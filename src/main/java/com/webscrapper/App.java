package com.webscrapper;

import org.jsoup.nodes.Document;

import com.webscrapper.request.Request;
import com.webscrapper.scrapping.Scrapping;

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
            Scrapping scrapping = new Scrapping(document);
            scrapping.runScrapping();

        } catch (IOException e) {
            e.printStackTrace();
        }

       

        scanner.close();
    }
}
