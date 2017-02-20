--------------------------------------------------------
--  Drop SEQUENCE  
--------------------------------------------------------

drop sequence stray_Ani_photos_H_seq1 ; 
drop sequence stray_Ani_message_seq1 ; 
drop sequence stray_Ani_Loc_seq1 ; 
drop sequence stray_Ani_seq1 ; 
drop sequence pet_Photos_seq1 ; 
drop sequence pet_Message_seq1 ; 
drop sequence pet_seq1 ; 
drop sequence adopt_Ani_photos_seq1 ; 
drop sequence adopt_Ani_message_seq1 ; 
drop sequence adopt_Ani_sponsor_seq1 ; 
drop sequence adoAniSpo_seq1 ; 
drop sequence adopt_Ani_seq1 ; 
drop sequence track_seq1 ; 
drop sequence adpPhotos_seq1 ; 
drop sequence adpMsg_seq1 ; 
drop sequence adp_seq1 ; 
drop sequence park_seq1 ; 
drop sequence aniHome_Photos_seq1 ; 
drop sequence aniHome_Msg_seq1 ; 
drop sequence aniHome_seq1 ; 
drop sequence mem_seq1 ; 
drop sequence emp_seq1 ; 

--------------------------------------------------------
--  DROP FOREIGN KEY  
--------------------------------------------------------

ALTER TABLE stray_Ani_photos_H DROP CONSTRAINT stray_Ani_photos_H_FK1;
ALTER TABLE stray_Ani_photos_H DROP CONSTRAINT stray_Ani_photos_H_FK2;
ALTER TABLE stray_Ani_message DROP CONSTRAINT stray_Ani_message_FK1;
ALTER TABLE stray_Ani_message DROP CONSTRAINT stray_Ani_message_FK2;
ALTER TABLE stray_Ani_Loc DROP CONSTRAINT stray_Ani_Loc_FK1;
ALTER TABLE stray_Ani_Loc DROP CONSTRAINT stray_Ani_Loc_FK2;
ALTER TABLE stray_Ani DROP CONSTRAINT stray_Ani_FK1;
ALTER TABLE pet_Photos DROP CONSTRAINT pet_Photos_FK1;
ALTER TABLE pet_Photos DROP CONSTRAINT pet_Photos_FK2;
ALTER TABLE pet_Message DROP CONSTRAINT pet_Message_FK1;
ALTER TABLE pet_Message DROP CONSTRAINT pet_Message_FK2;
ALTER TABLE pet DROP CONSTRAINT pet_FK1;
ALTER TABLE adopt_Ani_photos DROP CONSTRAINT adopt_Ani_photos_FK1;
ALTER TABLE adopt_Ani_photos DROP CONSTRAINT adopt_Ani_photos_FK2;
ALTER TABLE adopt_Ani_message DROP CONSTRAINT adopt_Ani_message_FK1;
ALTER TABLE adopt_Ani_message DROP CONSTRAINT adopt_Ani_message_FK2;
ALTER TABLE adopt_Ani_sponsor DROP CONSTRAINT adopt_Ani_sponsor_FK1;
ALTER TABLE adopt_Ani_sponsor DROP CONSTRAINT adopt_Ani_sponsor_FK2;
ALTER TABLE adoAniSpo DROP CONSTRAINT adoAniSpo_FK1;
ALTER TABLE adoAniSpo DROP CONSTRAINT adoAniSpo_FK2;
ALTER TABLE adopt_Ani DROP CONSTRAINT adopt_Ani_FK1;
ALTER TABLE track DROP CONSTRAINT track_FK1;
ALTER TABLE adpPhotos DROP CONSTRAINT adpPhotos_FK1;
ALTER TABLE adpMsg DROP CONSTRAINT adpMsg_FK1;
ALTER TABLE adpMsg DROP CONSTRAINT adpMsg_FK2;
ALTER TABLE adp DROP CONSTRAINT adp_FK1;
ALTER TABLE park DROP CONSTRAINT park_FK1;
ALTER TABLE aniHome_Photos DROP CONSTRAINT aniHome_Photos_FK1;
ALTER TABLE aniHome_Msg DROP CONSTRAINT aniHome_Msg_FK1;
ALTER TABLE aniHome_Msg DROP CONSTRAINT aniHome_Msg_FK2;
ALTER TABLE aniHome DROP CONSTRAINT aniHome_FK1;

