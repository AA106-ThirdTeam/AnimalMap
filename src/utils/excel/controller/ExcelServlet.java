package utils.excel.controller;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utils.excel.data.Common_variable;
import heibernate_com.park.model.*;
import heibernate_com.anihome_photos.model.*;
import heibernate_com.anihome_msg.model.*;
import heibernate_com.anihome.model.*;
import heibernate_com.mem.model.*;
import heibernate_com.emp.model.*;
import heibernate_com.track.model.*;
import heibernate_com.adpphotos.model.*;
import heibernate_com.adpmsg.model.*;
import heibernate_com.adp.model.*;
@WebServlet(urlPatterns = { "/back-end/ExcelServlet/ExcelServlet.do" })
public class ExcelServlet extends HttpServlet  {
	PrintWriter out = null;
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		out = res.getWriter();
		create_insert_sql_adp(req, res);
		create_insert_sql_adpMsg(req, res);
		create_insert_sql_adpPhotos(req, res);
		create_insert_sql_track(req, res);
		create_insert_sql_emp(req, res);
		create_insert_sql_mem(req, res);
		create_insert_sql_aniHome(req, res);
		create_insert_sql_aniHome_Msg(req, res);
		create_insert_sql_aniHome_Photos(req, res);
		create_insert_sql_park(req, res);
	}
	private void create_insert_sql_park(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "park";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					Park_interface dao = new ParkDAO();
					for (int i = 1; i < rows; i++) {
						ParkVO parkVO = new ParkVO();
						//以下3行程式碼因為要配合Hibernate的parkVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						EmpVO empVO = new EmpVO();
						empVO.setEmp_No(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						parkVO.setEmpVO(empVO);	
						parkVO.setPark_title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						parkVO.setPark_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(4, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(4, i).getContents().trim()));
								parkVO.setPark_pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								parkVO.setPark_pic(null);
							}								
						}else{
							parkVO.setPark_pic(null);
						}
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								parkVO.setAdp_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								parkVO.setAdp_start_date(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(6, i).getContents().trim());
								parkVO.setAdp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								parkVO.setAdp_upDate(tem_date);
							}	
						}	
						parkVO.setAdp_city(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						parkVO.setPark_town(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						parkVO.setPark_road(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						parkVO.setPark_lon(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						parkVO.setPark_lat(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(parkVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_aniHome_Photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "aniHome_Photos";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					AniHome_Photos_interface dao = new AniHome_PhotosDAO();
					for (int i = 1; i < rows; i++) {
						AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
						//以下3行程式碼因為要配合Hibernate的anihome_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						AniHomeVO aniHomeVO = new AniHomeVO();
						aniHomeVO.setAniHome_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						anihome_photosVO.setAniHomeVO(aniHomeVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(2, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(2, i).getContents().trim()));
								anihome_photosVO.setAniHome_Photos_pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								anihome_photosVO.setAniHome_Photos_pic(null);
							}								
						}else{
							anihome_photosVO.setAniHome_Photos_pic(null);
						}
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(anihome_photosVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_aniHome_Msg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "aniHome_Msg";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					AniHome_Msg_interface dao = new AniHome_MsgDAO();
					for (int i = 1; i < rows; i++) {
						AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
						//以下3行程式碼因為要配合Hibernate的anihome_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						AniHomeVO aniHomeVO = new AniHomeVO();
						aniHomeVO.setAniHome_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						anihome_msgVO.setAniHomeVO(aniHomeVO);	
						//以下3行程式碼因為要配合Hibernate的anihome_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						anihome_msgVO.setMemVO(memVO);	
						anihome_msgVO.setAniHome_Msg(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								anihome_msgVO.setAdp_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								anihome_msgVO.setAdp_start_date(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(anihome_msgVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_aniHome(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "aniHome";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					AniHome_interface dao = new AniHomeDAO();
					for (int i = 1; i < rows; i++) {
						AniHomeVO anihomeVO = new AniHomeVO();
						//以下3行程式碼因為要配合Hibernate的anihomeVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						anihomeVO.setMemVO(memVO);	
						anihomeVO.setAniHome_title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						anihomeVO.setAniHome_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								anihomeVO.setAniHome_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								anihomeVO.setAniHome_start_date(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								anihomeVO.setAniHome_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								anihomeVO.setAniHome_upDate(tem_date);
							}	
						}	
						anihomeVO.setAniHome_city(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						anihomeVO.setAniHome_town(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						anihomeVO.setAniHome_road(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						anihomeVO.setAniHome_lon(Double.valueOf(sheet.getCell(9, i).getContents().trim()));							
						anihomeVO.setAniHome_lat(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(anihomeVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_mem(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "mem";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					Mem_interface dao = new MemDAO();
					for (int i = 1; i < rows; i++) {
						MemVO memVO = new MemVO();
						memVO.setMem_account(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						memVO.setMem_email(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						memVO.setMem_Psw(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						memVO.setMem_nick_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						memVO.setMem_name(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						memVO.setMem_gender(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						memVO.setMem_Tw_Id(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(8, i).getContents().trim());
								memVO.setMem_birth_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								memVO.setMem_birth_date(tem_date);
							}	
						}	
						memVO.setMem_phone(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						memVO.setMem_Intro(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(11, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(11, i).getContents().trim()));
								memVO.setMem_profile(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								memVO.setMem_profile(null);
							}								
						}else{
							memVO.setMem_profile(null);
						}
						memVO.setMem_black_list(String.valueOf(sheet.getCell(12, i).getContents().trim()));							
						memVO.setMem_permission(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						memVO.setMem_setting(String.valueOf(sheet.getCell(14, i).getContents().trim()));							
						memVO.setMem_balance(Integer.valueOf(sheet.getCell(15, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(memVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emp(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emp";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					Emp_interface dao = new EmpDAO();
					for (int i = 1; i < rows; i++) {
						EmpVO empVO = new EmpVO();
						empVO.setEmp_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						empVO.setEmp_Pw(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						empVO.setEmp_email(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						empVO.setEmp_identity_card(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								empVO.setEmp_birthday(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								empVO.setEmp_birthday(tem_date);
							}	
						}	
						empVO.setEmp_phone(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						empVO.setEmp_address(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						empVO.setEmp_status(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(9, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(9, i).getContents().trim()));
								empVO.setEmp_picture(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								empVO.setEmp_picture(null);
							}								
						}else{
							empVO.setEmp_picture(null);
						}
						empVO.setEmp_Pic_format(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(11, i).getContents().trim());
								empVO.setEmp_hiredate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								empVO.setEmp_hiredate(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(12, i).getContents().trim());
								empVO.setEmp_firedate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								empVO.setEmp_firedate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(empVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_track(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "track";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					Track_interface dao = new TrackDAO();
					for (int i = 1; i < rows; i++) {
						TrackVO trackVO = new TrackVO();
						//以下3行程式碼因為要配合Hibernate的trackVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						trackVO.setMemVO(memVO);	
						trackVO.setTrack_record_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						trackVO.setTrack_record_class_Id(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(trackVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adpPhotos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adpPhotos";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					AdpPhotos_interface dao = new AdpPhotosDAO();
					for (int i = 1; i < rows; i++) {
						AdpPhotosVO adpphotosVO = new AdpPhotosVO();
						//以下3行程式碼因為要配合Hibernate的adpphotosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						AdpVO adpVO = new AdpVO();
						adpVO.setAdp_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adpphotosVO.setAdpVO(adpVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(2, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(2, i).getContents().trim()));
								adpphotosVO.setAdpPhotosPic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								adpphotosVO.setAdpPhotosPic(null);
							}								
						}else{
							adpphotosVO.setAdpPhotosPic(null);
						}
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adpphotosVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adpMsg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adpMsg";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					AdpMsg_interface dao = new AdpMsgDAO();
					for (int i = 1; i < rows; i++) {
						AdpMsgVO adpmsgVO = new AdpMsgVO();
						//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						AdpVO adpVO = new AdpVO();
						adpVO.setAdp_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adpmsgVO.setAdpVO(adpVO);	
						//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						adpmsgVO.setMemVO(memVO);	
						adpmsgVO.setMsg(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								adpmsgVO.setAdpMsgDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adpmsgVO.setAdpMsgDate(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								adpmsgVO.setAdpMsgadp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adpmsgVO.setAdpMsgadp_upDate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adpmsgVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adp(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adp";	
			System.out.println("tableName : "+ tableName);
			// ==== ====
			String filepath = Common_variable.excel_fakeDB_input_path + tableName + ".xls";
			// ==== Workbook ====
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(new File(filepath));
				// ==== 由Workbook的getSheet(0)方法選擇第一個工作表（從0開始） ====
				Sheet sheet = workbook.getSheet(0);
				// ==== 取得Sheet表中所包含的總row數 ====
				int rows = sheet.getRows();
				// ==== 取得Sheet表中所包含的總column數 ====
				int columns = sheet.getColumns();	
				if (rows > 1) {
					List<List> list_rows = linkhashMap_excel_DB.get(tableName);
					Adp_interface dao = new AdpDAO();
					for (int i = 1; i < rows; i++) {
						AdpVO adpVO = new AdpVO();
						//以下3行程式碼因為要配合Hibernate的adpVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adpVO.setMemVO(memVO);	
						adpVO.setAdp_title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						adpVO.setAdp_adp_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								adpVO.setAdp_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adpVO.setAdp_start_date(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								adpVO.setAdp_end_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adpVO.setAdp_end_date(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(6, i).getContents().trim());
								adpVO.setAdp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adpVO.setAdp_upDate(tem_date);
							}	
						}	
						adpVO.setAdp_city(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						adpVO.setAdp_town(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						adpVO.setAdp_road(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						adpVO.setAdp_lon(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						adpVO.setAdp_lat(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adpVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	public static String getTypeofCol(String 資料型態,String 欄位長度){
		String str = "";
		if (!(資料型態.indexOf("VARCHAR2") == -1)) {
			str += "String ";
		}
		if (!(資料型態.indexOf("DATE") == -1)) {
			str += "java.sql.Date ";
		}
		if (!(資料型態.indexOf("NUMBER") == -1)) {
			if (!(欄位長度.indexOf(",") == -1)) {
				str += "Double ";
			} else {
				str += "Integer ";
			}
		}
		if (!(資料型態.indexOf("BLOB") == -1)) {
			str += "byte[] ";
		}
		return str;		
	}
    public byte[] recoverImageFromUrl(String urlText) throws Exception {
        URL url = new URL(urlText);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }
        return output.toByteArray();
    }	
}
