package com.pet.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:自家寵物<br>
 *	英文:pet<br>
 */ 
public class PetDAO implements PetDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO (pet_Id,mem_Id,pet_name,pet_type,pet_gender,pet_heal,pet_Vac,pet_color,pet_body,pet_age,pet_Neu,pet_chip,pet_birth,pet_status,pet_CreDATE,pet_city,pet_town,pet_road,pet_FinLat,pet_FinLon ) VALUES  ( pet_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet SET pet_name=?,pet_type=? ,pet_gender=? ,pet_heal=? ,pet_Vac=? ,pet_color=? ,pet_body=? ,pet_age=? ,pet_Neu=? ,pet_chip=? ,pet_birth=? ,pet_status=? ,pet_CreDATE=? ,pet_city=? ,pet_town=? ,pet_road=? ,pet_FinLat=? ,pet_FinLon=?  WHERE pet_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet WHERE pet_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT pet_Id,mem_Id,pet_name,pet_type,pet_gender,pet_heal,pet_Vac,pet_color,pet_body,pet_age,pet_Neu,pet_chip,to_char(pet_birth,'yyyy-mm-dd') pet_birth,pet_status,to_char(pet_CreDATE,'yyyy-mm-dd') pet_CreDATE,pet_city,pet_town,pet_road,pet_FinLat,pet_FinLon WHERE pet_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT pet_Id,mem_Id,pet_name,pet_type,pet_gender,pet_heal,pet_Vac,pet_color,pet_body,pet_age,pet_Neu,pet_chip,to_char(pet_birth,'yyyy-mm-dd') pet_birth,pet_status,to_char(pet_CreDATE,'yyyy-mm-dd') pet_CreDATE,pet_city,pet_town,pet_road,pet_FinLat,pet_FinLon WHERE pet_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_PET_NAME =" UPDATE pet set PET_NAME=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_TYPE =" UPDATE pet set PET_TYPE=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_GENDER =" UPDATE pet set PET_GENDER=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_HEAL =" UPDATE pet set PET_HEAL=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_VAC =" UPDATE pet set PET_VAC=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_COLOR =" UPDATE pet set PET_COLOR=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_BODY =" UPDATE pet set PET_BODY=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_AGE =" UPDATE pet set PET_AGE=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_NEU =" UPDATE pet set PET_NEU=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_CHIP =" UPDATE pet set PET_CHIP=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_BIRTH =" UPDATE pet set PET_BIRTH=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_STATUS =" UPDATE pet set PET_STATUS=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_CREDATE =" UPDATE pet set PET_CREDATE=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_CITY =" UPDATE pet set PET_CITY=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_TOWN =" UPDATE pet set PET_TOWN=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_ROAD =" UPDATE pet set PET_ROAD=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_FINLAT =" UPDATE pet set PET_FINLAT=?  WHERE pet_Id=? " ; 
	private static final String UPDATE_PET_FINLON =" UPDATE pet set PET_FINLON=?  WHERE pet_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(PetVO aPetVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetDAO.INSERT_STMT);
			pstmt.setString (1, aPetVO.getMem_Id());
			pstmt.setString (2, aPetVO.getPet_name());
			pstmt.setString (3, aPetVO.getPet_type());
			pstmt.setString (4, aPetVO.getPet_gender());
			pstmt.setString (5, aPetVO.getPet_heal());
			pstmt.setString (6, aPetVO.getPet_Vac());
			pstmt.setString (7, aPetVO.getPet_color());
			pstmt.setString (8, aPetVO.getPet_body());
			pstmt.setString (9, aPetVO.getPet_age());
			pstmt.setString (10, aPetVO.getPet_Neu());
			pstmt.setString (11, aPetVO.getPet_chip());
			pstmt.setDate (12, aPetVO.getPet_birth());
			pstmt.setString (13, aPetVO.getPet_status());
			pstmt.setDate (14, aPetVO.getPet_CreDATE());
			pstmt.setString (15, aPetVO.getPet_city());
			pstmt.setString (16, aPetVO.getPet_town());
			pstmt.setString (17, aPetVO.getPet_road());
			pstmt.setDouble (18, aPetVO.getPet_FinLat());
			pstmt.setDouble (19, aPetVO.getPet_FinLon());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	} 
	//====以下是改寫update方法====
	@Override
	public void update(PetVO aPetVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetDAO.UPDATE);
			pstmt.setString (1, aPetVO.getPet_name());
			pstmt.setString (2, aPetVO.getPet_type());
			pstmt.setString (3, aPetVO.getPet_gender());
			pstmt.setString (4, aPetVO.getPet_heal());
			pstmt.setString (5, aPetVO.getPet_Vac());
			pstmt.setString (6, aPetVO.getPet_color());
			pstmt.setString (7, aPetVO.getPet_body());
			pstmt.setString (8, aPetVO.getPet_age());
			pstmt.setString (9, aPetVO.getPet_Neu());
			pstmt.setString (10, aPetVO.getPet_chip());
			pstmt.setDate (11, aPetVO.getPet_birth());
			pstmt.setString (12, aPetVO.getPet_status());
			pstmt.setDate (13, aPetVO.getPet_CreDATE());
			pstmt.setString (14, aPetVO.getPet_city());
			pstmt.setString (15, aPetVO.getPet_town());
			pstmt.setString (16, aPetVO.getPet_road());
			pstmt.setDouble (17, aPetVO.getPet_FinLat());
			pstmt.setDouble (18, aPetVO.getPet_FinLon());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	} 
	//====以下是改寫delete方法====
	@Override
	public void delete(String  aPet){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetDAO.DELETE);
			pstmt.setString (1,aPet);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	} 
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public PetVO findByPrimaryKey(String  aPet){
		PetVO petVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PetDAO.GET_ONE_STMT);
			pstmt.setString (1,aPet);
			pstmt.executeUpdate();
			while (rs.next()) {
				petVO = new PetVO();
				petVO.setPet_Id(rs.getString("pet_Id"));
				petVO.setMem_Id(rs.getString("mem_Id"));
				petVO.setPet_name(rs.getString("pet_name"));
				petVO.setPet_type(rs.getString("pet_type"));
				petVO.setPet_gender(rs.getString("pet_gender"));
				petVO.setPet_heal(rs.getString("pet_heal"));
				petVO.setPet_Vac(rs.getString("pet_Vac"));
				petVO.setPet_color(rs.getString("pet_color"));
				petVO.setPet_body(rs.getString("pet_body"));
				petVO.setPet_age(rs.getString("pet_age"));
				petVO.setPet_Neu(rs.getString("pet_Neu"));
				petVO.setPet_chip(rs.getString("pet_chip"));
				petVO.setPet_birth(rs.getDate("pet_birth"));
				petVO.setPet_status(rs.getString("pet_status"));
				petVO.setPet_CreDATE(rs.getDate("pet_CreDATE"));
				petVO.setPet_city(rs.getString("pet_city"));
				petVO.setPet_town(rs.getString("pet_town"));
				petVO.setPet_road(rs.getString("pet_road"));
				petVO.setPet_FinLat(rs.getDouble("pet_FinLat"));
				petVO.setPet_FinLon(rs.getDouble("pet_FinLon"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
		if (rs != null) {
			try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return petVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<PetVO> getAll(){ 
		List<PetVO> list = new ArrayList<PetVO>();
		PetVO petVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	} 
}