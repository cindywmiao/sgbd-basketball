package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.lang.String;

import java.io.FileNotFoundException;
import java.io.IOException;


class ParseSQL {
    
    //Fonction decoupant un fichier sql en un tableaux de fonction.
    static ArrayList<RequestSQL> parse(String nomFichier){
	BufferedReader buf = null;
	String sentence = null;
	RequestSQL command = new RequestSQL();
	ArrayList<RequestSQL> stock = new ArrayList();//Tableau pour stocker les commandes

	if(!nomFichier.endsWith(".sql"))
	    System.out.println("le fichier n'est pas un point sql!");

	else{
	    try{
		buf = new BufferedReader(new FileReader(nomFichier));
	    
		while((sentence = buf.readLine()) != null){
		    if(sentence.length() == 0){
			System.out.println("Ligne vide");
			stock.add(command);
			System.out.println("J'ai ajoute la commande : " + command.getText());
			command = new RequestSQL("");
		}
		    else if(sentence.charAt(0) == '-'){
			/*On lit un commentaire*/
			//System.out.println("J'ai lu un commentaire");
		    }
		    else{
			command.concat(sentence);
		    }
		}//end while
	    }catch (IOException e){
		System.out.println("Erreur a l'ouverture du ficher");
	    }finally{
		try{
		    buf.close();
		}catch(IOException e){
		    System.out.println("Impossible de fermer le fichier");
		}//end catch
	    }//end finally
	    stock.add(command);
	    System.out.println("J'ai ajoute la commande : " + command.getText());
	}//end else
	return stock;
    }
}
