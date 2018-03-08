package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATUS_TABLE")
public class Status {
	@Id
	private Integer statusId;
	private String status;
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int status_id, String status) {
		super();
		this.statusId = status_id;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Status [status_id=" + statusId + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusId;
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
		Status other = (Status) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusId != other.statusId)
			return false;
		return true;
	}
	public int getStatus_id() {
		return statusId;
	}
	public void setStatus_id(int status_id) {
		this.statusId = status_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
