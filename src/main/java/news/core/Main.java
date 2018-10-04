package news.core;

import news.crawler.BasicWebCrawler;

import java.util.Iterator;

public class Main {

    private static Configuration conf;

    public static Configuration getConfiguration() {
        return conf;
    }

    public static void main(String[] args) throws Exception {

        conf = new Configuration();

        BasicWebCrawler basicWebCrawler = new BasicWebCrawler();
        basicWebCrawler.getPageLinks("http://www.spiegel.de/thema/brexit/archiv.html");

    }
}
