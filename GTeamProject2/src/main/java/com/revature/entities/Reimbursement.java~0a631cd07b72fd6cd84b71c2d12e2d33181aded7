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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reimbursement {
	@Id
	@Column(name="REIMB_ID")
	@SequenceGenerator(name="REIMBID_SEQ", sequenceName="REIMBID_SEQ")
	@GeneratedValue(generator="REIMBID_SEQ", strategy=GenerationType.AUTO)
	private Integer reimbid;
	
	private double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="REIMB_AUTHOR")
	@JsonIgnore
	private Users reimb_author;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="REIMB_RESOLVER")
	@JsonIgnore 	 	
	private Users reimb_resolver;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="REIMB_STATUS")
	private Status reimb_status;
	
	private String reimb_type;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(Integer reimbid, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, Users reimb_author, Users reimb_resolver, Status reimb_status,
			String reimb_type) {
		super();
		this.reimbid = reimbid;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
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
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimb_author == null) ? 0 : reimb_author.hashCode());
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + ((reimb_resolver == null) ? 0 : reimb_resolver.hashCode());
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
		result = prime * result + ((reimbid == null) ? 0 : reimbid.hashCode());
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
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (reimb_author == null) {
			if (other.reimb_author != null)
				return false;
		} else if (!reimb_author.equals(other.reimb_author))
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_resolver == null) {
			if (other.reimb_resolver != null)
				return false;
		} else if (!reimb_resolver.equals(other.reimb_resolver))
			return false;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		if (reimbid == null) {
			if (other.reimbid != null)
				return false;
		} else if (!reimbid.equals(other.reimbid))
			return false;
		return true;
	}
	public Integer getReimbid() {
		return reimbid;
	}
	public void setReimbid(Integer reimbid) {
		this.reimbid = reimbid;
	}
	public double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public Users getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(Users reimb_author) {
		this.reimb_author = reimb_author;
	}
	public Users getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(Users reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public Status getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(Status reimb_status) {
		this.reimb_status = reimb_status;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	
	
}