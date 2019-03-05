package com.cts.bean;

import javax.persistence.*;

@Entity
@Table(name = "user_cred")
@NamedQuery(name="UserCred.findAll",query="SELECT u from UserCred u")
public class UserCred {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_name")
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
