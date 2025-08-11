package com.pharmacystore.dao;

import java.util.List;

import com.pharmacystore.pojo.Product;

public interface ProductDao {
	boolean addProduct(Product product);
	boolean deleteProduct(int productid);
	boolean updateProduct(Product product);
	List<Product> getAllProducts(int start,int total);
	List<Product> getAllProducts();
	Product searchProduct(int productid);
	boolean updateQuantityAfterOrder(int pid,int new_quantity);
	List<Product> displayProductCategoryWise(int categoryid);
	int getQuantityOfProduct(int pid);
	boolean updateQuantityAfterCancellation(int pid,int quantity);
}
