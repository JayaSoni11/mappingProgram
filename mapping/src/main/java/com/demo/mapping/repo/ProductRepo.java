package com.demo.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mapping.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
