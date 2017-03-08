package com.strayani_photo.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.strayani.model.StrayaniVO;





public class StrayaniPhotoJNDIDAO implements StrayaniPhotoDAO_interface{

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"INSERT INTO stray_Ani_photos (str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_nameEX,stray_Pic_time,stray_Pic_type) VALUES (stray_Ani_photos_Seq.NEXTVAL,?,?,?,?,?,sysdate,?)";
	private static final String GET_ALL_STMT = 
			"SELECT str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_nameEX,stray_Pic_time,stray_Pic_type FROM stray_Ani_photos";
	
	private static final String GET_ONE_STMT = 
			"SELECT str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_nameEX,stray_Pic_time,stray_Pic_type FROM stray_Ani_photos where str_Ani_Pic_No = ?";

	//	private static final String GET_Emps_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM stray_Ani where stray_Ani_Id = ? order by empno";
	private static final String GET_StrayaniPhotos_ByStrayaniID_STMT =
			"SELECT str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_nameEX,stray_Pic_time,stray_Pic_type FROM stray_Ani_photos where stray_Ani_Id = ? order by stray_Pic_time";
	
	private static final String DELETE = 
			"DELETE FROM stray_Ani_photos where str_Ani_Pic_No = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE stray_Ani_photos set stray_Ani_Pic=?, stray_Pic_name=?, stray_Pic_nameEX=?, stray_Pic_type=? where str_Ani_Pic_No = ?";
	
	private static final String UPDATE_HEAD_PHOTO = 
			"UPDATE stray_Ani_photos set stray_Pic_type=1 where stray_Ani_Id = ? and stray_Pic_type=0";
	
	private static final String UPDATE_TOHEAD_PHOTO = 
			"UPDATE stray_Ani_photos set stray_Pic_type=0 where str_Ani_Pic_No = ?";
	
	@Override
	public void insert(StrayaniPhotoVO strayaniPhotoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				
				if(((String)strayaniPhotoVO.getStray_Pic_type()).equals("0")){
					changeHeadPhotoToNomal(strayaniPhotoVO.getStray_Ani_Id());
				}
				
				
				
				pstmt.setString(1 , strayaniPhotoVO.getStray_Ani_Id());
				pstmt.setString(2 , strayaniPhotoVO.getMem_Id());
				pstmt.setBytes(3 , strayaniPhotoVO.getStray_Ani_Pic());
				pstmt.setString(4 , strayaniPhotoVO.getStray_Pic_name());
				pstmt.setString(5, strayaniPhotoVO.getStray_Pic_nameEX());
				pstmt.setString(6 , strayaniPhotoVO.getStray_Pic_type());
		
				pstmt.executeUpdate();
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	}

	@Override
	public void update(StrayaniPhotoVO strayaniPhotoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_STMT);
				
				
				
				
				pstmt.setBytes(1 , strayaniPhotoVO.getStray_Ani_Pic());
				pstmt.setString(2 , strayaniPhotoVO.getStray_Pic_name());
				pstmt.setString(3, strayaniPhotoVO.getStray_Pic_nameEX());
				pstmt.setString(4 , strayaniPhotoVO.getStray_Pic_type());
				pstmt.setString(5 , strayaniPhotoVO.getStr_Ani_Pic_No());
				
				
				
