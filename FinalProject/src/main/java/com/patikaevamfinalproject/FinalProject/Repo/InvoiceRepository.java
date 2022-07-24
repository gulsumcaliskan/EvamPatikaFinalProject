package com.patikaevamfinalproject.FinalProject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patikaevamfinalproject.FinalProject.Entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	
	List<Invoice> findByCustomerId(Long customerId);

}
