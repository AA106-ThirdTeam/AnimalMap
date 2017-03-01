package com.adoptani_photo.model;

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

import com.adoptani.model.AdoptaniVO;





public class AdoptaniPhotoJNDIDAO implements AdoptaniPhotoDAO_interface{

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
			"INSERT INTO adopt_Ani_photos (ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_nameEX,ado_Pic_time,ado_Pic_type) VALUES (adopt_Ani_photos_Seq.NEXTVAL,?,?,?,?,?,sysdate,?)";
	private static final String GET_ALL_STMT = 
			"SELECT ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_nameEX,ado_Pic_time,ado_Pic_type FROM adopt_Ani_photos";
	
	private static final String GET_ONE_STMT = 
			"SELECT ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_nameEX,ado_Pic_time,ado_Pic_type FROM adopt_Ani_photos where ado_Ani_Pic_No = ?";

	//	private static final String GET_Emps_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM adopt_Ani where adopt_Ani_Id = ? order by empno";
	private static final String GET_AdoptaniPhotos_ByAdoptaniID_STMT =
			"SELECT ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_nameEX,ado_Pic_time,ado_Pic_type FROM adopt_Ani_photos where adopt_Ani_Id = ? order by ado_Pic_time";
	private static final String DELETE = 
			"DELETE FROM adopt_Ani_photos where ado_Ani_Pic_No = ?";
	
	private static final String UPDATE_STMT = 
			"UPDATE adopt_Ani_photos set ado_Ani_Pic=?, ado_Pic_name=?, ado_Pic_nameEX=?, ado_Pic_type=? where ado_Ani_Pic_No = ?";
	
	private static final String UPDATE_HEAD_PHOTO = 
			"UPDATE adopt_Ani_photos set ado_Pic_type=1 where ADOPT_ANI_ID = ? and ado_Pic_type=0";
	
	private static final String UPDATE_TOHEAD_PHOTO = 
			"UPDATE adopt_Ani_photos set ado_Pic_type=0 where ado_Ani_Pic_No = ?";
	
