package com.seis.amazoncrawler.controller;

import com.seis.amazoncrawler.crawler.WebCrawler;
import com.seis.amazoncrawler.dto.ElementText;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ElementController {

    @Resource
    private WebCrawler webCrawler;

    @RequestMapping("/element")
    public ElementText greeting(@RequestParam(value = "url") String url, @RequestParam(value = "elementName") String elementName) {
        return new ElementText(webCrawler.getElementTextFromDom(url, elementName));
    }
}
