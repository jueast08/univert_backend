package test;

import java.sql.SQLException;

import com.univert.db.DbManagement;
import com.univert.db.MySQLManagement;

public class TestDB {

    final static String NomBase = "jdbc:mariadb://localhost/univert";

	public static void initDB() {
		try {
	       Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e){
	       System.err.println("Impossible de charger le driver " + e.getMessage ());
	       System.exit (-1) ; 
	   }
	}
	 
	public static void main(String[] args) throws SQLException {
		initDB();
		
		DbManagement.getInstance().setDelegate(new MySQLManagement());
		DbManagement.getInstance().connection(NomBase);	

		
	}
}
