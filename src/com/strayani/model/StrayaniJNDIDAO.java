package com.strayani.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;





public class StrayaniJNDIDAO implements StrayaniDAO_interface{
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"INSERT INTO STRAY_ANI (stray_Ani_Id ,mem_Id ,stray_Ani_name ,stray_Ani_type ,stray_Ani_gender ,stray_Ani_heal ,stray_Ani_Vac ,stray_Ani_color ,stray_Ani_body ,stray_Ani_age ,stray_Ani_Neu ,stray_Ani_chip ,stray_Ani_date ,stray_Ani_status ,stray_Ani_CreDate ,stray_Ani_FinLat ,stray_Ani_FinLon ,stray_Ani_city ,stray_Ani_town ,stray_Ani_road ) VALUES (stray_Ani_Seq.NEXTVAL,? ,?,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,sysdate,? ,? ,? ,? ,?)";
	
	private static final String GET_ALL_STMT = 
			"SELECT stray_Ani_Id ,mem_Id ,stray_Ani_name ,stray_Ani_type ,stray_Ani_gender ,stray_Ani_heal ,stray_Ani_Vac ,stray_Ani_color ,stray_Ani_body ,stray_Ani_age ,stray_Ani_Neu ,stray_Ani_chip ,stray_Ani_date ,stray_Ani_status ,stray_Ani_CreDate ,stray_Ani_FinLat ,stray_Ani_FinLon ,stray_Ani_city ,stray_Ani_town ,stray_Ani_road ,stray_Ani_like FROM STRAY_ANI ORDER BY stray_Ani_Id";
	
	private static final String GET_ONE_STMT = 
			"SELECT stray_Ani_Id ,mem_Id ,stray_Ani_name ,stray_Ani_type ,stray_Ani_gender ,stray_Ani_heal ,stray_Ani_Vac ,stray_Ani_color ,stray_Ani_body ,stray_Ani_age ,stray_Ani_Neu ,stray_Ani_chip ,stray_Ani_date ,stray_Ani_status ,stray_Ani_CreDate ,stray_Ani_FinLat ,stray_Ani_FinLon ,stray_Ani_city ,stray_Ani_town ,stray_Ani_road ,stray_Ani_like FROM STRAY_ANI where stray_Ani_Id = ?";

	//	private static final String GET_Emps_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM adopt_Ani where adopt_Ani_Id = ? order by empno";
	
