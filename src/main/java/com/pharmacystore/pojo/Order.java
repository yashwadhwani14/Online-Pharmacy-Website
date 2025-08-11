package com.pharmacystore.pojo;

import java.sql.Date;

public class Order {
	private int orderid;
	private int orderedunits;
	private String address;
	private Date ordereddate;
	private Date requesteddate;
	private boolean accepted;
	private boolean cancelled;
	private boolean confirmed;
	private int billamount;
	private String customerid;
	private int productid;

	public Order() {

	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getOrderedunits() {
		return orderedunits;
	}

	public void setOrderedunits(int orderedunits) {
		this.orderedunits = orderedunits;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOrdereddate() {
		return ordereddate;
	}

	public void setOrdereddate(Date orderdate) {
		this.ordereddate = orderdate;
	}

	public Date getRequesteddate() {
		return requesteddate;
	}

	public void setRequesteddate(Date requesteddate) {
		this.requesteddate = requesteddate;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getBillamount() {
		return billamount;
	}

	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}
}
