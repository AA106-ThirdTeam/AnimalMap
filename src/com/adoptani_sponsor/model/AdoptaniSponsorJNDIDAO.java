package com.adoptani_sponsor.model;

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





public class AdoptaniSponsorJNDIDAO implements AdoptaniSponsorDAO_interface{
	
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
			"INSERT INTO adopt_Ani_sponsor (ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time) VALUES (adopt_Ani_sponsor_Seq.NEXTVAL,?,?,?,?,sysdate)";
	private static final String GET_ALL_STMT = 
			"SELECT ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time FROM adopt_Ani_sponsor ORDER BY ado_Ani_Spo_No";
	
	private static final String GET_ONE_STMT = 
			"SELECT ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time FROM adopt_Ani_sponsor where ado_Ani_Spo_No = ?";
	
	private static final String GET_ONE_ALL_STMT = 
			"SELECT ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time FROM adopt_Ani_sponsor where adopt_Ani_Id = ? ORDER BY ado_Ani_Spo_time";	
	
	private static final String GET_ONE_ALL_Money_STMT = 
			"SELECT ado_Ani_Spo_money FROM adopt_Ani_sponsor where adopt_Ani_Id = ?";
	
	private static final String DELETE = 
			"DELETE FROM adopt_Ani_sponsor where ado_Ani_Spo_No = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE adopt_Ani_sponsor set   adopt_Ani_Id=?, mem_Id=?, ado_Ani_Spo_money=?, ado_Ani_Spo_thing=? where ado_Ani_Spo_No = ?";


	
	@Override
	public void insert(AdoptaniSponsorVO adoptaniSponsorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			
			
			pstmt.setString(1, adoptaniSponsorVO.getAdopt_Ani_Id());     
			pstmt.setString(2, adoptaniSponsorVO.getMem_Id());  
			pstmt.setInt(3, adoptaniSponsorVO.getAdo_Ani_Spo_money()); 
			pstmt.setString(4, adoptaniSponsorVO.getAdo_Ani_Spo_thing()); 

			
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
	public void update(AdoptaniSponsorVO adoptaniSponsorVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setString(1, adoptaniSponsorVO.getAdopt_Ani_Id());  
			pstmt.setString(2, adoptaniSponsorVO.getMem_Id());  
			pstmt.setInt(3, adoptaniSponsorVO.getAdo_Ani_Spo_money());  
			pstmt.setString(4, adoptaniSponsorVO.getAdo_Ani_Spo_thing());  
			pstmt.setString(5, adoptaniSponsorVO.getAdo_Ani_Spo_No());
			
			
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
	public void delete(String ado_Ani_Spo_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, ado_Ani_Spo_No);    
			
			
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
	public AdoptaniSponsorVO findByPrimaryKey(String ado_Ani_Spo_No) {
		
		AdoptaniSponsorVO adoptaniSponsorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, ado_Ani_Spo_No);
			
			rs = pstmt.executeQuery();
System.out.println(rs);
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
System.out.println(rs.getString("ado_Ani_Spo_No"));
				adoptaniSponsorVO = new AdoptaniSponsorVO();
				adoptaniSponsorVO.setAdo_Ani_Spo_No(rs.getString("ado_Ani_Spo_No"));
				adoptaniSponsorVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adoptaniSponsorVO.setMem_Id(rs.getString("mem_Id"));
				adoptaniSponsorVO.setAdo_Ani_Spo_money(rs.getInt("ado_Ani_Spo_money"));
				adoptaniSponsorVO.setAdo_Ani_Spo_thing(rs.getString("ado_Ani_Spo_thing"));
				adoptaniSponsorVO.setAdo_Ani_Spo_time(rs.getTimestamp("ado_Ani_Spo_time"));
			
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

		
		return adoptaniSponsorVO;
	}
	
	
	@Override
	public List<AdoptaniSponsorVO> getAll() {
		List<AdoptaniSponsorVO> list = new ArrayList<AdoptaniSponsorVO>();
		AdoptaniSponsorVO adoptaniSponsorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				//adoptaniVO也稱為Domain objects
				adoptaniSponsorVO = new AdoptaniSponsorVO();
				adoptaniSponsorVO.setAdo_Ani_Spo_No(rs.getString("ado_Ani_Spo_No"));
				adoptaniSponsorVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adoptaniSponsorVO.setMem_Id(rs.getString("mem_Id"));
				adoptaniSponsorVO.setAdo_Ani_Spo_money(rs.getInt("ado_Ani_Spo_money"));
				adoptaniSponsorVO.setAdo_Ani_Spo_thing(rs.getString("ado_Ani_Spo_thing"));
				adoptaniSponsorVO.setAdo_Ani_Spo_time(rs.getTimestamp("ado_Ani_Spo_time"));
			
				list.add(adoptaniSponsorVO); // Store the row in the list
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
	public List<AdoptaniSponsorVO> getOneAllSponsor(String Adopt_Ani_Id) {
		List<AdoptaniSponsorVO> list = new ArrayList<AdoptaniSponsorVO>();
		AdoptaniSponsorVO adoptaniSponsorVO = null;

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
				adoptaniSponsorVO = new AdoptaniSponsorVO();
				adoptaniSponsorVO.setAdo_Ani_Spo_No(rs.getString("ado_Ani_Spo_No"));
				adoptaniSponsorVO.setAdopt_Ani_Id(rs.getString("adopt_Ani_Id"));
				adoptaniSponsorVO.setMem_Id(rs.getString("mem_Id"));
				adoptaniSponsorVO.setAdo_Ani_Spo_money(rs.getInt("ado_Ani_Spo_money"));
				adoptaniSponsorVO.setAdo_Ani_Spo_thing(rs.getString("ado_Ani_Spo_thing"));
				adoptaniSponsorVO.setAdo_Ani_Spo_time(rs.getTimestamp("ado_Ani_Spo_time"));

				list.add(adoptaniSponsorVO); // Store the row in the list
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
	public Integer getOneAllSponsorMoney(String Adopt_Ani_Id) {
		List<AdoptaniSponsorVO> list = new ArrayList<AdoptaniSponsorVO>();
		AdoptaniSponsorVO adoptaniSponsorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int SponsorTotal = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_ALL_Money_STMT);
			pstmt.setString(1, Adopt_Ani_Id);
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()){
				SponsorTotal += rs.getInt("ado_Ani_Spo_money");
				
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
		return SponsorTotal;
	}	


}


