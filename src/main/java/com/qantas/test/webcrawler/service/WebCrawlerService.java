package com.qantas.test.webcrawler.service;

import com.qantas.test.webcrawler.crawler.WebCrawler;
import com.qantas.test.webcrawler.response.Links;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebCrawlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerService.class);

    /**
     *
     * @param url
     * @return
     */
    public Links getLinks(String url) {
        WebCrawler webCrawler = new WebCrawler();
        return webCrawler.getLinks(url);
    }
}