	@Override
	public void insert(AdoptaniPhotoVO adoptaniPhotoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				
				if(((String)adoptaniPhotoVO.getAdo_Pic_type()).equals("0")){
					changeHeadPhotoToNomal(adoptaniPhotoVO.getAdopt_Ani_Id());
				}
				
				
				pstmt.setString(1 , adoptaniPhotoVO.getAdopt_Ani_Id());
				pstmt.setString(2 , adoptaniPhotoVO.getMem_Id());
				pstmt.setBytes(3 , adoptaniPhotoVO.getAdo_Ani_Pic());
				pstmt.setString(4 , adoptaniPhotoVO.getAdo_Pic_name());
				pstmt.setString(5, adoptaniPhotoVO.getAdo_Pic_nameEX());
				pstmt.setString(6 , adoptaniPhotoVO.getAdo_Pic_type());
		
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
	public void update(AdoptaniPhotoVO adoptaniPhotoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_STMT);
				
				
				
				
				pstmt.setBytes(1 , adoptaniPhotoVO.getAdo_Ani_Pic());
				pstmt.setString(2 , adoptaniPhotoVO.getAdo_Pic_name());
				pstmt.setString(3, adoptaniPhotoVO.getAdo_Pic_nameEX());
				pstmt.setString(4 , adoptaniPhotoVO.getAdo_Pic_type());
				pstmt.setString(5 , adoptaniPhotoVO.getAdo_Ani_Pic_No());
				
				
				
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
	public void delete(String ado_Ani_Pic_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				
				
				
				
				pstmt.setString(1 , ado_Ani_Pic_No);
				
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
	public AdoptaniPhotoVO findByPrimaryKey(String ado_Ani_Pic_No) {
		
		AdoptaniPhotoVO adoptaniPhotoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				
				
				
				
				pstmt.setString(1 , ado_Ani_Pic_No);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					//adoptaniPhotoVO也稱為Domain objects
					adoptaniPhotoVO =new AdoptaniPhotoVO();
					
					adoptaniPhotoVO.setAdo_Ani_Pic_No(rs.getString("Ado_Ani_Pic_No"));
					adoptaniPhotoVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
					adoptaniPhotoVO.setMem_Id(rs.getString("Mem_Id"));
					adoptaniPhotoVO.setAdo_Ani_Pic(rs.getBytes("Ado_Ani_Pic"));
					adoptaniPhotoVO.setAdo_Pic_name(rs.getString("Ado_Pic_name"));
					adoptaniPhotoVO.setAdo_Pic_nameEX(rs.getString("Ado_Pic_nameEX"));
					adoptaniPhotoVO.setAdo_Pic_time(rs.getTimestamp("Ado_Pic_time"));
					adoptaniPhotoVO.setAdo_Pic_type(rs.getString("Ado_Pic_type"));
					
					
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
		
	
		return adoptaniPhotoVO;
	}

	@Override
	public List<AdoptaniPhotoVO> getAll() {

		List<AdoptaniPhotoVO> list = new ArrayList<AdoptaniPhotoVO>();
		AdoptaniPhotoVO adoptaniPhotoVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//adoptaniPhotoVO也稱為Domain objects
					adoptaniPhotoVO =new AdoptaniPhotoVO();
					
					adoptaniPhotoVO.setAdo_Ani_Pic_No(rs.getString("Ado_Ani_Pic_No"));
					adoptaniPhotoVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
					adoptaniPhotoVO.setMem_Id(rs.getString("Mem_Id"));
					adoptaniPhotoVO.setAdo_Ani_Pic(rs.getBytes("Ado_Ani_Pic"));
					adoptaniPhotoVO.setAdo_Pic_name(rs.getString("Ado_Pic_name"));
					adoptaniPhotoVO.setAdo_Pic_nameEX(rs.getString("Ado_Pic_nameEX"));
					adoptaniPhotoVO.setAdo_Pic_time(rs.getTimestamp("Ado_Pic_time"));
					adoptaniPhotoVO.setAdo_Pic_type(rs.getString("Ado_Pic_type"));
					
					list.add(adoptaniPhotoVO);
					
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
	public List<AdoptaniPhotoVO> getOneAdoptAni(String adopt_Ani_Id) {
		
		List<AdoptaniPhotoVO> list = new ArrayList<AdoptaniPhotoVO>();
		AdoptaniPhotoVO adoptaniPhotoVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_AdoptaniPhotos_ByAdoptaniID_STMT);
				
				
				pstmt.setString(1 , adopt_Ani_Id);
				
				rs = pstmt.executeQuery();
				
				
				while (rs.next()){
					//adoptaniPhotoVO也稱為Domain objects
					adoptaniPhotoVO =new AdoptaniPhotoVO();
					
					adoptaniPhotoVO.setAdo_Ani_Pic_No(rs.getString("Ado_Ani_Pic_No"));
					adoptaniPhotoVO.setAdopt_Ani_Id(rs.getString("Adopt_Ani_Id"));
					adoptaniPhotoVO.setMem_Id(rs.getString("Mem_Id"));
					adoptaniPhotoVO.setAdo_Ani_Pic(rs.getBytes("Ado_Ani_Pic"));
					adoptaniPhotoVO.setAdo_Pic_name(rs.getString("Ado_Pic_name"));
					adoptaniPhotoVO.setAdo_Pic_nameEX(rs.getString("Ado_Pic_nameEX"));
					adoptaniPhotoVO.setAdo_Pic_time(rs.getTimestamp("Ado_Pic_time"));
					adoptaniPhotoVO.setAdo_Pic_type(rs.getString("Ado_Pic_type"));
					
					list.add(adoptaniPhotoVO);
					
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
	public void changeHeadPhotoToNomal(String adopt_Ani_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_HEAD_PHOTO);
				
				
				
				
				pstmt.setString(1 ,adopt_Ani_Id);
				
				
				
				
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
	public void changeNomalPhotoToHead(String adopt_Ani_Id, String ado_Ani_Pic_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_TOHEAD_PHOTO);
				
				changeHeadPhotoToNomal(adopt_Ani_Id);
				
				
				pstmt.setString(1 ,ado_Ani_Pic_No);
				
				
				
				
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


