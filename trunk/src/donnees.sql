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

-- BUREAU

insert into BUREAU values (  1 , 'SAUTET'     , 'BESSON'     , 'RIVIERE'   , 'MONTAND'  , 1 ) ;
insert into BUREAU values (  2 , 'PINOTEAU'   , 'PREMINGER'  , 'COLAF'     ,'GARCIA  '  , 2 ) ;
insert into BUREAU values (  3 , 'FREY'       , 'DAVOY'      , 'GERONMI'   , 'DENEUVE'  , 3 ) ;
insert into BUREAU values (  4 , 'RICARDO'    , 'ZIDI'       , 'LYNE'      , 'MANESSE'  , 4) ;
insert into BUREAU values (  5 , 'AUTAN-LARA' ,'LESTRADOS'   , 'COCTEAU'    , 'CAPELLI'  , 5 ) ;
insert into BUREAU values (  6 , 'ROHMER'     , 'TRUFFAUT'   , 'GOMEZ'     , 'BELLI'    , 6 ) ;
insert into BUREAU values (  7 , 'MALLE'      , 'DELON'      , 'MEUNIER'   , 'DUPRILLOT', 7 ) ;
insert into BUREAU values (  8 , 'BESSON'     , 'POIRET'     , 'GABIN'     ,'DUBOIS'    , 8 ) ;
insert into BUREAU values (  9 , 'PREMINGER'  , 'ROBERT'     , 'BARTHOU'   , 'ANGLADE'  , 9 ) ;
insert into BUREAU values ( 10 , 'BEINEIX'    , 'BOURVIL'    , 'METIVIER'  ,'DUJARDIN'  , 10 ) ;


commit ;

-- JOUEUR

commit ;

insert into JOUEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-81' ) ;
insert into JOUEUR values (  2 , 'GARCIA'    , 'NICOLE'      , '21-FEB-87' ) ;
insert into JOUEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-91' ) ;
insert into JOUEUR values (  4 , 'DUBOIS'    , 'MARIE'       , '12-FEB-87' ) ;
insert into JOUEUR values (  5 , 'SCHNEIDER' , 'ROMY'        , '01-APR-82' ) ;
insert into JOUEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-90' ) ;
insert into JOUEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-88' ) ;
insert into JOUEUR values (  8 , 'DUPRILLOT' , 'JOHEL'       , '24-APR-88' ) ;
insert into JOUEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-89' ) ;
insert into JOUEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-83' ) ;
insert into JOUEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-91' ) ;
insert into JOUEUR values ( 12 , 'MASSARI'   , 'LEA'         , '01-MAR-91' ) ;
insert into JOUEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-89' ) ;
insert into JOUEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-84' ) ;
insert into JOUEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-88' ) ;
insert into JOUEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-88' ) ;
insert into JOUEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-88' ) ;
insert into JOUEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-88' ) ;
insert into JOUEUR values ( 19 , 'BELLI'     , 'AGOSTINA'    , '01-MAR-90' ) ;
insert into JOUEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-88' ) ;
insert into JOUEUR values ( 21 , 'MARLAUD'   , 'PHILIPPE'    , '01-JAN-01' ) ;
insert into JOUEUR values ( 22 , 'BELMONDO'  , 'JEAN-PAUL'   , '01-JAN-01' ) ;
insert into JOUEUR values ( 23 , 'ROURKE'    , 'MICKEY'      , '01-JAN-01' ) ;
insert into JOUEUR values ( 24 , 'BASINGER'  , 'KIM'         , '01-JAN-01' ) ;
insert into JOUEUR values ( 25 , 'DENEUVE'   , 'CATHERINE'   , '01-JAN-01' ) ;
insert into JOUEUR values ( 26 , 'GABIN'     , 'JEAN'        , '01-JAN-01' ) ;
insert into JOUEUR values ( 27 , 'DE FUNES'  , 'LOUIS'       , '01-JAN-01' ) ;
insert into JOUEUR values ( 28 , 'LANGLET'   , 'AMANDA'      , '01-JAN-01' ) ;
insert into JOUEUR values ( 29 , 'BARR'      , 'JEAN-MARC'   , '01-JAN-01' ) ;
insert into JOUEUR values ( 30 , 'ARQUETTE'  , 'ROSANNA'     , '01-JAN-01' ) ;
insert into JOUEUR values ( 31 , 'RENO'      , 'JEAN'        , '01-JAN-01' ) ;
insert into JOUEUR values ( 32 , 'NEWMAN'    , 'PAUL'        , '01-JAN-01' ) ;
insert into JOUEUR values ( 33 , 'DALLE'     , 'BEATRICE'    , '01-JAN-01' ) ;
insert into JOUEUR values ( 34 , 'ANGLADE'   , 'JEAN-HUGUES' , '01-JAN-01' ) ;
insert into JOUEUR values ( 35 , 'RIVIERE'   , 'MARIE'       , '01-JAN-01' ) ;

commit ;

-- ============================================================
--    verification des donnees
-- ============================================================

select count(*),'= 35 ?','ACTEUR' from ACTEUR 
union
select count(*),'= 21 ?','FILM' from FILM 
union
select count(*),'= 15 ?','REALISATEUR' from REALISATEUR 
union
select count(*),'= 40 ?','ROLE' from ROLE 
union
select count(*),'= 3 ?','CATEGORIE_PLACE' from CATEGORIE_PLACE 
union
select count(*),'= 3 ?','CATEGORIE_SEANCE' from CATEGORIE_SEANCE 
union
select count(*),'= 6 ?','TARIF' from TARIF 
union
select count(*),'= 1000 ?','PLACE' from PLACE 
union
select count(*), '= 24 ?','SEANCE' from SEANCE 
union
select count(*), '= 42 ?','RESERVATION' from RESERVATION ;