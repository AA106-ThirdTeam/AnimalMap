package com.strayani_location.model;

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





public class StrayaniLocationJNDIDAO implements StrayaniLocationDAO_interface{
	
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
			"INSERT INTO stray_Ani_Loc (str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon) VALUES (STRAY_ANI_LOC_SEQ.NEXTVAL,?,?,?,?)";
	private static final String GET_ALL_STMT = 
			"SELECT str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon FROM stray_Ani_Loc ORDER BY str_Ani_Loc_No";
	
	private static final String GET_ONE_STMT = 
			"SELECT str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon FROM stray_Ani_Loc where str_Ani_Loc_No = ?";
	
	private static final String GET_ONE_ALL_STMT = 
			"SELECT str_Ani_Loc_No,stray_Ani_Id,mem_Id,str_Ani_LocLat,str_Ani_LocLon FROM stray_Ani_Loc where stray_Ani_Id = ? ORDER BY str_Ani_Loc_No";	
	
	private static final String DELETE = 
			"DELETE FROM stray_Ani_Loc where str_Ani_Loc_No = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE stray_Ani_Loc set   str_Ani_LocLat=?, str_Ani_LocLon=? where str_Ani_Loc_No = ?";


	
	@Override
	public void insert(StrayaniLocationVO strayaniLocationVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			
			
			pstmt.setString(1, strayaniLocationVO.getStray_Ani_Id());     
			pstmt.setString(2, strayaniLocationVO.getMem_Id());  
			pstmt.setInt(3, strayaniLocationVO.getStr_Ani_LocLat()); 
			pstmt.setInt(4, strayaniLocationVO.getStr_Ani_LocLon()); 

			
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
	public void update(StrayaniLocationVO strayaniLocationVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, strayaniLocationVO.getStr_Ani_LocLat());  
			pstmt.setInt(2, strayaniLocationVO.getStr_Ani_LocLon());  
			pstmt.setString(3, strayaniLocationVO.getStr_Ani_Loc_No());  
			
			
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
	public void delete(String str_Ani_Loc_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, str_Ani_Loc_No);    
			
			
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
	public StrayaniLocationVO findByPrimaryKey(String str_Ani_Loc_No) {
		
		StrayaniLocationVO strayaniLocationVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, str_Ani_Loc_No);
			
			rs = pstmt.executeQuery();
System.out.println(rs);
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
System.out.println(rs.getString("str_Ani_Loc_No"));
			strayaniLocationVO = new StrayaniLocationVO();
			strayaniLocationVO.setStr_Ani_Loc_No(rs.getString("str_Ani_Loc_No"));
			strayaniLocationVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
			strayaniLocationVO.setMem_Id(rs.getString("mem_Id"));
			strayaniLocationVO.setStr_Ani_LocLat(rs.getInt("str_Ani_LocLat"));
			strayaniLocationVO.setStr_Ani_LocLon(rs.getInt("str_Ani_LocLon"));
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

		
		return strayaniLocationVO;
	}
	
	
	@Override
	public List<StrayaniLocationVO> getAll() {
		List<StrayaniLocationVO> list = new ArrayList<StrayaniLocationVO>();
		StrayaniLocationVO strayaniLocationVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
				strayaniLocationVO = new StrayaniLocationVO();
				strayaniLocationVO.setStr_Ani_Loc_No(rs.getString("str_Ani_Loc_No"));
				strayaniLocationVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
				strayaniLocationVO.setMem_Id(rs.getString("mem_Id"));
				strayaniLocationVO.setStr_Ani_LocLat(rs.getInt("str_Ani_LocLat"));
				strayaniLocationVO.setStr_Ani_LocLon(rs.getInt("str_Ani_LocLon"));
			
				list.add(strayaniLocationVO); // Store the row in the list
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
	
	@Override
	public List<StrayaniLocationVO> getOneAllLocation(String stray_Ani_Id) {
		List<StrayaniLocationVO> list = new ArrayList<StrayaniLocationVO>();
		StrayaniLocationVO strayaniLocationVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_ALL_STMT);
			pstmt.setString(1, stray_Ani_Id);
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
				strayaniLocationVO = new StrayaniLocationVO();
				strayaniLocationVO.setStr_Ani_Loc_No(rs.getString("str_Ani_Loc_No"));
				strayaniLocationVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
				strayaniLocationVO.setMem_Id(rs.getString("mem_Id"));
				strayaniLocationVO.setStr_Ani_LocLat(rs.getInt("str_Ani_LocLat"));
				strayaniLocationVO.setStr_Ani_LocLon(rs.getInt("str_Ani_LocLon"));
				
				list.add(strayaniLocationVO); // Store the row in the list
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


