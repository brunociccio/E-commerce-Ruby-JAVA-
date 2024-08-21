package br.com.fiap.ecommerceapi.products.dto;

import java.math.BigDecimal;

import br.com.fiap.ecommerceapi.products.Products;

public record ProductsRequest(
    String name,
    String description,
    BigDecimal price,
    String image,
    String tag
) {
    public Products toModel() {
        return Products.builder()
            .name(name)
            .description(description)
            .price(price)
            .image(image)
            .tag(tag)
            .build();
    }
    
}
