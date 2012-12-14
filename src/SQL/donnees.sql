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

insert into ENTRAINEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-61' ) ;
insert into ENTRAINEUR values (  2 , 'GARCIA'    , 'NICOLE'      , '21-FEB-67' ) ;
insert into ENTRAINEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-71' ) ;
insert into ENTRAINEUR values (  4 , 'DUBOIS'    , 'MARIE'       , '12-FEB-67' ) ;
insert into ENTRAINEUR values (  5 , 'SCHNEIDER' , 'ROMY'        , '01-APR-62' ) ;
insert into ENTRAINEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-70' ) ;
insert into ENTRAINEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-68' ) ;
insert into ENTRAINEUR values (  8 , 'DUPRILLOT' , 'JOHEL'       , '24-APR-78' ) ;
insert into ENTRAINEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-79' ) ;
insert into ENTRAINEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-73' ) ;
insert into ENTRAINEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-71' ) ;
insert into ENTRAINEUR values ( 12 , 'MASSARI'   , 'LEA'         , '01-MAR-71' ) ;
insert into ENTRAINEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-69' ) ;
insert into ENTRAINEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-74' ) ;
insert into ENTRAINEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-78' ) ;
insert into ENTRAINEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-68' ) ;
insert into ENTRAINEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-68' ) ;
insert into ENTRAINEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-78' ) ;
insert into ENTRAINEUR values ( 19 , 'BELLI'     , 'AGOSTINA'    , '01-MAR-70' ) ;
insert into ENTRAINEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-68' ) ;

commit;

-- CATEGORIES

insert into CATEGORIE values (  1 , 'BENJAMIN' );
insert into CATEGORIE values (  2 , 'CADET' );
insert into CATEGORIE values (  3 , 'JUNIOR' );

commit;

-- CLUB

insert into CLUB values (  1 , 'ESPERANCE'     ) ;
insert into CLUB values (  2 , 'AIGLES'   ) ;
insert into CLUB values (  3 , 'PANTHERE'       ) ;
insert into CLUB values (  4 , 'ETOILE'    ) ;
insert into CLUB values (  5 , 'FALCON' ) ;
insert into CLUB values (  6 , 'DRAGON'     ) ;
insert into CLUB values (  7 , 'PAIX'      ) ;
insert into CLUB values (  8 , 'LEOPARD'     ) ;
insert into CLUB values (  9 , 'SUNSHINE'  ) ;
insert into CLUB values ( 10 , 'PHENIX'    ) ;

commit;

-- EQUIPE

insert into EQUIPE values ( 1  , 'FC'   , 10 , 1 ) ;
insert into EQUIPE values ( 2  , 'INTER'  , 9  , 2 ) ;
insert into EQUIPE values ( 3  , 'US'    , 8  , 3 ) ;
insert into EQUIPE values ( 4  , 'AS'  , 7  , 1 ) ;
insert into EQUIPE values ( 5  , 'SCORPION'   , 6  , 2 ) ;
insert into EQUIPE values ( 6  , 'FCA'     , 5  , 3 ) ;
insert into EQUIPE values ( 7  , 'SPORTIF'  , 4  , 1 ) ;
insert into EQUIPE values ( 8  , 'ATLETICO'   , 3  , 2 ) ;
insert into EQUIPE values ( 9  , 'ASC'      , 2  , 3 ) ;
insert into EQUIPE values ( 10 , 'FCM'  , 1  , 1 ) ;
insert into EQUIPE values ( 11 , 'CAB'      , 10 , 2 ) ;
insert into EQUIPE values ( 12 , 'EST'    , 9  , 3 ) ;
insert into EQUIPE values ( 13 , 'CA'     , 8  , 1 ) ;
insert into EQUIPE values ( 14 , 'ASG'   , 7  , 2 ) ;
insert into EQUIPE values ( 15 , 'FCB'   , 6  , 3 ) ;

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

commit;

-- RENCONTRE

