-- ============================================================
--    suppression des donnees
-- ============================================================

delete from BUREAU ;
delete from CLUB ;
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

-- BUREAU

insert into BUREAU values (  1 , 'SAUTET'     , 'BESSON'     , 'RIVIERE'   , 'MONTAND'  ) ;
insert into BUREAU values (  2 , 'PINOTEAU'   , 'PREMINGER'  , 'COLAF'     , 'GARCIA  ' ) ;
insert into BUREAU values (  3 , 'FREY'       , 'DAVOY'      , 'GERONMI'   , 'DENEUVE'  ) ;
insert into BUREAU values (  4 , 'RICARDO'    , 'ZIDI'       , 'LYNE'      , 'MANESSE'  ) ;
insert into BUREAU values (  5 , 'AUTAN-LARA' , 'LESTRADOS'  , 'COCTEAU'   , 'CAPELLI'  ) ;
insert into BUREAU values (  6 , 'ROHMER'     , 'TRUFFAUT'   , 'GOMEZ'     , 'BELLI'    ) ;
insert into BUREAU values (  7 , 'MALLE'      , 'DELON'      , 'MEUNIER'   , 'DUPRILLOT') ;
insert into BUREAU values (  8 , 'BESSON'     , 'POIRET'     , 'GABIN'     , 'DUBOIS'   ) ;
insert into BUREAU values (  9 , 'PREMINGER'  , 'ROBERT'     , 'BARTHOU'   , 'ANGLADE'  ) ;
insert into BUREAU values ( 10 , 'BEINEIX'    , 'BOURVIL'    , 'METIVIER'  , 'DUJARDIN' ) ;

commit ;

-- CLUB

insert into CLUB values (  1 , 'SAUTET'     , 1 ) ;
insert into CLUB values (  2 , 'PINOTEAU'   , 2 ) ;
insert into CLUB values (  3 , 'FREY'       , 3 ) ;
insert into CLUB values (  4 , 'RICARDO'    , 4 ) ;
insert into CLUB values (  5 , 'AUTAN-LARA' , 5 ) ;
insert into CLUB values (  6 , 'ROHMER'     , 6 ) ;
insert into CLUB values (  7 , 'MALLE'      , 7 ) ;
insert into CLUB values (  8 , 'BESSON'     , 8 ) ;
insert into CLUB values (  9 , 'PREMINGER'  , 9 ) ;
insert into CLUB values ( 10 , 'BEINEIX'    , 10 ) ;

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

insert into RENCONTRE values (  1 , '13-OCT-81' , 11-33 , 1  , 2 ) ;
insert into RENCONTRE values (  2 , '21-FEB-87' , 20-26 , 3  , 4 ) ;
insert into RENCONTRE values (  3 , '06-FEB-91' , 23-33 , 5  , 6 ) ;
insert into RENCONTRE values (  4 , '12-FEB-87' , 22-25 , 7  , 8 ) ;
insert into RENCONTRE values (  5 , '01-APR-82' , 33-22 , 9  , 10) ;
insert into RENCONTRE values (  6 , '24-MAY-90' , 34-22 , 11 , 12 ) ;
insert into RENCONTRE values (  7 , '08-APR-88' , 30-25 , 13 , 14 ) ;
insert into RENCONTRE values (  8 , '24-APR-88' , 34-22 , 15 , 1  ) ;
insert into RENCONTRE values (  9 , '19-FEB-89' , 28-22 , 12 , 13 ) ;
insert into RENCONTRE values ( 10 , '04-OCT-83' , 35-24 , 5  , 8  ) ;
insert into RENCONTRE values ( 11 , '01-JAN-91' , 35-19 , 9  , 3  ) ;
insert into RENCONTRE values ( 12 , '01-MAR-91' , 32-23 , 2  , 10 ) ;
insert into RENCONTRE values ( 13 , '25-JAN-89' , 25-32 , 4  , 7  ) ;
insert into RENCONTRE values ( 14 , '01-NOV-84' , 28-34 , 7  , 11 ) ;
insert into RENCONTRE values ( 15 , '01-MAY-88' , 25-33 , 5  , 8  ) ;
insert into RENCONTRE values ( 16 , '11-APR-88' , 24-18 , 6  , 9  ) ;
insert into RENCONTRE values ( 17 , '06-JUL-88' , 26-33 , 14 , 3  ) ;
insert into RENCONTRE values ( 18 , '28-JUN-88' , 34-22 , 15 , 2  ) ;
insert into RENCONTRE values ( 19 , '01-MAR-90' , 33-22 , 14 , 7  ) ;
insert into RENCONTRE values ( 20 , '01-JAN-88' , 34-20 , 6  , 7  ) ;

commit ;

-- -- JOUEUR

