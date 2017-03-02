--------------------------------------------------------
--  Drop SEQUENCE  
--------------------------------------------------------

drop sequence charge_seq1 ; 
drop sequence product_kind_seq1 ; 
drop sequence orders_item_seq1 ; 
drop sequence second_ProdPhotos_seq1 ; 
drop sequence second_ProdMsg_seq1 ; 
drop sequence product_seq1 ; 
drop sequence second_Prod_seq1 ; 
drop sequence orders_seq1 ; 
drop sequence purview_seq1 ; 
drop sequence animal_index_seq1 ; 
drop sequence emg_H_Msg_seq1 ; 
drop sequence emg_Help_seq1 ; 
drop sequence report_seq1 ; 
drop sequence priv_message_seq1 ; 
drop sequence shop_comment_seq1 ; 
drop sequence shop_photo_seq1 ; 
drop sequence petShop_seq1 ; 
drop sequence grp_comment_seq1 ; 
drop sequence petGroup_seq1 ; 
drop sequence hos_photo_seq1 ; 
drop sequence hos_comment_seq1 ; 
drop sequence vet_hospital_seq1 ; 
drop sequence stray_Ani_photos_seq1 ; 
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
drop sequence post_Response_seq1 ; 
drop sequence post_seq1 ; 
drop sequence offiMsg_seq1 ; 
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

ALTER TABLE charge DROP CONSTRAINT charge_FK1;
ALTER TABLE orders_item DROP CONSTRAINT orders_item_FK1;
ALTER TABLE orders_item DROP CONSTRAINT orders_item_FK2;
ALTER TABLE second_ProdPhotos DROP CONSTRAINT second_ProdPhotos_FK1;
ALTER TABLE second_ProdMsg DROP CONSTRAINT second_ProdMsg_FK1;
ALTER TABLE second_ProdMsg DROP CONSTRAINT second_ProdMsg_FK2;
ALTER TABLE second_Prod DROP CONSTRAINT second_Prod_FK1;
ALTER TABLE orders DROP CONSTRAINT orders_FK1;
ALTER TABLE emp_purview DROP CONSTRAINT emp_purview_FK1;
ALTER TABLE emp_purview DROP CONSTRAINT emp_purview_FK2;
ALTER TABLE emg_H_Msg DROP CONSTRAINT emg_H_Msg_FK1;
ALTER TABLE emg_H_Msg DROP CONSTRAINT emg_H_Msg_FK2;
ALTER TABLE emg_Help DROP CONSTRAINT emg_Help_FK1;
ALTER TABLE report DROP CONSTRAINT report_FK1;
ALTER TABLE report DROP CONSTRAINT report_FK2;
ALTER TABLE rel_List DROP CONSTRAINT rel_List_FK1;
ALTER TABLE rel_List DROP CONSTRAINT rel_List_FK2;
ALTER TABLE priv_message DROP CONSTRAINT priv_message_FK1;
ALTER TABLE priv_message DROP CONSTRAINT priv_message_FK2;
ALTER TABLE shop_comment DROP CONSTRAINT shop_comment_FK1;
ALTER TABLE shop_comment DROP CONSTRAINT shop_comment_FK2;
ALTER TABLE shop_photo DROP CONSTRAINT shop_photo_FK1;
ALTER TABLE petShop DROP CONSTRAINT petShop_FK1;
ALTER TABLE grp_comment DROP CONSTRAINT grp_comment_FK1;
ALTER TABLE grp_comment DROP CONSTRAINT grp_comment_FK2;
ALTER TABLE JoinList DROP CONSTRAINT JoinList_FK1;
ALTER TABLE JoinList DROP CONSTRAINT JoinList_FK2;
ALTER TABLE petGroup DROP CONSTRAINT petGroup_FK1;
ALTER TABLE hos_photo DROP CONSTRAINT hos_photo_FK1;
ALTER TABLE hos_comment DROP CONSTRAINT hos_comment_FK1;
ALTER TABLE hos_comment DROP CONSTRAINT hos_comment_FK2;
ALTER TABLE vet_hospital DROP CONSTRAINT vet_hospital_FK1;
ALTER TABLE stray_Ani_photos DROP CONSTRAINT stray_Ani_photos_FK1;
ALTER TABLE stray_Ani_photos DROP CONSTRAINT stray_Ani_photos_FK2;
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
ALTER TABLE post_Response DROP CONSTRAINT post_Response_FK1;
ALTER TABLE post_Response DROP CONSTRAINT post_Response_FK2;
ALTER TABLE post DROP CONSTRAINT post_FK1;
ALTER TABLE offiMsg DROP CONSTRAINT offiMsg_FK1;
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