	private static final String DELETE = 
			"DELETE FROM STRAY_ANI where stray_Ani_Id = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE STRAY_ANI set stray_Ani_name=?, stray_Ani_type=?, stray_Ani_gender=?, stray_Ani_heal=?, stray_Ani_Vac=?, stray_Ani_color=?, stray_Ani_body=?, stray_Ani_age=?, stray_Ani_Neu=?, stray_Ani_chip=?, stray_Ani_date=?, stray_Ani_status=?, stray_Ani_CreDate=?, stray_Ani_FinLat=?, stray_Ani_FinLon=?, stray_Ani_city=?, stray_Ani_town=?, stray_Ani_road=?, stray_Ani_like=? where stray_Ani_Id = ?";


	
	@Override
	public void insert(StrayaniVO strayaniVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			    
			pstmt.setString(1, strayaniVO.getMem_Id());     
			pstmt.setString(2, strayaniVO.getStray_Ani_name());  
			pstmt.setString(3, strayaniVO.getStray_Ani_type());  
			pstmt.setString(4, strayaniVO.getStray_Ani_gender());  
			pstmt.setString(5, strayaniVO.getStray_Ani_heal());  
			pstmt.setString(6, strayaniVO.getStray_Ani_Vac());  
			pstmt.setString(7, strayaniVO.getStray_Ani_color());  
			pstmt.setString(8, strayaniVO.getStray_Ani_body());  
			pstmt.setString(9, strayaniVO.getStray_Ani_age());  
			pstmt.setString(10, strayaniVO.getStray_Ani_Neu());  
			pstmt.setString(11, strayaniVO.getStray_Ani_chip());  
			pstmt.setTimestamp(12, strayaniVO.getStray_Ani_date());  
			pstmt.setString(13, strayaniVO.getStray_Ani_status());  
//			pstmt.setTimestamp(14, strayaniVO.getStray_Ani_CreDate());  
			pstmt.setDouble(14, strayaniVO.getStray_Ani_FinLat());  
			pstmt.setDouble(15, strayaniVO.getStray_Ani_FinLon());  
			pstmt.setString(16, strayaniVO.getStray_Ani_city());  
			pstmt.setString(17, strayaniVO.getStray_Ani_town());  
			pstmt.setString(18, strayaniVO.getStray_Ani_road());
//			pstmt.setInt(19, strayaniVO.getStray_Ani_like());

			pstmt.executeUpdate();
			
			// Handle any driver errors
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
	public void update(StrayaniVO strayaniVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			     
//			pstmt.setString(1, strayaniVO.getMem_Id());     
			pstmt.setString(1, strayaniVO.getStray_Ani_name());  
			pstmt.setString(2, strayaniVO.getStray_Ani_type());  
			pstmt.setString(3, strayaniVO.getStray_Ani_gender());  
			pstmt.setString(4, strayaniVO.getStray_Ani_heal());  
			pstmt.setString(5, strayaniVO.getStray_Ani_Vac());  
			pstmt.setString(6, strayaniVO.getStray_Ani_color());  
			pstmt.setString(7, strayaniVO.getStray_Ani_body());  
			pstmt.setString(8, strayaniVO.getStray_Ani_age());  
			pstmt.setString(9, strayaniVO.getStray_Ani_Neu());  
			pstmt.setString(10, strayaniVO.getStray_Ani_chip());  
			pstmt.setTimestamp(11, strayaniVO.getStray_Ani_date());  
			pstmt.setString(12, strayaniVO.getStray_Ani_status());  
			pstmt.setTimestamp(13, strayaniVO.getStray_Ani_CreDate());  
			pstmt.setDouble(14, strayaniVO.getStray_Ani_FinLat());  
			pstmt.setDouble(15, strayaniVO.getStray_Ani_FinLon());  
			pstmt.setString(16, strayaniVO.getStray_Ani_city());  
			pstmt.setString(17, strayaniVO.getStray_Ani_town());  
			pstmt.setString(18, strayaniVO.getStray_Ani_road());
			pstmt.setInt(19, strayaniVO.getStray_Ani_like());
			pstmt.setString(20, strayaniVO.getStray_Ani_Id());
			

			pstmt.executeUpdate();
			
			// Handle any driver errors
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
	public void delete(String stray_Ani_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, stray_Ani_Id);    
			System.out.println(stray_Ani_Id);
			
			pstmt.executeUpdate();
			
			// Handle any driver errors
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
	public StrayaniVO findByPrimaryKey(String stray_Ani_Id) {
		
		StrayaniVO strayaniVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, stray_Ani_Id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				//strayaniVO也稱為Domain objects
				strayaniVO = new StrayaniVO();
				
                strayaniVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
                strayaniVO.setMem_Id(rs.getString("mem_Id"));
                strayaniVO.setStray_Ani_name(rs.getString("stray_Ani_name"));
                strayaniVO.setStray_Ani_type(rs.getString("stray_Ani_type"));
                strayaniVO.setStray_Ani_gender(rs.getString("stray_Ani_gender"));
                strayaniVO.setStray_Ani_heal(rs.getString("stray_Ani_heal"));
                strayaniVO.setStray_Ani_Vac(rs.getString("stray_Ani_Vac"));
                strayaniVO.setStray_Ani_color(rs.getString("stray_Ani_color"));
                strayaniVO.setStray_Ani_body(rs.getString("stray_Ani_body"));
                strayaniVO.setStray_Ani_age(rs.getString("stray_Ani_age"));
                strayaniVO.setStray_Ani_Neu(rs.getString("stray_Ani_Neu"));
                strayaniVO.setStray_Ani_chip(rs.getString("stray_Ani_chip"));
                strayaniVO.setStray_Ani_date(rs.getTimestamp("stray_Ani_date"));
                strayaniVO.setStray_Ani_status(rs.getString("stray_Ani_status"));
                strayaniVO.setStray_Ani_CreDate(rs.getTimestamp("stray_Ani_CreDate"));
                strayaniVO.setStray_Ani_FinLat(rs.getDouble("stray_Ani_FinLat"));
                strayaniVO.setStray_Ani_FinLon(rs.getDouble("stray_Ani_FinLon"));
                strayaniVO.setStray_Ani_city(rs.getString("stray_Ani_city"));
                strayaniVO.setStray_Ani_town(rs.getString("stray_Ani_town"));
                strayaniVO.setStray_Ani_road(rs.getString("stray_Ani_road"));
                strayaniVO.setStray_Ani_like(rs.getInt("stray_Ani_like"));

			}
			// Handle any driver errors
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

		
		return strayaniVO;
	}
	
	
	@Override
	public List<StrayaniVO> getAll() {
		List<StrayaniVO> list = new ArrayList<StrayaniVO>();
		StrayaniVO strayaniVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				//strayaniVO也稱為Domain objects
				strayaniVO = new StrayaniVO();
				
                strayaniVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
                strayaniVO.setMem_Id(rs.getString("mem_Id"));
                strayaniVO.setStray_Ani_name(rs.getString("stray_Ani_name"));
                strayaniVO.setStray_Ani_type(rs.getString("stray_Ani_type"));
                strayaniVO.setStray_Ani_gender(rs.getString("stray_Ani_gender"));
                strayaniVO.setStray_Ani_heal(rs.getString("stray_Ani_heal"));
                strayaniVO.setStray_Ani_Vac(rs.getString("stray_Ani_Vac"));
                strayaniVO.setStray_Ani_color(rs.getString("stray_Ani_color"));
                strayaniVO.setStray_Ani_body(rs.getString("stray_Ani_body"));
                strayaniVO.setStray_Ani_age(rs.getString("stray_Ani_age"));
                strayaniVO.setStray_Ani_Neu(rs.getString("stray_Ani_Neu"));
                strayaniVO.setStray_Ani_chip(rs.getString("stray_Ani_chip"));
                strayaniVO.setStray_Ani_date(rs.getTimestamp("stray_Ani_date"));
                strayaniVO.setStray_Ani_status(rs.getString("stray_Ani_status"));
                strayaniVO.setStray_Ani_CreDate(rs.getTimestamp("stray_Ani_CreDate"));
                strayaniVO.setStray_Ani_FinLat(rs.getDouble("stray_Ani_FinLat"));
                strayaniVO.setStray_Ani_FinLon(rs.getDouble("stray_Ani_FinLon"));
                strayaniVO.setStray_Ani_city(rs.getString("stray_Ani_city"));
                strayaniVO.setStray_Ani_town(rs.getString("stray_Ani_town"));
                strayaniVO.setStray_Ani_road(rs.getString("stray_Ani_road"));
                strayaniVO.setStray_Ani_like(rs.getInt("stray_Ani_like"));

				list.add(strayaniVO); // Store the row in the list
			}
			// Handle any driver errors
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
	
}






