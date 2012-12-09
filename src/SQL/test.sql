-- Les clubs --
-- Input : None --
-- Output : Informations des clubs --
select * 
from ENTRAINEUR;

select club.numero_club as NR, 
       club.nom_club as NOM,
       president  as P , 
       vice_president as VP ,	
       tresorier as T, 
       secretaire as S
from club, bureau
where club.numero_bureau = bureau.numero_bureau;
