package com.patikaevamfinalproject.FinalProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patikaevamfinalproject.FinalProject.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
