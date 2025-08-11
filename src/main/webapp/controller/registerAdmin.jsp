<%@page import="com.pharmacystore.daoimpl.AdminDaoImpl"%>
<%@page import="com.pharmacystore.dao.AdminDao"%>
	
	<jsp:useBean id="admin" 
		class="com.pharmacystore.pojo.Admin"
	 	scope="page">
	</jsp:useBean>
	
	<jsp:setProperty property="*" name="admin"/>
	
	<%
	System.out.println("UserID: " + admin.getUserid() + "<br>");
	System.out.println("Password: " + admin.getUserpassword() + "<br>");
		AdminDao daoImpl = new AdminDaoImpl();
		if(daoImpl.register(admin)) {
			response.sendRedirect("adminlogin.jsp?msg=adminRegSuccess");
		}
		else {			
			response.sendRedirect("adminregistration.jsp?msg=adminRegFail");
		}
	%>