insert into JOUEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-81' , 'TALENCE'  , '14-JAN-01' , 15 , 4  , 1 ) ;
insert into JOUEUR values (  2 , 'GARCIA'    , 'NICOLE'      , '21-FEB-87' , 'BORDEAUX' , '12-MAR-04' , 10 , 5  , 2 ) ;
insert into JOUEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-91' , 'BORDEAUX' , '06-JAN-99' , 34 , 3  , 3 ) ;
insert into JOUEUR values (  4 , 'DUBOIS'    , 'MARIE'       , '12-FEB-87' , 'BORDEAUX' , '16-OCT-06' , 15 , 4  , 4 ) ;
insert into JOUEUR values (  5 , 'SCHNEIDER' , 'ROMY'        , '01-APR-82' , 'PESSAC'   , '12-NOV-07' , 20 , 2  , 5 ) ;
insert into JOUEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-90' , 'PESSAC'   , '23-DEC-08' , 16 , 3  , 6 ) ;
insert into JOUEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-88' , 'PESSAC'   , '15-SEP-03' , 19 , 6  , 7 ) ;
insert into JOUEUR values (  8 , 'DUPRILLOT' , 'JOHEL'       , '24-APR-88' , 'PESSAC'   , '12-JAN-01' , 35 , 8  , 8 ) ;
insert into JOUEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-89' , 'BORDEAUX' , '27-JUL-02' , 33 , 10 , 9 ) ;
insert into JOUEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-83' , 'TALENCE'  , '11-SEP-01' , 37 , 6  , 10) ;
insert into JOUEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-91' , 'TALENCE'  , '12-JAN-05' , 26 , 4  , 11) ;
insert into JOUEUR values ( 12 , 'MASSARI'   , 'LEA'         , '01-MAR-91' , 'TALENCE'  , '16-MAR-05' , 24 , 4  , 12) ;
insert into JOUEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-89' , 'TALENCE'  , '19-OCT-04' , 28 , 5  , 13) ;
insert into JOUEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-84' , 'TAELNCE'  , '16-NOV-03' , 36 , 8  , 14) ;
insert into JOUEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-88' , 'TALENCE'  , '13-DEC-08' , 12 , 2  , 15) ;
insert into JOUEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-88' , 'BORDEAUX' , '07-APR-05' , 24 , 4  , 11) ;
insert into JOUEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-88' , 'BORDEAUX' , '03-NOV-04' , 28 , 5  , 14) ;
insert into JOUEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-88' , 'BORDEAUX' , '08-JUN-03' , 33 , 6  , 13) ;
insert into JOUEUR values ( 19 , 'BELLI'     , 'AGOSTINA'    , '01-MAR-90' , 'PARIS'    , '17-MAY-06' , 24 , 5  , 1 ) ;
insert into JOUEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-88' , 'PARIS'    , '16-NOV-04' , 29 , 5  , 2 ) ;

commit ;

-- PARTICIPE

insert into PARTICIPE values (  1 ,  1 ) ;
insert into PARTICIPE values (  2 ,  2 ) ;
insert into PARTICIPE values (  3 ,  3 ) ;
insert into PARTICIPE values (  4 ,  4 ) ;
insert into PARTICIPE values (  5 ,  5 ) ;
insert into PARTICIPE values (  6 ,  6 ) ;
insert into PARTICIPE values (  7 ,  7 ) ;
insert into PARTICIPE values (  8 ,  8 ) ;
insert into PARTICIPE values (  9 ,  9 ) ;
insert into PARTICIPE values ( 10 ,  10 ) ;
insert into PARTICIPE values ( 11 ,  11 ) ;
insert into PARTICIPE values ( 12 ,  12 ) ;
insert into PARTICIPE values ( 13 ,  13 ) ;
insert into PARTICIPE values ( 14 ,  14 ) ;
insert into PARTICIPE values ( 15 ,  15 ) ;
insert into PARTICIPE values ( 16 , 16 ) ;
insert into PARTICIPE values ( 17 , 17 ) ;
insert into PARTICIPE values ( 18 , 18 ) ;
insert into PARTICIPE values ( 19 , 19 ) ;
insert into PARTICIPE values ( 20 , 20 ) ;
insert into PARTICIPE values (  1 ,  3 ) ;
insert into PARTICIPE values (  2 ,  4 ) ;
insert into PARTICIPE values (  3 ,  5 ) ;
insert into PARTICIPE values (  4 ,  6 ) ;
insert into PARTICIPE values (  5 ,  7 ) ;
insert into PARTICIPE values (  6 ,  9 ) ;
insert into PARTICIPE values (  7 ,  10 ) ;
insert into PARTICIPE values (  8 ,  15 ) ;
insert into PARTICIPE values (  9 ,  16 ) ;
insert into PARTICIPE values ( 10 ,  17 ) ;
insert into PARTICIPE values ( 11 ,  17 ) ;
insert into PARTICIPE values ( 12 ,  18 ) ;
insert into PARTICIPE values ( 13 ,  19 ) ;
insert into PARTICIPE values ( 14 ,  20 ) ;
insert into PARTICIPE values ( 15 ,  11 ) ;
insert into PARTICIPE values ( 16 , 12 ) ;
insert into PARTICIPE values ( 17 , 13 ) ;
insert into PARTICIPE values ( 18 , 14 ) ;
insert into PARTICIPE values ( 19 , 1 ) ;
insert into PARTICIPE values ( 20 , 2 ) ;

commit;

-- ============================================================
--    verification des donnees
-- ============================================================

select count(*),'= 20 ?','ENTRAINEUR' from ENTRAINEUR 
union
select count(*),'= 3 ?','BUREAU' from BUREAU 
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
select count(*), '=40 ?','PARTICIPEE' from PARTICIPE ;
