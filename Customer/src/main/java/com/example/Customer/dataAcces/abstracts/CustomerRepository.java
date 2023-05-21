package com.example.Customer.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
