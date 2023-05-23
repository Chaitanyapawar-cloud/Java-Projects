package in.csp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="STOCK-PRICE-SERVICE")
public interface IFeignClient {

	@GetMapping("/stock/price/unitprice/{companyName}")
	public ResponseEntity<?> getStockUnitPrice(@PathVariable String companyName);
}
