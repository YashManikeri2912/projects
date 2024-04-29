package Com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import Com.DB.DbConfig;
import Com.admin.model.ConsumerRegistration;
import Com.admin.model.Rate;
public class ConsumerRegistrationDAO {

	private static final String UPDATE_RATE = "INSERT INTO consumerdetails VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String Edit_Consumer = "UPDATE consumerdetails SET name = ?,passbook = ?,adhar_no = ? ,rationcard = ? ,gender = ? ,address = ? ,pincode = ?,phone = ?,DOB = ?,DateOfRegistration = ?,c_type = ?,no_of_cylinder = ? WHERE consumerId = ?";

	public int UpdateRate(ConsumerRegistration ConsumerRegistration) {
	        try (
	        		Connection connection =  DbConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RATE)) {

	            preparedStatement.setInt( 1,ConsumerRegistration.getConsumerId());
	            preparedStatement.setString(2, ConsumerRegistration.getName());
	            preparedStatement.setInt(3, ConsumerRegistration.getPassbook());
	            preparedStatement.setLong(4, ConsumerRegistration.getAdhar());
	            preparedStatement.setInt(5, ConsumerRegistration.getRation());
	            preparedStatement.setString(6, ConsumerRegistration.getGender());
	            preparedStatement.setString(7,ConsumerRegistration.getAddress());
	            preparedStatement.setInt(8, ConsumerRegistration.getPincode());
	            preparedStatement.setInt(9, ConsumerRegistration.getPhone());
	            preparedStatement.setDate(10, Date.valueOf(ConsumerRegistration.getDOB()));
	            preparedStatement.setDate(11, Date.valueOf(ConsumerRegistration.getDateOfRegister()));
	            preparedStatement.setString(12, ConsumerRegistration.getCtype());
	            preparedStatement.setInt(13, ConsumerRegistration.getNo_of_cylinder());

	            preparedStatement.executeUpdate();

	        } catch (Exception e) {
            e.printStackTrace(); // Handle this exception properly in a real-world scenario
            return 0;
	        }
			return 0;
	    }
	
	public int EditConsumer(ConsumerRegistration ConsumerRegistration) {
        try (
        		Connection connection =  DbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Edit_Consumer)) {

           
            preparedStatement.setString(1, ConsumerRegistration.getName());
            preparedStatement.setInt(2, ConsumerRegistration.getPassbook());
            preparedStatement.setLong(3, ConsumerRegistration.getAdhar());
            preparedStatement.setInt(4, ConsumerRegistration.getRation());
            preparedStatement.setString(5, ConsumerRegistration.getGender());
            preparedStatement.setString(6,ConsumerRegistration.getAddress());
            preparedStatement.setInt(7, ConsumerRegistration.getPincode());
            preparedStatement.setInt(8, ConsumerRegistration.getPhone());
            preparedStatement.setDate(9, Date.valueOf(ConsumerRegistration.getDOB()));
            preparedStatement.setDate(10, Date.valueOf(ConsumerRegistration.getDateOfRegister()));
            preparedStatement.setString(11, ConsumerRegistration.getCtype());
            preparedStatement.setInt(12, ConsumerRegistration.getNo_of_cylinder());
            preparedStatement.setInt( 13,ConsumerRegistration.getConsumerId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
        e.printStackTrace(); // Handle this exception properly in a real-world scenario
        return 0;
        }
		return 0;
    }

}
