package com.emg_H.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.emg_H_Msg.model.Emg_H_MsgVO;

public class Emg_HDAO_JDBC implements Emg_HDAO_interface {

	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106";
	String passwd = "aa106";
	
		private static final String INSERT_STMT = 
			"Insert into emg_help values (emg_help_seq1.nextval,?,?,?,?,?,?,null,?,?,?,?,?,null)";
		private static final String GET_ALL_STMT = 
			"SELECT emg_H_Id,mem_Id,  emg_H_start_date, emg_H_end_date,emg_H_title,emg_H_content,emg_H_pic,emg_H_city,emg_H_town,emg_H_road,emg_H_lon,emg_H_lat,emg_H_status FROM emg_help order by emg_H_Id";
		private static final String GET_ONE_STMT = 
			"SELECT emg_H_Id,mem_Id,  emg_H_start_date, emg_H_end_date,emg_H_title,emg_H_content,emg_H_pic,emg_H_city,emg_H_town,emg_H_road,emg_H_lon,emg_H_lat,emg_H_status FROM emg_help  where emg_H_Id = ?";
		private static final String GET_EMG_H_MSG_ByEMG_H_ID_STMT = 
			"SELECT emg_H_Msg_Id,mem_Id,Emg_H_Id, emg_H_msg_start,emg_H_Msg_content FROM emg_H_Msg where emg_H_Id = ? order by emg_H_Msg_Id";
		
		private static final String DELETE_EMG_H_MSG = 
			"DELETE FROM emg_H_Msg where emg_H_Id = ?";
		private static final String DELETE_EMG_H= 
			"DELETE FROM emg_help where emg_H_Id = ?";
	
	

