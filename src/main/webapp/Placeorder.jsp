<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.pharmacystore.pojo.Product"%>
<%@page import="com.pharmacystore.daoimpl.OrderDaoImpl"%>
<%@page import="com.pharmacystore.dao.OrderDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.logging.Logger" %>
<%@page import="com.pharmacystore.pojo.Order"%>
<%@page import="com.pharmacystore.daoimpl.ProductDaoImpl"%>
<%@page import="com.pharmacystore.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
   prefix = "c" %>	

<%
   int productid = Integer.parseInt(request.getParameter("productid"));
   
   ProductDao pdaoImpl = new ProductDaoImpl();
   Product pr = pdaoImpl.searchProduct(productid);

   String customerid = (String) session.getAttribute("USER");
   int orderedunits = Integer.parseInt(request.getParameter("quantity"));
   String address = request.getParameter("address");
   Date ordereddate = Date.valueOf(LocalDate.now());
   // setting delivery date as 5 days after the ordered date
   Date requesteddate = Date.valueOf(LocalDate.now().plusDays(5));

   int price = pr.getPrice();   	
   int totalquantity = pr.getQuantity();   	
   int updatedq = totalquantity - orderedunits;	
   int billamount = (orderedunits) * (price);

   OrderDao odaoImpl = new OrderDaoImpl();
%>

<!-- Initialize Order Bean -->
<jsp:useBean id="order" class="com.pharmacystore.pojo.Order" scope="page" />

<!-- Set properties of the order bean -->
<jsp:setProperty name="order" property="customerid" value="<%= customerid %>" />
<jsp:setProperty name="order" property="productid" value="<%= productid %>" />
<jsp:setProperty name="order" property="orderedunits" value="<%= orderedunits %>" />
<jsp:setProperty name="order" property="address" value="<%= address %>" />
<jsp:setProperty name="order" property="ordereddate" value="<%= ordereddate %>" />
<jsp:setProperty name="order" property="requesteddate" value="<%= requesteddate %>" />
<jsp:setProperty name="order" property="accepted" value="true" />
<jsp:setProperty name="order" property="cancelled" value="false" />
<jsp:setProperty name="order" property="confirmed" value="true" />
<jsp:setProperty name="order" property="billamount" value="<%= billamount %>" />

<%
   if(orderedunits < totalquantity) {
	   System.out.println("customerid" + order.getCustomerid() +"<br>");
	   System.out.println("productid" + order.getProductid() +"<br>");
	   System.out.println("orderedunit" + order.getOrderedunits() +"<br>");
	   System.out.println("address" + order.getAddress() +"<br>");
	   System.out.println("ordereddate" + order.getOrdereddate() +"<br>");
	   System.out.println("requesteddate" + order.getRequesteddate() +"<br>");
	   System.out.println("billamount" + order.getBillamount() +"<br>");
	        if(odaoImpl.placeOrder(order)) {
           // Update product quantity after placing the order
           pdaoImpl.updateQuantityAfterOrder(productid, updatedq);
           out.print("success");
       } else {
           out.print("failure");
       }
   } else {
       out.print("lessquantity");
   }
%>