--------------------------------------------------------
--  Drop PK 
--------------------------------------------------------

ALTER TABLE stray_Ani_photos_H DROP CONSTRAINT stray_Ani_photos_H_PK;
ALTER TABLE stray_Ani_message DROP CONSTRAINT stray_Ani_message_PK;
ALTER TABLE stray_Ani_Loc DROP CONSTRAINT stray_Ani_Loc_PK;
ALTER TABLE stray_Ani DROP CONSTRAINT stray_Ani_PK;
ALTER TABLE pet_Photos DROP CONSTRAINT pet_Photos_PK;
ALTER TABLE pet_Message DROP CONSTRAINT pet_Message_PK;
ALTER TABLE pet DROP CONSTRAINT pet_PK;
ALTER TABLE adopt_Ani_photos DROP CONSTRAINT adopt_Ani_photos_PK;
ALTER TABLE adopt_Ani_message DROP CONSTRAINT adopt_Ani_message_PK;
ALTER TABLE adopt_Ani_sponsor DROP CONSTRAINT adopt_Ani_sponsor_PK;
ALTER TABLE adoAniSpo DROP CONSTRAINT adoAniSpo_PK;
ALTER TABLE adopt_Ani DROP CONSTRAINT adopt_Ani_PK;
ALTER TABLE track DROP CONSTRAINT track_PK;
ALTER TABLE adpPhotos DROP CONSTRAINT adpPhotos_PK;
ALTER TABLE adpMsg DROP CONSTRAINT adpMsg_PK;
ALTER TABLE adp DROP CONSTRAINT adp_PK;
ALTER TABLE park DROP CONSTRAINT park_PK;
ALTER TABLE aniHome_Photos DROP CONSTRAINT aniHome_Photos_PK;
ALTER TABLE aniHome_Msg DROP CONSTRAINT aniHome_Msg_PK;
ALTER TABLE aniHome DROP CONSTRAINT aniHome_PK;
ALTER TABLE mem DROP CONSTRAINT mem_PK;
ALTER TABLE emp DROP CONSTRAINT emp_PK;

--------------------------------------------------------
-- Drop Unique 
--------------------------------------------------------

ALTER TABLE emp DROP CONSTRAINT emp_UK1 ; 
ALTER TABLE emp DROP CONSTRAINT emp_UK2 ; 

--------------------------------------------------------
--  Drop for Table 
--------------------------------------------------------

drop table stray_Ani_photos_H CASCADE CONSTRAINTS ;
drop table stray_Ani_message CASCADE CONSTRAINTS ;
drop table stray_Ani_Loc CASCADE CONSTRAINTS ;
drop table stray_Ani CASCADE CONSTRAINTS ;
drop table pet_Photos CASCADE CONSTRAINTS ;
drop table pet_Message CASCADE CONSTRAINTS ;
drop table pet CASCADE CONSTRAINTS ;
drop table adopt_Ani_photos CASCADE CONSTRAINTS ;
drop table adopt_Ani_message CASCADE CONSTRAINTS ;
drop table adopt_Ani_sponsor CASCADE CONSTRAINTS ;
drop table adoAniSpo CASCADE CONSTRAINTS ;
drop table adopt_Ani CASCADE CONSTRAINTS ;
drop table track CASCADE CONSTRAINTS ;
drop table adpPhotos CASCADE CONSTRAINTS ;
drop table adpMsg CASCADE CONSTRAINTS ;
drop table adp CASCADE CONSTRAINTS ;
drop table park CASCADE CONSTRAINTS ;
drop table aniHome_Photos CASCADE CONSTRAINTS ;
drop table aniHome_Msg CASCADE CONSTRAINTS ;
drop table aniHome CASCADE CONSTRAINTS ;
drop table mem CASCADE CONSTRAINTS ;
drop table emp CASCADE CONSTRAINTS ;

--------------------------------------------------------
--  Create for Table 
--------------------------------------------------------

