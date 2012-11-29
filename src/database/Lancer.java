package database;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.ArrayList;

import java.util.Iterator;

public class Lancer {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, java.io.IOException {
	int i;

	ArrayList<RequestSQL> commands = new ArrayList();//Tableau pour stocker les commandes

	try{
	    for(i = 0; i<args.length; i++){
		System.out.println(args[i]);
		ParseSQL.parse(args[i], commands);
	    }
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

		// System.out.println("command 1 : " + commands.get(1).getText());
		// System.out.println("command 2 : " + commands.get(2).getText());
		// System.out.println("command 3 : " + commands.get(3).getText());

	       // Iterator it = commands.iterator();
	       // while(it.hasNext()){
	       // 	   requete =(RequestSQL) it.next();
	       // 	   System.out.println("En plus de la premiere commande, on a stocke : " + requete.getText());
	       // }
	    }catch(IndexOutOfBoundsException e){
		System.out.println("Acces interdit a l'indice : " + e.getCause());
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