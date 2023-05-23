package in.csp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.csp.model.Stock;

public interface IStockPriceRepo extends JpaRepository<Stock, Integer> {

	public Stock findByCompanyName(String companyName);
}
