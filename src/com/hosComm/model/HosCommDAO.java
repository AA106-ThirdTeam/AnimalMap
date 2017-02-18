package com.hosComm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hosPhoto.model.HosPhotoVO;

public class HosCommDAO implements HosCommDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO hos_comment (hosComment_Id, hosComment_MemId, hosComment_HosId, hosComment_content, hosComment_SendTime) "
			+ "VALUES (hos_comment_sq.nextval, ?, ?, ?, sysdate)";
	
	private static final String DELETE_STMT = "DELETE FROM hos_comment where hosComment_Id = ?";
	
	private static final String UPDATE_STMT = "UPDATE hos_comment set hosComment_MemId=?, hosComment_HosId=?, hosComment_content=?,"
			+ "hosComment_SendTime=?  where hosComment_Id=?";
	
	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT hosComment_Id, hosComment_MemId, hosComment_HosId, hosComment_content,"
			+ "hosComment_SendTime FROM hos_comment where hosComment_id = ?";
	
	
	@Override
	public void insert(HosCommVO hosCommVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			con.setAutoCommit(false);

			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, hosCommVO.getHosComment_MemId());
			pstmt.setString(2, hosCommVO.getHosComment_HosId());
			pstmt.setString(3, hosCommVO.getHosComment_content());
			
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
	public void update(HosCommVO hosCommVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con= ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE_STMT);
								
			HosCommVO oldHosCommVO = findByPrimaryKey(hosCommVO.getHosComment_Id());
			
			pstmt.setString(1, hosCommVO.getHosComment_MemId());
			pstmt.setString(2, hosCommVO.getHosComment_HosId());
			pstmt.setString(3, hosCommVO.getHosComment_content());
			pstmt.setTimestamp(4, oldHosCommVO.getHosComment_SendTime());
			
			pstmt.setString(5, hosCommVO.getHosComment_Id());
									
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
	public void delete(String hosComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();

			con.setAutoCommit(false);

			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setString(1, hosComment_Id);
//			System.out.println("DAO DELETE hosComment_Id= "+hosComment_Id);
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

	@Override
	public HosCommVO findByPrimaryKey(String hosComment_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HosCommVO hosCommVO = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, hosComment_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				hosCommVO = new HosCommVO();
				hosCommVO.setHosComment_Id(rs.getString(1));
				hosCommVO.setHosComment_MemId(rs.getString(2));
				hosCommVO.setHosComment_HosId(rs.getString(3));
				hosCommVO.setHosComment_content(rs.getString(4));
				hosCommVO.setHosComment_SendTime(rs.getTimestamp(5));
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

		return hosCommVO;
	}

	@Override
	public List<HosCommVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
