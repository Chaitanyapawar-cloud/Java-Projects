package in.csp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.csp.model.Customer;
import in.csp.service.ICustService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private ICustService service;
	


	@GetMapping(value="/list")
	public String custList(Map<String, Object> model)
	{
		List<Customer> Custlist = service.GetAllCustomers();
		System.out.println(Custlist);
		model.put("custlist", Custlist);
		return "CustList";
		
	}
	@GetMapping(value="/showForm")
	public String showForm(Map<String, Object> model)
	{
		Customer customer = new Customer();
		model.put("customer", customer);
		return "AddForm";
		
	}
	@PostMapping(value="/saveCustomer")
	public String saveCust(@ModelAttribute("customer") Customer customer)
	{
	 service.RegisterCustomer(customer);
	 System.out.println(customer);
		return "redirect:/customer/list";	
	}
	
	@GetMapping(value="/updateForm")
	public String updateForm(Map<String, Object> model,@RequestParam Integer id)
	{
		Customer cust = service.getCust(id);
		model.put("customer", cust);
		return "AddForm";
		
	}
	
	@GetMapping(value="/deleteForm")
	public String deleteForm(@RequestParam Integer id)
	{
		Customer cust = service.getCust(id);
		service.Delete(cust);
		return "redirect:/customer/list";
		
	}
	
	
	@GetMapping(value="/")
	public String home()
	{
		return "index";
	
	}
}
