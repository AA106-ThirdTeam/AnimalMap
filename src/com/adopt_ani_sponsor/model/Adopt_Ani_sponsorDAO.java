package com.adopt_ani_sponsor.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:送養動物贊助<br>
 *	英文:adopt_Ani_sponsor<br>
 */ 
public class Adopt_Ani_sponsorDAO implements Adopt_Ani_sponsorDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (ado_Ani_Spo_No,adopt_Ani_Id,mem_Id,ado_Ani_Spo_money,adoAniSpoMat ) VALUES  ( adopt_Ani_sponsor_seq1.nextval , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adopt_Ani_sponsor SET ado_Ani_Spo_money=?,adoAniSpoMat=?  WHERE ado_Ani_Spo_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adopt_Ani_sponsor WHERE ado_Ani_Spo_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT ado_Ani_Spo_No,adopt_Ani_Id,mem_Id,ado_Ani_Spo_money,adoAniSpoMat WHERE ado_Ani_Spo_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT ado_Ani_Spo_No,adopt_Ani_Id,mem_Id,ado_Ani_Spo_money,adoAniSpoMat WHERE ado_Ani_Spo_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADO_ANI_SPO_MONEY =" UPDATE adopt_Ani_sponsor set ADO_ANI_SPO_MONEY=?  WHERE ado_Ani_Spo_No=? " ; 
	private static final String UPDATE_ADOANISPOMAT =" UPDATE adopt_Ani_sponsor set ADOANISPOMAT=?  WHERE ado_Ani_Spo_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Adopt_Ani_sponsorVO aAdopt_Ani_sponsorVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_sponsorDAO.INSERT_STMT);
			pstmt.setString (1, aAdopt_Ani_sponsorVO.getAdopt_Ani_Id());
			pstmt.setString (2, aAdopt_Ani_sponsorVO.getMem_Id());
			pstmt.setInt (3, aAdopt_Ani_sponsorVO.getAdo_Ani_Spo_money());
			pstmt.setString (4, aAdopt_Ani_sponsorVO.getAdoAniSpoMat());
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
	public void update(Adopt_Ani_sponsorVO aAdopt_Ani_sponsorVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_sponsorDAO.UPDATE);
			pstmt.setInt (1, aAdopt_Ani_sponsorVO.getAdo_Ani_Spo_money());
			pstmt.setString (2, aAdopt_Ani_sponsorVO.getAdoAniSpoMat());
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
	public void delete(String  aAdopt_Ani_sponsor){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_sponsorDAO.DELETE);
			pstmt.setString (1,aAdopt_Ani_sponsor);
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
	public Adopt_Ani_sponsorVO findByPrimaryKey(String  aAdopt_Ani_sponsor){
		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_sponsorDAO.GET_ONE_STMT);
			pstmt.setString (1,aAdopt_Ani_sponsor);
			pstmt.executeUpdate();
			while (rs.next()) {
				adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
				adopt_ani_sponsorVO.setAdo_Ani_Spo_No(rs.getString("ado_Ani_Spo_No"));
				adopt_ani_sponsorVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adopt_ani_sponsorVO.setMem_Id(rs.getString("mem_Id"));
				adopt_ani_sponsorVO.setAdo_Ani_Spo_money(rs.getInt("ado_Ani_Spo_money"));
				adopt_ani_sponsorVO.setAdoAniSpoMat(rs.getString("adoAniSpoMat"));
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
		return adopt_ani_sponsorVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Adopt_Ani_sponsorVO> getAll(){ 
		List<Adopt_Ani_sponsorVO> list = new ArrayList<Adopt_Ani_sponsorVO>();
		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = null;
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