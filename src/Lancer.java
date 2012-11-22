package database;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Lancer {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, java.io.IOException {

	RequestSQL exempleReq = new RequestSQL("select * from ENTRAINEUR ");

      	// Preparation de la connexion.
	OracleDataSource ods = new OracleDataSource();
	ods.setUser("bmeunier");
	ods.setPassword("bmeunier");
	// URL de connexion, on remarque que le pilote utilise est "thin".
	ods.setURL("jdbc:oracle:thin:@oracle.enseirb.fr:1522/ecole");

	Connection conn = null;
	Statement stmt = null;
	try {
	    conn = ods.getConnection();
	    stmt = conn.createStatement();   

	exempleReq.execRequest();
	} 
	finally {
	    if (stmt != null) {
		stmt.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}	
    }
}