package com.emg_help.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Emg_help;
/** 
 *表格名稱 : <br>
 *	緊急求救<br>
 *	英文:emg_help<br>
 */ 
public class Emg_helpDAO implements Emg_helpDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO emg_help(emg_H_Id,mem_Id,emg_H_start_date,emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat ) VALUES  ( emg_help_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE emg_help SET emg_H_start_date=?,emg_H_end_date=? ,emg_H_title=? ,emg_H_content=? ,emg_H_Pic=? ,emg_H_Pic_format=? ,emg_H_city=? ,emg_H_town=? ,emg_H_road=? ,emg_H_Lon=? ,emg_H_Lat=?  WHERE emg_H_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM emg_help WHERE emg_H_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT emg_H_Id,mem_Id,to_char(emg_H_start_date,'yyyy-mm-dd') emg_H_start_date,to_char(emg_H_end_date,'yyyy-mm-dd') emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat FROM emg_help WHERE emg_H_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT emg_H_Id,mem_Id,to_char(emg_H_start_date,'yyyy-mm-dd') emg_H_start_date,to_char(emg_H_end_date,'yyyy-mm-dd') emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat FROM emg_help order by emg_H_Id " ; 

	//====以下是GET_ByFK_STMT指令====
    private static final String GET_Emg_helps_ByMem_Id_STMT = 
		"SELECT emg_H_Id,mem_Id,to_char(emg_H_start_date,'yyyy-mm-dd') emg_H_start_date,to_char(emg_H_end_date,'yyyy-mm-dd') emg_H_end_date,emg_H_title,emg_H_content,emg_H_Pic,emg_H_Pic_format,emg_H_city,emg_H_town,emg_H_road,emg_H_Lon,emg_H_Lat FROM Emg_help WHERE mem_Id = ? order by mem_Id";

	//====以下是新增指令====
	private static final String UPDATE_EMG_H_START_DATE =" UPDATE emg_help set EMG_H_START_DATE=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_END_DATE =" UPDATE emg_help set EMG_H_END_DATE=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_TITLE =" UPDATE emg_help set EMG_H_TITLE=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_CONTENT =" UPDATE emg_help set EMG_H_CONTENT=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_PIC =" UPDATE emg_help set EMG_H_PIC=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_PIC_FORMAT =" UPDATE emg_help set EMG_H_PIC_FORMAT=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_CITY =" UPDATE emg_help set EMG_H_CITY=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_TOWN =" UPDATE emg_help set EMG_H_TOWN=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_ROAD =" UPDATE emg_help set EMG_H_ROAD=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_LON =" UPDATE emg_help set EMG_H_LON=?  WHERE emg_H_Id=? " ; 
	private static final String UPDATE_EMG_H_LAT =" UPDATE emg_help set EMG_H_LAT=?  WHERE emg_H_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Emg_helpVO aEmg_helpVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_helpDAO.INSERT_STMT);
			pstmt.setString (1, aEmg_helpVO.getMem_Id());
			pstmt.setDate (2, aEmg_helpVO.getEmg_H_start_date());
			pstmt.setDate (3, aEmg_helpVO.getEmg_H_end_date());
			pstmt.setString (4, aEmg_helpVO.getEmg_H_title());
			pstmt.setString (5, aEmg_helpVO.getEmg_H_content());
			pstmt.setBytes (6, aEmg_helpVO.getEmg_H_Pic());
			pstmt.setString (7, aEmg_helpVO.getEmg_H_Pic_format());
			pstmt.setString (8, aEmg_helpVO.getEmg_H_city());
			pstmt.setString (9, aEmg_helpVO.getEmg_H_town());
			pstmt.setString (10, aEmg_helpVO.getEmg_H_road());
			pstmt.setDouble (11, aEmg_helpVO.getEmg_H_Lon());
			pstmt.setDouble (12, aEmg_helpVO.getEmg_H_Lat());
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
	public void update(Emg_helpVO aEmg_helpVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_helpDAO.UPDATE);
			pstmt.setDate (1, aEmg_helpVO.getEmg_H_start_date());
			pstmt.setDate (2, aEmg_helpVO.getEmg_H_end_date());
			pstmt.setString (3, aEmg_helpVO.getEmg_H_title());
			pstmt.setString (4, aEmg_helpVO.getEmg_H_content());
			pstmt.setBytes (5, aEmg_helpVO.getEmg_H_Pic());
			pstmt.setString (6, aEmg_helpVO.getEmg_H_Pic_format());
			pstmt.setString (7, aEmg_helpVO.getEmg_H_city());
			pstmt.setString (8, aEmg_helpVO.getEmg_H_town());
			pstmt.setString (9, aEmg_helpVO.getEmg_H_road());
			pstmt.setDouble (10, aEmg_helpVO.getEmg_H_Lon());
			pstmt.setDouble (11, aEmg_helpVO.getEmg_H_Lat());
			pstmt.setString (12, aEmg_helpVO.getEmg_H_Id());
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
	public void delete(String  aEmg_help){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_helpDAO.DELETE);
			pstmt.setString (1,aEmg_help);
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
	public Emg_helpVO findByPrimaryKey(String  aPK_NO){
		Emg_helpVO emg_helpVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Emg_helpDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emg_helpVO = new Emg_helpVO();
				emg_helpVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_helpVO.setMem_Id(rs.getString("mem_Id"));
				emg_helpVO.setEmg_H_start_date(rs.getDate("emg_H_start_date"));
				emg_helpVO.setEmg_H_end_date(rs.getDate("emg_H_end_date"));
				emg_helpVO.setEmg_H_title(rs.getString("emg_H_title"));
				emg_helpVO.setEmg_H_content(rs.getString("emg_H_content"));
				emg_helpVO.setEmg_H_Pic(rs.getBytes("emg_H_Pic"));
				emg_helpVO.setEmg_H_Pic_format(rs.getString("emg_H_Pic_format"));
				emg_helpVO.setEmg_H_city(rs.getString("emg_H_city"));
				emg_helpVO.setEmg_H_town(rs.getString("emg_H_town"));
				emg_helpVO.setEmg_H_road(rs.getString("emg_H_road"));
				emg_helpVO.setEmg_H_Lon(rs.getDouble("emg_H_Lon"));
				emg_helpVO.setEmg_H_Lat(rs.getDouble("emg_H_Lat"));
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
		return emg_helpVO; 
	} 

    @Override
    public List<Emg_helpVO> getAll() {
        List<Emg_helpVO> list = new ArrayList<Emg_helpVO>();
        Emg_helpVO emg_helpVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // emg_helpVO 也稱為 Domain objects
                emg_helpVO = new Emg_helpVO();
                emg_helpVO.setEmg_H_Id(rs.getString("emg_H_Id"));
                emg_helpVO.setMem_Id(rs.getString("mem_Id"));
                emg_helpVO.setEmg_H_start_date(rs.getDate("emg_H_start_date"));
                emg_helpVO.setEmg_H_end_date(rs.getDate("emg_H_end_date"));
                emg_helpVO.setEmg_H_title(rs.getString("emg_H_title"));
                emg_helpVO.setEmg_H_content(rs.getString("emg_H_content"));
                emg_helpVO.setEmg_H_Pic(rs.getBytes("emg_H_Pic"));
                emg_helpVO.setEmg_H_Pic_format(rs.getString("emg_H_Pic_format"));
                emg_helpVO.setEmg_H_city(rs.getString("emg_H_city"));
                emg_helpVO.setEmg_H_town(rs.getString("emg_H_town"));
                emg_helpVO.setEmg_H_road(rs.getString("emg_H_road"));
                emg_helpVO.setEmg_H_Lon(rs.getDouble("emg_H_Lon"));
                emg_helpVO.setEmg_H_Lat(rs.getDouble("emg_H_Lat"));

                list.add(emg_helpVO); // Store the row in the vector
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
    public List<Emg_helpVO> getAll(Map<String, String[]> map) {
        List<Emg_helpVO> list = new ArrayList<Emg_helpVO>();
        Emg_helpVO emg_helpVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            con = ds.getConnection();
            String finalSQL = "select * from Emg_help "
                  + jdbcUtil_CompositeQuery_Emg_help.get_WhereCondition(map)
                  + "order by emg_H_Id";
            pstmt = con.prepareStatement(finalSQL);
            System.out.println("●●finalSQL(by DAO) = "+finalSQL);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                emg_helpVO = new Emg_helpVO();
                
                emg_helpVO.setEmg_H_Id(rs.getString ("emg_H_Id"));
                emg_helpVO.setMem_Id(rs.getString ("mem_Id"));
                emg_helpVO.setEmg_H_start_date(rs.getDate ("emg_H_start_date"));
                emg_helpVO.setEmg_H_end_date(rs.getDate ("emg_H_end_date"));
                emg_helpVO.setEmg_H_title(rs.getString ("emg_H_title"));
                emg_helpVO.setEmg_H_content(rs.getString ("emg_H_content"));
                emg_helpVO.setEmg_H_Pic(rs.getBytes ("emg_H_Pic"));
                emg_helpVO.setEmg_H_Pic_format(rs.getString ("emg_H_Pic_format"));
                emg_helpVO.setEmg_H_city(rs.getString ("emg_H_city"));
                emg_helpVO.setEmg_H_town(rs.getString ("emg_H_town"));
                emg_helpVO.setEmg_H_road(rs.getString ("emg_H_road"));
                emg_helpVO.setEmg_H_Lon(rs.getDouble ("emg_H_Lon"));
                emg_helpVO.setEmg_H_Lat(rs.getDouble ("emg_H_Lat"));
             
                list.add(emg_helpVO); // Store the row in the List
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
    public Set<Emg_helpVO> getEmg_helpsByMem_Id(String mem_Id) {
        Set<Emg_helpVO> set = new LinkedHashSet<Emg_helpVO>();
        Emg_helpVO emg_helpVO = null;
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
    
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_Emg_helps_ByMem_Id_STMT);
            pstmt.setString(1, mem_Id);
            rs = pstmt.executeQuery();
    
            while (rs.next()) {
                emg_helpVO = new Emg_helpVO();
				emg_helpVO.setEmg_H_Id(rs.getString ("emg_H_Id"));
				emg_helpVO.setMem_Id(rs.getString ("mem_Id"));
				emg_helpVO.setEmg_H_start_date(rs.getDate ("emg_H_start_date"));
				emg_helpVO.setEmg_H_end_date(rs.getDate ("emg_H_end_date"));
				emg_helpVO.setEmg_H_title(rs.getString ("emg_H_title"));
				emg_helpVO.setEmg_H_content(rs.getString ("emg_H_content"));
				emg_helpVO.setEmg_H_Pic(rs.getBytes ("emg_H_Pic"));
				emg_helpVO.setEmg_H_Pic_format(rs.getString ("emg_H_Pic_format"));
				emg_helpVO.setEmg_H_city(rs.getString ("emg_H_city"));
				emg_helpVO.setEmg_H_town(rs.getString ("emg_H_town"));
				emg_helpVO.setEmg_H_road(rs.getString ("emg_H_road"));
				emg_helpVO.setEmg_H_Lon(rs.getDouble ("emg_H_Lon"));
				emg_helpVO.setEmg_H_Lat(rs.getDouble ("emg_H_Lat"));

                set.add(emg_helpVO); // Store the row in the vector
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