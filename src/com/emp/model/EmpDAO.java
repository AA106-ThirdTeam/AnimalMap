package com.emp.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO implements EmpDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT =
			"INSERT INTO emp (emp_No,emp_name,emp_Pw,emp_email,emp_Id,emp_birthday,emp_phone,emp_address,emp_status,emp_picture,emp_Pic_format,emp_hiredate,emp_firedate) VALUES (emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, null)";
	private static final String GET_ALL_STMT = 
			"SELECT emp_No,emp_name,emp_Pw,emp_email,emp_Id,to_char(emp_birthday,'yyyy-mm-dd') emp_birthday,emp_phone,emp_address,emp_status,emp_picture,to_char(emp_hiredate,'yyyy-mm-dd') emp_hiredate,to_char(emp_firedate,'yyyy-mm-dd') emp_firedate from emp order by emp_No desc";
	private static final String GET_ONE_STMT = 
			"SELECT emp_No,emp_name,emp_Pw,emp_email,emp_Id,to_char(emp_birthday,'yyyy-mm-dd') emp_birthday,emp_phone,emp_address,emp_status,emp_picture,to_char(emp_hiredate,'yyyy-mm-dd') emp_hiredate,to_char(emp_firedate,'yyyy-mm-dd') emp_firedate from emp where emp_No = ?";
	private static final String DELETE = 
			"DELETE FROM emp where emp_No = ?";
//	private static final String UPDATE = 
//			"UPDATE emp set emp_name=?,emp_Pw=?,emp_email=?,emp_Id=?,emp_birthday=?,emp_phone=?,emp_address=?,emp_status=?,emp_picture=?,emp_hiredate=?,emp_firedate=? where emp_No = ?";
	
	private static final String GET_USER_LOGIN = "Select emp_No,emp_name,emp_email,emp_Pw from emp where emp_email=? and emp_Pw=? ";
	
	
	@Override
	public void insert(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			  	con=ds.getConnection();
			  	pstmt=con.prepareStatement(INSERT_STMT);
			  	
		  	
			  	pstmt.setString(1, empVO.getEmp_name());
				pstmt.setString(2, empVO.getEmp_Pw());
				pstmt.setString(3, empVO.getEmp_email());
				pstmt.setString(4, empVO.getEmp_Id());
				pstmt.setDate(5, empVO.getEmp_birthday());
				pstmt.setString(6, empVO.getEmp_phone());
				pstmt.setString(7, empVO.getEmp_address());
				pstmt.setString(8, empVO.getEmp_status());
				pstmt.setBytes(9, empVO.getEmp_picture());				
				pstmt.setDate(10, empVO.getEmp_hiredate());
			
				pstmt.executeUpdate();

		
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
			//用StringBuffer 串接 SQL 指令
			byte[] emp_picture=empVO.getEmp_picture();
			StringBuffer UPDATE=new StringBuffer();
			UPDATE.append("UPDATE emp set emp_name=?,emp_Pw=?,emp_email=?,emp_Id=?,emp_birthday=?,emp_phone=?,emp_address=?,emp_status=?,emp_hiredate=?,emp_firedate=? ");
				
			// 如果Byte[] 有東西,串接指令
			if(emp_picture.length!=0){
				UPDATE.append(" ,emp_picture=? ");
			}	
					
			UPDATE.append(" where emp_No = ?");		
			
			
			
			
			con=ds.getConnection();
		  	pstmt=con.prepareStatement(UPDATE.toString());


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
			
			// 設一個Count  如果有新增的話 動態增加一個欄位
			int count=11;
			if(emp_picture.length!=0){
			pstmt.setBytes(count++, emp_picture);}			
			pstmt.setString(count, empVO.getEmp_No());			

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
	public void delete(String emp_No) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con=ds.getConnection();
		  	pstmt=con.prepareStatement(DELETE);


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
	public EmpVO findByPrimaryKey(String emp_No) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con=ds.getConnection();
		  	pstmt=con.prepareStatement(GET_ONE_STMT);


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
				empVO.setEmp_picture(rs.getBytes("emp_picture"));
				empVO.setEmp_hiredate(rs.getDate("emp_hiredate"));
				empVO.setEmp_firedate(rs.getDate("emp_firedate"));
			}

	
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
			con=ds.getConnection();
		  	pstmt=con.prepareStatement(GET_ALL_STMT);
		  	rs=pstmt.executeQuery();
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
				empVO.setEmp_picture(rs.getBytes("emp_picture"));
				empVO.setEmp_hiredate(rs.getDate("emp_hiredate"));
				empVO.setEmp_firedate(rs.getDate("emp_firedate"));
				list.add(empVO);

			}

	
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

	@Override
	public EmpVO findUserLogin(String emp_email, String emp_Pw) {
		// TODO Auto-generated method stub
		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(GET_USER_LOGIN);

			pstmt.setString(1, emp_email);
			pstmt.setString(2, emp_Pw);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				empVO = new EmpVO();	
				empVO.setEmp_No(rs.getString("emp_No"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_email(rs.getString("emp_email"));
				empVO.setEmp_Pw(rs.getString("emp_Pw"));
				
			}

		
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

	

}