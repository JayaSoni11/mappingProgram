package com.demo.mapping;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mapping.entity.Instructor;

public interface TestRepo extends JpaRepository<Instructor, Integer>{

}
