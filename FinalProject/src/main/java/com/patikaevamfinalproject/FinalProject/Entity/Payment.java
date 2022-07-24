package com.patikaevamfinalproject.FinalProject.Entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payments")
public class Payment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double paidTotal;
	private LocalDate date;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="customer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customer customer;
	
	// Constructor
	public Payment() {
	}
	
	public Payment(Long id, Double paidTotal, LocalDate date, Customer customer) {
		this.id = id;
		this.paidTotal = paidTotal;
		this.date = date;
		this.customer = customer;
	}
	
	// Getter
	public Long getId() {return id;}
	public Double getPaidTotal() {return paidTotal;}
	public LocalDate getDate() {return date;}
	public Customer getCustomer() {return customer;}
			
	// Setter
	public void setId(Long id) {this.id = id;}
	public void setPaidTotal(Double paidTotal) {this.paidTotal = paidTotal;}
	public void setDate(LocalDate date) {this.date = date;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	        
	    Payment payment = (Payment) o;
	    return id.equals(payment.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
		
		
	@Override
	public String toString() {
		return "Payment [id= " + id + ", paidTotal=" + paidTotal + ", date=" + date + ", customer =" + customer + "]";
	}

}
