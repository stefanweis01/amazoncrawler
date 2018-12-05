package com.sweis.amazoncrawler.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "price")
public class Price {

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    private Double price;
    private Date priceAt;

    public Price() {

    }

    public Price(final Double price, final Date priceAt) {
        this.price = price;
        this.priceAt = priceAt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Date getPriceAt() {
        return priceAt;
    }

    public void setPriceAt(final Date priceAt) {
        this.priceAt = priceAt;
    }
}
