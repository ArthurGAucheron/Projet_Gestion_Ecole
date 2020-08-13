# BDD
create schema db_gestion_ecole_users;

use db_gestion_ecole_users;

#-- table MEMBER (utilisateurs)
CREATE TABLE MEMBER (
		ID_MEMBER BIGINT NOT NULL,
		USERNAME VARCHAR(10) NOT NULL,
		PASSWORD VARCHAR(500) NOT NULL,
        ACTIVED TINYINT(1),
		PRIMARY KEY (ID_MEMBER)
	);

#-- table MEMBER_ROLE (roles)
CREATE TABLE MEMBER_ROLE (
		MEMBER_ID BIGINT NOT NULL,
		ROLE VARCHAR(20) NOT NULL,
		FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(ID_MEMBER)
	);
        
    
    #-- mdp : '123'
INSERT INTO `db_gestion_ecole_users`.`member` (`ID_MEMBER`, `USERNAME`, `PASSWORD`, `ACTIVED`) VALUES ('1', 'admin', '$2a$10$7AvBMWiQucCy8RR2gdX2Nu2lBwUxPuWt5jNy5GdYxfreOnRJoC1CC', '1');
	#-- mdp : 'abc'
INSERT INTO `db_gestion_ecole_users`.`member` (`ID_MEMBER`, `USERNAME`, `PASSWORD`, `ACTIVED`) VALUES ('2', 'teacher', '$2a$10$LSxkWRLQ1b75EJzn0GFwreoP.wP0.SkIFGfsBD7eHqPfPgEu2z5ae', '1');
	#-- mdp : '789'
INSERT INTO `db_gestion_ecole_users`.`member` (`ID_MEMBER`, `USERNAME`, `PASSWORD`, `ACTIVED`) VALUES ('3', 'student', '$2a$10$lsnbD460MMJcxB2nLxXwrec9lNr/vCOnaMyUk1JLLdTfylpIbP6zu', '1');


INSERT INTO `db_gestion_ecole_users`.`member_role` (`MEMBER_ID`, `ROLE`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `db_gestion_ecole_users`.`member_role` (`MEMBER_ID`, `ROLE`) VALUES ('2', 'ROLE_TEACHER');
INSERT INTO `db_gestion_ecole_users`.`member_role` (`MEMBER_ID`, `ROLE`) VALUES ('3', 'ROLE_STUDENT');
