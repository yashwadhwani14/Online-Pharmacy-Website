package com.pharmacystore.connection;

import java.sql.Connection;

public class TestDbConnection {
    public static void main(String[] args) {
        Connection con = DbConnection.getDatabaseConnection();
        if (con != null) {
            System.out.println("Database Connection Successful!");
        } else {
            System.out.println("Database Connection Failed!");
        }
    }
}