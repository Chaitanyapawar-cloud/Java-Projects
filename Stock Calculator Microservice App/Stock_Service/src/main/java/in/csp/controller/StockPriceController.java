package in.csp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.csp.model.Stock;
import in.csp.service.IStockPriceService;

@RestController
@RequestMapping("/stock/price")
public class StockPriceController {

	@Autowired
	private IStockPriceService service;
	
	@GetMapping("/unitprice/{companyName}")
	public ResponseEntity<?> getStockUnitPrice(@PathVariable String companyName)
	{
		Stock stockPrice = service.getStockPrice(companyName);
		return new ResponseEntity<Double>(stockPrice.getCompanyPrice(),HttpStatus.OK);
	}
}
