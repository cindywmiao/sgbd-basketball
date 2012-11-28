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
    static ArrayList<RequestSQL> parse(String nomFichier){
	BufferedReader buf = null;
	String sentence = null;
	RequestSQL command = new RequestSQL("");
	ArrayList<RequestSQL> stock = new ArrayList();//Tableau pour stocker les commandes

	try{
	    buf = new BufferedReader(new FileReader(nomFichier));
	    
		while((sentence = buf.readLine()) != null){
		    if(sentence.charAt(0) == '-')
			System.out.println("J'ai lu un commentaire");
		    else if(sentence.charAt(0) == ' ' || sentence.charAt(0) == '\n' || sentence.charAt(0) == '\0' || sentence.charAt(0) == '\r'|| (sentence.length() == 0) || sentence.charAt(0) == '#'){

			stock.add(command);
			System.out.println("&J'ai ajoute la commande : " + command + " &");
			command = new RequestSQL("");
		    }

		    else{
			command.concat(sentence);
			System.out.println("J'espere que c'est une partie de commande : " + sentence);
			System.out.println("Voila ce que je viens de mettre dans command :" + command.getText());
			    }
		}
	}catch (IOException e){
		System.out.println("Erreur a l'ouverture du ficher");
	}finally{
	    buf.close();
	}
	
	return stock;
    }
}

//	if(!nomFichier.endsWith(".sql"))
//	    System.out.println("le fichier n'est pas un point sql!");

//	else{
//	}
			    //C'est bizare mais le compilateur me dit ne pas connaitre isEmpty()