				pstmt.executeUpdate();
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	}

	@Override
	public void delete(String str_Ani_Pic_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				
				
				
				
				pstmt.setString(1 , str_Ani_Pic_No);
				
				pstmt.executeUpdate();
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	}

	@Override
	public StrayaniPhotoVO findByPrimaryKey(String str_Ani_Pic_No) {
		
		StrayaniPhotoVO strayaniPhotoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				
				
				
				
				pstmt.setString(1 , str_Ani_Pic_No);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					//strayaniPhotoVO也稱為Domain objects
					strayaniPhotoVO =new StrayaniPhotoVO();
					
					strayaniPhotoVO.setStr_Ani_Pic_No(rs.getString("Str_Ani_Pic_No"));
					strayaniPhotoVO.setStray_Ani_Id(rs.getString("Stray_Ani_Id"));
					strayaniPhotoVO.setMem_Id(rs.getString("Mem_Id"));
					strayaniPhotoVO.setStray_Ani_Pic(rs.getBytes("Stray_Ani_Pic"));
					strayaniPhotoVO.setStray_Pic_name(rs.getString("Stray_Pic_name"));
					strayaniPhotoVO.setStray_Pic_nameEX(rs.getString("Stray_Pic_nameEX"));
					strayaniPhotoVO.setStray_Pic_time(rs.getTimestamp("Stray_Pic_time"));
					strayaniPhotoVO.setStray_Pic_type(rs.getString("Stray_Pic_type"));
					
					
				}
				
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	
		return strayaniPhotoVO;
	}

	@Override
	public List<StrayaniPhotoVO> getAll() {

		List<StrayaniPhotoVO> list = new ArrayList<StrayaniPhotoVO>();
		StrayaniPhotoVO strayaniPhotoVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//strayaniPhotoVO也稱為Domain objects
					strayaniPhotoVO =new StrayaniPhotoVO();
					
					strayaniPhotoVO.setStr_Ani_Pic_No(rs.getString("Str_Ani_Pic_No"));
					strayaniPhotoVO.setStray_Ani_Id(rs.getString("Stray_Ani_Id"));
					strayaniPhotoVO.setMem_Id(rs.getString("Mem_Id"));
					strayaniPhotoVO.setStray_Ani_Pic(rs.getBytes("Stray_Ani_Pic"));
					strayaniPhotoVO.setStray_Pic_name(rs.getString("Stray_Pic_name"));
					strayaniPhotoVO.setStray_Pic_nameEX(rs.getString("Stray_Pic_nameEX"));
					strayaniPhotoVO.setStray_Pic_time(rs.getTimestamp("Stray_Pic_time"));
					strayaniPhotoVO.setStray_Pic_type(rs.getString("Stray_Pic_type"));
					
					
					list.add(strayaniPhotoVO);
					
				}
				
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	
		return list;
	}

	@Override
	public List<StrayaniPhotoVO> getOneStrayAni(String stray_Ani_Id) {
		
		List<StrayaniPhotoVO> list = new ArrayList<StrayaniPhotoVO>();
		StrayaniPhotoVO strayaniPhotoVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_StrayaniPhotos_ByStrayaniID_STMT);
				
				
				pstmt.setString(1 , stray_Ani_Id);
				
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//strayaniPhotoVO也稱為Domain objects
					strayaniPhotoVO =new StrayaniPhotoVO();
					
					strayaniPhotoVO.setStr_Ani_Pic_No(rs.getString("Str_Ani_Pic_No"));
					strayaniPhotoVO.setStray_Ani_Id(rs.getString("Stray_Ani_Id"));
					strayaniPhotoVO.setMem_Id(rs.getString("Mem_Id"));
					strayaniPhotoVO.setStray_Ani_Pic(rs.getBytes("Stray_Ani_Pic"));
					strayaniPhotoVO.setStray_Pic_name(rs.getString("Stray_Pic_name"));
					strayaniPhotoVO.setStray_Pic_nameEX(rs.getString("Stray_Pic_nameEX"));
					strayaniPhotoVO.setStray_Pic_time(rs.getTimestamp("Stray_Pic_time"));
					strayaniPhotoVO.setStray_Pic_type(rs.getString("Stray_Pic_type"));
					
					list.add(strayaniPhotoVO);
					
				}
				
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	
		return list;
	}
	
	@Override
	public void changeHeadPhotoToNomal(String stray_Ani_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_HEAD_PHOTO);
				
				
				
				
				pstmt.setString(1 ,stray_Ani_Id);
				
				
				
				
				pstmt.executeUpdate();
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	}

	@Override
	public void changeNomalPhotoToHead(String stray_Ani_Id, String str_Ani_Pic_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_TOHEAD_PHOTO);
				
				changeHeadPhotoToNomal(stray_Ani_Id);
				
				
				pstmt.setString(1 ,str_Ani_Pic_No);
				
				
				
				
				pstmt.executeUpdate();
				
				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				
				// Clean up JDBC resources
			} finally {
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}				
			}	if(con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		
	}


}


