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
	
	    System.out.println("11-Mettre a jour\n");

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
		System.out.println("Quelle operation souhaitez vous effecter?");
		System.out.println("1-Ajout ");
		System.out.println("2-Suppression ");
		System.out.println("3-Modification ");
		System.out.println("4-Retour en arriere ");
		
		int choix = sc.nextInt();
		sc.nextLine();
		switch(choix){
		case(1):
		    Menu.addInTable(stmt);
		    break;
		case(2):
		    Menu.deleteInTable(stmt);
		    break;
		case(3):
		    Menu.modifyInTable(stmt);
		    break;
		case(4):
		    break;
		default:
		    System.out.println("Choix non valide");
		    break;
		}
		break;
	    case(12):
		return false;
		
	    default:
		System.out.println("Commande rentree invalide");
		break;
	    }
	}catch(Exception e){
	    System.out.println("echec : " + e.getMessage());
	}finally{
	    System.out.println("Tapez sur entree pour continuer");
	    sc.nextLine();
	}

	return true;
    }

    static void addInTable(Statement stmt){

	System.out.println("Que souhaitez vous ajouter?");
	System.out.println("1-Club ");
	System.out.println("2-Joueur ");
	System.out.println("3-Match ");
	System.out.println("4-Retour au menu principal ");

	Scanner sc = new Scanner(System.in);
	int tab = sc.nextInt();
	sc.nextLine();
	RequestSQL r;
	try{

	    switch(tab){
	    case(1):
		System.out.println("Quel est le numero du nouveau club?");
		int cNum = sc.nextInt();
		sc.nextLine();
		System.out.println("Dans quelle ville est le nouveau club?");
		String cTown = sc.nextLine();
		r = new RequestSQL("insert into CLUB values("+cNum + ",'" + cTown + "')");
		r.execUp(stmt);
		break;

	    case(2):	
		RequestSQL reqLi = new RequestSQL("select max(NUMERO_LICENCE) from joueur");
		int maxLi = reqLi.recup(stmt);
		System.out.println("Quel est le numero de licence du nouveau joueur(superieur a " + maxLi + ")?");
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
		System.out.println("Quel est le numero de l'equipe du nouveau joueur (entre 1 et 15)?");
		int numTeam = sc.nextInt();
		sc.nextLine();
		r = new RequestSQL("insert into JOUEUR values("+numLi+",'" + name + "','" + firstName + "','" + birthday + "','" + town + "', '" + dateEnt + "'," + numTeam + ")");
		r.execUp(stmt);
		break;

	    case(3):
		RequestSQL reqMatch = new RequestSQL("select max(NUMERO_RENCONTRE) from RENCONTRE");
		int maxMatch = reqMatch.recup(stmt);

		System.out.println("Quel est le numero du nouveau match(superieur a " + maxMatch + ")?");
		int mNum = sc.nextInt();
		sc.nextLine();
		System.out.println("A quelle date du nouveau match a-t-il lieu?");
		String mDate = sc.nextLine();
		System.out.println("A quel est le score de l'equipe1?");
		int score1 = sc.nextInt();
		sc.nextLine();
		System.out.println("A quel est le score de l'equipe2?");
		int score2 = sc.nextInt();
		sc.nextLine();		
		System.out.println("A quel est le nom de l'equipe1?");
		String nom1 = sc.nextLine();
		System.out.println("A quel est le nom de l'equipe2?");
		String nom2 =sc.nextLine();

		reqMatch = new RequestSQL("select NUMERO_EQUIPE from EQUIPE where NOM_EQUIPE="+nom1);
		int num1 = reqMatch.recup(stmt);
		reqMatch = new RequestSQL("select NUMERO_EQUIPE from EQUIPE where NOM_EQUIPE="+nom2);
		int num2 = reqMatch.recup(stmt);
		r = new RequestSQL("insert into RENCONTRE values("+ mNum + ",'" + mDate + "'," + score1 + "," + score2 + "," + num1 + "," + num2 + ")");
		r.execUp(stmt);
	    case 4:
		break;
	    default:
		System.out.println("Ceci ne peut pas etre fait");
	    }

	}catch(Exception e){
	    System.out.println("Erreur : " + e.getMessage());	    
	}	
    }

    static void deleteInTable(Statement stmt){

	RequestSQL r;
	Scanner sc = new Scanner(System.in);
	System.out.println("Dans quelle table souhaitez vous faire une suppression?");
	System.out.println("1-Club ");
	System.out.println("2-Joueur ");
	System.out.println("3-Match ");
	System.out.println("4-Retour au menu principal ");

	int choix = sc.nextInt();
	sc.nextLine();
	switch(choix){

	case(1):
	    System.out.println("Entrez le numero du club que vous voulez supprimer :");
	    int numclub = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("delete from CLUB where CLUB.numero_CLUB = "+ numclub);
	    r.execUp(stmt);
	    break;

	case(2):
	    System.out.println("Entrez le numero de licence du joueur que vous voulez supprimer :");
	    int numLi = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("delete from joueur where joueur.numero_licence = "+ numLi);
	    r.execUp(stmt);
	    break;
	case(3):
	    System.out.println("Entrez le numero du match que vous voulez supprimer :");
	    int numMatch = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("delete from RENCONTRE where RENCONTRE.numero_rencontre = "+ numMatch);
	    r.execUp(stmt);
	    break;
	case(4):
	    break;
	default:
	    System.out.println("ce que vous avez rentre n'est pas  un choix valide");

	}
    }

	static void modifyInTable(Statement stmt){

	    RequestSQL r;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Dans quelle table souhaitez vous faire une modification?");
	    System.out.println("1-Club ");
	    System.out.println("2-Joueur ");
	    System.out.println("3-Match ");
	    System.out.println("4-Retour au menu principal ");

	    int choix = sc.nextInt();
	    sc.nextLine();
	    switch(choix){

	    case(1):
		System.out.println("Entrez le numero du club que vous voulez modifier :");
		int numclub = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez nouveau nom du club :");
		String clubNom = sc.nextLine();
		r = new RequestSQL("update club set club.nom_club = '" + clubNom + "' where club.numero_club = "+ numclub);
		r.execUp(stmt);
		break;

	    case(2):
		System.out.println("Entrez le numero de licence du joueur que vous voulez modifier :");
		int numLi = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez nouveau nom du joueur :");
		String joueurNom = sc.nextLine();
		r = new RequestSQL("update joueur set joueur.nom_joueur = '" + joueurNom + "' where joueur.numero_licence = " + numLi);
		r.execUp(stmt);
		break;
	    case(3):
		System.out.println("Entrez le numero du match que vous voulez modifier:");
		int numMatch = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez nouveau score de l'equipe 1 :");
		int score1 = sc.nextInt();
		sc.nextLine();
		r = new RequestSQL("update rencontre set rencontre.score_equipe1_rencontre = " + score1 + "5 where rencontre.numero_equipe1 = " + numMatch);
		r.execUp(stmt);
		break;
	    case(4):
		break;
	    default:
		System.out.println("ce que vous avez rentre n'est pas  un choix valide");

	    }

	}
}
