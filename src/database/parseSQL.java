package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.IOException;


class ParseSQL {
    
    //Fonction decoupant un fichier sql en un tableaux de fonction.
    static ArrayList<RequestSQL> parse(String nomFichier, ArrayList<RequestSQL> stock){
	    BufferedReader buf = null;
	    String sentence = null;
	    RequestSQL command = new RequestSQL("");

	if(!nomFichier.endsWith(".sql"))
	    System.out.println("le fichier n'est pas un point sql!");

	else{	    
	    try{
		buf = new BufferedReader(new FileReader(nomFichier));

		try{
		    while((sentence = buf.readLine()) != null){
			if(sentence.charAt(0) == '-')
			    System.out.println("J'ai lu un commentaire");
			else if(sentence.charAt(0) == ' ' || sentence.charAt(0) == '\n' || sentence.charAt(0) == '\0' || sentence.charAt(0) == '\r'|| (sentence.length() == 0)){
			    //C'est bizare mais le compilateur me dit ne pas connaitre isEmpty()
			    stock.add(command);
			    System.out.println("J'ai ajoute la command : " + command);
			    command = new RequestSQL("");
			}
			else{
			    command.concat(sentence);
			    System.out.println("J'espere que c'est une partie de commande : " + sentence);
			}
		    }
		}finally{
		    buf.close();
		}

	    }catch (IOException e){
		System.out.println("Erreur a l'ouverture du ficher");
	    }
	}
	return stock;
    }
}