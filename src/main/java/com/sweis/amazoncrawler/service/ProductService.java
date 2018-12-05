package com.sweis.amazoncrawler.service;

import com.sweis.amazoncrawler.dto.ProductDto;
import com.sweis.amazoncrawler.model.Product;
import com.sweis.amazoncrawler.repository.ProductRepository;
import com.sweis.amazoncrawler.resolver.AmazonUrlResolver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Optional;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public void saveProduct(final ProductDto productDto) {
        productRepository.save(transformProductDto(productDto));
    }

    private Product transformProductDto(final ProductDto productDto) {
        final Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());

        product.setLink(AmazonUrlResolver.getAsinFromUrl(productDto.getLink())
                .orElseThrow(() -> new IllegalArgumentException("Invalid url " + productDto.getLink())));

        return product;
    }
}
