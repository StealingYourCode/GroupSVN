package com.fdmgroup.chocolatectore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCT_SALES database table.
 * 
 */
@Entity
@Table(name="PRODUCT_SALES")

@NamedQuery(name="ProductSale.findAll", query="SELECT p FROM ProductSale p")
public class ProductSale implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal quantity;

	//bi-directional many-to-one association to Product
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PS_PRODUCT_ID")
	private Product product;

	//bi-directional many-to-one association to Sale
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PS_SALES_ID")
	private Sale sale;

	public ProductSale() {
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}