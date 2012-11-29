all : javac
	java database/Lancer test.sql

javac : 
	javac database/Lancer.java database/parseSQL.java database/RequestSQL.java

check :
	javac -Xlint database/*.java

lancer :
	java database/Lancer test.sql

appli : javac2
	java database/Lancer_appli info.sql s1.sql s2.sql s3.sql s4.sql score.sql consultation.sql

javac2:
	javac database/Lancer_appli.java database/parseSQL.java database/RequestSQL.java
