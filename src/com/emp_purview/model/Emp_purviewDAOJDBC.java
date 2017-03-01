package com.emp_purview.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;





public class Emp_purviewDAOJDBC implements Emp_purviewDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106";
	String passwd = "aa106";

	

	private static final String INSERT_STMT = "INSERT INTO emp_purview (emp_No,purview_No) VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT emp_No,purview_No from emp_purview order by emp_No ";
	private static final String DELETE = "DELETE FROM emp_purview where emp_No = ? and purview_No=? ";
	private static final String GET_LIST_EMP_PURVIEW_BY_EMPNO = "SELECT emp_No,purview_No FROM emp_purview where emp_No = ? ";


	@Override
	public void insert(Emp_purviewVO emp_purviewVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, emp_purviewVO.getEmp_No());
			pstmt.setString(2, emp_purviewVO.getPurview_No());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void delete(String emp_No) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_No);
		

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
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
	public List<Emp_purviewVO> getAll() {
		// TODO Auto-generated method stub

		List<Emp_purviewVO> list = new ArrayList<Emp_purviewVO>();
		Emp_purviewVO emp_purviewVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				emp_purviewVO = new Emp_purviewVO();
				emp_purviewVO.setEmp_No(rs.getString("emp_No"));
				emp_purviewVO.setPurview_No(rs.getString("purview_No"));
				list.add(emp_purviewVO);

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
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
	
	
	@Override
	public Set<Emp_purviewVO> Emp_purviewByEmp_no(String emp_No) {
		// TODO Auto-generated method stub
		
		Set<Emp_purviewVO> set = new LinkedHashSet<Emp_purviewVO>();
		Emp_purviewVO emp_purviewVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			pstmt = con.prepareStatement(GET_LIST_EMP_PURVIEW_BY_EMPNO);

			pstmt.setString(1, emp_No);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				emp_purviewVO = new Emp_purviewVO();

				emp_purviewVO.setEmp_No(rs.getString("emp_No"));
				emp_purviewVO.setPurview_No(rs.getString("purview_No"));
				
				set.add(emp_purviewVO); // Store the row in the vector

			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
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
		return set;
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		Emp_purviewDAOJDBC dao= new Emp_purviewDAOJDBC();
		
		//insert 		
//		Emp_purviewVO emp_purviewVO=new Emp_purviewVO();
//		emp_purviewVO.setEmp_No("10003");
//		emp_purviewVO.setPurview_No("15004");
//		dao.insert(emp_purviewVO);
//		
		//delete
//		dao.delete("10000", "15005");
		
		//Emp_purviewByEmp_no
		Set<Emp_purviewVO> set=dao.Emp_purviewByEmp_no("10000");
		for(Emp_purviewVO aEmp_purview: set){
		
			System.out.println(aEmp_purview.getEmp_No());
			System.out.println(aEmp_purview.getPurview_No());
			System.out.println("-------------------------------------------");
		}
//	
		
		
		
//		//getAll
//		List <Emp_purviewVO> list= dao.getAll();
//		for(Emp_purviewVO aEmp_purview:list){
//		System.out.println(aEmp_purview.getEmp_No());
//		System.out.println(aEmp_purview.getPurview_No());
//		System.out.println("-------------------------------------------------------");
//		}
//		
		
	}





	

	





	
	


	

	
	
}
