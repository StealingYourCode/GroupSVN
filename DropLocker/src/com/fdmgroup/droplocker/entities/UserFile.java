package com.fdmgroup.droplocker.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserFile
 *
 */
@Entity

@IdClass(UserFilePK.class)
public class UserFile implements Serializable {

	   
	@Id
	private Integer userId;   
	@Id
	private String fileName;
	private static final long serialVersionUID = 1L;

	public UserFile() {
		super();
	}   
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
   
}
