-- ============================================================
--    suppression des donnees
-- ============================================================

delete from CLUB ;
delete from PERSONNE ;
delete from EQUIPE ;
delete from CATEGORIE ;
delete from ENTRAINE ;
delete from JOUEUR ;
delete from PARTICIPE ;
delete from RENCONTRE ;
delete from ENTRAINEUR ;

commit ;

-- ============================================================
--    creation des donnees
-- ============================================================

-- ENTRAINEUR

insert into ENTRAINEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-81' ) ;
insert into ENTRAINEUR values (  2 , 'GARCIA'    , 'NICOLE'      , '21-FEB-87' ) ;
insert into ENTRAINEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-91' ) ;
insert into ENTRAINEUR values (  4 , 'DUBOIS'    , 'MARIE'       , '12-FEB-87' ) ;
insert into ENTRAINEUR values (  5 , 'SCHNEIDER' , 'ROMY'        , '01-APR-82' ) ;
insert into ENTRAINEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-90' ) ;
insert into ENTRAINEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-88' ) ;
insert into ENTRAINEUR values (  8 , 'DUPRILLOT' , 'JOHEL'       , '24-APR-88' ) ;
insert into ENTRAINEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-89' ) ;
insert into ENTRAINEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-83' ) ;
insert into ENTRAINEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-91' ) ;
insert into ENTRAINEUR values ( 12 , 'MASSARI'   , 'LEA'         , '01-MAR-91' ) ;
insert into ENTRAINEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-89' ) ;
insert into ENTRAINEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-84' ) ;
insert into ENTRAINEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-88' ) ;
insert into ENTRAINEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-88' ) ;
insert into ENTRAINEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-88' ) ;
insert into ENTRAINEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-88' ) ;
insert into ENTRAINEUR values ( 19 , 'BELLI'     , 'AGOSTINA'    , '01-MAR-90' ) ;
insert into ENTRAINEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-88' ) ;

commit;

-- CATEGORIES

insert into CATEGORIE values (  1 , 'CADET' );
insert into CATEGORIE values (  2 , 'BENJAMIN' );
insert into CATEGORIE values (  3 , 'JUNIOR' );

commit;

-- CLUB

insert into CLUB values (  1 , 'SAUTET'     ) ;
insert into CLUB values (  2 , 'PINOTEAU'   ) ;
insert into CLUB values (  3 , 'FREY'       ) ;
insert into CLUB values (  4 , 'RICARDO'    ) ;
insert into CLUB values (  5 , 'AUTAN-LARA' ) ;
insert into CLUB values (  6 , 'ROHMER'     ) ;
insert into CLUB values (  7 , 'MALLE'      ) ;
insert into CLUB values (  8 , 'BESSON'     ) ;
insert into CLUB values (  9 , 'PREMINGER'  ) ;
insert into CLUB values ( 10 , 'BEINEIX'    ) ;

commit;

-- EQUIPE

insert into EQUIPE values ( 1  , 'MARLAUD'   , 10 , 1 ) ;
insert into EQUIPE values ( 2  , 'BELMONDO'  , 9  , 2 ) ;
insert into EQUIPE values ( 3  , 'ROURKE'    , 8  , 3 ) ;
insert into EQUIPE values ( 4  , 'BASINGER'  , 7  , 1 ) ;
insert into EQUIPE values ( 5  , 'DENEUVE'   , 6  , 2 ) ;
insert into EQUIPE values ( 6  , 'GABIN'     , 5  , 3 ) ;
insert into EQUIPE values ( 7  , 'DE FUNES'  , 4  , 1 ) ;
insert into EQUIPE values ( 8  , 'LANGLET'   , 3  , 2 ) ;
insert into EQUIPE values ( 9  , 'BARR'      , 2  , 3 ) ;
insert into EQUIPE values ( 10 , 'ARQUETTE'  , 1  , 1 ) ;
insert into EQUIPE values ( 11 , 'RENO'      , 10 , 2 ) ;
insert into EQUIPE values ( 12 , 'NEWMAN'    , 9  , 3 ) ;
insert into EQUIPE values ( 13 , 'DALLE'     , 8  , 1 ) ;
insert into EQUIPE values ( 14 , 'ANGLADE'   , 7  , 2 ) ;
insert into EQUIPE values ( 15 , 'RIVIERE'   , 6  , 3 ) ;

