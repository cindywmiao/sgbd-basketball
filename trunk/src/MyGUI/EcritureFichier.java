import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public final class EcritureFichier {

    public void ecrireDuTexte(String S, String fichier){
	String adressedufichier = System.getProperty("user.dir") + "/"+ fichier;
	FileWriter f =null;
	try{
	    f = new FileWriter(adressedufichier,true);
	}catch (IOException e){
	    System.out.println("Erreur de fichier.");
	}
	PrintWriter p = new PrintWriter(f);
	BufferedWriter output = new BufferedWriter(f);
	try{
	    output.write(S);
	    output.flush();

	}catch(IOException e){
	    System.out.println("Erreur de fichier");
	}//p.println(S);
	try{
	    output.close();
	}catch (IOException e){
	    System.out.println("Erreur de fichier.");
	}
    }
}