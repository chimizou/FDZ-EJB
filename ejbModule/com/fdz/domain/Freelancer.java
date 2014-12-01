package com.fdz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
@NamedQuery(name="findFreelancerByName",query="select f from Freelancer f where f.nom=:p1"),
@NamedQuery(name="findFreelancerBySkills",query="select f from Freelancer f where f.education=:p2"),
})
public class Freelancer  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFreelancer;
	private String nom; 
	private String prenom; 
	private String login;
	private String password;
	private String email;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] image;
	private String city;
	private String country;
	@OneToMany(mappedBy="freelancer", cascade = CascadeType.ALL)			//Voir l'utilité de Cascade
	private List<Skills> listSkills ;
	private String experience;
	private String education;
	private String state;
	

	public String getState() {
		return state;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	@Column(columnDefinition="Decimal(10,2) default '0.00'")
	private float wallet;
	
	public Freelancer() {
		
	}

	public int getIdFreelancer() {
		return idFreelancer;
	}

	public void setIdFreelancer(int idFreelancer) {
		this.idFreelancer = idFreelancer;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public List<Skills> getListSkills() {
		return listSkills;
	}

	public void setListSkills(List<Skills> listSkills) {
		this.listSkills = listSkills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

}
