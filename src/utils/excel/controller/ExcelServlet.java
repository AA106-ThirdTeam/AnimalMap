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
import heibernate_com.emp_purview.model.*;
import heibernate_com.purview.model.*;
import heibernate_com.animal_index.model.*;
import heibernate_com.emg_h_msg.model.*;
import heibernate_com.emg_h.model.*;
import heibernate_com.stray_ani_photos.model.*;
import heibernate_com.stray_ani_message.model.*;
import heibernate_com.stray_ani_loc.model.*;
import heibernate_com.stray_ani.model.*;
import heibernate_com.pet_photos.model.*;
import heibernate_com.pet_message.model.*;
import heibernate_com.pet.model.*;
import heibernate_com.adopt_ani_photos.model.*;
import heibernate_com.adopt_ani_message.model.*;
import heibernate_com.adopt_ani_sponsor.model.*;
import heibernate_com.adoanispo.model.*;
import heibernate_com.adopt_ani.model.*;
import heibernate_com.post_response.model.*;
import heibernate_com.post.model.*;
import heibernate_com.offimsg.model.*;
import heibernate_com.track.model.*;
import heibernate_com.adpphotos.model.*;
import heibernate_com.adpmsg.model.*;
import heibernate_com.adp.model.*;
import heibernate_com.park.model.*;
import heibernate_com.anihome_photos.model.*;
import heibernate_com.anihome_msg.model.*;
import heibernate_com.anihome.model.*;
import heibernate_com.mem.model.*;
import heibernate_com.emp.model.*;
@WebServlet(urlPatterns = { "/back-end/ExcelServlet/ExcelServlet.do" })
public class ExcelServlet extends HttpServlet  {
	PrintWriter out = null;
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		out = res.getWriter();
		create_insert_sql_emp(req, res);
		create_insert_sql_mem(req, res);
		create_insert_sql_aniHome(req, res);
		create_insert_sql_aniHome_Msg(req, res);
		create_insert_sql_aniHome_Photos(req, res);
		create_insert_sql_park(req, res);
		create_insert_sql_adp(req, res);
		create_insert_sql_adpMsg(req, res);
		create_insert_sql_adpPhotos(req, res);
		create_insert_sql_track(req, res);
		create_insert_sql_offiMsg(req, res);
		create_insert_sql_post(req, res);
		create_insert_sql_post_Response(req, res);
		create_insert_sql_adopt_Ani(req, res);
		create_insert_sql_adoAniSpo(req, res);
		create_insert_sql_adopt_Ani_sponsor(req, res);
		create_insert_sql_adopt_Ani_message(req, res);
		create_insert_sql_adopt_Ani_photos(req, res);
		create_insert_sql_pet(req, res);
		create_insert_sql_pet_Message(req, res);
		create_insert_sql_pet_Photos(req, res);
		create_insert_sql_stray_Ani(req, res);
		create_insert_sql_stray_Ani_Loc(req, res);
		create_insert_sql_stray_Ani_message(req, res);
		create_insert_sql_stray_Ani_photos(req, res);
		create_insert_sql_emg_H(req, res);
		create_insert_sql_emg_H_Msg(req, res);
		create_insert_sql_animal_index(req, res);
		create_insert_sql_purview(req, res);
		create_insert_sql_emp_purview(req, res);
	}
	private void create_insert_sql_emp_purview(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emp_purview";	
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
					Emp_purview_interface dao = new Emp_purviewDAO();
					for (int i = 1; i < rows; i++) {
						Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(emp_purviewVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_purview(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "purview";	
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
					Purview_interface dao = new PurviewDAO();
					for (int i = 1; i < rows; i++) {
						PurviewVO purviewVO = new PurviewVO();
						purviewVO.setPruview_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(purviewVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_animal_index(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "animal_index";	
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
					Animal_index_interface dao = new Animal_indexDAO();
					for (int i = 1; i < rows; i++) {
						Animal_indexVO animal_indexVO = new Animal_indexVO();
						animal_indexVO.setAnimal_detail(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						animal_indexVO.setAnimal_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						animal_indexVO.setAnimal_class_No(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(animal_indexVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emg_H_Msg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emg_H_Msg";	
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
					Emg_H_Msg_interface dao = new Emg_H_MsgDAO();
					for (int i = 1; i < rows; i++) {
						Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
						//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						emg_h_msgVO.setMemVO(memVO);	
						//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Emg_HVO emg_HVO = new Emg_HVO();
						emg_HVO.setEmg_H_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						emg_h_msgVO.setEmg_HVO(emg_HVO);	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(3, i).getContents().trim());
								emg_h_msgVO.setEmg_H_Msg_start(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								emg_h_msgVO.setEmg_H_Msg_start(tem_date);
							}	
						}	
						emg_h_msgVO.setEmg_H_Msg_content(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(emg_h_msgVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emg_H(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emg_H";	
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
					Emg_H_interface dao = new Emg_HDAO();
					for (int i = 1; i < rows; i++) {
						Emg_HVO emg_hVO = new Emg_HVO();
						//以下3行程式碼因為要配合Hibernate的emg_hVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						emg_hVO.setMemVO(memVO);	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(2, i).getContents().trim());
								emg_hVO.setEmg_H_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								emg_hVO.setEmg_H_start_date(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(3, i).getContents().trim());
								emg_hVO.setEmg_H_end_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								emg_hVO.setEmg_H_end_date(tem_date);
							}	
						}	
						emg_hVO.setEmg_H_title(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						emg_hVO.setEmg_H_content(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(6, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(6, i).getContents().trim()));
								emg_hVO.setEmg_H_Pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								emg_hVO.setEmg_H_Pic(null);
							}								
						}else{
							emg_hVO.setEmg_H_Pic(null);
						}
						emg_hVO.setEmg_H_Pic_format(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						emg_hVO.setEmg_H_city(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						emg_hVO.setEmg_H_town(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						emg_hVO.setEmg_H_road(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						emg_hVO.setEmg_H_Lon(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						emg_hVO.setEmg_H_Lat(Double.valueOf(sheet.getCell(12, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(emg_hVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani_photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani_photos";	
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
					Stray_Ani_photos_interface dao = new Stray_Ani_photosDAO();
					for (int i = 1; i < rows; i++) {
						Stray_Ani_photosVO stray_ani_photosVO = new Stray_Ani_photosVO();
						//以下3行程式碼因為要配合Hibernate的stray_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Stray_AniVO stray_AniVO = new Stray_AniVO();
						stray_AniVO.setStray_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						stray_ani_photosVO.setStray_AniVO(stray_AniVO);	
						//以下3行程式碼因為要配合Hibernate的stray_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						stray_ani_photosVO.setMemVO(memVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(3, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(3, i).getContents().trim()));
								stray_ani_photosVO.setStray_Ani_Pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								stray_ani_photosVO.setStray_Ani_Pic(null);
							}								
						}else{
							stray_ani_photosVO.setStray_Ani_Pic(null);
						}
						stray_ani_photosVO.setStray_Pic_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						stray_ani_photosVO.setStray_Pic_extent(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(6, i).getContents().trim());
								stray_ani_photosVO.setStray_Pic_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								stray_ani_photosVO.setStray_Pic_time(tem_date);
							}	
						}	
						stray_ani_photosVO.setStray_Pic_type(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(stray_ani_photosVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani_message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani_message";	
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
					Stray_Ani_message_interface dao = new Stray_Ani_messageDAO();
					for (int i = 1; i < rows; i++) {
						Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
						//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Stray_AniVO stray_AniVO = new Stray_AniVO();
						stray_AniVO.setStray_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						stray_ani_messageVO.setStray_AniVO(stray_AniVO);	
						//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						stray_ani_messageVO.setMemVO(memVO);	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(3, i).getContents().trim());
								stray_ani_messageVO.setStr_Ani_Mes_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								stray_ani_messageVO.setStr_Ani_Mes_time(tem_date);
							}	
						}	
						stray_ani_messageVO.setStr_Ani_Mes(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(stray_ani_messageVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani_Loc(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani_Loc";	
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
					Stray_Ani_Loc_interface dao = new Stray_Ani_LocDAO();
					for (int i = 1; i < rows; i++) {
						Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
						//以下3行程式碼因為要配合Hibernate的stray_ani_locVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Stray_AniVO stray_AniVO = new Stray_AniVO();
						stray_AniVO.setStray_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						stray_ani_locVO.setStray_AniVO(stray_AniVO);	
						//以下3行程式碼因為要配合Hibernate的stray_ani_locVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						stray_ani_locVO.setMemVO(memVO);	
						stray_ani_locVO.setStr_Ani_LocLat(Double.valueOf(sheet.getCell(3, i).getContents().trim()));							
						stray_ani_locVO.setStr_Ani_LocLon(Double.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(stray_ani_locVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani";	
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
					Stray_Ani_interface dao = new Stray_AniDAO();
					for (int i = 1; i < rows; i++) {
						Stray_AniVO stray_aniVO = new Stray_AniVO();
						//以下3行程式碼因為要配合Hibernate的stray_aniVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						stray_aniVO.setMemVO(memVO);	
						stray_aniVO.setStray_Ani_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_type(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_gender(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_heal(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_Vac(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_color(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_body(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_age(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_Neu(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_chip(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(12, i).getContents().trim());
								stray_aniVO.setStray_Ani_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								stray_aniVO.setStray_Ani_date(tem_date);
							}	
						}	
						stray_aniVO.setStray_Ani_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(14, i).getContents().trim());
								stray_aniVO.setStray_Ani_CreDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								stray_aniVO.setStray_Ani_CreDate(tem_date);
							}	
						}	
						stray_aniVO.setStray_Ani_FinLat(Double.valueOf(sheet.getCell(15, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_FinLon(Double.valueOf(sheet.getCell(16, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_city(String.valueOf(sheet.getCell(17, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_town(String.valueOf(sheet.getCell(18, i).getContents().trim()));							
						stray_aniVO.setStray_Ani_road(String.valueOf(sheet.getCell(19, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(stray_aniVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_pet_Photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "pet_Photos";	
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
					Pet_Photos_interface dao = new Pet_PhotosDAO();
					for (int i = 1; i < rows; i++) {
						Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
						//以下3行程式碼因為要配合Hibernate的pet_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						PetVO petVO = new PetVO();
						petVO.setPet_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						pet_photosVO.setPetVO(petVO);	
						//以下3行程式碼因為要配合Hibernate的pet_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						pet_photosVO.setMemVO(memVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(3, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(3, i).getContents().trim()));
								pet_photosVO.setPet_Pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								pet_photosVO.setPet_Pic(null);
							}								
						}else{
							pet_photosVO.setPet_Pic(null);
						}
						pet_photosVO.setPet_Pic_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						pet_photosVO.setPet_Pic_extent(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(6, i).getContents().trim());
								pet_photosVO.setPet_Pic_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								pet_photosVO.setPet_Pic_time(tem_date);
							}	
						}	
						pet_photosVO.setPet_Pic_type(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(pet_photosVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_pet_Message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "pet_Message";	
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
					Pet_Message_interface dao = new Pet_MessageDAO();
					for (int i = 1; i < rows; i++) {
						Pet_MessageVO pet_messageVO = new Pet_MessageVO();
						//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						PetVO petVO = new PetVO();
						petVO.setPet_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						pet_messageVO.setPetVO(petVO);	
						//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						pet_messageVO.setMemVO(memVO);	
						pet_messageVO.setPet_Mes(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								pet_messageVO.setPet_Mes_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								pet_messageVO.setPet_Mes_time(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(pet_messageVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_pet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "pet";	
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
					Pet_interface dao = new PetDAO();
					for (int i = 1; i < rows; i++) {
						PetVO petVO = new PetVO();
						//以下3行程式碼因為要配合Hibernate的petVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						petVO.setMemVO(memVO);	
						petVO.setPet_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						petVO.setPet_type(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						petVO.setPet_gender(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						petVO.setPet_heal(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						petVO.setPet_Vac(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						petVO.setPet_color(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						petVO.setPet_body(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						petVO.setPet_age(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						petVO.setPet_Neu(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						petVO.setPet_chip(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(12, i).getContents().trim());
								petVO.setPet_birth(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								petVO.setPet_birth(tem_date);
							}	
						}	
						petVO.setPet_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(14, i).getContents().trim());
								petVO.setPet_CreDATE(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								petVO.setPet_CreDATE(tem_date);
							}	
						}	
						petVO.setPet_city(String.valueOf(sheet.getCell(15, i).getContents().trim()));							
						petVO.setPet_town(String.valueOf(sheet.getCell(16, i).getContents().trim()));							
						petVO.setPet_road(String.valueOf(sheet.getCell(17, i).getContents().trim()));							
						petVO.setPet_FinLat(Double.valueOf(sheet.getCell(18, i).getContents().trim()));							
						petVO.setPet_FinLon(Double.valueOf(sheet.getCell(19, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(petVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani_photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani_photos";	
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
					Adopt_Ani_photos_interface dao = new Adopt_Ani_photosDAO();
					for (int i = 1; i < rows; i++) {
						Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
						//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
						adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adopt_ani_photosVO.setAdopt_AniVO(adopt_AniVO);	
						//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						adopt_ani_photosVO.setMemVO(memVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(3, i).getContents().trim()))      ){
							try {
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(3, i).getContents().trim()));
								adopt_ani_photosVO.setAdo_Ani_Pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								adopt_ani_photosVO.setAdo_Ani_Pic(null);
							}								
						}else{
							adopt_ani_photosVO.setAdo_Ani_Pic(null);
						}
						adopt_ani_photosVO.setAdo_Pic_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						adopt_ani_photosVO.setAdo_Pic_extent(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(6, i).getContents().trim());
								adopt_ani_photosVO.setAdo_Pic_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adopt_ani_photosVO.setAdo_Pic_time(tem_date);
							}	
						}	
						adopt_ani_photosVO.setAdo_Pic_type(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adopt_ani_photosVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani_message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani_message";	
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
					Adopt_Ani_message_interface dao = new Adopt_Ani_messageDAO();
					for (int i = 1; i < rows; i++) {
						Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();
						//以下3行程式碼因為要配合Hibernate的adopt_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
						adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adopt_ani_messageVO.setAdopt_AniVO(adopt_AniVO);	
						//以下3行程式碼因為要配合Hibernate的adopt_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						adopt_ani_messageVO.setMemVO(memVO);	
						adopt_ani_messageVO.setAdo_Ani_Mes(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								adopt_ani_messageVO.setAdo_Ani_Mes_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adopt_ani_messageVO.setAdo_Ani_Mes_time(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adopt_ani_messageVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani_sponsor(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani_sponsor";	
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
					Adopt_Ani_sponsor_interface dao = new Adopt_Ani_sponsorDAO();
					for (int i = 1; i < rows; i++) {
						Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
						//以下3行程式碼因為要配合Hibernate的adopt_ani_sponsorVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
						adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adopt_ani_sponsorVO.setAdopt_AniVO(adopt_AniVO);	
						//以下3行程式碼因為要配合Hibernate的adopt_ani_sponsorVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						adopt_ani_sponsorVO.setMemVO(memVO);	
						adopt_ani_sponsorVO.setAdo_Ani_Spo_money(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						adopt_ani_sponsorVO.setAdo_Ani_Spo_thing(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								adopt_ani_sponsorVO.setAdo_Ani_Spo_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adopt_ani_sponsorVO.setAdo_Ani_Spo_time(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adopt_ani_sponsorVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adoAniSpo(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adoAniSpo";	
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
					AdoAniSpo_interface dao = new AdoAniSpoDAO();
					for (int i = 1; i < rows; i++) {
						AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
						//以下3行程式碼因為要配合Hibernate的adoanispoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
						adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adoanispoVO.setAdopt_AniVO(adopt_AniVO);	
						//以下3行程式碼因為要配合Hibernate的adoanispoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						adoanispoVO.setMemVO(memVO);	
						adoanispoVO.setAdoAniSpoMoney(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						adoanispoVO.setAdoAniSpoMat(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adoanispoVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani";	
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
					Adopt_Ani_interface dao = new Adopt_AniDAO();
					for (int i = 1; i < rows; i++) {
						Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
						//以下3行程式碼因為要配合Hibernate的adopt_aniVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						adopt_aniVO.setMemVO(memVO);	
						adopt_aniVO.setAdopt_Ani_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_type(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_gender(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_heal(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_Vac(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_color(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_body(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_age(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_Neu(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_chip(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(12, i).getContents().trim());
								adopt_aniVO.setAdopt_Ani_date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adopt_aniVO.setAdopt_Ani_date(tem_date);
							}	
						}	
						adopt_aniVO.setAdopt_Ani_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(14, i).getContents().trim());
								adopt_aniVO.setAdopt_Ani_CreDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								adopt_aniVO.setAdopt_Ani_CreDate(tem_date);
							}	
						}	
						adopt_aniVO.setAdopt_Ani_FinLat(Double.valueOf(sheet.getCell(15, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_FinLon(Double.valueOf(sheet.getCell(16, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_city(String.valueOf(sheet.getCell(17, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_town(String.valueOf(sheet.getCell(18, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_road(String.valueOf(sheet.getCell(19, i).getContents().trim()));							
						adopt_aniVO.setAdopt_Ani_like(Integer.valueOf(sheet.getCell(20, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(adopt_aniVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_post_Response(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "post_Response";	
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
					Post_Response_interface dao = new Post_ResponseDAO();
					for (int i = 1; i < rows; i++) {
						Post_ResponseVO post_responseVO = new Post_ResponseVO();
						//以下3行程式碼因為要配合Hibernate的post_responseVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						post_responseVO.setMemVO(memVO);	
						//以下3行程式碼因為要配合Hibernate的post_responseVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						PostVO postVO = new PostVO();
						postVO.setPost_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						post_responseVO.setPostVO(postVO);	
						post_responseVO.setPost_Response_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								post_responseVO.setPost_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								post_responseVO.setPost_time(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(5, i).getContents().trim());
								post_responseVO.setPost_Response_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								post_responseVO.setPost_Response_upDate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(post_responseVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_post(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "post";	
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
					Post_interface dao = new PostDAO();
					for (int i = 1; i < rows; i++) {
						PostVO postVO = new PostVO();
						//以下3行程式碼因為要配合Hibernate的postVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						MemVO memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						postVO.setMemVO(memVO);	
						postVO.setPost_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						postVO.setPost_class_Id(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						postVO.setPost_title(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						postVO.setPost_content(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(6, i).getContents().trim());
								postVO.setPost_time(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								postVO.setPost_time(tem_date);
							}	
						}	
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(7, i).getContents().trim());
								postVO.setPost_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								postVO.setPost_upDate(tem_date);
							}	
						}	
						postVO.setPost_resNum(Integer.valueOf(sheet.getCell(8, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(postVO);
					}
				}
				System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_offiMsg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "offiMsg";	
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
					OffiMsg_interface dao = new OffiMsgDAO();
					for (int i = 1; i < rows; i++) {
						OffiMsgVO offimsgVO = new OffiMsgVO();
						//以下3行程式碼因為要配合Hibernate的offimsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						EmpVO empVO = new EmpVO();
						empVO.setEmp_No(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						offimsgVO.setEmpVO(empVO);	
						offimsgVO.setOffiMsg_Title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						offimsgVO.setOffiMsg_Content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Date tem_date = null;
							try {
								tem_date = java.sql.Date.valueOf(sheet.getCell(4, i).getContents().trim());
								offimsgVO.setOffiMsg_Date(tem_date);
							} catch (IllegalArgumentException e) {
								//tem_date=null;
								tem_date=new java.sql.Date(System.currentTimeMillis());
								offimsgVO.setOffiMsg_Date(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//System.out.println(data_str);
						dao.insert(offimsgVO);
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
						parkVO.setPark_pic(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
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
						anihome_photosVO.setAniHome_Photos_pic(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
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
						anihomeVO.setAniHome_pic(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
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
						memVO.setMem_profile(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
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
						empVO.setEmp_picture(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
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
	public static String getTypeofCol(String data_type,String data_length){
		String str = "";
		if (!(data_type.indexOf("VARCHAR2") == -1)) {
			str += "String ";
		}
		if (!(data_type.indexOf("DATE") == -1)) {
			str += "java.sql.Date ";
		}
		if (!(data_type.indexOf("NUMBER") == -1)) {
			if (!(data_length.indexOf(",") == -1)) {
				str += "Double ";
			} else {
				str += "Integer ";
			}
		}
		if (!(data_type.indexOf("BLOB") == -1)) {
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
