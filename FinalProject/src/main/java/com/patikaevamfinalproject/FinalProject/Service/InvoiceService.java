package com.patikaevamfinalproject.FinalProject.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patikaevamfinalproject.FinalProject.Entity.Invoice;
import com.patikaevamfinalproject.FinalProject.Repo.CustomerRepository;
import com.patikaevamfinalproject.FinalProject.Repo.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	// Get all invoice
	public ResponseEntity<?> getAllDeptsByCustomerIdService(Long customerId){
		return new ResponseEntity<>(invoiceRepository.findByCustomerId(customerId), HttpStatus.OK);
	}
	
	// GET All ByCustomerIdAndInvoiceId
	public ResponseEntity<?> getAllInvoicesByCustomerIdAndInvoiceIdService(Long customerId, Long id){
		if(!customerRepository.existsById(customerId)) {
			throw new EntityNotFoundException("Not Found Customer with id: " + customerId);
		}
		invoiceRepository.findByCustomerId(customerId);
		if(!invoiceRepository.existsById(id)) {
			throw new EntityNotFoundException("Not Found Invoice with id: " + id);
		}
		
		Optional<Invoice> invoiceOpt = invoiceRepository.findById(id);
		Invoice invoice = invoiceOpt.get();
		if(invoice.getStatus() == 1) {
			return ResponseEntity.status(HttpStatus.OK).body("There is no dept");
		}
		return new ResponseEntity<>(invoice, HttpStatus.OK);	
	}
	
	// CREATE
	public ResponseEntity<Invoice> createInvoiceService(Long customerId, Invoice invoiceRequest){
		Invoice invoice = customerRepository.findById(customerId).map(customer -> { 
//		customerRepository.findById(customerId).map(customer -> {
			invoiceRequest.setCustomer(customer); 
			return invoiceRepository.save(invoiceRequest);
		}).orElseThrow(() -> new EntityNotFoundException("Not found Customer with id = " + customerId));
		return new ResponseEntity<>(invoice, HttpStatus.CREATED);
//		return createInvoiceService(customerId, invoiceRequest);
	}	
	
	// DELETE
	public ResponseEntity<HttpStatus> deleteInvoiceService(Long id){
		invoiceRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// UPDATE
	public ResponseEntity<Invoice> updateInvoiceService(long id, Invoice invoiceRequest){
		Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("InvoiceId " + id + "not found!!"));
		invoice.setDept(invoiceRequest.getDept());
		invoice.setUpdatedAt(invoiceRequest.getUpdatedAt().now());
//		invoice.setDate(invoiceRequest.getDate());
		invoice.setStatus(invoiceRequest.getStatus());
		return new ResponseEntity<>(invoiceRepository.save(invoice), HttpStatus.OK);
	}

}
