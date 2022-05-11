package com.visual.ProyectoC2.entitys;

public class Category {
	private String name;
	private int productID;
	
	public Category() {
		
	}
	
	public Category(String name, int productID) {
		super();
		this.name = name;
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", productID=" + productID + "]";
	}
	
	
}
