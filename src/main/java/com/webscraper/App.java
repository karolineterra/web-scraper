package com.webscraper;

import org.jsoup.nodes.Document;

import com.webscraper.request.Request;
import com.webscraper.scraping.Scraping;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a URL do site que deseja coletar as informações: ");
        String pageURL = scanner.nextLine();

        try {
            Request request = new Request(pageURL);
            Document document;
            document = request.fetchDocument();
            Scraping scraping = new Scraping(document);
            scraping.runScraping();

        } catch (IOException e) {
            System.out.println("Erro ao realizar a requisição.");
        }
        scanner.close();
    }
}
