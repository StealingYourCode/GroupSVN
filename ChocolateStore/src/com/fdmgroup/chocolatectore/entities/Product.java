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
	@SequenceGenerator(name="PRODUCT_PRODUCTID_GENERATOR", sequenceName="PRODUCT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_PRODUCTID_GENERATOR")
	@Column(name="PRODUCT_ID")
	private long productId;

	private String description;

	private String name;

	private BigDecimal price;

	@Column(name="STOCK_AMOUNT")
	private BigDecimal stockAmount;

	//bi-directional many-to-one association to ProductSale
	@OneToMany(mappedBy="product")
	private List<ProductSale> productSales;

	public Product() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getStockAmount() {
		return this.stockAmount;
	}

	public void setStockAmount(BigDecimal stockAmount) {
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