package com.sweis.amazoncrawler.repository;

import java.util.List;
import java.util.Optional;

import com.sweis.amazoncrawler.dto.ElementText;
import com.sweis.amazoncrawler.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}