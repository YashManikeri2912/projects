package Com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Com.DB.DbConfig;
import Com.admin.model.Booking;
import Com.admin.model.Stock;

public class BookingDAO {

	private static final String Insert_BOOKING= "insert bookingdetails SET bookingId=?,consumerId = ?,cylinder_type = ?, bookingdate = ?, no_of_cylinder = ?";
	private static final String Insert_Bill= "UPDATE bookingdetails SET diliverydate = ?,totalamt = ?, cname = ?, diliverycheck = ? WHERE consumerId=?";
	

	private static final String SELECT_STOCK = "SELECT COUNT(*) FROM your_table WHERE id = ?";
	
	public int Insert_BOOKING(Booking Booking) {
        try (
        		Connection connection =  DbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Insert_BOOKING)) {

            preparedStatement.setInt( 1,Booking.getBookingId());
            preparedStatement.setInt(2, Booking.getConsumerId());          
            preparedStatement.setString(3,Booking.getCylinderType());
            preparedStatement.setDate(4,Date.valueOf(Booking.getDate()));
            preparedStatement.setInt(5,Booking.getNoOfCylinder());
            
            preparedStatement.executeUpdate();

        } catch (Exception e) {
        e.printStackTrace(); // Handle this exception properly in a real-world scenario
        return 0;
        }
       
       
		return 0;
    }
	public int getLastbIdFromDatabase() {
        int lastbId = 0;

        try {
            // Create a PreparedStatement to execute a SQL query
        	String sql = "SELECT MAX(bookingId) as last_id FROM bookingdetails";
        	Connection connection =  DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
         
                // Execute the query
                try (ResultSet resultSet =preparedStatement.executeQuery()) {
                    // Check if there is a result
                    if (resultSet.next()) {
                        // Retrieve the last ID from the result set
                        lastbId = resultSet.getInt("last_id");
                    }
                }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's requirements
        }

        return lastbId;
    }
	public static ArrayList arr ;
	public ArrayList ConsumerDilivery(int comId) {
		
		 arr = new ArrayList();
	        try  {
	        	
	        	Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from bookingdetails where consumerId like '"+comId+"%'");
	             
	             try (ResultSet resultSet =preparedStatement.executeQuery()) {
	                    while (resultSet.next()) {
	                        int id = resultSet.getInt("consumerId");
	                        //String name = resultSet.getString("name");
	                        if(id==comId) {
	                        	arr.add(id);
	                        	arr.add(resultSet.getInt("bookingId"));
	                        	
	                        	arr.add(resultSet.getString("cylinder_type"));
	                        	
	                        	arr.add(resultSet.getInt("no_of_cylinder"));
	                        	arr.add(resultSet.getDate("bookingdate"));
	                        	
	                        	arr.add(resultSet.getDate("diliverydate"));
	                        	arr.add(resultSet.getDouble("totalamt"));
	                        	arr.add(resultSet.getString("cname"));
	                        	arr.add(resultSet.getBoolean("diliverycheck"));
	                        	return arr;
	                        }
	                        else {
	                        	return arr;
	                        }	                        	                      
	                    }

	        }
	             catch (Exception e) {
	            e.printStackTrace(); // Handle this exception properly in a real-world scenario
	        }
	             return arr;
	    } catch (Exception e1) {
			// TODO Auto-generated catch block	    	
			e1.printStackTrace();
		}
	        return arr;
	}
	public int Insert_Bill(int id,Booking Booking) {
        try (
        		
        		Connection connection =  DbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Insert_Bill)) {
        	  preparedStatement.setDate(1,Date.valueOf(Booking.getdDate()));
          
            preparedStatement.setDouble(2, Booking.getTotalamt());          
            preparedStatement.setString(3,Booking.getName());
            preparedStatement.setBoolean(4,Booking.getiCdilivery() );
            preparedStatement.setInt(5, id);      
            
            preparedStatement.executeUpdate();

        } catch (Exception e) {
        e.printStackTrace(); // Handle this exception properly in a real-world scenario
        return 0;
        }
       
       
		return 0;
    }
}