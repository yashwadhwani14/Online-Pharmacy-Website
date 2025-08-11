<%@page import="com.pharmacystore.daoimpl.OrderDaoImpl"%>
<%@page import="com.pharmacystore.dao.OrderDao"%>
<%@page import="com.pharmacystore.pojo.User"%>
<%@page import="com.pharmacystore.pojo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.pharmacystore.dao.UserDao"%>
<%
	String uid = (String) session.getAttribute("USER");
	
	OrderDao daoImpl = new OrderDaoImpl();
	
	List<Order> lst = 
			daoImpl.displayMyConfirmedOrders(uid);
	
	application.setAttribute("CONFIRMORDERLIST", lst);
	response.sendRedirect("confirmedorders.jsp");
%>