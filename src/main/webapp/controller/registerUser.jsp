<%@page import="com.pharmacystore.dao.UserDao"%>
<%@page import="com.pharmacystore.daoimpl.UserDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	<jsp:useBean id="user" 
	class="com.pharmacystore.pojo.User" scope="page">
	</jsp:useBean>
	
	<jsp:setProperty property="*" name="user"/>
	
	<%
	    System.out.println("userid" + user.getUserid() +"<br>");
	System.out.println("userpass" + user.getUserpassword() +"<br>");
	System.out.println("email" + user.getEmailid()+"<br>");
	System.out.println("age" + user.getAge() +"<br>");
	System.out.println("contact" + user.getContact() +"<br>");
	System.out.println("city" + user.getCity() +"<br>");
	System.out.println("state" + user.getState() +"<br>");
	System.out.println("pincode" + user.getPincode() +"<br>");
		UserDao daoImpl = new UserDaoImpl();
		if(daoImpl.register(user)) {
			response.sendRedirect("userlogin.jsp?msg=userRegistrationSuccess");		
		}
		else {
			response.sendRedirect("userregistration.jsp?msg=userRegFail");
		}
	%>