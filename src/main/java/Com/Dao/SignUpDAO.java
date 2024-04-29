package Com.Dao;
import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Com.DB.*;


import Com.DB.DbConfig;
import Com.Servlet.loginServlet;
import Com.admin.model.*;
import java.sql.Connection;
public class SignUpDAO {
	private static String Driver1 = "com.mysql.cj.jdbc.Driver";
	

	// Add your database connection details here
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/gascylinder";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "admin@123";
	

	// SQL queries
	// private static final String SELECT_ALL_RATES = "SELECT * FROM ratedetails";
	private static final String UPDATE_RATE = "UPDATE ratedetails SET DommRate = ?,CommRate = ? WHERE id = ?";
	private static final String Insert_admin = "INSERT INTO admin VALUES (?,?,?,?,?,?)";

	private static final String SELECT = "SELECT * from admin";

	public int signup(admin admin) {
	        try (
	        		Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(Insert_admin)) {
	        	
	            preparedStatement.setInt( 1,admin.getA_id());
	            preparedStatement.setString(2, admin.getName());
	            preparedStatement.setString(3, admin.getAddress());
	            preparedStatement.setLong(4, admin.getPhone());
	            preparedStatement.setString(5, admin.getEmail());
	            preparedStatement.setString(6, admin.getPassword());
	            
	            preparedStatement.executeUpdate();

	        } catch (Exception e) {
            e.printStackTrace(); // Handle this exception properly in a real-world scenario
            return 0;
	        }
			return 0;
	    }

	public boolean Select(String uname,String upassword) {
	        try  {
	        	
	        	Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
	             //Statement statement = connection.createStatement();
	            
	             ResultSet resultSet =preparedStatement.executeQuery();
	                   while (resultSet.next()) {
	                        String name = resultSet.getString("a_name");
	                        String  password = resultSet.getString("a_password");
	                       
	                        if (uname.equals(name) && upassword.equals(password)) {
	                            // Valid user found
	                       	
	                            return true;  
	                        }
	                       
	                    }
	                   resultSet.close();
	                   preparedStatement.close();
	            	 connection.close();    
	            	 return false;
	               
	    } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	      
	}

}
