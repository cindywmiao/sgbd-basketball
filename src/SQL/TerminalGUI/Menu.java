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
	    System.out.println("3-Match ");
	    System.out.println("4-Equipe ");
	    System.out.println("5-Categorie ");
	    System.out.println("6-Entraineur \n");

 	    System.out.println("7-Statistiques\n");

	
	    System.out.println("8-Mettre a jour\n");

	    System.out.println("9-Chercher une information precise dans la table\n");
	    
	    System.out.println("10-Utiliser une requete personnelle\n");

	    System.out.println("11-Quitter\n");

	    b = Menu.commande(stmt);
	
	}
    }

    static boolean commande(Statement stmt){
	boolean b = true;
	Scanner sc = new Scanner(System.in);
	String date;
	RequestSQL r;

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
		Menu.statistiques(stmt);
		break;

	    case(8):
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
	    case(9):
		Menu.findSth(stmt);
		break;
	    case(10):
		System.out.println("Entrez votre requete sans ';'");
		String text = sc.nextLine();
		r = new RequestSQL(text);
		r.execRequest(stmt);
		break;
	    case(11):
		return false;
		
	    default:
		System.out.println("Commande rentree invalide");
		break;
	    }
	}catch(Exception e){
	    System.out.println("echec : " + e.getMessage());
	}finally{
	    System.out.println("Appuyez sur entree pour continuer");
	    sc.nextLine();
	}

	return true;
    }

    static void statistiques(Statement stmt){
	RequestSQL r;
	String date;
	Scanner sc = new Scanner(System.in);
	int cat = 0, choix;
	String categorie = "";

	System.out.println("Sleectionnez les statistiques que vous voulez afficher : ");
	System.out.println("1-Moyenne des points marques par rencontre");
	System.out.println("2-Moyenne des points marques depuis le debut de la saison");
	System.out.println("3-Classement des meilleurs joueurs par categorie");
	System.out.println("4-Classement des equipes par cumul des scores");
	System.out.println("5-Classement des equipes par classement total des points.(1 match gagne = 3pts, un match nul = 1pts, un match perdu = 0pts)\n");
	System.out.println("6-Revenir au menu principal");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    System.out.println("Rentrez une date au format dd-MMM-aa(par exemple 21-FEB-12)");
	    date = sc.nextLine();
	    r = new RequestSQL("select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS from participe, rencontre where rencontre.date_rencontre = '" + date + "' and rencontre.numero_rencontre = participe.numero_rencontre");
	    r.execRequest(stmt);
	    break;
	case(2):
	    System.out.println("Rentrez l'annee qui vous interesse au format aa(par exemple '12' pour 2012)");
	    int annee = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS from joueur, participe, rencontre where rencontre.date_rencontre > '01-JAN-" + annee + "' and rencontre.numero_rencontre = participe.numero_rencontre");
	    r.execRequest(stmt);
	    break;
	case(3):
	    while(cat == 0){
		System.out.println("Rentrez l'une des categorie suivante : CADET, BENJAMIN, JUNIOR");
		categorie = sc.nextLine();
		if (categorie.equals("cadet"))
		    cat = 1;
		else if(categorie.equalsIgnoreCase("benjamin"))
		    cat = 2;
		else if(categorie.equalsIgnoreCase("junior"))
		    cat = 3;
		else{
		    System.out.println("La categorie choisi est invalide. Si vous ne souhaitez pas choisir une categorie taper 'q' sinon tapez entree");
		    if (sc.nextLine().equalsIgnoreCase("q"))
			break;
		}
	    }
	    System.out.println("Rentrez la date de debut de la saison format dd-MMM-aa(par exemple 21-FEB-12)");
	    date = sc.nextLine();
	    r = new RequestSQL("select joueur.numero_licence, sum(participe.cumul_points_marques_joueur) as SCORE from joueur, participe, rencontre, equipe where equipe.numero_categorie = "+ cat +" and rencontre.date_rencontre = '"+ date +"' and equipe.numero_equipe = joueur.numero_equipe and joueur.numero_licence = participe.numero_licence and participe.numero_rencontre = rencontre.numero_rencontre group by joueur.numero_licence order by score DESC");
	    r.execRequest(stmt);
	    break;

	case(4):
	    while(cat == 0){
		System.out.println("Rentrez l'une des categorie suivante : CADET, BENJAMIN, JUNIOR");
		categorie = sc.nextLine();
		if (categorie.equals("benjamin"))
		    cat = 1;
		else if(categorie.equalsIgnoreCase("cadet"))
		    cat = 2;
		else if(categorie.equalsIgnoreCase("junior"))
		    cat = 3;
		else{
		    System.out.println("La categorie choisi est invalide. Si vous ne souhaitez pas choisir une categorie taper 'q' sinon tapez entree");
		    if (sc.nextLine().equalsIgnoreCase("q"))
			break;
		}
	    }
	    r = new RequestSQL("select nom_equipe, score from equipe E, (select num_equipe, sum(score) as Score from( (select rencontre.numero_equipe1 as NUM_EQUIPE , rencontre.score_equipe1_rencontre as SCORE from rencontre) union (select rencontre.numero_equipe2 as NUM_EQUIPE , rencontre.score_equipe2_rencontre as SCORE from rencontre)) group by NUM_EQUIPE order by Score DESC) where E.numero_equipe = num_equipe and E.numero_categorie = "+ cat +"");

	    r.execRequest(stmt);
	    break;

	case(5):
	    while(cat == 0){
		System.out.println("Rentrez l'une des categorie suivante : CADET, BENJAMIN, JUNIOR");
		categorie = sc.nextLine();
		if (categorie.equals("benjamin"))
		    cat = 1;
		else if(categorie.equalsIgnoreCase("cadet"))
		    cat = 2;
		else if(categorie.equalsIgnoreCase("junior"))
		    cat = 3;
		else{
		    System.out.println("La categorie choisi est invalide. Si vous ne souhaitez pas choisir une categorie taper 'q' sinon tapez entree");
		    if (sc.nextLine().equalsIgnoreCase("q"))
			break;
		}
	    }
	    r = new RequestSQL("select nom_club as club ,nom_equipe as equipe , sum(points) as total from equipe E, club C, ((select numero_equipe1 as num_equipe , sum(case when score_equipe1_rencontre > score_equipe2_rencontre then 3 when score_equipe1_rencontre = score_equipe2_rencontre then 1 when score_equipe1_rencontre < score_equipe2_rencontre then 0 end) as points from rencontre group by numero_equipe1) union (select numero_equipe2 as num_equipe , sum(case when score_equipe2_rencontre > score_equipe1_rencontre then 3 when score_equipe2_rencontre = score_equipe1_rencontre then 1 when score_equipe2_rencontre < score_equipe1_rencontre then 0 end) as points from rencontre group by numero_equipe2)) where E.numero_equipe = num_equipe and E.numero_club = C.numero_club and E.numero_categorie = "+ cat +" group by nom_equipe, nom_club order by total desc");

	    r.execRequest(stmt);
	    break;
	case(6):
	    break;
	}

    }

    static void addInTable(Statement stmt){

	System.out.println("Que souhaitez vous ajouter?");
	System.out.println("1-Club ");
	System.out.println("2-Joueur ");
	System.out.println("3-Match ");
	System.out.println("4-Retour au menu principal ");

	String nom;
	Scanner sc = new Scanner(System.in);
	int tab = sc.nextInt();
	sc.nextLine();
	RequestSQL r;
	try{

	    switch(tab){
	    case(1):
		System.out.println("Quel est le nom du nouveau club?");
		String Nom = sc.nextLine();
		r = new RequestSQL("insert into CLUB ( NOM_CLUB) values ('" + Nom+ "')");
		r.execUp(stmt);
		break;

	    case(2):	
		System.out.println("Quel est le nom du nouveau joueur?");
		String nom = sc.nextLine();
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
		r = new RequestSQL("insert into JOUEUR  (NOM_JOUEUR, PRENOM_JOUEUR, DATE_de_NAISSANCE_JOUEUR, ADRESSE_JOUEUR, DATE_ENTREE_CLUB_JOUEUR, NUMERO_EQUIPE) values ('" + name + "','" + firstName + "','" + birthday + "','" + town + "', '" + dateEnt + "'," + numTeam + ")");
		r.execUp(stmt);
		break;

	    case(3):
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

		reqMatch = new RequestSQL("select NUMERO_EQUIPE from EQUIPE where NOM_EQUIPE='" + nom1 + "'");
		int num1 = reqMatch.recup(stmt);
		reqMatch = new RequestSQL("select NUMERO_EQUIPE from EQUIPE where NOM_EQUIPE='" + nom2 + "'");
		int num2 = reqMatch.recup(stmt);
		r = new RequestSQL("insert into RENCONTRE  (DATE_RENCONTRE, SCORE_EQUIPE1_RENCONTRE, SCORE_EQUIPE2_RENCONTRE, NUMERO_EQUIPE1, NUMERO_EQUIPE2) values('"+ mDate + "'," + score1 + "," + score2 + "," + num1 + "," + num2 + ")");
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
	RequestSQL r2;
	int max;

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
	    r2 = new RequestSQL("select max(NUMERO_CLUB) from club");
	    max = r2.recup(stmt);

	    System.out.println("Entrez le numero du club que vous voulez supprimer(inferieur a " + max + " :");
	    int numclub = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("delete from CLUB where CLUB.numero_CLUB = "+ numclub);
	    r.execUp(stmt);
	    break;

	case(2):
	    r2 = new RequestSQL("select max(NUMERO_LICENCE) from joueur");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero de licence du joueur que vous voulez supprimer(superieur a : " + max + " :");
	    int numLi = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("delete from joueur where joueur.numero_licence = "+ numLi);
	    r.execUp(stmt);
	    break;
	case(3):
		RequestSQL req = new RequestSQL("select max(NUMERO_RENCONTRE) from rencontre");
		max = req.recup(stmt);
	    System.out.println("Entrez le numero du match que vous voulez supprimer(inferieur a " + max + " :");
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
	    RequestSQL r2;
	    int max;

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
		r2 = new RequestSQL("select max(NUMERO_CLUB) from club");
		max = r2.recup(stmt);
		System.out.println("Entrez le numero du club que vous voulez modifier(inferieur a " + max + " :");
		int numclub = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez nouveau nom du club :");
		String clubNom = sc.nextLine();
		r = new RequestSQL("update club set club.nom_club = '" + clubNom + "' where club.numero_club = "+ numclub);
		r.execUp(stmt);
		break;

	    case(2):
		r2 = new RequestSQL("select max(NUMERO_LICENCE) from joueur");
		max = r2.recup(stmt);
		System.out.println("Entrez le numero du joueur que vous voulez modifier(inferieur a " + max + " :");

		int numLi = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez nouveau nom du joueur :");
		String joueurNom = sc.nextLine();
		r = new RequestSQL("update joueur set joueur.nom_joueur = '" + joueurNom + "' where joueur.numero_licence = " + numLi);
		r.execUp(stmt);
		break;
	    case(3):
		r2 = new RequestSQL("select max(NUMERO_RENCONTRE) from rencontre");
		max = r2.recup(stmt);
		System.out.println("Entrez le numero du match que vous voulez modifier(inferieur ou egale a " + max + ") :");
		int numMatch = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez nouveau score de l'equipe 1 :");
		int score1 = sc.nextInt();
		sc.nextLine();
		r = new RequestSQL("update rencontre set rencontre.score_equipe1_rencontre = " + score1 + " where rencontre.numero_rencontre = " + numMatch);
		r.execUp(stmt);
		break;
	    case(4):
		break;
	    default:
		System.out.println("ce que vous avez rentre n'est pas  un choix valide");

	    }

	}
    static void findSth(Statement stmt){
	Scanner sc = new Scanner(System.in);
	int choix;

	System.out.println("Selectionner le theme sur lequel vous voulez trouver des information :");
	System.out.println("1-joueur");
	System.out.println("2-club");
	System.out.println("3-entraineur");
	System.out.println("4-equipe");
	System.out.println("5-match");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    Menu.findPlayer(stmt);
	    break;
	case(2):
	    Menu.findClub(stmt);
	    break;
	case(3):
	    Menu.findTrainer(stmt);
	    break;
	case(4):
	    Menu.findTeam(stmt);
	    break;
	case(5):
	    Menu.findMatch(stmt);

	}
    }

    static void findPlayer(Statement stmt){
	Scanner sc = new Scanner(System.in);
	int choix;
	RequestSQL r;
	RequestSQL r2;
	int max;

	System.out.println("Vous voulez trouver par : ");
	System.out.println("1-Numero de licence");
	System.out.println("2-Nom");
	System.out.println("3-Prenom");
	System.out.println("4-Revenir au menu principal");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    r2 = new RequestSQL("select max(NUMERO_LICENCE) from joueur");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero de licence(inferieur ou egal a " + max + ") :");
	    int numLi = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("select * from JOUEUR where NUMERO_LICENCE = " + numLi);
	    r.execRequest(stmt);
	    break;
	case(2):
	    System.out.println("Entrez le nom :");
	    String nom = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from JOUEUR where NOM_JOUEUR = '" + nom + "'");
	    r.execRequest(stmt);
	    break;
	case(3):
	    System.out.println("Entrez le prenom :");
	    String prenom = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from JOUEUR where PRENOM_JOUEUR = '" + prenom + "'");
		r.execRequest(stmt);
	    break;
	case(4):
	    break;
	}
    }

    static void findClub(Statement stmt){
	Scanner sc = new Scanner(System.in);
	int choix, reponse = 0;
	RequestSQL r;
	RequestSQL r2;
	int max;
	String var;



	System.out.println("\nVous voulez trouver un club par: ");
	System.out.println("1-Numero de club");
	System.out.println("2-Nom");
	System.out.println("3-Personne donnee appartenant au club");
	System.out.println("4-Joueur donnee appartenant au club");
	System.out.println("5-un membre du bureau d'un club : \n");
	System.out.println("Ou vous souhaitez afficher : ");

	System.out.println("6-Les numeros avec le club correspondant");	
	System.out.println("7-Les equipes avec le club correspondant");
	System.out.println("8-Les joueurs et leur club");
	System.out.println("9-Le nombre de match gagnes, perdus et nuls pour un club");
	System.out.println("\n11-Revenir au menu principal");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    r2 = new RequestSQL("select max(NUMERO_CLUB) from club");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero de club(inferieur ou egal a " + max + ") :");
	    int numLi = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("select * from CLUB where NUMERO_CLUB = " + numLi);
		r.execRequest(stmt);
	    break;
	case(2):
	    System.out.println("Entrez le nom :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from CLUB where NOM_CLUB = '" + var + "'");
		r.execRequest(stmt);
	    break;
	case(3):
	    System.out.println("Entrez le nom de la personne:");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from CLUB where NUMERO_CLUB = (select NUMERO_CLUB from PERSONNE where NOM_PERSONNE = '" + var + "')");
		r.execRequest(stmt);
	    break;
	case(4):
	    System.out.println("Entrez le nom du joueur :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from CLUB where NUMERO_CLUB = (select NUMERO_CLUB from JOUEUR where NOM_JOUEUR = '" + var + "')");
		r.execRequest(stmt);
	    break;
	case(5):
	    System.out.println("Entrez le nom d'un club :");
	    String club = sc.nextLine().toUpperCase();
	    while(reponse != 5){
		System.out.println("Vous souhaitez chercher :");
		System.out.println("1-Le president");
		System.out.println("2-Le vice-president");
		System.out.println("3-Le tresorier");
		System.out.println("4-Le secretaire");
		System.out.println("5-Revenir au menu principal");
		reponse = sc.nextInt();
	    
		switch(reponse){
		case(1):
		    r = new RequestSQL("select * from PERSONNE where FONCTION_PERSONNE = 'PRESIDENT' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = '" + club + "')");
		    r.execRequest(stmt);
		    break;
		case(2):
		    r = new RequestSQL("select * from PERSONNE where FONCTION_PERSONNE = 'VICE-PRESIDENT' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = '" + club + "')");
		    r.execRequest(stmt);
		    break;
		case(3):
		    r = new RequestSQL("select * from PERSONNE where FONCTION_PERSONNE = 'TRESORIER' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = '" + club + "')");
		    r.execRequest(stmt);
		    break;
		case(4):
		    r = new RequestSQL("select * from PERSONNE where FONCTION_PERSONNE = 'SECRETAIRE' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = '" + club + "')");
		    r.execRequest(stmt);
		    break;
		case(5):
		    break;
		}
	    }
	    break;
	case(6):
	    r = new RequestSQL("select club.numero_club as NR, club.nom_club as NOM from club");
		r.execRequest(stmt);
	    break;
	case(7):
	    r = new RequestSQL("select equipe.numero_equipe, equipe.nom_equipe, club.nom_club, categorie.nom_categorie from equipe, club, categorie where equipe.numero_club = club.numero_club and equipe.numero_categorie = categorie.numero_categorie");
		r.execRequest(stmt);
	    break;
	case(8):
	    r = new RequestSQL("select joueur.numero_licence, joueur.nom_joueur, joueur.prenom_joueur, equipe.nom_equipe from joueur,equipe where joueur.numero_equipe = equipe.numero_equipe");
		r.execRequest(stmt);
	    break;

	case(9):
	    r2 = new RequestSQL("select max(NUMERO_CLUB) from club");
	    max = r2.recup(stmt);
	    System.out.println("Ecrivez le numero du club dont vous souhaitez voir les resultats(inferieur ou egale a "+ max +") : ");
	    int numCl = sc.nextInt();
	    sc.nextLine();
	    
	    r = new RequestSQL("select count(*) as GAGNER from( (select * from club, equipe, rencontre where equipe.numero_equipe = rencontre.numero_equipe1       and rencontre.score_equipe1_rencontre > rencontre.score_equipe2_rencontre      and equipe.numero_club = club.numero_club      and club.numero_club ="+ numCl +") union (select * from club, equipe, rencontre where equipe.numero_equipe = rencontre.numero_equipe2      and rencontre.score_equipe2_rencontre > rencontre.score_equipe1_rencontre      and equipe.numero_club = club.numero_club      and club.numero_club = "+ numCl +"))");
	    System.out.println("Matchs gagner :");
	    r.execRequest(stmt);

	    r = new RequestSQL("select count(*) as PERDU from((select *from club, equipe, rencontre where equipe.numero_equipe = rencontre.numero_equipe1       and rencontre.score_equipe1_rencontre < rencontre.score_equipe2_rencontre      and equipe.numero_club = club.numero_club      and club.numero_club =  "+ numCl +")union(select *from club, equipe, rencontre where equipe.numero_equipe = rencontre.numero_equipe2      and rencontre.score_equipe2_rencontre < rencontre.score_equipe1_rencontre      and equipe.numero_club = club.numero_club      and club.numero_club =  "+ numCl +"))");
	    System.out.println("Matchs perdus :");
	    r.execRequest(stmt);

	    r = new RequestSQL("select count(*) as NULS from( (select * from club, equipe, rencontre where equipe.numero_equipe = rencontre.numero_equipe1       and rencontre.score_equipe1_rencontre = rencontre.score_equipe2_rencontre      and equipe.numero_club = club.numero_club      and club.numero_club =  "+ numCl +")union(select *from club, equipe, rencontre where equipe.numero_equipe = rencontre.numero_equipe2      and rencontre.score_equipe2_rencontre = rencontre.score_equipe1_rencontre      and equipe.numero_club = club.numero_club      and club.numero_club =  "+ numCl +") )");
	    System.out.println("Matchs nuls :");
	    r.execRequest(stmt);

	    break;
	case(10):
	    break;
	}
    }


    static void findTrainer(Statement stmt){
	Scanner sc = new Scanner(System.in);
	int choix, max;
	RequestSQL r, r2;
	String var;


	System.out.println("Vous voulez trouver par : ");
	System.out.println("1-Numero d'entraineur");
	System.out.println("2-Nom");
	System.out.println("3-Prenom");
	System.out.println("4-Entraineur d'une equipe");	
	System.out.println("5-Revenir au menu principal");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    r2 = new RequestSQL("select max(NUMERO_ENTRAINEUR) from entraineur");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero d'un entraineur(inferieur ou egal a " + max + ") :");
	    int numLi = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("select * from ENTRAINEUR where NUMERO_ENTRAINEUR = " + numLi);
		r.execRequest(stmt);
	    break;
	case(2):
	    System.out.println("Entrez le nom :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from ENTRAINEUR where NOM_ENTRAINEUR = '" + var + "'");
		r.execRequest(stmt);
	    break;
	case(3):
	    System.out.println("Entrez le prenom :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from ENTRAINEUR where PRENOM_ENTRAINEUR = '" + var + "'");
		r.execRequest(stmt);
	    break;
	case(4):
	    System.out.println("Entrez le nom d'une equipe :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from ENTRAINEUR where NUMERO_ENTRAINEUR = (select NUMERO_ENTRAINEUR from ENTRAINE where NUMERO_EQUIPE = (select  NUMERO_EQUIPE from EQUIPE where NOM_EQUIPE = '" + var + "'))");
		r.execRequest(stmt);
	    break;
	case(5):
	    break;
	}
    }


    static void findTeam(Statement stmt){
	Scanner sc = new Scanner(System.in);
	int choix, max;
	RequestSQL r, r2;
	String var;

	System.out.println("Vous voulez trouver par : ");
	System.out.println("1-Numero d'equipe");
	System.out.println("2-Nom");
	System.out.println("3-Joueur donnee appartenant a l'equipe");
	System.out.println("4-Entraineur");
	System.out.println("5-Pour une categorie donnee");
	System.out.println("6-Revenir au menu principal");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    r2 = new RequestSQL("select max(NUMERO_EQUIPE) from equipe");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero d'une equipe(inferieur ou egal a " + max + ") :");

	    int numLi = sc.nextInt();
	    sc.nextLine();
	    r = new RequestSQL("select * from EQUIPE where NUMERO_EQUIPE = " + numLi);
		r.execRequest(stmt);
	    break;
	case(2):
	    System.out.println("Entrez le nom :");
	    var = sc.nextLine();
	    r = new RequestSQL("select * from EQUIPE where NOM_EQUIPE = '" + var + "'");
		r.execRequest(stmt);
	    break;
	case(3):
	    System.out.println("Entrez le nom d'un joueur :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from EQUIPE where NUMERO_EQUIPE = (select NUMERO_EQUIPE from JOUEUR where NOM_JOUEUR = '" + var + "')");
		r.execRequest(stmt);
	    break;
	case(4):
	    System.out.println("Entrez le nom d'un entraineur :");
	    var = sc.nextLine().toUpperCase();
	    r = new RequestSQL("select * from EQUIPE where NUMERO_EQUIPE = (select NUMERO_EQUIPE from ENTRAINE where NUMERO_ENTRAINEUR = (select NUMERO_ENTRAINEUR from ENTRAINEUR where NOM_ENTRAINEUR = '" + var + "'))");
		r.execRequest(stmt);
	    break;
	case(5):

	    do{
		System.out.println("Entrez le nom d'une categorie(junior, cadet ou poussin) :");
		var = sc.nextLine().toUpperCase();
		if(var.equals("POUSSIN") || var.equals("CADET") || var.equals("JUNIOR")){
		    r = new RequestSQL("select NOM_EQUIPE from EQUIPE where NUMERO_CATEGORIE = (select NUMERO_CATEGORIE from CATEGORIE where NOM_CATEGORIE = '" + var + "')");
		    r.execRequest(stmt);
		}
		else
		    System.out.println("Le nom de categorie rentre n'est pas valide.");
	    }while(!(var.equals("POUSSIN") || var.equals("CADET") || var.equals("JUNIOR")));
	    break;
	case(6):
	    break;
	}
    }


    static void findMatch(Statement stmt){
	Scanner sc = new Scanner(System.in);
	int choix, max, numLi;
	RequestSQL r, r2;
	String var, date;

	System.out.println("Vous voulez trouver : ");
	System.out.println("1-Les dates des rencontres auxquelle a pris part un joueur donnee");
	System.out.println("2-Le nombre de point marque par un joueur dans une rencontre donnee");
	System.out.println("3-Le nombre de fautes commises par un joueur lors d'une rencontre donnee");
	System.out.println("4-Le score des matchs joues a une date donnee");
	System.out.println("5-Revenir au menu principal");

	choix = sc.nextInt();
	sc.nextLine();

	switch(choix){
	case(1):
	    System.out.println("Entrez le nom du joueur dont vous voulez voir les matchs :");
	    var = sc.nextLine();
	    r = new RequestSQL("select DATE_RENCONTRE from RENCONTRE where NUMERO_RENCONTRE in (select NUMERO_RENCONTRE from PARTICIPE where NUMERO_LICENCE = (select NUMERO_LICENCE from JOUEUR where NOM_JOUEUR = '"+ var + "'))");
		r.execRequest(stmt);
	    break;
	case(2):

	    System.out.println("Rentrez la date du match au format dd-MM-aa(par exemple 21-FEB-12)");
	    date = sc.nextLine();

	    r2 = new RequestSQL("select max(NUMERO_LICENCE) from joueur");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero d'un joueur(inferieur ou egal a " + max + ") :");
	     numLi = sc.nextInt();
	    sc.nextLine();

	    r = new RequestSQL("select participe.cumul_points_marques_joueur from rencontre,participe where participe.numero_licence = "+ numLi +" and participe.numero_rencontre = rencontre.numero_rencontre and rencontre.date_rencontre = '" + date + "'");
		r.execRequest(stmt);
	    break;

	case(3):
	    System.out.println("Rentrez la date du match au format dd-MM-aa(par exemple 21-FEB-12)");
	    date = sc.nextLine();

	    r2 = new RequestSQL("select max(NUMERO_LICENCE) from joueur");
	    max = r2.recup(stmt);
	    System.out.println("Entrez le numero d'un joueur(inferieur ou egal a " + max + ") :");
	     numLi = sc.nextInt();
	    sc.nextLine();

	    r = new RequestSQL("select participe.cumul_fautes_joueur from rencontre,participe where participe.numero_licence = "+ numLi +" and participe.numero_rencontre = rencontre.numero_rencontre and rencontre.date_rencontre = '"+ date +"'");
		r.execRequest(stmt);
	    break;
	case(4):
	    System.out.println("Veuillez donner la date qui vous interesse au format jj-moi-aa(par exemple 21-FEB-12) : ");
	    date = sc.nextLine();
	    r = new RequestSQL("select rencontre.score_equipe1_rencontre as Equipe1 , rencontre.score_equipe2_rencontre as Equipe2 from rencontre where rencontre.date_rencontre = '" + date + "'");
	    r.execRequest(stmt);
	    break;

	case(5):
	    break;
	}
    }

}

