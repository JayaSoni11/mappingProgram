package com.demo.mapping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mapping.dto.APIResponse;
import com.demo.mapping.entity.Product;
import com.demo.mapping.repo.ProductRepo;
import com.demo.mapping.scheduler.Test;
import com.demo.mapping.service.Service;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private Test test;

	@Autowired
	private Service service;

	@Autowired
	private ProductRepo productRepo;

	@PostMapping("/save")
	public ResponseEntity<String> saveInstructor(@RequestBody List<Product> idata) {
		productRepo.saveAll(idata);

		return ResponseEntity.ok("data saved");
	}

	@GetMapping("/get")
	public List<Product> getAll() {
		List<Product> list = new ArrayList<>();
		list = productRepo.findAll();
		test.hello();
		return list;

	}

	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = service.findProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
		return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}

	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<Product> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}

}
