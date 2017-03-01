package com.post_Response.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Post_ResponseDAO implements Post_ResponseDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO post_Response (res_Id,mem_Id,post_Id,post_Response_content,post_time,post_Response_upDate) VALUES ('res'||'-'||LPAD(to_char(post_Response_seq1.nextval),4,'0'), ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT res_Id,mem_Id,post_Id,post_Response_content"
			+ ",to_char(post_time,'yyyy-mm-dd') post_time,to_char"
			+ "(post_Response_upDate,'yyyy-mm-dd') "
			+ "post_Response_upDate "
			+ "FROM post_Response "
			+ "order by res_Id DESC";
	private static final String GET_ONE_STMT = "SELECT res_Id,mem_Id,post_Id,post_Response_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(post_Response_upDate,'yyyy-mm-dd') post_Response_upDate FROM post_Response where res_Id = ?";
	private static final String DELETE = "DELETE FROM post_Response where res_Id = ?";
	private static final String UPDATE = "UPDATE post_Response set mem_Id=?, post_Id=?, post_Response_content=?, post_time=?, post_Response_upDate=? where res_Id = ?";

	private static final String GETSAME_ID_STMT = 
			"SELECT res_Id,mem_Id,post_Id,post_Response_content"
			+ ",to_char(post_time,'yyyy-mm-dd') post_time,to_char"
			+ "(post_Response_upDate,'yyyy-mm-dd') "
			+ "post_Response_upDate "
			+ "FROM post_Response "
			+"where post_Id=? "
			+ " order by res_Id DESC";
	@Override
	public void insert(Post_ResponseVO post_ResponseVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, post_ResponseVO.getMem_Id());
			pstmt.setString(2, post_ResponseVO.getPost_Id());
			pstmt.setString(3, post_ResponseVO.getPost_Response_content());
			pstmt.setDate(4, post_ResponseVO.getPost_time());
			pstmt.setDate(5, post_ResponseVO.getPost_Response_upDate());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(Post_ResponseVO post_ResponseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, post_ResponseVO.getMem_Id());
			pstmt.setString(2, post_ResponseVO.getPost_Id());
			pstmt.setString(3, post_ResponseVO.getPost_Response_content());
			pstmt.setDate(4, post_ResponseVO.getPost_time());
			pstmt.setDate(5, post_ResponseVO.getPost_Response_upDate());
			pstmt.setString(6, post_ResponseVO.getRes_Id());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(String res_Id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, res_Id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public Post_ResponseVO findByPrimaryKey(String res_Id) {

		Post_ResponseVO post_ResponseVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, res_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// post_ResponseVO 也稱為 Domain objects
				post_ResponseVO = new Post_ResponseVO();
				post_ResponseVO.setRes_Id(rs.getString("res_Id"));
				post_ResponseVO.setMem_Id(rs.getString("mem_Id"));
				post_ResponseVO.setPost_Id(rs.getString("post_Id"));
				post_ResponseVO.setPost_Response_content(rs.getString("post_Response_content"));
				post_ResponseVO.setPost_time(rs.getDate("post_time"));
				post_ResponseVO.setPost_Response_upDate(rs.getDate("post_Response_upDate"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		return post_ResponseVO;
	}

	@Override
	public List<Post_ResponseVO> getAll() {

		List<Post_ResponseVO> list = new ArrayList<Post_ResponseVO>();
		Post_ResponseVO post_ResponseVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// post_ResponseVO 也稱為 Domain objects
				post_ResponseVO = new Post_ResponseVO();
				post_ResponseVO.setRes_Id(rs.getString("res_Id"));
				post_ResponseVO.setMem_Id(rs.getString("mem_Id"));
				post_ResponseVO.setPost_Id(rs.getString("post_Id"));
				post_ResponseVO.setPost_Response_content(rs.getString("post_Response_content"));
				post_ResponseVO.setPost_time(rs.getDate("post_time"));
				post_ResponseVO.setPost_Response_upDate(rs.getDate("post_Response_upDate"));
				list.add(post_ResponseVO); // Store the row in the list
			}
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<Post_ResponseVO> getSameResId(String post_Id) {
		List<Post_ResponseVO> list = new ArrayList<Post_ResponseVO>();
		Post_ResponseVO post_ResponseVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GETSAME_ID_STMT);
			
			pstmt.setString(1,post_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// post_ResponseVO 也稱為 Domain objects
				post_ResponseVO = new Post_ResponseVO();
				post_ResponseVO.setRes_Id(rs.getString("res_Id"));
				post_ResponseVO.setMem_Id(rs.getString("mem_Id"));
				post_ResponseVO.setPost_Id(rs.getString("post_Id"));
				post_ResponseVO.setPost_Response_content(rs.getString("post_Response_content"));
				post_ResponseVO.setPost_time(rs.getDate("post_time"));
				post_ResponseVO.setPost_Response_upDate(rs.getDate("post_Response_upDate"));
				list.add(post_ResponseVO); // Store the row in the list
			}
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
