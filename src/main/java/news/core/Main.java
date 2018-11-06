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

        BasicWebCrawler c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/familie-kinder/.*"
                , "https://afdkompakt.de.*",1);
        c1.getPageLinks("https://afdkompakt.de/themen-2/familie-kinder/");
        System.out.println("################# Done with Famili + Kinder ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/islam-abendland/.*"
                , "https://afdkompakt.de.*",2);
        c1.getPageLinks("https://afdkompakt.de/themen-2/islam-abendland/");
        System.out.println("################# Done with ISLAM+ABENDLAND ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/schutz-sicherheit/.*"
                , "https://afdkompakt.de.*",3);
        c1.getPageLinks("https://afdkompakt.de/themen-2/schutz-sicherheit/");
        System.out.println("################# Done with SCHUTZ+SICHERHEIT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/gewalt-gegen-afd/.*"
                , "https://afdkompakt.de.*",4);
        c1.getPageLinks("https://afdkompakt.de/themen-2/gewalt-gegen-afd/");
        System.out.println("################# Done with GEWALT GEGEN AFD######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/heimat-identitaet/.*"
                , "https://afdkompakt.de.*",5);
        c1.getPageLinks("https://afdkompakt.de/themen-2/heimat-identitaet/");
        System.out.println("################# Done with HEIMT + IDENTITÄT D######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/freiheit-buerger/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/freiheit-buerger/");
        System.out.println("################# Done with FREIHEIT DER BÜRGER ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/medien-wahrheit/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/medien-wahrheit/");
        System.out.println("################# Done with MEDIEN WAHRHEIT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/europa-vielfalt/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/europa-vielfalt/");
        System.out.println("################# Done with EUROPA DER VIELFALT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/europa-vielfalt/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/europa-vielfalt/");
        System.out.println("################# Done with EUROPA DER VIELFALT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/europa-vielfalt/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/europa-vielfalt/");
        System.out.println("################# Done with EUROPA DER VIELFALT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/souveraen/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/souveraen/");
        System.out.println("################# Done with SOUVERÄNITÄT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/direkte-demokratie/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/direkte-demokratie/");
        System.out.println("################# Done with DIREKTE DEMOKRATIE ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/tradition-werte/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/tradition-werte/");
        System.out.println("################# Done with TRADITION UND WERTE ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/bildung-wissen/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/bildung-wissen/");
        System.out.println("################# Done with BILDUNG UND WISSEN ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/solidaritaet/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/solidaritaet/");
        System.out.println("################# Done with SOLIDARITÄT + SOZIALES ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/rente-demografie/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/rente-demografie/");
        System.out.println("################# Done with RENTE + DEMOGRAFIE ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/rechtsstaat/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/rechtsstaat/");
        System.out.println("################# Done with STAAT + RECHT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/geld-wirtschaft/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/geld-wirtschaft/");
        System.out.println("################# Done with GELD + WIRTSCHAFT ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/deutscher-mittelstand/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/deutscher-mittelstand/");
        System.out.println("################# Done with DEUTSCHER MITTELSTAND ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/energiewende/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/energiewende/");
        System.out.println("################# Done with ENERGIEWENDE ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/themen-2/deutschland-2030/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/themen-2/deutschland-2030/");
        System.out.println("################# Done with DEUTSCHLAND 2030 ######################");

        c1 = new BasicWebCrawler("https://afdkompakt.de/bundesverband/mittelstandsforum/.*"
                , "https://afdkompakt.de.*",6);
        c1.getPageLinks("https://afdkompakt.de/bundesverband/mittelstandsforum/");
        System.out.println("################# Done with MITTELSTANDFORUM ######################");
    }
}
