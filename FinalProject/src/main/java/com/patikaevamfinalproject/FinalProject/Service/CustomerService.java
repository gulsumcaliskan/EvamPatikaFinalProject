package com.patikaevamfinalproject.FinalProject.Service;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patikaevamfinalproject.FinalProject.Entity.Customer;
import com.patikaevamfinalproject.FinalProject.Repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// FIND ALL
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}
	
	//CREATE 
	public void create(Customer customer) {
		customerRepository.save(customer);
		System.out.println(customer.getName() + " with ID: " + customer.getId() + " is created successfully.");		
	}
		
	//DELETE
	public void delete(Long id) {
		customerRepository.deleteById(id);
		System.out.println("Customer with ID:" + id + " is deleted.");
	}
		
	// Method Find By Id
	public Customer findById(Long id) {
		return this.customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer Not Found"));
	}
	
	//UPDATE
	@Transactional
	public void update(String name, String surname, Long id) {
			
		Customer customerToUpdate = this.customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer Not Found"));
			
		if(Objects.nonNull(name) && name.length() > 0 && !customerToUpdate.getName().equals(name)) {
			customerToUpdate.setName(name);
			System.out.println("Customer with name: " + customerToUpdate.getName() + " is updated successfully.");
		}
		if(Objects.nonNull(surname) && surname.length() > 0 && !customerToUpdate.getSurname().equals(surname)) {
			customerToUpdate.setSurname(surname);		
		}
		System.out.println("Customer with ID: " + customerToUpdate.getId() + " is updated successfully.");
	}
	

}