CREATE TABLE stray_Ani_photos_H (str_Ani_Pic_No VARCHAR2(8),stray_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,stray_Ani_Pic BLOB NOT NULL ,stray_Pic_name VARCHAR2(24),stray_Pic_extent VARCHAR2(5),stray_Pic_time DATE,stray_Pic_type VARCHAR2(1) );
CREATE TABLE stray_Ani_message (str_Ani_Mes_No VARCHAR2(8),stray_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,str_Ani_Mes_time DATE,str_Ani_Mes VARCHAR2(300) NOT NULL  );
CREATE TABLE stray_Ani_Loc (str_Ani_Loc_No VARCHAR2(8),stray_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,str_Ani_LocLat NUMBER(9,6),str_Ani_LocLon NUMBER(9,6) );
CREATE TABLE stray_Ani (stray_Ani_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,stray_Ani_name VARCHAR2(30) NOT NULL ,stray_Ani_type VARCHAR2(15) NOT NULL ,stray_Ani_gender VARCHAR2(3),stray_Ani_heal VARCHAR2(60),stray_Ani_Vac VARCHAR2(60),stray_Ani_color VARCHAR2(20),stray_Ani_body VARCHAR2(20),stray_Ani_age VARCHAR2(2),stray_Ani_Neu VARCHAR2(1),stray_Ani_chip VARCHAR2(15),stray_Ani_date DATE,stray_Ani_status VARCHAR2(1),stray_Ani_CreDate DATE,stray_Ani_FinLat NUMBER(9,6),stray_Ani_FinLon NUMBER(9,6),stray_Ani_city VARCHAR2(12) NOT NULL ,stray_Ani_town VARCHAR2(12) NOT NULL ,stray_Ani_road VARCHAR2(50) NOT NULL  );
CREATE TABLE pet_Photos (pet_Pic_No VARCHAR2(8),pet_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,pet_Pic BLOB NOT NULL ,pet_Pic_name VARCHAR2(24),pet_Pic_extent VARCHAR2(5),pet_Pic_time DATE,pet_Pic_type VARCHAR2(1) );
CREATE TABLE pet_Message (pet_Mes_No VARCHAR2(8),pet_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,pet_Mes VARCHAR2(300) NOT NULL ,pet_Mes_time DATE );
CREATE TABLE pet (pet_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,pet_name VARCHAR2(30) NOT NULL ,pet_type VARCHAR2(15) NOT NULL ,pet_gender VARCHAR2(3),pet_heal VARCHAR2(60),pet_Vac VARCHAR2(60),pet_color VARCHAR2(20),pet_body VARCHAR2(20),pet_age VARCHAR2(2),pet_Neu VARCHAR2(1),pet_chip VARCHAR2(8),pet_birth DATE,pet_status VARCHAR2(1),pet_CreDATE DATE,pet_city VARCHAR2(12),pet_town VARCHAR2(12),pet_road VARCHAR2(50),pet_FinLat NUMBER(9,6),pet_FinLon NUMBER(9,6) );
CREATE TABLE adopt_Ani_photos (ado_Ani_Pic_No VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,ado_Ani_Pic BLOB NOT NULL ,ado_Pic_name VARCHAR2(24),ado_Pic_extent VARCHAR2(5),ado_Pic_time DATE,ado_Pic_type VARCHAR2(1) );
CREATE TABLE adopt_Ani_message (ado_Ani_Mes_No VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,ado_Ani_Mes VARCHAR2(100) NOT NULL ,ado_Ani_Mes_time DATE );
CREATE TABLE adopt_Ani_sponsor (ado_Ani_Spo_No VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,ado_Ani_Spo_money NUMBER(15),ado_Ani_Spo_thing VARCHAR2(30),ado_Ani_Spo_time DATE );
CREATE TABLE adoAniSpo (adoAniSpoNo VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,adoAniSpoMoney NUMBER(15),adoAniSpoMat VARCHAR2(30) );
CREATE TABLE adopt_Ani (adopt_Ani_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,adopt_Ani_name VARCHAR2(30) NOT NULL ,adopt_Ani_type VARCHAR2(15) NOT NULL ,adopt_Ani_gender VARCHAR2(3),adopt_Ani_heal VARCHAR2(60),adopt_Ani_Vac VARCHAR2(60),adopt_Ani_color VARCHAR2(20),adopt_Ani_body VARCHAR2(20),adopt_Ani_age VARCHAR2(2),adopt_Ani_Neu VARCHAR2(1),adopt_Ani_chip VARCHAR2(8),adopt_Ani_date DATE,adopt_Ani_status VARCHAR2(1),adopt_Ani_CreDate DATE,adopt_Ani_FinLat NUMBER(9,6),adopt_Ani_FinLon NUMBER(9,6),adopt_Ani_city VARCHAR2(12) NOT NULL ,adopt_Ani_town VARCHAR2(12) NOT NULL ,adopt_Ani_road VARCHAR2(50) NOT NULL ,adopt_Ani_like NUMBER(4) );
CREATE TABLE track (track_Id VARCHAR2(8),mem_Id VARCHAR2(8),track_record_class VARCHAR2(1),track_record_class_Id VARCHAR2(8) );
CREATE TABLE adpPhotos (adpPhotos_Id VARCHAR2(8),adp_Id VARCHAR2(8),adpPhotosPic BLOB );
CREATE TABLE adpMsg (adpMsg_Id VARCHAR2(8),adp_Id VARCHAR2(8),mem_Id VARCHAR2(8),msg VARCHAR2(3000),adpMsgDate DATE,adpMsgadp_upDate DATE );
CREATE TABLE adp (adp_Id VARCHAR2(8),mem_Id VARCHAR2(8),adp_title VARCHAR2(90),adp_adp_content VARCHAR2(3000),adp_start_date DATE,adp_end_date DATE,adp_upDate DATE,adp_city VARCHAR2(12),adp_town VARCHAR2(12),adp_road VARCHAR2(50),adp_lon NUMBER(9,6),adp_lat NUMBER(9,6) );
CREATE TABLE park (park_Id VARCHAR2(8),emp_No VARCHAR2(8),park_title VARCHAR2(90),park_content VARCHAR2(3000),park_pic VARCHAR2(40),adp_start_date DATE,adp_upDate DATE,adp_city VARCHAR2(12),park_town VARCHAR2(12),park_road VARCHAR2(50),park_lon NUMBER(9,6),park_lat NUMBER(9,6) );
CREATE TABLE aniHome_Photos (aniHome_Photos_Id VARCHAR2(8),aniHome_Id VARCHAR2(8),aniHome_Photos_pic VARCHAR2(40) );
CREATE TABLE aniHome_Msg (aniHome_Msg_Id VARCHAR2(8),aniHome_Id VARCHAR2(8),mem_Id VARCHAR2(8),aniHome_Msg VARCHAR2(3000),adp_start_date DATE NOT NULL  );
CREATE TABLE aniHome (aniHome_Id VARCHAR2(8),mem_Id VARCHAR2(8),aniHome_title VARCHAR2(90) NOT NULL ,aniHome_content VARCHAR2(3000) NOT NULL ,aniHome_start_date DATE NOT NULL ,aniHome_upDate DATE,aniHome_city VARCHAR2(12),aniHome_town VARCHAR2(12),aniHome_road VARCHAR2(50),aniHome_lon NUMBER(9,6),aniHome_lat NUMBER(9,6),aniHome_pic VARCHAR2(40) );
CREATE TABLE mem (mem_Id VARCHAR2(8),mem_account VARCHAR2(60) NOT NULL ,mem_email VARCHAR2(60) NOT NULL ,mem_Psw VARCHAR2(60) NOT NULL ,mem_nick_name VARCHAR2(60) NOT NULL ,mem_name VARCHAR2(40) NOT NULL ,mem_gender VARCHAR2(3) NOT NULL ,mem_Tw_Id VARCHAR2(10) NOT NULL ,mem_birth_date DATE NOT NULL ,mem_phone VARCHAR2(30) NOT NULL ,mem_Intro VARCHAR2(150),mem_profile VARCHAR2(40),mem_black_list VARCHAR2(1),mem_permission VARCHAR2(1),mem_setting VARCHAR2(30),mem_balance NUMBER(10) );
CREATE TABLE emp (emp_No VARCHAR2(8),emp_name VARCHAR2(30) NOT NULL ,emp_Pw VARCHAR2(60) NOT NULL ,emp_email VARCHAR2(60),emp_identity_card VARCHAR2(20),emp_birthday DATE,emp_phone VARCHAR2(15),emp_address VARCHAR2(100),emp_status VARCHAR2(1),emp_picture VARCHAR2(40),emp_Pic_format VARCHAR2(10),emp_hiredate DATE NOT NULL ,emp_firedate DATE );

