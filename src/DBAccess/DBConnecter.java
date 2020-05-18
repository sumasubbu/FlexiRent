package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	
    public static final String URL = "jdbc:hsqldb:localFile";
    public static final String USER = "sa";
    public static final String PASS = "";
    /**
     * Get a connection to database
     * @return Connection object
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws ClassNotFoundException
    {
      try {
    	  Class.forName("org.hsqldb.jdbc.JDBCDriver");
    	  return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      } catch (Exception e){
    	  throw new RuntimeException("SQL Error",e);    	  
      }
    }


}
