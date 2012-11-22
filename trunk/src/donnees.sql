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

-- insert into ENTRAINE values (  1 ,  1 ) ;
-- insert into ENTRAINE values (  2 ,  2 ) ;
-- insert into ENTRAINE values (  3 ,  3 ) ;
-- insert into ENTRAINE values (  4 ,  4 ) ;
-- insert into ENTRAINE values (  5 ,  5 ) ;
-- insert into ENTRAINE values (  6 ,  6 ) ;
-- insert into ENTRAINE values (  7 ,  7 ) ;
-- insert into ENTRAINE values (  8 ,  8 ) ;
-- insert into ENTRAINE values (  9 ,  9 ) ;
-- insert into ENTRAINE values ( 10 ,  10 ) ;
-- insert into ENTRAINE values (  1 ,  1 ) ;
-- insert into ENTRAINE values (  2 ,  2 ) ;
-- insert into ENTRAINE values (  3 ,  3 ) ;
-- insert into ENTRAINE values (  4 ,  4 ) ;
-- insert into ENTRAINE values (  5 ,  5 ) ;
-- insert into ENTRAINE values (  6 , 6 ) ;
-- insert into ENTRAINE values (  7 , 7 ) ;
-- insert into ENTRAINE values (  8 , 8 ) ;
-- insert into ENTRAINE values (  9 , 9 ) ;
-- insert into ENTRAINE values ( 10 , 10 ) ;

-- commit;

-- -- JOUEUR

-- commit ;

-- insert into JOUEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-81' ) ;
-- insert into JOUEUR values (  2 , 'GARCIA'    , 'NICOLE'      , '21-FEB-87' ) ;
-- insert into JOUEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-91' ) ;
-- insert into JOUEUR values (  4 , 'DUBOIS'    , 'MARIE'       , '12-FEB-87' ) ;
-- insert into JOUEUR values (  5 , 'SCHNEIDER' , 'ROMY'        , '01-APR-82' ) ;
-- insert into JOUEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-90' ) ;
-- insert into JOUEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-88' ) ;
-- insert into JOUEUR values (  8 , 'DUPRILLOT' , 'JOHEL'       , '24-APR-88' ) ;
-- insert into JOUEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-89' ) ;
-- insert into JOUEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-83' ) ;
-- insert into JOUEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-91' ) ;
-- insert into JOUEUR values ( 12 , 'MASSARI'   , 'LEA'         , '01-MAR-91' ) ;
-- insert into JOUEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-89' ) ;
-- insert into JOUEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-84' ) ;
-- insert into JOUEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-88' ) ;
-- insert into JOUEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-88' ) ;
-- insert into JOUEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-88' ) ;
-- insert into JOUEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-88' ) ;
-- insert into JOUEUR values ( 19 , 'BELLI'     , 'AGOSTINA'    , '01-MAR-90' ) ;
-- insert into JOUEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-88' ) ;
-- insert into JOUEUR values ( 21 , 'MARLAUD'   , 'PHILIPPE'    , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 22 , 'BELMONDO'  , 'JEAN-PAUL'   , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 23 , 'ROURKE'    , 'MICKEY'      , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 24 , 'BASINGER'  , 'KIM'         , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 25 , 'DENEUVE'   , 'CATHERINE'   , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 26 , 'GABIN'     , 'JEAN'        , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 27 , 'DE FUNES'  , 'LOUIS'       , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 28 , 'LANGLET'   , 'AMANDA'      , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 29 , 'BARR'      , 'JEAN-MARC'   , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 30 , 'ARQUETTE'  , 'ROSANNA'     , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 31 , 'RENO'      , 'JEAN'        , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 32 , 'NEWMAN'    , 'PAUL'        , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 33 , 'DALLE'     , 'BEATRICE'    , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 34 , 'ANGLADE'   , 'JEAN-HUGUES' , '01-JAN-01' ) ;
-- insert into JOUEUR values ( 35 , 'RIVIERE'   , 'MARIE'       , '01-JAN-01' ) ;

-- commit ;