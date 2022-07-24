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
import com.patikaevamfinalproject.FinalProject.Entity.Payment;
import com.patikaevamfinalproject.FinalProject.Service.CustomerService;
import com.patikaevamfinalproject.FinalProject.Service.InvoiceService;
import com.patikaevamfinalproject.FinalProject.Service.PaymentService;

@RestController
@RequestMapping("/api")
@RequestScope
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private CustomerService customerService;
	
	// GET
	@GetMapping("/customers/{customerId}/payments/{id}")
	public ResponseEntity<?> getAllDeptsByCustomerIdService(@PathVariable (value = "customerId") Long customerId, @PathVariable (value = "id") Long id){
		return paymentService.getAllDeptsByCustomerIdService(customerId, id);	
	}
	
	// 
	@GetMapping("/payments/{customerId}")
	public ResponseEntity<?> getPaymentsByCustomerId(@PathVariable (value = "customerId") Long customerId){
		return paymentService.getPaymentsByCustomerId(customerId);		
	}

	// CREATE
//	@PostMapping("/customers/{customerId}/payments/{id}")
	@PostMapping("/customers/{customerId}/payments/{id}")
	public ResponseEntity<Payment> createPaymentService(@PathVariable (value = "customerId") Long customerId, @PathVariable (value = "id") Long id, @RequestBody Payment paymentRequest){
		return paymentService.createPaymentService(customerId, id, paymentRequest);	
	}
	
	// DELETE
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<HttpStatus> deletePaymentService(@PathVariable (value = "id") long id){
		return paymentService.deletePaymentService(id);
	}
	
	// UPDATE
	@PutMapping("/customers/{customerId}/payments/{id}")
	public ResponseEntity<?> updatePaymentsService(@PathVariable (value = "customerId") Long customerId, @PathVariable (value = "id") Long id, @RequestBody Invoice invoiceRequest){
		return paymentService.updatePaymentsService(customerId, id, invoiceRequest);		
	}

}
