package com.adp.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	領養活動<br>
 *	英文:adp<br>
 */ 
public class AdpDAO implements AdpDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO adp(adp_Id,mem_Id,adp_title,adp_adp_content,adp_start_date,adp_end_date,adp_upDate,adp_city,adp_town,adp_road,adp_lon,adp_lat ) VALUES  ( adp_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adp SET adp_title=?,adp_adp_content=? ,adp_start_date=? ,adp_end_date=? ,adp_upDate=? ,adp_city=? ,adp_town=? ,adp_road=? ,adp_lon=? ,adp_lat=?  WHERE adp_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adp WHERE adp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT adp_Id,mem_Id,adp_title,adp_adp_content,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_end_date,'yyyy-mm-dd') adp_end_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,adp_town,adp_road,adp_lon,adp_lat FROM adp WHERE adp_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT adp_Id,mem_Id,adp_title,adp_adp_content,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_end_date,'yyyy-mm-dd') adp_end_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,adp_town,adp_road,adp_lon,adp_lat FROM adp order by adp_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADP_TITLE =" UPDATE adp set ADP_TITLE=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_ADP_CONTENT =" UPDATE adp set ADP_ADP_CONTENT=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_START_DATE =" UPDATE adp set ADP_START_DATE=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_END_DATE =" UPDATE adp set ADP_END_DATE=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_UPDATE =" UPDATE adp set ADP_UPDATE=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_CITY =" UPDATE adp set ADP_CITY=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_TOWN =" UPDATE adp set ADP_TOWN=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_ROAD =" UPDATE adp set ADP_ROAD=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_LON =" UPDATE adp set ADP_LON=?  WHERE adp_Id=? " ; 
	private static final String UPDATE_ADP_LAT =" UPDATE adp set ADP_LAT=?  WHERE adp_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AdpVO aAdpVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpDAO.INSERT_STMT);
			pstmt.setString (1, aAdpVO.getMem_Id());
			pstmt.setString (2, aAdpVO.getAdp_title());
			pstmt.setString (3, aAdpVO.getAdp_adp_content());
			pstmt.setDate (4, aAdpVO.getAdp_start_date());
			pstmt.setDate (5, aAdpVO.getAdp_end_date());
			pstmt.setDate (6, aAdpVO.getAdp_upDate());
			pstmt.setString (7, aAdpVO.getAdp_city());
			pstmt.setString (8, aAdpVO.getAdp_town());
			pstmt.setString (9, aAdpVO.getAdp_road());
			pstmt.setDouble (10, aAdpVO.getAdp_lon());
			pstmt.setDouble (11, aAdpVO.getAdp_lat());
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
	public void update(AdpVO aAdpVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpDAO.UPDATE);
			pstmt.setString (1, aAdpVO.getAdp_title());
			pstmt.setString (2, aAdpVO.getAdp_adp_content());
			pstmt.setDate (3, aAdpVO.getAdp_start_date());
			pstmt.setDate (4, aAdpVO.getAdp_end_date());
			pstmt.setDate (5, aAdpVO.getAdp_upDate());
			pstmt.setString (6, aAdpVO.getAdp_city());
			pstmt.setString (7, aAdpVO.getAdp_town());
			pstmt.setString (8, aAdpVO.getAdp_road());
			pstmt.setDouble (9, aAdpVO.getAdp_lon());
			pstmt.setDouble (10, aAdpVO.getAdp_lat());
			pstmt.setString (11, aAdpVO.getAdp_Id());
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
	public void delete(String  aAdp){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpDAO.DELETE);
			pstmt.setString (1,aAdp);
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
	public AdpVO findByPrimaryKey(String  aPK_NO){
		AdpVO adpVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				adpVO = new AdpVO();
				adpVO.setAdp_Id(rs.getString("adp_Id"));
				adpVO.setMem_Id(rs.getString("mem_Id"));
				adpVO.setAdp_title(rs.getString("adp_title"));
				adpVO.setAdp_adp_content(rs.getString("adp_adp_content"));
				adpVO.setAdp_start_date(rs.getDate("adp_start_date"));
				adpVO.setAdp_end_date(rs.getDate("adp_end_date"));
				adpVO.setAdp_upDate(rs.getDate("adp_upDate"));
				adpVO.setAdp_city(rs.getString("adp_city"));
				adpVO.setAdp_town(rs.getString("adp_town"));
				adpVO.setAdp_road(rs.getString("adp_road"));
				adpVO.setAdp_lon(rs.getDouble("adp_lon"));
				adpVO.setAdp_lat(rs.getDouble("adp_lat"));
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
		return adpVO; 
	} 

    @Override
    public List<AdpVO> getAll() {
        List<AdpVO> list = new ArrayList<AdpVO>();
        AdpVO adpVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // adpVO 也稱為 Domain objects
                adpVO = new AdpVO();
                adpVO.setAdp_Id(rs.getString("adp_Id"));
                adpVO.setMem_Id(rs.getString("mem_Id"));
                adpVO.setAdp_title(rs.getString("adp_title"));
                adpVO.setAdp_adp_content(rs.getString("adp_adp_content"));
                adpVO.setAdp_start_date(rs.getDate("adp_start_date"));
                adpVO.setAdp_end_date(rs.getDate("adp_end_date"));
                adpVO.setAdp_upDate(rs.getDate("adp_upDate"));
                adpVO.setAdp_city(rs.getString("adp_city"));
                adpVO.setAdp_town(rs.getString("adp_town"));
                adpVO.setAdp_road(rs.getString("adp_road"));
                adpVO.setAdp_lon(rs.getDouble("adp_lon"));
                adpVO.setAdp_lat(rs.getDouble("adp_lat"));

                list.add(adpVO); // Store the row in the vector
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