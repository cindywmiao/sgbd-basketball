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