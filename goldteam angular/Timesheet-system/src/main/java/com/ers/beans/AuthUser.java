package com.ers.beans;

public class AuthUser {
	protected int id;
	protected int manager;

	public AuthUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthUser(int id, int manager) {
		super();
		this.id = id;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + manager;
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
		AuthUser other = (AuthUser) obj;
		if (id != other.id)
			return false;
		if (manager != other.manager)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthUser [id=" + id + ", manager=" + manager + "]";
	}

}