commit;

-- ENTRAINE

insert into ENTRAINE values (  1 ,  1 ) ;
insert into ENTRAINE values (  2 ,  2 ) ;
insert into ENTRAINE values (  3 ,  3 ) ;
insert into ENTRAINE values (  4 ,  4 ) ;
insert into ENTRAINE values (  5 ,  5 ) ;
insert into ENTRAINE values (  6 ,  6 ) ;
insert into ENTRAINE values (  7 ,  7 ) ;
insert into ENTRAINE values (  8 ,  8 ) ;
insert into ENTRAINE values (  9 ,  9 ) ;
insert into ENTRAINE values ( 10 ,  10 ) ;
insert into ENTRAINE values ( 11 ,  11 ) ;
insert into ENTRAINE values ( 12 ,  12 ) ;
insert into ENTRAINE values ( 13 ,  13 ) ;
insert into ENTRAINE values ( 14 ,  14 ) ;
insert into ENTRAINE values ( 15 ,  15 ) ;
insert into ENTRAINE values (  6 , 16 ) ;
insert into ENTRAINE values (  7 , 17 ) ;
insert into ENTRAINE values (  8 , 18 ) ;
insert into ENTRAINE values (  9 , 19 ) ;
insert into ENTRAINE values ( 10 , 20 ) ;

commit;

-- RENCONTRE

insert into RENCONTRE values (  1 , '13-OCT-81' , 11 , 33 , 1  , 2 ) ;
insert into RENCONTRE values (  2 , '21-FEB-87' , 20 , 26 , 3  , 4 ) ;
insert into RENCONTRE values (  3 , '06-FEB-91' , 23 , 33 , 5  , 6 ) ;
insert into RENCONTRE values (  4 , '12-FEB-87' , 22 , 25 , 7  , 8 ) ;
insert into RENCONTRE values (  5 , '01-APR-82' , 33 , 22 , 9  , 10) ;
insert into RENCONTRE values (  6 , '24-MAY-90' , 34 , 22 , 11 , 12 ) ;
insert into RENCONTRE values (  7 , '08-APR-88' , 30 , 25 , 13 , 14 ) ;
insert into RENCONTRE values (  8 , '24-APR-88' , 34 , 22 , 15 , 1  ) ;
insert into RENCONTRE values (  9 , '19-FEB-89' , 28 , 22 , 12 , 13 ) ;
insert into RENCONTRE values ( 10 , '04-OCT-83' , 35 , 24 , 5  , 8  ) ;
insert into RENCONTRE values ( 11 , '01-JAN-91' , 35 , 19 , 9  , 3  ) ;
insert into RENCONTRE values ( 12 , '01-MAR-91' , 32 , 23 , 2  , 10 ) ;
insert into RENCONTRE values ( 13 , '25-JAN-89' , 25 , 32 , 4  , 7  ) ;
insert into RENCONTRE values ( 14 , '01-NOV-84' , 28 , 34 , 7  , 11 ) ;
insert into RENCONTRE values ( 15 , '01-MAY-88' , 25 , 33 , 5  , 8  ) ;
insert into RENCONTRE values ( 16 , '11-APR-88' , 24 , 18 , 6  , 9  ) ;
insert into RENCONTRE values ( 17 , '06-JUL-88' , 26 , 33 , 14 , 3  ) ;
insert into RENCONTRE values ( 18 , '28-JUN-88' , 34 , 22 , 15 , 2  ) ;
insert into RENCONTRE values ( 19 , '01-MAR-90' , 33 , 22 , 14 , 7  ) ;
insert into RENCONTRE values ( 20 , '01-JAN-88' , 34 , 20 , 6  , 7  ) ;

