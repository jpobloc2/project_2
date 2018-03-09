package com.revature.entities;

public class ResolveCredentials {
	private int userId;
	private int roleId;
	private int itemId;
	private String resolution;
	public ResolveCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResolveCredentials(int userId, int roleId, int itemId, String resolution) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.itemId = itemId;
		this.resolution = resolution;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
		result = prime * result + roleId;
		result = prime * result + userId;
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
		ResolveCredentials other = (ResolveCredentials) obj;
		if (itemId != other.itemId)
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		if (roleId != other.roleId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResolveCredentials [userId=" + userId + ", roleId=" + roleId + ", itemId=" + itemId + ", resolution="
				+ resolution + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	
}
