package news.crawler;

import news.core.DatabaseManager;
import news.core.SqlQueryManager;
import news.utils.ByteArrayToStringConverter;
import news.utils.GZIPUtils;
import news.utils.VariousUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicWebCrawler {

    public HashSet<String> links;
    private Connection connection;
    private String sharedPartTopicUrlPattern;
    private String baseUrlPattern;
    private int topicId;
    private int sourceId;

    public BasicWebCrawler(String sharedPartTopicUrlPattern, String baseUrlPattern, int topicId, int sourceId) {
        connection = DatabaseManager.getConnection();
        links = new HashSet<String>();
        this.sharedPartTopicUrlPattern = sharedPartTopicUrlPattern;
        this.baseUrlPattern = baseUrlPattern;
        this.topicId = topicId;
        this.sourceId = sourceId;
    }

    public void getPageLinks(String URL) {
        try {
            PreparedStatement insertArticle = this.connection.prepareStatement(
                    SqlQueryManager.getInstance().loadQuery("insert_article"), Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertTopicArticle = this.connection.prepareStatement(
                    SqlQueryManager.getInstance().loadQuery("insert_topic_article"));

            if (!links.contains(URL)) {
                links.add(URL);
                // System.out.println("New url: " + URL);
                Document document = Jsoup.connect(URL).timeout(0).get();

                Elements linksOnPage = document.select("a[href]");

                for (Element page : linksOnPage) {

                    Pattern p1 = Pattern.compile(sharedPartTopicUrlPattern);
                    Matcher m1 = p1.matcher(page.attr("abs:href"));
                    Pattern p2 = Pattern.compile(baseUrlPattern);
                    Matcher m2 = p2.matcher(page.attr("abs:href"));
                    if(m1.find()){
                        // System.out.println("    new archive to be processed: " + page.attr("abs:href"));
                        getPageLinks(page.attr("abs:href"));
                    } else if (m2.find() && !links.contains(page.attr("abs:href"))){
                        //System.out.println("    new url: " + page.attr("abs:href"));
                        links.add(page.attr("abs:href"));
                        String articleUrl = page.attr("abs:href");
                        Document article = Jsoup.connect(articleUrl).timeout(0).get();

                        insertArticle.setString(1, articleUrl);
                        insertArticle.setString(2, article.html());
                        insertArticle.setObject(3, sourceId);
                        int rowAffected = insertArticle.executeUpdate();
                        if (rowAffected == 1){
                            ResultSet rs = insertArticle.getGeneratedKeys();
                            if(rs.next()){
                                insertTopicArticle.setInt(1, topicId);
                                insertTopicArticle.setInt(2, rs.getInt(1));
                                insertTopicArticle.execute();
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
                e.printStackTrace();
        }
    }
}
