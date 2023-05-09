package com.training.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")

public class Employee {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;

	public Long getId() {
		return id;
	}

	public Employee(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	

}
