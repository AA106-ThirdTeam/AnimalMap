package com.hosPhoto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class HosPhotoDAO implements HosPhotoDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_HOS_PHOTO_STMT ="INSERT INTO hos_photo (hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention) "
			+ "VALUES (hos_photo_sq.nextval, ?, ?, ?, ?, ?)";
	
	private static final String DELETE = "DELETE FROM hos_photo where hosPhoto_Id = ?";
	
	private static final String UPDATE_DISPLAY_PHOTO_0 = "UPDATE hos_photo set isDisp_HosPhoto='0' where hosPhoto_HosId=?";
	private static final String UPDATE_DISPLAY_PHOTO_1 = "UPDATE hos_photo set isDisp_HosPhoto='1' where hosPhoto_Id=?";

	@Override
	public void insert(String hos_Id, List<HosPhotoVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			System.out.println(hos_Id);
			
			con = ds.getConnection();
			
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(INSERT_HOS_PHOTO_STMT);
			
			
			for(HosPhotoVO hosPhotoVO : list){
												
				pstmt.setString(1, hos_Id);
				pstmt.setBytes(2, hosPhotoVO.getHosPhoto_photo());
				pstmt.setString(3, hosPhotoVO.getIsDisp_HosPhoto());
				pstmt.setString(4, hosPhotoVO.getHosPhoto_name());
				pstmt.setString(5, hosPhotoVO.getHosPhoto_extention());

				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
		
		
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
	public void update(HosPhotoVO hosPhotoVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String hosPhoto_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con= ds.getConnection();
			
			con.setAutoCommit(false);
			
			
			
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1,hosPhoto_Id);
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
	public HosPhotoVO findByPrimaryKey(String hosPhoto_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HosPhotoVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setDisplayPhoto(String hosPhoto_Id, String hosPhoto_HosId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con= ds.getConnection();
			
			con.setAutoCommit(false);
			
			
			
			pstmt = con.prepareStatement(UPDATE_DISPLAY_PHOTO_0);
			pstmt.setString(1,hosPhoto_HosId);
			pstmt.executeUpdate();
													
			pstmt = con.prepareStatement(UPDATE_DISPLAY_PHOTO_1);
			pstmt.setString(1,hosPhoto_Id);
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
	
	
}
