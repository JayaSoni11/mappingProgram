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

import com.demo.mapping.entity.Instructor;
import com.demo.mapping.repo.InstructorRepo;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private InstructorRepo repo;

//	@PostConstruct
//	public void init() {
//		List<Instructor> ins = IntStream.range(1, 200).mapToObj(i -> new Instructor(new Random().nextInt(100),"Well","Jaya"+i,null)).collect(Collectors.toList());
//		repo.saveAll(ins);
//	}

	public List<Instructor> findAlInstructors() {
		return repo.findAll();
	}
	 
	public List<Instructor> findInstructorWithSorting(String field){
		return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public Page<Instructor> findInstructorWithPagination(int offset, int pageSize){
		Page<Instructor> ins=repo.findAll(PageRequest.of(offset, pageSize));
		return ins;
	}
	public Page<Instructor> findInstructorWithPaginationAndSorting(int offset, int pageSize, String field){
		Page<Instructor> ins=repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return ins;
	}
}
