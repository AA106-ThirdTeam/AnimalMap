package com.animal_index.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:動物圖鑑<br>
 *	英文:animal_index<br>
 */ 
public class Animal_indexDAO implements Animal_indexDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (animal_No,animal_detail,animal_class,animal_class_No ) VALUES  ( animal_index_seq1.nextval , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE animal_index SET animal_detail=?,animal_class=? ,animal_class_No=?  WHERE animal_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM animal_index WHERE animal_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT animal_No,animal_detail,animal_class,animal_class_No WHERE animal_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT animal_No,animal_detail,animal_class,animal_class_No WHERE animal_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ANIMAL_DETAIL =" UPDATE animal_index set ANIMAL_DETAIL=?  WHERE animal_No=? " ; 
	private static final String UPDATE_ANIMAL_CLASS =" UPDATE animal_index set ANIMAL_CLASS=?  WHERE animal_No=? " ; 
	private static final String UPDATE_ANIMAL_CLASS_NO =" UPDATE animal_index set ANIMAL_CLASS_NO=?  WHERE animal_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Animal_indexVO aAnimal_indexVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.INSERT_STMT);
			pstmt.setString (1, aAnimal_indexVO.getAnimal_detail());
			pstmt.setString (2, aAnimal_indexVO.getAnimal_class());
			pstmt.setString (3, aAnimal_indexVO.getAnimal_class_No());
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
	public void update(Animal_indexVO aAnimal_indexVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.UPDATE);
			pstmt.setString (1, aAnimal_indexVO.getAnimal_detail());
			pstmt.setString (2, aAnimal_indexVO.getAnimal_class());
			pstmt.setString (3, aAnimal_indexVO.getAnimal_class_No());
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
	public void delete(String  aAnimal_index){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.DELETE);
			pstmt.setString (1,aAnimal_index);
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
	public Animal_indexVO findByPrimaryKey(String  aAnimal_index){
	Animal_indexVO animal_indexVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.DELETE);
			pstmt.setString (1,aAnimal_index);
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
		return animal_indexVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Animal_indexVO> getAll(){ 
		List<Animal_indexVO> list = new ArrayList<Animal_indexVO>();
		Animal_indexVO animal_indexVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Animal_indexDAO.DELETE);
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