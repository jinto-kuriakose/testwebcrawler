package com.qantas.test.webcrawler.crawler;

import com.qantas.test.webcrawler.response.Links;
import com.qantas.test.webcrawler.service.WebCrawlerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WebCrawler {

    private static final int MAX_PAGES_TO_SEARCH = 50;
    private Set<String> linksVisited = new HashSet<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerService.class);
    private int currentPageCount = 0;

    /**
     * This method currently performs a simple link search on each page recursively.
     * Not using any caching or thread pooling.
     *
     * @param url
     * @return
     */
    public Links getLinks(String url) {
        Links links = new Links();
        getPageLinks(url, links);
        if (currentPageCount > MAX_PAGES_TO_SEARCH) {
            LOGGER.info("Links Search stopped due to MAX_PAGES_TO_SEARCH restriction of {} pages reached.", MAX_PAGES_TO_SEARCH);
        }
        if (!links.getNodes().isEmpty()) {
            return links.getNodes().get(0);
        } else {
            return null;
        }
    }

    public void getPageLinks(String url, Links parentLinks) {

        if (!linksVisited.contains(getBaseUrl(url)) && currentPageCount <= MAX_PAGES_TO_SEARCH) {
            try {
                currentPageCount++;
                linksVisited.add(getBaseUrl(url));
                LOGGER.info("Crawling URL={}", url);
                Document document = Jsoup.connect(url).get();

                Links links = new Links();
                links.setUrl(url);
                links.setTitle(document.title());
                parentLinks.getNodes().add(links);
                parentLinks = links;

                Elements linksOnPage = document.select("a[href]");
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), parentLinks);
                }
            } catch (Exception e) {
                LOGGER.error("Failed to process link {} : {}", url, e.getMessage());
            }
        }
    }

    private String getBaseUrl(String url) {
        if (!StringUtils.isEmpty(url)) {
            if (url.indexOf("?") > 1) {
                return url.substring(0, url.indexOf("?"));
            } else if (url.indexOf("#") > 1) {
                return url.substring(0, url.indexOf("#"));
            }
        }
        return url;
    }
}
