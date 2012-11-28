package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;


class ParseSQL {
    
    //Fonction decoupant un fichier sql en un tableaux de fonction.
    static void parse(String nomFichier){

	if(!nomFichier.endsWith(".sql"))
	    System.out.println("le fichier n'est pas un point sql!");
	else{
	    BufferedReader buf = null;
	    try{
	    buf = new BufferedReader(new FileReader(nomFichier));
	    String sentence = null;

	    try{
		if((sentence = buf.readLine()) != null){
		    if(sentence.charAt(0) == '-')
			System.out.println("J'ai lu un commentaire");
		    else if(sentence.charAt(0) == ' ' || sentence.charAt(0) == '\n' || sentence.charAt(0) == '\0' || sentence.charAt(0) == '\r')
			System.out.println("J'ai lu une ligne vide");
		    else
			Systeme.out.println("J'espere que c'est une commande");
		}
	    }finally{
		buf.close();
	    }

	    }catch (IOException e){
		System.out.println("Erreur ) l'ouverture du ficher");
		    }

	}
    }
}