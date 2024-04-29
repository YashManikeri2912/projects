package Com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.DB.*;


import Com.DB.DbConfig;
import Com.admin.model.*;

public class RateDAO {
	
	private static final String UPDATE_RATE = "UPDATE ratedetails SET DomRate = ?,CommRate = ? WHERE id = ?";

	private static final String SELECT_RATE = "SELECT * from ratedetails";

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

	public Rate SelectRate() {
	        try  {
	        	
	        	Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RATE);
	             
	             try (ResultSet resultSet =preparedStatement.executeQuery();) {
	                    while (resultSet.next()) {
	                        int id = resultSet.getInt("id");
	                        double DomRate = resultSet.getDouble("commRate");
	                        double CommRate = resultSet.getDouble("DomRate");
	                       
	                        return new Rate(id, DomRate,CommRate);
	                       
	                    }

	        } catch (Exception e) {
	            e.printStackTrace(); // Handle this exception properly in a real-world scenario
	        }
	             return null;
	    } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        return null;
	}

}
