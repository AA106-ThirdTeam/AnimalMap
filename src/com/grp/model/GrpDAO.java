package com.grp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.grpComm.model.GrpCommVO;
import com.joinlist.model.JoinListDAO;
import com.joinlist.model.JoinListVO;

public class GrpDAO implements GrpDAO_interface{

	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO petGroup (grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road, grp_StartTime,grp_EndTime, "
			+ "grp_CreateTime, grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo) VALUES (PETGROUP_SEQ1.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE,?,?,?,?,?)";

	private static final String GET_ALL_STMT = "SELECT grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road,  "
			+ " grp_StartTime, grp_EndTime, to_char(grp_CreateTime,'yyyy-mm-dd') grp_CreateTime, "
			+ "grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo FROM petGroup order by grp_id";

	private static final String FIND_BY_PRIMEKEY_STMT = "SELECT grp_Id, grp_MemId, grp_name, grp_city, grp_town, grp_road,"
			+ "grp_StartTime, grp_EndTime, grp_CreateTime, "
			+ "grp_Desc, grp_Long, grp_Lat, grp_visible, grp_photo FROM petGroup where grp_Id=?";

	private static final String DELETE = "DELETE FROM petGroup where grp_Id = ?";
	
	private static final String UPDATE = "UPDATE petGroup set grp_MemId=? , grp_name=? , grp_city=? , grp_town=? , grp_road=? "
			+ ",  grp_StartTime=? , grp_EndTime=? ,  grp_CreateTime=? , "
			+ "grp_Desc=? , grp_Long=? , grp_Lat=? , grp_visible=? , grp_photo=?  where grp_Id=?";
	
	private static final String GET_COMMENT_BY_GRPID_STMT ="SELECT grpComment_Id, grpComment_MemId, grpComment_GrpId, grpComment_content,"
			+ " grpComment_SendTime FROM grp_comment where grpComment_GrpId=? order by grpComment_SendTime desc";

	private static final String GET_JOINLIST_BY_GRPID_STMT ="SELECT joinList_GrpId,joinList_MemId,joinList_isInvited  FROM JoinList where joinList_GrpId=?" ;

	private static final String GET_JOINLIST_BY_MEMID_STMT ="SELECT joinList_GrpId,joinList_MemId,joinList_isInvited  FROM JoinList where joinList_MemId=?" ;
	
	public static final String GET_COUNT_STMT = "select COUNT(*) count from joinlist where joinList_isInvited='0' AND joinlist_grpid=?";

	
	
	@Override
	public GrpVO insert(GrpVO grpVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("DAO HI");
			con = ds.getConnection();
			
			String[] cols={"grp_Id"};
			pstmt = con.prepareStatement(INSERT_STMT,cols);

			con.setAutoCommit(false);
System.out.println("grpVO.getGrp_StartTime()="+grpVO.getGrp_StartTime());
			

System.out.println(grpVO.getGrp_MemId());
System.out.println(grpVO.getGrp_name());
System.out.println(grpVO.getGrp_city());
System.out.println(grpVO.getGrp_town());
System.out.println(grpVO.getGrp_road());
System.out.println(grpVO.getGrp_StartTime());
System.out.println(grpVO.getGrp_EndTime());
System.out.println(grpVO.getGrp_Desc());
System.out.println(grpVO.getGrp_Long());
System.out.println(grpVO.getGrp_Lat());
System.out.println(grpVO.getGrp_visible());
System.out.println(grpVO.getGrp_photo());
			
			
			
			pstmt.setString(1, grpVO.getGrp_MemId());
			pstmt.setString(2, grpVO.getGrp_name());
			pstmt.setString(3, grpVO.getGrp_city());
			pstmt.setString(4, grpVO.getGrp_town());
			pstmt.setString(5, grpVO.getGrp_road());
			pstmt.setTimestamp(6, grpVO.getGrp_StartTime());
			pstmt.setTimestamp(7, grpVO.getGrp_EndTime());
			pstmt.setString(8, grpVO.getGrp_Desc());
			pstmt.setDouble(9, grpVO.getGrp_Long());
			pstmt.setDouble(10, grpVO.getGrp_Lat());
			pstmt.setString(11, grpVO.getGrp_visible());
			pstmt.setBytes(12, grpVO.getGrp_photo());
									
			pstmt.executeUpdate();
			
			rs=pstmt.getGeneratedKeys();
			rs.next();
			String key = rs.getString(1);
			grpVO.setGrp_Id(key);
			System.out.println("key="+key);			
			con.commit();
			con.setAutoCommit(true);
			// Handle any driver errors
		}  catch (SQLException se) {

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
		return grpVO;

	}

	@Override
	public void update(GrpVO grpVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1,grpVO.getGrp_MemId());
			pstmt.setString(2,grpVO.getGrp_name());
			pstmt.setString(3,grpVO.getGrp_city());
			pstmt.setString(4,grpVO.getGrp_town());
			pstmt.setString(5,grpVO.getGrp_road());
			pstmt.setTimestamp(7,grpVO.getGrp_EndTime());
			pstmt.setTimestamp(6,grpVO.getGrp_StartTime());
			pstmt.setDate(8,grpVO.getGrp_CreateTime());
			pstmt.setString(9,grpVO.getGrp_Desc());
			pstmt.setDouble(10,grpVO.getGrp_Long());
			pstmt.setDouble(11,grpVO.getGrp_Lat());
			pstmt.setString(12,grpVO.getGrp_visible());
			pstmt.setBytes(13,grpVO.getGrp_photo());
			
			pstmt.setString(14,grpVO.getGrp_Id());
			
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
	public void delete(String grp_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			con.setAutoCommit(false);
					
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1,grp_Id);
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
	public GrpVO findByPrimaryKey(String grp_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GrpVO grpvo = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PRIMEKEY_STMT);
			pstmt.setString(1, grp_Id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				grpvo = new GrpVO();
System.out.println("rs.getTimestamp(8)="+rs.getTimestamp(8));
				grpvo.setGrp_Id(rs.getString(1));
				grpvo.setGrp_MemId(rs.getString(2));
				grpvo.setGrp_name(rs.getString(3));
				grpvo.setGrp_city(rs.getString(4));
				grpvo.setGrp_town(rs.getString(5));
				grpvo.setGrp_road(rs.getString(6));
				grpvo.setGrp_EndTime(rs.getTimestamp(8));
				grpvo.setGrp_StartTime(rs.getTimestamp(7));
				grpvo.setGrp_CreateTime(rs.getDate(9));
				grpvo.setGrp_Desc(rs.getString(10));
				grpvo.setGrp_Long(rs.getDouble(11));
				grpvo.setGrp_Lat(rs.getDouble(12));
				grpvo.setGrp_visible(rs.getString(13));
				grpvo.setGrp_photo(rs.getBytes(14));
			}

		}  catch (SQLException e) {
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

		return grpvo;
	}

