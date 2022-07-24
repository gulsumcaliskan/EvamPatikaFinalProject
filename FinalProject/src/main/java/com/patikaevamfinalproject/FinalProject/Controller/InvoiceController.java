package com.patikaevamfinalproject.FinalProject.Controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.patikaevamfinalproject.FinalProject.Entity.Invoice;
import com.patikaevamfinalproject.FinalProject.Service.CustomerService;
import com.patikaevamfinalproject.FinalProject.Service.InvoiceService;

@RestController
@RequestMapping("/api")
@RequestScope
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private CustomerService customerService;
	
	// GET all invoices
	@GetMapping("/customers/{customerId}/invoices")
	public ResponseEntity<?> getAllDeptsByCustomerIdService(@PathVariable (value = "customerId") Long customerId){
		return invoiceService.getAllDeptsByCustomerIdService(customerId);	
	}
	
	// GET
	@GetMapping("/customers/{customerId}/invoices/{id}")
	public ResponseEntity<?> getAllInvoicesByCustomerIdAndInvoiceIdService(@PathVariable (value = "customerId") Long customerId, @PathVariable (value = "id") Long id){
		return invoiceService.getAllInvoicesByCustomerIdAndInvoiceIdService(customerId, id);
	}
	
	// POST
	@PostMapping("/customers/{customerId}/invoices")
	public ResponseEntity<Invoice> createInvoiceService(@PathVariable (value = "customerId") Long customerId, @RequestBody Invoice invoiceRequest){
		/*
		Invoice invoice = customerRepository.findById(customerId).map(customer -> { 
			invoiceRequest.setCustomer(customer); 
			return invoiceRepository.save(invoiceRequest);
		}).orElseThrow(() -> new EntityNotFoundException("Not found Customer with id = " + customerId));
		*/
		return invoiceService.createInvoiceService(customerId, invoiceRequest);
//		return new ResponseEntity<>(invoiceService.createInvoiceService(customerId, invoiceRequest), HttpStatus.CREATED);	
	}
	
	// DELETE
	@DeleteMapping("/invoices/{id}")
	public ResponseEntity<HttpStatus> deleteInvoiceService(@PathVariable (value = "id") long id){
		return invoiceService.deleteInvoiceService(id);
	}
	
	// UPDATE
	@PutMapping("/invoices/{id}")
	public ResponseEntity<Invoice> updateInvoiceService(@PathVariable("id") long id, @RequestBody Invoice invoiceRequest){
		return invoiceService.updateInvoiceService(id, invoiceRequest);
	}

}
