<%@page import="com.pharmacystore.dao.ProductDao"%>
<%@page import="com.pharmacystore.pojo.Product"%>
<%@page import="com.pharmacystore.daoimpl.ProductDaoImpl"%>
<%@page import="com.pharmacystore.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean class="com.pharmacystore.pojo.Product" id="product" scope="page" ></jsp:useBean>
<jsp:setProperty property="*" name="product"/>

<%
System.out.println("productid " + product.getProductid() + "<br>");
System.out.println("productname " + product.getProductname()+ "<br>");
System.out.println("productprice " + product.getPrice() + "<br>");
System.out.println("productquantity " + product.getQuantity() + "<br>");
System.out.println("productdescr" + product.getDescription() + "<br>");
	if(!session.isNew() || session.getAttribute("ADMIN") != null)
	{	
		ProductDao daoImpl = new ProductDaoImpl();
	
		if(daoImpl.addProduct(product)){
			response.sendRedirect("adminhome.jsp?msg=productAddSuccess");
		}
		else
		{
			response.sendRedirect("additemtoproduct.jsp?msg=productAddFail");
		}
	}
%>

