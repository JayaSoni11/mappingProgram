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
import org.springframework.web.bind.annotation.RestController;

import com.demo.mapping.entity.APIResponse;
import com.demo.mapping.entity.Instructor;
import com.demo.mapping.repo.InstructorRepo;
import com.demo.mapping.scheduler.Test;
import com.demo.mapping.service.Service;


@RestController
public class InstructorController {
	@Autowired
	private Test test;
	
	@Autowired
	private Service service;

	@Autowired
	private InstructorRepo instructorRepo;

	@PostMapping("/save")
	public ResponseEntity<String> saveInstructor(@RequestBody List<Instructor> idata) {
		instructorRepo.saveAll(idata);
		
		return ResponseEntity.ok("data saved");
	}
	
	@GetMapping("/get")
	public List<Instructor> getAll() {
		List<Instructor> list=new ArrayList<>();
		list=instructorRepo.findAll();
		test.hello();
		return list;
		
	}
	
	@GetMapping("/getall")
	private APIResponse<List<Instructor>> getinstrucor(){
		List<Instructor> allIns=instructorRepo.findAll();
		return new APIResponse<>(allIns.size(), allIns);
	}
	@GetMapping("/field/{field}")
	private APIResponse<List<Instructor>> getInstructorWithSort(@PathVariable String field){
		List<Instructor> allIns=service.findInstructorWithSorting(field);
		return new APIResponse<>(allIns.size(), allIns);
	}
	
	@GetMapping("/pagination/{offset}/{pagesize}")
	private APIResponse<Page<Instructor>> getInstructorWithPagination(@PathVariable int offset,@PathVariable int pagesize){
		Page<Instructor> withpagination=service.findInstructorWithPagination(offset, pagesize);
		return new APIResponse<>(withpagination.getSize(), withpagination);
	}
	
	@GetMapping("/paginationAndSort/{offset}/{pagesize}/{field}")
	private APIResponse<Page<Instructor>> getInstructorWithSortAndPagination(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		Page<Instructor> withpagination=service.findInstructorWithPaginationAndSorting(offset, pagesize,field);
		return new APIResponse<>(withpagination.getSize(), withpagination);
	}


}

