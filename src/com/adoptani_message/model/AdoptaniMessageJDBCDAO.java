package com.adoptani_message.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class AdoptaniMessageJDBCDAO implements AdoptaniMessageDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO adopt_Ani_message (ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes) VALUES (adopt_Ani_message_Seq.NEXTVAL,?,?,sysdate,?)";
	
	private static final String GET_ALL_STMT = 
			"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes FROM adopt_Ani_message";
	
	private static final String GET_ONE_STMT = 
			"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes FROM adopt_Ani_message where ado_Ani_Mes_No = ?";
	
	private static final String GET_ONE_ALL_STMT = 
			"SELECT ado_Ani_Mes_No,adopt_Ani_Id,mem_Id,ado_Ani_Mes_time,ado_Ani_Mes FROM adopt_Ani_message where adopt_Ani_Id = ?";	
	
	private static final String DELETE = 
			"DELETE FROM adopt_Ani_message where ado_Ani_Mes_No = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE adopt_Ani_message set  ado_Ani_Mes=? where ado_Ani_Mes_No = ?";


	
	@Override
	public void insert(AdoptaniMessageVO adoptaniMessageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			    
			pstmt.setString(1, adoptaniMessageVO.getAdopt_Ani_Id());     
			pstmt.setString(2, adoptaniMessageVO.getMem_Id());  
			pstmt.setString(3, adoptaniMessageVO.getAdo_Ani_Mes());  

			
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			     
			pstmt.setString(1, adoptaniMessageVO.getAdo_Ani_Mes());  
			pstmt.setString(2, adoptaniMessageVO.getAdo_Ani_Mes_No());  
			
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, ado_Ani_Mes_No);    
			
			
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

	AdoptaniMessageJDBCDAO dao = new AdoptaniMessageJDBCDAO();

	// 新增
	AdoptaniMessageVO adoptaniMessageVO1 = new AdoptaniMessageVO();
	AdoptaniMessageVO adoptaniMessageVO2 = new AdoptaniMessageVO();
	
	adoptaniMessageVO1.setAdopt_Ani_Id("40000001");
	adoptaniMessageVO1.setMem_Id("10000001");
	adoptaniMessageVO1.setAdo_Ani_Mes("好可愛唷!!");
	
	
	dao.insert(adoptaniMessageVO1);
	System.out.println("成功插入");
	
	adoptaniMessageVO2.setAdopt_Ani_Id("40000001");
	adoptaniMessageVO2.setMem_Id("10000001");
	adoptaniMessageVO2.setAdo_Ani_Mes("棒棒!!");
	
	dao.insert(adoptaniMessageVO2);
	System.out.println("成功插入");
	// 修改
	
	AdoptaniMessageVO adoptaniMessageVO3 = new AdoptaniMessageVO();
	adoptaniMessageVO3.setAdo_Ani_Mes_No("42000001");
	adoptaniMessageVO3.setAdo_Ani_Mes("YEEEEEEE!!33");
	
	dao.update(adoptaniMessageVO3);
	System.out.println("成功修改");
	// 刪除
	dao.delete("40000004");
	System.out.println("成功刪除");
	// 查詢
	AdoptaniMessageVO adoptaniVO4 = dao.findByPrimaryKey("42000001");
	System.out.print(adoptaniVO4.getAdo_Ani_Mes_No() + ",");
	System.out.print(adoptaniVO4.getMem_Id() + ",");
	System.out.print(adoptaniVO4.getAdopt_Ani_Id() + ",");
	System.out.print(adoptaniVO4.getAdo_Ani_Mes_time() + ",");
	System.out.println(adoptaniVO4.getAdo_Ani_Mes() + ",");

	System.out.println("------------------------------------------------");
	
	//查詢
	List<AdoptaniMessageVO> list = dao.getAll();
	for (AdoptaniMessageVO aAdoptaniMessageVO : list) {
		System.out.print(aAdoptaniMessageVO.getAdo_Ani_Mes_No() + ",");
		System.out.print(aAdoptaniMessageVO.getMem_Id() + ",");
		System.out.print(aAdoptaniMessageVO.getAdopt_Ani_Id() + ",");
		System.out.print(aAdoptaniMessageVO.getAdo_Ani_Mes_time() + ",");
		System.out.print(aAdoptaniMessageVO.getAdo_Ani_Mes() + ",");
		System.out.println();
	
	System.out.println("------------------------------------------------");
	
	List<AdoptaniMessageVO> list2 = dao.getOneAllMessage("40000001");
	for (AdoptaniMessageVO aAdoptaniMessageVO2 : list2) {
		System.out.print(aAdoptaniMessageVO2.getAdo_Ani_Mes_No() + ",");
		System.out.print(aAdoptaniMessageVO2.getMem_Id() + ",");
		System.out.print(aAdoptaniMessageVO2.getAdopt_Ani_Id() + ",");
		System.out.print(aAdoptaniMessageVO2.getAdo_Ani_Mes_time() + ",");
		System.out.print(aAdoptaniMessageVO2.getAdo_Ani_Mes() + ",");
		System.out.println();
			}
		}
	}
}




