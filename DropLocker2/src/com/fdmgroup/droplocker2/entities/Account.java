package com.fdmgroup.droplocker2.entities;

import com.fdmgroup.droplocker2.entities.Plan;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity

public class Account implements Serializable {

	   
	@Id
	private Integer accountId;
	
	@ManyToOne
	@JoinColumn(name = "planId")
	private Plan plan;
	
	@Column(name="CURRENT_FILES")
	private Integer currentFiles;
	
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}   
	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Integer getCurrentFiles() {
		return currentFiles;
	}
	public void setCurrentFiles(Integer currentFiles) {
		this.currentFiles = currentFiles;
	}
	
	
   
}