commit ;

-- -- JOUEUR

insert into JOUEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-81' , 'TALENCE'  , '14-JAN-01' , 1 ) ;
insert into JOUEUR values (  2 , 'GARCIA'    , 'NICOLE'      , '21-FEB-87' , 'BORDEAUX' , '12-MAR-04' , 2 ) ;
insert into JOUEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-91' , 'BORDEAUX' , '06-JAN-99' , 3 ) ;
insert into JOUEUR values (  4 , 'DUBOIS'    , 'MARIE'       , '12-FEB-87' , 'BORDEAUX' , '16-OCT-06' , 4 ) ;
insert into JOUEUR values (  5 , 'SCHNEIDER' , 'ROMY'        , '01-APR-82' , 'PESSAC'   , '12-NOV-07' , 5 ) ;
insert into JOUEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-90' , 'PESSAC'   , '23-DEC-08' , 6 ) ;
insert into JOUEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-88' , 'PESSAC'   , '15-SEP-03' , 7 ) ;
insert into JOUEUR values (  8 , 'DUPRILLOT' , 'JOHEL'       , '24-APR-88' , 'PESSAC'   , '12-JAN-01' , 8 ) ;
insert into JOUEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-89' , 'BORDEAUX' , '27-JUL-02' , 9 ) ;
insert into JOUEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-83' , 'TALENCE'  , '11-SEP-01' , 10) ;
insert into JOUEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-91' , 'TALENCE'  , '12-JAN-05' , 11) ;
insert into JOUEUR values ( 12 , 'MASSARI'   , 'LEA'         , '01-MAR-91' , 'TALENCE'  , '16-MAR-05' , 12) ;
insert into JOUEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-89' , 'TALENCE'  , '19-OCT-04' , 13) ;
insert into JOUEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-84' , 'TAELNCE'  , '16-NOV-03' , 14) ;
insert into JOUEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-88' , 'TALENCE'  , '13-DEC-08' , 15) ;
insert into JOUEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-88' , 'BORDEAUX' , '07-APR-05' , 11) ;
insert into JOUEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-88' , 'BORDEAUX' , '03-NOV-04' , 14) ;
insert into JOUEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-88' , 'BORDEAUX' , '08-JUN-03' , 13) ;
insert into JOUEUR values ( 19 , 'BELLI'     , 'AGOSTINA'    , '01-MAR-90' , 'PARIS'    , '17-MAY-06' , 1 ) ;
insert into JOUEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-88' , 'PARIS'    , '16-NOV-04' , 2 ) ;

commit ;

-- PARTICIPE

