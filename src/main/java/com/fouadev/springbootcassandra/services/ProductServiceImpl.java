package com.fouadev.springbootcassandra.services;


import com.fouadev.springbootcassandra.entities.Product;
import com.fouadev.springbootcassandra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        product = Product.builder()
                .id(UUID.randomUUID())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1 = productRepository.findById(product.getId()).orElse(null);
        if (product1 == null) throw new RuntimeException("Product not found");
        product = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    }
}