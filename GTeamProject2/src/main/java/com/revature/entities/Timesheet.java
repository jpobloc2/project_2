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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.views.View;

@Entity
public class Timesheet {
	@Id
	@Column(name="TS_ID")
	@SequenceGenerator(name="TSID_SEQ", sequenceName="TSID_SEQ")
	@GeneratedValue(generator="TSID_SEQ", strategy=GenerationType.AUTO)
	@JsonView(View.Summary.class)
	private Integer timesheetId;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="AUTHOR_ID")
	@JsonView(View.Summary.class)
	private Users author;
	
	@JsonView(View.Summary.class)
	private Timestamp startDate;
	
	@JsonView(View.Summary.class)
	private Timestamp submittedDate;
	
	@JsonView(View.Summary.class)
	private Timestamp resolvedDate;
	
	@JsonView(View.Summary.class)
	private Double hoursTotal;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="STATUS")
	@JsonView(View.Summary.class)
	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) // Remove Cascade
	@JoinColumn(name="RESOLVER_ID")
	@JsonView(View.Summary.class)
	private Users resolver;
	
	@JsonView(View.Summary.class)
	private String tsComment;
	
	@JsonView(View.Summary.class)
	private Double sunday;
	
	@JsonView(View.Summary.class)
	private Double monday;
	
	@JsonView(View.Summary.class)
	private Double tuesday;
	
	@JsonView(View.Summary.class)
	private Double wednesday;
	
	@JsonView(View.Summary.class)
	private Double thursday;
	
	@JsonView(View.Summary.class)
	private Double friday;
	
	@JsonView(View.Summary.class)
	private Double saturday;
	
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Timesheet(Integer timesheetid, Users author, Timestamp start_date, Timestamp submitted_date,
			Timestamp resolved_date, Double hours_total, Status status, Users resolver, String ts_comment,
			Double sunday, Double monday, Double tuesday, Double wednesday, Double thursday, Double friday,
			Double saturday) {
		super();
		this.timesheetId = timesheetid;
		this.author = author;
		this.startDate = start_date;
		this.submittedDate = submitted_date;
		this.resolvedDate = resolved_date;
		this.hoursTotal = hours_total;
		this.status = status;
		this.resolver = resolver;
		this.tsComment = ts_comment;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
	}
	@Override
	public String toString() {
		return "Timesheet [timesheetid=" + timesheetId + ", author=" + author.getUsername() + ", start_date=" + startDate
				+ ", submitted_date=" + submittedDate + ", resolved_date=" + resolvedDate + ", hours_total="
				+ hoursTotal + ", status=" + status + ", resolver=" + resolver.getUsername() + ", ts_comment=" + tsComment
				+ ", sunday=" + sunday + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((friday == null) ? 0 : friday.hashCode());
		result = prime * result + ((hoursTotal == null) ? 0 : hoursTotal.hashCode());
		result = prime * result + ((monday == null) ? 0 : monday.hashCode());
		result = prime * result + ((resolvedDate == null) ? 0 : resolvedDate.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((saturday == null) ? 0 : saturday.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submittedDate == null) ? 0 : submittedDate.hashCode());
		result = prime * result + ((sunday == null) ? 0 : sunday.hashCode());
		result = prime * result + ((thursday == null) ? 0 : thursday.hashCode());
		result = prime * result + ((timesheetId == null) ? 0 : timesheetId.hashCode());
		result = prime * result + ((tsComment == null) ? 0 : tsComment.hashCode());
		result = prime * result + ((tuesday == null) ? 0 : tuesday.hashCode());
		result = prime * result + ((wednesday == null) ? 0 : wednesday.hashCode());
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
		Timesheet other = (Timesheet) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (friday == null) {
			if (other.friday != null)
				return false;
		} else if (!friday.equals(other.friday))
			return false;
		if (hoursTotal == null) {
			if (other.hoursTotal != null)
				return false;
		} else if (!hoursTotal.equals(other.hoursTotal))
			return false;
		if (monday == null) {
			if (other.monday != null)
				return false;
		} else if (!monday.equals(other.monday))
			return false;
		if (resolvedDate == null) {
			if (other.resolvedDate != null)
				return false;
		} else if (!resolvedDate.equals(other.resolvedDate))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (saturday == null) {
			if (other.saturday != null)
				return false;
		} else if (!saturday.equals(other.saturday))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submittedDate == null) {
			if (other.submittedDate != null)
				return false;
		} else if (!submittedDate.equals(other.submittedDate))
			return false;
		if (sunday == null) {
			if (other.sunday != null)
				return false;
		} else if (!sunday.equals(other.sunday))
			return false;
		if (thursday == null) {
			if (other.thursday != null)
				return false;
		} else if (!thursday.equals(other.thursday))
			return false;
		if (timesheetId == null) {
			if (other.timesheetId != null)
				return false;
		} else if (!timesheetId.equals(other.timesheetId))
			return false;
		if (tsComment == null) {
			if (other.tsComment != null)
				return false;
		} else if (!tsComment.equals(other.tsComment))
			return false;
		if (tuesday == null) {
			if (other.tuesday != null)
				return false;
		} else if (!tuesday.equals(other.tuesday))
			return false;
		if (wednesday == null) {
			if (other.wednesday != null)
				return false;
		} else if (!wednesday.equals(other.wednesday))
			return false;
		return true;
	}
	public Integer getTimesheetid() {
		return timesheetId;
	}
	public void setTimesheetid(Integer timesheetid) {
		this.timesheetId = timesheetid;
	}
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public Timestamp getStart_date() {
		return startDate;
	}
	public void setStart_date(Timestamp start_date) {
		this.startDate = start_date;
	}
	public Timestamp getSubmitted_date() {
		return submittedDate;
	}
	public void setSubmitted_date(Timestamp submitted_date) {
		this.submittedDate = submitted_date;
	}
	public Timestamp getResolved_date() {
		return resolvedDate;
	}
	public void setResolved_date(Timestamp resolved_date) {
		this.resolvedDate = resolved_date;
	}
	public Double getHours_total() {
		return hoursTotal;
	}
	public void setHours_total(Double hours_total) {
		this.hoursTotal = hours_total;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Users getResolver() {
		return resolver;
	}
	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}
	public String getTs_comment() {
		return tsComment;
	}
	public void setTs_comment(String ts_comment) {
		this.tsComment = ts_comment;
	}
	public Double getSunday() {
		return sunday;
	}
	public void setSunday(Double sunday) {
		this.sunday = sunday;
	}
	public Double getMonday() {
		return monday;
	}
	public void setMonday(Double monday) {
		this.monday = monday;
	}
	public Double getTuesday() {
		return tuesday;
	}
	public void setTuesday(Double tuesday) {
		this.tuesday = tuesday;
	}
	public Double getWednesday() {
		return wednesday;
	}
	public void setWednesday(Double wednesday) {
		this.wednesday = wednesday;
	}
	public Double getThursday() {
		return thursday;
	}
	public void setThursday(Double thursday) {
		this.thursday = thursday;
	}
	public Double getFriday() {
		return friday;
	}
	public void setFriday(Double friday) {
		this.friday = friday;
	}
	public Double getSaturday() {
		return saturday;
	}
	public void setSaturday(Double saturday) {
		this.saturday = saturday;
	}
	
	
}
