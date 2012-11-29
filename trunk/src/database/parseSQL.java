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
    static void parse(String nomFichier, ArrayList<RequestSQL> stock){
	BufferedReader buf = null;
	String sentence = null;
	RequestSQL command = new RequestSQL();

	if(!nomFichier.endsWith(".sql"))
	    System.out.println("le fichier n'est pas un point sql!");

	else{
	    try{
		buf = new BufferedReader(new FileReader(nomFichier));
	    
		while((sentence = buf.readLine()) != null){
		    if(sentence.length() == 0){
		}
		    else if(sentence.charAt(0) == '-'){
			/*On lit un commentaire*/
		    }
		    else if(sentence.endsWith(";")){
			    command.concat(sentence.replace(';', ' '));
			    stock.add(command);
			    command = new RequestSQL("");
		    }
		    else{
			command.concat(sentence);		      
		    }//end else
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
	}//end else
    }//end fct
}// end class
