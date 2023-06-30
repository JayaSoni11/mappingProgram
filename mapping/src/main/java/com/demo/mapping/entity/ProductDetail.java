//package com.demo.mapping.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class ProductDetail {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int pid;
//	private String owner;
//	private String ownermail;
//	
//	// @OneToOne(mappedBy = "instructorDetail")
////	@ManyToOne//(fetch=FetchType.LAZY)
////	@JoinColumn(name="abc")
//	   // private Product instructor;
//}
