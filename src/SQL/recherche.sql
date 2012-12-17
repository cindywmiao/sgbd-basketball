
-- Recherche un joueur par son identifiant
--input : NUMERO_LICENCE
select * from JOUEUR where NUMERO_LICENCE = 1 ;

-- Recherche un joueur par son nom
--input : NOM_JOUEUR
select * from JOUEUR where NOM_JOUEUR = 'POIRET' ;

-- Recherche un joueur par son prenom
--input PRENOM_JOUEUR
select * from JOUEUR where PRENOM_JOUEUR = 'NATHAN';




--Rechercher un entraineur par son identifiant
--input NUMERO_ENTRAINEUR
select * from ENTRAINEUR where NUMERO_ENTRAINEUR = 1;

--Rechercher un entraineur par son nom
--input : NOM_ENTRAINEUR
select * from ENTRAINEUR where NOM_ENTRAINEUR = 'DUBOIS';

--Rechercher un entraineur par son prenom 
--input : PRENOM_ENTRAINEUR
select * from ENTRAINEUR where PRENOM_ENTRAINEUR = 'ALAIN';

--Rechercher l'entraineur d'une equipe donnee
--input : NOM_EQUIPE
select * from ENTRAINEUR where NUMERO_ENTRAINEUR = (select NUMERO_ENTRAINEUR from ENTRAINE where NUMERO_EQUIPE = (select  NUMERO_EQUIPE from EQUIPE where NOM_EQUIPE = 'US')); 




--Rechercher un club par son numero
--input : NUMERO_CLUB
select * from CLUB where NUMERO_CLUB = 1;

--Rechercher un club par son nom
--input : NOM_CLUB
select * from CLUB where NOM_CLUB = 'AIGLES';




-- Recherche le club d'une personne donnée
--input :  nom_personne
select * from CLUB where NUMERO_CLUB = (select NUMERO_CLUB from PERSONNE where NOM_PERSONNE = '?');

 

--Rechercher une equipe par son numero
--input : NUMERO_EQUIPE
select * from EQUIPE where NUMERO_EQUIPE = 1;

--Rechercher une equipe par son nom
--input NOM_EQUIPE
select * from EQUIPE where NOM_EQUIPE = 'US';

--Rechercher une equipe d'un joueur donne
--input NOM_JOUEUR
select * from EQUIPE where NUMERO_EQUIPE = (select NUMERO_EQUIPE from JOUEUR where NOM_JOUEUR = 'MONTAND');

--Rechercher une equipe par son entraineur
--input NOM_ENTRAINEUR
select * from EQUIPE where NUMERO_EQUIPE = (select NUMERO_EQUIPE from ENTRAINE where NUMERO_ENTRAINEUR = (select NUMERO_ENTRAINEUR from ENTRAINEUR where NOM_ENTRAINEUR = 'GARCIA'));

--Rechercher les equipes d une categorie donnee 
--input NOM_CATEGORIE
select NOM_EQUIPE from EQUIPE where NUMERO_CATEGORIE = (select NUMERO_CATEGORIE from CATEGORIE where NOM_CATEGORIE = 'CADET');





--Rechercher le president d'un club donne
--input : NOM_CLUB
select * from PERSONNE where FONCTION_PERSONNE = 'PRESIDENT' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = 'ESPERANCE');

--Rechercher le vice-president d'un club donne
--input : NOM_CLUB
select * from PERSONNE where FONCTION_PERSONNE = 'VICE-PRESIDENT' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = 'ESPERANCE');

--Rechercher le tresorier d'un club donne
--input : NOM_CLUB
select * from PERSONNE where FONCTION_PERSONNE = 'TRESORIER' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = 'ESPERANCE');

--Rechercher le secretaire d'un club donne
--input : NOM_CLUB
select * from PERSONNE where FONCTION_PERSONNE = 'SECRETAIRE' and NUMERO_CLUB = (select NUMERO_CLUB from CLUB where NOM_CLUB = 'ESPERANCE');


--Rechercher les dates des rencontres dans lesquelles a joue un joueur donne
--input : NOM_JOUEUR
select DATE_RENCONTRE from RENCONTRE where NUMERO_RENCONTRE in (select NUMERO_RENCONTRE from PARTICIPE where NUMERO_LICENCE = (select NUMERO_LICENCE from JOUEUR where NOM_JOUEUR = 'MONTAND'));

--Rechercher le nombre de points marques par un joueur a une rencontre donnee
--input : NUMERO_LICENCE et DATE_RENCONTRE

select participe.cumul_points_marques_joueur
from rencontre,participe 
where participe.numero_licence = 2 and participe.numero_rencontre = rencontre.numero_rencontre and rencontre.date_rencontre = '01-APR-12';


--Rechercher le nombre de fautes commises par un joueur a une rencontre donnee
--input : NUMERO_LICENCE et DATE_RENCONTRE
select participe.cumul_fautes_joueur
from rencontre,participe 
where participe.numero_licence = 2 and participe.numero_rencontre = rencontre.numero_rencontre and rencontre.date_rencontre = '01-APR-12';

-- La feuille du match à une date donnée --
-- Input : date --
-- Exemple date : 21-feb-87 --

(select distinct NOM_EQUIPE as EQUIPE , SCORE_EQUIPE1_RENCONTRE as SCORE_EQUIPE  from EQUIPE E, RENCONTRE R, PARTICIPE P where E.NUMERO_EQUIPE = R.NUMERO_EQUIPE1 and R.NUMERO_RENCONTRE = P.NUMERO_RENCONTRE and R.DATE_RENCONTRE = '21-feb-12' )
union
(select distinct NOM_EQUIPE as EQUIPE , SCORE_EQUIPE2_RENCONTRE as SCORE_EQUIPE from EQUIPE E, RENCONTRE R, PARTICIPE P where E.NUMERO_EQUIPE = R.NUMERO_EQUIPE2 and R.NUMERO_RENCONTRE = P.NUMERO_RENCONTRE and R.DATE_RENCONTRE = '21-feb-12');

-- La liste des joueurs à une date donnée --
-- input : date --
-- Exemple date = 13-OCT-81 --

select NOM_JOUEUR from JOUEUR J, PARTICIPE P, RENCONTRE R where J.NUMERO_LICENCE = P.NUMERO_LICENCE and P.NUMERO_RENCONTRE = R.NUMERO_RENCONTRE and R.DATE_RENCONTRE = '28-JUN-08' ;

-- Les scores des matchs joués à une date donnée --
-- Exemple de date : '24-FEB-87' --
-- Input : date --
select rencontre.score_equipe1_rencontre as Equipe1 , rencontre.score_equipe2_rencontre as Equipe2
from rencontre
where rencontre.date_rencontre = '13-OCT-12'; 
