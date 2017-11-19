package com.qantas.test.webcrawler.controller;

import com.qantas.test.webcrawler.response.Links;
import com.qantas.test.webcrawler.service.WebCrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebCrawlerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerController.class);

    @Autowired
    WebCrawlerService webCrawlerService;

    /**
     * This api will return a tree of child pages linked to the URL.
     * @param url
     * @return tree of child pages with links
     */
    @RequestMapping(value = "/webcrawler", method = RequestMethod.GET)
    private Links getLinks(@RequestParam("url") String url){

        //TODO Accepts a transaction or unique id and attach that with logger so that requests can be tracked easily.
        LOGGER.info("New WebCrawler request received for url={}", url);
        try {
            Links links = webCrawlerService.getLinks(url);
            LOGGER.info("Returning Links for url={}, Links={}",url, links);
            return links;
        }catch (Exception ex){
            LOGGER.error("Error occurred for request with url="+url,ex);

            //TODO Implement error response handlers
            throw ex;
        }
    }
}
