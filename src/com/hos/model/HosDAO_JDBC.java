package com.hos.model;

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
import java.util.Map;
import java.util.Set;

import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoVO;

public class HosDAO_JDBC implements HosDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";

	private static final String INSERT_STMT = "INSERT INTO vet_hospital (hos_Id, hos_MemId, hos_name, hos_city, hos_town, hos_road,hos_CreateTime , hos_StartTime, hos_EndTime"
			+ ", hos_Desc, hos_Long, hos_Lat, hos_visible, hos_Eval, hos_URL, hos_Tel) VALUES (VET_HOSPITAL_SQ.NEXTVAL, ?, ?, ?, ?, ?,SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT hos_Id, hos_MemId, hos_name, hos_city, hos_town, hos_road, to_char(hos_EndTime,'yyyy-mm-dd') hos_EndTime,"
			+ "to_char(hos_StartTime,'yyyy-mm-dd') hos_StartTime, "
			+ "to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime, "
			+ "hos_Desc, hos_Long, hos_Lat, hos_visible, hos_Eval, hos_URL, hos_Tel FROM vet_hospital order by hos_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT hos_Id, hos_MemId, hos_name, hos_city, hos_town, hos_road, to_char(hos_EndTime,'yyyy-mm-dd') hos_EndTime,"
			+ "to_char(hos_StartTime,'yyyy-mm-dd') hos_StartTime, "
			+ "to_char(hos_CreateTime,'yyyy-mm-dd') hos_CreateTime, "
			+ "hos_Desc, hos_Long, hos_Lat, hos_visible, hos_Eval, hos_URL, hos_Tel FROM vet_hospital where hos_Id=?";

	private static final String DELETE = "DELETE FROM vet_hospital where hos_Id = ?";
	
	private static final String UPDATE = "UPDATE vet_hospital set hos_MemId=? , hos_name=? , hos_city=? , hos_town=? , hos_road=? "
			+ ", hos_EndTime=? ,"
			+ " hos_StartTime=? , "
			+ " hos_CreateTime=? , "
			+ "hos_Desc=? , hos_Long=? , hos_Lat=? , hos_visible=? , hos_Eval=?, hos_URL=?, hos_Tel=? where hos_Id=?";

	@Override
	public void insert(HosVO hosVO, List<HosPhotoVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);


			pstmt.setString(1, hosVO.getHos_MemId());
			pstmt.setString(2, hosVO.getHos_name());
			pstmt.setString(3, hosVO.getHos_city());
			pstmt.setString(4, hosVO.getHos_town());
			pstmt.setString(5, hosVO.getHos_road());
			pstmt.setString(6, hosVO.getHos_StartTime());
			pstmt.setString(7, hosVO.getHos_EndTime());
			
			
			pstmt.setString(8, hosVO.getHos_Desc());
			pstmt.setDouble(9, hosVO.getHos_Long());
			pstmt.setDouble(10, hosVO.getHos_Lat());
			pstmt.setString(11, hosVO.getHos_visible());
			pstmt.setInt(12, hosVO.getHos_Eval());
			pstmt.setString(13, hosVO.getHos_URL());
			pstmt.setString(14, hosVO.getHos_Tel());
			

			pstmt.executeUpdate();

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
	public void update(HosVO hosVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			
			pstmt.setString(1,hosVO.getHos_MemId());
			pstmt.setString(2,hosVO.getHos_name());
			pstmt.setString(3,hosVO.getHos_city());
			pstmt.setString(4,hosVO.getHos_town());
			pstmt.setString(5,hosVO.getHos_road());
			pstmt.setString(6,hosVO.getHos_EndTime());
			pstmt.setString(7,hosVO.getHos_StartTime());
			pstmt.setDate(8,hosVO.getHos_CreateTime());
			pstmt.setString(9,hosVO.getHos_Desc());
			pstmt.setDouble(10,hosVO.getHos_Long());
			pstmt.setDouble(11,hosVO.getHos_Lat());
			pstmt.setString(12,hosVO.getHos_visible());
			pstmt.setInt(13, hosVO.getHos_Eval());
			pstmt.setString(14, hosVO.getHos_URL());
			pstmt.setString(15, hosVO.getHos_Tel());
			
			pstmt.setString(16,hosVO.getHos_Id());
			
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
	public void delete(String hos_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			
			con.setAutoCommit(false);
			
			
			
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1,hos_Id);
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
	public HosVO findByPrimaryKey(String hos_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HosVO hosvo = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, hos_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				hosvo = new HosVO();

				hosvo.setHos_Id(rs.getString(1));
				hosvo.setHos_MemId(rs.getString(2));
				hosvo.setHos_name(rs.getString(3));
				hosvo.setHos_city(rs.getString(4));
				hosvo.setHos_town(rs.getString(5));
				hosvo.setHos_road(rs.getString(6));
				hosvo.setHos_EndTime(String.valueOf(rs.getString(7)));
				hosvo.setHos_StartTime(String.valueOf(rs.getString(8)));
				hosvo.setHos_CreateTime(java.sql.Date.valueOf(rs.getString(9)));
				hosvo.setHos_Desc(rs.getString(10));
				hosvo.setHos_Long(rs.getDouble(11));
				hosvo.setHos_Lat(rs.getDouble(12));
				hosvo.setHos_visible(rs.getString(13));
				hosvo.setHos_Eval(rs.getInt(14));
				hosvo.setHos_URL(rs.getString(15));
				hosvo.setHos_Tel(rs.getString(16));
				

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

		return hosvo;
	}

	@Override
	public List<HosVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HosVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				HosVO hosvo = new HosVO();

				hosvo.setHos_Id(rs.getString(1));
				hosvo.setHos_MemId(rs.getString(2));
				hosvo.setHos_name(rs.getString(3));
				hosvo.setHos_city(rs.getString(4));
				hosvo.setHos_town(rs.getString(5));
				hosvo.setHos_road(rs.getString(6));
				hosvo.setHos_EndTime(String.valueOf(rs.getString(7)));
				hosvo.setHos_StartTime(String.valueOf(rs.getString(8)));
				hosvo.setHos_CreateTime(java.sql.Date.valueOf(rs.getString(9)));
				hosvo.setHos_Desc(rs.getString(10));
				hosvo.setHos_Long(rs.getDouble(11));
				hosvo.setHos_Lat(rs.getDouble(12));
				hosvo.setHos_visible(rs.getString(13));
				hosvo.setHos_Eval(rs.getInt(14));
				hosvo.setHos_URL(rs.getString(15));
				hosvo.setHos_Tel(rs.getString(16));

				list.add(hosvo);
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
		HosDAO_JDBC hosdao = new HosDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Date date =new Date(cal.getTimeInMillis());
		
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
		 HosVO hosvo = new HosVO();
//		 
//		 byte[] b = null;	 
//		 File f = new
//		 File("WebContent\\group\\grpImage\\1.jpg");
//		 
//		 try{
//		 FileInputStream fis = new FileInputStream(f);
//		 BufferedInputStream bis = new BufferedInputStream(fis);
//		 b = new byte[bis.available()];
//		 bis.read(b);
//		 bis.close();
//		 fis.close(); 
//		 }catch(Exception e){e.printStackTrace();}
		 
//		 hosvo.setHos_Id("01");
//		 hosvo.setHos_MemId("01");
//		 hosvo.setHos_name("name01");
//		 hosvo.setHos_city("city01");
//		 hosvo.setHos_town("town01");
//		 hosvo.setHos_road("road01");
//		 hosvo.setHos_EndTime(date);
//		 hosvo.setHos_StartTime(date);
//		 hosvo.setHos_CreateTime(date);
//		 hosvo.setHos_Desc("01");
//		 hosvo.setHos_Long(100.40338);
//		 hosvo.setHos_Lat(120.17403);
//		 hosvo.setHos_visible("1");
//		 hosvo.setHos_Eval(99);
//		 hosvo.setHos_URL("http://www.googleYOU.com");
//		 hosvo.setHos_Tel("0123456789");
//
//		 hosdao.insert(hosvo);
		 
//test UPDATE=========================================================
		 
//		 HosVO hosvo2 = new HosVO();
//		 byte[] b2 = null;
//		 File f2 = new
//		 File("\\WebContent\\group\\grpImage\\1.jpg");
//		 try{
//			 FileInputStream fis = new FileInputStream(f2);
//			 BufferedInputStream bis = new BufferedInputStream(fis);
//			 b2 = new byte[bis.available()];
//			 bis.read(b2);
//			 }catch(Exception e){e.printStackTrace();}
//		
//		 hosvo2.setHos_Id("01");
//		 hosvo2.setHos_MemId("50");
//		 hosvo2.setHos_name("name05");
//		 hosvo2.setHos_city("city053");
//		 hosvo2.setHos_town("town053");
//		 hosvo2.setHos_road("road073");
//		 hosvo2.setHos_EndTime(date);
//		 hosvo2.setHos_StartTime(date);
//		 hosvo2.setHos_CreateTime(date);
//		 hosvo2.setHos_Desc("04557");
//		 hosvo2.setHos_Long(12.401338);
//		 hosvo2.setHos_Lat(11.174113);
//		 hosvo2.setHos_visible("1");
//		 hosvo2.setHos_Eval("17578");
// 		 hosvo2.setHos_URL("http://www.googleYOU757.com");
// 		 hosvo2.setHos_Tel("0123455");
//
//		
//		 hosdao.update(hosvo2);
		 
// test GETALL=========================================================
		 
		 
		List<HosVO> list = hosdao.getAll();
		for (HosVO g : list) {

			System.out.println(g.getHos_Id());
			System.out.println(g.getHos_MemId());
			System.out.println(g.getHos_name());
			System.out.println(g.getHos_city());
			System.out.println(g.getHos_town());
			System.out.println(g.getHos_road());
			System.out.println(g.getHos_EndTime());
			System.out.println(g.getHos_StartTime());
			System.out.println(g.getHos_CreateTime());
			System.out.println(g.getHos_Desc());
			System.out.println(g.getHos_Long());
			System.out.println(g.getHos_Lat());
			System.out.println(g.getHos_visible());
			System.out.println(g.getHos_Eval());
			System.out.println(g.getHos_URL());
			System.out.println(g.getHos_Tel());
		}
//test findByPrimaryKey=============================================
//			HosVO g = new HosVO();
//		    g = hosdao.findByPrimaryKey(1);
//			
//			System.out.println(g.getHos_Id());
//			System.out.println(g.getHos_MemId());
//			System.out.println(g.getHos_name());
//			System.out.println(g.getHos_city());
//			System.out.println(g.getHos_town());
//			System.out.println(g.getHos_road());
//			System.out.println(g.getHos_EndTime());
//			System.out.println(g.getHos_StartTime());
//			System.out.println(g.getHos_CreateTime());
//			System.out.println(g.getHos_Desc());
//			System.out.println(g.getHos_Long());
//			System.out.println(g.getHos_Lat());
//			System.out.println(g.getHos_visible());
//			System.out.println(g.getHos_Eval());
//			System.out.println(g.getHos_URL());
//			System.out.println(g.getHos_Tel());

//		test DELETE===================================================
			
//			hosdao.delete("1");

	}

	@Override
	public Set<HosPhotoVO> getPhotosByHosId(String hosId) {
		return null;
	}

	@Override
	public List<HosVO> searchAll(String searchCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<HosCommVO> getCommentsByHosId(String hos_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HosVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
