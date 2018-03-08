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

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.views.View;

@Entity
public class Users {
	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "USERID_SEQ", sequenceName = "USERID_SEQ")
	@GeneratedValue(generator = "USERID_SEQ", strategy = GenerationType.AUTO)
	@JsonView(View.UserInfo.class)
	private Integer userId;

	@JsonView(View.UserInfo.class)
	private String username;
	private String password;
	@Column(name="FIRST_NAME")
	@JsonView(View.Summary.class)
	private String firstName;
	@JsonView(View.Summary.class)
	@Column(name="LAST_NAME")
	private String lastName;
	@JsonView(View.UserInfo.class)
	private String userEmail;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ROLE")
	@JsonView(View.UserInfo.class)
	private UserRole role;

	@JsonView(View.UserInfo.class)
	private Double wage;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYER_ID")
	private Users employer;

	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	private Set<Users> subordinates = new HashSet<Users>();

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private Set<Timesheet> timesheets = new HashSet<Timesheet>();

	@OneToMany(mappedBy = "reimbAuthor", fetch = FetchType.LAZY)
	private Set<Reimbursement> reimbursements = new HashSet<Reimbursement>();

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private Set<AdvancePayment> advancePayments = new HashSet<AdvancePayment>();

	@JsonView(View.UserInfo.class)
	private Double debt;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int userid, String username, String password, String first_name, String last_name, String user_email,
			UserRole role, Double wage, Users employer_id, Double debt) {
		super();
		this.userId = userid;
		this.username = username;
		this.password = password;
		this.firstName = first_name;
		this.lastName = last_name;
		this.userEmail = user_email;
		this.role = role;
		this.wage = wage;
		this.employer = employer_id;
		this.debt = debt;
	}

	@Override
	public String toString() {
		// return "Users [userid=" + userid + ", username=" + username + ", password=" +
		// password + ", first_name="
		// + first_name + ", last_name=" + last_name + ", user_email=" + user_email + ",
		// user_role=" + role
		// + ", wage=" + wage + ", employer_id=" + ", debt=" + debt + "]";
		return "users tostring********************************";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debt == null) ? 0 : debt.hashCode());
		result = prime * result + ((employer == null) ? 0 : employer.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userId;
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId != other.userId)
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
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

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	}

	

}
