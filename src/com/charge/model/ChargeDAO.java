package com.charge.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:儲值<br>
 *	英文:charge<br>
 */ 
public class ChargeDAO implements ChargeDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (charge_no,mem_Id,charge_NUMBER,pay,applytime ) VALUES  ( charge_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE charge SET charge_NUMBER=?,pay=? ,applytime=?  WHERE charge_no=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM charge WHERE charge_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT charge_no,mem_Id,charge_NUMBER,pay,to_char(applytime,'yyyy-mm-dd') applytime WHERE charge_no=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT charge_no,mem_Id,charge_NUMBER,pay,to_char(applytime,'yyyy-mm-dd') applytime WHERE charge_no=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_CHARGE_NUMBER =" UPDATE charge set CHARGE_NUMBER=?  WHERE charge_no=? " ; 
	private static final String UPDATE_PAY =" UPDATE charge set PAY=?  WHERE charge_no=? " ; 
	private static final String UPDATE_APPLYTIME =" UPDATE charge set APPLYTIME=?  WHERE charge_no=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(ChargeVO aChargeVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ChargeDAO.INSERT_STMT);
			pstmt.setString (1, aChargeVO.getMem_Id());
			pstmt.setInt (2, aChargeVO.getCharge_NUMBER());
			pstmt.setInt (3, aChargeVO.getPay());
			pstmt.setDate (4, aChargeVO.getApplytime());
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
	public void update(ChargeVO aChargeVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ChargeDAO.UPDATE);
			pstmt.setInt (1, aChargeVO.getCharge_NUMBER());
			pstmt.setInt (2, aChargeVO.getPay());
			pstmt.setDate (3, aChargeVO.getApplytime());
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
	public void delete(String  aCharge){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ChargeDAO.DELETE);
			pstmt.setString (1,aCharge);
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
	public ChargeVO findByPrimaryKey(String  aCharge){
	ChargeVO chargeVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ChargeDAO.DELETE);
			pstmt.setString (1,aCharge);
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
		return chargeVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<ChargeVO> getAll(){ 
		List<ChargeVO> list = new ArrayList<ChargeVO>();
		ChargeVO chargeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ChargeDAO.DELETE);
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