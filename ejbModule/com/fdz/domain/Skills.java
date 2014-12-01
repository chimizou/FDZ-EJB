package com.fdz.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skills
 *
 */
@Entity

public class Skills implements Serializable {

	
	//ID
	@Id
	private long IdSkills;
	//Relation
	@ManyToOne
	@JoinColumn(name="FK_Freelancer")
	private Freelancer freelancer;
	@ManyToOne
	@JoinColumn(name="FK_JobProposal")
	private JobProposal jobProposal ;
	//Attributes
	private String Name;
	private static final long serialVersionUID = 1L;

	public Skills() {
		super();
	}   
	public long getIdSkills() {
		return this.IdSkills;
	}

	public void setIdSkills(long IdSkills) {
		this.IdSkills = IdSkills;
	}   
	public String getSkills() {
		return this.Name;
	}

	public void setSkills(String Name) {
		this.Name = Name;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
   
}
