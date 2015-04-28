package com.fdmgroup.droplocker2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: AccountFile
 *
 */
@Entity

@IdClass(AccountFilePK.class)
public class AccountFile implements Serializable {

	   
	@Id
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account accountId; 
	
	@Id
	@Column(name="FILE_NAME")
	private String fileName;
	private static final long serialVersionUID = 1L;

	public AccountFile() {
		super();
	}   
	public Account getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}   
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
   
}

class AccountFilePK  implements Serializable {   
	   
	 
	private Account accountId;         
	private String fileName;
	private static final long serialVersionUID = 1L;

	public AccountFilePK() {}

}	
