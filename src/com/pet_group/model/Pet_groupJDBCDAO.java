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
public class Pet_groupJDBCDAO implements Pet_groupDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO pet_group (grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,grp_StartTime,grp_EndTime,grp_Desc,grp_Long,grp_Lat,grp_CreateTime,grp_visible,grp_photo ) VALUES  ( pet_group_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet_group SET grp_name=?,grp_city=? ,grp_Addr=? ,grp_road=? ,grp_StartTime=? ,grp_EndTime=? ,grp_Desc=? ,grp_Long=? ,grp_Lat=? ,grp_CreateTime=? ,grp_visible=? ,grp_photo=?  WHERE grp_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet_group WHERE grp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,to_char(grp_StartTime,'yyyy-mm-dd') grp_StartTime,to_char(grp_EndTime,'yyyy-mm-dd') grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo WHERE grp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT grp_Id,grp_MemId,grp_name,grp_city,grp_Addr,grp_road,to_char(grp_StartTime,'yyyy-mm-dd') grp_StartTime,to_char(grp_EndTime,'yyyy-mm-dd') grp_EndTime,grp_Desc,grp_Long,grp_Lat,to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime,grp_visible,grp_photo WHERE grp_Id=? " ; 
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
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_groupDAO.GET_ONE_STMT);
			pstmt.setString (1,aPet_group);
			pstmt.executeUpdate();
			while (rs.next()) {
				pet_groupVO = new Pet_groupVO();
				pet_groupVO.setGrp_Id(rs.getString("grp_Id"));
				pet_groupVO.setGrp_MemId(rs.getString("grp_MemId"));
				pet_groupVO.setGrp_name(rs.getString("grp_name"));
				pet_groupVO.setGrp_city(rs.getString("grp_city"));
				pet_groupVO.setGrp_Addr(rs.getString("grp_Addr"));
				pet_groupVO.setGrp_road(rs.getString("grp_road"));
				pet_groupVO.setGrp_StartTime(rs.getDate("grp_StartTime"));
				pet_groupVO.setGrp_EndTime(rs.getDate("grp_EndTime"));
				pet_groupVO.setGrp_Desc(rs.getString("grp_Desc"));
				pet_groupVO.setGrp_Long(rs.getDouble("grp_Long"));
				pet_groupVO.setGrp_Lat(rs.getDouble("grp_Lat"));
				pet_groupVO.setGrp_CreateTime(rs.getDate("grp_CreateTime"));
				pet_groupVO.setGrp_visible(rs.getString("grp_visible"));
				pet_groupVO.setGrp_photo(rs.getBytes("grp_photo"));
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
		return pet_groupVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Pet_groupVO> getAll(){ 
		List<Pet_groupVO> list = new ArrayList<Pet_groupVO>();
		Pet_groupVO pet_groupVO = null;
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