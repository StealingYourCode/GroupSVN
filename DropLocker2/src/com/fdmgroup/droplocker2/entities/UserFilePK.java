package com.fdmgroup.droplocker2.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

/**
 * ID class for entity: UserFile
 *
 */ 
public class UserFilePK  implements Serializable {   
   
	         
	private Integer userId;         
	private String fileName;
	private static final long serialVersionUID = 1L;

	public UserFilePK() {}

	

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof UserFilePK)) {
			return false;
		}
		UserFilePK other = (UserFilePK) o;
		return true
			&& (getUserId() == null ? other.getUserId() == null : getUserId().equals(other.getUserId()))
			&& (getFileName() == null ? other.getFileName() == null : getFileName().equals(other.getFileName()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getUserId() == null ? 0 : getUserId().hashCode());
		result = prime * result + (getFileName() == null ? 0 : getFileName().hashCode());
		return result;
	}
   
   
}
