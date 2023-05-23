package in.csp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.csp.feign.IFeignClient;

@RestController
@RequestMapping("/stock")
public class StockCalculationController {

	@Autowired
	private IFeignClient fc;
	
	@GetMapping("/calc/{companyName}/{qnty}")
	public ResponseEntity<?> getStockTotPrice(@PathVariable String companyName,@PathVariable Integer qnty)
	{
		ResponseEntity<?> responseEntity= null;
		Double totalPrice= null;
		try {
			
			responseEntity = fc.getStockUnitPrice(companyName);
			int statuscode= responseEntity.getStatusCodeValue();
			if(statuscode==200)
			{
				Double unitPrice =(Double) responseEntity.getBody();
				 totalPrice= unitPrice*qnty;
			}
			
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Company Not Found",HttpStatus.BAD_REQUEST);
		}
		
		 
		return new ResponseEntity<Double>(totalPrice,HttpStatus.OK);
	}
}
