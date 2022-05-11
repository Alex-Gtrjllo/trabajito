package com.visual.ProyectoC2.entitys;

import java.sql.Timestamp;

public class Sell {
	private int sellID;
	private Timestamp fecha;
	private int productID;
	private String productName;
	private Float productPrice;
	private int stock;
	private String codigo;
	private int userID;
	
	public Sell() {
		
	}

	public Sell(int sellID, Timestamp fecha, int productID, String productName, Float productPrice, int stock,
			String codigo, int userID) {
		super();
		this.sellID = sellID;
		this.fecha = fecha;
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.stock = stock;
		this.codigo = codigo;
		this.userID = userID;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
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
		return "Sell [sellID=" + sellID + ", fecha=" + fecha + ", productID=" + productID + ", productName="
				+ productName + ", productPrice=" + productPrice + ", stock=" + stock + ", codigo=" + codigo
				+ ", userID=" + userID + "]";
	}
	
}
