package com.emp_purview.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.purview.model.PurviewVO;

public class Emp_purviewDAO implements Emp_purviewDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO emp_purview (emp_No,purview_No) VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT emp_No,purview_No from emp_purview order by emp_No ";
	private static final String DELETE = "DELETE FROM emp_purview where emp_No = ?";
	private static final String GET_LIST_EMP_PURVIEW_BY_EMPNO = "SELECT emp_No,purview_No FROM emp_purview where emp_No = ? ";


	@Override
	public void insert(Emp_purviewVO emp_purviewVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, emp_purviewVO.getEmp_No());
			pstmt.setString(2, emp_purviewVO.getPurview_No());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_No);
			

			pstmt.executeQuery();

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
	public List<Emp_purviewVO> getAll() {
		// TODO Auto-generated method stub

		List<Emp_purviewVO> list = new ArrayList<Emp_purviewVO>();
		Emp_purviewVO emp_purviewVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
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
		Set<Emp_purviewVO> set = new LinkedHashSet<Emp_purviewVO>();
		Emp_purviewVO emp_purviewVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();

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
		}  finally {
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




}

