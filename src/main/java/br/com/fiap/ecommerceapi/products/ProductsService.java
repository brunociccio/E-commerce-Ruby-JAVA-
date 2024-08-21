package br.com.fiap.ecommerceapi.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository repository;

    public List<Products> findAll(){
        return repository.findAll();
    }

    public Products create(Products products){
        return repository.save(products);
    }
    
}
