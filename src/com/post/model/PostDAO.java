package com.post.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.post_Response.model.Post_ResponseVO;

public class PostDAO implements PostDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();	//JNDI訪問環境
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");//JNDI的名稱
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO post (post_Id,mem_Id,post_class,post_class_Id,post_title,post_content,post_time,post_upDate,post_resNum) VALUES (post_seq1.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT post_Id,mem_Id,post_class,post_class_Id,post_title,post_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(post_upDate,'yyyy-mm-dd') post_upDate,post_resNum FROM post order by post_Id";
	private static final String GET_ONE_STMT = "SELECT post_Id,mem_Id,post_class,post_class_Id,post_title,post_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(post_upDate,'yyyy-mm-dd') post_upDate,post_resNum FROM post where post_Id = ?";
	private static final String GETPost_Responses_ByPost_Id_STMT = "SELECT res_Id,mem_Id,post_Id,post_Response_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(post_Response_upDate,'yyyy-mm-dd') post_Response_upDate FROM post_Response where post_Id = ? order by res_Id";
	//post_Response多方
	private static final String DELETE_POST_RESPONSEs = "DELETE FROM post_Response where post_Id= ?";
	private static final String DELETE_POST = "DELETE FROM post where post_Id = ?";

	private static final String UPDATE = "UPDATE post set mem_Id=?, post_class=?, post_class_Id=?, post_title=?, post_content=?, post_time=?, post_upDate=?, post_resNum=? where post_Id = ?";
//insert新增
	@Override
	public void insert(PostVO postVO) {
		Connection con = null;	//連線
		PreparedStatement pstmt = null;	//Java.sql的下一個街口,執行sql查詢語句

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, postVO.getMem_Id());
			pstmt.setString(2, postVO.getPost_class());
			pstmt.setString(3, postVO.getPost_class_Id());
			pstmt.setString(4, postVO.getPost_title());
			pstmt.setString(5, postVO.getPost_content());
			pstmt.setDate(6, postVO.getPost_time());
			pstmt.setDate(7, postVO.getPost_upDate());
			pstmt.setInt(8, postVO.getPost_resNum());

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
	public void update(PostVO postVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, postVO.getMem_Id());
			pstmt.setString(2, postVO.getPost_class());
			pstmt.setString(3, postVO.getPost_class_Id());
			pstmt.setString(4, postVO.getPost_title());
			pstmt.setString(5, postVO.getPost_content());
			pstmt.setDate(6, postVO.getPost_time());
			pstmt.setDate(7, postVO.getPost_upDate());
			pstmt.setInt(8, postVO.getPost_resNum());
			pstmt.setString(9, postVO.getPost_Id());

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
	public void delete(String post_Id) {
		int updateCount_POST_RESPONSEs = 0;	

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);

			// 先刪除回覆留言
			pstmt = con.prepareStatement(DELETE_POST_RESPONSEs);
			pstmt.setString(1, post_Id);
			updateCount_POST_RESPONSEs = pstmt.executeUpdate();
			// 再刪除文章
			pstmt = con.prepareStatement(DELETE_POST);
			pstmt.setString(1, post_Id);
			pstmt.executeUpdate();

			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除回覆文章編號" + post_Id + "時,共有文章" + updateCount_POST_RESPONSEs + "回覆同時被刪除");
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public PostVO findByPrimaryKey(String post_Id) {
		// TODO Auto-generated method stub
		PostVO postVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, post_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// postVO 也稱為 Domain objects
				postVO = new PostVO();
				postVO.setPost_Id(rs.getString("post_Id"));
				postVO.setMem_Id(rs.getString("mem_Id"));
				postVO.setPost_class(rs.getString("post_class"));
				postVO.setPost_class_Id(rs.getString("post_class_Id"));
				postVO.setPost_title(rs.getString("post_title"));
				postVO.setPost_content(rs.getString("post_content"));
				postVO.setPost_time(rs.getDate("post_time"));
				postVO.setPost_upDate(rs.getDate("post_upDate"));
				postVO.setPost_resNum(rs.getInt("post_resNum"));
			}

			// Handle any SQL errors
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
		return postVO;
	}

	@Override
	public List<PostVO> getAll() {
		List<PostVO> list = new ArrayList<PostVO>();
		PostVO postVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				postVO = new PostVO();
				postVO.setPost_Id(rs.getString("post_Id"));
				postVO.setMem_Id(rs.getString("mem_Id"));
				postVO.setPost_class(rs.getString("post_class"));
				postVO.setPost_class_Id(rs.getString("post_class_Id"));
				postVO.setPost_title(rs.getString("post_title"));
				postVO.setPost_content(rs.getString("post_content"));
				postVO.setPost_time(rs.getDate("post_time"));
				postVO.setPost_upDate(rs.getDate("post_upDate"));
				postVO.setPost_resNum(rs.getInt("post_resNum"));
				list.add(postVO); // Store the row in the list
			}
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public Set<Post_ResponseVO> getPost_ResponsesByPost_Id(String post_Id) {
		// TODO Auto-generated method stub
		Set<Post_ResponseVO> set = new LinkedHashSet<Post_ResponseVO>();
		Post_ResponseVO post_ResponseVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GETPost_Responses_ByPost_Id_STMT);
			pstmt.setString(1, post_Id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				post_ResponseVO = new Post_ResponseVO();
				post_ResponseVO.setRes_Id(rs.getString("res_Id"));
				post_ResponseVO.setMem_Id(rs.getString("mem_Id"));
				post_ResponseVO.setPost_Id(rs.getString("post_Id"));
				post_ResponseVO.setPost_Response_content(rs.getString("post_Response_content"));
				post_ResponseVO.setPost_time(rs.getDate("post_time"));
				post_ResponseVO.setPost_Response_upDate(rs.getDate("post_Response_upDate"));
				set.add(post_ResponseVO); // Store the row in the vector
			}
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return set;
	}

}
