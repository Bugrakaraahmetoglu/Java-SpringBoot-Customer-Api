package com.example.Customer.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.business.abstracts.CustomerService;
import com.example.Customer.business.requests.CreateBrandsRequest;
import com.example.Customer.business.requests.UpdateCustomerRequest;
import com.example.Customer.business.responses.GetAllCustomerResponse;
import com.example.Customer.business.responses.GetByIdCustomerRepsonse;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerControllers {
	private CustomerService customerService;
	
	
	@GetMapping("/getAll")
	public List<GetAllCustomerResponse> getAll(){
		return customerService.gettAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdCustomerRepsonse getById(@PathVariable int id){
		return customerService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add( CreateBrandsRequest createBrandRequest) {
		this.customerService.add(createBrandRequest);
		
	}
	
	@PutMapping
	public void update( UpdateCustomerRequest updateCustomerRequest) {
		this.customerService.update(updateCustomerRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete( int id) {
		this.customerService.delete(id);
	}
}
