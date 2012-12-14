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
    ResultSet execRequest(Statement stmt) {
	// Execution de la requete.
	
	ResultSet rset = null;
	ResultSetMetaData data = null;
	int i;

	try{
	    rset = stmt.executeQuery(requestText);
	    data = rset.getMetaData();
	    for (i = 1; i <= data.getColumnCount(); i++)
		System.out.print(data.getColumnName(i) + " ");
	    System.out.print("\n");

	    this.affichageTerminal(rset, data);
	}catch(Exception e){
	    System.out.println("Erreur a l'execution d'une requete :" + e.getMessage());
	}
	    return rset;
    }

    void concat(String next){
	requestText = requestText.concat(next);
	requestText = requestText.concat(" ");
    }

    int recup(Statement stmt){
	ResultSet rset = null;
	ResultSetMetaData data = null;
	try{
	rset = stmt.executeQuery(requestText);
	data = rset.getMetaData();
	}catch(Exception e){
	    System.out.println("echec : recup" + e.getMessage());   
	}

	try{
	    if(rset.next()){
		if(data.getColumnTypeName(1).equals("CHAR"))
		    System.out.print("Je ne connais pas le format de donnees suivant :" + data.getColumnTypeName(1));
		else if(data.getColumnTypeName(1).equals("NUMBER"))
		    return(rset.getInt(1));
		else if(data.getColumnTypeName(1).equals("DATE"))
		    System.out.print("Je ne connais pas le format de donnees suivant :" + data.getColumnTypeName(1));
		else
		    System.out.print("Je ne connais pas le format de donnees suivant :" + data.getColumnTypeName(1));
	    }
	}catch(Exception e){
	    System.out.println("echec recup2 : " + e.getMessage());   
	}

	return 0;
    }
    void execUp(Statement stmt) {
	// Execution de la commande de modification de la table.
	try{
	    stmt.executeUpdate(requestText);
	}catch(Exception e){
	    System.out.println("Erreur execution d'un update : "+ e.getMessage());
	}
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