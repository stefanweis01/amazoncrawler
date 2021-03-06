package com.sweis.amazoncrawler.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String link;
    @OneToMany(mappedBy = "product")
    private List<Price> prices;

    public Product() {

    }

    public Product(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Product(final String id, final String name, final String link) {
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