insert into RENCONTRE values (  1 , '13-OCT-12' , 11 , 33 , 1  , 2 ) ;
insert into RENCONTRE values (  2 , '21-FEB-12' , 20 , 26 , 3  , 4 ) ;
insert into RENCONTRE values (  3 , '06-FEB-11' , 23 , 33 , 5  , 6 ) ;
insert into RENCONTRE values (  4 , '12-FEB-11' , 22 , 25 , 7  , 8 ) ;
insert into RENCONTRE values (  5 , '01-APR-12' , 33 , 22 , 9  , 10) ;
insert into RENCONTRE values (  6 , '24-MAY-10' , 34 , 22 , 11 , 12 ) ;
insert into RENCONTRE values (  7 , '08-APR-08' , 30 , 25 , 13 , 14 ) ;
insert into RENCONTRE values (  8 , '24-APR-08' , 34 , 22 , 15 , 1  ) ;
insert into RENCONTRE values (  9 , '19-FEB-09' , 28 , 22 , 12 , 13 ) ;
insert into RENCONTRE values ( 10 , '04-OCT-12' , 35 , 24 , 5  , 8  ) ;
insert into RENCONTRE values ( 11 , '01-JAN-11' , 35 , 19 , 9  , 3  ) ;
insert into RENCONTRE values ( 12 , '01-MAR-11' , 32 , 23 , 2  , 10 ) ;
insert into RENCONTRE values ( 13 , '25-JAN-08' , 25 , 32 , 4  , 7  ) ;
insert into RENCONTRE values ( 14 , '01-NOV-08' , 28 , 34 , 7  , 11 ) ;
insert into RENCONTRE values ( 15 , '01-MAY-09' , 25 , 33 , 5  , 8  ) ;
insert into RENCONTRE values ( 16 , '11-APR-09' , 24 , 18 , 6  , 9  ) ;
insert into RENCONTRE values ( 17 , '06-JUL-08' , 26 , 33 , 14 , 3  ) ;
insert into RENCONTRE values ( 18 , '28-JUN-08' , 34 , 22 , 15 , 2  ) ;
insert into RENCONTRE values ( 19 , '01-MAR-10' , 33 , 22 , 14 , 7  ) ;
insert into RENCONTRE values ( 20 , '01-JAN-06' , 34 , 20 , 6  , 7  ) ;

commit ;

-- -- JOUEUR

