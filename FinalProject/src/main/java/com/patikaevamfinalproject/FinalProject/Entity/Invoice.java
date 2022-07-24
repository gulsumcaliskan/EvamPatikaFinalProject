package com.patikaevamfinalproject.FinalProject.Entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="invoices")
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double dept;
	@CreatedDate
	@Column(name= "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
    private LocalDateTime updatedAt;
	
	private int status;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="customer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customer customer;
	
	// Constructor
	public Invoice() {
	}
			
	public Invoice(Long id, Double dept, Date createdAt, LocalDateTime updatedAt, int status, Customer customer) {
		this.id = id;
		this.dept = dept;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.customer = customer;
	}
		
	// Getter
	public Long getId() {return id;}
	public Double getDept() {return dept;}
	public Date getCreatedAt() {return createdAt;}
	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public Customer getCustomer() {return customer;}
	public int getStatus() {return status;}
				
	// Setter
	public void setId(Long id) {this.id = id;}
	public void setDept(Double dept) {this.dept = dept;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	public void setStatus(int status) {this.status = status;}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Invoice invoice = (Invoice) o;
        return id.equals(invoice.id);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(id);
    }
	
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", dept=" + dept + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status=" + status + ", customer=" + customer + "]";
	}


}
