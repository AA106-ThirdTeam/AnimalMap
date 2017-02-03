package com.adpphotos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	領養活動相簿<br>
 *	英文:adpPhotos<br>
 */ 
public class AdpPhotosDAO implements AdpPhotosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO adpPhotos(adpPhotos_Id,adp_Id,adpPhotosPic ) VALUES  ( adpPhotos_seq1.nextval , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adpPhotos SET adp_Id=?,adpPhotosPic=?  WHERE adpPhotos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adpPhotos WHERE adpPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT adpPhotos_Id,adp_Id,adpPhotosPic FROM adpphotos WHERE adpPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT adpPhotos_Id,adp_Id,adpPhotosPic FROM adpPhotos order by adpPhotos_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADP_ID =" UPDATE adpPhotos set ADP_ID=?  WHERE adpPhotos_Id=? " ; 
	private static final String UPDATE_ADPPHOTOSPIC =" UPDATE adpPhotos set ADPPHOTOSPIC=?  WHERE adpPhotos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AdpPhotosVO aAdpPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.INSERT_STMT);
			pstmt.setString (1, aAdpPhotosVO.getAdp_Id());
			pstmt.setBytes (2, aAdpPhotosVO.getAdpPhotosPic());
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
	public void update(AdpPhotosVO aAdpPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.UPDATE);
			pstmt.setString (1, aAdpPhotosVO.getAdp_Id());
			pstmt.setBytes (2, aAdpPhotosVO.getAdpPhotosPic());
			pstmt.setString (3, aAdpPhotosVO.getAdpPhotos_Id());
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
	public void delete(String  aAdpPhotos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.DELETE);
			pstmt.setString (1,aAdpPhotos);
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
	public AdpPhotosVO findByPrimaryKey(String  aPK_NO){
		AdpPhotosVO adpphotosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				adpphotosVO = new AdpPhotosVO();
				adpphotosVO.setAdpPhotos_Id(rs.getString("adpPhotos_Id"));
				adpphotosVO.setAdp_Id(rs.getString("adp_Id"));
				adpphotosVO.setAdpPhotosPic(rs.getBytes("adpPhotosPic"));
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
		return adpphotosVO; 
	} 

    @Override
    public List<AdpPhotosVO> getAll() {
        List<AdpPhotosVO> list = new ArrayList<AdpPhotosVO>();
        AdpPhotosVO adpphotosVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // adpphotosVO 也稱為 Domain objects
                adpphotosVO = new AdpPhotosVO();
                adpphotosVO.setAdpPhotos_Id(rs.getString("adpPhotos_Id"));
                adpphotosVO.setAdp_Id(rs.getString("adp_Id"));
                adpphotosVO.setAdpPhotosPic(rs.getBytes("adpPhotosPic"));

                list.add(adpphotosVO); // Store the row in the vector
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