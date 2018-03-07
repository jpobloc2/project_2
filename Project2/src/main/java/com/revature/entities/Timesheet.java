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

@Entity
public class Timesheet {
	@Id
	@Column(name="TS_ID")
	@SequenceGenerator(name="TSID_SEQ", sequenceName="TSID_SEQ")
	@GeneratedValue(generator="TSID_SEQ", strategy=GenerationType.AUTO)
	private Integer timesheetid;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) // Remove Cascade
	@JoinColumn(name="AUTHOR_ID")
	private Users author;
	
	private Timestamp start_date;
	private Timestamp submitted_date;
	private Timestamp resolved_date;
	private Double hours_total;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="STATUS")
	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) // Remove Cascade
	@JoinColumn(name="RESOLVER_ID")
	private Users resolver;
	
	private String ts_comment;
	private Double sunday;
	private Double monday;
	private Double tuesday;
	private Double wednesday;
	private Double thursday;
	private Double friday;
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
		this.timesheetid = timesheetid;
		this.author = author;
		this.start_date = start_date;
		this.submitted_date = submitted_date;
		this.resolved_date = resolved_date;
		this.hours_total = hours_total;
		this.status = status;
		this.resolver = resolver;
		this.ts_comment = ts_comment;
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
		return "Timesheet [timesheetid=" + timesheetid + ", author=" + author.getUsername() + ", start_date=" + start_date
				+ ", submitted_date=" + submitted_date + ", resolved_date=" + resolved_date + ", hours_total="
				+ hours_total + ", status=" + status + ", resolver=" + resolver.getUsername() + ", ts_comment=" + ts_comment
				+ ", sunday=" + sunday + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((friday == null) ? 0 : friday.hashCode());
		result = prime * result + ((hours_total == null) ? 0 : hours_total.hashCode());
		result = prime * result + ((monday == null) ? 0 : monday.hashCode());
		result = prime * result + ((resolved_date == null) ? 0 : resolved_date.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((saturday == null) ? 0 : saturday.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted_date == null) ? 0 : submitted_date.hashCode());
		result = prime * result + ((sunday == null) ? 0 : sunday.hashCode());
		result = prime * result + ((thursday == null) ? 0 : thursday.hashCode());
		result = prime * result + ((timesheetid == null) ? 0 : timesheetid.hashCode());
		result = prime * result + ((ts_comment == null) ? 0 : ts_comment.hashCode());
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
		if (hours_total == null) {
			if (other.hours_total != null)
				return false;
		} else if (!hours_total.equals(other.hours_total))
			return false;
		if (monday == null) {
			if (other.monday != null)
				return false;
		} else if (!monday.equals(other.monday))
			return false;
		if (resolved_date == null) {
			if (other.resolved_date != null)
				return false;
		} else if (!resolved_date.equals(other.resolved_date))
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
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted_date == null) {
			if (other.submitted_date != null)
				return false;
		} else if (!submitted_date.equals(other.submitted_date))
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
		if (timesheetid == null) {
			if (other.timesheetid != null)
				return false;
		} else if (!timesheetid.equals(other.timesheetid))
			return false;
		if (ts_comment == null) {
			if (other.ts_comment != null)
				return false;
		} else if (!ts_comment.equals(other.ts_comment))
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
		return timesheetid;
	}
	public void setTimesheetid(Integer timesheetid) {
		this.timesheetid = timesheetid;
	}
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getSubmitted_date() {
		return submitted_date;
	}
	public void setSubmitted_date(Timestamp submitted_date) {
		this.submitted_date = submitted_date;
	}
	public Timestamp getResolved_date() {
		return resolved_date;
	}
	public void setResolved_date(Timestamp resolved_date) {
		this.resolved_date = resolved_date;
	}
	public Double getHours_total() {
		return hours_total;
	}
	public void setHours_total(Double hours_total) {
		this.hours_total = hours_total;
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
		return ts_comment;
	}
	public void setTs_comment(String ts_comment) {
		this.ts_comment = ts_comment;
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
