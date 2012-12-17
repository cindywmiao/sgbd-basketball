-- Ajout d'un joueur --
insert into JOUEUR values(42, 'MONTAND','YVES','13-OCT-89','TALENCE', '14-JAN-01',1);
commit;

-- Ajout d'un club --
insert into CLUB values ( 11 , 'BEINEIX' ) ;
commit;

-- Ajout d'un match --
insert into RENCONTRE values ( 21 , '21-OCT-87' , 34 , 25 , 3  , 7  ) ;
commit;

-- Suppression d'un joueur --
delete from joueur where joueur.numero_licence = 20;
commit;

-- Suppression d'un club --
delete from club where club.numero_club = 10;
commit;

-- Suppression d'un match --
delete from rencontre where rencontre.numero_rencontre = 20;
commit;

-- Modification d'un joueur --
update joueur set joueur.nom_joueur = 'PIERRE' where joueur.numero_licence = 19;
commit;

-- Modification d'un club --
update club set club.nom_club = 'MILLE' where club.numero_club = 9;
commit;

-- Modification d'un match --
update rencontre set rencontre.score_equipe1_rencontre = 15 where rencontre.numero_rencontre = 3;
commit;
