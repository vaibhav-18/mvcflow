package com.user.dao;


import java.util.List;

import com.user.model.Customer;



public interface CustomerDao {
	long saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);

	Customer findCustomerById(Long id);

	List<Customer> findAllCustomers();
}
