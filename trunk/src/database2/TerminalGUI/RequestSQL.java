package TerminalGUI;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class RequestSQL {
    private String requestText;

    RequestSQL(){
	requestText = "";
    }
    
    RequestSQL(String request){
	requestText = request;
    }

    String getText(){
	return requestText;
    }
    
    //execute la commande passee en parametre
    ResultSet execRequest(Statement stmt) throws SQLException, ClassNotFoundException, java.io.IOException {
	// Execution de la requete.
	ResultSet rset = stmt.executeQuery(requestText);
	ResultSetMetaData data = rset.getMetaData();
	int i;

	for (i = 1; i <= data.getColumnCount(); i++)
	    System.out.print(data.getColumnName(i) + " ");
	System.out.print("\n");

	this.affichageTerminal(rset, data);
	return rset;
    }

    void concat(String next){
	requestText = requestText.concat(next);
	requestText = requestText.concat(" ");
    }

    //Affiche dans le terminal le resultat de la commande
    //TODO : Deplacer cette fonction dans la GUI
    private void affichageTerminal(ResultSet rset, ResultSetMetaData data) throws SQLException, ClassNotFoundException, java.io.IOException{
	int i;

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
	return("je retourne la requete : " + requestText);
    }
}