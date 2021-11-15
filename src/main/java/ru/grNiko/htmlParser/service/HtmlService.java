package ru.grNiko.htmlParser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HtmlService {

    public static Document getDocumentByUrl(String url) throws IOException {

        Document document = Jsoup.connect(url)
                .userAgent("Opera")
                .timeout(5000)
                .referrer("https://www.google.com/")
                .get();

        return document;
    }
}
