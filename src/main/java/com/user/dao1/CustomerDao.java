package com.user.dao1;

import java.util.List;

import com.user.model.Customer;



public interface CustomerDao {
	long saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);

	Customer findCustomerById(Long id);

	List<Customer> findAllCustomers();
}
