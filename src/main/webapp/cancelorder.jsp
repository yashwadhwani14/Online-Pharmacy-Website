<%@page import="com.pharmacystore.daoimpl.OrderDaoImpl"%>
<%@page import="com.pharmacystore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%
	int oid = Integer.parseInt(request.getParameter("orderid"));
	OrderDao daoImpl = new OrderDaoImpl();
	
	if(daoImpl.changeOrderStatusToCancelled(oid))
	{
		out.print("success");
	}else{
		out.print("failure");
	}
	%>
