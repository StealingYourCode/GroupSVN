package com.fdmgroup.droplocker.entities;

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
	private Integer PlanId;
	private String PlanName;
	private Integer FilesAllowed;
	private static final long serialVersionUID = 1L;

	public Plan() {
		super();
	}   
	public Integer getPlanId() {
		return this.PlanId;
	}

	public void setPlanId(Integer PlanId) {
		this.PlanId = PlanId;
	}   
	public String getPlanName() {
		return this.PlanName;
	}

	public void setPlanName(String PlanName) {
		this.PlanName = PlanName;
	}   
	public Integer getFilesAllowed() {
		return this.FilesAllowed;
	}

	public void setFilesAllowed(Integer FilesAllowed) {
		this.FilesAllowed = FilesAllowed;
	}
   
}
