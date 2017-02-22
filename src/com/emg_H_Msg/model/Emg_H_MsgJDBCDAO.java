package com.emg_H_Msg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.model.EmpVO;



public class Emg_H_MsgJDBCDAO implements Emg_H_Msg_interface{
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106";
	String passwd = "aa106";
	
	private static final String INSERT_STMT = 
			"INSERT INTO emg_H_Msg (emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content) VALUES (emg_H_Msg_seq.NEXTVAL, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content FROM emg_H_Msg order by emg_H_Msg_Id";
		private static final String GET_ONE_STMT = 
			"SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content FROM emg_H_Msg  where emg_H_Msg_Id = ?";
		private static final String DELETE = 
			"DELETE FROM emg_H_Msg where emg_H_Msg_Id = ?";
		private static final String UPDATE = 
			"UPDATE emg_H_Msg set mem_Id=? ,emg_H_Id=?, emg_H_Msg_start=? , emg_H_Msg_content=? where emg_H_Msg_Id = ?";

	
	
	


	@Override
	public void insert(Emg_H_MsgVO emg_H_MsgVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, emg_H_MsgVO.getMem_Id());
			pstmt.setString(2, emg_H_MsgVO.getEmg_H_Id());
			pstmt.setTimestamp(3, emg_H_MsgVO.getEmg_H_Msg_start());
			pstmt.setString(4, emg_H_MsgVO.getEmg_H_Msg_content());
			
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());		
		 } catch(ClassNotFoundException ce){
			 ce.printStackTrace();
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
	public void update(Emg_H_MsgVO emg_H_MsgVO) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, emg_H_MsgVO.getMem_Id());
			pstmt.setString(2, emg_H_MsgVO.getEmg_H_Id());
			pstmt.setTimestamp(3, emg_H_MsgVO.getEmg_H_Msg_start());
			pstmt.setString(4, emg_H_MsgVO.getEmg_H_Msg_content());
			pstmt.setString(5, emg_H_MsgVO.getEmg_H_Msg_Id());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException  se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
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
	public void delete(String Emg_H_Msg_Id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, Emg_H_Msg_Id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
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
	public Emg_H_MsgVO  findByPrimaryKey(String Emg_H_Msg_Id) {
		// TODO Auto-generated method stub
		
		Emg_H_MsgVO emg_H_MsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, Emg_H_Msg_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {		
				
				emg_H_MsgVO = new Emg_H_MsgVO();				
				
				emg_H_MsgVO.setEmg_H_Msg_Id(rs.getString("emg_H_Msg_Id"));
				emg_H_MsgVO.setMem_Id(rs.getString("mem_Id"));
				emg_H_MsgVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_H_MsgVO.setEmg_H_Msg_start(rs.getTimestamp("emg_H_Msg_start"));
				emg_H_MsgVO.setEmg_H_Msg_content(rs.getString("emg_H_Msg_content"));
				
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
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
		return emg_H_MsgVO;
	}

	@Override
	public List<Emg_H_MsgVO> getAll() {
		// TODO Auto-generated method stub
		
		List<Emg_H_MsgVO> list = new ArrayList<Emg_H_MsgVO>();
		Emg_H_MsgVO emg_H_MsgVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs=pstmt.executeQuery();


			while (rs.next()) {
				
				emg_H_MsgVO = new Emg_H_MsgVO();
				
				emg_H_MsgVO.setEmg_H_Msg_Id(rs.getString("emg_H_Msg_Id"));
				emg_H_MsgVO.setMem_Id(rs.getString("mem_Id"));
				emg_H_MsgVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_H_MsgVO.setEmg_H_Msg_start(rs.getTimestamp("emg_H_Msg_start"));
				emg_H_MsgVO.setEmg_H_Msg_content(rs.getString("emg_H_Msg_content"));
				list.add(emg_H_MsgVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
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
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emg_H_MsgJDBCDAO dao = new Emg_H_MsgJDBCDAO();

		// insert
		
//		 Emg_H_MsgVO emg_H_MsgVO = new Emg_H_MsgVO();
//		 
//		 emg_H_MsgVO.setMem_Id("101");
//		 emg_H_MsgVO.setEmg_H_Id("50002");
//		 emg_H_MsgVO.setEmg_H_Msg_start(java.sql.Timestamp.valueOf("2017-02-09 00:00:00"));
//		 emg_H_MsgVO.setEmg_H_Msg_content("現在沒辦法過去~~~");		
//		 dao.insert(emg_H_MsgVO);
		
		//update
		 Emg_H_MsgVO emg_H_MsgVO2 = new Emg_H_MsgVO();
		 
		 emg_H_MsgVO2.setEmg_H_Msg_start(java.sql.Timestamp.valueOf("2017-02-10 00:00:00"));
		 emg_H_MsgVO2.setMem_Id("103");
		 emg_H_MsgVO2.setEmg_H_Id("50001");
		 emg_H_MsgVO2.setEmg_H_Msg_content("XXXXXXXXXXXXXXXXXXXXX");
		 emg_H_MsgVO2.setEmg_H_Msg_Id("55003");		 
		 dao.update(emg_H_MsgVO2);
		 
		 //delete
//		 dao.delete("55002");
		
		
		//get one 
//		Emg_H_MsgVO emg_H_MsgVO3 = dao.findByPrimaryKey("55003");
//		System.out.print(emg_H_MsgVO3.getEmg_H_Msg_Id() + ",");
//		System.out.print(emg_H_MsgVO3.getMem_Id() + ",");
//		System.out.print(emg_H_MsgVO3.getEmg_H_Id() + ",");
//		System.out.print(emg_H_MsgVO3.getEmg_H_Msg_start() + ",");
//		System.out.println(emg_H_MsgVO3.getEmg_H_Msg_content() );
		
//		System.out.println("---------------------------");
		
		
		// get all
//		List<Emg_H_MsgVO> list = dao.getAll();
//		for (Emg_H_MsgVO emg_H_Msg : list) {
//			System.out.print(emg_H_Msg.getEmg_H_Msg_Id() + ",");
//			System.out.print(emg_H_Msg.getMem_Id() + ",");
//			System.out.print(emg_H_Msg.getEmg_H_Id() + ",");
//			System.out.print(emg_H_Msg.getEmg_H_Msg_start() + ",");
//			System.out.print(emg_H_Msg.getEmg_H_Msg_content());
//			System.out.println();
//		}

	}
}

