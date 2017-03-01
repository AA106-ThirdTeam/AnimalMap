package com.emp.model;

import java.sql.*;
import java.util.*;
import java.io.*;

public class EmpJDBCDAO implements EmpDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106";
	String passwd = "aa106";

	private static final String INSERT_STMT = "INSERT INTO emp (emp_No,emp_name,emp_Pw,emp_email,emp_Id,emp_birthday,emp_phone,emp_address,emp_status,emp_picture,emp_Pic_format,emp_hiredate,emp_firedate) VALUES (employee_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, null, null, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT emp_No,emp_name,emp_Pw,emp_email,emp_Id,to_char(emp_birthday,'yyyy-mm-dd') emp_birthday,emp_phone,emp_address,emp_status,to_char(emp_hiredate,'yyyy-mm-dd') emp_hiredate,to_char(emp_firedate,'yyyy-mm-dd') emp_firedate from emp order by emp_No";
	private static final String GET_ONE_STMT = "SELECT emp_No,emp_name,emp_Pw,emp_email,emp_Id,to_char(emp_birthday,'yyyy-mm-dd') emp_birthday,emp_phone,emp_address,emp_status,to_char(emp_hiredate,'yyyy-mm-dd') emp_hiredate,to_char(emp_firedate,'yyyy-mm-dd') emp_firedate from emp where emp_No = ?";
	private static final String DELETE = "DELETE FROM emp where emp_No = ?";
	private static final String UPDATE = "UPDATE emp set emp_name=?,emp_Pw=?,emp_email=?,emp_Id=?,emp_birthday=?,emp_phone=?,emp_address=?,emp_status=?,emp_hiredate=?,emp_firedate=? where emp_No = ?";
	private static final String GET_USER_LOGIN = "Select emp_No,emp_name,emp_email,emp_Pw from emp where emp_email=? and emp_Pw=? ";

	@Override
	public void insert(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, empVO.getEmp_name());
			pstmt.setString(2, empVO.getEmp_Pw());
			pstmt.setString(3, empVO.getEmp_email());
			pstmt.setString(4, empVO.getEmp_Id());
			pstmt.setDate(5, empVO.getEmp_birthday());
			pstmt.setString(6, empVO.getEmp_phone());
			pstmt.setString(7, empVO.getEmp_address());
			pstmt.setString(8, empVO.getEmp_status());
			pstmt.setDate(9, empVO.getEmp_hiredate());
			pstmt.setDate(10, empVO.getEmp_firedate());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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
	public void update(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, empVO.getEmp_name());
			pstmt.setString(2, empVO.getEmp_Pw());
			pstmt.setString(3, empVO.getEmp_email());
			pstmt.setString(4, empVO.getEmp_Id());
			pstmt.setDate(5, empVO.getEmp_birthday());
			pstmt.setString(6, empVO.getEmp_phone());
			pstmt.setString(7, empVO.getEmp_address());
			pstmt.setString(8, empVO.getEmp_status());
			pstmt.setDate(9, empVO.getEmp_hiredate());
			pstmt.setDate(10, empVO.getEmp_firedate());
			pstmt.setString(11, empVO.getEmp_No());

			pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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
	public void delete(String emp_No) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_No);

			pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public EmpVO findByPrimaryKey(String emp_No) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, emp_No);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				empVO = new EmpVO();
				empVO.setEmp_No(rs.getString("emp_No"));
				empVO.setEmp_name(rs.getString("emp_Name"));
				empVO.setEmp_Pw(rs.getString("emp_Pw"));
				empVO.setEmp_email(rs.getString("emp_email"));
				empVO.setEmp_Id(rs.getString("emp_Id"));
				empVO.setEmp_birthday(rs.getDate("emp_birthday"));
				empVO.setEmp_phone(rs.getString("emp_phone"));
				empVO.setEmp_address(rs.getString("emp_address"));
				empVO.setEmp_status(rs.getString("emp_status"));
				empVO.setEmp_hiredate(rs.getDate("emp_hiredate"));
				empVO.setEmp_firedate(rs.getDate("emp_firedate"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	

	@Override
	public EmpVO findUserLogin(String emp_email, String emp_Pw) {
		// TODO Auto-generated method stub
		
		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_USER_LOGIN);

			pstmt.setString(1, emp_email);
			pstmt.setString(2, emp_Pw);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				empVO = new EmpVO();
				
				empVO.setEmp_No(rs.getString("emp_No"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_Pw(rs.getString("emp_Pw"));
				empVO.setEmp_email(rs.getString("emp_email"));
				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	
	
	

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				empVO = new EmpVO();
				empVO.setEmp_No(rs.getString("emp_No"));
				empVO.setEmp_name(rs.getString("emp_Name"));
				empVO.setEmp_Pw(rs.getString("emp_Pw"));
				empVO.setEmp_email(rs.getString("emp_email"));
				empVO.setEmp_Id(rs.getString("emp_Id"));
				empVO.setEmp_birthday(rs.getDate("emp_birthday"));
				empVO.setEmp_phone(rs.getString("emp_phone"));
				empVO.setEmp_address(rs.getString("emp_address"));
				empVO.setEmp_status(rs.getString("emp_status"));
				empVO.setEmp_hiredate(rs.getDate("emp_hiredate"));
				empVO.setEmp_firedate(rs.getDate("emp_firedate"));
				list.add(empVO);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public static void main(String[] args) throws IOException {

		EmpJDBCDAO dao = new EmpJDBCDAO();

		// insert
//		 EmpVO empVO1 = new EmpVO();
//		 empVO1.setEmp_name("aaaa");
//		 empVO1.setEmp_Pw("123123");
//		 empVO1.setEmp_email("aa106_01@iii.com");
//		 empVO1.setEmp_Id("C1600500");
//		 empVO1.setEmp_birthday(java.sql.Date.valueOf("2000-01-01"));
//		 empVO1.setEmp_phone("0933123123");
//		 empVO1.setEmp_address("台北市");
//		 empVO1.setEmp_status("1");
//		 empVO1.setEmp_hiredate(java.sql.Date.valueOf("2016-09-20"));
//		 empVO1.setEmp_firedate(java.sql.Date.valueOf("2017-03-10"));
//		 dao.insert(empVO1);

		// update
//		 EmpVO empVO2=new EmpVO();
//		 empVO2.setEmp_name("123456");
//		 empVO2.setEmp_Pw("123123");
//		 empVO2.setEmp_email("aa106_01@iii.com");
//		 empVO2.setEmp_Id("C1600500");
//		 empVO2.setEmp_birthday(java.sql.Date.valueOf("2000-01-01"));
//		 empVO2.setEmp_phone("0933123123");
//		 empVO2.setEmp_address("台北市");
//		 empVO2.setEmp_status("1");
//		 empVO2.setEmp_hiredate(java.sql.Date.valueOf("2016-09-20"));
//		 empVO2.setEmp_firedate(java.sql.Date.valueOf("2017-03-10"));
//		 empVO2.setEmp_No("10006");
//		 dao.update(empVO2);

		// delete
		// dao.delete("10006");

		//findUserLogin data
		EmpVO empVO4=dao.findUserLogin("aa106_20@iii.com", "aa106");
		System.out.println(empVO4.getEmp_No());
		System.out.println(empVO4.getEmp_name());
		System.out.println(empVO4.getEmp_email());
		System.out.println(empVO4.getEmp_Pw());
		System.out.println("---------------------------");
		
		
		// select one
//		EmpVO empVO3 = dao.findByPrimaryKey("10002");
//		System.out.print(empVO3.getEmp_No() + ",");
//		System.out.print(empVO3.getEmp_name() + ",");
//		System.out.print(empVO3.getEmp_Pw() + ",");
//		System.out.print(empVO3.getEmp_email() + ",");
//		System.out.print(empVO3.getEmp_Id() + ",");
//		System.out.print(empVO3.getEmp_birthday() + ",");
//		System.out.print(empVO3.getEmp_phone() + ",");
//		System.out.print(empVO3.getEmp_address() + ",");
//		System.out.print(empVO3.getEmp_status() + ",");
//		System.out.print(empVO3.getEmp_hiredate() + ",");
//		System.out.println(empVO3.getEmp_firedate() + ",");
//		System.out.println("---------------------------");
		

		// select all
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmp_No() + ",");
//			System.out.print(aEmp.getEmp_name() + ",");
//			System.out.print(aEmp.getEmp_Pw() + ",");
//			System.out.print(aEmp.getEmp_email() + ",");
//			System.out.print(aEmp.getEmp_Id() + ",");
//			System.out.print(aEmp.getEmp_birthday() + ",");
//			System.out.print(aEmp.getEmp_phone() + ",");
//			System.out.print(aEmp.getEmp_address() + ",");
//			System.out.print(aEmp.getEmp_status() + ",");
//			System.out.print(aEmp.getEmp_hiredate() + ",");
//			System.out.print(aEmp.getEmp_firedate());
//			System.out.println();
//		}

	}


	
}