ALTER TABLE charge DROP CONSTRAINT charge_PK;
ALTER TABLE product_kind DROP CONSTRAINT product_kind_PK;
ALTER TABLE orders_item DROP CONSTRAINT orders_item_PK;
ALTER TABLE second_ProdPhotos DROP CONSTRAINT second_ProdPhotos_PK;
ALTER TABLE second_ProdMsg DROP CONSTRAINT second_ProdMsg_PK;
ALTER TABLE product DROP CONSTRAINT product_PK;
ALTER TABLE second_Prod DROP CONSTRAINT second_Prod_PK;
ALTER TABLE orders DROP CONSTRAINT orders_PK;
ALTER TABLE emp_purview DROP CONSTRAINT emp_purview_PK;
ALTER TABLE purview DROP CONSTRAINT purview_PK;
ALTER TABLE animal_index DROP CONSTRAINT animal_index_PK;
ALTER TABLE emg_H_Msg DROP CONSTRAINT emg_H_Msg_PK;
ALTER TABLE emg_Help DROP CONSTRAINT emg_Help_PK;
ALTER TABLE report DROP CONSTRAINT report_PK;
ALTER TABLE rel_List DROP CONSTRAINT rel_List_PK;
ALTER TABLE priv_message DROP CONSTRAINT priv_message_PK;
ALTER TABLE shop_comment DROP CONSTRAINT shop_comment_PK;
ALTER TABLE shop_photo DROP CONSTRAINT shop_photo_PK;
ALTER TABLE petShop DROP CONSTRAINT petShop_PK;
ALTER TABLE grp_comment DROP CONSTRAINT grp_comment_PK;
ALTER TABLE JoinList DROP CONSTRAINT JoinList_PK;
ALTER TABLE petGroup DROP CONSTRAINT petGroup_PK;
ALTER TABLE hos_photo DROP CONSTRAINT hos_photo_PK;
ALTER TABLE hos_comment DROP CONSTRAINT hos_comment_PK;
ALTER TABLE vet_hospital DROP CONSTRAINT vet_hospital_PK;
ALTER TABLE stray_Ani_photos DROP CONSTRAINT stray_Ani_photos_PK;
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
ALTER TABLE post_Response DROP CONSTRAINT post_Response_PK;
ALTER TABLE post DROP CONSTRAINT post_PK;
ALTER TABLE offiMsg DROP CONSTRAINT offiMsg_PK;
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

drop table charge CASCADE CONSTRAINTS ;
drop table product_kind CASCADE CONSTRAINTS ;
drop table orders_item CASCADE CONSTRAINTS ;
drop table second_ProdPhotos CASCADE CONSTRAINTS ;
drop table second_ProdMsg CASCADE CONSTRAINTS ;
drop table product CASCADE CONSTRAINTS ;
drop table second_Prod CASCADE CONSTRAINTS ;
drop table orders CASCADE CONSTRAINTS ;
drop table emp_purview CASCADE CONSTRAINTS ;
drop table purview CASCADE CONSTRAINTS ;
drop table animal_index CASCADE CONSTRAINTS ;
drop table emg_H_Msg CASCADE CONSTRAINTS ;
drop table emg_Help CASCADE CONSTRAINTS ;
drop table report CASCADE CONSTRAINTS ;
drop table rel_List CASCADE CONSTRAINTS ;
drop table priv_message CASCADE CONSTRAINTS ;
drop table shop_comment CASCADE CONSTRAINTS ;
drop table shop_photo CASCADE CONSTRAINTS ;
drop table petShop CASCADE CONSTRAINTS ;
drop table grp_comment CASCADE CONSTRAINTS ;
drop table JoinList CASCADE CONSTRAINTS ;
drop table petGroup CASCADE CONSTRAINTS ;
drop table hos_photo CASCADE CONSTRAINTS ;
drop table hos_comment CASCADE CONSTRAINTS ;
drop table vet_hospital CASCADE CONSTRAINTS ;
drop table stray_Ani_photos CASCADE CONSTRAINTS ;
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
drop table post_Response CASCADE CONSTRAINTS ;
drop table post CASCADE CONSTRAINTS ;
drop table offiMsg CASCADE CONSTRAINTS ;
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

