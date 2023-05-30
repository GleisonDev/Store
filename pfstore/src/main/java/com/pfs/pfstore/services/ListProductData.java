package com.pfs.pfstore.services;

import java.math.BigDecimal;

import com.pfs.pfstore.models.Product;

public record ListProductData(Long id, String name, String brand, String section, BigDecimal price) {

    public ListProductData(Product product) {
        this(product.getId(), product.getName(), product.getBrand(), product.getSection(), product.getPrice());
    }
}
