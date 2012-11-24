-- Moyenne des points marquée par rencontre à une date donnée
-- Input : date_rencontre (type date)

select avg(joueur.cumul_points_marques_joueur) as MOYENNE_POINTS
from joueur, participe, rencontre
where rencontre.date_rencontre = '21-FEB-87'
      and rencontre.numero_rencontre = participe.numero_rencontre
      and participe.numero_licence = joueur.numero_licence;

-- Moyenne des points marquée depuis le début de la saison --
-- Input : date de début de la saison

select avg(joueur.cumul_points_marques_joueur) as MOYENNE_POINTS
from joueur, participe, rencontre
where rencontre.date_rencontre > '21-FEB-87'
      and rencontre.numero_rencontre = participe.numero_rencontre
      and participe.numero_licence = joueur.numero_licence;

-- Classement des meilleurs joueurs d'une journée pour une catégorie --
-- Input : numero_categorie (type int)
-- Input : date_rencontre (type date)

select joueur.numero_licence, sum(rencontre.score_rencontre) as SCORE
from joueur, participe, rencontre, equipe
where equipe.numero_categorie = 1
      and rencontre.date_rencontre = '21-FEB-87'
      and equipe.numero_equipe = joueur.numero_equipe
      and joueur.numero_licence = participe.numero_licence
      and participe.numero_rencontre = rencontre.numero_rencontre
group by joueur.numero_licence 
order by score DESC;

-- Classement des équipes --

select t.numero_equipe,(sum(t.score_rencontre) + sum(rencontre.score_rencontre)) as score
from rencontre,
(select *
from equipe,rencontre
where equipe.numero_equipe = rencontre.numero_equipe1 ) t
where t.numero_equipe = rencontre.numero_equipe2
group by t.numero_equipe
order by score DESC;