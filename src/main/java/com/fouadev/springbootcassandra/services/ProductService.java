package com.fouadev.springbootcassandra.services;

import com.fouadev.springbootcassandra.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product saveProduct(Product product);

    Product findProductById(UUID id);

    Product updateProduct(Product product);
    void deleteProductById(UUID id);

    List<Product> findProducts();

}
