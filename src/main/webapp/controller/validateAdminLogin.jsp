<%@page import="com.pharmacystore.pojo.Admin"%>
<%@page import="com.pharmacystore.daoimpl.AdminDaoImpl"%>
<%@page import="com.pharmacystore.dao.AdminDao"%>
<jsp:useBean id="admin" 
	class="com.pharmacystore.pojo.Admin" scope="page"> 
</jsp:useBean>
<jsp:setProperty property="*" name="admin"/>

<%
System.out.println("UserID: " + admin.getUserid() + "<br>");
System.out.println("Password: " + admin.getUserpassword() + "<br>");
		AdminDao daoImpl = new AdminDaoImpl();
		if(daoImpl.checkAdmin(admin)){
			session.setAttribute("ADMIN", admin.getUserid());
			response.sendRedirect("adminhome.jsp");
		}
		else{
			response.sendRedirect("adminlogin.jsp?msg=adminLoginError");
		}	
%>