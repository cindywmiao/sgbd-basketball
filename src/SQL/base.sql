-- ============================================================
--   Nom de la base   :  Basketball                                
--   Nom de SGBD      :  ORACLE Version 7.0                    
--   Date de creation :  7/11/2012                       
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

drop sequence SequenceEntraineur;

drop sequence SequenceJoueur;

drop sequence SequencePersonne;

drop sequence SequenceClub;

drop sequence SequenceEquipe;

drop sequence SequenceRencontre;

drop sequence SequenceCategorie;

-- ============================================================
--   Table : CLUB                                            
-- ============================================================
create table CLUB
(
    NUMERO_CLUB                   NUMBER(3)			 not null,
    NOM_CLUB                      CHAR(20)               not null,	 
    constraint pk_club primary key (NUMERO_CLUB)
);

-- ============================================================
--   Table : PERSONNE                                            
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
--   Table : ENTRAINEUR                                            
-- ============================================================
create table ENTRAINEUR
(
    NUMERO_ENTRAINEUR                   NUMBER(3)              not null,
    NOM_ENTRAINEUR                      CHAR(20)               not null,
    PRENOM_ENTRAINEUR                   CHAR(20) 	       not null,
    DATE_ENTREE_CLUB_ENTRAINEUR        DATE                   not null,
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

CREATE SEQUENCE SequenceClub
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER MonTriggClub
BEFORE INSERT
ON CLUB
FOR EACH ROW
BEGIN
SELECT SequenceClub.NEXTVAL
INTO :NEW.NUMERO_CLUB
FROM DUAL;
END;

/

CREATE SEQUENCE SequenceEquipe
START WITH 1
INCREMENT BY 1;


CREATE TRIGGER MonTriggEquipe
BEFORE INSERT
ON EQUIPE
FOR EACH ROW
BEGIN
SELECT SequenceEquipe.NEXTVAL
INTO :NEW.NUMERO_EQUIPE
FROM DUAL;
END;

/


CREATE SEQUENCE SequencePersonne
START WITH 1
INCREMENT BY 1;


CREATE TRIGGER MonTriggPersonne
BEFORE INSERT
ON PERSONNE
FOR EACH ROW
BEGIN
SELECT SequencePersonne.NEXTVAL
INTO :NEW.NUMERO_PERSONNE
FROM DUAL;
END;

/


CREATE SEQUENCE SequenceEntraineur
START WITH 1
INCREMENT BY 1;


CREATE TRIGGER MonTriggEntraineur
BEFORE INSERT
ON ENTRAINEUR
FOR EACH ROW
BEGIN
SELECT SequenceEntraineur.NEXTVAL
INTO :NEW.NUMERO_ENTRAINEUR
FROM DUAL;
END;

/


CREATE SEQUENCE SequenceJoueur
START WITH 1
INCREMENT BY 1;


CREATE TRIGGER MonTriggJoueur
BEFORE INSERT
ON JOUEUR
FOR EACH ROW
BEGIN
SELECT SequenceJoueur.NEXTVAL
INTO :NEW.NUMERO_LICENCE
FROM DUAL;
END;

/


CREATE SEQUENCE SequenceRencontre
START WITH 1
INCREMENT BY 1;


CREATE TRIGGER MonTriggRencontre
BEFORE INSERT
ON RENCONTRE
FOR EACH ROW
BEGIN
SELECT SequenceRencontre.NEXTVAL
INTO :NEW.NUMERO_RENCONTRE
FROM DUAL;
END;

/

CREATE SEQUENCE SequenceCategorie
START WITH 1
INCREMENT BY 1;


CREATE TRIGGER MonTriggCategorie
BEFORE INSERT
ON CATEGORIE
FOR EACH ROW
BEGIN
SELECT SequenceCategorie.NEXTVAL
INTO :NEW.NUMERO_CATEGORIE
FROM DUAL;
END;

/
