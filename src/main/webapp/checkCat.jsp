<%@page import="com.pharmacystore.daoimpl.CategoryDaoImpl"%>
<%@page import="com.pharmacystore.dao.CategoryDao"%>
<%@page import="com.pharmacystore.pojo.Category"%>

<%
    // Get the category name from the request body
    String catName = request.getParameter("categoryName");

    if (catName == null || catName.trim().isEmpty()) {
        out.print("failure");
        return;
    }

    Category category = new Category();
    category.setCategoryname(catName);

    CategoryDao daoImpl = new CategoryDaoImpl();
    
    if(daoImpl.addCategory(category)){
        out.print("success");
    } else {
        out.print("failure");
    }
%>
