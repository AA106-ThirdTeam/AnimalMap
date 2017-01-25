package com.adopt_ani.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:送養動物<br>
 *	英文:adopt_Ani<br>
 */ 
public class Adopt_AniDAO implements Adopt_AniDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (adopt_Ani_Id,mem_Id,adopt_Ani_name,adopt_Ani_type,adopt_Ani_gender,adopt_Ani_heal,adopt_Ani_Vac,adopt_Ani_color,adopt_Ani_body,adopt_Ani_age,adopt_Ani_Neu,adopt_Ani_chip,adopt_Ani_date,adopt_Ani_status,adopt_Ani_CreDate,adopt_Ani_FinLat,adopt_Ani_FinLon,adopt_Ani_city,adopt_Ani_town,adopt_Ani_road ) VALUES  ( adopt_Ani_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adopt_Ani SET adopt_Ani_name=?,adopt_Ani_type=? ,adopt_Ani_gender=? ,adopt_Ani_heal=? ,adopt_Ani_Vac=? ,adopt_Ani_color=? ,adopt_Ani_body=? ,adopt_Ani_age=? ,adopt_Ani_Neu=? ,adopt_Ani_chip=? ,adopt_Ani_date=? ,adopt_Ani_status=? ,adopt_Ani_CreDate=? ,adopt_Ani_FinLat=? ,adopt_Ani_FinLon=? ,adopt_Ani_city=? ,adopt_Ani_town=? ,adopt_Ani_road=?  WHERE adopt_Ani_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adopt_Ani WHERE adopt_Ani_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT adopt_Ani_Id,mem_Id,adopt_Ani_name,adopt_Ani_type,adopt_Ani_gender,adopt_Ani_heal,adopt_Ani_Vac,adopt_Ani_color,adopt_Ani_body,adopt_Ani_age,adopt_Ani_Neu,adopt_Ani_chip,to_char(adopt_Ani_date,'yyyy-mm-dd') adopt_Ani_date,adopt_Ani_status,to_char(adopt_Ani_CreDate,'yyyy-mm-dd') adopt_Ani_CreDate,adopt_Ani_FinLat,adopt_Ani_FinLon,adopt_Ani_city,adopt_Ani_town,adopt_Ani_road WHERE adopt_Ani_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT adopt_Ani_Id,mem_Id,adopt_Ani_name,adopt_Ani_type,adopt_Ani_gender,adopt_Ani_heal,adopt_Ani_Vac,adopt_Ani_color,adopt_Ani_body,adopt_Ani_age,adopt_Ani_Neu,adopt_Ani_chip,to_char(adopt_Ani_date,'yyyy-mm-dd') adopt_Ani_date,adopt_Ani_status,to_char(adopt_Ani_CreDate,'yyyy-mm-dd') adopt_Ani_CreDate,adopt_Ani_FinLat,adopt_Ani_FinLon,adopt_Ani_city,adopt_Ani_town,adopt_Ani_road WHERE adopt_Ani_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADOPT_ANI_NAME =" UPDATE adopt_Ani set ADOPT_ANI_NAME=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_TYPE =" UPDATE adopt_Ani set ADOPT_ANI_TYPE=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_GENDER =" UPDATE adopt_Ani set ADOPT_ANI_GENDER=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_HEAL =" UPDATE adopt_Ani set ADOPT_ANI_HEAL=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_VAC =" UPDATE adopt_Ani set ADOPT_ANI_VAC=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_COLOR =" UPDATE adopt_Ani set ADOPT_ANI_COLOR=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_BODY =" UPDATE adopt_Ani set ADOPT_ANI_BODY=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_AGE =" UPDATE adopt_Ani set ADOPT_ANI_AGE=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_NEU =" UPDATE adopt_Ani set ADOPT_ANI_NEU=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_CHIP =" UPDATE adopt_Ani set ADOPT_ANI_CHIP=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_DATE =" UPDATE adopt_Ani set ADOPT_ANI_DATE=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_STATUS =" UPDATE adopt_Ani set ADOPT_ANI_STATUS=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_CREDATE =" UPDATE adopt_Ani set ADOPT_ANI_CREDATE=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_FINLAT =" UPDATE adopt_Ani set ADOPT_ANI_FINLAT=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_FINLON =" UPDATE adopt_Ani set ADOPT_ANI_FINLON=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_CITY =" UPDATE adopt_Ani set ADOPT_ANI_CITY=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_TOWN =" UPDATE adopt_Ani set ADOPT_ANI_TOWN=?  WHERE adopt_Ani_Id=? " ; 
	private static final String UPDATE_ADOPT_ANI_ROAD =" UPDATE adopt_Ani set ADOPT_ANI_ROAD=?  WHERE adopt_Ani_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Adopt_AniVO aAdopt_AniVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_AniDAO.INSERT_STMT);
			pstmt.setString (1, aAdopt_AniVO.getMem_Id());
			pstmt.setString (2, aAdopt_AniVO.getAdopt_Ani_name());
			pstmt.setString (3, aAdopt_AniVO.getAdopt_Ani_type());
			pstmt.setString (4, aAdopt_AniVO.getAdopt_Ani_gender());
			pstmt.setString (5, aAdopt_AniVO.getAdopt_Ani_heal());
			pstmt.setString (6, aAdopt_AniVO.getAdopt_Ani_Vac());
			pstmt.setString (7, aAdopt_AniVO.getAdopt_Ani_color());
			pstmt.setString (8, aAdopt_AniVO.getAdopt_Ani_body());
			pstmt.setString (9, aAdopt_AniVO.getAdopt_Ani_age());
			pstmt.setString (10, aAdopt_AniVO.getAdopt_Ani_Neu());
			pstmt.setString (11, aAdopt_AniVO.getAdopt_Ani_chip());
			pstmt.setDate (12, aAdopt_AniVO.getAdopt_Ani_date());
			pstmt.setString (13, aAdopt_AniVO.getAdopt_Ani_status());
			pstmt.setDate (14, aAdopt_AniVO.getAdopt_Ani_CreDate());
			pstmt.setDouble (15, aAdopt_AniVO.getAdopt_Ani_FinLat());
			pstmt.setDouble (16, aAdopt_AniVO.getAdopt_Ani_FinLon());
			pstmt.setString (17, aAdopt_AniVO.getAdopt_Ani_city());
			pstmt.setString (18, aAdopt_AniVO.getAdopt_Ani_town());
			pstmt.setString (19, aAdopt_AniVO.getAdopt_Ani_road());
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
	public void update(Adopt_AniVO aAdopt_AniVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_AniDAO.UPDATE);
			pstmt.setString (1, aAdopt_AniVO.getAdopt_Ani_name());
			pstmt.setString (2, aAdopt_AniVO.getAdopt_Ani_type());
			pstmt.setString (3, aAdopt_AniVO.getAdopt_Ani_gender());
			pstmt.setString (4, aAdopt_AniVO.getAdopt_Ani_heal());
			pstmt.setString (5, aAdopt_AniVO.getAdopt_Ani_Vac());
			pstmt.setString (6, aAdopt_AniVO.getAdopt_Ani_color());
			pstmt.setString (7, aAdopt_AniVO.getAdopt_Ani_body());
			pstmt.setString (8, aAdopt_AniVO.getAdopt_Ani_age());
			pstmt.setString (9, aAdopt_AniVO.getAdopt_Ani_Neu());
			pstmt.setString (10, aAdopt_AniVO.getAdopt_Ani_chip());
			pstmt.setDate (11, aAdopt_AniVO.getAdopt_Ani_date());
			pstmt.setString (12, aAdopt_AniVO.getAdopt_Ani_status());
			pstmt.setDate (13, aAdopt_AniVO.getAdopt_Ani_CreDate());
			pstmt.setDouble (14, aAdopt_AniVO.getAdopt_Ani_FinLat());
			pstmt.setDouble (15, aAdopt_AniVO.getAdopt_Ani_FinLon());
			pstmt.setString (16, aAdopt_AniVO.getAdopt_Ani_city());
			pstmt.setString (17, aAdopt_AniVO.getAdopt_Ani_town());
			pstmt.setString (18, aAdopt_AniVO.getAdopt_Ani_road());
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
	public void delete(String  aAdopt_Ani){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_AniDAO.DELETE);
			pstmt.setString (1,aAdopt_Ani);
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
	public Adopt_AniVO findByPrimaryKey(String  aAdopt_Ani){
		Adopt_AniVO adopt_aniVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_AniDAO.GET_ONE_STMT);
			pstmt.setString (1,aAdopt_Ani);
			pstmt.executeUpdate();
			while (rs.next()) {
				adopt_aniVO = new Adopt_AniVO();
				adopt_aniVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adopt_aniVO.setMem_Id(rs.getString("mem_Id"));
				adopt_aniVO.setAdopt_Ani_name(rs.getString("adopt_Ani_name"));
				adopt_aniVO.setAdopt_Ani_type(rs.getString("adopt_Ani_type"));
				adopt_aniVO.setAdopt_Ani_gender(rs.getString("adopt_Ani_gender"));
				adopt_aniVO.setAdopt_Ani_heal(rs.getString("adopt_Ani_heal"));
				adopt_aniVO.setAdopt_Ani_Vac(rs.getString("adopt_Ani_Vac"));
				adopt_aniVO.setAdopt_Ani_color(rs.getString("adopt_Ani_color"));
				adopt_aniVO.setAdopt_Ani_body(rs.getString("adopt_Ani_body"));
				adopt_aniVO.setAdopt_Ani_age(rs.getString("adopt_Ani_age"));
				adopt_aniVO.setAdopt_Ani_Neu(rs.getString("adopt_Ani_Neu"));
				adopt_aniVO.setAdopt_Ani_chip(rs.getString("adopt_Ani_chip"));
				adopt_aniVO.setAdopt_Ani_date(rs.getDate("adopt_Ani_date"));
				adopt_aniVO.setAdopt_Ani_status(rs.getString("adopt_Ani_status"));
				adopt_aniVO.setAdopt_Ani_CreDate(rs.getDate("adopt_Ani_CreDate"));
				adopt_aniVO.setAdopt_Ani_FinLat(rs.getDouble("adopt_Ani_FinLat"));
				adopt_aniVO.setAdopt_Ani_FinLon(rs.getDouble("adopt_Ani_FinLon"));
				adopt_aniVO.setAdopt_Ani_city(rs.getString("adopt_Ani_city"));
				adopt_aniVO.setAdopt_Ani_town(rs.getString("adopt_Ani_town"));
				adopt_aniVO.setAdopt_Ani_road(rs.getString("adopt_Ani_road"));
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
		return adopt_aniVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Adopt_AniVO> getAll(){ 
		List<Adopt_AniVO> list = new ArrayList<Adopt_AniVO>();
		Adopt_AniVO adopt_aniVO = null;
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