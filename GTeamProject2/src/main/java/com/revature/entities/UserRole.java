package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRole {
	@Id
	private Integer userRoleId;
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
	public int getUser_role_id() {
		return userRoleId;
	}
	public void setUser_role_id(int user_role_id) {
		this.userRoleId = user_role_id;
	}
	public String getUser_role() {
		return userRole;
	}
	public void setUser_role(String user_role) {
		this.userRole = user_role;
	}

}
