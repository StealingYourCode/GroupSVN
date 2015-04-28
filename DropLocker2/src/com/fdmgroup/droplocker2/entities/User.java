package com.fdmgroup.droplocker2.entities;

import com.fdmgroup.droplocker2.entities.Plan;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private Integer userId;
	
	private String username;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "planId")
	private Plan userPlan;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
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
	public Plan getUserPlan() {
		return this.userPlan;
	}

	public void setUserPlan(Plan userPlan) {
		this.userPlan = userPlan;
	}
   
}
