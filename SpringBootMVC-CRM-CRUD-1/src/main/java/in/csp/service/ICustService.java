package in.csp.service;

import java.util.List;

import in.csp.model.Customer;

public interface ICustService {

	public List<Customer> GetAllCustomers();
	public void RegisterCustomer( Customer c);
	public Customer getCust(Integer id);
	public void Delete(Customer c);
}
