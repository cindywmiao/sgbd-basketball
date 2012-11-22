package database;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class RequestSQL {
    String requestText;
    
    RequestSQL(String requete){
	requestText = requete;
    }
    
    void execRequest() throws SQLException, ClassNotFoundException, java.io.IOException {
	// Execution de la requete.
	ResultSet rset = stmt.executeQuery(requestText);
	ResultSetMetaData data = rset.getMetaData();
	int i;

	for (i = 1; i <= data.getColumnCount(); i++)
	    System.out.print(data.getColumnName(i) + " ");
	System.out.print("\n");

	while (rset.next()) {
	    // Affichage du resultat.
	    
	    for (i = 1; i <= data.getColumnCount(); i++){
		if(data.getColumnTypeName(i).equals("CHAR"))
		    System.out.print(rset.getString(i) + " ");
		else if(data.getColumnTypeName(i).equals("NUMBER"))
		    System.out.print(rset.getInt(i) + " ");
		else if(data.getColumnTypeName(i).equals("DATE"))
		    System.out.print(rset.getString(i) + " ");
		else
		    System.out.print("Je ne connais pas le format de donnees suivant :" + getColumnTypeName(i));
	    }
	    System.out.println("\n");
	}
    }

    String toString(){
	println("La requete appelée est : " + requestText);
    }
}