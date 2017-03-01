package com.grp.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.grpComm.model.GrpCommVO;
import com.hosComm.model.HosCommVO;
import com.joinlist.model.JoinListVO;

public class GrpDAO_JDBC implements GrpDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "aa106g3";
	String passwd = "aa106g3";

	private static final String INSERT_STMT = "INSERT INTO petGroup (grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road, grp_EndTime, grp_StartTime, "
			+ "grp_CreateTime, grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo) VALUES (PETGROUP_SEQ1.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE,?,?,?,?,?)";

	private static final String GET_ALL_STMT = "SELECT grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road,  grp_EndTime,"
			+ " grp_StartTime, "
			+ "to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime, "
			+ "grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo FROM petGroup order by grp_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road, grp_EndTime,"
			+ "grp_StartTime, grp_CreateTime, "
			+ "grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo FROM petGroup where grp_Id=?";

	private static final String DELETE = "DELETE FROM petGroup where grp_Id = ?";
	
	private static final String UPDATE = "UPDATE petGroup set grp_MemId=? , grp_name=? , grp_city=? , grp_town=? , grp_road=? "
			+ ", grp_EndTime=? , grp_StartTime=? ,  grp_CreateTime=? , "
			+ "grp_Desc=? , grp_Long=? , grp_Lat=? , grp_visible=? , grp_photo=?  where grp_Id=?";

	@Override
	public GrpVO insert(GrpVO grpVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			con.setAutoCommit(false);

			
			pstmt.setString(1, grpVO.getGrp_MemId());
			pstmt.setString(2, grpVO.getGrp_name());
			pstmt.setString(3, grpVO.getGrp_city());
			pstmt.setString(4, grpVO.getGrp_town());
			pstmt.setString(5, grpVO.getGrp_road());
			pstmt.setTimestamp(6, grpVO.getGrp_EndTime());
			pstmt.setTimestamp(7, grpVO.getGrp_StartTime());
			
			pstmt.setString(8, grpVO.getGrp_Desc());
			pstmt.setDouble(9, grpVO.getGrp_Long());
			pstmt.setDouble(10, grpVO.getGrp_Lat());
			pstmt.setString(11, grpVO.getGrp_visible());
			pstmt.setBytes(12, grpVO.getGrp_photo());
			

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
		return grpVO;

	}

	@Override
	public void update(GrpVO grpVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			
			pstmt.setString(1,grpVO.getGrp_MemId());
			pstmt.setString(2,grpVO.getGrp_name());
			pstmt.setString(3,grpVO.getGrp_city());
			pstmt.setString(4,grpVO.getGrp_town());
			pstmt.setString(5,grpVO.getGrp_road());
			pstmt.setTimestamp(6,grpVO.getGrp_EndTime());
			pstmt.setTimestamp(7,grpVO.getGrp_StartTime());
			pstmt.setDate(8,grpVO.getGrp_CreateTime());
			pstmt.setString(9,grpVO.getGrp_Desc());
			pstmt.setDouble(10,grpVO.getGrp_Long());
			pstmt.setDouble(11,grpVO.getGrp_Lat());
			pstmt.setString(12,grpVO.getGrp_visible());
			pstmt.setBytes(13,grpVO.getGrp_photo());
			
			pstmt.setString(14,grpVO.getGrp_Id());
			
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
	public void delete(String grp_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, userid, passwd);
			
			con.setAutoCommit(false);
			
			
			
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1,grp_Id);
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
	public GrpVO findByPrimaryKey(String grp_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GrpVO grpvo = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, grp_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				grpvo = new GrpVO();

				grpvo.setGrp_Id(rs.getString(1));
				grpvo.setGrp_MemId(rs.getString(2));
				grpvo.setGrp_name(rs.getString(3));
				grpvo.setGrp_city(rs.getString(4));
				grpvo.setGrp_town(rs.getString(5));
				grpvo.setGrp_road(rs.getString(6));
				grpvo.setGrp_EndTime(rs.getTimestamp(7));
				grpvo.setGrp_StartTime(rs.getTimestamp(8));
				grpvo.setGrp_CreateTime(rs.getDate(9));
				grpvo.setGrp_Desc(rs.getString(10));
				grpvo.setGrp_Long(rs.getDouble(11));
				grpvo.setGrp_Lat(rs.getDouble(12));
				grpvo.setGrp_visible(rs.getString(13));
				grpvo.setGrp_photo(rs.getBytes(14));
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

		return grpvo;
	}

	@Override
	public List<GrpVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GrpVO> list = new ArrayList<>();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrpVO grpvo = new GrpVO();

				grpvo.setGrp_Id(rs.getString(1));
				grpvo.setGrp_MemId(rs.getString(2));
				grpvo.setGrp_name(rs.getString(3));
				grpvo.setGrp_city(rs.getString(4));
				grpvo.setGrp_town(rs.getString(5));
				grpvo.setGrp_road(rs.getString(6));
				grpvo.setGrp_EndTime(rs.getTimestamp(7));
				grpvo.setGrp_StartTime(rs.getTimestamp(8));
				grpvo.setGrp_CreateTime(java.sql.Date.valueOf(rs.getString(9)));
				grpvo.setGrp_Desc(rs.getString(10));
				grpvo.setGrp_Long(rs.getDouble(11));
				grpvo.setGrp_Lat(rs.getDouble(12));
				grpvo.setGrp_visible(rs.getString(13));
				grpvo.setGrp_photo(rs.getBytes(14));

				list.add(grpvo);
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
		GrpDAO_JDBC grpdao = new GrpDAO_JDBC();
		Calendar cal = Calendar.getInstance();
		Date date =new Date(cal.getTimeInMillis());
		Timestamp ts = new Timestamp(cal.getTimeInMillis());
