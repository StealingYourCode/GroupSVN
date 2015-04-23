package com.fdmgroup.chocolatectore.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SALES database table.
 * 
 */
@Entity
@Table(name="SALES")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SALES_SALESID_GENERATOR", sequenceName="SALE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SALES_SALESID_GENERATOR")
	@Column(name="SALES_ID")
	private Integer salesId;

	@Temporal(TemporalType.DATE)
	@Column(name="SALE_DATE")
	private Calendar saleDate;

	//bi-directional many-to-one association to ProductSale
	@OneToMany(mappedBy="sale")
	private List<ProductSale> productSales;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;

	public Sale() {
	}

	public Integer getSalesId() {
		return this.salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public Calendar getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public List<ProductSale> getProductSales() {
		return this.productSales;
	}

	public void setProductSales(List<ProductSale> productSales) {
		this.productSales = productSales;
	}

	public ProductSale addProductSale(ProductSale productSale) {
		getProductSales().add(productSale);
		productSale.setSale(this);

		return productSale;
	}

	public ProductSale removeProductSale(ProductSale productSale) {
		getProductSales().remove(productSale);
		productSale.setSale(null);

		return productSale;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}