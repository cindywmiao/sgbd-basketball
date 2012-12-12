package TerminalGUI;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Menu{

    static void Menu()
    {};

    static void afficheMenu(Statement stmt){
	boolean b =true;

      	while(b){
	System.out.println("Pour executer les requetes suivantes, taper le nombre correspondant : ");
	System.out.println("1-Club ");
	System.out.println("2-Joueur ");
	System.out.println("3-Rencontre ");
	System.out.println("4-Equipe ");
	System.out.println("5-Categorie ");
	System.out.println("6-Entraineur \n");

	System.out.println("7-Moyenne des points marques par rencontre");
	System.out.println("8-Moyenne des points marques depuis le debut de la saison");
	System.out.println("9-Classement des meilleurs joueurs par categorie");
	System.out.println("10-Classement des equipes\n");
	
	System.out.println("11-Mettre a jour");

	System.out.println("12-Quitter\n");

	b = Menu.commande(stmt);
	}
    }

    static boolean commande(Statement stmt){
	boolean b = true;
	Scanner sc = new Scanner(System.in);
	String date;
	RequestSQL r;
	int cat = 0;
	String categorie = "";

	int reponse = sc.nextInt();
	sc.nextLine();

	try{
	    switch(reponse){
	    case(1):
		r = new RequestSQL("select * from club");
		r.execRequest(stmt);
		break;
	    case(2):
		r = new RequestSQL("select * from joueur");
		r.execRequest(stmt);
		break;
	    
	    case(3):
		r = new RequestSQL("select * from rencontre");
		r.execRequest(stmt);
		break;
	    case(4):
		r = new RequestSQL("select * from equipe");
		r.execRequest(stmt);
		break;
	    
	    case(5):
		r = new RequestSQL("select * from Categorie");
		r.execRequest(stmt);
		break;
	    case(6):
		r = new RequestSQL("select * from entraineur");
		r.execRequest(stmt);
		break;
		
	    case(7):
		System.out.println("Rentrez une date au format dd-MMM-aa(par exemple 21-FEB-87)");
		date = sc.nextLine();

		//TODO : check que la date est au format valide
	    
		r = new RequestSQL("select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS from participe, rencontre where rencontre.date_rencontre = '" + date + "' and rencontre.numero_rencontre = participe.numero_rencontre");
		r.execRequest(stmt);
		break;

	    case(8):
		System.out.println("Rentrez la date de debut de la saison format dd-MMM-aa(par exemple 21-FEB-87)");
		date = sc.nextLine();

		r = new RequestSQL("select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS from joueur, participe, rencontre where rencontre.date_rencontre > '" +date+ "' and rencontre.numero_rencontre = participe.numero_rencontre");
		r.execRequest(stmt);
		break;

	    case(9):
		while(cat == 0){
		    System.out.println("Rentrez l'une des categorie suivante : cadet, benjamin, junior");
		    categorie = sc.nextLine();
		    if (categorie.equals("cadet"))
			cat = 1;
		    else if(categorie.equals("benjamin"))
			cat = 2;
		    else if(categorie.equals("junior"))
			cat = 3;
		    else{
			System.out.println("La categorie choisi est invalide. Si vous ne souhaitez pas choisir une categorie taper 'q' sinon tapez entree");
			if (sc.nextLine().equals("q"))
			    break;
		    }
		}

		System.out.println("Rentrez la date de debut de la saison format dd-MMM-aa(par exemple 21-FEB-87)");
		date = sc.nextLine();

		r = new RequestSQL("select joueur.numero_licence, sum(participe.cumul_points_marques_joueur) as SCORE from joueur, participe, rencontre, equipe where equipe.numero_categorie = "+ cat +" and rencontre.date_rencontre = '"+ date +"' and equipe.numero_equipe = joueur.numero_equipe and joueur.numero_licence = participe.numero_licence and participe.numero_rencontre = rencontre.numero_rencontre group by joueur.numero_licence order by score DESC");

		r.execRequest(stmt);
		break;


	    case(10):
		r = new RequestSQL("select num_equipe, sum(score) as Score from( (select rencontre.numero_equipe1 as NUM_EQUIPE , rencontre.score_equipe1_rencontre as SCORE from rencontre) union (select rencontre.numero_equipe2 as NUM_EQUIPE , rencontre.score_equipe2_rencontre as SCORE from rencontre)) group by NUM_EQUIPE order by Score DESC");
		r.execRequest(stmt);
		break;

	    case(11):
		Menu.modifyTable(stmt);
		break;

	    case(12):
		return false;

	    default:
		System.out.println("Commande rentree invalide");
		break;
	    }

	}catch(Exception e){
	    System.out.println("echec : " + e.getMessage());
	}
	return true;
    }

    static void modifyTable(Statement stmt){

	System.out.println("Quelle table souhaitez vous modifier?");
	System.out.println("1-Club ");
	System.out.println("2-Joueur ");
	System.out.println("3-Rencontre ");
	System.out.println("4-Equipe ");
	System.out.println("5-Categorie ");
	System.out.println("6-Entraineur \n");

	Scanner sc = new Scanner(System.in);
	int tab = sc.nextInt();
	sc.nextLine();
	RequestSQL r;

	try{

	    switch(tab){
	    case(2):
		System.out.println("Quel est le numero de licence du nouveau joueur?");
		int numLi = sc.nextInt();
		sc.nextLine();
		System.out.println("Quel est le nom du nouveau joueur?");
		String name = sc.nextLine();
		System.out.println("Quel est le prenom du nouveau joueur?");
		String firstName = sc.nextLine();
		System.out.println("Quel est la date de naissance du nouveau joueur?");
		String birthday = sc.nextLine();
		System.out.println("Quel est la ville du nouveau joueur?");
		String town = sc.nextLine();
		System.out.println("Quel est la date d'entree dans le club du nouveau joueur?");
		String dateEnt = sc.nextLine();
		System.out.println("Quel est le numero de l'equipe du nouveau joueur?");
		int numTeam = sc.nextInt();
		sc.nextLine();

		r = new RequestSQL("insert into JOUEUR values("+numLi+",'" + name + "','" + firstName + "','" + birthday + "','" + town + "', '" + dateEnt + "'," + numTeam + ")");
		//	    r2 = new RequestSQL("commit");
	    
		r.execUp(stmt);
		break;

	    default:
		System.out.println("Ceci ne peut pas etre fait");
	
	    }
	}catch(Exception e){
	    System.out.println("Erreur : " + e.getMessage());	    
	}
	
    }
}