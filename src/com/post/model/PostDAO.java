package com.post.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	討論區<br>
 *	英文:post<br>
 */ 
public class PostDAO implements PostDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO post(post_Id,mem_Id,post_class,post_class_Id,post_title,post_content,post_time,post_upDate,post_resNum ) VALUES  ( post_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE post SET post_class=?,post_class_Id=? ,post_title=? ,post_content=? ,post_time=? ,post_upDate=? ,post_resNum=?  WHERE post_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM post WHERE post_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT post_Id,mem_Id,post_class,post_class_Id,post_title,post_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(post_upDate,'yyyy-mm-dd') post_upDate,post_resNum FROM post WHERE post_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT post_Id,mem_Id,post_class,post_class_Id,post_title,post_content,to_char(post_time,'yyyy-mm-dd') post_time,to_char(post_upDate,'yyyy-mm-dd') post_upDate,post_resNum FROM post order by post_Id " ; 
	//====以下是新增指令====
	private static final String UPDATE_POST_CLASS =" UPDATE post set POST_CLASS=?  WHERE post_Id=? " ; 
	private static final String UPDATE_POST_CLASS_ID =" UPDATE post set POST_CLASS_ID=?  WHERE post_Id=? " ; 
	private static final String UPDATE_POST_TITLE =" UPDATE post set POST_TITLE=?  WHERE post_Id=? " ; 
	private static final String UPDATE_POST_CONTENT =" UPDATE post set POST_CONTENT=?  WHERE post_Id=? " ; 
	private static final String UPDATE_POST_TIME =" UPDATE post set POST_TIME=?  WHERE post_Id=? " ; 
	private static final String UPDATE_POST_UPDATE =" UPDATE post set POST_UPDATE=?  WHERE post_Id=? " ; 
	private static final String UPDATE_POST_RESNUM =" UPDATE post set POST_RESNUM=?  WHERE post_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(PostVO aPostVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PostDAO.INSERT_STMT);
			pstmt.setString (1, aPostVO.getMem_Id());
			pstmt.setString (2, aPostVO.getPost_class());
			pstmt.setString (3, aPostVO.getPost_class_Id());
			pstmt.setString (4, aPostVO.getPost_title());
			pstmt.setString (5, aPostVO.getPost_content());
			pstmt.setDate (6, aPostVO.getPost_time());
			pstmt.setDate (7, aPostVO.getPost_upDate());
			pstmt.setInt (8, aPostVO.getPost_resNum());
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
	public void update(PostVO aPostVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PostDAO.UPDATE);
			pstmt.setString (1, aPostVO.getPost_class());
			pstmt.setString (2, aPostVO.getPost_class_Id());
			pstmt.setString (3, aPostVO.getPost_title());
			pstmt.setString (4, aPostVO.getPost_content());
			pstmt.setDate (5, aPostVO.getPost_time());
			pstmt.setDate (6, aPostVO.getPost_upDate());
			pstmt.setInt (7, aPostVO.getPost_resNum());
			pstmt.setString (8, aPostVO.getPost_Id());
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
	public void delete(String  aPost){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PostDAO.DELETE);
			pstmt.setString (1,aPost);
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
	public PostVO findByPrimaryKey(String  aPK_NO){
		PostVO postVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PostDAO.GET_ONE_STMT);
			pstmt.setString (1,aPK_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				postVO = new PostVO();
				postVO.setPost_Id(rs.getString("post_Id"));
				postVO.setMem_Id(rs.getString("mem_Id"));
				postVO.setPost_class(rs.getString("post_class"));
				postVO.setPost_class_Id(rs.getString("post_class_Id"));
				postVO.setPost_title(rs.getString("post_title"));
				postVO.setPost_content(rs.getString("post_content"));
				postVO.setPost_time(rs.getDate("post_time"));
				postVO.setPost_upDate(rs.getDate("post_upDate"));
				postVO.setPost_resNum(rs.getInt("post_resNum"));
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
		return postVO; 
	} 

    @Override
    public List<PostVO> getAll() {
        List<PostVO> list = new ArrayList<PostVO>();
        PostVO postVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // postVO 也稱為 Domain objects
                postVO = new PostVO();
                postVO.setPost_Id(rs.getString("post_Id"));
                postVO.setMem_Id(rs.getString("mem_Id"));
                postVO.setPost_class(rs.getString("post_class"));
                postVO.setPost_class_Id(rs.getString("post_class_Id"));
                postVO.setPost_title(rs.getString("post_title"));
                postVO.setPost_content(rs.getString("post_content"));
                postVO.setPost_time(rs.getDate("post_time"));
                postVO.setPost_upDate(rs.getDate("post_upDate"));
                postVO.setPost_resNum(rs.getInt("post_resNum"));

                list.add(postVO); // Store the row in the vector
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