package com.thirdware.guptabookstore.dao;


import com.thirdware.guptabookstore.models.Customer;


public interface CustomerDao {
	public Customer  customerRegister(Customer customer);
	public Customer customerLogin(String email);
	public String role(int id);
}
