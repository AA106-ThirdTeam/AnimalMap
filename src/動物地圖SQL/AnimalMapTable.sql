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
drop sequence purview_seq1 ; 
drop sequence animal_index_seq1 ; 
drop sequence emg_H_Msg_seq1 ; 
drop sequence emg_H_seq1 ; 
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
ALTER TABLE emg_H_Msg DROP CONSTRAINT emg_H_Msg_FK1;
ALTER TABLE emg_H_Msg DROP CONSTRAINT emg_H_Msg_FK2;
ALTER TABLE emg_H DROP CONSTRAINT emg_H_FK1;
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
ALTER TABLE purview DROP CONSTRAINT purview_PK;
ALTER TABLE animal_index DROP CONSTRAINT animal_index_PK;
ALTER TABLE emg_H_Msg DROP CONSTRAINT emg_H_Msg_PK;
ALTER TABLE emg_H DROP CONSTRAINT emg_H_PK;
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
drop table purview CASCADE CONSTRAINTS ;
drop table animal_index CASCADE CONSTRAINTS ;
drop table emg_H_Msg CASCADE CONSTRAINTS ;
drop table emg_H CASCADE CONSTRAINTS ;
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
CREATE TABLE purview (purview_No VARCHAR2(8),pruview_name VARCHAR2(50) );
CREATE TABLE animal_index (animal_No VARCHAR2(8),animal_detail VARCHAR2(300),animal_class VARCHAR2(2),animal_class_No VARCHAR2(2) );
CREATE TABLE emg_H_Msg (emg_H_Msg_Id VARCHAR2(8),mem_Id VARCHAR2(8),emg_H_Id VARCHAR2(8),emg_H_Msg_start DATE,emg_H_Msg_content VARCHAR2(300) NOT NULL  );
CREATE TABLE emg_H (emg_H_Id VARCHAR2(8),mem_Id VARCHAR2(8),emg_H_start_date DATE,emg_H_end_date DATE,emg_H_title VARCHAR2(90),emg_H_content VARCHAR2(3000),emg_H_Pic BLOB,emg_H_Pic_format VARCHAR2(10),emg_H_city VARCHAR2(20),emg_H_town VARCHAR2(20),emg_H_road VARCHAR2(50),emg_H_Lon NUMBER(9,6),emg_H_Lat NUMBER(9,6) );
CREATE TABLE track (track_Id VARCHAR2(8),mem_Id VARCHAR2(8),track_record_class VARCHAR2(1),track_record_class_Id VARCHAR2(8) );
CREATE TABLE adpPhotos (adpPhotos_Id VARCHAR2(8),adp_Id VARCHAR2(8),adpPhotosPic BLOB );
CREATE TABLE adpMsg (adpMsg_Id VARCHAR2(8),adp_Id VARCHAR2(8),mem_Id VARCHAR2(8),msg VARCHAR2(3000),adpMsgDate DATE,adpMsgadp_upDate DATE );
CREATE TABLE adp (adp_Id VARCHAR2(8),mem_Id VARCHAR2(8),adp_title VARCHAR2(90),adp_adp_content VARCHAR2(3000),adp_start_date DATE,adp_end_date DATE,adp_upDate DATE,adp_city VARCHAR2(12),adp_town VARCHAR2(12),adp_road VARCHAR2(50),adp_lon NUMBER(9,6),adp_lat NUMBER(9,6) );
CREATE TABLE park (park_Id VARCHAR2(8),emp_No VARCHAR2(8),park_title VARCHAR2(90),park_content VARCHAR2(3000),park_pic BLOB,adp_start_date DATE,adp_upDate DATE,adp_city VARCHAR2(12),park_town VARCHAR2(12),park_road VARCHAR2(50),park_lon NUMBER(9,6),park_lat NUMBER(9,6) );
CREATE TABLE aniHome_Photos (aniHome_Photos_Id VARCHAR2(8),aniHome_Id VARCHAR2(8),aniHome_Photos_pic BLOB );
CREATE TABLE aniHome_Msg (aniHome_Msg_Id VARCHAR2(8),aniHome_Id VARCHAR2(8),mem_Id VARCHAR2(8),aniHome_Msg VARCHAR2(3000),adp_start_date DATE NOT NULL  );
CREATE TABLE aniHome (aniHome_Id VARCHAR2(8),mem_Id VARCHAR2(8),aniHome_title VARCHAR2(90) NOT NULL ,aniHome_content VARCHAR2(3000) NOT NULL ,aniHome_start_date DATE NOT NULL ,aniHome_upDate DATE,aniHome_city VARCHAR2(12),aniHome_town VARCHAR2(12),aniHome_road VARCHAR2(50),aniHome_lon NUMBER(9,6),aniHome_lat NUMBER(9,6) );
CREATE TABLE mem (mem_Id VARCHAR2(8),mem_account VARCHAR2(60) NOT NULL ,mem_email VARCHAR2(60) NOT NULL ,mem_Psw VARCHAR2(60) NOT NULL ,mem_nick_name VARCHAR2(60) NOT NULL ,mem_name VARCHAR2(40) NOT NULL ,mem_gender VARCHAR2(3) NOT NULL ,mem_Tw_Id VARCHAR2(10) NOT NULL ,mem_birth_date DATE NOT NULL ,mem_phone VARCHAR2(30) NOT NULL ,mem_Intro VARCHAR2(150),mem_profile BLOB,mem_black_list VARCHAR2(1),mem_permission VARCHAR2(1),mem_setting VARCHAR2(30),mem_balance NUMBER(10) );
CREATE TABLE emp (emp_No VARCHAR2(8),emp_name VARCHAR2(30) NOT NULL ,emp_Pw VARCHAR2(60) NOT NULL ,emp_email VARCHAR2(60),emp_identity_card VARCHAR2(20),emp_birthday DATE,emp_phone VARCHAR2(15),emp_address VARCHAR2(100),emp_status VARCHAR2(1),emp_picture BLOB,emp_Pic_format VARCHAR2(10),emp_hiredate DATE NOT NULL ,emp_firedate DATE );

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
ALTER TABLE purview MODIFY (
purview_No NOT NULL 
);
ALTER TABLE purview ADD CONSTRAINT purview_PK PRIMARY KEY (
purview_No 
) ENABLE; 
ALTER TABLE animal_index MODIFY (
animal_No NOT NULL 
);
ALTER TABLE animal_index ADD CONSTRAINT animal_index_PK PRIMARY KEY (
animal_No 
) ENABLE; 
ALTER TABLE emg_H_Msg MODIFY (
emg_H_Msg_Id NOT NULL 
);
ALTER TABLE emg_H_Msg ADD CONSTRAINT emg_H_Msg_PK PRIMARY KEY (
emg_H_Msg_Id 
) ENABLE; 
ALTER TABLE emg_H MODIFY (
emg_H_Id NOT NULL 
);
ALTER TABLE emg_H ADD CONSTRAINT emg_H_PK PRIMARY KEY (
emg_H_Id 
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
--  COMMENT ON COLUMN  
--------------------------------------------------------

COMMENT ON COLUMN stray_Ani_photos_H.str_Ani_Pic_No IS '相片編號 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.stray_Ani_Id IS '社區動物編號 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.stray_Ani_Pic IS '流浪動物相片 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.stray_Pic_name IS '相片檔名 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.stray_Pic_extent IS '相片副檔名 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.stray_Pic_time IS '相片發布時間 | PS: ';
COMMENT ON COLUMN stray_Ani_photos_H.stray_Pic_type IS '相片類型 | PS: 0:一般,1:大頭貼';
COMMENT ON COLUMN stray_Ani_message.str_Ani_Mes_No IS '流浪動物留言編號 | PS: ';
COMMENT ON COLUMN stray_Ani_message.stray_Ani_Id IS '社區動物編號 | PS: ';
COMMENT ON COLUMN stray_Ani_message.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN stray_Ani_message.str_Ani_Mes_time IS '發布時間 | PS: ';
COMMENT ON COLUMN stray_Ani_message.str_Ani_Mes IS '流浪動物留言 | PS: ';
COMMENT ON COLUMN stray_Ani_Loc.str_Ani_Loc_No IS '流浪動物出沒編號 | PS: ';
COMMENT ON COLUMN stray_Ani_Loc.stray_Ani_Id IS '社區動物編號 | PS: ';
COMMENT ON COLUMN stray_Ani_Loc.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN stray_Ani_Loc.str_Ani_LocLat IS '送養地點經度 | PS: google map經緯度';
COMMENT ON COLUMN stray_Ani_Loc.str_Ani_LocLon IS '送養地點緯度 | PS: google map經緯度';
COMMENT ON COLUMN stray_Ani.stray_Ani_Id IS '社區動物編號 | PS: ';
COMMENT ON COLUMN stray_Ani.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_name IS '流浪動物名字 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_type IS '流浪動物種類 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_gender IS '流浪性別 | PS: M.公F.母';
COMMENT ON COLUMN stray_Ani.stray_Ani_heal IS '流浪動物健康狀況 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_Vac IS '流浪動物疫苗接踵 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_color IS '流浪動物毛色 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_body IS '流浪動物體型 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_age IS '流浪動物年齡 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_Neu IS '流浪動物節育 | PS: 1.已節育0.未節育';
COMMENT ON COLUMN stray_Ani.stray_Ani_chip IS '流浪動物晶片編號 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_date IS '流浪動物發現時間 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_status IS '流浪動物物件狀態 | PS: 1.顯示0.不顯示';
COMMENT ON COLUMN stray_Ani.stray_Ani_CreDate IS '流浪動物建立時間 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_FinLat IS '流浪出沒地點經度 | PS: google map經緯度';
COMMENT ON COLUMN stray_Ani.stray_Ani_FinLon IS '流浪出沒地點緯度 | PS: google map經緯度';
COMMENT ON COLUMN stray_Ani.stray_Ani_city IS '縣/市 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_town IS '鄉鎮市區 | PS: ';
COMMENT ON COLUMN stray_Ani.stray_Ani_road IS '道路街名村里 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Pic_No IS '寵物相片編號 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Id IS '寵物編號 | PS: ';
COMMENT ON COLUMN pet_Photos.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Pic IS '寵物相片 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Pic_name IS '寵物相片檔名 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Pic_extent IS '寵物相片副檔名 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Pic_time IS '發布時間 | PS: ';
COMMENT ON COLUMN pet_Photos.pet_Pic_type IS '相片類型 | PS: 0:一般,1:大頭貼';
COMMENT ON COLUMN pet_Message.pet_Mes_No IS '寵物留言編號 | PS: ';
COMMENT ON COLUMN pet_Message.pet_Id IS '寵物編號 | PS: ';
COMMENT ON COLUMN pet_Message.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN pet_Message.pet_Mes IS '寵物留言 | PS: ';
COMMENT ON COLUMN pet_Message.pet_Mes_time IS '發布時間 | PS: ';
COMMENT ON COLUMN pet.pet_Id IS '寵物編號 | PS: ';
COMMENT ON COLUMN pet.mem_Id IS '主人會員編號 | PS: ';
COMMENT ON COLUMN pet.pet_name IS '寵物名字 | PS: ';
COMMENT ON COLUMN pet.pet_type IS '寵物種類 | PS: ';
COMMENT ON COLUMN pet.pet_gender IS '寵物性別 | PS: M.公F.母';
COMMENT ON COLUMN pet.pet_heal IS '寵物健康狀況 | PS: ';
COMMENT ON COLUMN pet.pet_Vac IS '寵物疫苗接踵 | PS: ';
COMMENT ON COLUMN pet.pet_color IS '寵物毛色 | PS: ';
COMMENT ON COLUMN pet.pet_body IS '寵物體型 | PS: ';
COMMENT ON COLUMN pet.pet_age IS '寵物年齡 | PS: ';
COMMENT ON COLUMN pet.pet_Neu IS '寵物節育 | PS: 1.已節育0.未節育';
COMMENT ON COLUMN pet.pet_chip IS '寵物晶片編號 | PS: ';
COMMENT ON COLUMN pet.pet_birth IS '寵物生日 | PS: ';
COMMENT ON COLUMN pet.pet_status IS '寵物物件狀態 | PS: 1.顯示0.不顯示';
COMMENT ON COLUMN pet.pet_CreDATE IS '寵物建立時間 | PS: ';
COMMENT ON COLUMN pet.pet_city IS '縣市 | PS: ';
COMMENT ON COLUMN pet.pet_town IS '鄉鎮市區 | PS: ';
COMMENT ON COLUMN pet.pet_road IS '道路街名村里 | PS: ';
COMMENT ON COLUMN pet.pet_FinLat IS '送養地點經度 | PS: google map經緯度';
COMMENT ON COLUMN pet.pet_FinLon IS '送養地點緯度 | PS: google map經緯度';
COMMENT ON COLUMN adopt_Ani_photos.ado_Ani_Pic_No IS '送養動物相片編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.adopt_Ani_Id IS '送養動物編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.ado_Ani_Pic IS '送養動物相片 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.ado_Pic_name IS '寵物相片檔名 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.ado_Pic_extent IS '寵物相片副檔名 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.ado_Pic_time IS '發布時間 | PS: ';
COMMENT ON COLUMN adopt_Ani_photos.ado_Pic_type IS '相片類型 | PS: 0:一般,1:大頭貼';
COMMENT ON COLUMN adopt_Ani_message.ado_Ani_Mes_No IS '送養動物留言編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_message.adopt_Ani_Id IS '社區動物編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_message.mem_Id IS '送養動物會員編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_message.ado_Ani_Mes IS '送養動物留言 | PS: ';
COMMENT ON COLUMN adopt_Ani_message.ado_Ani_Mes_time IS '發布時間 | PS: ';
COMMENT ON COLUMN adopt_Ani_sponsor.ado_Ani_Spo_No IS '送養動物贊助編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_sponsor.adopt_Ani_Id IS '送養動物編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_sponsor.mem_Id IS '贊助者會員編號 | PS: ';
COMMENT ON COLUMN adopt_Ani_sponsor.ado_Ani_Spo_money IS '贊助送養動物金額 | PS: ';
COMMENT ON COLUMN adopt_Ani_sponsor.ado_Ani_Spo_thing IS '贊助送養動物物資 | PS: ';
COMMENT ON COLUMN adopt_Ani_sponsor.ado_Ani_Spo_time IS '贊助送養動物時間 | PS: ';
COMMENT ON COLUMN adoAniSpo.adoAniSpoNo IS '送養動物贊助編號 | PS: ';
COMMENT ON COLUMN adoAniSpo.adopt_Ani_Id IS '送養動物編號 | PS: ';
COMMENT ON COLUMN adoAniSpo.mem_Id IS '贊助者會員編號 | PS: ';
COMMENT ON COLUMN adoAniSpo.adoAniSpoMoney IS '贊助送養動物金額 | PS: ';
COMMENT ON COLUMN adoAniSpo.adoAniSpoMat IS '贊助送養動物物資 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_Id IS '送養動物編號 | PS: ';
COMMENT ON COLUMN adopt_Ani.mem_Id IS '發布者會員編號 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_name IS '送養動物名字 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_type IS '送養動物動物種類 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_gender IS '送養動物性別 | PS: M.公F.母';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_heal IS '送養動物健康狀況 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_Vac IS '送養動物疫苗接踵 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_color IS '送養動物毛色 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_body IS '送養動物體型 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_age IS '送養動物年齡 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_Neu IS '送養動物節育 | PS: 1.已節育0.未節育';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_chip IS '送養動物晶片編號 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_date IS '送養時間 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_status IS '送養動物物件狀態 | PS: 1.顯示0.不顯示';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_CreDate IS '送養動物建立時間 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_FinLat IS '送養地點經度 | PS: google map經緯度';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_FinLon IS '送養地點緯度 | PS: google map經緯度';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_city IS '縣/市 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_town IS '鄉鎮市區 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_road IS '道路街名村里 | PS: ';
COMMENT ON COLUMN adopt_Ani.adopt_Ani_like IS '喜歡數 | PS: ';
COMMENT ON COLUMN purview.purview_No IS '權限編號 | PS: ';
COMMENT ON COLUMN purview.pruview_name IS '權限名稱 | PS: ';
COMMENT ON COLUMN animal_index.animal_No IS '圖鑑編號 | PS: ';
COMMENT ON COLUMN animal_index.animal_detail IS '圖鑑敘述 | PS: ';
COMMENT ON COLUMN animal_index.animal_class IS '圖鑑類別 | PS: ';
COMMENT ON COLUMN animal_index.animal_class_No IS '圖鑑類別照片編號 | PS: ';
COMMENT ON COLUMN emg_H_Msg.emg_H_Msg_Id IS '緊急求救留言編號 | PS: ';
COMMENT ON COLUMN emg_H_Msg.mem_Id IS '留言會員編號 | PS: ';
COMMENT ON COLUMN emg_H_Msg.emg_H_Id IS '求救編號 | PS: ';
COMMENT ON COLUMN emg_H_Msg.emg_H_Msg_start IS '發布時間 | PS: ';
COMMENT ON COLUMN emg_H_Msg.emg_H_Msg_content IS '留言內容 | PS: ';
COMMENT ON COLUMN emg_H.emg_H_Id IS '求救編號 | PS: ';
COMMENT ON COLUMN emg_H.mem_Id IS '發起人編號 | PS: ';
COMMENT ON COLUMN emg_H.emg_H_start_date IS '開始時間 | PS: ';
COMMENT ON COLUMN emg_H.emg_H_end_date IS '結束日期 | PS: ';
COMMENT ON COLUMN emg_H.emg_H_title IS '求救標題 | PS: 標題上限字數-30個中文字';
COMMENT ON COLUMN emg_H.emg_H_content IS '求救內容 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN emg_H.emg_H_Pic IS '照片 | PS: ';
COMMENT ON COLUMN emg_H.emg_H_Pic_format IS '照片副檔名 | PS: ';
COMMENT ON COLUMN emg_H.emg_H_city IS '縣市 | PS: 可以為空';
COMMENT ON COLUMN emg_H.emg_H_town IS '鄉鎮市區 | PS: 可以為空';
COMMENT ON COLUMN emg_H.emg_H_road IS '道路街名村里 | PS: 可以為空';
COMMENT ON COLUMN emg_H.emg_H_Lon IS '緊急求救經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN emg_H.emg_H_Lat IS '緊急求救緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN track.track_Id IS '收藏編號 | PS: ';
COMMENT ON COLUMN track.mem_Id IS '會員編號 | PS: ';
COMMENT ON COLUMN track.track_record_class IS '收藏種類 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物';
COMMENT ON COLUMN track.track_record_class_Id IS '種類編號 | PS: ';
COMMENT ON COLUMN adpPhotos.adpPhotos_Id IS '領養活動相簿編號 | PS: PK';
COMMENT ON COLUMN adpPhotos.adp_Id IS '領養活動編號 | PS: FK';
COMMENT ON COLUMN adpPhotos.adpPhotosPic IS '領養活動照片 | PS: ';
COMMENT ON COLUMN adpMsg.adpMsg_Id IS '領養活動留言編號 | PS: PK';
COMMENT ON COLUMN adpMsg.adp_Id IS '領養活動編號 | PS: FK';
COMMENT ON COLUMN adpMsg.mem_Id IS '留言會員編號 | PS: FK';
COMMENT ON COLUMN adpMsg.msg IS '領養活動留言 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN adpMsg.adpMsgDate IS '留言發布日期 | PS: ';
COMMENT ON COLUMN adpMsg.adpMsgadp_upDate IS '留言更新日期 | PS: 有更新才會有值';
COMMENT ON COLUMN adp.adp_Id IS '領養活動編號 | PS: ';
COMMENT ON COLUMN adp.mem_Id IS '發布會員編號 | PS: ';
COMMENT ON COLUMN adp.adp_title IS '領養活動標題 | PS: 標題上限字數-30個中文字';
COMMENT ON COLUMN adp.adp_adp_content IS '領養活動內容 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN adp.adp_start_date IS '領養活動發布時間 | PS: ';
COMMENT ON COLUMN adp.adp_end_date IS '領養活動到期時間 | PS: ';
COMMENT ON COLUMN adp.adp_upDate IS '領養活動更新時間 | PS: ';
COMMENT ON COLUMN adp.adp_city IS '縣市 | PS: ';
COMMENT ON COLUMN adp.adp_town IS '鄉鎮市區 | PS: ';
COMMENT ON COLUMN adp.adp_road IS '道路街名村里 | PS: ';
COMMENT ON COLUMN adp.adp_lon IS '領養活動經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN adp.adp_lat IS '緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN park.park_Id IS '公園編號 | PS: PK';
COMMENT ON COLUMN park.emp_No IS '員工編號 | PS: FK';
COMMENT ON COLUMN park.park_title IS '公園標題 | PS: 標題上限字數-30個中文字';
COMMENT ON COLUMN park.park_content IS '公園內容 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN park.park_pic IS '公園照片 | PS: ';
COMMENT ON COLUMN park.adp_start_date IS '公園發布時間 | PS: ';
COMMENT ON COLUMN park.adp_upDate IS '公園更新時間 | PS: ';
COMMENT ON COLUMN park.adp_city IS '縣市 | PS: ';
COMMENT ON COLUMN park.park_town IS '鄉鎮市區 | PS: ';
COMMENT ON COLUMN park.park_road IS '道路街名村里 | PS: ';
COMMENT ON COLUMN park.park_lon IS '公園經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN park.park_lat IS '緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN aniHome_Photos.aniHome_Photos_Id IS '相片編號 | PS: PK';
COMMENT ON COLUMN aniHome_Photos.aniHome_Id IS '動物之家編號 | PS: FK';
COMMENT ON COLUMN aniHome_Photos.aniHome_Photos_pic IS '動物之家照片 | PS: ';
COMMENT ON COLUMN aniHome_Msg.aniHome_Msg_Id IS '動物之家留言編號 | PS: PK';
COMMENT ON COLUMN aniHome_Msg.aniHome_Id IS '動物之家編號 | PS: FK';
COMMENT ON COLUMN aniHome_Msg.mem_Id IS '留言會員編號 | PS: FK';
COMMENT ON COLUMN aniHome_Msg.aniHome_Msg IS '動物之家留言 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN aniHome_Msg.adp_start_date IS '留言發布日期 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_Id IS '動物之家編號 | PS: PK';
COMMENT ON COLUMN aniHome.mem_Id IS '會員編號 | PS: FK';
COMMENT ON COLUMN aniHome.aniHome_title IS '動物之家標題 | PS: 標題上限字數-30個中文字';
COMMENT ON COLUMN aniHome.aniHome_content IS '動物之家內容 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN aniHome.aniHome_start_date IS '動物之家發布時間 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_upDate IS '動物之家更新時間 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_city IS '縣市 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_town IS '鄉鎮市區 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_road IS '道路街名村里 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_lon IS '動物之家經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN aniHome.aniHome_lat IS '緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)';
COMMENT ON COLUMN mem.mem_Id IS '會員編號 | PS: PK';
COMMENT ON COLUMN mem.mem_account IS '帳號 | PS: ';
COMMENT ON COLUMN mem.mem_email IS '信箱 | PS: ';
COMMENT ON COLUMN mem.mem_Psw IS '密碼 | PS: ';
COMMENT ON COLUMN mem.mem_nick_name IS '會員暱稱 | PS: ';
COMMENT ON COLUMN mem.mem_name IS '姓名 | PS: ';
COMMENT ON COLUMN mem.mem_gender IS '性別 | PS: M.男F.女';
COMMENT ON COLUMN mem.mem_Tw_Id IS '身份證字號 | PS: ';
COMMENT ON COLUMN mem.mem_birth_date IS '出生年月日 | PS: ';
COMMENT ON COLUMN mem.mem_phone IS '手機 | PS: ';
COMMENT ON COLUMN mem.mem_Intro IS '個人簡介 | PS: ';
COMMENT ON COLUMN mem.mem_profile IS '大頭照 | PS: ';
COMMENT ON COLUMN mem.mem_black_list IS '黑名單 | PS: 0.非黑名單1.黑名單';
COMMENT ON COLUMN mem.mem_permission IS '權限 | PS: 1.一般 2.志工 3.店家';
COMMENT ON COLUMN mem.mem_setting IS '偏好設定 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物';
COMMENT ON COLUMN mem.mem_balance IS '餘額 | PS: ';
COMMENT ON COLUMN emp.emp_No IS '員工編號 | PS: ';
COMMENT ON COLUMN emp.emp_name IS '員工姓名 | PS: ';
COMMENT ON COLUMN emp.emp_Pw IS '員工密碼 | PS: ';
COMMENT ON COLUMN emp.emp_email IS '員工信箱 | PS: ';
COMMENT ON COLUMN emp.emp_identity_card IS '員工身分證 | PS: ';
COMMENT ON COLUMN emp.emp_birthday IS '員工出生年月日 | PS: ';
COMMENT ON COLUMN emp.emp_phone IS '員工電話 | PS: ';
COMMENT ON COLUMN emp.emp_address IS '員工地址 | PS: ';
COMMENT ON COLUMN emp.emp_status IS '員工狀態 | PS: 1:在職 0: 離職';
COMMENT ON COLUMN emp.emp_picture IS '員工照片 | PS: ';
COMMENT ON COLUMN emp.emp_Pic_format IS '員工照片副檔名 | PS: ';
COMMENT ON COLUMN emp.emp_hiredate IS '雇用日期 | PS: ';
COMMENT ON COLUMN emp.emp_firedate IS '離職日期 | PS: ';

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
ALTER TABLE emg_H_Msg ADD CONSTRAINT emg_H_Msg_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE emg_H_Msg ADD CONSTRAINT emg_H_Msg_FK2 FOREIGN KEY ( emg_H_Id ) REFERENCES emg_H ( emg_H_Id ) ENABLE;
ALTER TABLE emg_H ADD CONSTRAINT emg_H_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
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
CREATE SEQUENCE  purview_seq1 INCREMENT BY 1 START WITH 21000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  animal_index_seq1 INCREMENT BY 1 START WITH 20000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  emg_H_Msg_seq1 INCREMENT BY 1 START WITH 7100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  emg_H_seq1 INCREMENT BY 1 START WITH 7000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
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


