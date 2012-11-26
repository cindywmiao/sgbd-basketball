-- Moyenne des points marquée depuis le début de la saison --
-- Input : date de début de la saison

select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS
from joueur, participe, rencontre
where rencontre.date_rencontre > '21-FEB-87'
      and rencontre.numero_rencontre = participe.numero_rencontre;