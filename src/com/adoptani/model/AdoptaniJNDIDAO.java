package com.adoptani.model;

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





public class AdoptaniJNDIDAO implements AdoptaniDAO_interface{
	
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
			"INSERT INTO adopt_Ani (ADOPT_ANI_ID,MEM_ID,ADOPT_ANI_NAME,ADOPT_ANI_TYPE,ADOPT_ANI_GENDER,ADOPT_ANI_HEAL,ADOPT_ANI_VAC,ADOPT_ANI_COLOR,ADOPT_ANI_BODY,ADOPT_ANI_AGE,ADOPT_ANI_NEU,ADOPT_ANI_CHIP,ADOPT_ANI_DATE,ADOPT_ANI_STATUS,ADOPT_ANI_CREDATE,ADOPT_ANI_FINLAT,ADOPT_ANI_FINLON,ADOPT_ANI_CITY,ADOPT_ANI_TOWN,ADOPT_ANI_ROAD) VALUES (adopt_Ani_Seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)";
	
	private static final String GET_ALL_STMT = 
			"SELECT ADOPT_ANI_ID,MEM_ID,ADOPT_ANI_NAME,ADOPT_ANI_TYPE,ADOPT_ANI_GENDER,ADOPT_ANI_HEAL,ADOPT_ANI_VAC,ADOPT_ANI_COLOR,ADOPT_ANI_BODY,ADOPT_ANI_AGE,ADOPT_ANI_NEU,ADOPT_ANI_CHIP,ADOPT_ANI_DATE,ADOPT_ANI_STATUS,ADOPT_ANI_CREDATE,ADOPT_ANI_FINLAT,ADOPT_ANI_FINLON,ADOPT_ANI_CITY,ADOPT_ANI_TOWN,ADOPT_ANI_ROAD,ADOPT_ANI_LIKE FROM adopt_Ani ORDER BY ADOPT_ANI_ID";
	
	private static final String GET_ONE_STMT = 
			"SELECT ADOPT_ANI_ID,MEM_ID,ADOPT_ANI_NAME,ADOPT_ANI_TYPE,ADOPT_ANI_GENDER,ADOPT_ANI_HEAL,ADOPT_ANI_VAC,ADOPT_ANI_COLOR,ADOPT_ANI_BODY,ADOPT_ANI_AGE,ADOPT_ANI_NEU,ADOPT_ANI_CHIP,ADOPT_ANI_DATE,ADOPT_ANI_STATUS,ADOPT_ANI_CREDATE,ADOPT_ANI_FINLAT,ADOPT_ANI_FINLON,ADOPT_ANI_CITY,ADOPT_ANI_TOWN,ADOPT_ANI_ROAD,ADOPT_ANI_LIKE FROM adopt_Ani where adopt_Ani_Id = ?";

	//	private static final String GET_Emps_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM adopt_Ani where adopt_Ani_Id = ? order by empno";
	
