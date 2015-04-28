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
	private Integer planId;
	private String planName;
	private Integer filesAllowed;
	private static final long serialVersionUID = 1L;

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
