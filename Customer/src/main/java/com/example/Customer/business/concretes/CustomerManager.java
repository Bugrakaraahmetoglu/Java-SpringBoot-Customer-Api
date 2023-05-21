package com.example.Customer.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Customer.business.abstracts.CustomerService;
import com.example.Customer.business.requests.CreateBrandsRequest;
import com.example.Customer.business.requests.UpdateCustomerRequest;
import com.example.Customer.business.responses.GetAllCustomerResponse;
import com.example.Customer.business.responses.GetByIdCustomerRepsonse;
import com.example.Customer.core.utilities.mappers.ModelMapperService;
import com.example.Customer.dataAcces.abstracts.CustomerRepository;
import com.example.Customer.entities.concretes.Customer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService{

	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCustomerResponse> gettAll() {
		
		List<Customer> customers = customerRepository.findAll();
		
		List<GetAllCustomerResponse> customerResponse = customers.stream()
			.map(customer -> this.modelMapperService.forResponse().
					map(customer, GetAllCustomerResponse.class)).collect(Collectors.toList());
		
		return customerResponse ;
	}

	@Override
	public void add(CreateBrandsRequest createBrandsRequests) {
		
		Customer customer = this.modelMapperService.forRequest().map(createBrandsRequests, Customer.class);

		this.customerRepository.save(customer);
	}

	@Override
	public GetByIdCustomerRepsonse getById(int id) {
		Customer customer = this.customerRepository.findById(id).orElseThrow();
		
		GetByIdCustomerRepsonse response =
				this.modelMapperService.forResponse().map(customer, GetByIdCustomerRepsonse.class);
		return response;
	}

	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}

	@Override
	public void delete(int id) {
		this.customerRepository.deleteById(id);
	}

}
