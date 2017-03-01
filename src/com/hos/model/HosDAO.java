package com.hos.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoVO;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_vet_hospital;
import jdbc.util.searchWithSortQuery.SearchWithSort_Hos;


public class HosDAO implements HosDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB_dream");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	private static final String INSERT_HOS_STMT = "INSERT INTO vet_hospital (hos_Id, hos_MemId, hos_name, hos_city, hos_town, hos_road,hos_CreateTime , hos_StartTime, hos_EndTime"
			+ ", hos_Desc, hos_Long, hos_Lat, hos_visible, hos_Eval, hos_URL, hos_Tel) VALUES (VET_HOSPITAL_SEQ1.NEXTVAL, ?, ?, ?, ?, ?,SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_HOS_PHOTO_STMT ="INSERT INTO hos_photo (hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention) "
			+ "VALUES (HOS_PHOTO_SEQ1.nextval, ?, ?, ?, ?, ?)";
	
	
	private static final String GET_ALL_STMT = "SELECT hos_Id, hos_MemId, hos_name, hos_city, hos_town,"
			+ " hos_road, hos_EndTime, hos_StartTime, + hos_CreateTime, hos_Desc, hos_Long, hos_Lat, "
			+ "hos_visible, hos_Eval, hos_URL, hos_Tel FROM vet_hospital order by hos_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT hos_Id, hos_MemId, hos_name, hos_city, hos_town,"
			+ "hos_road, hos_EndTime, hos_StartTime, hos_CreateTime, hos_Desc, hos_Long, hos_Lat,"
			+ "hos_visible, hos_Eval, hos_URL, hos_Tel FROM vet_hospital where hos_Id=?";
	
	private static final String DELETE = "DELETE FROM vet_hospital where hos_Id = ?";
	
	private static final String UPDATE = "UPDATE vet_hospital set hos_MemId=? , hos_name=? , hos_city=? , hos_town=? ,"
			+ "hos_road=? , hos_EndTime=? , hos_StartTime=? ,  hos_CreateTime=? , "
			+ "hos_Desc=? , hos_Long=? , hos_Lat=? , hos_visible=? , hos_Eval=?, hos_URL=?, hos_Tel=? where hos_Id=?";
	
	private static final String GET_PHOTOS_BY_HOSID_STMT = "SELECT hosPhoto_Id, hosPhoto_HosId, hosPhoto_photo, isDisp_HosPhoto, hosPhoto_name, hosPhoto_extention "
			+ "FROM hos_photo where hosPhoto_HosId = ?";
	
	private static final String GET_COMMENT_BY_HOSID_STMT ="SELECT hosComment_Id, hosComment_MemId, hosComment_HosId, hosComment_content,"
			+ " hosComment_SendTime FROM hos_comment where hosComment_HosId=?";
	
	@Override
	public HosVO insert(HosVO hosVO, List<HosPhotoVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {

			con = ds.getConnection();
			String[] cols = { "hos_Id" };
			pstmt = con.prepareStatement(INSERT_HOS_STMT,cols);

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
			
			rs=pstmt.getGeneratedKeys();
			
			pstmt.clearParameters();
			
			pstmt = con.prepareStatement(INSERT_HOS_PHOTO_STMT);

			rs.next();
			String key = rs.getString(1);
			
			
			for(HosPhotoVO hosPhotoVO : list){
				hosPhotoVO.setHosPhoto_HosId(key);
								
				pstmt.setString(1, hosPhotoVO.getHosPhoto_HosId());
				pstmt.setBytes(2, hosPhotoVO.getHosPhoto_photo());
				pstmt.setString(3, hosPhotoVO.getIsDisp_HosPhoto());
				pstmt.setString(4, hosPhotoVO.getHosPhoto_name());
				pstmt.setString(5, hosPhotoVO.getHosPhoto_extention());
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();

			con.commit();
			con.setAutoCommit(true);
			//為了回傳hosVO
			hosVO.setHos_Id(key);
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
		
		return hosVO;

	}

	@Override
	public void update(HosVO hosVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
//			System.out.println(hosVO.getHos_visible());
//			System.out.println(hosVO.getHos_Id());
			
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
	public void delete(String hos_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			con.setAutoCommit(false);
			System.out.println("DAO  "+hos_Id);
			
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1,hos_Id);
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
	public HosVO findByPrimaryKey(String hos_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HosVO hosvo = null;

		try {
			con = ds.getConnection();
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
				hosvo.setHos_EndTime(rs.getString(7));
				hosvo.setHos_StartTime(rs.getString(8));
				hosvo.setHos_CreateTime(rs.getDate(9));
				hosvo.setHos_Desc(rs.getString(10));
				hosvo.setHos_Long(rs.getDouble(11));
				hosvo.setHos_Lat(rs.getDouble(12));
				hosvo.setHos_visible(rs.getString(13));
				hosvo.setHos_Eval(rs.getInt(14));
				hosvo.setHos_URL(rs.getString(15));
				hosvo.setHos_Tel(rs.getString(16));
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

		return hosvo;
	}

	@Override
	public List<HosVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HosVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();
//			to_char(hos_StartTime,'YYYY-MM-DD HH24:MI:SS') 
			while (rs.next()) {
				HosVO hosvo = new HosVO();
				
				hosvo.setHos_Id(rs.getString(1));
				hosvo.setHos_MemId(rs.getString(2));
				hosvo.setHos_name(rs.getString(3));
				hosvo.setHos_city(rs.getString(4));
				hosvo.setHos_town(rs.getString(5));
				hosvo.setHos_road(rs.getString(6));

				hosvo.setHos_EndTime(rs.getString(7));
				hosvo.setHos_StartTime(rs.getString(8));


				hosvo.setHos_CreateTime(rs.getDate(9));
				hosvo.setHos_Desc(rs.getString(10));
				hosvo.setHos_Long(rs.getDouble(11));
				hosvo.setHos_Lat(rs.getDouble(12));
				hosvo.setHos_visible(rs.getString(13));
				hosvo.setHos_Eval(rs.getInt(14));
				hosvo.setHos_URL(rs.getString(15));
				hosvo.setHos_Tel(rs.getString(16));

				list.add(hosvo);
			}

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

	@Override
	public Set<HosPhotoVO> getPhotosByHosId(String hos_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Set<HosPhotoVO> set = new LinkedHashSet<>();
		try {
		

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PHOTOS_BY_HOSID_STMT);
			
			pstmt.setString(1, hos_Id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HosPhotoVO hosPhotoVO = new HosPhotoVO();

				hosPhotoVO.setHosPhoto_Id(rs.getString(1));
				hosPhotoVO.setHosPhoto_HosId(rs.getString(2));
				hosPhotoVO.setHosPhoto_photo(rs.getBytes(3));
				hosPhotoVO.setIsDisp_HosPhoto(rs.getString(4));
				hosPhotoVO.setHosPhoto_name(rs.getString(5));
				hosPhotoVO.setHosPhoto_extention(rs.getString(6));
	
				set.add(hosPhotoVO);
			}

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

		return set;
	}

	@Override
	public List<HosVO> searchAll(String searchCondition) {
	Connection con = null;
	List<HosVO> list = null;
	try {
		SearchWithSort_Hos swsHos = new SearchWithSort_Hos();
		con = ds.getConnection();
		list = swsHos.searchAll(con,searchCondition);
	} catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
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
	public Set<HosCommVO> getCommentsByHosId(String hos_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Set<HosCommVO> set = new LinkedHashSet<>();
		try {
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_COMMENT_BY_HOSID_STMT);
			
			pstmt.setString(1, hos_Id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HosCommVO hosCommVO = new HosCommVO();
				
				hosCommVO.setHosComment_Id(rs.getString(1));
				hosCommVO.setHosComment_MemId(rs.getString(2));
				hosCommVO.setHosComment_HosId(rs.getString(3));
				hosCommVO.setHosComment_content(rs.getString(4));
				hosCommVO.setHosComment_SendTime(rs.getTimestamp(5));
	
				set.add(hosCommVO);
			}

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

		return set;
	}

	@Override
	public List<HosVO> getAll(Map<String, String[]> map) {
		List<HosVO> list = new ArrayList<HosVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			con = ds.getConnection();
			String finalSQL = "select * from vet_hospital "
		          + jdbcUtil_CompositeQuery_vet_hospital.get_WhereCondition(map)
		          + "order by hos_Id";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				HosVO hosvo = new HosVO();
				
				hosvo.setHos_Id(rs.getString("hos_Id"));
				hosvo.setHos_MemId(rs.getString("hos_MemId"));
				hosvo.setHos_name(rs.getString("hos_name"));
				hosvo.setHos_city(rs.getString("hos_city"));
				hosvo.setHos_town(rs.getString("hos_town"));
				hosvo.setHos_road(rs.getString("hos_road"));

				hosvo.setHos_EndTime(rs.getString("hos_EndTime"));
				hosvo.setHos_StartTime(rs.getString("hos_StartTime"));

				hosvo.setHos_CreateTime(rs.getDate("hos_CreateTime"));
				hosvo.setHos_Desc(rs.getString("hos_Desc"));
				hosvo.setHos_Long(rs.getDouble("hos_Long"));
				hosvo.setHos_Lat(rs.getDouble("hos_Lat"));
				hosvo.setHos_visible(rs.getString("hos_visible"));
				hosvo.setHos_Eval(rs.getInt("hos_Eval"));
				hosvo.setHos_URL(rs.getString("hos_URL"));
				hosvo.setHos_Tel(rs.getString("hos_Tel"));

				list.add(hosvo); // Store the row in the List
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
