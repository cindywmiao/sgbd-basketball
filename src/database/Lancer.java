package database;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.ArrayList;

public class Lancer {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, java.io.IOException {

	ArrayList<RequestSQL> commands = null;//Tableau pour stocker les commandes

	try{
	    commands = ParseSQL.parse(args[0]);
	}
	catch(java.lang.ArrayIndexOutOfBoundsException e) {
	    System.out.println("Vous devez passer au moins un nom de fichier.sql en argument lorsque vous lancer le programme.");	    
	}

      	// Preparation de la connexion.
	OracleDataSource ods = new OracleDataSource();
	ods.setUser("bmeunier");
	ods.setPassword("bmeunier");
	// URL de connexion, on remarque que le pilote utilise est "thin".
	ods.setURL("jdbc:oracle:thin:@oracle.enseirb.fr:1522/ecole");

	Connection conn = null;
	Statement stmt = null;
	RequestSQL requete = null;

	try {
	    conn = ods.getConnection();
	    stmt = conn.createStatement();
	    
	    try{
	       commands.get(0).execRequest(stmt);
	       commands.get(1).execRequest(stmt);
	    }catch(IndexOutOfBoundsException e){
		System.out.println("Acces interdit a l'indice : " + e.getCause());
	    }
	    catch(SQLException e){
		System.out.println("Voila l'exception :" + e.getCause());
	    }
	    
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