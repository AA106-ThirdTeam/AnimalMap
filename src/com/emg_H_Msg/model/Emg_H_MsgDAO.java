package com.emg_H_Msg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Emg_H_MsgDAO implements Emg_H_Msg_interface{
	
	
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
			"INSERT INTO emg_H_Msg (emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start"
			+ ",emg_H_Msg_content) VALUES (emg_H_Msg_seq1.NEXTVAL, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content FROM emg_H_Msg order by emg_H_Msg_Id desc";
		private static final String GET_ONE_STMT = 
			"SELECT emg_H_Msg_Id,mem_Id,emg_H_Id,emg_H_Msg_start,emg_H_Msg_content FROM emg_H_Msg  where emg_H_Msg_Id = ?";
		private static final String DELETE = 
			"DELETE FROM emg_H_Msg where emg_H_Msg_Id = ?";
		private static final String UPDATE = 
				"UPDATE emg_H_Msg set emg_H_Id=?, emg_H_Msg_start=? , emg_H_Msg_content=? where emg_H_Msg_Id = ?";

	
	

	@Override
	public void insert(Emg_H_MsgVO emg_H_MsgVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			// 會員ID 可能要綁定 主鍵才能使用     問題會顯示 找不到PK ，SQL 語法上先刪掉
			pstmt.setString(1, emg_H_MsgVO.getMem_Id());
			
			pstmt.setString(1, emg_H_MsgVO.getEmg_H_Id());
			pstmt.setTimestamp(2, emg_H_MsgVO.getEmg_H_Msg_start());
			pstmt.setString(3, emg_H_MsgVO.getEmg_H_Msg_content());
			pstmt.setString(4, emg_H_MsgVO.getEmg_H_Msg_Id());
			

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
	public void delete(String Emg_H_Msg_Id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, Emg_H_Msg_Id);

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
	public Emg_H_MsgVO  findByPrimaryKey(String Emg_H_Msg_Id) {
		// TODO Auto-generated method stub
		
		Emg_H_MsgVO emg_H_MsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

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
