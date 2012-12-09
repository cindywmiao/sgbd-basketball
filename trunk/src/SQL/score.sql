-- Les scores des matchs joués à une date donnée --
-- Exemple de date : '24-FEB-87' --
-- Input : date --
select rencontre.score_equipe1_rencontre as Equipe1 , rencontre.score_equipe2_rencontre as Equipe2
from rencontre
where rencontre.date_rencontre = '?'; 