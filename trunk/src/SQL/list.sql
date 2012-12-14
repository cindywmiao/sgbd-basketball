-- La liste des joueurs à une date donnée --
-- input : date --
-- Exemple date = 13-OCT-81 --

select NOM_JOUEUR from JOUEUR J, PARTICIPE P, RENCONTRE R where J.NUMERO_LICENCE = P.NUMERO_LICENCE and P.NUMERO_RENCONTRE = R.NUMERO_RENCONTRE and R.DATE_RENCONTRE = '28-JUN-08' ;
