-- Informations sur les clubs, les équipes, les joueurs --

-- Les clubs --
-- Input : None --
-- Output : Informations des clubs --

select club.numero_club as NR, 
       club.nom_club as NOM,
       president  as P , 
       vice_president as VP ,	
       tresorier as T, 
       secretaire as S
from club, bureau
where club.numero_bureau = bureau.numero_bureau;

-- Les équipes --
-- Input : None --
-- Output : Informations des équipes --

select equipe.numero_equipe, equipe.nom_equipe, club.nom_club, categorie.nom_categorie
from equipe, club, categorie
where equipe.numero_club = club.numero_club and equipe.numero_categorie = categorie.numero_categorie;

-- Les joueurs --
-- Input : None --
-- Output : Informations des joueurs --

select joueur.numero_licence, joueur.nom_joueur, joueur.prenom_joueur, joueur.date_de_naissance_joueur, joueur.adresse_joueur, joueur.date_entree_club_joueur, equipe.nom_equipe
from joueur,equipe
where joueur.numero_equipe = equipe.numero_equipe;

-- Les scores des matchs joués à une date donnée --
-- Input : date --

select rencontre.score_equipe1_rencontre as Equipe1 , rencontre.score_equipe2_rencontre as Equipe2
from rencontre
where rencontre.date_rencontre = '21-FEB-87'; 

-- Pour un club, on veut le nombre de matchs gagnés, perdus ou nuls --
-- Input : numero du club --

select count(*) as GAGNER
from(
(select *
from club, equipe, rencontre
where equipe.numero_equipe = rencontre.numero_equipe1 
      and rencontre.score_equipe1_rencontre > rencontre.score_equipe2_rencontre
      and equipe.numero_club = club.numero_club
      and club.numero_club = 2)
union
(select *
from club, equipe, rencontre 
where equipe.numero_equipe = rencontre.numero_equipe2
      and rencontre.score_equipe2_rencontre > rencontre.score_equipe1_rencontre
      and equipe.numero_club = club.numero_club
      and club.numero_club = 2)
);

select count(*) as PERDU
from(
(select *
from club, equipe, rencontre
where equipe.numero_equipe = rencontre.numero_equipe1 
      and rencontre.score_equipe1_rencontre < rencontre.score_equipe2_rencontre
      and equipe.numero_club = club.numero_club
      and club.numero_club = 2)
union
(select *
from club, equipe, rencontre 
where equipe.numero_equipe = rencontre.numero_equipe2
      and rencontre.score_equipe2_rencontre < rencontre.score_equipe1_rencontre
      and equipe.numero_club = club.numero_club
      and club.numero_club = 2)
);

select count(*) as NULS
from(
(select *
from club, equipe, rencontre
where equipe.numero_equipe = rencontre.numero_equipe1 
      and rencontre.score_equipe1_rencontre = rencontre.score_equipe2_rencontre
      and equipe.numero_club = club.numero_club
      and club.numero_club = 2)
union
(select *
from club, equipe, rencontre 
where equipe.numero_equipe = rencontre.numero_equipe2
      and rencontre.score_equipe2_rencontre = rencontre.score_equipe1_rencontre
      and equipe.numero_club = club.numero_club
      and club.numero_club = 2)
);