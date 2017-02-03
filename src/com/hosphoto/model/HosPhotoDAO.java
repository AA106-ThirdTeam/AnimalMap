package com.hosphoto.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	診所相片<br>
 *	英文:hosPhoto<br>
 */ 
public class HosPhotoDAO implements HosPhotoDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO hosPhoto(hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent ) VALUES  ( hosPhoto_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE hosPhoto SET hosPhoto_photo=?,isDisp_HosPhoto=? ,hosPhoto_name=? ,hosPhoto_extent=?  WHERE hosPhoto_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM hosPhoto WHERE hosPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent FROM hosphoto WHERE hosPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent FROM hosPhoto order by hosPhoto_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_HOSPHOTO_PHOTO =" UPDATE hosPhoto set HOSPHOTO_PHOTO=?  WHERE hosPhoto_Id=? " ; 
	private static final String UPDATE_ISDISP_HOSPHOTO =" UPDATE hosPhoto set ISDISP_HOSPHOTO=?  WHERE hosPhoto_Id=? " ; 
	private static final String UPDATE_HOSPHOTO_NAME =" UPDATE hosPhoto set HOSPHOTO_NAME=?  WHERE hosPhoto_Id=? " ; 
	private static final String UPDATE_HOSPHOTO_EXTENT =" UPDATE hosPhoto set HOSPHOTO_EXTENT=?  WHERE hosPhoto_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(HosPhotoVO aHosPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.INSERT_STMT);
			pstmt.setString (1, aHosPhotoVO.getHosPhoto_HosId());
			pstmt.setBytes (2, aHosPhotoVO.getHosPhoto_photo());
			pstmt.setString (3, aHosPhotoVO.getIsDisp_HosPhoto());
			pstmt.setString (4, aHosPhotoVO.getHosPhoto_name());
			pstmt.setString (5, aHosPhotoVO.getHosPhoto_extent());
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
	public void update(HosPhotoVO aHosPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.UPDATE);
			pstmt.setBytes (1, aHosPhotoVO.getHosPhoto_photo());
			pstmt.setString (2, aHosPhotoVO.getIsDisp_HosPhoto());
			pstmt.setString (3, aHosPhotoVO.getHosPhoto_name());
			pstmt.setString (4, aHosPhotoVO.getHosPhoto_extent());
			pstmt.setString (5, aHosPhotoVO.getHosPhoto_Id());
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
	public void delete(String  aHosPhoto){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.DELETE);
			pstmt.setString (1,aHosPhoto);
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
	public HosPhotoVO findByPrimaryKey(String  aPK_NO){
		HosPhotoVO hosphotoVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				hosphotoVO = new HosPhotoVO();
				hosphotoVO.setHosPhoto_Id(rs.getString("hosPhoto_Id"));
				hosphotoVO.setHosPhoto_HosId(rs.getString("hosPhoto_HosId"));
				hosphotoVO.setHosPhoto_photo(rs.getBytes("hosPhoto_photo"));
				hosphotoVO.setIsDisp_HosPhoto(rs.getString("isDisp_HosPhoto"));
				hosphotoVO.setHosPhoto_name(rs.getString("hosPhoto_name"));
				hosphotoVO.setHosPhoto_extent(rs.getString("hosPhoto_extent"));
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
		return hosphotoVO; 
	} 

    @Override
    public List<HosPhotoVO> getAll() {
        List<HosPhotoVO> list = new ArrayList<HosPhotoVO>();
        HosPhotoVO hosphotoVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // hosphotoVO 也稱為 Domain objects
                hosphotoVO = new HosPhotoVO();
                hosphotoVO.setHosPhoto_Id(rs.getString("hosPhoto_Id"));
                hosphotoVO.setHosPhoto_HosId(rs.getString("hosPhoto_HosId"));
                hosphotoVO.setHosPhoto_photo(rs.getBytes("hosPhoto_photo"));
                hosphotoVO.setIsDisp_HosPhoto(rs.getString("isDisp_HosPhoto"));
                hosphotoVO.setHosPhoto_name(rs.getString("hosPhoto_name"));
                hosphotoVO.setHosPhoto_extent(rs.getString("hosPhoto_extent"));

                list.add(hosphotoVO); // Store the row in the vector
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