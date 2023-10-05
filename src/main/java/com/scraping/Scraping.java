package com.scraping;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scraping {
    private Document pagePath;

    public Scraping(Document pagePath) {
        this.pagePath = pagePath;
    }

    public void runScraping() {
        scrapeTitle();
        scrapeImage();
        scrapePrice();
        scrapeDescription();
    }

    private void scrapeTitle() {
        Elements title = pagePath.select("[data-productname]");
        String textTitle = title.text();
        if (textTitle.isEmpty()) {
            System.out.println("O nome do produto não foi encontrado");
        } else {
            System.out.println("---- NOME DO PRODUTO ----");
            System.out.println(textTitle);
            new WriteFile(textTitle).startWriting();
        }

    }

    private void scrapePrice() {
        Elements price = pagePath.select(".default-price span strong");
        String textPrice = price.text();
        if (textPrice.isEmpty()) {
            System.out.println("O preço do produto não foi encontrado");
        } else {
            System.out.println("----- PREÇO DO PRODUTO ----");
            System.out.println(textPrice);
            new WriteFile(textPrice).startWriting();
        }

    }

    private void scrapeImage() {
        Elements imagePath = pagePath.select(".photo-figure .zoom");
        String imgSrc = imagePath.attr("src");

        if (imgSrc.isEmpty()) {
            System.out.println("A imagem do produto não foi encontrada");
        } else {
            System.out.println("---- LINK DA IMAGEM DO PRODUTO ----");
            System.out.println(imgSrc);
            new WriteFile(imgSrc).startWriting();
        }
    }

    private void scrapeDescription() {
        Elements description = pagePath.select("#features p");
        String textDescription = description.text();
        if (textDescription.isEmpty()) {
            System.out.println("A descrição do produto não foi encontrada");
        } else {
            System.out.println("---- DESCRIÇÃO DO PRODUTO ----");
            System.out.println(textDescription);
            new WriteFile(textDescription).startWriting();
        }
    }

}
