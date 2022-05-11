package com.visual.ProyectoC2.entitys;

public class Suppliers {
	private String name;
	private String address;
	private String email;
	private int phoneNumber;
	private int productID;
	
	public Suppliers() {
		
	}
	
	public Suppliers(String name, String address, String email, int phoneNumber, int productID) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.productID = productID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	@Override
	public String toString() {
		return "Suppliers [name=" + name + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", productID=" + productID + "]";
	}
	
	
}
