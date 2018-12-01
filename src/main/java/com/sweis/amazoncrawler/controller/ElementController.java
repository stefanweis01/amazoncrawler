package com.sweis.amazoncrawler.controller;

import com.sweis.amazoncrawler.crawler.WebCrawler;
import com.sweis.amazoncrawler.dto.ElementText;
import com.sweis.amazoncrawler.model.Product;
import com.sweis.amazoncrawler.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Optional;

@RestController
public class ElementController {

    @Resource
    private WebCrawler webCrawler;

    @Resource
    private ProductRepository productRepository;

    @RequestMapping(value = "/element", method = RequestMethod.GET)
    public ElementText getElement(@RequestParam(value = "url") String url, @RequestParam(value = "elementName") String elementName) {
        return new ElementText(webCrawler.getElementTextFromDom(url, elementName));
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public Product getPrice(@RequestParam(value = "name") String name) {
        //return new Price(priceService.getPriceForProductName(name));
        Optional<Product> product = productRepository.findById(name);
        return new Product("123", "Super geil");
        //return product.orElse(null);
    }
}
