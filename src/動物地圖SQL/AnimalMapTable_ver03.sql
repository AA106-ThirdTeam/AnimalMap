--------------------------------------------------------
--  Drop SEQUENCE  
--------------------------------------------------------

drop sequence park_seq1 ; 
drop sequence aniHome_Msg_seq1 ; 
drop sequence aniHome_seq1 ; 
drop sequence mem_seq1 ; 
drop sequence emp_seq1 ; 

--------------------------------------------------------
--  DROP FOREIGN KEY  
--------------------------------------------------------

ALTER TABLE park DROP CONSTRAINT park_FK1;
ALTER TABLE aniHome_Msg DROP CONSTRAINT aniHome_Msg_FK1;
ALTER TABLE aniHome_Msg DROP CONSTRAINT aniHome_Msg_FK2;
ALTER TABLE aniHome DROP CONSTRAINT aniHome_FK1;

--------------------------------------------------------
--  Drop PK 
--------------------------------------------------------

ALTER TABLE park DROP CONSTRAINT park_PK;
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

drop table park CASCADE CONSTRAINTS ;
drop table aniHome_Msg CASCADE CONSTRAINTS ;
drop table aniHome CASCADE CONSTRAINTS ;
drop table mem CASCADE CONSTRAINTS ;
drop table emp CASCADE CONSTRAINTS ;

--------------------------------------------------------
--  Create for Table 
--------------------------------------------------------

CREATE TABLE park (park_Id NUMBER(8),emp_No NUMBER(8),park_title VARCHAR2(90),park_content VARCHAR2(3000),park_pic BLOB,adp_start_date DATE,adp_upDate DATE,adp_city VARCHAR2(12),park_town VARCHAR2(12),park_road VARCHAR2(50),park_lon NUMBER(9,6),park_lat NUMBER(9,6) );
CREATE TABLE aniHome_Msg (aniHome_Msg_Id NUMBER(8),aniHome_Id NUMBER(8),mem_Id NUMBER(8),aniHome_Msg VARCHAR2(3000),adp_start_date DATE NOT NULL  );
CREATE TABLE aniHome (aniHome_Id NUMBER(8),mem_Id NUMBER(8),aniHome_title VARCHAR2(90) NOT NULL ,aniHome_content VARCHAR2(3000) NOT NULL ,aniHome_start_date DATE NOT NULL ,aniHome_upDate DATE,aniHome_city VARCHAR2(12),aniHome_town VARCHAR2(12),aniHome_road VARCHAR2(50),aniHome_lon NUMBER(9,6),aniHome_lat NUMBER(9,6) );
CREATE TABLE mem (mem_Id NUMBER(8),mem_email VARCHAR2(60) NOT NULL ,mem_account VARCHAR2(60) NOT NULL ,mem_Psw VARCHAR2(60) NOT NULL ,mem_nick_name VARCHAR2(60) NOT NULL ,mem_name VARCHAR2(40) NOT NULL ,mem_gender VARCHAR2(3) NOT NULL ,mem_Tw_Id VARCHAR2(10) NOT NULL ,mem_birth_date DATE NOT NULL ,mem_phone VARCHAR2(30) NOT NULL ,mem_Intro VARCHAR2(150),mem_profile BLOB,mem_black_list VARCHAR2(1),mem_permission VARCHAR2(1),mem_setting VARCHAR2(30),mem_balance NUMBER(10) );
CREATE TABLE emp (emp_No NUMBER(8),emp_name VARCHAR2(30) NOT NULL ,emp_Pw VARCHAR2(60) NOT NULL ,emp_email VARCHAR2(60),emp_identity_card VARCHAR2(20),emp_birthday DATE,emp_phone VARCHAR2(15),emp_address VARCHAR2(100),emp_status VARCHAR2(1),emp_picture BLOB,emp_Pic_format VARCHAR2(10),emp_hiredate DATE NOT NULL ,emp_firedate DATE );

--------------------------------------------------------
--  Create PK 
--------------------------------------------------------

ALTER TABLE park MODIFY (
park_Id NOT NULL 
);
ALTER TABLE park ADD CONSTRAINT park_PK PRIMARY KEY (
park_Id 
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
COMMENT ON COLUMN aniHome_Msg.aniHome_Msg_Id IS '動物之家留言編號 | PS: PK';
COMMENT ON COLUMN aniHome_Msg.aniHome_Id IS '動物之家編號 | PS: FK';
COMMENT ON COLUMN aniHome_Msg.mem_Id IS '留言會員編號 | PS: FK';
COMMENT ON COLUMN aniHome_Msg.aniHome_Msg IS '動物之家留言 | PS: 內容上限字數-1000個中文字';
COMMENT ON COLUMN aniHome_Msg.adp_start_date IS '留言發布日期 | PS: ';
COMMENT ON COLUMN aniHome.aniHome_Id IS '動物之家編號 | PS: PK';
COMMENT ON COLUMN aniHome.mem_Id IS '會員 | PS: FK';
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
COMMENT ON COLUMN mem.mem_email IS '信箱 | PS: ';
COMMENT ON COLUMN mem.mem_account IS '帳號 | PS: 電子信箱就是帳號';
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

ALTER TABLE park ADD CONSTRAINT park_FK1 FOREIGN KEY ( emp_No ) REFERENCES emp ( emp_No ) ENABLE;
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

CREATE SEQUENCE  park_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  aniHome_Msg_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  aniHome_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  mem_seq1 INCREMENT BY 1 START WITH 7000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  emp_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;

--------------------------------------------------------
--  COMMIT DATA BASE  
--------------------------------------------------------
COMMIT;


