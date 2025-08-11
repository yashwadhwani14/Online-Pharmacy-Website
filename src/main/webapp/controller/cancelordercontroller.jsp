<%@page import="com.pharmacystore.daoimpl.OrderDaoImpl"%>
<%@page import="com.pharmacystore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
int oid = 0;
try {
    oid = Integer.parseInt(request.getParameter("orderid"));
} catch (NumberFormatException e) {
    out.print("Invalid Order ID.");
    return;
}

OrderDao daoImpl = new OrderDaoImpl();
if (daoImpl.changeOrderStatusToCancelled(oid)) {
    out.print("success");
} else {
    out.print("failure");
}
%>
