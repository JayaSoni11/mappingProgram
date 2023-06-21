package com.demo.mapping.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String about;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "laptopid")
	
//	@OneToMany//(targetEntity=InstructorDetail.class,cascade=CascadeType.ALL, mappedBy="laptopid")
//	@JoinColumn(name="laptopid")
//	private List<InstructorDetail> instructorDetail;
}
