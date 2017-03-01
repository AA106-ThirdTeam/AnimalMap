package com.grpComm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.grpComm.model.GrpCommVO;

public class GrpCommDAO implements GrpCommDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_dream");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO grp_comment (grpComment_Id, grpComment_MemId, grpComment_GrpId, grpComment_content, grpComment_SendTime) "
			+ "VALUES (GRP_COMMENT_SEQ1.nextval, ?, ?, ?, sysdate)";
	
	private static final String DELETE_STMT = "DELETE FROM grp_comment where grpComment_Id = ?";
	
	private static final String UPDATE_STMT = "UPDATE grp_comment set grpComment_MemId=?, grpComment_GrpId=?, grpComment_content=?,"
			+ "grpComment_SendTime=?  where grpComment_Id=?";
	
	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT grpComment_Id, grpComment_MemId, grpComment_GrpId, grpComment_content,"
			+ "grpComment_SendTime FROM grp_comment where grpComment_id = ?";
	
	
	@Override
	public void insert(GrpCommVO grpCommVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			con.setAutoCommit(false);

			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, grpCommVO.getGrpComment_MemId());
			pstmt.setString(2, grpCommVO.getGrpComment_GrpId());
			pstmt.setString(3, grpCommVO.getGrpComment_content());
			
			pstmt.executeQuery();

			con.commit();
			con.setAutoCommit(true);
			// Handle any driver errors
		} catch (SQLException se) {

			try {
				con.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}

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
	public void update(GrpCommVO grpCommVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con= ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE_STMT);
								
			GrpCommVO oldGrpCommVO = findByPrimaryKey(grpCommVO.getGrpComment_Id());
			
			pstmt.setString(1, grpCommVO.getGrpComment_MemId());
			pstmt.setString(2, grpCommVO.getGrpComment_GrpId());
			pstmt.setString(3, grpCommVO.getGrpComment_content());
			pstmt.setTimestamp(4, oldGrpCommVO.getGrpComment_SendTime());
			
			pstmt.setString(5, grpCommVO.getGrpComment_Id());
									
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	public void delete(String grpComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();

			con.setAutoCommit(false);

			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setString(1, grpComment_Id);
//			System.out.println("DAO DELETE grpComment_Id= "+grpComment_Id);
			pstmt.executeUpdate();

			con.commit();
			con.setAutoCommit(true);
			// Handle any driver errors
		} catch (SQLException se) {

			try {
				con.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}

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

	
	public GrpCommVO findByPrimaryKey(String grpComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GrpCommVO grpCommVO = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, grpComment_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				grpCommVO = new GrpCommVO();
				grpCommVO.setGrpComment_Id(rs.getString(1));
				grpCommVO.setGrpComment_MemId(rs.getString(2));
				grpCommVO.setGrpComment_GrpId(rs.getString(3));
				grpCommVO.setGrpComment_content(rs.getString(4));
				grpCommVO.setGrpComment_SendTime(rs.getTimestamp(5));
			}

		} catch (SQLException e) {
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

		return grpCommVO;
	}

	
	public List<GrpCommVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
