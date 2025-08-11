package com.pharmacystore.pojo;

public class Product {
	private int productid;
	private String productname;
	private int price;
	private int quantity;
	private String description;
	private int categoryid;

	public Product() {

	}

	public Product(int productid, String productname, int price, int quantity, String description, int categoryid) {
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.categoryid = categoryid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
}
