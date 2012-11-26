package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


class ParseSQL {
    
    //Fonction decoupant un fichier sql en un tableaux de fonction.
    static void parse(String nomFichier){

	if(!nomFichier.endsWith(".sql"))
	    System.out.println("le fichier n'est pas un point sql!");
	else{
	    File fis= new FileInputStream(new File(nomFichier));
	    byte[] buf = new byte[8];

	    


	}
    }   
}