	@Override
	public List<GrpVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GrpVO> list = new ArrayList<>();
		try {
			
			con = ds.getConnection();

			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrpVO grpvo = new GrpVO();

				grpvo.setGrp_Id(rs.getString(1));
				grpvo.setGrp_MemId(rs.getString(2));
				grpvo.setGrp_name(rs.getString(3));
				grpvo.setGrp_city(rs.getString(4));
				grpvo.setGrp_town(rs.getString(5));
				grpvo.setGrp_road(rs.getString(6));
				grpvo.setGrp_EndTime(rs.getTimestamp(8));
				grpvo.setGrp_StartTime(rs.getTimestamp(7));
				grpvo.setGrp_CreateTime(java.sql.Date.valueOf(rs.getString(9)));
				grpvo.setGrp_Desc(rs.getString(10));
				grpvo.setGrp_Long(rs.getDouble(11));
				grpvo.setGrp_Lat(rs.getDouble(12));
				grpvo.setGrp_visible(rs.getString(13));
				grpvo.setGrp_photo(rs.getBytes(14));

				list.add(grpvo);
			}

		}  catch (SQLException se) {
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
	public Set<GrpCommVO> getCommentsByGrpId(String grp_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Set<GrpCommVO> set = new LinkedHashSet<>();
		try {
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_COMMENT_BY_GRPID_STMT);
			
			pstmt.setString(1, grp_Id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrpCommVO grpCommVO = new GrpCommVO();
				
				grpCommVO.setGrpComment_Id(rs.getString(1));
				grpCommVO.setGrpComment_MemId(rs.getString(2));
				grpCommVO.setGrpComment_GrpId(rs.getString(3));
				grpCommVO.setGrpComment_content(rs.getString(4));
				grpCommVO.setGrpComment_SendTime(rs.getTimestamp(5));
	
				set.add(grpCommVO);
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
	public Set<JoinListVO> getJoinListByGrpId(String grp_Id) {
		Set<JoinListVO> set = new LinkedHashSet<JoinListVO>();
        JoinListVO joinlistVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_JOINLIST_BY_GRPID_STMT);
            
            pstmt.setString(1, grp_Id);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // joinlistVO 也稱為 Domain objects
                joinlistVO = new JoinListVO();
                joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
                joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
                joinlistVO.setJoinList_isInvited(rs.getString("joinList_isInvited"));

                set.add(joinlistVO); // Store the row in the vector
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
        return set;
    }
	
	@Override
	public int get_count_By_joinList_GrpId(String joinList_GrpId) {
		int count = 0; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_COUNT_STMT);
			pstmt.setString (1,joinList_GrpId);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt("count");
				
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
		return count; 
	}

	@Override
	public Set<JoinListVO> getJoinListByMemId(String mem_Id) {
		Set<JoinListVO> set = new LinkedHashSet<JoinListVO>();
        JoinListVO joinlistVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_JOINLIST_BY_MEMID_STMT);
            
            pstmt.setString(1, mem_Id);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // joinlistVO 也稱為 Domain objects
                joinlistVO = new JoinListVO();
                joinlistVO.setJoinList_GrpId(rs.getString("joinList_GrpId"));
                joinlistVO.setJoinList_MemId(rs.getString("joinList_MemId"));
                joinlistVO.setJoinList_isInvited(rs.getString("joinList_isInvited"));

                set.add(joinlistVO); // Store the row in the vector
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
        return set;
	}
	
}
