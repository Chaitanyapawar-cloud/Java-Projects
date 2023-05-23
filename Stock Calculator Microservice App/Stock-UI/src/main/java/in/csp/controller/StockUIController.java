package in.csp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.csp.service.StockUIService;

@Controller
@RequestMapping("/api")
public class StockUIController {
	@Autowired
	private StockUIService service;

	@GetMapping("/form")
	public String getForm()
	{
		return "index";
	}
	
	@GetMapping("/processform")
	public String processForm(Model model,HttpServletRequest req)
	{
		String companyName = req.getParameter("companyName").toUpperCase();
		Integer qnty = Integer.parseInt(req.getParameter("qnty"));
		String msg = service.getMsg(companyName, qnty);
		model.addAttribute("msg", msg);
		return "index";
	}
}
