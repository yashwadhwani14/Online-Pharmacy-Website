package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.OrderDao;
import com.pharmacystore.pojo.Order;

public class OrderDaoImpl implements OrderDao {
	public boolean placeOrder(Order order) {
		try (Connection con = DbConnection.getDatabaseConnection()) {
			PreparedStatement pst = con
					.prepareStatement("INSERT INTO productorder(orderedunits, address,"
							+ " ordereddate, requesteddate, accepted, cancelled, "
							+ "confirmed, billamount, customerid, productid)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
					

			pst.setInt(1, order.getOrderedunits());
			pst.setString(2, order.getAddress());
			pst.setDate(3, order.getOrdereddate());
			pst.setDate(4, order.getRequesteddate());
			pst.setBoolean(5, true);
			pst.setBoolean(6, false);
			pst.setBoolean(7, false);
			pst.setInt(8, order.getBillamount());
			pst.setString(9, order.getCustomerid());
			pst.setInt(10, order.getProductid());

			int count = pst.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Order> getAllOrders() {
		List<Order> orderList = new ArrayList<>();
		try (Connection con = DbConnection.getDatabaseConnection()) {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM productorder");

			ResultSet rs = pst.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Order order = new Order();
					order.setOrderid(rs.getInt("orderid"));
					order.setOrderedunits(rs.getInt("orderedunits"));
					order.setAddress(rs.getString("address"));
					order.setOrdereddate(rs.getDate("ordereddate"));
					order.setRequesteddate(rs.getDate("requesteddate"));
					order.setAccepted(rs.getBoolean("accepted"));
					order.setCancelled(rs.getBoolean("cancelled"));
					order.setConfirmed(rs.getBoolean("confirmed"));
					order.setBillamount(rs.getInt("billamount"));
					order.setCustomerid(rs.getString("customerid"));
					order.setProductid(rs.getInt("product"));

					orderList.add(order);
				}
				return orderList;
			} else
				return orderList;

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			orderList.clear();
			return orderList;
		}
	}

	public List<Order> getAllUnconfirmedOrders() {
		List<Order> orderList = new ArrayList<>();

		try (Connection con = DbConnection.getDatabaseConnection()) {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM productorder " + "WHERE accepted =true "
					+ "and cancelled = false and confirmed = false");

			ResultSet rs = pst.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Order order = new Order();

					order.setOrderid(rs.getInt("orderid"));
					order.setOrderedunits(rs.getInt("orderedunits"));
					order.setAddress(rs.getString("address"));
					order.setOrdereddate(rs.getDate("ordereddate"));
					order.setRequesteddate(rs.getDate("requesteddate"));
					order.setAccepted(rs.getBoolean("accepted"));
					order.setCancelled(rs.getBoolean("cancelled"));
					order.setConfirmed(rs.getBoolean("confirmed"));
					order.setBillamount(rs.getInt("billamount"));
					order.setCustomerid(rs.getString("customerid"));
					order.setProductid(rs.getInt("productid"));

					orderList.add(order);
				}
				return orderList;
			} else
				return orderList;

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			orderList.clear();
			return orderList;
		}
	}

	public Order searchOrder(int orderid) {
		Order order = null;

		try (Connection con = DbConnection.getDatabaseConnection()) {

			PreparedStatement pst = con.prepareStatement("SELECT * " + "FROM productorder " + "WHERE orderid = ?");
			pst.setInt(1, orderid);

			ResultSet rs = pst.executeQuery();

			if (rs.isBeforeFirst()) {
				rs.next();

				order = new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setOrderedunits(rs.getInt("orderdunits"));
				order.setAddress(rs.getString("address"));
				order.setOrdereddate(rs.getDate("ordereddate"));
				order.setRequesteddate(rs.getDate("requesteddate"));
				order.setAccepted(rs.getBoolean("accepted"));
				order.setCancelled(rs.getBoolean("cancelled"));
				order.setConfirmed(rs.getBoolean("confirmed"));
				order.setBillamount(rs.getInt("billamount"));
				order.setCustomerid(rs.getString("customerid"));
				order.setProductid(rs.getInt("productid"));
			}

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		return order;
	}

	public boolean changeOrderStatusToConfirmed(int orderid) {
		boolean status = false;
		try (Connection con = DbConnection.getDatabaseConnection()) {

			PreparedStatement pst = con
					.prepareStatement("UPDATE productorder SET " 
			+ "confirmed = TRUE WHERE orderid = ?");

			pst.setInt(1, orderid);
			int count = pst.executeUpdate();

			if (count > 0)
				status = true;

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return status;
	}

	public boolean changeOrderStatusToRejected(int orderid) {
		boolean status = false;
		try (Connection con = DbConnection.getDatabaseConnection()) {
			PreparedStatement pst = con
					.prepareStatement("UPDATE productorder SET " + 
			"accepted = false WHERE orderid=?");
			pst.setInt(1, orderid);
			int count = pst.executeUpdate();
			if (count > 0)
				status = true;
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return status;
	}

	public boolean changeOrderStatusToCancelled(int orderid) {
		boolean status = false;
		try (Connection con = DbConnection.getDatabaseConnection()) {
			PreparedStatement pst = con.prepareStatement("UPDATE productorder "
					+ "SET cancelled = true "
					+ "WHERE orderid = ?");
			pst.setInt(1, orderid);
			int count = pst.executeUpdate();
			if(count>0)
				status = true;
		} catch (SQLException |NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return status;
	}
	public List<Order> getAllOrdersForUser(String customerid){
		List<Order> orderList = new ArrayList<>();
		try (Connection con = DbConnection.getDatabaseConnection()) 
		{
			PreparedStatement pst = con.prepareStatement("SELECT * FROM " 
					+ " productorder WHERE customerid = ?");

			pst.setString(1, customerid);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.isBeforeFirst()) {
				while(rs.next()) {
					Order order = new Order();
					order.setOrderid(rs.getInt("orderid"));
					order.setOrderedunits(rs.getInt("orderedunits"));
					order.setAddress(rs.getString("address"));
					order.setOrdereddate(rs.getDate("ordereddate"));
					order.setRequesteddate(rs.getDate("requesteddate"));
					order.setAccepted(rs.getBoolean("accepted"));
					order.setCancelled(rs.getBoolean("cancelled"));
					order.setConfirmed(rs.getBoolean("confirmed"));
					order.setBillamount(rs.getInt("billamount"));
					order.setCustomerid(rs.getString("customerid"));
					order.setProductid(rs.getInt("productid"));
					orderList.add(order);
				}
			}
			
		} catch (SQLException |NullPointerException e) {
			e.printStackTrace();
			orderList.clear();
			return orderList;
		}
		return orderList;
	}
	public boolean updateOrderAddress(int orderid, String address) {
		boolean status = false;
		try (Connection con = DbConnection.getDatabaseConnection()) 
		{
			
			PreparedStatement pst = con.prepareStatement("UPDATE productorder SET address = ? " 
					+ " WHERE orderid = ?");
			
			pst.setString(1, address);
			pst.setInt(2, orderid);
			
			int count = pst.executeUpdate();
			
			if(count>0) 
				status = true;
			
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return status;
		}
		return status;
	}
	public 	int[] getProductDetailsFromOrderId(Order order) {
		int[] product = new int[2];
		try(Connection con = DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = con.prepareStatement("SELECT * FROM product"
					+ " WHERE productid =?");
			
			pst.setInt(1, order.getProductid());
			
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					product[0] = rs.getInt("productid");
					product[1] = rs.getInt("quantity");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	public boolean getStatus(int orderid) {
		boolean status = false;
		try (Connection con = DbConnection.getDatabaseConnection()) 
		{
			
			PreparedStatement pst = con.prepareStatement("SELECT cancelled FROM productorder"
					+ "WHERE orderid = ?");
			pst.setInt(1, orderid);
			
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					status = rs.getBoolean("cancelled");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		 return status;
	}
	public List<Order> displayMyCancelledOrders(String userid){
		List<Order> orderList = new ArrayList<>();
		
		try (Connection con = DbConnection.getDatabaseConnection()) 
		{
			
			PreparedStatement pst = con.prepareStatement(" " 
					+ "SELECT * FROM productorder "
					+ "WHERE customerid = ? AND "
					+ "cancelled = true AND confirmed = true "
					+ "AND accepted = true");
			pst.setString(1, userid);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Order order = new Order();
					
					order.setOrderid(rs.getInt("orderid"));
					order.setOrderedunits(rs.getInt("orderedunits"));
					order.setAddress(rs.getString("address"));
					order.setOrdereddate(rs.getDate("ordereddate"));
					order.setRequesteddate(rs.getDate("requesteddate"));
					order.setAccepted(rs.getBoolean("accepted"));
					order.setConfirmed(rs.getBoolean("confirmed"));
					order.setCancelled(rs.getBoolean("cancelled"));
					order.setBillamount(rs.getInt("billamount"));
					order.setCustomerid(rs.getString("customerid"));
					order.setProductid(rs.getInt("productid"));
					
					orderList.add(order);
				}
			}
			return orderList;
			
		} catch (SQLException |NullPointerException e) {
			e.printStackTrace();
			orderList.clear();
			return orderList;
		}
	}
	public List<Order> displayMyConfirmedOrders(String userid){
		List<Order> orderList = new ArrayList<>();
		
		try (Connection con = DbConnection.getDatabaseConnection()) 
		{
			
			PreparedStatement pst = con.prepareStatement("SELECT * FROM productorder WHERE "
					+ "customerid = ? AND cancelled = false AND "
					+ " confirmed = true AND accepted = true");
			pst.setString(1, userid);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Order order = new Order();
					
					order.setOrderid(rs.getInt("orderid"));
					order.setOrderedunits(rs.getInt("orderedunits"));
					order.setAddress(rs.getString("address"));
					order.setOrdereddate(rs.getDate("ordereddate"));
					order.setRequesteddate(rs.getDate("requesteddate"));
					order.setAccepted(rs.getBoolean("accepted"));
					order.setConfirmed(rs.getBoolean("confirmed"));
					order.setCancelled(rs.getBoolean("cancelled"));
					order.setBillamount(rs.getInt("billamount"));
					order.setCustomerid(rs.getString("customerid"));
					order.setProductid(rs.getInt("productid"));
					
					orderList.add(order);
				}
			}
			return orderList;
			
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			orderList.clear();
			return orderList;
		}
	}
}