	private static final String DELETE = 
			"DELETE FROM ADOPT_ANI where ADOPT_ANI_ID = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE adopt_Ani set adopt_Ani_name=?, adopt_Ani_type=?, adopt_Ani_gender=?, adopt_Ani_heal=?, adopt_Ani_Vac=?, adopt_Ani_color=?, adopt_Ani_body=?, adopt_Ani_age=?, adopt_Ani_Neu=?, adopt_Ani_chip=?, adopt_Ani_date=?, adopt_Ani_status=?, adopt_Ani_CreDate=?, adopt_Ani_FinLat=?, adopt_Ani_FinLon=?, adopt_Ani_city=?, adopt_Ani_town=?, adopt_Ani_road=? where adopt_Ani_Id = ?";


	
	@Override
	public void insert(AdoptaniVO adoptaniVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			    
			pstmt.setString(1, adoptaniVO.getMem_Id());     
			pstmt.setString(2, adoptaniVO.getAdopt_Ani_name());  
			pstmt.setString(3, adoptaniVO.getAdopt_Ani_type());  
			pstmt.setString(4, adoptaniVO.getAdopt_Ani_gender());  
			pstmt.setString(5, adoptaniVO.getAdopt_Ani_heal());  
			pstmt.setString(6, adoptaniVO.getAdopt_Ani_Vac());  
			pstmt.setString(7, adoptaniVO.getAdopt_Ani_color());  
			pstmt.setString(8, adoptaniVO.getAdopt_Ani_body());  
			pstmt.setString(9, adoptaniVO.getAdopt_Ani_age());  
			pstmt.setString(10, adoptaniVO.getAdopt_Ani_Neu());  
			pstmt.setString(11, adoptaniVO.getAdopt_Ani_chip());  
			pstmt.setTimestamp(12, adoptaniVO.getAdopt_Ani_date());  
			pstmt.setString(13, adoptaniVO.getAdopt_Ani_status());  
//			pstmt.setTimestamp(14, adoptaniVO.getAdopt_Ani_CreDate());  
			pstmt.setDouble(14, adoptaniVO.getAdopt_Ani_FinLat());  
			pstmt.setDouble(15, adoptaniVO.getAdopt_Ani_FinLon());  
			pstmt.setString(16, adoptaniVO.getAdopt_Ani_city());  
			pstmt.setString(17, adoptaniVO.getAdopt_Ani_town());  
			pstmt.setString(18, adoptaniVO.getAdopt_Ani_road());
//			pstmt.setInt(19, adoptaniVO.getAdopt_Ani_like());

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
	public void update(AdoptaniVO adoptaniVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			     
			pstmt.setString(1, adoptaniVO.getAdopt_Ani_name());  
			pstmt.setString(2, adoptaniVO.getAdopt_Ani_type());  
			pstmt.setString(3, adoptaniVO.getAdopt_Ani_gender());  
			pstmt.setString(4, adoptaniVO.getAdopt_Ani_heal());  
			pstmt.setString(5, adoptaniVO.getAdopt_Ani_Vac());  
			pstmt.setString(6, adoptaniVO.getAdopt_Ani_color());  
			pstmt.setString(7, adoptaniVO.getAdopt_Ani_body());  
			pstmt.setString(8, adoptaniVO.getAdopt_Ani_age());  
			pstmt.setString(9, adoptaniVO.getAdopt_Ani_Neu());  
			pstmt.setString(10, adoptaniVO.getAdopt_Ani_chip());  
			pstmt.setTimestamp  (11, adoptaniVO.getAdopt_Ani_date());  
			pstmt.setString(12, adoptaniVO.getAdopt_Ani_status());  
			pstmt.setTimestamp  (13, adoptaniVO.getAdopt_Ani_CreDate());  
			pstmt.setDouble(14, adoptaniVO.getAdopt_Ani_FinLat());  
			pstmt.setDouble(15, adoptaniVO.getAdopt_Ani_FinLon());  
			pstmt.setString(16, adoptaniVO.getAdopt_Ani_city());  
			pstmt.setString(17, adoptaniVO.getAdopt_Ani_town());  
			pstmt.setString(18, adoptaniVO.getAdopt_Ani_road());
//			pstmt.setInt(19, adoptaniVO.getAdopt_Ani_like());
			pstmt.setString(19, adoptaniVO.getAdopt_Ani_Id());
			

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
	public void delete(String adopt_Ani_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, adopt_Ani_Id);    
			System.out.println(adopt_Ani_Id);
			
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
	public AdoptaniVO findByPrimaryKey(String adopt_Ani_Id) {
		
		AdoptaniVO adoptaniVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, adopt_Ani_Id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
				adoptaniVO = new AdoptaniVO();
				
				adoptaniVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
				adoptaniVO.setMem_Id(rs.getString("Mem_Id"));
				adoptaniVO.setAdopt_Ani_name(rs.getString("Adopt_Ani_name"));
				adoptaniVO.setAdopt_Ani_type(rs.getString("Adopt_Ani_type"));
				adoptaniVO.setAdopt_Ani_gender(rs.getString("Adopt_Ani_gender"));
				adoptaniVO.setAdopt_Ani_heal(rs.getString("Adopt_Ani_heal"));
				adoptaniVO.setAdopt_Ani_Vac(rs.getString("Adopt_Ani_Vac"));
				adoptaniVO.setAdopt_Ani_color(rs.getString("Adopt_Ani_color"));
				adoptaniVO.setAdopt_Ani_body(rs.getString("Adopt_Ani_body"));
				adoptaniVO.setAdopt_Ani_age(rs.getString("Adopt_Ani_age"));
				adoptaniVO.setAdopt_Ani_Neu(rs.getString("Adopt_Ani_Neu"));
				adoptaniVO.setAdopt_Ani_chip(rs.getString("Adopt_Ani_chip"));
				adoptaniVO.setAdopt_Ani_date(rs.getTimestamp("Adopt_Ani_date"));
				adoptaniVO.setAdopt_Ani_status(rs.getString("Adopt_Ani_status"));
				adoptaniVO.setAdopt_Ani_CreDate(rs.getTimestamp("Adopt_Ani_CreDate"));
				adoptaniVO.setAdopt_Ani_FinLat(rs.getDouble("Adopt_Ani_FinLat"));
				adoptaniVO.setAdopt_Ani_FinLon(rs.getDouble("Adopt_Ani_FinLon"));
				adoptaniVO.setAdopt_Ani_city(rs.getString("Adopt_Ani_city"));
				adoptaniVO.setAdopt_Ani_town(rs.getString("Adopt_Ani_town"));
				adoptaniVO.setAdopt_Ani_road(rs.getString("Adopt_Ani_road"));
				adoptaniVO.setAdopt_Ani_like(rs.getInt("Adopt_Ani_like"));

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

		
		return adoptaniVO;
	}
	
	
	@Override
	public List<AdoptaniVO> getAll() {
		List<AdoptaniVO> list = new ArrayList<AdoptaniVO>();
		AdoptaniVO adoptaniVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
				adoptaniVO = new AdoptaniVO();
				
				adoptaniVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
				adoptaniVO.setMem_Id(rs.getString("Mem_Id"));
				adoptaniVO.setAdopt_Ani_name(rs.getString("Adopt_Ani_name"));
				adoptaniVO.setAdopt_Ani_type(rs.getString("Adopt_Ani_type"));
				adoptaniVO.setAdopt_Ani_gender(rs.getString("Adopt_Ani_gender"));
				adoptaniVO.setAdopt_Ani_heal(rs.getString("Adopt_Ani_heal"));
				adoptaniVO.setAdopt_Ani_Vac(rs.getString("Adopt_Ani_Vac"));
				adoptaniVO.setAdopt_Ani_color(rs.getString("Adopt_Ani_color"));
				adoptaniVO.setAdopt_Ani_body(rs.getString("Adopt_Ani_body"));
				adoptaniVO.setAdopt_Ani_age(rs.getString("Adopt_Ani_age"));
				adoptaniVO.setAdopt_Ani_Neu(rs.getString("Adopt_Ani_Neu"));
				adoptaniVO.setAdopt_Ani_chip(rs.getString("Adopt_Ani_chip"));
				adoptaniVO.setAdopt_Ani_date(rs.getTimestamp("Adopt_Ani_date"));
				adoptaniVO.setAdopt_Ani_status(rs.getString("Adopt_Ani_status"));
				adoptaniVO.setAdopt_Ani_CreDate(rs.getTimestamp("Adopt_Ani_CreDate"));
				adoptaniVO.setAdopt_Ani_FinLat(rs.getDouble("Adopt_Ani_FinLat"));
				adoptaniVO.setAdopt_Ani_FinLon(rs.getDouble("Adopt_Ani_FinLon"));
				adoptaniVO.setAdopt_Ani_city(rs.getString("Adopt_Ani_city"));
				adoptaniVO.setAdopt_Ani_town(rs.getString("Adopt_Ani_town"));
				adoptaniVO.setAdopt_Ani_road(rs.getString("Adopt_Ani_road"));
				adoptaniVO.setAdopt_Ani_like(rs.getInt("Adopt_Ani_like"));

				list.add(adoptaniVO); // Store the row in the list
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
	




public static void main(String[] args) {

	AdoptaniJDBCDAO dao = new AdoptaniJDBCDAO();

	// 新增
	AdoptaniVO adoptaniVO1 = new AdoptaniVO();
	AdoptaniVO adoptaniVO2 = new AdoptaniVO();
	
	adoptaniVO1.setMem_Id("10000001");
	adoptaniVO1.setAdopt_Ani_name("Snoopy");
	adoptaniVO1.setAdopt_Ani_type("dog");
	adoptaniVO1.setAdopt_Ani_gender("1");
	adoptaniVO1.setAdopt_Ani_heal("good");
	adoptaniVO1.setAdopt_Ani_Vac("no");
	adoptaniVO1.setAdopt_Ani_color("white&black");
	adoptaniVO1.setAdopt_Ani_body("middle");
	adoptaniVO1.setAdopt_Ani_age("?");
	adoptaniVO1.setAdopt_Ani_Neu("0");
	adoptaniVO1.setAdopt_Ani_chip("");
	adoptaniVO1.setAdopt_Ani_date(java.sql.Timestamp.valueOf("2000-01-01 01:01:01"));
	adoptaniVO1.setAdopt_Ani_status("1");
	adoptaniVO1.setAdopt_Ani_CreDate(java.sql.Timestamp.valueOf("2000-01-01 01:01:01"));
	adoptaniVO1.setAdopt_Ani_FinLat(12.111111);
	adoptaniVO1.setAdopt_Ani_FinLon(121.111111);
	adoptaniVO1.setAdopt_Ani_city("");
	adoptaniVO1.setAdopt_Ani_town("");
	adoptaniVO1.setAdopt_Ani_road("");
	adoptaniVO1.setAdopt_Ani_like(3);
	dao.insert(adoptaniVO1);
	System.out.println("成功插入");
	
	adoptaniVO2.setMem_Id("10000001");
	adoptaniVO2.setAdopt_Ani_name("Snoopy33");
	adoptaniVO2.setAdopt_Ani_type("dog");
	adoptaniVO2.setAdopt_Ani_gender("1");
	adoptaniVO2.setAdopt_Ani_heal("good");
	adoptaniVO2.setAdopt_Ani_Vac("no");
	adoptaniVO2.setAdopt_Ani_color("white&black");
	adoptaniVO2.setAdopt_Ani_body("middle");
	adoptaniVO2.setAdopt_Ani_age("?");
	adoptaniVO2.setAdopt_Ani_Neu("0");
	adoptaniVO2.setAdopt_Ani_chip("");
	adoptaniVO2.setAdopt_Ani_date(java.sql.Timestamp.valueOf("2000-01-01 01:01:01"));
	adoptaniVO2.setAdopt_Ani_status("1");
	adoptaniVO2.setAdopt_Ani_CreDate(java.sql.Timestamp.valueOf("2000-01-01 01:01:01"));
	adoptaniVO2.setAdopt_Ani_FinLat(12.111111);
	adoptaniVO2.setAdopt_Ani_FinLon(121.111111);
	adoptaniVO2.setAdopt_Ani_city("");
	adoptaniVO2.setAdopt_Ani_town("");
	adoptaniVO2.setAdopt_Ani_road("");
	adoptaniVO2.setAdopt_Ani_like(4);
	dao.insert(adoptaniVO2);
	System.out.println("成功插入");
	// 修改
	AdoptaniVO adoptaniVO3 = new AdoptaniVO();
	adoptaniVO3.setAdopt_Ani_Id("40000021");
	adoptaniVO3.setMem_Id("10000001");
	adoptaniVO3.setAdopt_Ani_name("SnoopyVer3");
	adoptaniVO3.setAdopt_Ani_type("dog");
	adoptaniVO3.setAdopt_Ani_gender("1");
	adoptaniVO3.setAdopt_Ani_heal("good");
	adoptaniVO3.setAdopt_Ani_Vac("no");
	adoptaniVO3.setAdopt_Ani_color("yellow");
	adoptaniVO3.setAdopt_Ani_body("middle");
	adoptaniVO3.setAdopt_Ani_age("?");
	adoptaniVO3.setAdopt_Ani_Neu("0");
	adoptaniVO3.setAdopt_Ani_chip("");
	adoptaniVO3.setAdopt_Ani_date(java.sql.Timestamp.valueOf("2000-01-01 01:01:01"));
	adoptaniVO3.setAdopt_Ani_status("1");
	adoptaniVO3.setAdopt_Ani_CreDate(java.sql.Timestamp.valueOf("2000-01-01 01:01:01"));
	adoptaniVO3.setAdopt_Ani_FinLat(12.111111);
	adoptaniVO3.setAdopt_Ani_FinLon(121.111111);
	adoptaniVO3.setAdopt_Ani_city("");
	adoptaniVO3.setAdopt_Ani_town("");
	adoptaniVO3.setAdopt_Ani_road("");
	adoptaniVO3.setAdopt_Ani_like(15);
	dao.update(adoptaniVO3);
	System.out.println("成功修改");
	// 刪除
	dao.delete("40000004");
	System.out.println("成功刪除");
	// 查詢
	AdoptaniVO adoptaniVO4 = dao.findByPrimaryKey("40000001");
	System.out.print(adoptaniVO4.getAdopt_Ani_Id() + ",");
	System.out.print(adoptaniVO4.getMem_Id() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_name() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_type() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_gender() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_heal() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_Vac() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_color() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_body() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_age() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_Neu() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_chip() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_date() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_status() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_CreDate() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_FinLat() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_FinLon() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_city() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_town() + ",");
	System.out.println(adoptaniVO4.getAdopt_Ani_road() + ",");
	System.out.println(adoptaniVO4.getAdopt_Ani_like() + ",");
	System.out.println("------------------------------------------------");
	
	//查詢
	List<AdoptaniVO> list = dao.getAll();
	for (AdoptaniVO aAdoptaniVO : list) {
		System.out.print(aAdoptaniVO.getAdopt_Ani_Id() + ",");
		System.out.print(aAdoptaniVO.getMem_Id() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_name() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_type() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_gender() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_heal() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_Vac() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_color() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_body() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_age() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_Neu() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_chip() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_date() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_status() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_CreDate() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_FinLat() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_FinLon() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_city() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_town() + ",");
		System.out.print(aAdoptaniVO.getAdopt_Ani_road() + ",");
		System.out.println(aAdoptaniVO.getAdopt_Ani_like() + ",");
		System.out.println();
	}
  }
}


