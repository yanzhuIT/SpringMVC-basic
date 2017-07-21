package com.github.entities;

public class Address {
	
	private String state;
	private String county;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", county=" + county + "]";
	}
	
	
	

}
