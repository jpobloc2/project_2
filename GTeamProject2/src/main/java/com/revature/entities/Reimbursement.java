package com.revature.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.views.View;

@Entity
public class Reimbursement {
	@Id
	@Column(name="REIMB_ID")
	@SequenceGenerator(name="REIMBID_SEQ", sequenceName="REIMBID_SEQ")
	@GeneratedValue(generator="REIMBID_SEQ", strategy=GenerationType.AUTO)
	@JsonView(View.Summary.class)
	private Integer reimbId;
	
	@JsonView(View.Summary.class)
	private double reimbAmount;
	@JsonView(View.Summary.class)
	private Timestamp reimbSubmitted;
	@JsonView(View.Summary.class)
	private Timestamp reimbResolved;
	@JsonView(View.Summary.class)
	private String reimbDescription;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="REIMB_AUTHOR")
	@JsonView(View.Summary.class)
	private Users reimbAuthor;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="REIMB_RESOLVER")
	@JsonView(View.Summary.class)
	private Users reimbResolver;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="REIMB_STATUS")
	@JsonView(View.Summary.class)
	private Status reimbStatus;
	
	@JsonView(View.Summary.class)
	private String reimbType;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(Integer reimbid, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, Users reimb_author, Users reimb_resolver, Status reimb_status,
			String reimb_type) {
		super();
		this.reimbId = reimbid;
		this.reimbAmount = reimb_amount;
		this.reimbSubmitted = reimb_submitted;
		this.reimbResolved = reimb_resolved;
		this.reimbDescription = reimb_description;
		this.reimbAuthor = reimb_author;
		this.reimbResolver = reimb_resolver;
		this.reimbStatus = reimb_status;
		this.reimbType = reimb_type;
	}
	@Override
	public String toString() {
//		return "Reimbursement [reimbid=" + reimbid + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
//				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
//				+ ", reimb_author=" + reimb_author.getUsername() + ", reimb_resolver=" + reimb_resolver.getUsername() + ", reimb_status="
////				+ reimb_status + ", reimb_type=" + reimb_type + "]";
		return "*****************reimbursement tostring********";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbAuthor == null) ? 0 : reimbAuthor.hashCode());
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + ((reimbResolver == null) ? 0 : reimbResolver.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + ((reimbId == null) ? 0 : reimbId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthor == null) {
			if (other.reimbAuthor != null)
				return false;
		} else if (!reimbAuthor.equals(other.reimbAuthor))
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolver == null) {
			if (other.reimbResolver != null)
				return false;
		} else if (!reimbResolver.equals(other.reimbResolver))
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbId == null) {
			if (other.reimbId != null)
				return false;
		} else if (!reimbId.equals(other.reimbId))
			return false;
		return true;
	}
	public Integer getReimbid() {
		return reimbId;
	}
	public void setReimbid(Integer reimbid) {
		this.reimbId = reimbid;
	}
	public double getReimb_amount() {
		return reimbAmount;
	}
	public void setReimb_amount(double reimb_amount) {
		this.reimbAmount = reimb_amount;
	}
	public Timestamp getReimb_submitted() {
		return reimbSubmitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimbSubmitted = reimb_submitted;
	}
	public Timestamp getReimb_resolved() {
		return reimbResolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimbResolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimbDescription;
	}
	public void setReimb_description(String reimb_description) {
		this.reimbDescription = reimb_description;
	}
	public Users getReimb_author() {
		return reimbAuthor;
	}
	public void setReimb_author(Users reimb_author) {
		this.reimbAuthor = reimb_author;
	}
	public Users getReimb_resolver() {
		return reimbResolver;
	}
	public void setReimb_resolver(Users reimb_resolver) {
		this.reimbResolver = reimb_resolver;
	}
	public Status getReimb_status() {
		return reimbStatus;
	}
	public void setReimb_status(Status reimb_status) {
		this.reimbStatus = reimb_status;
	}
	public String getReimb_type() {
		return reimbType;
	}
	public void setReimb_type(String reimb_type) {
		this.reimbType = reimb_type;
	}
	
	
}