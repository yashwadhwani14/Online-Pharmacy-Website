package com.pharmacystore.dao;

import java.util.List;

import com.pharmacystore.pojo.Order;

public interface OrderDao {
	boolean placeOrder(Order order);
	List<Order> getAllOrders();
	List<Order> getAllUnconfirmedOrders();
	Order searchOrder(int orderid);
	boolean changeOrderStatusToConfirmed(int orderid);
	boolean changeOrderStatusToRejected(int orderid);
	boolean changeOrderStatusToCancelled(int orderid);
	List<Order> getAllOrdersForUser(String customerid);
	boolean updateOrderAddress(int orderid, String address);
	int[] getProductDetailsFromOrderId(Order order);
	boolean getStatus(int orderid);
	List<Order> displayMyCancelledOrders(String userid);
	List<Order> displayMyConfirmedOrders(String userid);
}