insert into PARTICIPE values (  1 ,  1   ,0  , 1) ;
insert into PARTICIPE values (  1 ,  2   ,0  , 2) ;
insert into PARTICIPE values (  1 ,  3   ,5  , 3) ;
insert into PARTICIPE values (  1 ,  4   ,6  , 2) ;
insert into PARTICIPE values (  2 ,  2   ,2  , 2) ;
insert into PARTICIPE values (  2 ,  5   ,0  , 5) ;
insert into PARTICIPE values (  2 ,  6   ,3  , 0) ;
insert into PARTICIPE values (  2 ,  17  ,4  , 1) ;
insert into PARTICIPE values (  2 ,  10  ,3  , 1) ;
insert into PARTICIPE values (  2 ,  3   ,6  , 3) ;
insert into PARTICIPE values (  3 ,  1   ,5  , 1) ;
insert into PARTICIPE values (  3 ,  4   ,3  , 2) ;
insert into PARTICIPE values (  3 ,  15  ,5  , 1) ;
insert into PARTICIPE values (  3 ,  16  ,0  , 1) ;
insert into PARTICIPE values (  4 ,  17  ,4  , 1) ;
insert into PARTICIPE values (  4 ,  18  ,4  , 1) ;
insert into PARTICIPE values (  4 ,  1   ,1  , 0) ;
insert into PARTICIPE values (  4 ,  2   ,0  , 2) ;
insert into PARTICIPE values (  5 ,  3   ,5  , 3) ;
insert into PARTICIPE values (  5 ,  4   ,4  , 1) ;
insert into PARTICIPE values (  5 ,  2   ,5  , 2) ;
insert into PARTICIPE values (  5 ,  1   ,5  , 1) ;
insert into PARTICIPE values (  6 ,  10  ,4  , 1) ;
insert into PARTICIPE values (  6 ,  9   ,2  , 0) ;
insert into PARTICIPE values (  7 ,  7   ,1  , 2) ;
insert into PARTICIPE values (  7 ,  13  ,0  , 1) ;
insert into PARTICIPE values (  8 ,  12  ,1  , 1) ;
insert into PARTICIPE values (  8 ,  11  ,3  , 1) ;
insert into PARTICIPE values (  9 ,  19  ,2  , 1) ;
insert into PARTICIPE values (  9 ,  20  ,5  , 2) ;
insert into PARTICIPE values ( 10 ,  20  ,3  , 2) ;
insert into PARTICIPE values ( 10 ,  2   ,6  , 2) ;
insert into PARTICIPE values ( 11 ,  2   ,0  , 2) ;
insert into PARTICIPE values ( 11 ,  12  ,4  , 1) ;
insert into PARTICIPE values ( 11 ,  13  ,3  , 1) ;
insert into PARTICIPE values ( 11 ,  15  ,3  , 2) ;
insert into PARTICIPE values ( 12 ,  19  ,3 , 0) ;
insert into PARTICIPE values ( 12 ,  11  ,4 , 1) ;
insert into PARTICIPE values ( 12 ,  12  ,5 , 2) ;
insert into PARTICIPE values ( 13 ,  13  ,5 , 0) ;
insert into PARTICIPE values ( 13 ,  11  ,5 , 0) ;
insert into PARTICIPE values ( 13 ,  7   ,1 , 0) ;
insert into PARTICIPE values ( 13 ,  6   ,2 , 0) ;
insert into PARTICIPE values ( 13 ,  5   ,3 , 0) ;
insert into PARTICIPE values ( 13 ,  1   ,1 , 0) ;
insert into PARTICIPE values ( 14 ,  2   ,2 , 2) ;
insert into PARTICIPE values ( 14 ,  14  ,3 , 2) ;
insert into PARTICIPE values ( 14 ,  8   ,5 , 2) ;
insert into PARTICIPE values ( 14 ,  16  ,3 , 2) ;
insert into PARTICIPE values ( 15 ,  17  ,0 , 1) ;
insert into PARTICIPE values ( 15 ,  18  ,1 , 0) ;
insert into PARTICIPE values ( 15 ,  15  ,4 , 3) ;
insert into PARTICIPE values ( 16 ,  16  ,0 , 1) ;
insert into PARTICIPE values ( 16 ,  17  ,3 , 2) ;
insert into PARTICIPE values ( 17 ,  18  ,2 , 0) ;
insert into PARTICIPE values ( 17 ,  17  ,1 , 1) ;
insert into PARTICIPE values ( 17 ,  19  ,4 , 1) ;
insert into PARTICIPE values ( 17 ,  14  ,4 , 0) ;
insert into PARTICIPE values ( 18 ,  13  ,4 , 2) ;
insert into PARTICIPE values ( 18 ,  15  ,3 , 0) ;
insert into PARTICIPE values ( 18 ,  5   ,4 , 2) ;
insert into PARTICIPE values ( 18 ,  6   ,5 , 1) ;
insert into PARTICIPE values ( 18 ,  7   ,2 , 1) ;
insert into PARTICIPE values ( 18 ,  8   ,3 , 0) ;
insert into PARTICIPE values ( 18 ,  18  ,3 , 2) ;
insert into PARTICIPE values ( 19 ,  19  ,2 , 0) ;
insert into PARTICIPE values ( 19 ,  9   ,2 , 1) ;
insert into PARTICIPE values ( 19 ,  10  ,0 , 3) ;
insert into PARTICIPE values ( 19 ,  11  ,1 , 2) ;
insert into PARTICIPE values ( 20 ,  2   ,0 , 1) ;
insert into PARTICIPE values ( 20 ,  20  ,1 , 0) ;
insert into PARTICIPE values ( 20 ,  8   ,1 , 2) ;
insert into PARTICIPE values ( 20 ,  7   ,2 , 0) ;
insert into PARTICIPE values ( 20 ,  6   ,0 , 0) ;
insert into PARTICIPE values ( 20 ,  9   ,2 , 1) ;