	@Override
	public void insert(Emg_HVO emg_HVO) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);		
		
		
		pstmt.setString(1, emg_HVO.getMem_Id());
		pstmt.setTimestamp(2, emg_HVO.getEmg_H_start_date());
		pstmt.setTimestamp(3, emg_HVO.getEmg_H_end_date());
		pstmt.setString(4, emg_HVO.getEmg_H_title());
		pstmt.setString(5, emg_HVO.getEmg_H_content());
		pstmt.setBytes(6, emg_HVO.getEmg_H_pic());
		pstmt.setString(7, emg_HVO.getEmg_H_city());
		pstmt.setString(8, emg_HVO.getEmg_H_town());
		pstmt.setString(9, emg_HVO.getEmg_H_road());
		pstmt.setDouble(10, emg_HVO.getEmg_H_Lon());
		pstmt.setDouble(11, emg_HVO.getEmg_H_Lat());
		

		pstmt.executeUpdate();

		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. " + se.getMessage());
		// Clean up JDBC resources
	} catch (ClassNotFoundException e) {
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

}

	@Override
	public void delete(String emg_H_Id) {
		// TODO Auto-generated method stub
		
		int updateCount_EmgMsg = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);

			// 先刪除 留言table的求救編號
			pstmt = con.prepareStatement(DELETE_EMG_H_MSG);
			pstmt.setString(1, emg_H_Id);
			updateCount_EmgMsg = pstmt.executeUpdate();
			// 再刪除求救編號
			pstmt = con.prepareStatement(DELETE_EMG_H);
			pstmt.setString(1, emg_H_Id);
			pstmt.executeUpdate();

			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除求救編號 " + emg_H_Id + " 時,求救的留言 " + updateCount_EmgMsg + " 同時被刪除");

			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
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
		
	}

	@Override
	public Emg_HVO findByPrimaryKey(String emg_H_Id) {
		Emg_HVO emg_HVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, emg_H_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				emg_HVO = new Emg_HVO();

				emg_HVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_HVO.setMem_Id(rs.getString("mem_Id"));
				emg_HVO.setEmg_H_start_date(rs.getTimestamp("emg_H_start_date"));
				emg_HVO.setEmg_H_end_date(rs.getTimestamp("emg_H_end_date"));
				emg_HVO.setEmg_H_title(rs.getString("emg_H_title"));
				emg_HVO.setEmg_H_content(rs.getString("emg_H_content"));
				emg_HVO.setEmg_H_pic(rs.getBytes("emg_H_pic"));
				emg_HVO.setEmg_H_city(rs.getString("emg_H_city"));
				emg_HVO.setEmg_H_town(rs.getString("emg_H_town"));
				emg_HVO.setEmg_H_road(rs.getString("emg_H_road"));
				emg_HVO.setEmg_H_Lon(rs.getDouble("emg_H_Lon"));
				emg_HVO.setEmg_H_Lat(rs.getDouble("emg_H_Lat"));
				emg_HVO.setEmg_H_status(rs.getString("emg_H_status"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return emg_HVO;
	}

	@Override
	public List<Emg_HVO> getAll() {
		// TODO Auto-generated method stub
		List<Emg_HVO> list = new ArrayList<Emg_HVO>();
		Emg_HVO emg_HVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				emg_HVO = new Emg_HVO();

				emg_HVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_HVO.setMem_Id(rs.getString("mem_Id"));
				emg_HVO.setEmg_H_start_date(rs.getTimestamp("emg_H_start_date"));
				emg_HVO.setEmg_H_end_date(rs.getTimestamp("emg_H_end_date"));
				emg_HVO.setEmg_H_title(rs.getString("emg_H_title"));
				emg_HVO.setEmg_H_content(rs.getString("emg_H_content"));
				emg_HVO.setEmg_H_pic(rs.getBytes("emg_H_pic"));
				emg_HVO.setEmg_H_city(rs.getString("emg_H_city"));
				emg_HVO.setEmg_H_town(rs.getString("emg_H_town"));
				emg_HVO.setEmg_H_road(rs.getString("emg_H_road"));
				emg_HVO.setEmg_H_Lon(rs.getDouble("emg_H_lon"));
				emg_HVO.setEmg_H_Lat(rs.getDouble("emg_H_lat"));
				emg_HVO.setEmg_H_status(rs.getString("emg_H_status"));
				list.add(emg_HVO);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Set<Emg_H_MsgVO> getEmg_H_MsgByEmg_H_Id(String emg_H_Id) {
		// TODO Auto-generated method stub
		Set<Emg_H_MsgVO> set = new LinkedHashSet<Emg_H_MsgVO>();
		Emg_H_MsgVO emg_H_MsgVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			pstmt = con.prepareStatement(GET_EMG_H_MSG_ByEMG_H_ID_STMT);

			pstmt.setString(1, emg_H_Id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				emg_H_MsgVO = new Emg_H_MsgVO();

				emg_H_MsgVO.setEmg_H_Msg_Id(rs.getString("emg_H_Msg_Id"));
				emg_H_MsgVO.setMem_Id(rs.getString("mem_Id"));
				emg_H_MsgVO.setEmg_H_Id(rs.getString("emg_H_Id"));
				emg_H_MsgVO.setEmg_H_Msg_start(rs.getTimestamp("emg_H_Msg_start"));
				emg_H_MsgVO.setEmg_H_Msg_content(rs.getString("emg_H_Msg_content"));
				set.add(emg_H_MsgVO); // Store the row in the vector

			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emg_HDAO_JDBC dao= new Emg_HDAO_JDBC();
		
		//insert
		
		Emg_HVO emg_HVO=new Emg_HVO();
		emg_HVO.setMem_Id("103");
		emg_HVO.setEmg_H_start_date(java.sql.Timestamp.valueOf("2017-02-10 00:00:00"));
		emg_HVO.setEmg_H_end_date(java.sql.Timestamp.valueOf("2017-02-15 00:00:00"));
		emg_HVO.setEmg_H_title("發現狗!!");
		emg_HVO.setEmg_H_content("這裡有被遺棄的狗!!");
		emg_HVO.setEmg_H_city("桃園市");
		emg_HVO.setEmg_H_town("中壢區");
		emg_HVO.setEmg_H_road("中山路");
		emg_HVO.setEmg_H_Lon( new Double (24.954409));
		emg_HVO.setEmg_H_Lat( new Double (121.227028));	
			
		dao.insert(emg_HVO);		
		System.out.println("check table is or not OK?");	
		
		//get one
		
//		Emg_HVO emg_HVO2=dao.findByPrimaryKey("50002");
//		System.out.println(emg_HVO2.getEmg_H_Id());
//		System.out.println(emg_HVO2.getMem_Id());
//		System.out.println(emg_HVO2.getEmg_H_start_date());
//		System.out.println(emg_HVO2.getEmg_H_end_date());
//		System.out.println(emg_HVO2.getEmg_H_title());
//		System.out.println(emg_HVO2.getEmg_H_content());
//		System.out.println(emg_HVO2.getEmg_H_city());
//		System.out.println(emg_HVO2.getEmg_H_town());
//		System.out.println(emg_HVO2.getEmg_H_road());
//		System.out.println(emg_HVO2.getEmg_H_Lon());
//		System.out.println(emg_HVO2.getEmg_H_Lat());
//		System.out.println(emg_HVO2.getEmg_H_status());
////		
////		System.out.println("-------------------------------------------");
//		
//		//get all
////		
//		List<Emg_HVO> list =dao.getAll();
//		for(Emg_HVO aEmg_H : list){
//			System.out.print(aEmg_H.getEmg_H_Id()+" - ");
//			System.out.print(aEmg_H.getMem_Id()+" - ");
//			System.out.print(aEmg_H.getEmg_H_start_date()+" - ");
//			System.out.print(aEmg_H.getEmg_H_end_date()+" - ");
//			System.out.print(aEmg_H.getEmg_H_title()+" - ");
//			System.out.print(aEmg_H.getEmg_H_content()+" - ");
//			System.out.print(aEmg_H.getEmg_H_city()+" - ");
//			System.out.print(aEmg_H.getEmg_H_town()+" - ");
//			System.out.print(aEmg_H.getEmg_H_road()+" - ");
//			System.out.print(aEmg_H.getEmg_H_Lon()+" - ");
//			System.out.println(aEmg_H.getEmg_H_Lat());
//			System.out.println(aEmg_H.getEmg_H_status());
//			System.out.println("-------------------------------------------");
		
			
		}
		
//		get one by emg_H_Id from emg_H_Msg
		
//		Set<Emg_H_MsgVO> set =dao.getEmg_H_MsgByEmg_H_Id("50003");
//		for(Emg_H_MsgVO aEmg_H_Msg : set){
//			System.out.print(aEmg_H_Msg.getEmg_H_Msg_Id() + ",");
//			System.out.print(aEmg_H_Msg.getMem_Id() + ",");
//			System.out.print(aEmg_H_Msg.getEmg_H_Id() + ",");
//			System.out.print(aEmg_H_Msg.getEmg_H_Msg_start() + ",");
//			System.out.println(aEmg_H_Msg.getEmg_H_Msg_content());
//			System.out.println("--------------------------------------");
//		}
		
//		delete
		
//		dao.delete("50001");
//		System.out.println("check table is or not OK?");	
//
//	}

}
