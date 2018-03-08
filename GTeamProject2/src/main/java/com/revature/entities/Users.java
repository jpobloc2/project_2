package com.revature.entities;

import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.revature.views.View;

@Entity
public class Users {
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="USERID_SEQ", sequenceName="USERID_SEQ")
	@GeneratedValue(generator="USERID_SEQ", strategy=GenerationType.AUTO)
	private Integer userid;
	
	private String username;
	private String password;
	@JsonView(View.Summary.class)
	private String first_name;
	@JsonView(View.Summary.class)
	private String last_name;
	private String user_email;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ROLE")
	private UserRole role;
	
	private Double wage;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="EMPLOYER_ID")
	@JsonIgnore
	private Users employer;

	@OneToMany(mappedBy="employer", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Users> subordinates = new HashSet<Users>();
	
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY)
	@JsonIgnore	
	private Set<Timesheet> timesheets = new HashSet<Timesheet>();
	
	@OneToMany(mappedBy="reimb_author", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Reimbursement> reimbursements = new HashSet<Reimbursement>();
	
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<AdvancePayment> advancePayments = new HashSet<AdvancePayment>();
	
	private Double debt;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userid, String username, String password, String first_name, String last_name, String user_email,
			UserRole role, Double wage, Users employer_id, Double debt) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.role = role;
		this.wage = wage;
		this.employer = employer_id;
		this.debt = debt;
	}
	@Override
	public String toString() {
//		return "Users [userid=" + userid + ", username=" + username + ", password=" + password + ", first_name="
//				+ first_name + ", last_name=" + last_name + ", user_email=" + user_email + ", user_role=" + role
//				+ ", wage=" + wage + ", employer_id=" + ", debt=" + debt + "]";
		return "users tostring********************************";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debt == null) ? 0 : debt.hashCode());
		result = prime * result + ((employer == null) ? 0 : employer.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((wage == null) ? 0 : wage.hashCode());
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
		Users other = (Users) obj;
		if (debt == null) {
			if (other.debt != null)
				return false;
		} else if (!debt.equals(other.debt))
			return false;
		if (employer == null) {
			if (other.employer != null)
				return false;
		} else if (!employer.equals(other.employer))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (wage == null) {
			if (other.wage != null)
				return false;
		} else if (!wage.equals(other.wage))
			return false;
		return true;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public UserRole getUser_role() {
		return role;
	}
	public void setUser_role(String user_role) {
		this.role = role;
	}
	public Double getWage() {
		return wage;
	}
	public void setWage(Double wage) {
		this.wage = wage;
	}
	public Users getEmployer_id() {
		return employer;
	}
	public void setEmployer_id(Users employer_id) {
		this.employer = employer_id;
	}
	public Double getDebt() {
		return debt;
	}
	public void setDebt(Double debt) {
		this.debt = debt;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public Users getEmployer() {
		return employer;
	}
	public void setEmployer(Users employer) {
		this.employer = employer;
	}
	public Set<Users> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(Set<Users> subordinates) {
		this.subordinates = subordinates;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}
	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	public Set<Reimbursement> getReimbursements() {
		return reimbursements;
	}
	public void setReimbursements(Set<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}
	public Set<AdvancePayment> getAdvancePayments() {
		return advancePayments;
	}
	public void setAdvancePayments(Set<AdvancePayment> advancePayments) {
		this.advancePayments = advancePayments;
	}
	
	
	
	
}
