package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.CategoryDao;
import com.pharmacystore.pojo.Category;

public class CategoryDaoImpl implements CategoryDao {

	public boolean addCategory(Category category) {
		try (Connection con = DbConnection.getDatabaseConnection()) {

			PreparedStatement pst = con.prepareStatement("INSERT INTO category" 
			+ " (categoryname) VALUES(?)");

			pst.setString(1, category.getCategoryname());

			int count = pst.executeUpdate();

			if (count > 0)
				return true;
			else
				return false;

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(int catid) {

		try (Connection con = DbConnection.getDatabaseConnection()) {

			PreparedStatement pst = con.prepareStatement("DELETE FROM category "
					+ "WHERE categoryid = ?");

			pst.setInt(1, catid);

			int count = pst.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Category> getAllCategories() {
		List<Category> lst = new ArrayList<>();

		try (Connection con = DbConnection.getDatabaseConnection()) {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM category");

			ResultSet rs = pst.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Category obj = new Category();
					obj.setCategoryid(rs.getInt("categoryid"));
					obj.setCategoryname(rs.getString("categoryname"));
					lst.add(obj);
				}
				return lst;
			} else
				return lst;

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
	}
}