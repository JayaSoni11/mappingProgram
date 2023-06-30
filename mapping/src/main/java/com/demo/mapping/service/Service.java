package com.demo.mapping.service;

import java.util.List;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import com.demo.mapping.entity.Product;
import com.demo.mapping.repo.ProductRepo;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private ProductRepo repo;

	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1, 200)
				.mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(500000)))
				.collect(Collectors.toList());
		repo.saveAll(products);
	}

	public List<Product> findAllProducts() {
		return repo.findAll();
	}

	public List<Product> findProductsWithSorting(String field){
        return  repo.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Product> findProductsWithPagination(int offset,int pageSize){
        Page<Product> products = repo.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Product> products = repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
    }

}