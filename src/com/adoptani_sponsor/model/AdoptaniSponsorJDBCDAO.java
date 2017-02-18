package com.adoptani_sponsor.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class AdoptaniSponsorJDBCDAO implements AdoptaniSponsorDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO adopt_Ani_sponsor (ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time) VALUES (adopt_Ani_sponsor_Seq.NEXTVAL,?,?,?,?,sysdate)";
	private static final String GET_ALL_STMT = 
			"SELECT ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time FROM adopt_Ani_sponsor";
	
	private static final String GET_ONE_STMT = 
			"SELECT ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time FROM adopt_Ani_sponsor where ado_Ani_Spo_No = ?";
	
	private static final String GET_ONE_ALL_STMT = 
			"SELECT ado_Ani_Spo_No, adopt_Ani_Id, mem_Id, ado_Ani_Spo_money, ado_Ani_Spo_thing, ado_Ani_Spo_time FROM adopt_Ani_sponsor where adopt_Ani_Id = ?";	
	
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			
			pstmt.setString(1, adoptaniSponsorVO.getAdopt_Ani_Id());     
			pstmt.setString(2, adoptaniSponsorVO.getMem_Id());  
			pstmt.setInt(3, adoptaniSponsorVO.getAdo_Ani_Spo_money()); 
			pstmt.setString(4, adoptaniSponsorVO.getAdo_Ani_Spo_thing()); 

			
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
	public void update(AdoptaniSponsorVO adoptaniSponsorVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setString(1, adoptaniSponsorVO.getAdopt_Ani_Id());  
			pstmt.setString(2, adoptaniSponsorVO.getMem_Id());  
			pstmt.setInt(3, adoptaniSponsorVO.getAdo_Ani_Spo_money());  
			pstmt.setString(4, adoptaniSponsorVO.getAdo_Ani_Spo_thing());  
			pstmt.setString(5, adoptaniSponsorVO.getAdo_Ani_Spo_No());
			
			
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
	public void delete(String ado_Ani_Spo_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, ado_Ani_Spo_No);    
			
			
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
	public AdoptaniSponsorVO findByPrimaryKey(String ado_Ani_Spo_No) {
		
		AdoptaniSponsorVO adoptaniSponsorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, ado_Ani_Spo_No);
			
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
	public List<AdoptaniSponsorVO> getOneAllSponsor(String Adopt_Ani_Id) {
		List<AdoptaniSponsorVO> list = new ArrayList<AdoptaniSponsorVO>();
		AdoptaniSponsorVO adoptaniSponsorVO = null;

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

	AdoptaniSponsorJDBCDAO dao = new AdoptaniSponsorJDBCDAO();

	// 新增
	AdoptaniSponsorVO adoptaniSponsorVO1 = new AdoptaniSponsorVO();
	AdoptaniSponsorVO adoptaniSponsorVO2 = new AdoptaniSponsorVO();
	
	adoptaniSponsorVO1.setAdopt_Ani_Id("40000001");
	adoptaniSponsorVO1.setMem_Id("10000001");
	adoptaniSponsorVO1.setAdo_Ani_Spo_money(10000);
	adoptaniSponsorVO1.setAdo_Ani_Spo_thing("高級狗糧");
	
	dao.insert(adoptaniSponsorVO1);
	System.out.println("成功插入");
	
	adoptaniSponsorVO2.setAdopt_Ani_Id("40000021");
	adoptaniSponsorVO2.setMem_Id("10000002");
	adoptaniSponsorVO2.setAdo_Ani_Spo_money(9999);
	adoptaniSponsorVO2.setAdo_Ani_Spo_thing("高麗菜");
	dao.insert(adoptaniSponsorVO2);
	System.out.println("成功插入");
	// 修改
	
	AdoptaniSponsorVO adoptaniSponsorVO3 = new AdoptaniSponsorVO();
	adoptaniSponsorVO3.setAdopt_Ani_Id("40000021");
	adoptaniSponsorVO3.setMem_Id("10000003");
	adoptaniSponsorVO3.setAdo_Ani_Spo_money(99999);
	adoptaniSponsorVO3.setAdo_Ani_Spo_thing("高麗菜2");
	adoptaniSponsorVO3.setAdo_Ani_Spo_No("43000001");
	
	dao.update(adoptaniSponsorVO3);
	System.out.println("成功修改");
	// 刪除
	dao.delete("43000001");
	System.out.println("成功刪除");
	
	System.out.println("---------------------findByPrimaryKey---------------------------");
	// 查詢
	AdoptaniSponsorVO adoptaniSponsorVO4 = dao.findByPrimaryKey("43000021");
	System.out.print(adoptaniSponsorVO4.getAdo_Ani_Spo_No() + ",");
	System.out.print(adoptaniSponsorVO4.getMem_Id() + ",");
	System.out.print(adoptaniSponsorVO4.getAdopt_Ani_Id() + ",");
	System.out.print(adoptaniSponsorVO4.getAdo_Ani_Spo_time() + ",");
	System.out.println(adoptaniSponsorVO4.getAdo_Ani_Spo_money() + ",");
	System.out.println(adoptaniSponsorVO4.getAdo_Ani_Spo_thing() + ",");

	System.out.println("----------------------getAll--------------------------");
	
	//查詢
	List<AdoptaniSponsorVO> list = dao.getAll();
	for (AdoptaniSponsorVO adoptaniSponsorVO5 : list) {
		System.out.print(adoptaniSponsorVO5.getAdo_Ani_Spo_No() + ",");
		System.out.print(adoptaniSponsorVO5.getMem_Id() + ",");
		System.out.print(adoptaniSponsorVO5.getAdopt_Ani_Id() + ",");
		System.out.print(adoptaniSponsorVO5.getAdo_Ani_Spo_time() + ",");
		System.out.println(adoptaniSponsorVO5.getAdo_Ani_Spo_money() + ",");
		System.out.println(adoptaniSponsorVO5.getAdo_Ani_Spo_thing() + ",");
		System.out.println();
	}
	System.out.println("-------------------getOneAllSponsor----------------------------");
	
	List<AdoptaniSponsorVO> list2 = dao.getOneAllSponsor("40000001");
	for (AdoptaniSponsorVO adoptaniSponsorVO6 : list2) {
		System.out.print(adoptaniSponsorVO6.getAdo_Ani_Spo_No() + ",");
		System.out.print(adoptaniSponsorVO6.getMem_Id() + ",");
		System.out.print(adoptaniSponsorVO6.getAdopt_Ani_Id() + ",");
		System.out.print(adoptaniSponsorVO6.getAdo_Ani_Spo_time() + ",");
		System.out.println(adoptaniSponsorVO6.getAdo_Ani_Spo_money() + ",");
		System.out.println(adoptaniSponsorVO6.getAdo_Ani_Spo_thing() + ",");
		System.out.println();
			
		}
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
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_ALL_Money_STMT);
				pstmt.setString(1, Adopt_Ani_Id);
				
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					SponsorTotal += rs.getInt("ado_Ani_Spo_money");
					
				}
				// Handle any driver errors
			} catch (SQLException | ClassNotFoundException se) {
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




