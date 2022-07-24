package com.patikaevamfinalproject.FinalProject.Entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	
	//Constructor
	public Customer() {
	}
	
	public Customer(Long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;	
	}
	
	//Getter and Setter
	public Long getId() {
		return id;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return id.equals(customer.id);		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + "," +
				"name=" + name + "," +
				"surname=" + surname + "]";
	}

}
