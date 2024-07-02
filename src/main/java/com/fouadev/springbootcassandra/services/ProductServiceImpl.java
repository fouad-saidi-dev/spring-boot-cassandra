package com.fouadev.springbootcassandra.services;


import com.fouadev.springbootcassandra.entities.Product;
import com.fouadev.springbootcassandra.repositories.ProductRepository;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
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
                .quantity(product.getQuantity())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        logger.info("Updating product: {}", product.getId());
        Product product1 = productRepository.findById(product.getId()).orElse(null);
        if (product1 == null) throw new RuntimeException("Product not found");
        product1 = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        Product updatedProduct = productRepository.save(product1);
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