--------------------------------------------------------
--  Create PK 
--------------------------------------------------------

ALTER TABLE stray_Ani_photos_H MODIFY (
str_Ani_Pic_No NOT NULL 
);
ALTER TABLE stray_Ani_photos_H ADD CONSTRAINT stray_Ani_photos_H_PK PRIMARY KEY (
str_Ani_Pic_No 
) ENABLE; 
ALTER TABLE stray_Ani_message MODIFY (
str_Ani_Mes_No NOT NULL 
);
ALTER TABLE stray_Ani_message ADD CONSTRAINT stray_Ani_message_PK PRIMARY KEY (
str_Ani_Mes_No 
) ENABLE; 
ALTER TABLE stray_Ani_Loc MODIFY (
str_Ani_Loc_No NOT NULL 
);
ALTER TABLE stray_Ani_Loc ADD CONSTRAINT stray_Ani_Loc_PK PRIMARY KEY (
str_Ani_Loc_No 
) ENABLE; 
ALTER TABLE stray_Ani MODIFY (
stray_Ani_Id NOT NULL 
);
ALTER TABLE stray_Ani ADD CONSTRAINT stray_Ani_PK PRIMARY KEY (
stray_Ani_Id 
) ENABLE; 
ALTER TABLE pet_Photos MODIFY (
pet_Pic_No NOT NULL 
);
ALTER TABLE pet_Photos ADD CONSTRAINT pet_Photos_PK PRIMARY KEY (
pet_Pic_No 
) ENABLE; 
ALTER TABLE pet_Message MODIFY (
pet_Mes_No NOT NULL 
);
ALTER TABLE pet_Message ADD CONSTRAINT pet_Message_PK PRIMARY KEY (
pet_Mes_No 
) ENABLE; 
ALTER TABLE pet MODIFY (
pet_Id NOT NULL 
);
ALTER TABLE pet ADD CONSTRAINT pet_PK PRIMARY KEY (
pet_Id 
) ENABLE; 
ALTER TABLE adopt_Ani_photos MODIFY (
ado_Ani_Pic_No NOT NULL 
);
ALTER TABLE adopt_Ani_photos ADD CONSTRAINT adopt_Ani_photos_PK PRIMARY KEY (
ado_Ani_Pic_No 
) ENABLE; 
ALTER TABLE adopt_Ani_message MODIFY (
ado_Ani_Mes_No NOT NULL 
);
ALTER TABLE adopt_Ani_message ADD CONSTRAINT adopt_Ani_message_PK PRIMARY KEY (
ado_Ani_Mes_No 
) ENABLE; 
ALTER TABLE adopt_Ani_sponsor MODIFY (
ado_Ani_Spo_No NOT NULL 
);
ALTER TABLE adopt_Ani_sponsor ADD CONSTRAINT adopt_Ani_sponsor_PK PRIMARY KEY (
ado_Ani_Spo_No 
) ENABLE; 
ALTER TABLE adoAniSpo MODIFY (
adoAniSpoNo NOT NULL 
);
ALTER TABLE adoAniSpo ADD CONSTRAINT adoAniSpo_PK PRIMARY KEY (
adoAniSpoNo 
) ENABLE; 
ALTER TABLE adopt_Ani MODIFY (
adopt_Ani_Id NOT NULL 
);
ALTER TABLE adopt_Ani ADD CONSTRAINT adopt_Ani_PK PRIMARY KEY (
adopt_Ani_Id 
) ENABLE; 
ALTER TABLE track MODIFY (
track_Id NOT NULL 
);
ALTER TABLE track ADD CONSTRAINT track_PK PRIMARY KEY (
track_Id 
) ENABLE; 
ALTER TABLE adpPhotos MODIFY (
adpPhotos_Id NOT NULL 
);
ALTER TABLE adpPhotos ADD CONSTRAINT adpPhotos_PK PRIMARY KEY (
adpPhotos_Id 
) ENABLE; 
ALTER TABLE adpMsg MODIFY (
adpMsg_Id NOT NULL 
);
ALTER TABLE adpMsg ADD CONSTRAINT adpMsg_PK PRIMARY KEY (
adpMsg_Id 
) ENABLE; 
ALTER TABLE adp MODIFY (
adp_Id NOT NULL 
);
ALTER TABLE adp ADD CONSTRAINT adp_PK PRIMARY KEY (
adp_Id 
) ENABLE; 
ALTER TABLE park MODIFY (
park_Id NOT NULL 
);
ALTER TABLE park ADD CONSTRAINT park_PK PRIMARY KEY (
park_Id 
) ENABLE; 
ALTER TABLE aniHome_Photos MODIFY (
aniHome_Photos_Id NOT NULL 
);
ALTER TABLE aniHome_Photos ADD CONSTRAINT aniHome_Photos_PK PRIMARY KEY (
aniHome_Photos_Id 
) ENABLE; 
ALTER TABLE aniHome_Msg MODIFY (
aniHome_Msg_Id NOT NULL 
);
ALTER TABLE aniHome_Msg ADD CONSTRAINT aniHome_Msg_PK PRIMARY KEY (
aniHome_Msg_Id 
) ENABLE; 
ALTER TABLE aniHome MODIFY (
aniHome_Id NOT NULL 
);
ALTER TABLE aniHome ADD CONSTRAINT aniHome_PK PRIMARY KEY (
aniHome_Id 
) ENABLE; 
ALTER TABLE mem MODIFY (
mem_Id NOT NULL 
);
ALTER TABLE mem ADD CONSTRAINT mem_PK PRIMARY KEY (
mem_Id 
) ENABLE; 
ALTER TABLE emp MODIFY (
emp_No NOT NULL 
);
ALTER TABLE emp ADD CONSTRAINT emp_PK PRIMARY KEY (
emp_No 
) ENABLE; 

