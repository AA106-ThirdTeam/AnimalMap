package com.charge.model;

import java.util.*;
import java.sql.*;

public class ChargeJDBCDAO implements ChargeDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "bertha";
	String passwd = "109910622";
	
	private static final String INSERT_STMT =
			"INSERT INTO charge(charge_no,mem_id,charge_number,pay,applytime) VALUES (charge_seq1.NEXTVAL,?,?,?,?)";
		
	private static final String UPDATE =
			"UPDATE charge set mem_id= ?,charge_number= ?,pay= ?,applytime= ? where charge_no =?";
	
	private static final String DELETE = 
			"DELETE FROM charge where charge_no=?";
	
	private static final String GET_ALL_STMT =
			"SELECT charge_no,mem_Id,charge_number,pay,to_char(applytime,'yyyy-mm-dd') applytime FROM charge order by charge_no";
	
	private static final String GET_ONE_STMT =
			"SELECT charge_no,mem_Id,charge_number,pay,to_char(applytime,'yyyy-mm-dd') applytime FROM charge where charge_no = ?";
	
	@Override
 	public void insert(ChargeVO chargeVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, chargeVO.getMem_Id());
			pstmt.setInt(2, chargeVO.getCharge_number());
			pstmt.setInt(3, chargeVO.getPay());
			pstmt.setDate(4, chargeVO.getApplytime());
			
			pstmt.executeUpdate();
			
			
		}  catch (ClassNotFoundException e){
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se){
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
			if (pstmt != null) {
				try{
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null){
				try{
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(ChargeVO chargeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, chargeVO.getMem_Id());
			pstmt.setInt(2, chargeVO.getCharge_number());
			pstmt.setInt(3, chargeVO.getPay());
			pstmt.setDate(4, chargeVO.getApplytime());
			pstmt.setString(5, chargeVO.getCharge_no());
			pstmt.executeUpdate();
			
		}  catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

	@Override
	public void delete(String charge_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, charge_no);
			pstmt.executeUpdate();
			
		}  catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

	@Override
	public ChargeVO findByPrimaryKey(String charge_no) {
		
		ChargeVO chargeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, charge_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				chargeVO = new ChargeVO();
				chargeVO.setCharge_no(rs.getString("charge_no"));
				chargeVO.setMem_id(rs.getString("mem_id"));
				chargeVO.setCharge_number(rs.getInt("charge_number"));
				chargeVO.setPay(rs.getInt("pay"));
				chargeVO.setApplytime(rs.getDate("applytime"));
			}
			
		}  catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
		return chargeVO;
	}

	@Override
	public List<ChargeVO> getAll() {
		List<ChargeVO> list = new ArrayList<ChargeVO>();
		ChargeVO chargeVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			
			chargeVO = new ChargeVO();
			chargeVO.setCharge_no(rs.getString("charge_no"));
			chargeVO.setMem_id(rs.getString("mem_Id"));
			chargeVO.setCharge_number(rs.getInt("charge_number"));
			chargeVO.setPay(rs.getInt("pay"));
			chargeVO.setApplytime(rs.getDate("applytime"));
			list.add(chargeVO);
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
		return list;
	}

	@Override
	public List<ChargeVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String args[]){
		
		ChargeJDBCDAO dao = new ChargeJDBCDAO();
		
//Insert~~~~~~
		ChargeVO chargeVO1 = new ChargeVO();
		chargeVO1.setMem_id("7002");
		chargeVO1.setCharge_number(1200);
		chargeVO1.setPay(1);
		chargeVO1.setApplytime(java.sql.Date.valueOf("2017-01-01"));
		dao.insert(chargeVO1);
		System.out.println("~~~~~~~Insert_RUN~~~~~~~~~~");
		
//Update~~~~~~
//		ChargeVO chargeVO2 = new ChargeVO();
//		chargeVO2.setCharge_no("5");
//		chargeVO2.setMem_id("7002");
//		chargeVO2.setCharge_number(1200);
//		chargeVO2.setPay(2);
//		chargeVO2.setApplytime(java.sql.Date.valueOf("2017-01-02"));
//		dao.update(chargeVO2);
//		System.out.println("~~~~~~~Update_RUN~~~~~~~~~~");		

//Delete~~~~~~
//		dao.delete("5");
//		System.out.println("~~~~~~~Delete_RUN~~~~~~~~~~");
	
//查詢
//	ChargeVO chargeVO2 = dao.findByPrimaryKey("101");
//	System.out.print(chargeVO2.getCharge_no() + ",");
//	System.out.print(chargeVO2.getMem_Id() + ",");
//	System.out.print(chargeVO2.getCharge_number() + ",");
//	System.out.print(chargeVO2.getPay() + ",");
//	System.out.print(chargeVO2.getApplytime() + ",");
//	System.out.println("---------------------");
	
//查全部
//	List<ChargeVO> list = dao.getAll();
//	for (ChargeVO chargeVO4 : list) {
//		System.out.print(chargeVO4.getCharge_no() + ",");
//		System.out.print(chargeVO4.getMem_Id() + ",");
//		System.out.print(chargeVO4.getCharge_number() + ",");
//		System.out.print(chargeVO4.getPay() + ",");
//		System.out.print(chargeVO4.getApplytime());
//		System.out.println();
//	}
	}
	@Override
	public Set<ChargeVO> getChargesByMem_Id(String mem_Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
