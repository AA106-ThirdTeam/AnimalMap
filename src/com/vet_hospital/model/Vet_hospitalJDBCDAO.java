package com.vet_hospital.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:診所<br>
 *	英文:vet_hospital<br>
 */ 
public class Vet_hospitalJDBCDAO implements Vet_hospitalDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO vet_hospital (hos_Id,mem_Id,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,hos_StartTime,hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,hos_CreateTime,hos_visible ) VALUES  ( vet_hospital_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE vet_hospital SET hos_name=?,hos_city=? ,hos_town=? ,hos_road=? ,hos_Eval=? ,hos_URL=? ,hos_StartTime=? ,hos_EndTime=? ,hos_Tel=? ,hos_Desc=? ,hos_Long=? ,hos_Lat=? ,hos_CreateTime=? ,hos_visible=?  WHERE hos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM vet_hospital WHERE hos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT hos_Id,mem_Id,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,to_char(hos_StartTime,'yyyy-mm-dd') hos_StartTime,to_char(hos_EndTime,'yyyy-mm-dd') hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime,hos_visible WHERE hos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT hos_Id,mem_Id,hos_name,hos_city,hos_town,hos_road,hos_Eval,hos_URL,to_char(hos_StartTime,'yyyy-mm-dd') hos_StartTime,to_char(hos_EndTime,'yyyy-mm-dd') hos_EndTime,hos_Tel,hos_Desc,hos_Long,hos_Lat,to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime,hos_visible WHERE hos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Vet_hospitalVO aVet_hospitalVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.INSERT_STMT);
			pstmt.setString (1, aVet_hospitalVO.getMem_Id());
			pstmt.setString (2, aVet_hospitalVO.getHos_name());
			pstmt.setString (3, aVet_hospitalVO.getHos_city());
			pstmt.setString (4, aVet_hospitalVO.getHos_town());
			pstmt.setString (5, aVet_hospitalVO.getHos_road());
			pstmt.setInt (6, aVet_hospitalVO.getHos_Eval());
			pstmt.setString (7, aVet_hospitalVO.getHos_URL());
			pstmt.setDate (8, aVet_hospitalVO.getHos_StartTime());
			pstmt.setDate (9, aVet_hospitalVO.getHos_EndTime());
			pstmt.setString (10, aVet_hospitalVO.getHos_Tel());
			pstmt.setString (11, aVet_hospitalVO.getHos_Desc());
			pstmt.setDouble (12, aVet_hospitalVO.getHos_Long());
			pstmt.setDouble (13, aVet_hospitalVO.getHos_Lat());
			pstmt.setDate (14, aVet_hospitalVO.getHos_CreateTime());
			pstmt.setString (15, aVet_hospitalVO.getHos_visible());
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
	public void update(Vet_hospitalVO aVet_hospitalVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.UPDATE);
			pstmt.setString (1, aVet_hospitalVO.getHos_name());
			pstmt.setString (2, aVet_hospitalVO.getHos_city());
			pstmt.setString (3, aVet_hospitalVO.getHos_town());
			pstmt.setString (4, aVet_hospitalVO.getHos_road());
			pstmt.setInt (5, aVet_hospitalVO.getHos_Eval());
			pstmt.setString (6, aVet_hospitalVO.getHos_URL());
			pstmt.setDate (7, aVet_hospitalVO.getHos_StartTime());
			pstmt.setDate (8, aVet_hospitalVO.getHos_EndTime());
			pstmt.setString (9, aVet_hospitalVO.getHos_Tel());
			pstmt.setString (10, aVet_hospitalVO.getHos_Desc());
			pstmt.setDouble (11, aVet_hospitalVO.getHos_Long());
			pstmt.setDouble (12, aVet_hospitalVO.getHos_Lat());
			pstmt.setDate (13, aVet_hospitalVO.getHos_CreateTime());
			pstmt.setString (14, aVet_hospitalVO.getHos_visible());
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
	public void delete(String  aVet_hospital){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.DELETE);
			pstmt.setString (1,aVet_hospital);
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
	public Vet_hospitalVO findByPrimaryKey(String  aVet_hospital){
		Vet_hospitalVO vet_hospitalVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Vet_hospitalDAO.GET_ONE_STMT);
			pstmt.setString (1,aVet_hospital);
			pstmt.executeUpdate();
			while (rs.next()) {
				vet_hospitalVO = new Vet_hospitalVO();
				vet_hospitalVO.setHos_Id(rs.getString("hos_Id"));
				vet_hospitalVO.setMem_Id(rs.getString("mem_Id"));
				vet_hospitalVO.setHos_name(rs.getString("hos_name"));
				vet_hospitalVO.setHos_city(rs.getString("hos_city"));
				vet_hospitalVO.setHos_town(rs.getString("hos_town"));
				vet_hospitalVO.setHos_road(rs.getString("hos_road"));
				vet_hospitalVO.setHos_Eval(rs.getInt("hos_Eval"));
				vet_hospitalVO.setHos_URL(rs.getString("hos_URL"));
				vet_hospitalVO.setHos_StartTime(rs.getDate("hos_StartTime"));
				vet_hospitalVO.setHos_EndTime(rs.getDate("hos_EndTime"));
				vet_hospitalVO.setHos_Tel(rs.getString("hos_Tel"));
				vet_hospitalVO.setHos_Desc(rs.getString("hos_Desc"));
				vet_hospitalVO.setHos_Long(rs.getDouble("hos_Long"));
				vet_hospitalVO.setHos_Lat(rs.getDouble("hos_Lat"));
				vet_hospitalVO.setHos_CreateTime(rs.getDate("hos_CreateTime"));
				vet_hospitalVO.setHos_visible(rs.getString("hos_visible"));
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
		return vet_hospitalVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Vet_hospitalVO> getAll(){ 
		List<Vet_hospitalVO> list = new ArrayList<Vet_hospitalVO>();
		Vet_hospitalVO vet_hospitalVO = null;
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