--------------------------------------------------------
--  FOREIGN KEY  
--------------------------------------------------------

ALTER TABLE stray_Ani_photos_H ADD CONSTRAINT stray_Ani_photos_H_FK1 FOREIGN KEY ( stray_Ani_Id ) REFERENCES stray_Ani ( stray_Ani_Id ) ENABLE;
ALTER TABLE stray_Ani_photos_H ADD CONSTRAINT stray_Ani_photos_H_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE stray_Ani_message ADD CONSTRAINT stray_Ani_message_FK1 FOREIGN KEY ( stray_Ani_Id ) REFERENCES stray_Ani ( stray_Ani_Id ) ENABLE;
ALTER TABLE stray_Ani_message ADD CONSTRAINT stray_Ani_message_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE stray_Ani_Loc ADD CONSTRAINT stray_Ani_Loc_FK1 FOREIGN KEY ( stray_Ani_Id ) REFERENCES stray_Ani ( stray_Ani_Id ) ENABLE;
ALTER TABLE stray_Ani_Loc ADD CONSTRAINT stray_Ani_Loc_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE stray_Ani ADD CONSTRAINT stray_Ani_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE pet_Photos ADD CONSTRAINT pet_Photos_FK1 FOREIGN KEY ( pet_Id ) REFERENCES pet ( pet_Id ) ENABLE;
ALTER TABLE pet_Photos ADD CONSTRAINT pet_Photos_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE pet_Message ADD CONSTRAINT pet_Message_FK1 FOREIGN KEY ( pet_Id ) REFERENCES pet ( pet_Id ) ENABLE;
ALTER TABLE pet_Message ADD CONSTRAINT pet_Message_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE pet ADD CONSTRAINT pet_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adopt_Ani_photos ADD CONSTRAINT adopt_Ani_photos_FK1 FOREIGN KEY ( adopt_Ani_Id ) REFERENCES adopt_Ani ( adopt_Ani_Id ) ENABLE;
ALTER TABLE adopt_Ani_photos ADD CONSTRAINT adopt_Ani_photos_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adopt_Ani_message ADD CONSTRAINT adopt_Ani_message_FK1 FOREIGN KEY ( adopt_Ani_Id ) REFERENCES adopt_Ani ( adopt_Ani_Id ) ENABLE;
ALTER TABLE adopt_Ani_message ADD CONSTRAINT adopt_Ani_message_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adopt_Ani_sponsor ADD CONSTRAINT adopt_Ani_sponsor_FK1 FOREIGN KEY ( adopt_Ani_Id ) REFERENCES adopt_Ani ( adopt_Ani_Id ) ENABLE;
ALTER TABLE adopt_Ani_sponsor ADD CONSTRAINT adopt_Ani_sponsor_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adoAniSpo ADD CONSTRAINT adoAniSpo_FK1 FOREIGN KEY ( adopt_Ani_Id ) REFERENCES adopt_Ani ( adopt_Ani_Id ) ENABLE;
ALTER TABLE adoAniSpo ADD CONSTRAINT adoAniSpo_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adopt_Ani ADD CONSTRAINT adopt_Ani_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE track ADD CONSTRAINT track_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adpPhotos ADD CONSTRAINT adpPhotos_FK1 FOREIGN KEY ( adp_Id ) REFERENCES adp ( adp_Id ) ENABLE;
ALTER TABLE adpMsg ADD CONSTRAINT adpMsg_FK1 FOREIGN KEY ( adp_Id ) REFERENCES adp ( adp_Id ) ENABLE;
ALTER TABLE adpMsg ADD CONSTRAINT adpMsg_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE adp ADD CONSTRAINT adp_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE park ADD CONSTRAINT park_FK1 FOREIGN KEY ( emp_No ) REFERENCES emp ( emp_No ) ENABLE;
ALTER TABLE aniHome_Photos ADD CONSTRAINT aniHome_Photos_FK1 FOREIGN KEY ( aniHome_Id ) REFERENCES aniHome ( aniHome_Id ) ENABLE;
ALTER TABLE aniHome_Msg ADD CONSTRAINT aniHome_Msg_FK1 FOREIGN KEY ( aniHome_Id ) REFERENCES aniHome ( aniHome_Id ) ENABLE;
ALTER TABLE aniHome_Msg ADD CONSTRAINT aniHome_Msg_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE aniHome ADD CONSTRAINT aniHome_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;

