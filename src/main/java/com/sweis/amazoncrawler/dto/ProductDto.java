package com.sweis.amazoncrawler.dto;

public class ProductDto {

    private String id;
    private String name;
    private String link;

    public ProductDto() {

    }

    public ProductDto(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public ProductDto(final String id, final String name, final String link) {
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }
}

