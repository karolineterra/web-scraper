package com.request;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Request {
    private String pageURL;

    public Request (String pageURL){
        this.pageURL = pageURL;
    }

    public Document fetchDocument() throws IOException {
        return Jsoup.connect(pageURL).get();
    }
 
}
