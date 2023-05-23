package in.csp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Entity
@Table(name="STOCK_PRICE")
@Data
public class Stock {

	@Id
	@Column(name = "STOCK_ID")
	private Integer stockId;
	
	@Column(name = "COMPANY_NAME")
	private String  companyName;
	
	@Column(name = "COMPANY_PRICE")
	private Double  companyPrice;
}
