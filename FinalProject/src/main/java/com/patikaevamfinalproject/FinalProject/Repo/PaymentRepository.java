package com.patikaevamfinalproject.FinalProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patikaevamfinalproject.FinalProject.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	Payment findByCustomerId(Long customerId);

}
