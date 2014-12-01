package com.fdz.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@NamedQuery(name="findByLogin",query="select a from Admin a where a.login=:p1")
public class Admin implements Serializable {

	@Id
	private int idAdmin;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   
	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
