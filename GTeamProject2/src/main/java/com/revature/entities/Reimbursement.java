package com.revature.entities;

import java.sql.Timestamp;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REIMB_AUTHOR")
	@JsonView(View.Summary.class)
	private Users reimbAuthor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REIMB_RESOLVER")
	@JsonView(View.Summary.class)
	private Users reimbResolver;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="REIMB_STATUS")
	@JsonView(View.Summary.class)
	private Status reimbStatus;
	
	@JsonView(View.Summary.class)
	private String reimbType;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(Integer reimbId, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Users reimbAuthor, Users reimbResolver, Status reimbStatus, String reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription

				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus
				+ ", reimbType=" + reimbType + "]";

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
		result = prime * result + ((reimbId == null) ? 0 : reimbId.hashCode());
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + ((reimbResolver == null) ? 0 : reimbResolver.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
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
		if (reimbId == null) {
			if (other.reimbId != null)
				return false;
		} else if (!reimbId.equals(other.reimbId))
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
		return true;
	}
	public Integer getReimbId() {
		return reimbId;
	}
	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public Users getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(Users reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public Users getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(Users reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public Status getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(Status reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	
}