CREATE TABLE charge (charge_no VARCHAR2(8),mem_Id VARCHAR2(8),charge_NUMBER NUMBER(15) NOT NULL ,pay NUMBER(1),applytime DATE NOT NULL  );
CREATE TABLE product_kind (product_kind_no VARCHAR2(5),product_kind_name VARCHAR2(10) NOT NULL  );
CREATE TABLE orders_item (orders_item_no VARCHAR2(8),orders_no VARCHAR2(8),product_no VARCHAR2(8),commodities_amout NUMBER(15),selling_price NUMBER(15) );
CREATE TABLE second_ProdPhotos (second_ProdPhotos_Id VARCHAR2(8),second_Prod_Id VARCHAR2(8) NOT NULL  );
CREATE TABLE second_ProdMsg (second_ProdMsg_Id VARCHAR2(8),second_Prod_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,second_ProdMsg_Msg VARCHAR2(3000),second_ProdMsg_DATE DATE,second_ProdMsg_adp_upDate DATE );
CREATE TABLE product (product_no VARCHAR2(8),product_name VARCHAR2(50) NOT NULL ,product_introduction VARCHAR2(300),product_price NUMBER(15) NOT NULL ,product_stock NUMBER(15) NOT NULL ,product_picture_large BLOB,product_picture_small BLOB,product_status NUMBER(1),product_create_date DATE NOT NULL ,product_info VARCHAR2(300),product_kind_no NUMBER(1) );
CREATE TABLE second_Prod (second_Prod_Id VARCHAR2(8),mem_Id VARCHAR2(8),second_Prod_Title VARCHAR2(90),second_Prod_Content VARCHAR2(3000),second_Prod_adp_start_date DATE,second_Prod_adp_end_date DATE,second_Prod_adp_upDate DATE,second_Prod_adp_city VARCHAR2(12),second_Prod_Town VARCHAR2(12),second_Prod_Road VARCHAR2(50),second_Prod_Lon NUMBER(9,6),second_Prod_Lat NUMBER(9,6) );
CREATE TABLE orders (orders_no VARCHAR2(8),mem_Id VARCHAR2(10),orders_receiver VARCHAR2(15) NOT NULL ,post_no VARCHAR2(5),post_adp_city VARCHAR2(15) NOT NULL ,post_town VARCHAR2(15) NOT NULL ,post_road VARCHAR2(30) NOT NULL ,orders_phone NUMBER(10) NOT NULL ,collect_mode_no NUMBER(1) NOT NULL ,orders_date DATE NOT NULL ,orders_ship_date DATE,orders_total NUMBER(8),orders_status NUMBER(1),orders_credit NUMBER(8) );
CREATE TABLE emp_purview (emp_No VARCHAR2(8),purview_No VARCHAR2(8) );
CREATE TABLE purview (purview_No VARCHAR2(8),purview_name VARCHAR2(50) );
CREATE TABLE animal_index (animal_No VARCHAR2(8),animal_detail VARCHAR2(300),animal_class VARCHAR2(2),animal_class_No VARCHAR2(2) );
CREATE TABLE emg_H_Msg (emg_H_Msg_Id VARCHAR2(8),mem_Id VARCHAR2(8),emg_H_Id VARCHAR2(8),emg_H_Msg_start DATE,emg_H_Msg_content VARCHAR2(300) );
CREATE TABLE emg_Help (emg_H_Id VARCHAR2(8),mem_Id VARCHAR2(8),emg_H_start_date DATE,emg_H_end_date DATE,emg_H_title VARCHAR2(90),emg_H_content VARCHAR2(3000),emg_H_Pic BLOB,emg_H_Pic_format VARCHAR2(10),emg_H_city VARCHAR2(20),emg_H_town VARCHAR2(20),emg_H_road VARCHAR2(50),emg_H_Lon NUMBER(9,6),emg_H_Lat NUMBER(9,6),emg_H_status VARCHAR2(30) );
CREATE TABLE report (report_No VARCHAR2(8),report_name VARCHAR2(30),report_class VARCHAR2(30),report_class_No VARCHAR2(30),report_class_No_value VARCHAR2(30),report_content VARCHAR2(300),report_status VARCHAR2(2),mem_Id_active VARCHAR2(8),mem_Id_passive VARCHAR2(8),report_time DATE,report_class_status VARCHAR2(30) );
CREATE TABLE rel_List (rel_MemId VARCHAR2(8),added_MemId VARCHAR2(8),isBlackList VARCHAR2(1) NOT NULL ,isInvited VARCHAR2(1) NOT NULL  );
CREATE TABLE priv_message (privMsg_Id VARCHAR2(8),privMsgSend_MemId VARCHAR2(8) NOT NULL ,privMsgRec_MemId VARCHAR2(8) NOT NULL ,privMsg_content VARCHAR2(300),privMsg_SendTime DATE,privMsg_type VARCHAR2(1) NOT NULL  );
CREATE TABLE shop_comment (shopComment_Id VARCHAR2(8),shopComment_MemId VARCHAR2(8) NOT NULL ,shopComment_ShopId VARCHAR2(8) NOT NULL ,shopComment_content VARCHAR2(300),shopComment_SendTime DATE );
CREATE TABLE shop_photo (shopPhoto_Id VARCHAR2(8),shopPhoto_ShopId VARCHAR2(8) NOT NULL ,shopPhoto_photo BLOB NOT NULL ,isDisp_shopPhoto VARCHAR2(1) NOT NULL ,shopPhoto_name VARCHAR2(20),SHOPPHOTO_EXTENTION VARCHAR2(8) );
CREATE TABLE petShop (shop_Id VARCHAR2(8),shop_MemId VARCHAR2(8) NOT NULL ,shop_name VARCHAR2(50) NOT NULL ,shop_city VARCHAR2(20) NOT NULL ,shop_town VARCHAR2(50),shop_road VARCHAR2(50),shop_Eval NUMBER(20),shop_URL VARCHAR2(300),shop_StartTime VARCHAR2(20),shop_EndTime VARCHAR2(20),shop_CreateTime DATE,shop_Tel VARCHAR2(20),shop_Desc VARCHAR2(3000),shop_Long NUMBER(9,6),shop_Lat NUMBER(9,6),shop_visible VARCHAR2(1) );
CREATE TABLE grp_comment (grpComment_Id VARCHAR2(8),grpComment_MemId VARCHAR2(8) NOT NULL ,grpComment_GrpId VARCHAR2(8) NOT NULL ,grpComment_content VARCHAR2(300),grpComment_SendTime DATE );
CREATE TABLE JoinList (joinList_GrpId VARCHAR2(8),joinList_MemId VARCHAR2(8),JOINLIST_ISINVITED VARCHAR2(1) );
CREATE TABLE petGroup (grp_Id VARCHAR2(8),grp_MemId VARCHAR2(8) NOT NULL ,grp_name VARCHAR2(50) NOT NULL ,grp_city VARCHAR2(20) NOT NULL ,GRP_TOWN VARCHAR2(50) NOT NULL ,grp_road VARCHAR2(50),grp_EndTime DATE NOT NULL ,grp_StartTime DATE NOT NULL ,grp_CreateTime DATE,grp_Desc VARCHAR2(3000),grp_Long NUMBER(9,6),grp_Lat NUMBER(9,6),grp_visible VARCHAR2(1),GRP_PHOTO BLOB );
CREATE TABLE hos_photo (hosPhoto_Id VARCHAR2(8),hosPhoto_HosId VARCHAR2(8) NOT NULL ,hosPhoto_photo BLOB NOT NULL ,isDisp_HosPhoto VARCHAR2(1) NOT NULL ,hosPhoto_name VARCHAR2(30),HOSPHOTO_EXTENTION VARCHAR2(8) );
CREATE TABLE hos_comment (hosComment_Id VARCHAR2(8),hosComment_MemId VARCHAR2(8) NOT NULL ,hosComment_HosId VARCHAR2(8) NOT NULL ,hosComment_content VARCHAR2(300) NOT NULL ,hosComment_SendTime DATE NOT NULL  );
CREATE TABLE vet_hospital (hos_Id VARCHAR2(8),hos_MemId VARCHAR2(8) NOT NULL ,hos_name VARCHAR2(50) NOT NULL ,hos_city VARCHAR2(20),hos_town VARCHAR2(50),hos_road VARCHAR2(50),hos_Eval NUMBER(20),hos_URL VARCHAR2(300),hos_StartTime VARCHAR2(20),hos_EndTime VARCHAR2(20),hos_CreateTime DATE,hos_Tel VARCHAR2(20),hos_Desc VARCHAR2(3000),hos_Long NUMBER(9,6),hos_Lat NUMBER(9,6),hos_visible VARCHAR2(1) );
CREATE TABLE stray_Ani_photos (str_Ani_Pic_No VARCHAR2(8),stray_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,stray_Ani_Pic BLOB NOT NULL ,stray_Pic_name VARCHAR2(24),stray_Pic_nameEX VARCHAR2(5),stray_Pic_time DATE,stray_Pic_type VARCHAR2(1) );
CREATE TABLE stray_Ani_message (str_Ani_Mes_No VARCHAR2(8),stray_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,str_Ani_Mes_time DATE,str_Ani_Mes VARCHAR2(300) NOT NULL  );
CREATE TABLE stray_Ani_Loc (str_Ani_Loc_No VARCHAR2(8),stray_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,str_Ani_LocLat NUMBER(9,6),str_Ani_LocLon NUMBER(9,6) );
CREATE TABLE stray_Ani (stray_Ani_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,stray_Ani_name VARCHAR2(30) NOT NULL ,stray_Ani_type VARCHAR2(15) NOT NULL ,stray_Ani_gender VARCHAR2(3),stray_Ani_heal VARCHAR2(60),stray_Ani_Vac VARCHAR2(60),stray_Ani_color VARCHAR2(20),stray_Ani_body VARCHAR2(20),stray_Ani_age VARCHAR2(15),stray_Ani_Neu VARCHAR2(1),stray_Ani_chip VARCHAR2(15),stray_Ani_date DATE,stray_Ani_status VARCHAR2(1),stray_Ani_CreDate DATE,stray_Ani_FinLat NUMBER(9,6),stray_Ani_FinLon NUMBER(9,6),stray_Ani_city VARCHAR2(12) NOT NULL ,stray_Ani_town VARCHAR2(12) NOT NULL ,stray_Ani_road VARCHAR2(50) NOT NULL  );
CREATE TABLE pet_Photos (pet_Pic_No VARCHAR2(8),pet_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,pet_Pic BLOB NOT NULL ,pet_Pic_name VARCHAR2(24),pet_Pic_nameEX VARCHAR2(5),pet_Pic_time DATE,pet_Pic_type VARCHAR2(1) );
CREATE TABLE pet_Message (pet_Mes_No VARCHAR2(8),pet_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,pet_Mes VARCHAR2(300) NOT NULL ,pet_Mes_time DATE );
CREATE TABLE pet (pet_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,pet_name VARCHAR2(30) NOT NULL ,pet_type VARCHAR2(15) NOT NULL ,pet_gender VARCHAR2(3),pet_heal VARCHAR2(60),pet_Vac VARCHAR2(60),pet_color VARCHAR2(20),pet_body VARCHAR2(20),pet_age VARCHAR2(15),pet_Neu VARCHAR2(1),pet_chip VARCHAR2(15),pet_birth DATE,pet_status VARCHAR2(1),pet_CreDATE DATE,pet_city VARCHAR2(12),pet_town VARCHAR2(12),pet_road VARCHAR2(50),pet_FinLat NUMBER(9,6),pet_FinLon NUMBER(9,6) );
CREATE TABLE adopt_Ani_photos (ado_Ani_Pic_No VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,ado_Ani_Pic BLOB NOT NULL ,ado_Pic_name VARCHAR2(24),ado_Pic_nameEX VARCHAR2(5),ado_Pic_time DATE,ado_Pic_type VARCHAR2(1) );
CREATE TABLE adopt_Ani_message (ado_Ani_Mes_No VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,ado_Ani_Mes VARCHAR2(100) NOT NULL ,ado_Ani_Mes_time DATE );
CREATE TABLE adopt_Ani_sponsor (ado_Ani_Spo_No VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,ado_Ani_Spo_money NUMBER(15),ado_Ani_Spo_thing VARCHAR2(30),ado_Ani_Spo_time DATE );
CREATE TABLE adoAniSpo (adoAniSpoNo VARCHAR2(8),adopt_Ani_Id VARCHAR2(8) NOT NULL ,mem_Id VARCHAR2(8) NOT NULL ,adoAniSpoMoney NUMBER(15),adoAniSpoMat VARCHAR2(30) );
CREATE TABLE adopt_Ani (adopt_Ani_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,adopt_Ani_name VARCHAR2(30) NOT NULL ,adopt_Ani_type VARCHAR2(15) NOT NULL ,adopt_Ani_gender VARCHAR2(3),adopt_Ani_heal VARCHAR2(60),adopt_Ani_Vac VARCHAR2(60),adopt_Ani_color VARCHAR2(20),adopt_Ani_body VARCHAR2(20),adopt_Ani_age VARCHAR2(15),adopt_Ani_Neu VARCHAR2(1),adopt_Ani_chip VARCHAR2(15),adopt_Ani_date DATE,adopt_Ani_status VARCHAR2(1),adopt_Ani_CreDate DATE,adopt_Ani_FinLat NUMBER(9,6),adopt_Ani_FinLon NUMBER(9,6),adopt_Ani_city VARCHAR2(12) NOT NULL ,adopt_Ani_town VARCHAR2(12) NOT NULL ,adopt_Ani_road VARCHAR2(50) NOT NULL ,adopt_Ani_like NUMBER(4) );
CREATE TABLE post_Response (res_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,post_Id VARCHAR2(8) NOT NULL ,post_Response_content VARCHAR2(900) NOT NULL ,post_time DATE,post_Response_upDate DATE );
CREATE TABLE post (post_Id VARCHAR2(8),mem_Id VARCHAR2(8) NOT NULL ,post_class VARCHAR2(10),post_class_Id VARCHAR2(8),post_title VARCHAR2(80) NOT NULL ,post_content VARCHAR2(3000) NOT NULL ,post_time DATE NOT NULL ,post_upDate DATE,post_resNum NUMBER(4) );
CREATE TABLE offiMsg (offiMsg_Id VARCHAR2(8),emp_No VARCHAR2(8) NOT NULL ,offiMsg_Title VARCHAR2(90),offiMsg_Content VARCHAR2(3000),offiMsg_Date DATE );
CREATE TABLE track (track_Id VARCHAR2(8),mem_Id VARCHAR2(8),track_record_class VARCHAR2(1),track_record_class_Id VARCHAR2(8) );
CREATE TABLE adpPhotos (adpPhotos_Id VARCHAR2(8),adp_Id VARCHAR2(8),adpPhotosPic CLOB );
CREATE TABLE adpMsg (adpMsg_Id VARCHAR2(8),adp_Id VARCHAR2(8),mem_Id VARCHAR2(8),msg VARCHAR2(3000),adpMsgDate DATE,adpMsgadp_upDate DATE );
CREATE TABLE adp (adp_Id VARCHAR2(8),mem_Id VARCHAR2(8),adp_title VARCHAR2(90),adp_adp_content CLOB,adp_start_date DATE,adp_end_date DATE,adp_upDate DATE,adp_city VARCHAR2(12),adp_town VARCHAR2(12),adp_road VARCHAR2(50),adp_addr CLOB,adp_lon NUMBER(9,6),adp_lat NUMBER(9,6),adp_adp_pic CLOB );
CREATE TABLE park (park_Id VARCHAR2(8),emp_No VARCHAR2(8),park_title VARCHAR2(90),park_content CLOB,park_pic CLOB,park_start_date DATE,park_upDate DATE,park_city VARCHAR2(12),park_town VARCHAR2(12),park_road VARCHAR2(50),park_lon NUMBER(9,6),park_lat NUMBER(9,6) );
CREATE TABLE aniHome_Photos (aniHome_Photos_Id VARCHAR2(8),aniHome_Id VARCHAR2(8),aniHome_Photos_pic CLOB );
CREATE TABLE aniHome_Msg (aniHome_Msg_Id VARCHAR2(8),aniHome_Id VARCHAR2(8),mem_Id VARCHAR2(8),aniHome_Msg CLOB,adp_start_date DATE NOT NULL  );
CREATE TABLE aniHome (aniHome_Id VARCHAR2(8),mem_Id VARCHAR2(8),aniHome_title VARCHAR2(90) NOT NULL ,aniHome_content CLOB NOT NULL ,aniHome_start_date DATE NOT NULL ,aniHome_upDate DATE,aniHome_city VARCHAR2(12),aniHome_town VARCHAR2(12),aniHome_road VARCHAR2(50),aniHome_addr VARCHAR2(300),aniHome_lon NUMBER(9,6),aniHome_lat NUMBER(9,6),aniHome_pic CLOB );
CREATE TABLE mem (mem_Id VARCHAR2(8),mem_account VARCHAR2(60) NOT NULL ,mem_email VARCHAR2(60) NOT NULL ,mem_Psw VARCHAR2(60) NOT NULL ,mem_nick_name VARCHAR2(60) NOT NULL ,mem_name VARCHAR2(40) NOT NULL ,mem_gender VARCHAR2(3) NOT NULL ,mem_Tw_Id VARCHAR2(10) NOT NULL ,mem_birth_date DATE NOT NULL ,mem_phone VARCHAR2(30) NOT NULL ,mem_Intro VARCHAR2(150),mem_profile VARCHAR2(40),mem_black_list VARCHAR2(1),mem_permission VARCHAR2(1),mem_setting VARCHAR2(30),mem_balance NUMBER(10) );
CREATE TABLE emp (emp_No VARCHAR2(8),emp_name VARCHAR2(30) NOT NULL ,emp_Pw VARCHAR2(60) NOT NULL ,emp_email VARCHAR2(60),emp_Id VARCHAR2(20),emp_birthday DATE,emp_phone VARCHAR2(15),emp_address VARCHAR2(100),emp_status VARCHAR2(1),emp_picture BLOB,emp_Pic_format VARCHAR2(10),emp_hiredate DATE NOT NULL ,emp_firedate DATE );

