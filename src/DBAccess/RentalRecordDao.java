package DBAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RentalRecord;

public class RentalRecordDao extends DBConnecter {
	
	PropertyDao propertyDao = new PropertyDao();

	public static final String FIND_RENTAL_RECORDS = "SELECT PROPERTY_ID,"
			+ "START_DATE,"
			+ "ESTIMATED_RETURN_DATE,"
			+ "ACTUAL_RETURN_DATE,"
			+ "RENTAL_FEE,"
			+ "LATE_FEE,"
			+ "TOTAL_DUE,"
			+ "CUSTOMER"
			+ " FROM RENTAL_RECORD"
			+ " WHERE PROPERTY_ID = ?";
	
	public static final String INSERT_RENTAL_RECORD = "INSERT INTO RENTAL_RECORD"
			+ "(PROPERTY_ID,"
			+ "START_DATE,"
			+ "ESTIMATED_RETURN_DATE,"
			+ "ACTUAL_RETURN_DATE,"
			+ "RENTAL_FEE,"
			+ "LATE_FEE,"
			+ "TOTAL_DUE,"
			+ "CUSTOMER)"
			+ "VALUES "
			+ "(?,?,?,?,?,?,?,?)";
	
	public static final String UPDATE_RENTAL_RECORD = "UPDATE RENTAL_RECORD "
			+ " SET ACTUAL_RETURN_DATE = SYSDATE"
			+ " WHERE ID IN (SELECT MAX(ID) FROM RENTAL_RECORD WHERE PROPERTY_ID = ?)";
	
	public void returnRental(String propertyId){
		
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_RENTAL_RECORD);
			statement.setString(1, propertyId);
			statement.executeUpdate();
			propertyDao.updateStatus(propertyId, "Available");
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void insertRental(RentalRecord record){
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_RENTAL_RECORD);
			statement.setString(1,record.getProperty().getProperty_id());
			statement.setDate(2,new java.sql.Date(record.getStart().getTime()));
			statement.setDate(3,new java.sql.Date(record.getEstimatedEnd().getTime()));
			statement.setDate(4,new java.sql.Date(record.getActualEnd().getTime()));
			statement.setDouble(5, record.getRentalFee());
			statement.setDouble(6, record.getLateFee());
			statement.setDouble(7, record.getTotalFee());
			statement.setString(8, record.getCustomer());
			statement.executeUpdate();
			propertyDao.updateStatus(record.getProperty().getProperty_id(), "Rented");
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<RentalRecord> getRentalRecords(String propertyId){
		Connection connection;
		List<RentalRecord> rentalRecords = new ArrayList<>();
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_RENTAL_RECORDS);
			statement.setString(1, propertyId);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				RentalRecord record = new RentalRecord();
				record.setProperty(propertyDao.getProperty(propertyId));
				record.setStart(resultSet.getDate("START_DATE"));
				record.setEstimatedEnd(resultSet.getDate("ESTIMATED_RETURN_DATE"));
				record.setActualEnd(resultSet.getDate("ACTUAL_RETURN_DATE"));
				record.setRentalFee(resultSet.getDouble("RENTAL_FEE"));
				record.setLateFee(resultSet.getDouble("LATE_FEE"));
				record.setTotalFee(resultSet.getDouble("TOTAL_DUE"));
				record.setCustomer(resultSet.getString("CUSTOMER"));
				record.getRentalId();
				rentalRecords.add(record);
			}
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentalRecords;
	}
	
}
