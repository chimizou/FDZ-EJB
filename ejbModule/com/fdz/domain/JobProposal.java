package com.fdz.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobProposal
 *
 */
@Entity
@NamedQuery(name="GetJobProposalsByJobOwner",
query="SELECT e " +     "FROM JobProposal e " + "WHERE e.jobOwner.idJobOwner =:param ")

public class JobProposal implements Serializable {

	//Relation
		@Id private int IdJobProposal;
		@ManyToOne
		@JoinColumn(name="FK_JobOwner")
		private JobOwner jobOwner ;
		@OneToMany(mappedBy="jobProposal")
		private List<Category> listCategory;
	    @ManyToMany
	    @JoinTable(name="FreelancerApproved")
	    private Set<Freelancer> listFreelancer;			//Pour générer les clés primaires composées (Set au lieu de List)
		@OneToOne(mappedBy="jobProposal")
		private Feedback feedback;
		@OneToMany(mappedBy="jobProposal")
	    private List<Skills> listSkills;
		//Attributes
		private String Title;
		private String Description;
		private int EstimatedDuration;
		private String Specification;
		private int EstimatedWorkload;
		private String State;
		private static final long serialVersionUID = 1L;
	    
		public JobProposal() {
			super();
		}   
		public int getIdJobProposal() {
			return this.IdJobProposal;
		}

		public void setIdJobProposal(int IdJobProposal) {
			this.IdJobProposal = IdJobProposal;
		}   
		public String getTitle() {
			return this.Title;
		}

		public void setTitle(String Title) {
			this.Title = Title;
		}   
		public String getDescription() {
			return this.Description;
		}

		public void setDescription(String Description) {
			this.Description = Description;
		}   
		public int getEstimatedDuration() {
			return this.EstimatedDuration;
		}

		public void setEstimatedDuration(int EstimatedDuration) {
			this.EstimatedDuration = EstimatedDuration;
		}   
		public String getSpecification() {
			return this.Specification;
		}

		public void setSpecification(String Specification) {
			this.Specification = Specification;
		}   
		public int getEstimatedWorkload() {
			return this.EstimatedWorkload;
		}

		public void setEstimatedWorkload(int EstimatedWorkload) {
			this.EstimatedWorkload = EstimatedWorkload;
		}   
		public String getState() {
			return this.State;
		}

		public void setState(String State) {
			this.State = State;
		}
		public List<Category> getListcategory() {
			return listCategory;
		}
		public void setListcategory(List<Category> listcategory) {
			this.listCategory = listcategory;
		}
		public JobOwner getJobOwner() {
			return jobOwner;
		}
		public void setJobOwner(JobOwner jobOwner) {
			this.jobOwner = jobOwner;
		}
		public Feedback getFeedback() {
			return feedback;
		}
		public void setFeedback(Feedback feedback) {
			this.feedback = feedback;
		}
		public List<Skills> getListSkills() {
			return listSkills;
		}
		public void setListSkills(List<Skills> listSkills) {
			this.listSkills = listSkills;
		}

		
	   
	}
