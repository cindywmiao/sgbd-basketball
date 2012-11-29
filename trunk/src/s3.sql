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