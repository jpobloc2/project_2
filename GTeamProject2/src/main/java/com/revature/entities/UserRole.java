package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.views.View;

@Entity
@Table(name = "USER_ROLES")
public class UserRole {
	@Id
	@JsonView(View.UserInfo.class)
	private Integer userRoleId;
	@JsonView(View.UserInfo.class)
	private String userRole;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(int user_role_id, String user_role) {
		super();
		this.userRoleId = user_role_id;
		this.userRole = user_role;
	}

	@Override
	public String toString() {
		return "UserRole [user_role_id=" + userRoleId + ", user_role=" + userRole + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + userRoleId;
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
		UserRole other = (UserRole) obj;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
