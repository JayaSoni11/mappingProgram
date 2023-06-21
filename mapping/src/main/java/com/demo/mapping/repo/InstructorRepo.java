package com.demo.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mapping.entity.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer>{

}
