package com.revature.entities;

public class Complaint {
	String complainant;
	String complainantAddr;
	String complainantMsg;
	public String getComplainant() {
		return complainant;
	}
	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}
	public String getComplainantAddr() {
		return complainantAddr;
	}
	public void setComplainantAddr(String complainantAddr) {
		this.complainantAddr = complainantAddr;
	}
	public String getComplainantMsg() {
		return complainantMsg;
	}
	public void setComplainantMsg(String complainantMsg) {
		this.complainantMsg = complainantMsg;
	}
	public Complaint(String complainant, String complainantAddr, String complainantMsg) {
		super();
		this.complainant = complainant;
		this.complainantAddr = complainantAddr;
		this.complainantMsg = complainantMsg;
	}
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
