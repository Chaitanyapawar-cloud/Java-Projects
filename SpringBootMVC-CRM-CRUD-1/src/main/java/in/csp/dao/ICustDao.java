package in.csp.dao;

import org.springframework.data.repository.CrudRepository;

import in.csp.model.Customer;

public interface ICustDao extends CrudRepository<Customer, Integer> {

}
