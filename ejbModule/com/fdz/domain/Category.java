package com.fdz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdCategory;
	private String Name;
	@ManyToOne
	@JoinColumn (name="FK_JobProposal")
	private JobProposal jobProposal;
    @OneToMany (mappedBy="category",cascade=CascadeType.REMOVE)//bech ki tfassa5 categorie les subcategory mte3ha yetfass5ou m3aha
	private List<Category> listcategory;
    @ManyToOne
    private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Category() {
		super();
	}   
	public long getIdCategory() {
		return this.IdCategory;
	}

	public void setIdCategory(long IdCategory) {
		this.IdCategory = IdCategory;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	public JobProposal getJobProposal() {
		return jobProposal;
	}
	public void setJobProposal(JobProposal jobProposal) {
		this.jobProposal = jobProposal;
	}
	public List<Category> getListcategory() {
		return listcategory;
	}
	public void setListcategory(List<Category> listcategory) {
		this.listcategory = listcategory;
	}
	
   
}