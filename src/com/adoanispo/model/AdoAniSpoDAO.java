package com.adoanispo.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:送養動物領養人<br>
 *	英文:adoAniSpo<br>
 */ 
public class AdoAniSpoDAO implements AdoAniSpoDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat ) VALUES  ( adoAniSpo_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adoAniSpo SET adoAniSpoMoney=?,adoAniSpoMat=?  WHERE adoAniSpoNo=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adoAniSpo WHERE adoAniSpoNo=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat WHERE adoAniSpoNo=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT adoAniSpoNo,adoAniSpoAniId,adoAniSpomem_Id,adoAniSpoMoney,adoAniSpoMat WHERE adoAniSpoNo=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADOANISPOMONEY =" UPDATE adoAniSpo set ADOANISPOMONEY=?  WHERE adoAniSpoNo=? " ; 
	private static final String UPDATE_ADOANISPOMAT =" UPDATE adoAniSpo set ADOANISPOMAT=?  WHERE adoAniSpoNo=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AdoAniSpoVO aAdoAniSpoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.INSERT_STMT);
			pstmt.setString (1, aAdoAniSpoVO.getAdoAniSpoAniId());
			pstmt.setString (2, aAdoAniSpoVO.getAdoAniSpomem_Id());
			pstmt.setInt (3, aAdoAniSpoVO.getAdoAniSpoMoney());
			pstmt.setString (4, aAdoAniSpoVO.getAdoAniSpoMat());
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
	public void update(AdoAniSpoVO aAdoAniSpoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.UPDATE);
			pstmt.setInt (1, aAdoAniSpoVO.getAdoAniSpoMoney());
			pstmt.setString (2, aAdoAniSpoVO.getAdoAniSpoMat());
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
	public void delete(String  aAdoAniSpo){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.DELETE);
			pstmt.setString (1,aAdoAniSpo);
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
	public AdoAniSpoVO findByPrimaryKey(String  aAdoAniSpo){
	AdoAniSpoVO adoanispoVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.DELETE);
			pstmt.setString (1,aAdoAniSpo);
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
		return adoanispoVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<AdoAniSpoVO> getAll(){ 
		List<AdoAniSpoVO> list = new ArrayList<AdoAniSpoVO>();
		AdoAniSpoVO adoanispoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdoAniSpoDAO.DELETE);
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