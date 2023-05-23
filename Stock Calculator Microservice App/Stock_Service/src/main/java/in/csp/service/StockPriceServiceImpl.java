package in.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.csp.dao.IStockPriceRepo;
import in.csp.exception.StockNotFoundException;
import in.csp.model.Stock;

@Service
public class StockPriceServiceImpl implements IStockPriceService {

	@Autowired
	private IStockPriceRepo dao;
	
	@Override
	public Stock getStockPrice(String CompanyName) {
		 Stock stock= dao.findByCompanyName(CompanyName);
		 if(stock==null)
			 throw new StockNotFoundException("Stock Not Found");
		 return stock;
	}

}