insert into JOUEUR values (  1 , 'MONTAND'   , 'YVES'        , '13-OCT-81' , 'TALENCE'  , '14-JAN-01' , 1 ) ;
insert into JOUEUR values (  2 , 'GARCIA'    , 'NICOLAS'      , '21-FEB-87' , 'BORDEAUX' , '12-MAR-04' , 2 ) ;
insert into JOUEUR values (  3 , 'VILLERET'  , 'JACQUES'     , '06-FEB-91' , 'BORDEAUX' , '06-JAN-99' , 3 ) ;
insert into JOUEUR values (  4 , 'DUBOIS'    , 'JEAN'       , '12-FEB-87' , 'BORDEAUX' , '16-OCT-06' , 4 ) ;
insert into JOUEUR values (  5 , 'SCHNEIDER' , 'ROMAIN'        , '01-APR-82' , 'PESSAC'   , '12-NOV-07' , 5 ) ;
insert into JOUEUR values (  6 , 'FREY'      , 'SAMY'        , '24-MAY-90' , 'PESSAC'   , '23-DEC-08' , 6 ) ;
insert into JOUEUR values (  7 , 'RICARDO'   , 'BRUNOZZI'    , '08-APR-88' , 'PESSAC'   , '15-SEP-03' , 7 ) ;
insert into JOUEUR values (  8 , 'DUPRILLOT' , 'JOEL'       , '24-APR-88' , 'PESSAC'   , '12-JAN-01' , 8 ) ;
insert into JOUEUR values (  9 , 'LESTRADOS' , 'DOMINIQUOS'  , '19-FEB-89' , 'BORDEAUX' , '27-JUL-02' , 9 ) ;
insert into JOUEUR values ( 10 , 'DELON'     , 'ALAIN'       , '04-OCT-83' , 'TALENCE'  , '11-SEP-01' , 10) ;
insert into JOUEUR values ( 11 , 'VENTURA'   , 'LINO'        , '01-JAN-91' , 'TALENCE'  , '12-JAN-05' , 11) ;
insert into JOUEUR values ( 12 , 'MASSARI'   , 'LEO'         , '01-MAR-91' , 'TALENCE'  , '16-MAR-05' , 12) ;
insert into JOUEUR values ( 13 , 'POIRET'    , 'JEAN'        , '25-JAN-89' , 'TALENCE'  , '19-OCT-04' , 13) ;
insert into JOUEUR values ( 14 , 'CLUZET'    , 'FRANCOIS'    , '01-NOV-84' , 'TAELNCE'  , '16-NOV-03' , 14) ;
insert into JOUEUR values ( 15 , 'MALAVOY'   , 'CHRISTOPHE'  , '01-MAY-88' , 'TALENCE'  , '13-DEC-08' , 15) ;
insert into JOUEUR values ( 16 , 'BOURVIL'   , 'BOURVIL'     , '11-APR-88' , 'BORDEAUX' , '07-APR-05' , 11) ;
insert into JOUEUR values ( 17 , 'ROBERT'    , 'YVES'        , '06-JUL-88' , 'BORDEAUX' , '03-NOV-04' , 14) ;
insert into JOUEUR values ( 18 , 'MANESSE'   , 'GASPARD'     , '28-JUN-88' , 'BORDEAUX' , '08-JUN-03' , 13) ;
insert into JOUEUR values ( 19 , 'BELLI'     , 'ANTHONY'    , '01-MAR-90' , 'PARIS'    , '17-MAY-06' , 1 ) ;
insert into JOUEUR values ( 20 , 'BRASSEUR'  , 'CLAUDE'      , '01-JAN-88' , 'PARIS'    , '16-NOV-04' , 2 ) ;
insert into JOUEUR values ( 21 , 'PONTEAU'   , 'NATHAN'        , '13-OCT-81' , 'TALENCE'  , '14-JAN-01' , 1 ) ;
insert into JOUEUR values ( 22 , 'STALOS'    , 'NICOLAS'      , '21-FEB-87' , 'BORDEAUX' , '12-MAR-04' , 2 ) ;
insert into JOUEUR values ( 23 , 'RHODES'    , 'THOMAS'     , '06-FEB-91' , 'BORDEAUX' , '06-JAN-99' , 3 ) ;
insert into JOUEUR values ( 24 , 'BORNAT'    , 'JOFFREY'       , '12-FEB-87' , 'BORDEAUX' , '16-OCT-06' , 4 ) ;
insert into JOUEUR values ( 25 , 'MAKARIOS'  , 'BASTIEN'        , '01-APR-82' , 'PESSAC'   , '12-NOV-07' , 5 ) ;
insert into JOUEUR values ( 26 , 'HOMER'     , 'ARNAUD'        , '24-MAY-90' , 'PESSAC'   , '23-DEC-08' , 6 ) ;
insert into JOUEUR values ( 27 , 'HALL'      , 'FRANCK'    , '08-APR-88' , 'PESSAC'   , '15-SEP-03' , 7 ) ;
insert into JOUEUR values ( 28 , 'DORIAN'    , 'JEROME'       , '24-APR-88' , 'PESSAC'   , '12-JAN-01' , 8 ) ;
insert into JOUEUR values ( 29 , 'LENOUVEAU' , 'ANTOINE'  , '19-FEB-89' , 'BORDEAUX' , '27-JUL-02' , 9 ) ;
insert into JOUEUR values ( 30 , 'DEBON'     , 'PIERRE'       , '04-OCT-83' , 'TALENCE'  , '11-SEP-01' , 10) ;
insert into JOUEUR values ( 31 , 'ADONIS'    , 'REMY'        , '01-JAN-91' , 'TALENCE'  , '12-JAN-05' , 11) ;
insert into JOUEUR values ( 32 , 'MONTAIGNE' , 'LEONARD'         , '01-MAR-91' , 'TALENCE'  , '16-MAR-05' , 12) ;
insert into JOUEUR values ( 33 , 'POULET'    , 'GOERGES'        , '25-JAN-89' , 'TALENCE'  , '19-OCT-04' , 13) ;
insert into JOUEUR values ( 34 , 'CELERIER'  , 'NICOLAS'    , '01-NOV-84' , 'TAELNCE'  , '16-NOV-03' , 14) ;
insert into JOUEUR values ( 35 , 'LEBLANC'   , 'FLORENT'  , '01-MAY-88' , 'TALENCE'  , '13-DEC-08' , 15) ;
insert into JOUEUR values ( 36 , 'BLONEAU'   , 'FLORIAN'     , '11-APR-88' , 'BORDEAUX' , '07-APR-05' , 11) ;
insert into JOUEUR values ( 37 , 'HOFER'     , 'BENJAMIN'        , '06-JUL-88' , 'BORDEAUX' , '03-NOV-04' , 14) ;
insert into JOUEUR values ( 38 , 'PAGNY'     , 'SEBASTIEN'     , '28-JUN-88' , 'BORDEAUX' , '08-JUN-03' , 13) ;
insert into JOUEUR values ( 39 , 'MASUN'     , 'ANTONIO'    , '01-MAR-90' , 'PARIS'    , '17-MAY-06' , 1 ) ;
insert into JOUEUR values ( 40 , 'CORENTIN'  , 'DAVID'      , '01-JAN-88' , 'PARIS'    , '16-NOV-04' , 2 ) ;

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

