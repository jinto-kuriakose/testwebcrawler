package com.qantas.test.webcrawler.controller;

import com.qantas.test.webcrawler.response.Links;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleHTMLController {

    @RequestMapping(value = "/testhtml", method = RequestMethod.GET)
    String testhtml() {
        StringBuilder testHTML = new StringBuilder();

        testHTML.append("<html>");
        testHTML.append("<body>");

        testHTML.append("<a href=\"http://localhost:8080/testhtml/2\"></a>");
        testHTML.append("<a href=\"http://localhost:8080/testhtml/1\"></a>");
        testHTML.append("<a href=\"http://localhost:8080/testhtml/3\"></a>");

        testHTML.append("</body>");
        testHTML.append("</html>");
        return testHTML.toString();
    }

    @RequestMapping(value = "/testhtml/1", method = RequestMethod.GET)
    String testhtml1() {
        StringBuilder testHTML = new StringBuilder();
        return testHTML.toString();
    }

    @RequestMapping(value = "/testhtml/2", method = RequestMethod.GET)
    String testhtml2() {
        StringBuilder testHTML = new StringBuilder();
        return testHTML.toString();
    }

    @RequestMapping(value = "/testhtml/3", method = RequestMethod.GET)
    String testhtml3() {
        StringBuilder testHTML = new StringBuilder();

        testHTML.append("<html>");
        testHTML.append("<body>");

        testHTML.append("<a href=\"http://localhost:8080/testhtml/2\"></a>");
        testHTML.append("<a href=\"http://localhost:8080/testhtml\"></a>");
        testHTML.append("<a href=\"http://localhost:8080/testhtml/4\"></a>");

        testHTML.append("</body>");
        testHTML.append("</html>");
        return testHTML.toString();
    }

    @RequestMapping(value = "/testhtml/4", method = RequestMethod.GET)
    String testhtml4() {
        StringBuilder testHTML = new StringBuilder();
        return testHTML.toString();
    }
}