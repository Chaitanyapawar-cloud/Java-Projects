package in.csp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.csp.dao.ICustDao;
import in.csp.model.Customer;

@Service
public class CustomerServiceImp implements ICustService{

	@Autowired
	private ICustDao dao;
	

	@Override
	public List<Customer> GetAllCustomers() {
		List<Customer> Custlist = (List<Customer>) dao.findAll();
		return Custlist;
	}

	@Override
	public void RegisterCustomer(Customer c) {
		dao.save(c);
	}

	

	@Override
	public void Delete(Customer c) {
		dao.delete(c);
	}

	@Override
	public Customer getCust(Integer id) {
		Optional<Customer> opt = dao.findById(id);
			return opt.get();
	}
}
