package com.sweis.amazoncrawler.service;

import com.sweis.amazoncrawler.constants.AmazonCrawlerConstants;
import com.sweis.amazoncrawler.crawler.WebCrawler;
import com.sweis.amazoncrawler.resolver.AmazonUrlResolver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Optional;

@Service
public class PriceService {

    @Resource
    private WebCrawler webCrawler;

    public Optional<Double> crawlPriceForAsin(final String asin) {
        final String priceElement = webCrawler.getElementTextFromDom(AmazonUrlResolver.buildAmazonUrlFromAsin(asin), AmazonCrawlerConstants.PRICE_ELEMENT);

        if (priceElement != null) {
            return Optional.of(Double.valueOf(priceElement.replaceAll("[^\\d.,]","")));
        }

        return Optional.empty();
    }
}
