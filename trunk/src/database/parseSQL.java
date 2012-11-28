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
	    BufferedReader buf= new BufferedReader(new FileReader(nomFichier));
	    String sentence = NULL;

		try{
		    if((sentence = buf.readLine()) != null){
			if(sentence[0] == '-')
			    System.out.println("J'ai lu le bon truc! :) : " + (char)buf);
	    }
		}catch(IOException e){
		    System.out.println("On a renvoyé une erreur en lisant le fichier" + nomFichier);
	}
		finally{
		    buf.close();
		}
	}
    }
}