package com.emp.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:員工<br>
 *	英文:emp<br>
 */ 
public class EmpDAO implements EmpDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (emp_No,emp_name,emp_Pw,emp_email,emp_Id,emp_birthday,emp_phone,emp_address,emp_status,emp_picture,emp_Pic_format,emp_hiredate,emp_firedate ) VALUES  ( emp_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE emp SET emp_name=?,emp_Pw=? ,emp_email=? ,emp_Id=? ,emp_birthday=? ,emp_phone=? ,emp_address=? ,emp_status=? ,emp_picture=? ,emp_Pic_format=? ,emp_hiredate=? ,emp_firedate=?  WHERE emp_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM emp WHERE emp_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT emp_No,emp_name,emp_Pw,emp_email,emp_Id,to_char(emp_birthday,'yyyy-mm-dd') emp_birthday,emp_phone,emp_address,emp_status,emp_picture,emp_Pic_format,to_char(emp_hiredate,'yyyy-mm-dd') emp_hiredate,to_char(emp_firedate,'yyyy-mm-dd') emp_firedate WHERE emp_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT emp_No,emp_name,emp_Pw,emp_email,emp_Id,to_char(emp_birthday,'yyyy-mm-dd') emp_birthday,emp_phone,emp_address,emp_status,emp_picture,emp_Pic_format,to_char(emp_hiredate,'yyyy-mm-dd') emp_hiredate,to_char(emp_firedate,'yyyy-mm-dd') emp_firedate WHERE emp_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_EMP_NAME =" UPDATE emp set EMP_NAME=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_PW =" UPDATE emp set EMP_PW=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_EMAIL =" UPDATE emp set EMP_EMAIL=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_ID =" UPDATE emp set EMP_ID=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_BIRTHDAY =" UPDATE emp set EMP_BIRTHDAY=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_PHONE =" UPDATE emp set EMP_PHONE=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_ADDRESS =" UPDATE emp set EMP_ADDRESS=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_STATUS =" UPDATE emp set EMP_STATUS=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_PICTURE =" UPDATE emp set EMP_PICTURE=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_PIC_FORMAT =" UPDATE emp set EMP_PIC_FORMAT=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_HIREDATE =" UPDATE emp set EMP_HIREDATE=?  WHERE emp_No=? " ; 
	private static final String UPDATE_EMP_FIREDATE =" UPDATE emp set EMP_FIREDATE=?  WHERE emp_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(EmpVO aEmpVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(EmpDAO.INSERT_STMT);
			pstmt.setString (1, aEmpVO.getEmp_name());
			pstmt.setString (2, aEmpVO.getEmp_Pw());
			pstmt.setString (3, aEmpVO.getEmp_email());
			pstmt.setString (4, aEmpVO.getEmp_Id());
			pstmt.setDate (5, aEmpVO.getEmp_birthday());
			pstmt.setString (6, aEmpVO.getEmp_phone());
			pstmt.setString (7, aEmpVO.getEmp_address());
			pstmt.setString (8, aEmpVO.getEmp_status());
			pstmt.setBytes (9, aEmpVO.getEmp_picture());
			pstmt.setString (10, aEmpVO.getEmp_Pic_format());
			pstmt.setDate (11, aEmpVO.getEmp_hiredate());
			pstmt.setDate (12, aEmpVO.getEmp_firedate());
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
	public void update(EmpVO aEmpVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(EmpDAO.UPDATE);
			pstmt.setString (1, aEmpVO.getEmp_name());
			pstmt.setString (2, aEmpVO.getEmp_Pw());
			pstmt.setString (3, aEmpVO.getEmp_email());
			pstmt.setString (4, aEmpVO.getEmp_Id());
			pstmt.setDate (5, aEmpVO.getEmp_birthday());
			pstmt.setString (6, aEmpVO.getEmp_phone());
			pstmt.setString (7, aEmpVO.getEmp_address());
			pstmt.setString (8, aEmpVO.getEmp_status());
			pstmt.setBytes (9, aEmpVO.getEmp_picture());
			pstmt.setString (10, aEmpVO.getEmp_Pic_format());
			pstmt.setDate (11, aEmpVO.getEmp_hiredate());
			pstmt.setDate (12, aEmpVO.getEmp_firedate());
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
	public void delete(String  aEmp){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(EmpDAO.DELETE);
			pstmt.setString (1,aEmp);
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
	public EmpVO findByPrimaryKey(String  aEmp){
		EmpVO empVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(EmpDAO.GET_ONE_STMT);
			pstmt.setString (1,aEmp);
			pstmt.executeUpdate();
			while (rs.next()) {
				empVO = new EmpVO();
				empVO.setEmp_No(rs.getString("emp_No"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_Pw(rs.getString("emp_Pw"));
				empVO.setEmp_email(rs.getString("emp_email"));
				empVO.setEmp_Id(rs.getString("emp_Id"));
				empVO.setEmp_birthday(rs.getDate("emp_birthday"));
				empVO.setEmp_phone(rs.getString("emp_phone"));
				empVO.setEmp_address(rs.getString("emp_address"));
				empVO.setEmp_status(rs.getString("emp_status"));
				empVO.setEmp_picture(rs.getBytes("emp_picture"));
				empVO.setEmp_Pic_format(rs.getString("emp_Pic_format"));
				empVO.setEmp_hiredate(rs.getDate("emp_hiredate"));
				empVO.setEmp_firedate(rs.getDate("emp_firedate"));
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
		return empVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<EmpVO> getAll(){ 
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;
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