//		int r = (int)Math.ceil(Math.random()*10);
//		
		
//		 GrpVO grpvo = new GrpVO();
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
//		 
//		 grpvo.setGrp_MemId("1000000");
//		 grpvo.setGrp_name("name01");
//		 grpvo.setGrp_city("city01");
//		 grpvo.setGrp_town("town01");
//		 grpvo.setGrp_road("road01");
//		 grpvo.setGrp_EndTime(ts);
//		 grpvo.setGrp_StartTime(ts);
//		 grpvo.setGrp_CreateTime(date);
//		 grpvo.setGrp_Desc("01");
//		 grpvo.setGrp_Long(100.40338);
//		 grpvo.setGrp_Lat(120.17403);
//		 grpvo.setGrp_visible("1");
//		 grpvo.setGrp_photo(b);
//
//		 grpdao.insert(grpvo);
		 
//test UPDATE=========================================================
		 
//		 GrpVO grpvo2 = new GrpVO();
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
//		 grpvo2.setGrp_Id("02");
//		 grpvo2.setGrp_MemId("03");
//		 grpvo2.setGrp_name("name03");
//		 grpvo2.setGrp_city("city03");
//		 grpvo2.setGrp_town("town03");
//		 grpvo2.setGrp_road("road03");
//		 grpvo2.setGrp_EndTime(date);
//		 grpvo2.setGrp_StartTime(date);
//		 grpvo2.setGrp_CreateTime(date);
//		 grpvo2.setGrp_Desc("03");
//		 grpvo2.setGrp_Long(12.401338);
//		 grpvo2.setGrp_Lat(11.174113);
//		 grpvo2.setGrp_visible("1");
//		 grpvo2.setGrp_photo(b2);
//
//		
//		 grpdao.update(grpvo2);
		 
// test GETALL=========================================================
		 
		 
//		List<GrpVO> list = grpdao.getAll();
//		for (GrpVO g : list) {
//
//			System.out.println(g.getGrp_Id());
//			System.out.println(g.getGrp_MemId());
//			System.out.println(g.getGrp_name());
//			System.out.println(g.getGrp_city());
//			System.out.println(g.getGrp_town());
//			System.out.println(g.getGrp_road());
//			System.out.println(g.getGrp_EndTime());
//			System.out.println(g.getGrp_StartTime());
//			System.out.println(g.getGrp_CreateTime());
//			System.out.println(g.getGrp_Desc());
//			System.out.println(g.getGrp_Long());
//			System.out.println(g.getGrp_Lat());
//			System.out.println(g.getGrp_visible());
//			System.out.println(g.getGrp_photo());
//test findByPrimaryKey=============================================
			GrpVO g = new GrpVO();
		    g = grpdao.findByPrimaryKey("6000003");
			
			System.out.println(g.getGrp_Id());
			System.out.println(g.getGrp_MemId());
			System.out.println(g.getGrp_name());
			System.out.println(g.getGrp_city());
			System.out.println(g.getGrp_town());
			System.out.println(g.getGrp_road());
			System.out.println(g.getGrp_EndTime());
			System.out.println(g.getGrp_StartTime());
			System.out.println(g.getGrp_CreateTime());
			System.out.println(g.getGrp_Desc());
			System.out.println(g.getGrp_Long());
			System.out.println(g.getGrp_Lat());
			System.out.println(g.getGrp_visible());
			System.out.println(g.getGrp_photo());

//		test DELETE===================================================
			
//			grpdao.delete(1);

	}

	

	@Override
	public Set<GrpCommVO> getCommentsByGrpId(String grp_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<JoinListVO> getJoinListByGrpId(String grp_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int get_count_By_joinList_GrpId(String joinList_GrpId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<JoinListVO> getJoinListByMemId(String mem_Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
