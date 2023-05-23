package in.csp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class StockUIService{

	public String getMsg(String companyName, Integer qnty)
	{
		String url= "http://localhost:1111/stock/calc/{companyName}/{qnty}";
		WebClient webClient=WebClient.create();
		Double totprice =null;
		String msg =null;
		try {
			totprice = webClient.get().
					 uri(url,companyName,qnty).
					 retrieve().
					 bodyToMono(Double.class).
					 block();
			msg="Total Stock price is "+totprice;
		}
		catch (Exception e) {
			msg="CompanyName not found";
		}
		return msg;
	}

}
