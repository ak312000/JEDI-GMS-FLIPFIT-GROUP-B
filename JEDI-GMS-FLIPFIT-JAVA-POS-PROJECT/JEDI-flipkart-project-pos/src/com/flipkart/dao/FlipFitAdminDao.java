package com.flipkart.dao;

import com.flipkart.bean.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDao implements AdminDaoInterface{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/FlipFitApplicationSchema";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "7507516072@Ss";
    static List<Admin> admins = new ArrayList<>();

    public void add(Admin admin) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            // Step 3 Regiater Driver here and create connection

            Class.forName("com.mysql.jdbc.Driver");

            // Step 4 make/open  a connection

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String sql = "insert into admin(admin_name,admin_email_address,admin_phone_number,admin_password) values(?,?,?,?)";
            //String sql = "UPDATE Employees set age=? WHERE id=?";
            // String sql1="delete from employee where id=?";
            // stmt.setInt(1, 101);
            stmt = conn.prepareStatement(sql);

            // Hard coded data


            String name = admin.getAdminName();
            String address = admin.getAdminEmailAddress();
            String phone = admin.getAdminPhone();
            String password = admin.getPassword();
//            String location="india";
            //Bind values into the parameters.
            stmt.setString(1, name);  // This would set age
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.setString(4,password);
//            stmt.setString(4, location);
            stmt.executeUpdate();


        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        admins.add(admin);
        System.out.println("Admin added successfully");
    }

    public List<Admin> getAllAdmins() {
        // Your database logic to fetch all admins goes here
        // For example, you might use JDBC or an ORM framework

        // For demonstration purposes, let's create a sample list of admins
        if(admins.isEmpty()){
            System.out.println("It is empty");
        }
        return admins;
    }
}
