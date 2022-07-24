package com.patikaevamfinalproject.FinalProject.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patikaevamfinalproject.FinalProject.Entity.Invoice;
import com.patikaevamfinalproject.FinalProject.Entity.Payment;
import com.patikaevamfinalproject.FinalProject.Repo.CustomerRepository;
import com.patikaevamfinalproject.FinalProject.Repo.InvoiceRepository;
import com.patikaevamfinalproject.FinalProject.Repo.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	// GET all depts
	public ResponseEntity<?> getAllDeptsByCustomerIdService(Long customerId, Long id){
		paymentRepository.findByCustomerId(customerId);
		invoiceRepository.findByCustomerId(customerId);
		Optional<Invoice> invoiceOpt = invoiceRepository.findById(id);
		Invoice invoice = invoiceOpt.get();
		if(!(invoice.getDept() == 1)) {
		}
//		return new ResponseEntity<>(invoiceRepository.findByCustomerId(customerId), HttpStatus.OK);
		return new ResponseEntity<>(invoice, HttpStatus.OK);

		/*
		 * 
		if(!customerRepository.existsById(customerId)) {
			throw new EntityNotFoundException("Not Found Customer with id: " + customerId);
		}
		paymentRepository.findByCustomerId(customerId);
//		invoiceRepository.findByCustId(customerId);
		Invoice invoice = invoiceRepository.findByCustId(customerId);
		
//		Invoice inv = invoice.get(invoice.size());
//		return new ResponseEntity<>(inv.getDept(), HttpStatus.OK);
		return new ResponseEntity<>(invoice.getDept(), HttpStatus.OK);
		*/
	}
	
	// GET
	public ResponseEntity<?> getPaymentsByCustomerId(Long customerId){
		return new ResponseEntity<>(paymentRepository.findById(customerId), HttpStatus.OK);	
	}
	
	// CREATE
	public ResponseEntity<Payment> createPaymentService(Long customerId, Long id, Payment paymentRequest){
		Payment payment = customerRepository.findById(customerId).map(customer -> {
			paymentRequest.setCustomer(customer);
			return paymentRepository.save(paymentRequest);
		}).orElseThrow(() -> new EntityNotFoundException("Not found Customer with id = " + customerId));
		
		invoiceRepository.findByCustomerId(customerId);
		if(!invoiceRepository.existsById(id)) {
			throw new EntityNotFoundException("Not Found Invoice with id: " + id);
		}
		Optional<Invoice> invoiceOpt = invoiceRepository.findById(id);
		Invoice invoice = invoiceOpt.get();
		if(!(invoice.getDept() == 1)) {
//			return new ResponseEntity<>(payment, HttpStatus.CREATED);
		}
//		return new ResponseEntity<>(payment, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(payment, HttpStatus.CREATED);
	}
	
	// DELETE
	public ResponseEntity<HttpStatus> deletePaymentService(Long id){
		paymentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// UPDATE
	public ResponseEntity<?> updatePaymentsService(Long customerId, Long id, Invoice invoiceRequest){
		if(!customerRepository.existsById(customerId)) {
			throw new EntityNotFoundException("Not Found Customer with id: " + customerId);
		}
//		Payment payment = paymentRepository.findByCustomerId(customerId);
		invoiceRepository.findByCustomerId(customerId);
		if(!invoiceRepository.existsById(id)) {
			throw new EntityNotFoundException("Not Found Invoice with id: " + id);
		}
		Optional<Invoice> invoiceOpt = invoiceRepository.findById(id);
		Invoice invoice = invoiceOpt.get();

		if(invoice.getDept() == 0 && invoice.getStatus() == 1) {
			return ResponseEntity.status(HttpStatus.OK).body("The dept is already paid");
		}
		/*
		if(invoice.getDept() == 0) {
			return ResponseEntity.status(HttpStatus.OK).body("The dept is already paid");
		}
		*/
		invoice.setDept(invoiceRequest.getDept());	
//		invoice.setDept(invoiceRequest.getDept());
//		payment.setDate(invoiceRequest.getDate().now());
		return new ResponseEntity<>(invoiceRepository.save(invoice), HttpStatus.OK);	
	}

}
