-- Pour un club, on veut le nombre de matchs gagnés, perdus ou nuls --

---matchs gagnes
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


--matchs perdus
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


--matchs nuls
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
