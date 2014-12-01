package com.fdz.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobOwner
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name="findByName",query="select j from JobOwner j where j.companyname=:p1"),
@NamedQuery(name="findByCountry",query="select j from JobOwner j where j.country=:p2"),
})
public class JobOwner implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idJobOwner;
	private String login;
	private String password;
	private String email;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] image;
	private String country;
	private String city;
	private String companyname;
	@Column(columnDefinition="Decimal(10,2) default '0.00'")
	private float wallet;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="jobOwner" ,cascade=CascadeType.REMOVE)
	private List<JobProposal> list_job_proposals;
	private String state;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public JobOwner() {
		super();
	}   
	public JobOwner(String login, String password, String email, byte[] image,
			String country, String city, String companyname, float wallet,
			List<JobProposal> list_job_proposals, String state) {
		super();
		
		this.login = login;
		this.password = password;
		this.email = email;
		this.image = image;
		this.country = country;
		this.city = city;
		this.companyname = companyname;
		this.wallet = wallet;
		this.list_job_proposals = list_job_proposals;
		this.state = state;
	}

	public int getIdJobOwner() {
		return this.idJobOwner;
	}

	public void setIdJobOwner(int idJobOwner) {
		this.idJobOwner = idJobOwner;
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
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}   
	public float getWallet() {
		return this.wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public List<JobProposal> getList_job_proposals() {
		return list_job_proposals;
	}
	public void setList_job_proposals(List<JobProposal> list_job_proposals) {
		this.list_job_proposals = list_job_proposals;
	}

	@Override
	public String toString() {
		return "JobOwner [idJobOwner=" + idJobOwner + ", login=" + login
				+ ", password=" + password + ", email=" + email + ", image="
				+ Arrays.toString(image) + ", country=" + country + ", city="
				+ city + ", companyname=" + companyname + ", wallet=" + wallet
				+ ", state="
				+ state + "]";
	}
	
	
}
