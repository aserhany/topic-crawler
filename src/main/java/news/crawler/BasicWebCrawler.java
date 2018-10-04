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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public BasicWebCrawler() {
        connection = DatabaseManager.getConnection();
        links = new HashSet<String>();
    }

    public void getPageLinks(String URL) {
        try {
            PreparedStatement insertHTML = this.connection.prepareStatement(
                    SqlQueryManager.getInstance().loadQuery("insert_html"));

            if (!links.contains(URL)) {
                links.add(URL);
                System.out.println("New archive url: " + URL);
                Document document = Jsoup.connect(URL).timeout(0).get();

                Elements linksOnPage = document.select("a[href]");

                for (Element page : linksOnPage) {

                    Pattern p1 = Pattern.compile("http://www.spiegel.de/thema/brexit/archiv.*");
                    Matcher m1 = p1.matcher(page.attr("abs:href"));
                    Pattern p2 = Pattern.compile("http://www.spiegel.de.*");
                    Matcher m2 = p2.matcher(page.attr("abs:href"));
                    if(m1.find()){
                        System.out.println("    new archive to be processed: " + page.attr("abs:href"));
                        getPageLinks(page.attr("abs:href"));
                    } else if (m2.find() && !links.contains(page.attr("abs:href"))){
                        System.out.println("    new url: " + page.attr("abs:href"));
                        links.add(page.attr("abs:href"));
                        String articleUrl = page.attr("abs:href");
                        Document article = Jsoup.connect(articleUrl).timeout(0).get();

                        insertHTML.setObject(1, VariousUtils.generateUUIDv1());
                        insertHTML.setString(2, articleUrl);
                        insertHTML.setObject(3, LocalDateTime.now());
                        insertHTML.setBytes(4, GZIPUtils.compressString(article.html()));
                        insertHTML.setInt(5, 2);
                        insertHTML.execute();
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