--------------------------------------------------------
--  Create Unique  
--------------------------------------------------------

ALTER TABLE emp ADD CONSTRAINT emp_UK1 UNIQUE ( emp_email )ENABLE;
ALTER TABLE emp ADD CONSTRAINT emp_UK2 UNIQUE ( emp_identity_card )ENABLE;

--------------------------------------------------------
--  Create SEQUENCE  
--------------------------------------------------------

CREATE SEQUENCE  stray_Ani_photos_H_seq1 INCREMENT BY 1 START WITH 2100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  stray_Ani_message_seq1 INCREMENT BY 1 START WITH 2200000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  stray_Ani_Loc_seq1 INCREMENT BY 1 START WITH 2300000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  stray_Ani_seq1 INCREMENT BY 1 START WITH 2000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  pet_Photos_seq1 INCREMENT BY 1 START WITH 3100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  pet_Message_seq1 INCREMENT BY 1 START WITH 3200000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  pet_seq1 INCREMENT BY 1 START WITH 3000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adopt_Ani_photos_seq1 INCREMENT BY 1 START WITH 4100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adopt_Ani_message_seq1 INCREMENT BY 1 START WITH 4200000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adopt_Ani_sponsor_seq1 INCREMENT BY 1 START WITH 4300000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adoAniSpo_seq1 INCREMENT BY 1 START WITH 4400000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adopt_Ani_seq1 INCREMENT BY 1 START WITH 4000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  track_seq1 INCREMENT BY 1 START WITH 19000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adpPhotos_seq1 INCREMENT BY 1 START WITH 14200000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adpMsg_seq1 INCREMENT BY 1 START WITH 14100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  adp_seq1 INCREMENT BY 1 START WITH 14000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  park_seq1 INCREMENT BY 1 START WITH 180000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  aniHome_Photos_seq1 INCREMENT BY 1 START WITH 5200000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  aniHome_Msg_seq1 INCREMENT BY 1 START WITH 5100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  aniHome_seq1 INCREMENT BY 1 START WITH 5000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  mem_seq1 INCREMENT BY 1 START WITH 1000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  emp_seq1 INCREMENT BY 1 START WITH 10000 NOMAXVALUE  NOCYCLE  NOCACHE ;

--------------------------------------------------------
--  COMMIT DATA BASE  
--------------------------------------------------------
COMMIT;


