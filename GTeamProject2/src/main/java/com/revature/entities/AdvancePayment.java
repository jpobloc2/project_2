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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.views.View;

@Entity
@Table(name="ADV_PAYMENT")
public class AdvancePayment {
	
	@Id
	@Column(name="ADV_ID")
	@SequenceGenerator(name="ADVID_SEQ", sequenceName="ADVID_SEQ")
	@GeneratedValue(generator="ADVID_SEQ", strategy=GenerationType.AUTO)
	@JsonView(View.Summary.class)
	private Integer advId;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE) // Remove Cascade
	@JoinColumn(name="AUTHOR_ID")
	@JsonView(View.Summary.class)
	private Users author;
	
	@JsonView(View.Summary.class)
	private double amount;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE) // Remove Cascade
	@JoinColumn(name="STATUS")
	@JsonView(View.Summary.class)
	private Status status;
	@JsonView(View.Summary.class)
	private Timestamp submitDate;
	@JsonView(View.Summary.class)
	private Timestamp resolveDate;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE) // Remove Cascade
	@JoinColumn(name="RESOLVER_ID")
	@JsonView(View.Summary.class)
	private Users resolver;
	
	@JsonView(View.Summary.class)
	private String advComment;

	public AdvancePayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvancePayment(Integer advId, Users author, double amount, Status status, Timestamp submitDate,
			Timestamp resolveDate, Users resolver, String advComment) {
		super();
		this.advId = advId;
		this.author = author;
		this.amount = amount;
		this.status = status;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.resolver = resolver;
		this.advComment = advComment;
	}

	@Override
	public String toString() {
		return "AdvancePayment [advId=" + advId + ", author=" + author + ", amount=" + amount + ", status=" + status
				+ ", submitDate=" + submitDate + ", resolveDate=" + resolveDate + ", resolver=" + resolver
				+ ", advComment=" + advComment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advComment == null) ? 0 : advComment.hashCode());
		result = prime * result + ((advId == null) ? 0 : advId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
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
		AdvancePayment other = (AdvancePayment) obj;
		if (advComment == null) {
			if (other.advComment != null)
				return false;
		} else if (!advComment.equals(other.advComment))
			return false;
		if (advId == null) {
			if (other.advId != null)
				return false;
		} else if (!advId.equals(other.advId))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (resolveDate == null) {
			if (other.resolveDate != null)
				return false;
		} else if (!resolveDate.equals(other.resolveDate))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		return true;
	}

	public Integer getAdvId() {
		return advId;
	}

	public void setAdvId(Integer advId) {
		this.advId = advId;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public Timestamp getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
	}

	public Users getResolver() {
		return resolver;
	}

	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}

	public String getAdvComment() {
		return advComment;
	}

	public void setAdvComment(String advComment) {
		this.advComment = advComment;
	}


	
}
