package com.visual.ProyectoC2.entitys;

public class Product {
	
	private int productID;
	private String name;
	private float price;
	private int stock;
	private String codigo;
	private int userID;
	
	public Product() {
		
	}
	
	public Product(int productID, String name, float price, int stock, String codigo, int userID) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.codigo = codigo;
		this.userID = userID;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", codigo=" + codigo + ", userID=" + userID + "]";
	}
	
	
	
	
}
