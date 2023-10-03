package com.webscrapper.scrapping;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scrapping {
    private Document pagePath;

    public Scrapping(Document pagePath) {
        this.pagePath = pagePath;
    }

    public void runScrapping() {
        scrapeTitle();
        scrapeImage();
        scrapePrice();
        scrapeDescription();
    }

    private void scrapeTitle() {
        Elements title = pagePath.select("[data-productname]");
        String textTitle = title.text();
        System.out.println("---- NOME DO PRODUTO ----");
        System.out.println(textTitle);;
    }
    private void scrapePrice() {
        Elements price = pagePath.select(".default-price span strong");
        String textPrice = price.text();
        System.out.println("----- PREÇO DO PRODUTO ----");
        System.out.println(textPrice);
    }
    private void scrapeImage(){
        Elements imagePath = pagePath.select(".photo-figure .zoom");
        String imgSrc = imagePath.attr("src");
        System.out.println("---- LINK DA IMAGEM DO PRODUTO ----");
        System.out.println(imgSrc);
    }

    private void scrapeDescription() {
        Elements description = pagePath.select("#features p");
        String textDescription = description.text();
        System.out.println("---- DESCRIÇÃO DO PRODUTO ----");
        System.out.println(textDescription);
    }
    
}
