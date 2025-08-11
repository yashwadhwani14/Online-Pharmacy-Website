package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.AdminDao;
import com.pharmacystore.pojo.Admin;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean register(Admin admin) {
        try (Connection con = DbConnection.getDatabaseConnection()) {
            
            // Debugging: Print values
            System.out.println("Admin UserID: " + admin.getUserid());
            System.out.println("Admin Password: " + admin.getUserpassword());

            if (con == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            // FIXED: Explicitly specify columns
            PreparedStatement pst = con.prepareStatement("INSERT INTO admin (userid, userpassword) VALUES (?, ?)");

            pst.setString(1, admin.getUserid());
            pst.setString(2, admin.getUserpassword());

            int count = pst.executeUpdate();
            if(count>0)
            	return true;
            else
            	return false;

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkAdmin(Admin admin) {
        try (Connection con = DbConnection.getDatabaseConnection()) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            // FIXED: Add space before WHERE
            PreparedStatement pst = con.prepareStatement("SELECT * FROM admin "
            		+ "WHERE userid = ? AND userpassword = ?");
            pst.setString(1, admin.getUserid());
            pst.setString(2, admin.getUserpassword());

            ResultSet rs = pst.executeQuery();
            
        	if(rs.isBeforeFirst())
				return true;
			else
				return false;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