--------------------------------------------------------
--  Create PK 
--------------------------------------------------------

ALTER TABLE charge MODIFY (
charge_no NOT NULL 
);
ALTER TABLE charge ADD CONSTRAINT charge_PK PRIMARY KEY (
charge_no 
) ENABLE; 
ALTER TABLE product_kind MODIFY (
product_kind_no NOT NULL 
);
ALTER TABLE product_kind ADD CONSTRAINT product_kind_PK PRIMARY KEY (
product_kind_no 
) ENABLE; 
ALTER TABLE orders_item MODIFY (
orders_item_no NOT NULL 
 , orders_no NOT NULL 
 , product_no NOT NULL 
);
ALTER TABLE orders_item ADD CONSTRAINT orders_item_PK PRIMARY KEY (
orders_item_no 
 , orders_no 
 , product_no 
) ENABLE; 
ALTER TABLE second_ProdPhotos MODIFY (
second_ProdPhotos_Id NOT NULL 
);
ALTER TABLE second_ProdPhotos ADD CONSTRAINT second_ProdPhotos_PK PRIMARY KEY (
second_ProdPhotos_Id 
) ENABLE; 
ALTER TABLE second_ProdMsg MODIFY (
second_ProdMsg_Id NOT NULL 
);
ALTER TABLE second_ProdMsg ADD CONSTRAINT second_ProdMsg_PK PRIMARY KEY (
second_ProdMsg_Id 
) ENABLE; 
ALTER TABLE product MODIFY (
product_no NOT NULL 
);
ALTER TABLE product ADD CONSTRAINT product_PK PRIMARY KEY (
product_no 
) ENABLE; 
ALTER TABLE second_Prod MODIFY (
second_Prod_Id NOT NULL 
);
ALTER TABLE second_Prod ADD CONSTRAINT second_Prod_PK PRIMARY KEY (
second_Prod_Id 
) ENABLE; 
ALTER TABLE orders MODIFY (
orders_no NOT NULL 
);
ALTER TABLE orders ADD CONSTRAINT orders_PK PRIMARY KEY (
orders_no 
) ENABLE; 
ALTER TABLE emp_purview MODIFY (
emp_No NOT NULL 
 , purview_No NOT NULL 
);
ALTER TABLE emp_purview ADD CONSTRAINT emp_purview_PK PRIMARY KEY (
emp_No 
 , purview_No 
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
ALTER TABLE emg_Help MODIFY (
emg_H_Id NOT NULL 
);
ALTER TABLE emg_Help ADD CONSTRAINT emg_Help_PK PRIMARY KEY (
emg_H_Id 
) ENABLE; 
ALTER TABLE report MODIFY (
report_No NOT NULL 
);
ALTER TABLE report ADD CONSTRAINT report_PK PRIMARY KEY (
report_No 
) ENABLE; 
ALTER TABLE rel_List MODIFY (
rel_MemId NOT NULL 
 , added_MemId NOT NULL 
);
ALTER TABLE rel_List ADD CONSTRAINT rel_List_PK PRIMARY KEY (
rel_MemId 
 , added_MemId 
) ENABLE; 
ALTER TABLE priv_message MODIFY (
privMsg_Id NOT NULL 
);
ALTER TABLE priv_message ADD CONSTRAINT priv_message_PK PRIMARY KEY (
privMsg_Id 
) ENABLE; 
ALTER TABLE shop_comment MODIFY (
shopComment_Id NOT NULL 
);
ALTER TABLE shop_comment ADD CONSTRAINT shop_comment_PK PRIMARY KEY (
shopComment_Id 
) ENABLE; 
ALTER TABLE shop_photo MODIFY (
shopPhoto_Id NOT NULL 
);
ALTER TABLE shop_photo ADD CONSTRAINT shop_photo_PK PRIMARY KEY (
shopPhoto_Id 
) ENABLE; 
ALTER TABLE petShop MODIFY (
shop_Id NOT NULL 
);
ALTER TABLE petShop ADD CONSTRAINT petShop_PK PRIMARY KEY (
shop_Id 
) ENABLE; 
ALTER TABLE grp_comment MODIFY (
grpComment_Id NOT NULL 
);
ALTER TABLE grp_comment ADD CONSTRAINT grp_comment_PK PRIMARY KEY (
grpComment_Id 
) ENABLE; 
ALTER TABLE JoinList MODIFY (
joinList_GrpId NOT NULL 
 , joinList_MemId NOT NULL 
);
ALTER TABLE JoinList ADD CONSTRAINT JoinList_PK PRIMARY KEY (
joinList_GrpId 
 , joinList_MemId 
) ENABLE; 
ALTER TABLE petGroup MODIFY (
grp_Id NOT NULL 
);
ALTER TABLE petGroup ADD CONSTRAINT petGroup_PK PRIMARY KEY (
grp_Id 
) ENABLE; 
ALTER TABLE hos_photo MODIFY (
hosPhoto_Id NOT NULL 
);
ALTER TABLE hos_photo ADD CONSTRAINT hos_photo_PK PRIMARY KEY (
hosPhoto_Id 
) ENABLE; 
ALTER TABLE hos_comment MODIFY (
hosComment_Id NOT NULL 
);
ALTER TABLE hos_comment ADD CONSTRAINT hos_comment_PK PRIMARY KEY (
hosComment_Id 
) ENABLE; 
ALTER TABLE vet_hospital MODIFY (
hos_Id NOT NULL 
);
ALTER TABLE vet_hospital ADD CONSTRAINT vet_hospital_PK PRIMARY KEY (
hos_Id 
) ENABLE; 
ALTER TABLE stray_Ani_photos MODIFY (
str_Ani_Pic_No NOT NULL 
);
ALTER TABLE stray_Ani_photos ADD CONSTRAINT stray_Ani_photos_PK PRIMARY KEY (
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
ALTER TABLE post_Response MODIFY (
res_Id NOT NULL 
);
ALTER TABLE post_Response ADD CONSTRAINT post_Response_PK PRIMARY KEY (
res_Id 
) ENABLE; 
ALTER TABLE post MODIFY (
post_Id NOT NULL 
);
ALTER TABLE post ADD CONSTRAINT post_PK PRIMARY KEY (
post_Id 
) ENABLE; 
ALTER TABLE offiMsg MODIFY (
offiMsg_Id NOT NULL 
);
ALTER TABLE offiMsg ADD CONSTRAINT offiMsg_PK PRIMARY KEY (
offiMsg_Id 
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

ALTER TABLE charge ADD CONSTRAINT charge_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE orders_item ADD CONSTRAINT orders_item_FK1 FOREIGN KEY ( orders_no ) REFERENCES orders ( orders_no ) ENABLE;
ALTER TABLE orders_item ADD CONSTRAINT orders_item_FK2 FOREIGN KEY ( product_no ) REFERENCES product ( product_no ) ENABLE;
ALTER TABLE second_ProdPhotos ADD CONSTRAINT second_ProdPhotos_FK1 FOREIGN KEY ( second_Prod_Id ) REFERENCES second_Prod ( second_Prod_Id ) ENABLE;
ALTER TABLE second_ProdMsg ADD CONSTRAINT second_ProdMsg_FK1 FOREIGN KEY ( second_Prod_Id ) REFERENCES second_Prod ( second_Prod_Id ) ENABLE;
ALTER TABLE second_ProdMsg ADD CONSTRAINT second_ProdMsg_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE second_Prod ADD CONSTRAINT second_Prod_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE orders ADD CONSTRAINT orders_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE emp_purview ADD CONSTRAINT emp_purview_FK1 FOREIGN KEY ( emp_No ) REFERENCES emp ( emp_No ) ENABLE;
ALTER TABLE emp_purview ADD CONSTRAINT emp_purview_FK2 FOREIGN KEY ( purview_No ) REFERENCES purview ( purview_No ) ENABLE;
ALTER TABLE emg_H_Msg ADD CONSTRAINT emg_H_Msg_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE emg_H_Msg ADD CONSTRAINT emg_H_Msg_FK2 FOREIGN KEY ( emg_H_Id ) REFERENCES emg_Help ( emg_H_Id ) ENABLE;
ALTER TABLE emg_Help ADD CONSTRAINT emg_Help_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE report ADD CONSTRAINT report_FK1 FOREIGN KEY ( mem_Id_active ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE report ADD CONSTRAINT report_FK2 FOREIGN KEY ( mem_Id_passive ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE rel_List ADD CONSTRAINT rel_List_FK1 FOREIGN KEY ( rel_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE rel_List ADD CONSTRAINT rel_List_FK2 FOREIGN KEY ( added_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE priv_message ADD CONSTRAINT priv_message_FK1 FOREIGN KEY ( privMsgSend_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE priv_message ADD CONSTRAINT priv_message_FK2 FOREIGN KEY ( privMsgRec_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE shop_comment ADD CONSTRAINT shop_comment_FK1 FOREIGN KEY ( shopComment_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE shop_comment ADD CONSTRAINT shop_comment_FK2 FOREIGN KEY ( shopComment_ShopId ) REFERENCES petShop ( shop_Id ) ENABLE;
ALTER TABLE shop_photo ADD CONSTRAINT shop_photo_FK1 FOREIGN KEY ( shopPhoto_ShopId ) REFERENCES petShop ( shop_Id ) ENABLE;
ALTER TABLE petShop ADD CONSTRAINT petShop_FK1 FOREIGN KEY ( shop_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE grp_comment ADD CONSTRAINT grp_comment_FK1 FOREIGN KEY ( grpComment_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE grp_comment ADD CONSTRAINT grp_comment_FK2 FOREIGN KEY ( grpComment_GrpId ) REFERENCES petGroup ( grp_Id ) ENABLE;
ALTER TABLE JoinList ADD CONSTRAINT JoinList_FK1 FOREIGN KEY ( joinList_GrpId ) REFERENCES petGroup ( grp_Id ) ENABLE;
ALTER TABLE JoinList ADD CONSTRAINT JoinList_FK2 FOREIGN KEY ( joinList_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE petGroup ADD CONSTRAINT petGroup_FK1 FOREIGN KEY ( grp_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE hos_photo ADD CONSTRAINT hos_photo_FK1 FOREIGN KEY ( hosPhoto_HosId ) REFERENCES vet_hospital ( hos_Id ) ENABLE;
ALTER TABLE hos_comment ADD CONSTRAINT hos_comment_FK1 FOREIGN KEY ( hosComment_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE hos_comment ADD CONSTRAINT hos_comment_FK2 FOREIGN KEY ( hosComment_HosId ) REFERENCES vet_hospital ( hos_Id ) ENABLE;
ALTER TABLE vet_hospital ADD CONSTRAINT vet_hospital_FK1 FOREIGN KEY ( hos_MemId ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE stray_Ani_photos ADD CONSTRAINT stray_Ani_photos_FK1 FOREIGN KEY ( stray_Ani_Id ) REFERENCES stray_Ani ( stray_Ani_Id ) ENABLE;
ALTER TABLE stray_Ani_photos ADD CONSTRAINT stray_Ani_photos_FK2 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
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
ALTER TABLE post_Response ADD CONSTRAINT post_Response_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE post_Response ADD CONSTRAINT post_Response_FK2 FOREIGN KEY ( post_Id ) REFERENCES post ( post_Id ) ENABLE;
ALTER TABLE post ADD CONSTRAINT post_FK1 FOREIGN KEY ( mem_Id ) REFERENCES mem ( mem_Id ) ENABLE;
ALTER TABLE offiMsg ADD CONSTRAINT offiMsg_FK1 FOREIGN KEY ( emp_No ) REFERENCES emp ( emp_No ) ENABLE;
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
ALTER TABLE emp ADD CONSTRAINT emp_UK2 UNIQUE ( emp_Id )ENABLE;

--------------------------------------------------------
--  Create SEQUENCE  
--------------------------------------------------------

CREATE SEQUENCE  charge_seq1 INCREMENT BY 1 START WITH 25000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  product_kind_seq1 INCREMENT BY 1 START WITH 11300000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  orders_item_seq1 INCREMENT BY 1 START WITH 24000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  second_ProdPhotos_seq1 INCREMENT BY 1 START WITH 11200000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  second_ProdMsg_seq1 INCREMENT BY 1 START WITH 11100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  product_seq1 INCREMENT BY 1 START WITH 11000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  second_Prod_seq1 INCREMENT BY 1 START WITH 10000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  orders_seq1 INCREMENT BY 1 START WITH 26000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  purview_seq1 INCREMENT BY 1 START WITH 21000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  animal_index_seq1 INCREMENT BY 1 START WITH 20000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  emg_H_Msg_seq1 INCREMENT BY 1 START WITH 7100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  emg_Help_seq1 INCREMENT BY 1 START WITH 7000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  report_seq1 INCREMENT BY 1 START WITH 20000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  priv_message_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  shop_comment_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  shop_photo_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  petShop_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  grp_comment_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  petGroup_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  hos_photo_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  hos_comment_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  vet_hospital_seq1 INCREMENT BY 1 START WITH 1 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  stray_Ani_photos_seq1 INCREMENT BY 1 START WITH 2100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
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
CREATE SEQUENCE  post_Response_seq1 INCREMENT BY 1 START WITH 16100000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  post_seq1 INCREMENT BY 1 START WITH 16000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
CREATE SEQUENCE  offiMsg_seq1 INCREMENT BY 1 START WITH 22000000 NOMAXVALUE  NOCYCLE  NOCACHE ;
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


