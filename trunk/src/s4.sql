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
