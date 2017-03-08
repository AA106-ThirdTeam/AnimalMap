package com.strayani_message.model;

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





public class StrayaniMessageJNDIDAO implements StrayaniMessageDAO_interface{
	
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
				"INSERT INTO stray_Ani_message (str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes) VALUES (stray_Ani_message_Seq.NEXTVAL,?,?,sysdate,?)";
		
		private static final String GET_ALL_STMT = 
				"SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes FROM stray_Ani_message";
		
		private static final String GET_ONE_STMT = 
				"SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes FROM stray_Ani_message where str_Ani_Mes_No = ?";

		private static final String DELETE = 
				"DELETE FROM stray_Ani_message where str_Ani_Mes_No = ?";
		
		private static final String UPDATE_STMT = 
				"UPDATE stray_Ani_message set  str_Ani_Mes=? where str_Ani_Mes_No = ?";

		private static final String GET_ONE_ALL_STMT = 
				"SELECT str_Ani_Mes_No,stray_Ani_Id,mem_Id,str_Ani_Mes_time,str_Ani_Mes FROM stray_Ani_message where stray_Ani_Id = ? ORDER BY str_Ani_Mes_time";	
		
		
		@Override
		public void insert(StrayaniMessageVO strayaniMessageVO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				
				System.out.println("StrayaniMessageJNDIDAO strayaniMessageVO:"+strayaniMessageVO.getStray_Ani_Id());
				pstmt.setString(1, strayaniMessageVO.getStray_Ani_Id());     
				pstmt.setString(2, strayaniMessageVO.getMem_Id());  
				pstmt.setString(3, strayaniMessageVO.getStr_Ani_Mes());  

				
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
		public void update(StrayaniMessageVO strayaniMessageVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_STMT);
				
				     
				pstmt.setString(1, strayaniMessageVO.getStr_Ani_Mes());  
				pstmt.setString(2, strayaniMessageVO.getStr_Ani_Mes_No());  
				System.out.println("here");
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
		public void delete(String str_Ani_Mes_No) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				
				pstmt.setString(1, str_Ani_Mes_No);    
				
				
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
		public StrayaniMessageVO findByPrimaryKey(String str_Ani_Mes_No) {
			
			StrayaniMessageVO strayaniMessageVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				
				pstmt.setString(1, str_Ani_Mes_No);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					//strayaniVO也稱為Domain objects
					strayaniMessageVO = new StrayaniMessageVO();
					strayaniMessageVO.setStr_Ani_Mes_No(rs.getString("Str_Ani_Mes_No"));
					strayaniMessageVO.setStray_Ani_Id(rs.getString("Stray_Ani_Id"));
					strayaniMessageVO.setMem_Id(rs.getString("Mem_Id"));
					strayaniMessageVO.setStr_Ani_Mes(rs.getString("Str_Ani_Mes"));
					strayaniMessageVO.setStr_Ani_Mes_time(rs.getString("str_Ani_Mes_time"));
				
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

			
			return strayaniMessageVO;
		}
		
		
		@Override
		public List<StrayaniMessageVO> getAll() {
			List<StrayaniMessageVO> list = new ArrayList<StrayaniMessageVO>();
			StrayaniMessageVO strayaniMessageVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//strayaniVO也稱為Domain objects
					strayaniMessageVO = new StrayaniMessageVO();
					strayaniMessageVO.setStr_Ani_Mes_No(rs.getString("Str_Ani_Mes_No"));
					strayaniMessageVO.setStray_Ani_Id(rs.getString("Stray_Ani_Id"));
					strayaniMessageVO.setMem_Id(rs.getString("Mem_Id"));
					strayaniMessageVO.setStr_Ani_Mes(rs.getString("Str_Ani_Mes"));
					strayaniMessageVO.setStr_Ani_Mes_time(rs.getString("str_Ani_Mes_time"));

					list.add(strayaniMessageVO); // Store the row in the list
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
		public List<StrayaniMessageVO> getOneAllMessage(String Stray_Ani_Id) {
			List<StrayaniMessageVO> list = new ArrayList<StrayaniMessageVO>();
			StrayaniMessageVO strayaniMessageVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_ALL_STMT);
				pstmt.setString(1, Stray_Ani_Id);
				
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//strayaniVO也稱為Domain objects
					strayaniMessageVO = new StrayaniMessageVO();
					strayaniMessageVO.setStr_Ani_Mes_No(rs.getString("Str_Ani_Mes_No"));
					strayaniMessageVO.setStray_Ani_Id(rs.getString("Stray_Ani_Id"));
					strayaniMessageVO.setMem_Id(rs.getString("Mem_Id"));
					strayaniMessageVO.setStr_Ani_Mes(rs.getString("Str_Ani_Mes"));
					strayaniMessageVO.setStr_Ani_Mes_time(rs.getString("str_Ani_Mes_time"));

					list.add(strayaniMessageVO); // Store the row in the list
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


