package com.sweis.amazoncrawler.controller;

import com.sweis.amazoncrawler.dto.ProductDto;
import com.sweis.amazoncrawler.model.Product;
import com.sweis.amazoncrawler.repository.ProductRepository;
import com.sweis.amazoncrawler.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Optional;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private ProductRepository productRepository;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
        try {
            productService.saveProduct(productDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (final Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public Product getProduct(@RequestParam(value = "id") String id) {
        final Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
