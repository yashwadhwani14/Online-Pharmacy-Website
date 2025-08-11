<%@page import="com.pharmacystore.daoimpl.OrderDaoImpl"%>
<%@page import="com.pharmacystore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%
	int oid = Integer.parseInt(request.getParameter("orderid"));
	OrderDao daoImpl = new OrderDaoImpl();
	
	if(daoImpl.changeOrderStatusToConfirmed(oid))
	{
		response.sendRedirect("adminhome.jsp?msg=confirmSuccess");
	}else{
		response.sendRedirect("vieworders.jsp?msg=confirmFail");
	}
	%>
