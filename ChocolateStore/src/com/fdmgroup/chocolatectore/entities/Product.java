package com.fdmgroup.chocolatectore.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PRODUCT_ID_SEQ")
	@SequenceGenerator(name="PRODUCT_ID_SEQ", sequenceName="PRODUCT_ID_SEQ")
	@Column(name="PRODUCT_ID")
	private Integer productId;

	private String description;
	@Column(name="PRODUCT_NAME")
	private String productName;

	private BigDecimal price;

	@Column(name="STOCK_AMOUNT")
	private Integer stockAmount;

	//bi-directional many-to-one association to ProductSale
	@OneToMany(mappedBy="product")
	private List<ProductSale> productSales;

	public Product() {
	}

	public Product(String name, BigDecimal price, Integer qty, String description) {
		this.productName = name;
		this.price = price;
		this.stockAmount = qty;
		this.description = description;
	}
	
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStockAmount() {
		return this.stockAmount;
	}

	public void setStockAmount(Integer stockAmount) {
		this.stockAmount = stockAmount;
	}

	public List<ProductSale> getProductSales() {
		return this.productSales;
	}

	public void setProductSales(List<ProductSale> productSales) {
		this.productSales = productSales;
	}

	public ProductSale addProductSale(ProductSale productSale) {
		getProductSales().add(productSale);
		productSale.setProduct(this);

		return productSale;
	}

	public ProductSale removeProductSale(ProductSale productSale) {
		getProductSales().remove(productSale);
		productSale.setProduct(null);

		return productSale;
	}

}