package br.com.fiap.ecommerceapi.products.dto;

import java.math.BigDecimal;

import br.com.fiap.ecommerceapi.products.Products;

public record ProductsResponse (
    Long id,
    String name,
    String description,
    BigDecimal price,
    String image,
    String tag
) {

    public static ProductsResponse from(Products products) {
        return new ProductsResponse(
            products.getId(),
            products.getName(),
            products.getDescription(),
            products.getPrice(),
            products.getImage(),
            products.getTag()
        );
    }
    
}
