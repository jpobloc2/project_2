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

@Entity
@Table(name="ADV_PAYMENT")
public class AdvancePayment {
	
	@Id
	@Column(name="ADV_ID")
	@SequenceGenerator(name="ADVID_SEQ", sequenceName="ADVID_SEQ")
	@GeneratedValue(generator="ADVID_SEQ", strategy=GenerationType.AUTO)
	private Integer advid;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) // Remove Cascade
	@JoinColumn(name="AUTHOR_ID")
	private Users author;
	
	private double amount;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) // Remove Cascade
	@JoinColumn(name="STATUS")
	private Status status;
	private Timestamp submit_date;
	private Timestamp resolve_date;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) // Remove Cascade
	@JoinColumn(name="RESOLVER_ID")
	private Users resolver;
	
	private String adv_comment;

	public AdvancePayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvancePayment(Integer advid, Users author, double amount, Status status, Timestamp submit_date,
			Timestamp resolve_date, Users resolver, String adv_comment) {
		super();
		this.advid = advid;
		this.author = author;
		this.amount = amount;
		this.status = status;
		this.submit_date = submit_date;
		this.resolve_date = resolve_date;
		this.resolver = resolver;
		this.adv_comment = adv_comment;
	}

	@Override
	public String toString() {
		return "AdvancePayment [advid=" + advid + ", author=" + author.getUsername() + ", amount=" + amount + ", status=" + status
				+ ", submit_date=" + submit_date + ", resolve_date=" + resolve_date + ", resolver=" + resolver.getUsername()
				+ ", adv_comment=" + adv_comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adv_comment == null) ? 0 : adv_comment.hashCode());
		result = prime * result + ((advid == null) ? 0 : advid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((resolve_date == null) ? 0 : resolve_date.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submit_date == null) ? 0 : submit_date.hashCode());
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
		if (adv_comment == null) {
			if (other.adv_comment != null)
				return false;
		} else if (!adv_comment.equals(other.adv_comment))
			return false;
		if (advid == null) {
			if (other.advid != null)
				return false;
		} else if (!advid.equals(other.advid))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (resolve_date == null) {
			if (other.resolve_date != null)
				return false;
		} else if (!resolve_date.equals(other.resolve_date))
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
		if (submit_date == null) {
			if (other.submit_date != null)
				return false;
		} else if (!submit_date.equals(other.submit_date))
			return false;
		return true;
	}

	public Integer getAdvid() {
		return advid;
	}

	public void setAdvid(Integer advid) {
		this.advid = advid;
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

	public Timestamp getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(Timestamp submit_date) {
		this.submit_date = submit_date;
	}

	public Timestamp getResolve_date() {
		return resolve_date;
	}

	public void setResolve_date(Timestamp resolve_date) {
		this.resolve_date = resolve_date;
	}

	public Users getResolver() {
		return resolver;
	}

	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}

	public String getAdv_comment() {
		return adv_comment;
	}

	public void setAdv_comment(String adv_comment) {
		this.adv_comment = adv_comment;
	}

	

	
}
