package Com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import Com.DB.DbConfig;
import Com.admin.model.*;

public class ConsumerDAO {
	
	private static final String UPDATE_RATE = "UPDATE ratedetails SET DomRate = ?,CommRate = ? WHERE id = ?";

	private static final String SELECT_CONSUMER = "SELECT * from consumerdetails where consumerId like '1%'";

	public int UpdateRate(Rate Rate) {
	        try (
	        		Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RATE)) {

	            preparedStatement.setDouble( 1,Rate.getDomRate());
	            preparedStatement.setDouble(2, Rate.getCommRate());
	            preparedStatement.setDouble(3, 1);


	            preparedStatement.executeUpdate();

	        } catch (Exception e) {
            e.printStackTrace(); // Handle this exception properly in a real-world scenario
            return 0;
	        }
			return 0;
	    }

	public static void main(String []args) {
		ConsumerDAO c =new ConsumerDAO();		
		c.SelectConsumer(1);
		 ar.get(0);
	 System.out.println(c.SelectConsumer(1).get(0));
		 System.out.println(c.SelectConsumer(1).get(1));
//		 System.out.println(c.SelectConsumer(1).get(2));
//		 System.out.println(c.SelectConsumer(1).get(3));
//		 System.out.println(c.SelectConsumer(1).get(4));
	}
	public static ArrayList ar ;
	public ArrayList SelectConsumer(int comId) {
		
		 ar = new ArrayList();
	        try  {
	        	
	        	Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from consumerdetails where consumerId like '"+comId+"%'");
	             
	             try (ResultSet resultSet =preparedStatement.executeQuery()) {
	                    while (resultSet.next()) {
	                        int id = resultSet.getInt("consumerId");
	                        //String name = resultSet.getString("name");
	                        if(id==comId) {
	                        	ar.add(id);
	                        	ar.add(resultSet.getString("name"));
	                        	ar.add(resultSet.getInt("passbook"));
	                        	ar.add(resultSet.getInt("adhar_no"));
	                        	ar.add(resultSet.getInt("rationcard"));
	                        	ar.add(resultSet.getString("gender"));
	                        	ar.add(resultSet.getString("address"));
	                        	ar.add(resultSet.getInt("pincode"));
	                        	ar.add(resultSet.getInt("phone"));
	                        	ar.add(resultSet.getDate("DOB"));
	                        	ar.add(resultSet.getDate("DOB"));
	                        	ar.add(resultSet.getString("c_type"));
	                        	ar.add(resultSet.getInt("no_of_cylinder"));
	                        	return ar;
	                        }
	                        else {
	                        	return ar;
	                        }	                        	                      
	                    }

	        }
	             catch (Exception e) {
	            e.printStackTrace(); // Handle this exception properly in a real-world scenario
	        }
	             return ar;
	    } catch (Exception e1) {
			// TODO Auto-generated catch block	    	
			e1.printStackTrace();
		}
	        return ar;
	}

	public static int ar(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getLastIdFromDatabase() {
        int lastId = 0;

        try {
            // Create a PreparedStatement to execute a SQL query
        	String sql = "SELECT MAX(consumerId) as last_id FROM consumerdetails";
        	Connection connection =  DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
         
                // Execute the query
                try (ResultSet resultSet =preparedStatement.executeQuery()) {
                    // Check if there is a result
                    if (resultSet.next()) {
                        // Retrieve the last ID from the result set
                        lastId = resultSet.getInt("last_id");
                    }
                }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's requirements
        }

        return lastId;
    }

	public boolean deleteConsumerById(int id) {
        boolean success = false;

        try {
            // Create a PreparedStatement to execute a SQL query
            String sql = "DELETE FROM consumerdetails WHERE consumerId = ?";
        	Connection connection =  DbConfig.getConnection();
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
                // Set the ID parameter in the query
            	preparedStatement.setInt(1, id);

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if the deletion was successful
                success = rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's requirements
        }

        return success;
    }
	public boolean isIdPresent(int id) {
        boolean result = false;
        String sql = "SELECT COUNT(*) FROM consumerdetails WHERE consumerId = ?";
        Connection connection =  DbConfig.getConnection();
       
           
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql))
             {
            	preparedStatement.setInt(1, id);

                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check the result
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        result = count > 0;
                    }
                }
            }
         catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        
        }
        return result;
    }
}
