-- Commande 1 --
-- Moyenne des points marquée par rencontre à une date donnée
-- Input : date_rencontre (type date)
select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS
from participe, rencontre
where rencontre.date_rencontre = '21-FEB-87'
      and rencontre.numero_rencontre = participe.numero_rencontre;

-- Commande 2 --
-- Moyenne des points marquée depuis le début de la saison --
-- Input : date de début de la saison
select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS
from joueur, participe, rencontre
where rencontre.date_rencontre > '21-FEB-87'
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
select numero, sum(score) as S
from(
(select rencontre.numero_equipe1 as NUMERO , rencontre.score_equipe1_rencontre as SCORE
from rencontre)
union
(select rencontre.numero_equipe2 as NUMERO , rencontre.score_equipe2_rencontre as SCORE
from rencontre))
group by NUMERO
order by S DESC;