package com.pet_group.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:揪團<br>
 *	英文:pet_group<br>
 */ 
public class Pet_groupDAO implements Pet_groupDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,grp_StartTime,grp_EndTime,grp_Desc,grp_Long,grp_Lat,grp_CreateTime,grp_visible,grp_photo ) VALUES  ( pet_group_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet_group SET grp_name=?,grp_city=? ,grp_Addr=? ,grp_road=? ,grp_StartTime=? ,grp_EndTime=? ,grp_Desc=? ,grp_Long=? ,grp_Lat=? ,grp_CreateTime=? ,grp_visible=? ,grp_photo=?  WHERE grp_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet_group WHERE grp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,to_char(grp_StartTime,'yyyy-mm-dd') grp_StartTime,to_char(grp_EndTime,'yyyy-mm-dd') grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo WHERE grp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,to_char(grp_StartTime,'yyyy-mm-dd') grp_StartTime,to_char(grp_EndTime,'yyyy-mm-dd') grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo WHERE grp_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_GRP_NAME =" UPDATE pet_group set GRP_NAME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_CITY =" UPDATE pet_group set GRP_CITY=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_ADDR =" UPDATE pet_group set GRP_ADDR=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_ROAD =" UPDATE pet_group set GRP_ROAD=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_STARTTIME =" UPDATE pet_group set GRP_STARTTIME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_ENDTIME =" UPDATE pet_group set GRP_ENDTIME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_DESC =" UPDATE pet_group set GRP_DESC=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_LONG =" UPDATE pet_group set GRP_LONG=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_LAT =" UPDATE pet_group set GRP_LAT=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_CREATETIME =" UPDATE pet_group set GRP_CREATETIME=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_VISIBLE =" UPDATE pet_group set GRP_VISIBLE=?  WHERE grp_Id=? " ; 
	private static final String UPDATE_GRP_PHOTO =" UPDATE pet_group set GRP_PHOTO=?  WHERE grp_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Pet_groupVO aPet_groupVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.INSERT_STMT);
			pstmt.setString (1, aPet_groupVO.getGrp_MemId());
			pstmt.setString (2, aPet_groupVO.getGrp_name());
			pstmt.setString (3, aPet_groupVO.getGrp_city());
			pstmt.setString (4, aPet_groupVO.getGrp_Addr());
			pstmt.setString (5, aPet_groupVO.getGrp_road());
			pstmt.setDate (6, aPet_groupVO.getGrp_StartTime());
			pstmt.setDate (7, aPet_groupVO.getGrp_EndTime());
			pstmt.setString (8, aPet_groupVO.getGrp_Desc());
			pstmt.setDouble (9, aPet_groupVO.getGrp_Long());
			pstmt.setDouble (10, aPet_groupVO.getGrp_Lat());
			pstmt.setDate (11, aPet_groupVO.getGrp_CreateTime());
			pstmt.setString (12, aPet_groupVO.getGrp_visible());
			pstmt.setBytes (13, aPet_groupVO.getGrp_photo());
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
	public void update(Pet_groupVO aPet_groupVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.UPDATE);
			pstmt.setString (1, aPet_groupVO.getGrp_name());
			pstmt.setString (2, aPet_groupVO.getGrp_city());
			pstmt.setString (3, aPet_groupVO.getGrp_Addr());
			pstmt.setString (4, aPet_groupVO.getGrp_road());
			pstmt.setDate (5, aPet_groupVO.getGrp_StartTime());
			pstmt.setDate (6, aPet_groupVO.getGrp_EndTime());
			pstmt.setString (7, aPet_groupVO.getGrp_Desc());
			pstmt.setDouble (8, aPet_groupVO.getGrp_Long());
			pstmt.setDouble (9, aPet_groupVO.getGrp_Lat());
			pstmt.setDate (10, aPet_groupVO.getGrp_CreateTime());
			pstmt.setString (11, aPet_groupVO.getGrp_visible());
			pstmt.setBytes (12, aPet_groupVO.getGrp_photo());
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
	public void delete(String  aPet_group){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.DELETE);
			pstmt.setString (1,aPet_group);
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
	public Pet_groupVO findByPrimaryKey(String  aPet_group){
	Pet_groupVO pet_groupVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.DELETE);
			pstmt.setString (1,aPet_group);
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
		return pet_groupVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Pet_groupVO> getAll(){ 
		List<Pet_groupVO> list = new ArrayList<Pet_groupVO>();
		Pet_groupVO pet_groupVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.DELETE);
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
		return list;	} 
}