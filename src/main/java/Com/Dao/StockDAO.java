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

public class StockDAO {
	
	
	
	
	private static final String UPDATE_STOCK = "UPDATE stock SET Domstock = ?,Comstock = ? WHERE id = ?";

	private static final String SELECT_STOCK = "SELECT * from stock";

	
	
	public int UpdateStock(Stock stock) {
	        try (
	        		Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK)) {

	            preparedStatement.setInt( 1,stock.getComstock());
	            preparedStatement.setInt(2, stock.getDomstock());
	           
	            preparedStatement.setDouble(3, 1);

	            preparedStatement.executeUpdate();

	        } catch (Exception e) {
            e.printStackTrace(); // Handle this exception properly in a real-world scenario
            return 0;
	        }
			return 0;
	    }

	public Stock SelectStock() {
	        try  {
	        	
	        	Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK);
	             
	             try (ResultSet resultSet =preparedStatement.executeQuery();) {
	                    while (resultSet.next()) {
	                    	 int id = resultSet.getInt("id");
	                        int DomStock = resultSet.getInt("Domstock");
	                        int CommStock = resultSet.getInt("comstock");
	                       
	                        return new Stock( DomStock,CommStock);
	                       
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

