package com.track.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	追蹤收藏<br>
 *	英文:track<br>
 */ 
public class TrackDAO implements TrackDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO track(track_Id,mem_Id,track_record_class,track_record_class_Id ) VALUES  ( track_seq1.nextval , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE track SET track_record_class=?,track_record_class_Id=?  WHERE track_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM track WHERE track_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT track_Id,mem_Id,track_record_class,track_record_class_Id FROM track WHERE track_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT track_Id,mem_Id,track_record_class,track_record_class_Id FROM track order by track_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_TRACK_RECORD_CLASS =" UPDATE track set TRACK_RECORD_CLASS=?  WHERE track_Id=? " ; 
	private static final String UPDATE_TRACK_RECORD_CLASS_ID =" UPDATE track set TRACK_RECORD_CLASS_ID=?  WHERE track_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(TrackVO aTrackVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(TrackDAO.INSERT_STMT);
			pstmt.setString (1, aTrackVO.getMem_Id());
			pstmt.setString (2, aTrackVO.getTrack_record_class());
			pstmt.setString (3, aTrackVO.getTrack_record_class_Id());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
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
	//====以下是改寫update方法====
	@Override
	public void update(TrackVO aTrackVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(TrackDAO.UPDATE);
			pstmt.setString (1, aTrackVO.getTrack_record_class());
			pstmt.setString (2, aTrackVO.getTrack_record_class_Id());
			pstmt.setString (3, aTrackVO.getTrack_Id());
			pstmt.executeUpdate();
		} catch (SQLException se) {
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
	//====以下是改寫delete方法====
	@Override
	public void delete(String  aTrack){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(TrackDAO.DELETE);
			pstmt.setString (1,aTrack);
			pstmt.executeUpdate();
		} catch (SQLException se) {
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
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public TrackVO findByPrimaryKey(String  aPK_NO){
		TrackVO trackVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(TrackDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				trackVO = new TrackVO();
				trackVO.setTrack_Id(rs.getString("track_Id"));
				trackVO.setMem_Id(rs.getString("mem_Id"));
				trackVO.setTrack_record_class(rs.getString("track_record_class"));
				trackVO.setTrack_record_class_Id(rs.getString("track_record_class_Id"));
			}
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
		return trackVO; 
	} 

    @Override
    public List<TrackVO> getAll() {
        List<TrackVO> list = new ArrayList<TrackVO>();
        TrackVO trackVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // trackVO 也稱為 Domain objects
                trackVO = new TrackVO();
                trackVO.setTrack_Id(rs.getString("track_Id"));
                trackVO.setMem_Id(rs.getString("mem_Id"));
                trackVO.setTrack_record_class(rs.getString("track_record_class"));
                trackVO.setTrack_record_class_Id(rs.getString("track_record_class_Id"));

                list.add(trackVO); // Store the row in the vector
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