insert into PERSONNE values ( 1  ,'MALLE' ,'ROBAT', 'TALENCE' , 'PRESIDENT',      1);
insert into PERSONNE values ( 2  ,'PONTUS','RAPHAEL', 'TALENCE' , 'VICE-PRESIDENT', 1);
insert into PERSONNE values ( 3  ,'MOLLAT' ,'JEAN', 'TALENCE' , 'TRESORIER',     1);
insert into PERSONNE values ( 4  ,'JEAN' ,'PIERRE', 'TALENCE' , 'SECRETAIRE',  1);
insert into PERSONNE values ( 5  ,'POIREAU' ,'FLORENT', 'TALENCE' , 'PRESIDENT',      2);
insert into PERSONNE values ( 6  ,'LEVEQUE' ,'FLORIAN', 'TALENCE' , 'VICE-PRESIDENT', 2);
insert into PERSONNE values ( 7  ,'SYLVAIN' ,'NATHAN', 'TALENCE' , 'TRESORIER',     2);
insert into PERSONNE values ( 8  ,'STEPHANE' ,'NICOLAS', 'TALENCE' , 'SECRETAIRE',  2);
insert into PERSONNE values ( 9  ,'GUILLEREZ' ,'JAMES', 'TALENCE' , 'PRESIDENT',      3);
insert into PERSONNE values ( 10 ,'GOMEZ' ,'JOFFREY', 'TALENCE' , 'VICE-PRESIDENT', 3);
insert into PERSONNE values ( 11 ,'HERNANDEZ' ,'BASTIEN', 'TALENCE' , 'TRESORIER',     3);
insert into PERSONNE values ( 12 ,'FERNANDEZ' ,'JEREMY', 'TALENCE' , 'SECRETAIRE',  3);
insert into PERSONNE values ( 13 ,'MOURET' ,'JEAN', 'TALENCE' , 'PRESIDENT',      4);
insert into PERSONNE values ( 14 ,'DELON' ,'NICOLAS', 'TALENCE' , 'VICE-PRESIDENT', 4);
insert into PERSONNE values ( 15 ,'MARTIN' ,'PIERRE', 'TALENCE' , 'TRESORIER',     4);
insert into PERSONNE values ( 16 ,'SELLAM' ,'QUENTIN', 'TALENCE' , 'SECRETAIRE',  4);
insert into PERSONNE values ( 17 ,'MORIZET' ,'ANTOINE', 'TALENCE' , 'PRESIDENT',      5);
insert into PERSONNE values ( 18 ,'DEBON' ,'ERWAN', 'TALENCE' , 'VICE-PRESIDENT', 5);
insert into PERSONNE values ( 19 ,'LEBON' ,'BEN', 'TALENCE' , 'TRESORIER',     5);
insert into PERSONNE values ( 20 ,'DUBOIS' ,'OLIVIER', 'TALENCE' , 'SECRETAIRE',  5);
insert into PERSONNE values ( 21 ,'BENOIT' ,'DENIS', 'TALENCE' , 'PRESIDENT',      6);
insert into PERSONNE values ( 22 ,'RUELLE' ,'FRANCOIS', 'TALENCE' , 'VICE-PRESIDENT', 6);
insert into PERSONNE values ( 23 ,'SANTOS' ,'JULIEN', 'TALENCE' , 'TRESORIER',     6);
insert into PERSONNE values ( 24 ,'BLANCO' ,'RAPHAEL', 'TALENCE' , 'SECRETAIRE',  6);
insert into PERSONNE values ( 25 ,'LEBLANC' ,'EMMANUEL', 'TALENCE' , 'PRESIDENT',      7);
insert into PERSONNE values ( 26 ,'RASTRERO' ,'EDDY', 'TALENCE' , 'VICE-PRESIDENT', 7);
insert into PERSONNE values ( 27 ,'NAVAS' ,'DANIEL', 'TALENCE' , 'TRESORIER',     7);
insert into PERSONNE values ( 28 ,'BIENVENU' ,'DANNY', 'TALENCE' , 'SECRETAIRE',  7);
insert into PERSONNE values ( 29 ,'MALLE' ,'SIMON', 'TALENCE' , 'PRESIDENT',      8);
insert into PERSONNE values ( 30 ,'MALLE' ,'THOMAS', 'TALENCE' , 'VICE-PRESIDENT', 8);
insert into PERSONNE values ( 31 ,'MALLE' ,'JULIEN', 'TALENCE' , 'TRESORIER',     8);
insert into PERSONNE values ( 32 ,'MALLE' ,'FRED', 'TALENCE' , 'SECRETAIRE',  8);
insert into PERSONNE values ( 33 ,'MALLE' ,'PHILIPPE', 'TALENCE' , 'PRESIDENT',      9);
insert into PERSONNE values ( 34 ,'MALLE' ,'JEAN', 'TALENCE' , 'VICE-PRESIDENT', 9);
insert into PERSONNE values ( 35 ,'MALLE' ,'ROBAT', 'TALENCE' , 'TRESORIER',     9);
insert into PERSONNE values ( 36 ,'MALLE' ,'NICOLAS', 'TALENCE' , 'SECRETAIRE',  9);
insert into PERSONNE values ( 37 ,'MALLE' ,'HERVE', 'TALENCE' , 'PRESIDENT',      10);
insert into PERSONNE values ( 38 ,'MALLE' ,'JOHN', 'TALENCE' , 'VICE-PRESIDENT', 10);
insert into PERSONNE values ( 39 ,'MALLE' ,'PATRICK', 'TALENCE' , 'TRESORIER',     10);
insert into PERSONNE values ( 40 ,'MALLE' ,'ARNAUD', 'TALENCE' , 'SECRETAIRE',  10);

commit;

-- -- ============================================================
-- --    verification des donnees
-- -- ============================================================

select count(*),'= 20 ?','ENTRAINEUR' from ENTRAINEUR 
union
select count(*),'= 3 ?','CATEGORIE' from CATEGORIE 
union
select count(*),'= 10 ?','CLUB' from CLUB 
union
select count(*),'= 15 ?','EQUIPE' from EQUIPE
union
select count(*),'= 20 ?','ENTRAINE' from ENTRAINE 
union
select count(*),'= 20 ?','RENCONTRE' from RENCONTRE 
union
select count(*),'= 40 ?','JOUEUR' from JOUEUR 
union
select count(*), '=75 ?','PARTICIPE' from PARTICIPE
union
select count(*),'= 40 ?','PERSONNE' from BUREAU ;