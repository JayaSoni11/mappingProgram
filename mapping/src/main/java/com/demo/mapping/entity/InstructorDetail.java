package com.demo.mapping.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int laptopid;
	private String modelnumber;
	private String brand;
	
	// @OneToOne(mappedBy = "instructorDetail")
//	@ManyToOne//(fetch=FetchType.LAZY)
//	@JoinColumn(name="abc")
	   // private Instructor instructor;
}
