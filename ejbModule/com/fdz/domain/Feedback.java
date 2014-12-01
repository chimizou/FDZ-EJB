package com.fdz.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feedback
 *
 */
@Entity

public class Feedback implements Serializable {

	//ID
	@Id
	private int IdFeedback;
	//Relation
	@OneToOne
	@JoinColumn(name="FK_JobProposal")
	private JobProposal jobProposal;
	//Attributes
	private int QualityWork;
	private int Communication;
	private int Professionalism;
	private int CompletionRates;
	private int Time;
	private int Budget;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}   
	public int getIdFeedback() {
		return this.IdFeedback;
	}

	public void setIdFeedback(int IdFeedback) {
		this.IdFeedback = IdFeedback;
	}   
	public int getQualityWork() {
		return this.QualityWork;
	}

	public void setQualityWork(int QualityWork) {
		this.QualityWork = QualityWork;
	}   
	public int getCommunication() {
		return this.Communication;
	}

	public void setCommunication(int Communication) {
		this.Communication = Communication;
	}   
	public int getProfessionalism() {
		return this.Professionalism;
	}

	public void setProfessionalism(int Professionalism) {
		this.Professionalism = Professionalism;
	}   
	public int getCompletionRates() {
		return this.CompletionRates;
	}

	public void setCompletionRates(int CompletionRates) {
		this.CompletionRates = CompletionRates;
	}   
	public int getTime() {
		return this.Time;
	}

	public void setTime(int Time) {
		this.Time = Time;
	}   
	public int getBudget() {
		return this.Budget;
	}

	public void setBudget(int Budget) {
		this.Budget = Budget;
	}
	public JobProposal getJobProposal() {
		return jobProposal;
	}
	public void setJobProposal(JobProposal jobProposal) {
		this.jobProposal = jobProposal;
	}
   
}
