package com.sweis.amazoncrawler.resolver;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmazonUrlResolver {

    public static Optional<String> getAsinFromUrl(final String url) {
        Pattern asinPattern = Pattern.compile("\\/([a-zA-Z0-9]{10})(?:[\\/?]|$)");
        Matcher matcher = asinPattern.matcher(url);
        if (matcher.find() && matcher.group(1) != null && !matcher.group(1).equals("")) {
            return Optional.of(matcher.group(1));
        }
        return Optional.empty();
    }

    public static String buildAmazonUrlFromAsin(final String asin) {
        return "http://www.amazon.de/dp/" + asin;
    }
}
