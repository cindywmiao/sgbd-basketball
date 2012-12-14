-- Commande 1 --
-- Moyenne des points marqués par rencontre à une date donnée
-- Input : date_rencontre (type date)
select avg(participe.cumul_points_marques_joueur) as moyenne
from participe, rencontre
where rencontre.date_rencontre = '21-FEB-12'
      and rencontre.numero_rencontre = participe.numero_rencontre;

-- Commande 2 --
-- Moyenne des points marquée depuis le début de la saison --
-- Input : date de début de la saison
select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS
from joueur, participe, rencontre
where rencontre.date_rencontre > '01-JAN-07'
and rencontre.date_rencontre < '31-DEC-07'
      and rencontre.numero_rencontre = participe.numero_rencontre;

-- Commande 3 --
-- Classement des meilleurs joueurs d'une journée pour une catégorie --
-- Input : numero_categorie (type int)
-- Input : date_rencontre (type date)
select joueur.numero_licence, sum(participe.cumul_points_marques_joueur) as SCORE
from joueur, participe, rencontre, equipe
where equipe.numero_categorie = 1
      and rencontre.date_rencontre = '21-FEB-87'
      and equipe.numero_equipe = joueur.numero_equipe
      and joueur.numero_licence = participe.numero_licence
      and participe.numero_rencontre = rencontre.numero_rencontre
group by joueur.numero_licence 
order by score DESC;

-- Commande 4 --
-- Classement des équipes --


--Premiere methode : classement par cumul de score--
select num_equipe, nom_equipe, score
from equipe,(
select num_equipe, sum(score) as Score
from(
(select rencontre.numero_equipe1 as NUM_EQUIPE , rencontre.score_equipe1_rencontre as SCORE
from rencontre)
union
(select rencontre.numero_equipe2 as NUM_EQUIPE , rencontre.score_equipe2_rencontre as SCORE
from rencontre))
group by NUM_EQUIPE
order by Score DESC)
where equipe.numero_equipe = num_equipe;

--Deuxieme methode : classement pas total des points :
-------- un match gagne --> 3 points
-------- un match nul   --> 1 point
-------- un match perdu --> 0 point

select nom_club as club ,nom_equipe as equipe , sum(points) as total
from equipe E, club C,
((select numero_equipe1 as num_equipe , sum(case
when score_equipe1_rencontre > score_equipe2_rencontre 
then 3
when score_equipe1_rencontre = score_equipe2_rencontre 
then 1
when score_equipe1_rencontre < score_equipe2_rencontre
then 0
end) as points
from rencontre
group by numero_equipe1)
union
(select numero_equipe2 as num_equipe , sum(case
when score_equipe2_rencontre > score_equipe1_rencontre 
then 3
when score_equipe2_rencontre = score_equipe1_rencontre 
then 1
when score_equipe2_rencontre < score_equipe1_rencontre
then 0
end) as points
from rencontre
group by numero_equipe2))
where E.numero_equipe = num_equipe
and E.numero_club = C.numero_club
group by nom_equipe, nom_club
order by total desc;
