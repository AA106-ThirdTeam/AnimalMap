package com.second_prodphotos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Second_ProdPhotos;
/** 
 *表格名稱 : <br>
 *	二手商品相簿<br>
 *	英文:second_ProdPhotos<br>
 */ 
public class Second_ProdPhotosDAO implements Second_ProdPhotosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO second_ProdPhotos(second_ProdPhotos_Id,second_Prod_Id ) VALUES  ( second_ProdPhotos_seq1.nextval , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE second_ProdPhotos SET  WHERE second_ProdPhotos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM second_ProdPhotos WHERE second_ProdPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT second_ProdPhotos_Id,second_Prod_Id FROM second_prodphotos WHERE second_ProdPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT second_ProdPhotos_Id,second_Prod_Id FROM second_ProdPhotos order by second_ProdPhotos_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Second_ProdPhotoss_BySecond_Prod_Id_STMT = 
		"SELECT second_ProdPhotos_Id,second_Prod_Id FROM Second_ProdPhotos WHERE second_Prod_Id = ? order by second_Prod_Id";

	//====以下是新增指令====
	//====以下是改寫insert方法====
	@Override
	public void insert(Second_ProdPhotosVO aSecond_ProdPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.INSERT_STMT);
			pstmt.setString (1, aSecond_ProdPhotosVO.getSecond_Prod_Id());
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
	public void update(Second_ProdPhotosVO aSecond_ProdPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.UPDATE);
			pstmt.setString (1, aSecond_ProdPhotosVO.getSecond_ProdPhotos_Id());
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
	public void delete(String  aSecond_ProdPhotos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.DELETE);
			pstmt.setString (1,aSecond_ProdPhotos);
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
	public Second_ProdPhotosVO findByPrimaryKey(String  aPK_NO){
		Second_ProdPhotosVO second_prodphotosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdPhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				second_prodphotosVO = new Second_ProdPhotosVO();
				second_prodphotosVO.setSecond_ProdPhotos_Id(rs.getString("second_ProdPhotos_Id"));
				second_prodphotosVO.setSecond_Prod_Id(rs.getString("second_Prod_Id"));
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
		return second_prodphotosVO; 
	} 

    @Override
    public List<Second_ProdPhotosVO> getAll() {
        List<Second_ProdPhotosVO> list = new ArrayList<Second_ProdPhotosVO>();
        Second_ProdPhotosVO second_prodphotosVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // second_prodphotosVO 也稱為 Domain objects
                second_prodphotosVO = new Second_ProdPhotosVO();
                second_prodphotosVO.setSecond_ProdPhotos_Id(rs.getString("second_ProdPhotos_Id"));
                second_prodphotosVO.setSecond_Prod_Id(rs.getString("second_Prod_Id"));

                list.add(second_prodphotosVO); // Store the row in the vector
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
    public List<Second_ProdPhotosVO> getAll(Map<String, String[]> map) {
        List<Second_ProdPhotosVO> list = new ArrayList<Second_ProdPhotosVO>();
        Second_ProdPhotosVO second_prodphotosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Second_ProdPhotos "
                  + jdbcUtil_CompositeQuery_Second_ProdPhotos.get_WhereCondition(map)
                  + "order by second_ProdPhotos_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                second_prodphotosVO = new Second_ProdPhotosVO();
                
                second_prodphotosVO.setSecond_ProdPhotos_Id(rs.getString ("second_ProdPhotos_Id"));
                second_prodphotosVO.setSecond_Prod_Id(rs.getString ("second_Prod_Id"));
             
                list.add(second_prodphotosVO); // Store the row in the List
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
    public Set<Second_ProdPhotosVO> getSecond_ProdPhotossBySecond_Prod_Id(String second_Prod_Id) {
        Set<Second_ProdPhotosVO> set = new LinkedHashSet<Second_ProdPhotosVO>();
        Second_ProdPhotosVO second_prodphotosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Second_ProdPhotoss_BySecond_Prod_Id_STMT);
            pstmt.setString(1, second_Prod_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                second_prodphotosVO = new Second_ProdPhotosVO();
				second_prodphotosVO.setSecond_ProdPhotos_Id(rs.getString ("second_ProdPhotos_Id"));
				second_prodphotosVO.setSecond_Prod_Id(rs.getString ("second_Prod_Id"));

                set.add(second_prodphotosVO); // Store the row in the vector
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