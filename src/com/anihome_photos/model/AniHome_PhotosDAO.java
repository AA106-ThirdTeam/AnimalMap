package com.anihome_photos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_AniHome_Photos;
/** 
 *表格名稱 : <br>
 *	動物之家相簿<br>
 *	英文:aniHome_Photos<br>
 */ 
public class AniHome_PhotosDAO implements AniHome_PhotosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO aniHome_Photos(aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic ) VALUES  ( aniHome_Photos_seq1.nextval , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE aniHome_Photos SET aniHome_Photos_pic=? WHERE aniHome_Photos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM aniHome_Photos WHERE aniHome_Photos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic FROM anihome_photos WHERE aniHome_Photos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic FROM aniHome_Photos order by aniHome_Photos_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_AniHome_Photoss_ByAniHome_Id_STMT = 
		"SELECT aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic FROM AniHome_Photos WHERE aniHome_Id = ? order by aniHome_Id";

	//====以下是新增指令====
	private static final String UPDATE_ANIHOME_PHOTOS_PIC =" UPDATE aniHome_Photos set ANIHOME_PHOTOS_PIC=?  WHERE aniHome_Photos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AniHome_PhotosVO aAniHome_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.INSERT_STMT);
			pstmt.setString (1, aAniHome_PhotosVO.getAniHome_Id());
			pstmt.setBytes (2, aAniHome_PhotosVO.getAniHome_Photos_pic());
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
	public void update(AniHome_PhotosVO aAniHome_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.UPDATE);
			pstmt.setBytes (1, aAniHome_PhotosVO.getAniHome_Photos_pic());
			pstmt.setString (2, aAniHome_PhotosVO.getAniHome_Photos_Id());
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
	public void delete(String  aAniHome_Photos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.DELETE);
			pstmt.setString (1,aAniHome_Photos);
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
	public AniHome_PhotosVO findByPrimaryKey(String  aPK_NO){
		AniHome_PhotosVO anihome_photosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				anihome_photosVO = new AniHome_PhotosVO();
				anihome_photosVO.setAniHome_Photos_Id(rs.getString("aniHome_Photos_Id"));
				anihome_photosVO.setAniHome_Id(rs.getString("aniHome_Id"));
				anihome_photosVO.setAniHome_Photos_pic(rs.getBytes("aniHome_Photos_pic"));
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
		return anihome_photosVO; 
	} 

    @Override
    public List<AniHome_PhotosVO> getAll() {
        List<AniHome_PhotosVO> list = new ArrayList<AniHome_PhotosVO>();
        AniHome_PhotosVO anihome_photosVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // anihome_photosVO 也稱為 Domain objects
                anihome_photosVO = new AniHome_PhotosVO();
                anihome_photosVO.setAniHome_Photos_Id(rs.getString("aniHome_Photos_Id"));
                anihome_photosVO.setAniHome_Id(rs.getString("aniHome_Id"));
                anihome_photosVO.setAniHome_Photos_pic(rs.getBytes("aniHome_Photos_pic"));

                list.add(anihome_photosVO); // Store the row in the vector
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

    @Override
    public List<AniHome_PhotosVO> getAll(Map<String, String[]> map) {
        List<AniHome_PhotosVO> list = new ArrayList<AniHome_PhotosVO>();
        AniHome_PhotosVO anihome_photosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from AniHome_Photos "
                  + jdbcUtil_CompositeQuery_AniHome_Photos.get_WhereCondition(map)
                  + "order by aniHome_Photos_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                anihome_photosVO = new AniHome_PhotosVO();
                
                anihome_photosVO.setAniHome_Photos_Id(rs.getString ("aniHome_Photos_Id"));
                anihome_photosVO.setAniHome_Id(rs.getString ("aniHome_Id"));
                anihome_photosVO.setAniHome_Photos_pic(rs.getBytes ("aniHome_Photos_pic"));
             
                list.add(anihome_photosVO); // Store the row in the List
            }
    
            // ====
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


 

    @Override   
    public Set<AniHome_PhotosVO> getAniHome_PhotossByAniHome_Id(String aniHome_Id) {
        Set<AniHome_PhotosVO> set = new LinkedHashSet<AniHome_PhotosVO>();
        AniHome_PhotosVO anihome_photosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_AniHome_Photoss_ByAniHome_Id_STMT);
            pstmt.setString(1, aniHome_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                anihome_photosVO = new AniHome_PhotosVO();
				anihome_photosVO.setAniHome_Photos_Id(rs.getString ("aniHome_Photos_Id"));
				anihome_photosVO.setAniHome_Id(rs.getString ("aniHome_Id"));
				anihome_photosVO.setAniHome_Photos_pic(rs.getBytes ("aniHome_Photos_pic"));

                set.add(anihome_photosVO); // Store the row in the vector
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
        return set;
    }



}