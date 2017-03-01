package com.offiMsg.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OffiMsgDAO implements OffiMsgDAO_interface{

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
	//測試版的offiMsg_empId(發布員工的欄位名稱不一樣)	
		private static final String INSERT_STMT = 
				"INSERT INTO offiMsg (offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,offiMsg_Date) VALUES (offiMsg_seq1.NEXTVAL, ?, ?, ?, ?)";
			private static final String GET_ALL_STMT = 
				"SELECT offiMsg_Id,offiMsg_empId,offiMsg_Title"
				+ ",offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date"
				+ " FROM offiMsg order by offiMsg_Id";
			private static final String GET_ONE_STMT = 
				"SELECT offiMsg_Id,offiMsg_empId,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date FROM offiMsg where offiMsg_Id = ?";
			private static final String DELETE = 
				"DELETE FROM offiMsg where offiMsg_Id = ?";
			private static final String UPDATE = 
				"UPDATE offiMsg set offiMsg_empId=?, offiMsg_Title=?, offiMsg_Content=?, offiMsg_Date=? where offiMsg_Id = ?";
//正確版欄位名稱
//			private static final String INSERT_STMT = 
//					"INSERT INTO offiMsg (offiMsg_Id,emp_No,offiMsg_Title,offiMsg_Content,offiMsg_Date) VALUES (offiMsg_seq1.NEXTVAL, ?, ?, ?, ?)";
//				private static final String GET_ALL_STMT = 
//					"SELECT offiMsg_Id,emp_No,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date"
//					+ "FROM offiMsg order by offiMsg_Id";
//				private static final String GET_ONE_STMT = 
//					"SELECT offiMsg_Id,emp_No,offiMsg_Title,offiMsg_Content,to_char(offiMsg_Date,'yyyy-mm-dd') offiMsg_Date FROM offiMsg where offiMsg_Id = ?";
//				private static final String DELETE = 
//					"DELETE FROM offiMsg where offiMsg_Id = ?";
//				private static final String UPDATE = 
//					"UPDATE offiMsg set emp_No=?, offiMsg_Title=?, offiMsg_Content=?, offiMsg_Date=? where offiMsg_Id = ?";
			
			@Override
			public void insert(OffiMsgVO offiMsgVO) {
			
				Connection con = null;
				PreparedStatement pstmt = null;
				
				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(INSERT_STMT);

					pstmt.setString(1, offiMsgVO.getOffiMsg_empId());
					pstmt.setString(2, offiMsgVO.getOffiMsg_Title());
					pstmt.setString(3, offiMsgVO.getOffiMsg_Content());
					pstmt.setDate(4, offiMsgVO.getOffiMsg_Date());
					
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
			public void update(OffiMsgVO offiMsgVO) {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE);

					pstmt.setString(1, offiMsgVO.getOffiMsg_empId());
					pstmt.setString(2, offiMsgVO.getOffiMsg_Title());
					pstmt.setString(3, offiMsgVO.getOffiMsg_Content());
					pstmt.setDate(4, offiMsgVO.getOffiMsg_Date());
					pstmt.setString(5, offiMsgVO.getOffiMsg_Id());

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
			public void delete(String offiMsg_Id) {
				
				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(DELETE);

					pstmt.setString(1, offiMsg_Id);

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
			public OffiMsgVO findByPrimaryKey(String offiMsg_Id) {
				
				OffiMsgVO offiMsgVO = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setString(1, offiMsg_Id);

					rs = pstmt.executeQuery();

					while (rs.next()) {
						// offiMsgVO 也稱為 Domain objects
						offiMsgVO = new OffiMsgVO();
						offiMsgVO.setOffiMsg_Id(rs.getString("offiMsg_Id"));
						offiMsgVO.setOffiMsg_empId(rs.getString("offiMsg_empId"));
						offiMsgVO.setOffiMsg_Title(rs.getString("offiMsg_Title"));
						offiMsgVO.setOffiMsg_Content(rs.getString("offiMsg_Content"));
						offiMsgVO.setOffiMsg_Date(rs.getDate("offiMsg_Date"));
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
				return offiMsgVO;
			}
			@Override
			public List<OffiMsgVO> getAll() {
				
				List<OffiMsgVO> list = new ArrayList<OffiMsgVO>();
				OffiMsgVO offiMsgVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						// offiMsgVO 也稱為 Domain objects
						offiMsgVO = new OffiMsgVO();
						offiMsgVO.setOffiMsg_Id(rs.getString("offiMsg_Id"));
						offiMsgVO.setOffiMsg_empId(rs.getString("offiMsg_empId"));
						offiMsgVO.setOffiMsg_Title(rs.getString("offiMsg_Title"));
						offiMsgVO.setOffiMsg_Content(rs.getString("offiMsg_Content"));
						offiMsgVO.setOffiMsg_Date(rs.getDate("offiMsg_Date"));
						list.add(offiMsgVO); // Store the row in the list
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
