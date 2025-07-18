package com.abhi.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
public class Person {
	@Id
	private String id;
	private String name;
	private int age;

	// Constructors
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}