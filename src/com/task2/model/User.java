package com.task2.model;

import java.util.Date;

public class User {
	
	private int id;
	private String name;
	private String password;
	private int age;
	private String gender;
	private String country;
	private Date dateofbirth;
	private Double salary;
	private String address;
	private String description;
	private String typeofrequest;
	
	public User(int id, String name, String password, int age, String gender, String country, Date dateofbirth,
			Double salary, String address, String description, String typeofrequest) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.dateofbirth = dateofbirth;
		this.salary = salary;
		this.address = address;
		this.description = description;
		this.typeofrequest = typeofrequest;
	}

	public User() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeofrequest() {
		return typeofrequest;
	}

	public void setTypeofrequest(String typeofrequest) {
		this.typeofrequest = typeofrequest;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", gender=" + gender
				+ ", country=" + country + ", dateofbirth=" + dateofbirth + ", salary=" + salary + ", address="
				+ address + ", description=" + description + ", typeofrequest=" + typeofrequest + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPassword()=" + getPassword() + ", getAge()=" + getAge()
				+ ", getGender()=" + getGender() + ", getCountry()=" + getCountry() + ", getDateofbirth()="
				+ getDateofbirth() + ", getSalary()=" + getSalary() + ", getAddress()=" + getAddress()
				+ ", getDescription()=" + getDescription() + ", getTypeofrequest()=" + getTypeofrequest()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	
	

}