commit;

-- PERSONNE

insert into PERSONNE values ( 1  ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      1);
insert into PERSONNE values ( 2  ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 1);
insert into PERSONNE values ( 3  ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     1);
insert into PERSONNE values ( 4  ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  1);
insert into PERSONNE values ( 5  ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      2);
insert into PERSONNE values ( 6  ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 2);
insert into PERSONNE values ( 7  ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     2);
insert into PERSONNE values ( 8  ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  2);
insert into PERSONNE values ( 9  ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      3);
insert into PERSONNE values ( 10 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 3);
insert into PERSONNE values ( 11 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     3);
insert into PERSONNE values ( 12 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  3);
insert into PERSONNE values ( 13 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      4);
insert into PERSONNE values ( 14 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 4);
insert into PERSONNE values ( 15 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     4);
insert into PERSONNE values ( 16 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  4);
insert into PERSONNE values ( 17 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      5);
insert into PERSONNE values ( 18 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 5);
insert into PERSONNE values ( 19 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     5);
insert into PERSONNE values ( 20 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  5);
insert into PERSONNE values ( 21 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      6);
insert into PERSONNE values ( 22 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 6);
insert into PERSONNE values ( 23 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     6);
insert into PERSONNE values ( 24 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  6);
insert into PERSONNE values ( 25 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      7);
insert into PERSONNE values ( 26 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 7);
insert into PERSONNE values ( 27 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     7);
insert into PERSONNE values ( 28 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  7);
insert into PERSONNE values ( 29 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      8);
insert into PERSONNE values ( 30 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 8);
insert into PERSONNE values ( 31 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     8);
insert into PERSONNE values ( 32 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  8);
insert into PERSONNE values ( 33 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      9);
insert into PERSONNE values ( 34 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 9);
insert into PERSONNE values ( 35 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     9);
insert into PERSONNE values ( 36 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  9);
insert into PERSONNE values ( 37 ,'MALLE' ,'ROBAT', 'TALENCE' , 'PESIDENT',      10);
insert into PERSONNE values ( 38 ,'MALLE' ,'ROBAT', 'TALENCE' , 'VICE-PESIDENT', 10);
insert into PERSONNE values ( 39 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     10);
insert into PERSONNE values ( 40 ,'MALLE' ,'ROBAT', 'TALENCE' , 'SECINIATAIRE',  10);

commit;

-- -- ============================================================
-- --    verification des donnees
-- -- ============================================================

select count(*),'= 20 ?','ENTRAINEUR' from ENTRAINEUR 
union
select count(*),'= 10 ?','CATEGORIE' from CATEGORIE 
union
select count(*),'= 10 ?','CLUB' from CLUB 
union
select count(*),'= 15 ?','EQUIPE' from EQUIPE
union
select count(*),'= 20 ?','ENTRAINE' from ENTRAINE 
union
select count(*),'= 20 ?','RENCONTRE' from RENCONTRE 
union
select count(*),'= 20 ?','JOUEUR' from JOUEUR 
union
select count(*), '=75 ?','PARTICIPE' from PARTICIPE
union
select count(*),'= 40 ?','PERSONNE' from BUREAU ;