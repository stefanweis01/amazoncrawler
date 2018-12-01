package com.seis.amazoncrawler.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class WebCrawler {

    final Logger LOG = LoggerFactory.getLogger(WebCrawler.class);

    /**
     * Returns the text from the given url and element name if present
     * otherwise null.
     *
     * @param url the url
     * @param elementName the elment name
     * @return the text if present, otherwise null
     */
    public String getElementTextFromDom(final String url, final String elementName) {
        final Optional<Element> element = getElementFromDom(url, elementName);

        if (element.isPresent() && element.get().hasText()) {
            return element.get().text();
        }
        return null;
    }

    private Optional<Element> getElementFromDom(final String url, final String elementName) {
        final Optional<Document> document = getDomFromUrl(url);
        if (document.isPresent()) {
            final Element element = document.get().getElementById(elementName);
            if (element != null) {
                LOG.debug("Found element " + element);
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    private Optional<Document> getDomFromUrl(final String url) {
        if (url != null && !url.isEmpty()) {
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
                return Optional.ofNullable(document);
            } catch (final IOException e) {
                LOG.error("Couldn't connect to url " + url);
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
