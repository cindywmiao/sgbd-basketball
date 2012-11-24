-- Classement des équipes --

select t.numero_equipe,(sum(t.score_rencontre) + sum(rencontre.score_rencontre)) as score
from rencontre,
(select *
from equipe,rencontre
where equipe.numero_equipe = rencontre.numero_equipe1 ) t
where t.numero_equipe = rencontre.numero_equipe2
group by t.numero_equipe
order by score DESC;