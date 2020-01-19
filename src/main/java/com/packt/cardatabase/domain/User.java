package com.packt.cardatabase.domain;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "testerschema")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String surname, identitynumber, color, registerNumber;
	private int year, price;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private Teacher teacher;

	public User() {}

	public User(String brand, String identitynumber, String color, String registerNumber, int year, int price, Teacher teacher) {
		super();
		this.surname = brand;
		this.identitynumber = identitynumber;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		this.teacher = teacher;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getIdentitynumber() {
		return identitynumber;
	}
	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
