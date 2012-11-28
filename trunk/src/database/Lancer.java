package database;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.ArrayList;

public class Lancer {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, java.io.IOException {

	ArrayList<RequestSQL> commands = null;//Tableau pour stocker les commandes

	try{
	    commands = ParseSQL.parse(args[0], commands);
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
	RequestSQL request = null;

	try {
	    conn = ods.getConnection();
	    stmt = conn.createStatement();
	    
	    try{
		requete = (commands.get(0));
		requete.execRequest(stmt);
	    }
	    catch(IndexOutOfBoundsException e){
		System.out.println("Acces interdit a l'indice : 0");
	    }
	    try{
		(commands.get(1)).execRequest(stmt);
	    }
	    catch(IndexOutOfBoundsException e){
		System.out.println("Acces interdit a l'indice : 1");
	    }
	    System.out.println("La liste est vide : " + commands.isEmpty());
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