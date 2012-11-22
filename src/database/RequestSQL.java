package database;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class RequestSQL {
    private String requestText;
    private String name;
    
    RequestSQL(String requete, String rName){
	requestText = requete;
	name = rName;
    }
    

    ResultSet execRequest(Statement stmt) throws SQLException, ClassNotFoundException, java.io.IOException {
	// Execution de la requete.
	ResultSet rset = stmt.executeQuery(requestText);
	ResultSetMetaData data = rset.getMetaData();
	int i;

	for (i = 1; i <= data.getColumnCount(); i++)
	    System.out.print(data.getColumnName(i) + " ");
	System.out.print("\n");

	this.affichageTerminal(rset);
	return rset;
    }

    //TODO : Déplacer cette fonction dans la GUI
    private void affichageTerminal(ResultSet rset){
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
		    System.out.print("Je ne connais pas le format de donnees suivant :" + data.getColumnTypeName(i));
	    }
	    System.out.println("\n");
	}
    }

    public String toString(){
	System.out.println("La requete appelee est : " + requestText);
	return("La requete appelee est : " + requestText);
    }
}