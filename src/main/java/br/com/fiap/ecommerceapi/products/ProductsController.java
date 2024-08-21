package br.com.fiap.ecommerceapi.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.ecommerceapi.products.dto.ProductsRequest;
import br.com.fiap.ecommerceapi.products.dto.ProductsResponse;


@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    ProductsService service;

    @GetMapping
    public List<Products> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<ProductsResponse> create(@RequestBody ProductsRequest userRequest, UriComponentsBuilder uriBuilder){
        var user = service.create(userRequest.toModel());

        var uri = uriBuilder
                    .path("/users/{id}")
                    .buildAndExpand(user.getId())
                    .toUri();

        return ResponseEntity
                .created(uri)
                .body(ProductsResponse.from(user));
    }
}
