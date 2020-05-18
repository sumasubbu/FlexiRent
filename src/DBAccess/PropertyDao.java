package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.InvalidException;
import model.Property;

public class PropertyDao extends DBConnecter {
	
	public void insertProperty(Property property){
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_PROPERTY);
			statement.setString(1,property.getProperty_id());
			statement.setString(2, property.getImageUrl());
			statement.setInt(3, property.getNo_of_bedroom());
			statement.setString(4, property.getProp_type());
			statement.setString(5,property.getStatus());
			statement.setString(6, property.getShort_desc());
			statement.setString(7, property.getLong_desc());
			statement.setInt(8, property.getStreet_number());
			statement.setString(9, property.getStreet_name());
			statement.setString(10, property.getSuburb());
			statement.setString(11, property.getInMaintenance());
			statement.setDouble(12, property.getFee_per_day());
			
			statement.executeUpdate();
			System.out.println("Inserted"+property.toString());
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Property getProperty(String propertyId){
		Connection connection;
		Property property = new Property();
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_PROPERTY);
			statement.setString(1, propertyId);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				property.setProperty_id(resultSet.getString("PROPERTY_ID"));
				property.setImageUrl(resultSet.getString("IMAGE_URL"));
				property.setNo_of_bedroom(resultSet.getInt("NUM_BEDROOMS"));
				property.setProp_type(resultSet.getString("TYPE_NAME"));
				property.setStatus(resultSet.getString("STATUS"));
				property.setShort_desc(resultSet.getString("SHORT_DESCRIPTION"));
				property.setLong_desc(resultSet.getString("LONG_DESCRIPTION"));
				property.setStreet_number(resultSet.getInt("STREET_NUM")); 
				property.setStreet_name(resultSet.getString("STREET_NAME")); 
				property.setSuburb(resultSet.getString("SUBURB"));
				property.setInMaintenance(resultSet.getString("IN_MAINTENANCE"));
				property.setFee_per_day(resultSet.getDouble("FEE_PER_DAY"));
			}
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
		
	}
	
	public void startMaintenance(String propertyId){
		Connection connection;
		try {
			if(checkMaintenance(propertyId))
			{
				throw new InvalidException("Property is already under maintanance");
			}
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(START_MAINTENANCE);
			statement.setString(1, propertyId);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
	}
	public boolean checkMaintenance(String propertyId){
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(CHECK_MAINTENANCE);
			statement.setString(1, propertyId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
				return resultSet.getString("IN_MAINTENANCE").equals("YES");
			else
				throw new InvalidException("Property not found");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public void endMaintenance(String propertyId){
		Connection connection;
		try {
			if (!checkMaintenance(propertyId)) {
				throw new InvalidException("Property is not under maintanance");
			}
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(STOP_MAINTENANCE);
			statement.setString(1, propertyId);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateStatus(String propertyId, String status){
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS);
			statement.setString(1, status);
			statement.setString(2, propertyId);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Property> getAllProperties(){
		Connection connection;
		List<Property> propertyList = new ArrayList<Property>();
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_ALL);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Property property = new Property();
				property.setProperty_id(resultSet.getString("PROPERTY_ID"));
				property.setImageUrl(resultSet.getString("IMAGE_URL"));
				property.setNo_of_bedroom(resultSet.getInt("NUM_BEDROOMS"));
				property.setProp_type(resultSet.getString("TYPE_NAME"));
				property.setStatus(resultSet.getString("STATUS"));
				property.setShort_desc(resultSet.getString("SHORT_DESCRIPTION"));
				property.setLong_desc(resultSet.getString("LONG_DESCRIPTION"));
				property.setStreet_number(resultSet.getInt("STREET_NUM")); 
				property.setStreet_name(resultSet.getString("STREET_NAME")); 
				property.setSuburb(resultSet.getString("SUBURB"));
				property.setInMaintenance(resultSet.getString("IN_MAINTENANCE"));
				property.setFee_per_day(resultSet.getDouble("FEE_PER_DAY"));
				propertyList.add(property);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return propertyList;
		
	}
	
	
	
	
	public static final String INSERT_PROPERTY = "INSERT INTO RENTAL_PROPERTY "
			+ "(PROPERTY_ID, "
			+ "IMAGE_URL,"
			+ "NUM_BEDROOMS,"
			+ "TYPE_NAME,"
			+ "STATUS,"
			+ "SHORT_DESCRIPTION,"
			+ "LONG_DESCRIPTION,"
			+ "STREET_NUM,"
			+ "STREET_NAME,"
			+ "SUBURB,"
			+ "IN_MAINTENANCE,"
			+ "FEE_PER_DAY)"
			+ " VALUES"
			+ " (?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String UPDATE_STATUS = "UPDATE RENTAL_PROPERTY"
			+ " SET STATUS = ?"
			+ " WHERE PROPERTY_ID = ?";

	public static final String START_MAINTENANCE = "UPDATE RENTAL_PROPERTY"
			+ " SET IN_MAINTENANCE = 'YES'"
			+ " WHERE PROPERTY_ID = ?";
	
	public static final String STOP_MAINTENANCE = "UPDATE RENTAL_PROPERTY"
			+ " SET IN_MAINTENANCE = 'NO'"
			+ " WHERE PROPERTY_ID = ?";
	public static final String CHECK_MAINTENANCE = "SELECT IN_MAINTENANCE "  
						+ " FROM RENTAL_PROPERTY "  
						+ " WHERE PROPERTY_ID = ?";
	
	public static final String FIND_ALL = "SELECT PROPERTY_ID, "
			+ "IMAGE_URL, "
			+ "NUM_BEDROOMS, "
			+ "TYPE_NAME, "
			+ "STATUS, "
			+ "SHORT_DESCRIPTION, "
			+ "LONG_DESCRIPTION, "
			+ "STREET_NUM, "
			+ "STREET_NAME, "
			+ "SUBURB, "
			+ "IN_MAINTENANCE, "
			+ "FEE_PER_DAY " 
			+ " FROM RENTAL_PROPERTY ";
	
	public static final String FIND_PROPERTY = "SELECT PROPERTY_ID, "
			+ "IMAGE_URL, "
			+ "NUM_BEDROOMS, "
			+ "TYPE_NAME, "
			+ "STATUS, "
			+ "SHORT_DESCRIPTION, "
			+ "LONG_DESCRIPTION, "
			+ "STREET_NUM, "
			+ "STREET_NAME, "
			+ "SUBURB, "
			+ "IN_MAINTENANCE, "
			+ "FEE_PER_DAY " 
			+ " FROM RENTAL_PROPERTY "
			+ " WHERE PROPERTY_ID = ?";

}
