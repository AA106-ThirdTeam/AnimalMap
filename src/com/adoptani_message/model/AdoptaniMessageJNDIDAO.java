package com.adoptani_message.model;

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





public class AdoptaniMessageJNDIDAO implements AdoptaniMessageDAO_interface{
	
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
				"INSERT INTO adopt_Ani_message (ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes) VALUES (adopt_Ani_message_Seq.NEXTVAL,?,?,sysdate,?)";
		
		private static final String GET_ALL_STMT = 
				"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes FROM adopt_Ani_message";
		
		private static final String GET_ONE_STMT = 
				"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes FROM adopt_Ani_message where ado_Ani_Mes_No = ?";

		private static final String DELETE = 
				"DELETE FROM adopt_Ani_message where ado_Ani_Mes_No = ?";
		
		private static final String UPDATE_STMT = 
				"UPDATE adopt_Ani_message set  ado_Ani_Mes=? where ado_Ani_Mes_No = ?";

		private static final String GET_ONE_ALL_STMT = 
				"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes FROM adopt_Ani_message where adopt_Ani_Id = ? ORDER BY ado_Ani_Mes_time";	
		
		
		@Override
		public void insert(AdoptaniMessageVO adoptaniMessageVO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				
				    
				pstmt.setString(1, adoptaniMessageVO.getAdopt_Ani_Id());     
				pstmt.setString(2, adoptaniMessageVO.getMem_Id());  
				pstmt.setString(3, adoptaniMessageVO.getAdo_Ani_Mes());  

				
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
		public void update(AdoptaniMessageVO adoptaniMessageVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_STMT);
				
				     
				pstmt.setString(1, adoptaniMessageVO.getAdo_Ani_Mes());  
				pstmt.setString(2, adoptaniMessageVO.getAdo_Ani_Mes_No());  
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
		public void delete(String ado_Ani_Mes_No) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				
				pstmt.setString(1, ado_Ani_Mes_No);    
				
				
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
		public AdoptaniMessageVO findByPrimaryKey(String ado_Ani_Mes_No) {
			
			AdoptaniMessageVO adoptaniMessageVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				
				pstmt.setString(1, ado_Ani_Mes_No);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					//adoptaniVO也稱為Domain objects
					adoptaniMessageVO = new AdoptaniMessageVO();
					adoptaniMessageVO.setAdo_Ani_Mes_No(rs.getString("Ado_Ani_Mes_No"));
					adoptaniMessageVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
					adoptaniMessageVO.setMem_Id(rs.getString("Mem_Id"));
					adoptaniMessageVO.setAdo_Ani_Mes(rs.getString("Ado_Ani_Mes"));
					adoptaniMessageVO.setAdo_Ani_Mes_time(rs.getString("ado_Ani_Mes_time"));
				
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

			
			return adoptaniMessageVO;
		}
		
		
		@Override
		public List<AdoptaniMessageVO> getAll() {
			List<AdoptaniMessageVO> list = new ArrayList<AdoptaniMessageVO>();
			AdoptaniMessageVO adoptaniMessageVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//adoptaniVO也稱為Domain objects
					adoptaniMessageVO = new AdoptaniMessageVO();
					adoptaniMessageVO.setAdo_Ani_Mes_No(rs.getString("Ado_Ani_Mes_No"));
					adoptaniMessageVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
					adoptaniMessageVO.setMem_Id(rs.getString("Mem_Id"));
					adoptaniMessageVO.setAdo_Ani_Mes(rs.getString("Ado_Ani_Mes"));
					adoptaniMessageVO.setAdo_Ani_Mes_time(rs.getString("ado_Ani_Mes_time"));

					list.add(adoptaniMessageVO); // Store the row in the list
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
		public List<AdoptaniMessageVO> getOneAllMessage(String Adopt_Ani_Id) {
			List<AdoptaniMessageVO> list = new ArrayList<AdoptaniMessageVO>();
			AdoptaniMessageVO adoptaniMessageVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_ALL_STMT);
				pstmt.setString(1, Adopt_Ani_Id);
				
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//adoptaniVO也稱為Domain objects
					adoptaniMessageVO = new AdoptaniMessageVO();
					adoptaniMessageVO.setAdo_Ani_Mes_No(rs.getString("Ado_Ani_Mes_No"));
					adoptaniMessageVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
					adoptaniMessageVO.setMem_Id(rs.getString("Mem_Id"));
					adoptaniMessageVO.setAdo_Ani_Mes(rs.getString("Ado_Ani_Mes"));
					adoptaniMessageVO.setAdo_Ani_Mes_time(rs.getString("ado_Ani_Mes_time"));

					list.add(adoptaniMessageVO); // Store the row in the list
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


