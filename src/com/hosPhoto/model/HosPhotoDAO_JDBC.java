package com.hosPhoto.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hos.model.HosVO;

public class HosPhotoDAO_JDBC implements HosPhotoDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";
	
//	hosPhoto_Id
//	hosPhoto_HosId
//	hosPhoto_photo
//	isDisp_HosPhoto
//	hosPhoto_name
//	hosPhoto_extention	
	
	
	

	private static final String INSERT_STMT = "INSERT INTO hos_photo (hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention "
			+ "FROM hos_photo order by hosPhoto_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention "
			+ "FROM hos_photo where hosPhoto_id = ?";

	private static final String DELETE = "DELETE FROM hos_photo where hosPhoto_Id = ?";
	
	private static final String UPDATE = "UPDATE hos_photo set  hosPhoto_HosId=?, hosPhoto_photo=?, isDisp_HosPhoto=?, hosPhoto_name=?, hosPhoto_extention=?  where hosPhoto_Id=?";
	
	private static final String INSERT_HOS_PHOTO_STMT ="INSERT INTO hos_photo (hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention) "
			+ "VALUES (hos_photo_sq.nextval, ?, ?, ?, ?, ?) where hos_Id = ?";

	
	
	@Override
	public void insert(String hos_Id, List<HosPhotoVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);

			pstmt = con.prepareStatement(INSERT_HOS_PHOTO_STMT);
			
			
			for(HosPhotoVO hosPhotoVO : list){
												
				pstmt.setString(1, hosPhotoVO.getHosPhoto_HosId());
				pstmt.setBytes(2, hosPhotoVO.getHosPhoto_photo());
				pstmt.setString(3, hosPhotoVO.getIsDisp_HosPhoto());
				pstmt.setString(4, hosPhotoVO.getHosPhoto_name());
				pstmt.setString(5, hosPhotoVO.getHosPhoto_extention());
				pstmt.setString(6, hos_Id);
				
				
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
		
		
			con.commit();
			con.setAutoCommit(true);
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
						
			pstmt.setString(1, hosPhotoVO.getHosPhoto_HosId());
			pstmt.setBytes(2, hosPhotoVO.getHosPhoto_photo());
			pstmt.setString(3, hosPhotoVO.getIsDisp_HosPhoto());
			pstmt.setString(4, hosPhotoVO.getHosPhoto_name());
			pstmt.setString(5, hosPhotoVO.getHosPhoto_extention());
			pstmt.setString(6, hosPhotoVO.getHosPhoto_Id());
			
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
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
	public void delete(String hosPhoto_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			
			con.setAutoCommit(false);
			
			
			
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1,1);
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HosPhotoVO hosPhotoVO = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, hosPhoto_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				hosPhotoVO = new HosPhotoVO();
				hosPhotoVO.setHosPhoto_Id(rs.getString(1));
				hosPhotoVO.setHosPhoto_HosId(rs.getString(2));
				hosPhotoVO.setHosPhoto_photo(rs.getBytes(3));
				hosPhotoVO.setIsDisp_HosPhoto(rs.getString(4));
				hosPhotoVO.setHosPhoto_name(rs.getString(5));
				hosPhotoVO.setHosPhoto_extention(rs.getString(6));
		

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		return hosPhotoVO;
	}

	@Override
	public List<HosPhotoVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HosPhotoVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				HosPhotoVO hosPhotoVO = new HosPhotoVO();

				hosPhotoVO.setHosPhoto_Id(rs.getString(1));
				hosPhotoVO.setHosPhoto_HosId(rs.getString(2));
				hosPhotoVO.setHosPhoto_photo(rs.getBytes(3));
				hosPhotoVO.setIsDisp_HosPhoto(rs.getString(4));
				hosPhotoVO.setHosPhoto_name(rs.getString(5));
				hosPhotoVO.setHosPhoto_extention(rs.getString(6));
	
				list.add(hosPhotoVO);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
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

		return list;
	}

	public static void main(String args[]) {

// test INSERT=============================================================
		HosPhotoDAO_JDBC hosPhotoDao = new HosPhotoDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Date date =new Date(cal.getTimeInMillis());
		
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
		 
//		 byte[] b = null;
//		 
//		 File f = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\grpImage\\1.jpg");
//		 
//		 try{
//		 FileInputStream fis = new FileInputStream(f);
//		 BufferedInputStream bis = new BufferedInputStream(fis);
//		 b = new byte[bis.available()];
//		 bis.read(b);
//		 }catch(Exception e){e.printStackTrace();}
//		 
//		 HosPhotoVO hosPhotoVO = new HosPhotoVO();
//		 
//		 hosPhotoVO.setHosPhoto_Id("1");
//		 hosPhotoVO.setHosPhoto_HosId("1");
//		 hosPhotoVO.setHosPhoto_photo(b);
//		 hosPhotoVO.setIsDisp_HosPhoto("1");
//		 hosPhotoVO.setHosPhoto_name("º}«G¶Ü");
//		 hosPhotoVO.setHosPhoto_extention(".jpeg");
//
//		 
//
//		 hosPhotoDao.insert(hosPhotoVO);
		 
//test UPDATE=========================================================
		 
		
//		 byte[] b2 = null;
//		 File f2 = new
//		 File("C:\\AA106_WebApp\\eclipse_WTP_workspace\\AA106G3\\WebContent\\group\\grpImage\\avatar.jpg");
//		 try{
//			 FileInputStream fis = new FileInputStream(f2);
//			 BufferedInputStream bis = new BufferedInputStream(fis);
//			 b2 = new byte[bis.available()];
//			 bis.read(b2);
//			 }catch(Exception e){e.printStackTrace();}
//		
//		 HosPhotoVO hosPhotoVO2 = new HosPhotoVO();
//		 
//		  hosPhotoVO2.setHosPhoto_Id("1");
//		 hosPhotoVO2.setHosPhoto_HosId("546");
//		 hosPhotoVO2.setHosPhoto_photo(b2);
//		 hosPhotoVO2.setIsDisp_HosPhoto("0");
//		 hosPhotoVO2.setHosPhoto_name("º}«G");
//		 hosPhotoVO2.setHosPhoto_extention(".jpeg");
//
//		
//		 hosPhotoDao.update(hosPhotoVO2);
		 
// test GETALL=========================================================
		 
		 
//		List<HosPhotoVO> list = hosPhotoDao.getAll();
//		for (HosPhotoVO g : list) {
//
//			System.out.println(g.getHosPhoto_Id());
//			System.out.println(g.getHosPhoto_HosId());
//			System.out.println(g.getHosPhoto_photo());
//			System.out.println(g.getIsDisp_HosPhoto());
//			System.out.println(g.getHosPhoto_name());
//			System.out.println(g.getHosPhoto_extention());
//		}
//			
//test findByPrimaryKey=============================================
			HosPhotoVO g = new HosPhotoVO();
		    g = hosPhotoDao.findByPrimaryKey("1");
			
			System.out.println(g.getHosPhoto_Id());
			System.out.println(g.getHosPhoto_HosId());
			System.out.println(g.getHosPhoto_photo());
			System.out.println(g.getIsDisp_HosPhoto());
			System.out.println(g.getHosPhoto_name());
			System.out.println(g.getHosPhoto_extention());

//		test DELETE===================================================
			
//			hosPhotoDao.delete(1);

	}

	@Override
	public void setDisplayPhoto(String hosPhoto_Id, String hosPhoto_HosId) {
		// TODO Auto-generated method stub
		
	}

}
