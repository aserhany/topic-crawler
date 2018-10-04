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

        BasicWebCrawler boerseCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/boerse/archiv.*"
                , "http://www.spiegel.de.*",3);
        boerseCrawler.getPageLinks("http://www.spiegel.de/thema/boerse/archiv.html");

        System.out.println("################# Done with Boere ######################");

        BasicWebCrawler bundeswehrCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/bundeswehr/archiv.*"
                , "http://www.spiegel.de.*",4);
        bundeswehrCrawler.getPageLinks("http://www.spiegel.de/thema/bundeswehr/archiv.html");

        System.out.println("################# Done with Bundeswehr ######################");

        BasicWebCrawler chemnitzCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/chemnitz/dossierarchiv.*"
                , "http://www.spiegel.de.*",5);
        chemnitzCrawler.getPageLinks("http://www.spiegel.de/thema/chemnitz/dossierarchiv-2.html");

        System.out.println("################# Done with Chemnitz ######################");

        BasicWebCrawler erneubareEnergieCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/erneuerbare_energien/archiv.*"
                , "http://www.spiegel.de.*",6);
        erneubareEnergieCrawler.getPageLinks("http://www.spiegel.de/thema/erneuerbare_energien/archiv.html");

        System.out.println("################# Done with ErneubareEnergie ######################");

        BasicWebCrawler griechenlandCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/griechenland/dossierarchiv.*"
                , "http://www.spiegel.de.*",7);
        griechenlandCrawler.getPageLinks("http://www.spiegel.de/thema/griechenland/dossierarchiv-2.html");

        System.out.println("################# Done with Griechendland ######################");

        BasicWebCrawler islamCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/islam/dossierarchiv.*"
                , "http://www.spiegel.de.*",8);
        islamCrawler.getPageLinks("http://www.spiegel.de/thema/islam/dossierarchiv-2.html");

        System.out.println("################# Done with Islam ######################");


        BasicWebCrawler polizeiCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/polizei/dossierarchiv.*"
                , "http://www.spiegel.de.*",9);
        polizeiCrawler.getPageLinks("http://www.spiegel.de/thema/polizei/dossierarchiv-2.html");

        System.out.println("################# Done with Polizei ######################");

        BasicWebCrawler relegionCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/religion/dossierarchiv.*"
                , "http://www.spiegel.de.*",10);
        relegionCrawler.getPageLinks("http://www.spiegel.de/thema/religion/dossierarchiv-2.html");

        System.out.println("################# Done with Relegion ######################");

        BasicWebCrawler russlandCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/russland/dossierarchiv.*"
                , "http://www.spiegel.de.*",11);
        russlandCrawler.getPageLinks("http://www.spiegel.de/thema/russland/dossierarchiv-2.html");

        System.out.println("################# Done with Russland ######################");

        BasicWebCrawler steuernCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/steuern/dossierarchiv.*"
                , "http://www.spiegel.de.*",12);
        steuernCrawler.getPageLinks("http://www.spiegel.de/thema/steuern/dossierarchiv-2.html");

        System.out.println("################# Done with Steuern ######################");

        BasicWebCrawler syrienCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/syrien/dossierarchiv.*"
                , "http://www.spiegel.de.*",13);
        syrienCrawler.getPageLinks("http://www.spiegel.de/thema/syrien/dossierarchiv-2.html");

        System.out.println("################# Done with Syrien ######################");

        BasicWebCrawler ueberwachungCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/ueberwachung/archiv.*"
                , "http://www.spiegel.de.*",14);
        ueberwachungCrawler.getPageLinks("http://www.spiegel.de/thema/ueberwachung/archiv.html");

        System.out.println("################# Done with Ueberwachung ######################");

        BasicWebCrawler ukraineCrawler = new BasicWebCrawler("http://www.spiegel.de/thema/ukraine/dossierarchiv.*"
                , "http://www.spiegel.de.*",15);
        ukraineCrawler.getPageLinks("http://www.spiegel.de/thema/ukraine/dossierarchiv-2.html");

        System.out.println("################# Done with Ukraine ######################");





    }
}
