-- ============================================================
--   Nom de la base   :  Basketball                                
--   Nom de SGBD      :  ORACLE Version 7.0                    
--   Date de creation :  30/10/96  12:09                       
-- ============================================================
drop table CLUB cascade constraints;

drop table PERSONNE cascade constraints;

drop table EQUIPE cascade constraints;

drop table CATEGORIE cascade constraints;

drop table ENTRAINEUR cascade constraints;

drop table JOUEUR cascade constraints;

drop table RENCONTRE cascade constraints;

drop table PARTICIPE cascade constraints;

drop table ENTRAINE cascade constraints;

-- ============================================================
--   Table : CLUB                                            
-- ============================================================
create table CLUB
(
    NUMERO_CLUB                   NUMBER(3)              not null,
    NOM_CLUB                      CHAR(20)               not null,	 
    constraint pk_club primary key (NUMERO_CLUB)
);

-- ============================================================
--   Table : BUREAU                                            
-- ============================================================
create table PERSONNE
(
    NUMERO_PERSONNE                 NUMBER(3)              not null,
    NOM_PERSONNE                    CHAR(20)               not null,
    PRENOM_PERSONNE                 CHAR(20)               not null,
    ADRESSE_PERSONNE                CHAR(20)               not null,
    FONCTION_PERSONNE               CHAR(20)               not null,
    NUMERO_CLUB                     NUMBER(3)              not null,	
    constraint pk_personne primary key (NUMERO_PERSONNE)
);

-- ============================================================
--   Table : EQUIPE                                            
-- ============================================================
create table EQUIPE
(
    NUMERO_EQUIPE                   NUMBER(3)              not null,
    NOM_EQUIPE                      CHAR(20)               not null,
    NUMERO_CLUB                     NUMBER(3)   	   not null,
    NUMERO_CATEGORIE                NUMBER(3)              not null,
    constraint pk_equipe primary key (NUMERO_EQUIPE)
);

-- ============================================================
--   Table : CATEGORIE                                            
-- ============================================================
create table CATEGORIE
(
    NUMERO_CATEGORIE                   NUMBER(3)              not null,
    NOM_CATEGORIE                      CHAR(20)               not null,
    constraint pk_categorie primary key (NUMERO_CATEGORIE)
);

-- ============================================================
--   Table : ENTAINEUR                                            
-- ============================================================
create table ENTRAINEUR
(
    NUMERO_ENTRAINEUR                   NUMBER(3)              not null,
    NOM_ENTRAINEUR                      CHAR(20)               not null,
    PRENOM_ENTRAINEUR                   CHAR(20) 	       not null,
    DATE_ENTREE_CLUB_ENTRAINTEUR        DATE                   not null,
    constraint pk_entraineur primary key (NUMERO_ENTRAINEUR)
);

-- ============================================================
--   Table : JOUEUR                                            
-- ============================================================
create table JOUEUR
(
    NUMERO_LICENCE                   NUMBER(3)              not null,
    NOM_JOUEUR                       CHAR(20)               not null,
    PRENOM_JOUEUR                    CHAR(20) 	            not null,
    DATE_DE_NAISSANCE_JOUEUR        DATE                           , 
    ADRESSE_JOUEUR                   CHAR(30)               not null,
    DATE_ENTREE_CLUB_JOUEUR          DATE                           ,
    NUMERO_EQUIPE                    NUMBER(3)              not null,
    constraint pk_joueur primary key (NUMERO_LICENCE)
);

-- ============================================================
--   Table : RENCONTRE                                            
-- ============================================================
create table RENCONTRE
(
    NUMERO_RENCONTRE                    NUMBER(3)              not null,
    DATE_RENCONTRE                      DATE                           ,
    SCORE_EQUIPE1_RENCONTRE             NUMBER(3)                      ,
    SCORE_EQUIPE2_RENCONTRE		NUMBER(3)		       ,  
    NUMERO_EQUIPE1   		        NUMBER(3)              not null, 
    NUMERO_EQUIPE2                      NUMBER(3)              not null,
    constraint pk_rencontre primary key (NUMERO_RENCONTRE)
);

-- ============================================================
--   Table : PARTICIPE                                            
-- ============================================================
create table PARTICIPE
(
    NUMERO_LICENCE                    NUMBER(3)              not null,
    NUMERO_RENCONTRE                  NUMBER(3)              not null,
    CUMUL_POINTS_MARQUES_JOUEUR       NUMBER(3)                      ,	      
    CUMUL_FAUTES_JOUEUR               NUMBER(3)                      , 
    constraint pk_participe primary key (NUMERO_LICENCE, NUMERO_RENCONTRE)
);

-- ============================================================
--   Table : ENTRAINE                                            
-- ============================================================
create table ENTRAINE
(
    NUMERO_EQUIPE                      NUMBER(3)              not null,
    NUMERO_ENTRAINEUR                  NUMBER(3)              not null,
    constraint pk_entraine primary key (NUMERO_EQUIPE, NUMERO_ENTRAINEUR)
);

-- alter table BUREAU
--     add constraint fk1_bureau foreign key (NUMERO_CLUB)
--        references CLUB (NUMERO_CLUB);

-- alter table CLUB
--    add constraint fk1_club foreign key (NUMERO_BUREAU)
--       references BUREAU (NUMERO_BUREAU) on delete cascade;

alter table PERSONNE
    add constraint fk1_personne foreign key (NUMERO_CLUB)
       references CLUB (NUMERO_CLUB) on delete cascade;

alter table EQUIPE
    add constraint fk1_equipe foreign key (NUMERO_CLUB)
       references CLUB (NUMERO_CLUB) on delete cascade;

alter table EQUIPE
    add constraint fk2_equipe foreign key (NUMERO_CATEGORIE)
       references CATEGORIE (NUMERO_CATEGORIE) on delete cascade;

alter table JOUEUR
    add constraint fk1_joueur foreign key (NUMERO_EQUIPE)
       references EQUIPE (NUMERO_EQUIPE) on delete cascade;

alter table PARTICIPE
    add constraint fk1_participe foreign key (NUMERO_LICENCE)
       references JOUEUR (NUMERO_LICENCE) on delete cascade;

alter table PARTICIPE
    add constraint fk2_participe foreign key (NUMERO_RENCONTRE)
       references RENCONTRE (NUMERO_RENCONTRE) on delete cascade;

alter table RENCONTRE
    add constraint fk1_rencontre foreign key (NUMERO_EQUIPE1)
       references EQUIPE (NUMERO_EQUIPE) on delete cascade;

alter table RENCONTRE
    add constraint fk2_rencontre foreign key (NUMERO_EQUIPE2)
       references EQUIPE (NUMERO_EQUIPE) on delete cascade;

alter table ENTRAINE
    add constraint fk1_entraine foreign key (NUMERO_EQUIPE)
       references EQUIPE (NUMERO_EQUIPE) on delete cascade;

alter table ENTRAINE
    add constraint fk2_entraine foreign key (NUMERO_ENTRAINEUR)
       references ENTRAINEUR (NUMERO_ENTRAINEUR) on delete cascade;