package com.emg_h.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	緊急求救<br>
 *	英文:emg_H<br>
 */ 
public class Emg_HDAO implements Emg_HDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO emg_H(emg_H_Id,mem_Id,emg_H_start_date,emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat ) VALUES  ( emg_H_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE emg_H SET emg_H_start_date=?,emg_H_end_date=? ,emg_H_title=? ,emg_H_content=? ,emg_H_Pic=? ,emg_H_Pic_format=? ,emg_H_city=? ,emg_H_town=? ,emg_H_road=? ,emg_H_Lon=? ,emg_H_Lat=?  WHERE emg_H_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM emg_H WHERE emg_H_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT emg_H_Id,mem_Id,to_char(emg_H_start_date,'yyyy-mm-dd') emg_H_start_date,to_char(emg_H_end_date,'yyyy-mm-dd') emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat FROM emg_h WHERE emg_H_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT emg_H_Id,mem_Id,to_char(emg_H_start_date,'yyyy-mm-dd') emg_H_start_date,to_char(emg_H_end_date,'yyyy-mm-dd') emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat FROM emg_H order by emg_H_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_EMG_H_START_DATE =" UPDATE emg_H set EMG_H_START_DATE=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_END_DATE =" UPDATE emg_H set EMG_H_END_DATE=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_TITLE =" UPDATE emg_H set EMG_H_TITLE=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_CONTENT =" UPDATE emg_H set EMG_H_CONTENT=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_PIC =" UPDATE emg_H set EMG_H_PIC=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_PIC_FORMAT =" UPDATE emg_H set EMG_H_PIC_FORMAT=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_CITY =" UPDATE emg_H set EMG_H_CITY=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_TOWN =" UPDATE emg_H set EMG_H_TOWN=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_ROAD =" UPDATE emg_H set EMG_H_ROAD=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_LON =" UPDATE emg_H set EMG_H_LON=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_LAT =" UPDATE emg_H set EMG_H_LAT=?  WHERE emg_H_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Emg_HVO aEmg_HVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_HDAO.INSERT_STMT);
			pstmt.setString (1, aEmg_HVO.getMem_Id());
			pstmt.setDate (2, aEmg_HVO.getEmg_H_start_date());
			pstmt.setDate (3, aEmg_HVO.getEmg_H_end_date());
			pstmt.setString (4, aEmg_HVO.getEmg_H_title());
			pstmt.setString (5, aEmg_HVO.getEmg_H_content());
			pstmt.setBytes (6, aEmg_HVO.getEmg_H_Pic());
			pstmt.setString (7, aEmg_HVO.getEmg_H_Pic_format());
			pstmt.setString (8, aEmg_HVO.getEmg_H_city());
			pstmt.setString (9, aEmg_HVO.getEmg_H_town());
			pstmt.setString (10, aEmg_HVO.getEmg_H_road());
			pstmt.setDouble (11, aEmg_HVO.getEmg_H_Lon());
			pstmt.setDouble (12, aEmg_HVO.getEmg_H_Lat());
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
	public void update(Emg_HVO aEmg_HVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_HDAO.UPDATE);
			pstmt.setDate (1, aEmg_HVO.getEmg_H_start_date());
			pstmt.setDate (2, aEmg_HVO.getEmg_H_end_date());
			pstmt.setString (3, aEmg_HVO.getEmg_H_title());
			pstmt.setString (4, aEmg_HVO.getEmg_H_content());
			pstmt.setBytes (5, aEmg_HVO.getEmg_H_Pic());
			pstmt.setString (6, aEmg_HVO.getEmg_H_Pic_format());
			pstmt.setString (7, aEmg_HVO.getEmg_H_city());
			pstmt.setString (8, aEmg_HVO.getEmg_H_town());
			pstmt.setString (9, aEmg_HVO.getEmg_H_road());
			pstmt.setDouble (10, aEmg_HVO.getEmg_H_Lon());
			pstmt.setDouble (11, aEmg_HVO.getEmg_H_Lat());
			pstmt.setString (12, aEmg_HVO.getEmg_H_Id());
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
	public void delete(String  aEmg_H){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_HDAO.DELETE);
			pstmt.setString (1,aEmg_H);
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
	public Emg_HVO findByPrimaryKey(String  aPK_NO){
		Emg_HVO emg_hVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_HDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emg_hVO = new Emg_HVO();
				emg_hVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_hVO.setMem_Id(rs.getString("mem_Id"));
				emg_hVO.setEmg_H_start_date(rs.getDate("emg_H_start_date"));
				emg_hVO.setEmg_H_end_date(rs.getDate("emg_H_end_date"));
				emg_hVO.setEmg_H_title(rs.getString("emg_H_title"));
				emg_hVO.setEmg_H_content(rs.getString("emg_H_content"));
				emg_hVO.setEmg_H_Pic(rs.getBytes("emg_H_Pic"));
				emg_hVO.setEmg_H_Pic_format(rs.getString("emg_H_Pic_format"));
				emg_hVO.setEmg_H_city(rs.getString("emg_H_city"));
				emg_hVO.setEmg_H_town(rs.getString("emg_H_town"));
				emg_hVO.setEmg_H_road(rs.getString("emg_H_road"));
				emg_hVO.setEmg_H_Lon(rs.getDouble("emg_H_Lon"));
				emg_hVO.setEmg_H_Lat(rs.getDouble("emg_H_Lat"));
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
		return emg_hVO; 
	} 

    @Override
    public List<Emg_HVO> getAll() {
        List<Emg_HVO> list = new ArrayList<Emg_HVO>();
        Emg_HVO emg_hVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // emg_hVO 也稱為 Domain objects
                emg_hVO = new Emg_HVO();
                emg_hVO.setEmg_H_Id(rs.getString("emg_H_Id"));
                emg_hVO.setMem_Id(rs.getString("mem_Id"));
                emg_hVO.setEmg_H_start_date(rs.getDate("emg_H_start_date"));
                emg_hVO.setEmg_H_end_date(rs.getDate("emg_H_end_date"));
                emg_hVO.setEmg_H_title(rs.getString("emg_H_title"));
                emg_hVO.setEmg_H_content(rs.getString("emg_H_content"));
                emg_hVO.setEmg_H_Pic(rs.getBytes("emg_H_Pic"));
                emg_hVO.setEmg_H_Pic_format(rs.getString("emg_H_Pic_format"));
                emg_hVO.setEmg_H_city(rs.getString("emg_H_city"));
                emg_hVO.setEmg_H_town(rs.getString("emg_H_town"));
                emg_hVO.setEmg_H_road(rs.getString("emg_H_road"));
                emg_hVO.setEmg_H_Lon(rs.getDouble("emg_H_Lon"));
                emg_hVO.setEmg_H_Lat(rs.getDouble("emg_H_Lat"));

                list.add(emg_hVO); // Store the row in the vector
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