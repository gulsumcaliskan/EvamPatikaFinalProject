package com.patikaevamfinalproject.FinalProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.patikaevamfinalproject.FinalProject.Entity.Customer;
import com.patikaevamfinalproject.FinalProject.Service.CustomerService;

@RestController
@RequestMapping("/api")
@RequestScope
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return this.customerService.getCustomers();
	}
	
	@PostMapping("/customers")
	public ResponseEntity<?>create(@RequestBody Customer customer){
		this.customerService.create(customer);
		return ResponseEntity.ok("Customer with ID: " + customer.getId() + " is created successfully!");
	}
	
	@DeleteMapping("/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try{
            this.customerService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
	
	@GetMapping("/customers/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.customerService.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
       

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> update(@RequestParam(required = false) String name, @RequestParam(required = false) String surname,
                                    @PathVariable("id") Long id){
        try {
        	this.customerService.update(name, surname, id);            
            return ResponseEntity.ok("Customer with ID: " + id + " is updated successfully");
        }catch (Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
