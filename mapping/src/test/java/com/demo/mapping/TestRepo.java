package com.demo.mapping;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mapping.entity.Product;

public interface TestRepo extends JpaRepository<Product, Integer>{

}
