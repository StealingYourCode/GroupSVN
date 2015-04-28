package com.fdmgroup.droplocker2.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Plan
 *
 */
@Entity

public class Plan implements Serializable {

	   
	@Id
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME", unique=true)
	private String planName;
	
	@Column(name="FILES_ALLOWED")
	private Integer filesAllowed;
	
	private static final long serialVersionUID = 1L;
	
	public Plan(Integer id, String planName, Integer filesAllowed) {
		this.planId = id;
		this.planName = planName;
		this.filesAllowed = filesAllowed;
	}

	public Plan() {
		super();
	}   
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}   
	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}   
	public Integer getFilesAllowed() {
		return this.filesAllowed;
	}

	public void setFilesAllowed(Integer filesAllowed) {
		this.filesAllowed = filesAllowed;
	}
   
}
