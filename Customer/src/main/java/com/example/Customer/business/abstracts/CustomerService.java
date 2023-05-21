package com.example.Customer.business.abstracts;

import java.util.List;

import com.example.Customer.business.requests.CreateBrandsRequest;
import com.example.Customer.business.requests.UpdateCustomerRequest;
import com.example.Customer.business.responses.GetAllCustomerResponse;
import com.example.Customer.business.responses.GetByIdCustomerRepsonse;

public interface CustomerService {
	List<GetAllCustomerResponse> gettAll();
	GetByIdCustomerRepsonse getById(int id);
	void add(CreateBrandsRequest createBrandsRequests);
	void update(UpdateCustomerRequest updateCustomerRequest);
	void delete(int id);


}
