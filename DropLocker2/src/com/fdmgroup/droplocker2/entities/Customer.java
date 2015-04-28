package com.fdmgroup.droplocker2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class Customer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_ID_SEQ")
	@SequenceGenerator(name="USER_ID_SEQ", sequenceName="USER_ID_SEQ")
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account userAccount;
	
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Account getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(Account userAccount) {
		this.userAccount = userAccount;
	}
	
	
   
}
