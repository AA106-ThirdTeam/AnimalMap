package com.pet_photos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Pet_Photos;
/** 
 *表格名稱 : <br>
 *	自家寵物相簿<br>
 *	英文:pet_Photos<br>
 */ 
public class Pet_PhotosDAO implements Pet_PhotosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO pet_Photos(pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,pet_Pic_time,pet_Pic_type ) VALUES  ( pet_Photos_seq1.nextval , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet_Photos SET pet_Pic=?,pet_Pic_name=? ,pet_Pic_extent=? ,pet_Pic_time=? ,pet_Pic_type=?  WHERE pet_Pic_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet_Photos WHERE pet_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,to_char(pet_Pic_time,'yyyy-mm-dd') pet_Pic_time,pet_Pic_type FROM pet_photos WHERE pet_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,to_char(pet_Pic_time,'yyyy-mm-dd') pet_Pic_time,pet_Pic_type FROM pet_Photos order by pet_Pic_No " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Pet_Photoss_ByPet_Id_STMT = 
		"SELECT pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,to_char(pet_Pic_time,'yyyy-mm-dd') pet_Pic_time,pet_Pic_type FROM Pet_Photos WHERE pet_Id = ? order by pet_Id";
    private static final String GET_Pet_Photoss_ByMem_Id_STMT = 
		"SELECT pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,to_char(pet_Pic_time,'yyyy-mm-dd') pet_Pic_time,pet_Pic_type FROM Pet_Photos WHERE mem_Id = ? order by mem_Id";

	//====以下是新增指令====
	private static final String UPDATE_PET_PIC =" UPDATE pet_Photos set PET_PIC=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_NAME =" UPDATE pet_Photos set PET_PIC_NAME=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_EXTENT =" UPDATE pet_Photos set PET_PIC_EXTENT=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_TIME =" UPDATE pet_Photos set PET_PIC_TIME=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_TYPE =" UPDATE pet_Photos set PET_PIC_TYPE=?  WHERE pet_Pic_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Pet_PhotosVO aPet_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.INSERT_STMT);
			pstmt.setString (1, aPet_PhotosVO.getPet_Id());
			pstmt.setString (2, aPet_PhotosVO.getMem_Id());
			pstmt.setBytes (3, aPet_PhotosVO.getPet_Pic());
			pstmt.setString (4, aPet_PhotosVO.getPet_Pic_name());
			pstmt.setString (5, aPet_PhotosVO.getPet_Pic_extent());
			pstmt.setDate (6, aPet_PhotosVO.getPet_Pic_time());
			pstmt.setString (7, aPet_PhotosVO.getPet_Pic_type());
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
	public void update(Pet_PhotosVO aPet_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.UPDATE);
			pstmt.setBytes (1, aPet_PhotosVO.getPet_Pic());
			pstmt.setString (2, aPet_PhotosVO.getPet_Pic_name());
			pstmt.setString (3, aPet_PhotosVO.getPet_Pic_extent());
			pstmt.setDate (4, aPet_PhotosVO.getPet_Pic_time());
			pstmt.setString (5, aPet_PhotosVO.getPet_Pic_type());
			pstmt.setString (6, aPet_PhotosVO.getPet_Pic_No());
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
	public void delete(String  aPet_Photos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.DELETE);
			pstmt.setString (1,aPet_Photos);
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
	public Pet_PhotosVO findByPrimaryKey(String  aPK_NO){
		Pet_PhotosVO pet_photosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pet_photosVO = new Pet_PhotosVO();
				pet_photosVO.setPet_Pic_No(rs.getString("pet_Pic_No"));
				pet_photosVO.setPet_Id(rs.getString("pet_Id"));
				pet_photosVO.setMem_Id(rs.getString("mem_Id"));
				pet_photosVO.setPet_Pic(rs.getBytes("pet_Pic"));
				pet_photosVO.setPet_Pic_name(rs.getString("pet_Pic_name"));
				pet_photosVO.setPet_Pic_extent(rs.getString("pet_Pic_extent"));
				pet_photosVO.setPet_Pic_time(rs.getDate("pet_Pic_time"));
				pet_photosVO.setPet_Pic_type(rs.getString("pet_Pic_type"));
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
		return pet_photosVO; 
	} 

    @Override
    public List<Pet_PhotosVO> getAll() {
        List<Pet_PhotosVO> list = new ArrayList<Pet_PhotosVO>();
        Pet_PhotosVO pet_photosVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // pet_photosVO 也稱為 Domain objects
                pet_photosVO = new Pet_PhotosVO();
                pet_photosVO.setPet_Pic_No(rs.getString("pet_Pic_No"));
                pet_photosVO.setPet_Id(rs.getString("pet_Id"));
                pet_photosVO.setMem_Id(rs.getString("mem_Id"));
                pet_photosVO.setPet_Pic(rs.getBytes("pet_Pic"));
                pet_photosVO.setPet_Pic_name(rs.getString("pet_Pic_name"));
                pet_photosVO.setPet_Pic_extent(rs.getString("pet_Pic_extent"));
                pet_photosVO.setPet_Pic_time(rs.getDate("pet_Pic_time"));
                pet_photosVO.setPet_Pic_type(rs.getString("pet_Pic_type"));

                list.add(pet_photosVO); // Store the row in the vector
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
    public List<Pet_PhotosVO> getAll(Map<String, String[]> map) {
        List<Pet_PhotosVO> list = new ArrayList<Pet_PhotosVO>();
        Pet_PhotosVO pet_photosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Pet_Photos "
                  + jdbcUtil_CompositeQuery_Pet_Photos.get_WhereCondition(map)
                  + "order by pet_Pic_No";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                pet_photosVO = new Pet_PhotosVO();
                
                pet_photosVO.setPet_Pic_No(rs.getString ("pet_Pic_No"));
                pet_photosVO.setPet_Id(rs.getString ("pet_Id"));
                pet_photosVO.setMem_Id(rs.getString ("mem_Id"));
                pet_photosVO.setPet_Pic(rs.getBytes ("pet_Pic"));
                pet_photosVO.setPet_Pic_name(rs.getString ("pet_Pic_name"));
                pet_photosVO.setPet_Pic_extent(rs.getString ("pet_Pic_extent"));
                pet_photosVO.setPet_Pic_time(rs.getDate ("pet_Pic_time"));
                pet_photosVO.setPet_Pic_type(rs.getString ("pet_Pic_type"));
             
                list.add(pet_photosVO); // Store the row in the List
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
    public Set<Pet_PhotosVO> getPet_PhotossByPet_Id(String pet_Id) {
        Set<Pet_PhotosVO> set = new LinkedHashSet<Pet_PhotosVO>();
        Pet_PhotosVO pet_photosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Pet_Photoss_ByPet_Id_STMT);
            pstmt.setString(1, pet_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                pet_photosVO = new Pet_PhotosVO();
				pet_photosVO.setPet_Pic_No(rs.getString ("pet_Pic_No"));
				pet_photosVO.setPet_Id(rs.getString ("pet_Id"));
				pet_photosVO.setMem_Id(rs.getString ("mem_Id"));
				pet_photosVO.setPet_Pic(rs.getBytes ("pet_Pic"));
				pet_photosVO.setPet_Pic_name(rs.getString ("pet_Pic_name"));
				pet_photosVO.setPet_Pic_extent(rs.getString ("pet_Pic_extent"));
				pet_photosVO.setPet_Pic_time(rs.getDate ("pet_Pic_time"));
				pet_photosVO.setPet_Pic_type(rs.getString ("pet_Pic_type"));

                set.add(pet_photosVO); // Store the row in the vector
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


 

    @Override   
    public Set<Pet_PhotosVO> getPet_PhotossByMem_Id(String mem_Id) {
        Set<Pet_PhotosVO> set = new LinkedHashSet<Pet_PhotosVO>();
        Pet_PhotosVO pet_photosVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Pet_Photoss_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                pet_photosVO = new Pet_PhotosVO();
				pet_photosVO.setPet_Pic_No(rs.getString ("pet_Pic_No"));
				pet_photosVO.setPet_Id(rs.getString ("pet_Id"));
				pet_photosVO.setMem_Id(rs.getString ("mem_Id"));
				pet_photosVO.setPet_Pic(rs.getBytes ("pet_Pic"));
				pet_photosVO.setPet_Pic_name(rs.getString ("pet_Pic_name"));
				pet_photosVO.setPet_Pic_extent(rs.getString ("pet_Pic_extent"));
				pet_photosVO.setPet_Pic_time(rs.getDate ("pet_Pic_time"));
				pet_photosVO.setPet_Pic_type(rs.getString ("pet_Pic_type"));

                set.add(pet_photosVO); // Store the row in the vector
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