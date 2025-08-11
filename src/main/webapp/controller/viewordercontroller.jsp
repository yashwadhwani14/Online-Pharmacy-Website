<%@page import="com.pharmacystore.pojo.User"%>
<%@page import="com.pharmacystore.pojo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.pharmacystore.dao.OrderDao"%>
<%@page import="com.pharmacystore.daoimpl.OrderDaoImpl"%>
<%
	OrderDao odao = new OrderDaoImpl();
	
	List<Order> lst = odao.getAllUnconfirmedOrders();
	application.setAttribute("UNCONFIRMEDORDERLIST",
			lst);
	response.sendRedirect("vieworders.jsp");
%>