package com.fouadev.springbootcassandra.repositories;

import com.fouadev.springbootcassandra.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
