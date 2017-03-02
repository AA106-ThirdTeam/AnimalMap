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
import heibernate_com.charge.model.*;
import heibernate_com.product_kind.model.*;
import heibernate_com.orders_item.model.*;
import heibernate_com.second_prodphotos.model.*;
import heibernate_com.second_prodmsg.model.*;
import heibernate_com.product.model.*;
import heibernate_com.second_prod.model.*;
import heibernate_com.orders.model.*;
import heibernate_com.emp_purview.model.*;
import heibernate_com.purview.model.*;
import heibernate_com.animal_index.model.*;
import heibernate_com.emg_h_msg.model.*;
import heibernate_com.emg_help.model.*;
import heibernate_com.report.model.*;
import heibernate_com.rel_list.model.*;
import heibernate_com.priv_message.model.*;
import heibernate_com.shop_comment.model.*;
import heibernate_com.shop_photo.model.*;
import heibernate_com.petshop.model.*;
import heibernate_com.grp_comment.model.*;
import heibernate_com.joinlist.model.*;
import heibernate_com.petgroup.model.*;
import heibernate_com.hos_photo.model.*;
import heibernate_com.hos_comment.model.*;
import heibernate_com.vet_hospital.model.*;
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
		create_insert_sql_vet_hospital(req, res);
		create_insert_sql_hos_comment(req, res);
		create_insert_sql_hos_photo(req, res);
		create_insert_sql_petGroup(req, res);
		create_insert_sql_JoinList(req, res);
		create_insert_sql_grp_comment(req, res);
		create_insert_sql_petShop(req, res);
		create_insert_sql_shop_photo(req, res);
		create_insert_sql_shop_comment(req, res);
		create_insert_sql_priv_message(req, res);
		create_insert_sql_rel_List(req, res);
		create_insert_sql_report(req, res);
		create_insert_sql_emg_Help(req, res);
		create_insert_sql_emg_H_Msg(req, res);
		create_insert_sql_animal_index(req, res);
		create_insert_sql_purview(req, res);
		create_insert_sql_emp_purview(req, res);
		create_insert_sql_orders(req, res);
		create_insert_sql_second_Prod(req, res);
		create_insert_sql_product(req, res);
		create_insert_sql_second_ProdMsg(req, res);
		create_insert_sql_second_ProdPhotos(req, res);
		create_insert_sql_orders_item(req, res);
		create_insert_sql_product_kind(req, res);
		create_insert_sql_charge(req, res);
	}
	private void create_insert_sql_charge(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "charge";	
			////System.out.println("tableName : "+ tableName);
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
					Charge_interface dao = new ChargeDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						ChargeVO chargeVO = new ChargeVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的chargeVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			chargeVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						chargeVO.setCharge_NUMBER(Integer.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						chargeVO.setPay(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								chargeVO.setApplytime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								chargeVO.setApplytime(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(chargeVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_product_kind(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "product_kind";	
			////System.out.println("tableName : "+ tableName);
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
					Product_kind_interface dao = new Product_kindDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Product_kindVO product_kindVO = new Product_kindVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						product_kindVO.setProduct_kind_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(product_kindVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_orders_item(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "orders_item";	
			////System.out.println("tableName : "+ tableName);
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
					Orders_item_interface dao = new Orders_itemDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Orders_itemVO orders_itemVO = new Orders_itemVO();
			tem_str = sheet.getCell(0, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的orders_itemVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			OrdersVO ordersVO = new OrdersVO();
			ordersVO.setOrders_no(String.valueOf(sheet.getCell(0, i).getContents().trim()));
			orders_itemVO.setOrdersVO(ordersVO);	
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的orders_itemVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			ProductVO productVO = new ProductVO();
			productVO.setProduct_no(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			orders_itemVO.setProductVO(productVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						orders_itemVO.setCommodities_amount(Integer.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						orders_itemVO.setSelling_price(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(orders_itemVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_second_ProdPhotos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "second_ProdPhotos";	
			////System.out.println("tableName : "+ tableName);
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
					Second_ProdPhotos_interface dao = new Second_ProdPhotosDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的second_prodphotosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Second_ProdVO second_ProdVO = new Second_ProdVO();
			second_ProdVO.setSecond_Prod_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			second_prodphotosVO.setSecond_ProdVO(second_ProdVO);	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(second_prodphotosVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_second_ProdMsg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "second_ProdMsg";	
			////System.out.println("tableName : "+ tableName);
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
					Second_ProdMsg_interface dao = new Second_ProdMsgDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的second_prodmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Second_ProdVO second_ProdVO = new Second_ProdVO();
			second_ProdVO.setSecond_Prod_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			second_prodmsgVO.setSecond_ProdVO(second_ProdVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的second_prodmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			second_prodmsgVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodmsgVO.setSecond_ProdMsg_Msg(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								second_prodmsgVO.setSecond_ProdMsg_DATE(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								second_prodmsgVO.setSecond_ProdMsg_DATE(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								second_prodmsgVO.setSecond_ProdMsg_adp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								second_prodmsgVO.setSecond_ProdMsg_adp_upDate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(second_prodmsgVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_product(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "product";	
			////System.out.println("tableName : "+ tableName);
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
					Product_interface dao = new ProductDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						ProductVO productVO = new ProductVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_introduction(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_price(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_stock(Integer.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_picture_large(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_picture_small(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_status(Integer.valueOf(sheet.getCell(7, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(8, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(8, i).getContents().trim());
								productVO.setProduct_create_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								productVO.setProduct_create_date(tem_date);
							}	
						}	
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_info(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						productVO.setProduct_kind_no(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(productVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_second_Prod(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "second_Prod";	
			////System.out.println("tableName : "+ tableName);
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
					Second_Prod_interface dao = new Second_ProdDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Second_ProdVO second_prodVO = new Second_ProdVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的second_prodVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			second_prodVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_Title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_Content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								second_prodVO.setSecond_Prod_adp_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								second_prodVO.setSecond_Prod_adp_start_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								second_prodVO.setSecond_Prod_adp_end_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								second_prodVO.setSecond_Prod_adp_end_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								second_prodVO.setSecond_Prod_adp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								second_prodVO.setSecond_Prod_adp_upDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_adp_city(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_Town(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_Road(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_Lon(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						second_prodVO.setSecond_Prod_Lat(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(second_prodVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_orders(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "orders";	
			////System.out.println("tableName : "+ tableName);
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
					Orders_interface dao = new OrdersDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						OrdersVO ordersVO = new OrdersVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的ordersVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			ordersVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setOrders_receiver(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setPost_no(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setPost_adp_city(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setPost_town(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setPost_road(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setOrders_phone(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setCollect_mode_no(Integer.valueOf(sheet.getCell(8, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(9, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(9, i).getContents().trim());
								ordersVO.setOrders_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								ordersVO.setOrders_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(10, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(10, i).getContents().trim());
								ordersVO.setOrders_ship_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								ordersVO.setOrders_ship_date(tem_date);
							}	
						}	
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setOrders_total(Integer.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setOrders_status(Integer.valueOf(sheet.getCell(12, i).getContents().trim()));							
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						ordersVO.setOrders_credit(Integer.valueOf(sheet.getCell(13, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(ordersVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emp_purview(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emp_purview";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
			tem_str = sheet.getCell(0, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的emp_purviewVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			EmpVO empVO = new EmpVO();
			empVO.setEmp_No(String.valueOf(sheet.getCell(0, i).getContents().trim()));
			emp_purviewVO.setEmpVO(empVO);	
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的emp_purviewVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PurviewVO purviewVO = new PurviewVO();
			purviewVO.setPurview_No(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			emp_purviewVO.setPurviewVO(purviewVO);	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(emp_purviewVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_purview(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "purview";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						PurviewVO purviewVO = new PurviewVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						purviewVO.setPurview_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(purviewVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_animal_index(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "animal_index";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Animal_indexVO animal_indexVO = new Animal_indexVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						animal_indexVO.setAnimal_detail(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						animal_indexVO.setAnimal_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						animal_indexVO.setAnimal_class_No(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(animal_indexVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emg_H_Msg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emg_H_Msg";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			emg_h_msgVO.setMemVO(memVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的emg_h_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Emg_HelpVO emg_HelpVO = new Emg_HelpVO();
			emg_HelpVO.setEmg_H_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			emg_h_msgVO.setEmg_HelpVO(emg_HelpVO);	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(3, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(3, i).getContents().trim());
								emg_h_msgVO.setEmg_H_Msg_start(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								emg_h_msgVO.setEmg_H_Msg_start(tem_date);
							}	
						}	
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_h_msgVO.setEmg_H_Msg_content(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(emg_h_msgVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emg_Help(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emg_Help";	
			////System.out.println("tableName : "+ tableName);
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
					Emg_Help_interface dao = new Emg_HelpDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Emg_HelpVO emg_helpVO = new Emg_HelpVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的emg_helpVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			emg_helpVO.setMemVO(memVO);	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(2, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(2, i).getContents().trim());
								emg_helpVO.setEmg_H_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								emg_helpVO.setEmg_H_start_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(3, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(3, i).getContents().trim());
								emg_helpVO.setEmg_H_end_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								emg_helpVO.setEmg_H_end_date(tem_date);
							}	
						}	
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_title(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_content(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(6, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(6, i).getContents().trim()));
								emg_helpVO.setEmg_H_Pic(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								emg_helpVO.setEmg_H_Pic(null);
							}								
						}else{
							emg_helpVO.setEmg_H_Pic(null);
						}
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_Pic_format(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_city(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_town(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_road(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_Lon(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_Lat(Double.valueOf(sheet.getCell(12, i).getContents().trim()));							
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						emg_helpVO.setEmg_H_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(emg_helpVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_report(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "report";	
			////System.out.println("tableName : "+ tableName);
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
					Report_interface dao = new ReportDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						ReportVO reportVO = new ReportVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_class_No(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_class_No_value(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_content(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_status(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
			tem_str = sheet.getCell(7, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的reportVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(7, i).getContents().trim()));
			reportVO.setMemVO(memVO);	
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						//以下3行程式碼因為要配合Hibernate的reportVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(8, i).getContents().trim()));
						reportVO.setMemVO(memVO);	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(9, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(9, i).getContents().trim());
								reportVO.setReport_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								reportVO.setReport_time(tem_date);
							}	
						}	
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						reportVO.setReport_class_status(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(reportVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_rel_List(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "rel_List";	
			////System.out.println("tableName : "+ tableName);
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
					Rel_List_interface dao = new Rel_ListDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Rel_ListVO rel_listVO = new Rel_ListVO();
			tem_str = sheet.getCell(0, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的rel_listVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(0, i).getContents().trim()));
			rel_listVO.setMemVO(memVO);	
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						//以下3行程式碼因為要配合Hibernate的rel_listVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
						rel_listVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						rel_listVO.setIsBlackList(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						rel_listVO.setIsInvited(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(rel_listVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_priv_message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "priv_message";	
			////System.out.println("tableName : "+ tableName);
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
					Priv_message_interface dao = new Priv_messageDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Priv_messageVO priv_messageVO = new Priv_messageVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的priv_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			priv_messageVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						//以下3行程式碼因為要配合Hibernate的priv_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
						memVO = new MemVO();
						memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
						priv_messageVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						priv_messageVO.setPrivMsg_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								priv_messageVO.setPrivMsg_SendTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								priv_messageVO.setPrivMsg_SendTime(tem_date);
							}	
						}	
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						priv_messageVO.setPrivMsg_type(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(priv_messageVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_shop_comment(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "shop_comment";	
			////System.out.println("tableName : "+ tableName);
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
					Shop_comment_interface dao = new Shop_commentDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Shop_commentVO shop_commentVO = new Shop_commentVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的shop_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			shop_commentVO.setMemVO(memVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的shop_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PetShopVO petShopVO = new PetShopVO();
			petShopVO.setShop_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			shop_commentVO.setPetShopVO(petShopVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						shop_commentVO.setShopComment_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								shop_commentVO.setShopComment_SendTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								shop_commentVO.setShopComment_SendTime(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(shop_commentVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_shop_photo(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "shop_photo";	
			////System.out.println("tableName : "+ tableName);
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
					Shop_photo_interface dao = new Shop_photoDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Shop_photoVO shop_photoVO = new Shop_photoVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的shop_photoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PetShopVO petShopVO = new PetShopVO();
			petShopVO.setShop_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			shop_photoVO.setPetShopVO(petShopVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(2, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(2, i).getContents().trim()));
								shop_photoVO.setShopPhoto_photo(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								shop_photoVO.setShopPhoto_photo(null);
							}								
						}else{
							shop_photoVO.setShopPhoto_photo(null);
						}
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						shop_photoVO.setIsDisp_shopPhoto(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						shop_photoVO.setShopPhoto_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						shop_photoVO.setSHOPPHOTO_EXTENTION(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(shop_photoVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_petShop(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "petShop";	
			////System.out.println("tableName : "+ tableName);
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
					PetShop_interface dao = new PetShopDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						PetShopVO petshopVO = new PetShopVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的petshopVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			petshopVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_city(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_town(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_road(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_Eval(Integer.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_URL(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_StartTime(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_EndTime(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(10, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(10, i).getContents().trim());
								petshopVO.setShop_CreateTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								petshopVO.setShop_CreateTime(tem_date);
							}	
						}	
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_Tel(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_Desc(String.valueOf(sheet.getCell(12, i).getContents().trim()));							
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_Long(Double.valueOf(sheet.getCell(13, i).getContents().trim()));							
						tem_str = sheet.getCell(14, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_Lat(Double.valueOf(sheet.getCell(14, i).getContents().trim()));							
						tem_str = sheet.getCell(15, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petshopVO.setShop_visible(String.valueOf(sheet.getCell(15, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(petshopVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_grp_comment(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "grp_comment";	
			////System.out.println("tableName : "+ tableName);
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
					Grp_comment_interface dao = new Grp_commentDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Grp_commentVO grp_commentVO = new Grp_commentVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的grp_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			grp_commentVO.setMemVO(memVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的grp_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PetGroupVO petGroupVO = new PetGroupVO();
			petGroupVO.setGrp_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			grp_commentVO.setPetGroupVO(petGroupVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						grp_commentVO.setGrpComment_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								grp_commentVO.setGrpComment_SendTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								grp_commentVO.setGrpComment_SendTime(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(grp_commentVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_JoinList(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "JoinList";	
			////System.out.println("tableName : "+ tableName);
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
					JoinList_interface dao = new JoinListDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						JoinListVO joinlistVO = new JoinListVO();
			tem_str = sheet.getCell(0, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的joinlistVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PetGroupVO petGroupVO = new PetGroupVO();
			petGroupVO.setGrp_Id(String.valueOf(sheet.getCell(0, i).getContents().trim()));
			joinlistVO.setPetGroupVO(petGroupVO);	
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的joinlistVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			joinlistVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						joinlistVO.setJOINLIST_ISINVITED(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(joinlistVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_petGroup(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "petGroup";	
			////System.out.println("tableName : "+ tableName);
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
					PetGroup_interface dao = new PetGroupDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						PetGroupVO petgroupVO = new PetGroupVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的petgroupVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			petgroupVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_city(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGRP_TOWN(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_road(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								petgroupVO.setGrp_EndTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								petgroupVO.setGrp_EndTime(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(7, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(7, i).getContents().trim());
								petgroupVO.setGrp_StartTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								petgroupVO.setGrp_StartTime(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(8, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(8, i).getContents().trim());
								petgroupVO.setGrp_CreateTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								petgroupVO.setGrp_CreateTime(tem_date);
							}	
						}	
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_Desc(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_Long(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_Lat(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petgroupVO.setGrp_visible(String.valueOf(sheet.getCell(12, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(13, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(13, i).getContents().trim()));
								petgroupVO.setGRP_PHOTO(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								petgroupVO.setGRP_PHOTO(null);
							}								
						}else{
							petgroupVO.setGRP_PHOTO(null);
						}
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(petgroupVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_hos_photo(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "hos_photo";	
			////System.out.println("tableName : "+ tableName);
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
					Hos_photo_interface dao = new Hos_photoDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Hos_photoVO hos_photoVO = new Hos_photoVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的hos_photoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
			vet_hospitalVO.setHos_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			hos_photoVO.setVet_hospitalVO(vet_hospitalVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(2, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
								byte[] tem_bytes = recoverImageFromUrl(String.valueOf(sheet.getCell(2, i).getContents().trim()));
								hos_photoVO.setHosPhoto_photo(tem_bytes);
								StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(tem_bytes, false)));
								String contourChart = sb.toString();		
								//out.println("contourChart : " + contourChart);
								//out.println("<img src=\"data:image/png;base64,"+contourChart+"\"/>");	
							} catch (Exception e) {
								hos_photoVO.setHosPhoto_photo(null);
							}								
						}else{
							hos_photoVO.setHosPhoto_photo(null);
						}
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						hos_photoVO.setIsDisp_HosPhoto(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						hos_photoVO.setHosPhoto_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						hos_photoVO.setHOSPHOTO_EXTENTION(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(hos_photoVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_hos_comment(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "hos_comment";	
			////System.out.println("tableName : "+ tableName);
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
					Hos_comment_interface dao = new Hos_commentDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Hos_commentVO hos_commentVO = new Hos_commentVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的hos_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			hos_commentVO.setMemVO(memVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的hos_commentVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
			vet_hospitalVO.setHos_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			hos_commentVO.setVet_hospitalVO(vet_hospitalVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						hos_commentVO.setHosComment_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								hos_commentVO.setHosComment_SendTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								hos_commentVO.setHosComment_SendTime(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(hos_commentVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_vet_hospital(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "vet_hospital";	
			////System.out.println("tableName : "+ tableName);
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
					Vet_hospital_interface dao = new Vet_hospitalDAO();
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的vet_hospitalVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			vet_hospitalVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_city(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_town(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_road(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_Eval(Integer.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_URL(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_StartTime(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_EndTime(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(10, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(10, i).getContents().trim());
								vet_hospitalVO.setHos_CreateTime(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								vet_hospitalVO.setHos_CreateTime(tem_date);
							}	
						}	
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_Tel(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_Desc(String.valueOf(sheet.getCell(12, i).getContents().trim()));							
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_Long(Double.valueOf(sheet.getCell(13, i).getContents().trim()));							
						tem_str = sheet.getCell(14, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_Lat(Double.valueOf(sheet.getCell(14, i).getContents().trim()));							
						tem_str = sheet.getCell(15, i).getContents().trim();
						//////System.out.println(tem_str+",");
						vet_hospitalVO.setHos_visible(String.valueOf(sheet.getCell(15, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(vet_hospitalVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani_photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani_photos";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Stray_Ani_photosVO stray_ani_photosVO = new Stray_Ani_photosVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Stray_AniVO stray_AniVO = new Stray_AniVO();
			stray_AniVO.setStray_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			stray_ani_photosVO.setStray_AniVO(stray_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			stray_ani_photosVO.setMemVO(memVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(3, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
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
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_ani_photosVO.setStray_Pic_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_ani_photosVO.setStray_Pic_nameEX(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								stray_ani_photosVO.setStray_Pic_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								stray_ani_photosVO.setStray_Pic_time(tem_date);
							}	
						}	
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_ani_photosVO.setStray_Pic_type(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(stray_ani_photosVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani_message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani_message";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Stray_AniVO stray_AniVO = new Stray_AniVO();
			stray_AniVO.setStray_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			stray_ani_messageVO.setStray_AniVO(stray_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			stray_ani_messageVO.setMemVO(memVO);	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(3, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(3, i).getContents().trim());
								stray_ani_messageVO.setStr_Ani_Mes_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								stray_ani_messageVO.setStr_Ani_Mes_time(tem_date);
							}	
						}	
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_ani_messageVO.setStr_Ani_Mes(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(stray_ani_messageVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani_Loc(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani_Loc";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_ani_locVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Stray_AniVO stray_AniVO = new Stray_AniVO();
			stray_AniVO.setStray_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			stray_ani_locVO.setStray_AniVO(stray_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_ani_locVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			stray_ani_locVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_ani_locVO.setStr_Ani_LocLat(Double.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_ani_locVO.setStr_Ani_LocLon(Double.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(stray_ani_locVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_stray_Ani(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "stray_Ani";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Stray_AniVO stray_aniVO = new Stray_AniVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的stray_aniVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			stray_aniVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_type(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_gender(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_heal(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_Vac(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_color(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_body(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_age(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_Neu(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_chip(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(12, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(12, i).getContents().trim());
								stray_aniVO.setStray_Ani_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								stray_aniVO.setStray_Ani_date(tem_date);
							}	
						}	
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(14, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(14, i).getContents().trim());
								stray_aniVO.setStray_Ani_CreDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								stray_aniVO.setStray_Ani_CreDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(15, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_FinLat(Double.valueOf(sheet.getCell(15, i).getContents().trim()));							
						tem_str = sheet.getCell(16, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_FinLon(Double.valueOf(sheet.getCell(16, i).getContents().trim()));							
						tem_str = sheet.getCell(17, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_city(String.valueOf(sheet.getCell(17, i).getContents().trim()));							
						tem_str = sheet.getCell(18, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_town(String.valueOf(sheet.getCell(18, i).getContents().trim()));							
						tem_str = sheet.getCell(19, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_road(String.valueOf(sheet.getCell(19, i).getContents().trim()));							
						tem_str = sheet.getCell(20, i).getContents().trim();
						//////System.out.println(tem_str+",");
						stray_aniVO.setStray_Ani_like(Integer.valueOf(sheet.getCell(20, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(stray_aniVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_pet_Photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "pet_Photos";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的pet_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PetVO petVO = new PetVO();
			petVO.setPet_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			pet_photosVO.setPetVO(petVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的pet_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			pet_photosVO.setMemVO(memVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(3, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
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
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						pet_photosVO.setPet_Pic_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						pet_photosVO.setPet_Pic_nameEX(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								pet_photosVO.setPet_Pic_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								pet_photosVO.setPet_Pic_time(tem_date);
							}	
						}	
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						pet_photosVO.setPet_Pic_type(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(pet_photosVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_pet_Message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "pet_Message";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Pet_MessageVO pet_messageVO = new Pet_MessageVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PetVO petVO = new PetVO();
			petVO.setPet_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			pet_messageVO.setPetVO(petVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的pet_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			pet_messageVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						pet_messageVO.setPet_Mes(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								pet_messageVO.setPet_Mes_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								pet_messageVO.setPet_Mes_time(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(pet_messageVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_pet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "pet";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						PetVO petVO = new PetVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的petVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			petVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_type(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_gender(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_heal(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_Vac(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_color(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_body(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_age(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_Neu(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_chip(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(12, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(12, i).getContents().trim());
								petVO.setPet_birth(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								petVO.setPet_birth(tem_date);
							}	
						}	
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(14, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(14, i).getContents().trim());
								petVO.setPet_CreDATE(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								petVO.setPet_CreDATE(tem_date);
							}	
						}	
						tem_str = sheet.getCell(15, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_city(String.valueOf(sheet.getCell(15, i).getContents().trim()));							
						tem_str = sheet.getCell(16, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_town(String.valueOf(sheet.getCell(16, i).getContents().trim()));							
						tem_str = sheet.getCell(17, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_road(String.valueOf(sheet.getCell(17, i).getContents().trim()));							
						tem_str = sheet.getCell(18, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_FinLat(Double.valueOf(sheet.getCell(18, i).getContents().trim()));							
						tem_str = sheet.getCell(19, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_FinLon(Double.valueOf(sheet.getCell(19, i).getContents().trim()));							
						tem_str = sheet.getCell(20, i).getContents().trim();
						//////System.out.println(tem_str+",");
						petVO.setPet_like(Integer.valueOf(sheet.getCell(20, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(petVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani_photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani_photos";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
			adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adopt_ani_photosVO.setAdopt_AniVO(adopt_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_ani_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			adopt_ani_photosVO.setMemVO(memVO);	
						if(   !"".equals(String.valueOf(sheet.getCell(3, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
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
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_ani_photosVO.setAdo_Pic_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_ani_photosVO.setAdo_Pic_nameEX(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								adopt_ani_photosVO.setAdo_Pic_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adopt_ani_photosVO.setAdo_Pic_time(tem_date);
							}	
						}	
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_ani_photosVO.setAdo_Pic_type(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adopt_ani_photosVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani_message(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani_message";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
			adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adopt_ani_messageVO.setAdopt_AniVO(adopt_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_ani_messageVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			adopt_ani_messageVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_ani_messageVO.setAdo_Ani_Mes(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								adopt_ani_messageVO.setAdo_Ani_Mes_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adopt_ani_messageVO.setAdo_Ani_Mes_time(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adopt_ani_messageVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani_sponsor(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani_sponsor";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_ani_sponsorVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
			adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adopt_ani_sponsorVO.setAdopt_AniVO(adopt_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_ani_sponsorVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			adopt_ani_sponsorVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_ani_sponsorVO.setAdo_Ani_Spo_money(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_ani_sponsorVO.setAdo_Ani_Spo_thing(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								adopt_ani_sponsorVO.setAdo_Ani_Spo_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adopt_ani_sponsorVO.setAdo_Ani_Spo_time(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adopt_ani_sponsorVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adoAniSpo(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adoAniSpo";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adoanispoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			Adopt_AniVO adopt_AniVO = new Adopt_AniVO();
			adopt_AniVO.setAdopt_Ani_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adoanispoVO.setAdopt_AniVO(adopt_AniVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adoanispoVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			adoanispoVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adoanispoVO.setAdoAniSpoMoney(Integer.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adoanispoVO.setAdoAniSpoMat(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adoanispoVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adopt_Ani(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adopt_Ani";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adopt_aniVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adopt_aniVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_name(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_type(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_gender(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_heal(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_Vac(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_color(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_body(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_age(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_Neu(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_chip(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(12, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(12, i).getContents().trim());
								adopt_aniVO.setAdopt_Ani_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adopt_aniVO.setAdopt_Ani_date(tem_date);
							}	
						}	
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_status(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(14, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(14, i).getContents().trim());
								adopt_aniVO.setAdopt_Ani_CreDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adopt_aniVO.setAdopt_Ani_CreDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(15, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_FinLat(Double.valueOf(sheet.getCell(15, i).getContents().trim()));							
						tem_str = sheet.getCell(16, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_FinLon(Double.valueOf(sheet.getCell(16, i).getContents().trim()));							
						tem_str = sheet.getCell(17, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_city(String.valueOf(sheet.getCell(17, i).getContents().trim()));							
						tem_str = sheet.getCell(18, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_town(String.valueOf(sheet.getCell(18, i).getContents().trim()));							
						tem_str = sheet.getCell(19, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_road(String.valueOf(sheet.getCell(19, i).getContents().trim()));							
						tem_str = sheet.getCell(20, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adopt_aniVO.setAdopt_Ani_like(Integer.valueOf(sheet.getCell(20, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adopt_aniVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_post_Response(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "post_Response";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						Post_ResponseVO post_responseVO = new Post_ResponseVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的post_responseVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			post_responseVO.setMemVO(memVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的post_responseVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			PostVO postVO = new PostVO();
			postVO.setPost_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			post_responseVO.setPostVO(postVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						post_responseVO.setPost_Response_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								post_responseVO.setPost_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								post_responseVO.setPost_time(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								post_responseVO.setPost_Response_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								post_responseVO.setPost_Response_upDate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(post_responseVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_post(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "post";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						PostVO postVO = new PostVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的postVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			postVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						postVO.setPost_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						postVO.setPost_class_Id(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						postVO.setPost_title(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						postVO.setPost_content(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								postVO.setPost_time(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								postVO.setPost_time(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(7, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(7, i).getContents().trim());
								postVO.setPost_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								postVO.setPost_upDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						postVO.setPost_resNum(Integer.valueOf(sheet.getCell(8, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(postVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_offiMsg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "offiMsg";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						OffiMsgVO offimsgVO = new OffiMsgVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的offimsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			EmpVO empVO = new EmpVO();
			empVO.setEmp_No(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			offimsgVO.setEmpVO(empVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						offimsgVO.setOffiMsg_Title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						offimsgVO.setOffiMsg_Content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								offimsgVO.setOffiMsg_Date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								offimsgVO.setOffiMsg_Date(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(offimsgVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_track(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "track";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						TrackVO trackVO = new TrackVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的trackVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			trackVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						trackVO.setTrack_record_class(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						trackVO.setTrack_record_class_Id(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(trackVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adpPhotos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adpPhotos";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AdpPhotosVO adpphotosVO = new AdpPhotosVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adpphotosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			AdpVO adpVO = new AdpVO();
			adpVO.setAdp_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adpphotosVO.setAdpVO(adpVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpphotosVO.setAdpPhotosPic(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adpphotosVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adpMsg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adpMsg";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AdpMsgVO adpmsgVO = new AdpMsgVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			AdpVO adpVO = new AdpVO();
			adpVO.setAdp_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adpmsgVO.setAdpVO(adpVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adpmsgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			adpmsgVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpmsgVO.setMsg(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								adpmsgVO.setAdpMsgDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adpmsgVO.setAdpMsgDate(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								adpmsgVO.setAdpMsgadp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adpmsgVO.setAdpMsgadp_upDate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adpmsgVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_adp(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "adp";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AdpVO adpVO = new AdpVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的adpVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			adpVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_adp_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								adpVO.setAdp_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adpVO.setAdp_start_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								adpVO.setAdp_end_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adpVO.setAdp_end_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								adpVO.setAdp_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								adpVO.setAdp_upDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_city(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_town(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_road(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_addr(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_lon(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_lat(Double.valueOf(sheet.getCell(12, i).getContents().trim()));							
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						adpVO.setAdp_adp_pic(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(adpVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_park(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "park";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						ParkVO parkVO = new ParkVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的parkVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			EmpVO empVO = new EmpVO();
			empVO.setEmp_No(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			parkVO.setEmpVO(empVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_pic(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								parkVO.setPark_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								parkVO.setPark_start_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(6, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(6, i).getContents().trim());
								parkVO.setPark_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								parkVO.setPark_upDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_city(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_town(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_road(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_lon(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						parkVO.setPark_lat(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(parkVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_aniHome_Photos(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "aniHome_Photos";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的anihome_photosVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			AniHomeVO aniHomeVO = new AniHomeVO();
			aniHomeVO.setAniHome_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			anihome_photosVO.setAniHomeVO(aniHomeVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihome_photosVO.setAniHome_Photos_pic(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(anihome_photosVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_aniHome_Msg(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "aniHome_Msg";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的anihome_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			AniHomeVO aniHomeVO = new AniHomeVO();
			aniHomeVO.setAniHome_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			anihome_msgVO.setAniHomeVO(aniHomeVO);	
			tem_str = sheet.getCell(2, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的anihome_msgVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(2, i).getContents().trim()));
			anihome_msgVO.setMemVO(memVO);	
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihome_msgVO.setAniHome_Msg(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								anihome_msgVO.setAdp_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								anihome_msgVO.setAdp_start_date(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(anihome_msgVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_aniHome(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "aniHome";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						AniHomeVO anihomeVO = new AniHomeVO();
			tem_str = sheet.getCell(1, i).getContents().trim();
			//////System.out.println(tem_str+",");
			//以下3行程式碼因為要配合Hibernate的anihomeVO,以能夠使用Hibernate的強大功能,所以這裏顯得比較麻煩!!
			MemVO memVO = new MemVO();
			memVO.setMem_Id(String.valueOf(sheet.getCell(1, i).getContents().trim()));
			anihomeVO.setMemVO(memVO);	
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_title(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_content(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(4, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(4, i).getContents().trim());
								anihomeVO.setAniHome_start_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								anihomeVO.setAniHome_start_date(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								anihomeVO.setAniHome_upDate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								anihomeVO.setAniHome_upDate(tem_date);
							}	
						}	
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_city(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_town(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_road(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_addr(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_lon(Double.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_lat(Double.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						anihomeVO.setAniHome_pic(String.valueOf(sheet.getCell(12, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(anihomeVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_mem(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "mem";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						MemVO memVO = new MemVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_account(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_email(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_Psw(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_nick_name(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						tem_str = sheet.getCell(5, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_name(String.valueOf(sheet.getCell(5, i).getContents().trim()));							
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_gender(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_Tw_Id(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(8, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(8, i).getContents().trim());
								memVO.setMem_birth_date(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								memVO.setMem_birth_date(tem_date);
							}	
						}	
						tem_str = sheet.getCell(9, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_phone(String.valueOf(sheet.getCell(9, i).getContents().trim()));							
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_Intro(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						tem_str = sheet.getCell(11, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_profile(String.valueOf(sheet.getCell(11, i).getContents().trim()));							
						tem_str = sheet.getCell(12, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_black_list(String.valueOf(sheet.getCell(12, i).getContents().trim()));							
						tem_str = sheet.getCell(13, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_permission(String.valueOf(sheet.getCell(13, i).getContents().trim()));							
						tem_str = sheet.getCell(14, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_setting(String.valueOf(sheet.getCell(14, i).getContents().trim()));							
						tem_str = sheet.getCell(15, i).getContents().trim();
						//////System.out.println(tem_str+",");
						memVO.setMem_balance(Integer.valueOf(sheet.getCell(15, i).getContents().trim()));							
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(memVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
			} catch (BiffException e) {
//				e.printStackTrace();
			}					
	}
	private void create_insert_sql_emp(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String tem_str;
		LinkedHashMap<String, List> linkhashMap_excel_DB = 
				Common_variable.linkhashMap_excel_DB;
			String tableName = "emp";	
			////System.out.println("tableName : "+ tableName);
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
					int tem_rows_index = 0 ;
					boolean tem_isMaxRow = false;
					for (int i = 1; i < rows; i++) {
						tem_rows_index ++ ;
						boolean tem_b_hasText = false;
						for (int j = 0; j < columns; j++) {
							tem_str = sheet.getCell(j, i).getContents().trim();
							if(tem_str.length()>0){
								tem_b_hasText = true;
							}
							System.out.print("第"+j+"欄 : " + tem_str);
						}
						System.out.println("---------------------------------------");
						if (!tem_b_hasText) {
							break;
						}
					}
					for (int i = 1; i < tem_rows_index+1; i++) {
						EmpVO empVO = new EmpVO();
						tem_str = sheet.getCell(1, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_name(String.valueOf(sheet.getCell(1, i).getContents().trim()));							
						tem_str = sheet.getCell(2, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_Pw(String.valueOf(sheet.getCell(2, i).getContents().trim()));							
						tem_str = sheet.getCell(3, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_email(String.valueOf(sheet.getCell(3, i).getContents().trim()));							
						tem_str = sheet.getCell(4, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_Id(String.valueOf(sheet.getCell(4, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(5, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(5, i).getContents().trim());
								empVO.setEmp_birthday(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								empVO.setEmp_birthday(tem_date);
							}	
						}	
						tem_str = sheet.getCell(6, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_phone(String.valueOf(sheet.getCell(6, i).getContents().trim()));							
						tem_str = sheet.getCell(7, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_address(String.valueOf(sheet.getCell(7, i).getContents().trim()));							
						tem_str = sheet.getCell(8, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_status(String.valueOf(sheet.getCell(8, i).getContents().trim()));							
						if(   !"".equals(String.valueOf(sheet.getCell(9, i).getContents().trim()))      ){
							try {
								tem_str = "圖片";
								//////System.out.println(tem_str+",");
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
						tem_str = sheet.getCell(10, i).getContents().trim();
						//////System.out.println(tem_str+",");
						empVO.setEmp_Pic_format(String.valueOf(sheet.getCell(10, i).getContents().trim()));							
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(11, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(11, i).getContents().trim());
								empVO.setEmp_hiredate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								empVO.setEmp_hiredate(tem_date);
							}	
						}	
						{
							java.sql.Timestamp tem_date = null;
							try {
								tem_str = sheet.getCell(12, i).getContents().trim();
								//////System.out.println(tem_str+",");
								tem_date = java.sql.Timestamp.valueOf(sheet.getCell(12, i).getContents().trim());
								empVO.setEmp_firedate(tem_date);
							} catch (IllegalArgumentException e) {
								tem_date=null;
								//tem_date=new java.sql.Timestamp(System.currentTimeMillis());
								empVO.setEmp_firedate(tem_date);
							}	
						}	
						//String data_str = sheet.getCell(j, i).getContents().trim();
						//////System.out.println(data_str);
						try {
							dao.insert(empVO);
						} catch (Exception e) {
							System.err.println("有一筆資料無法新增");
						}
					}
				}
				////System.out.println("--------------");
				////System.out.println(tableName+ "  rows:" + rows);
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
			str += "java.sql.Timestamp ";
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
		if (!(data_type.indexOf("CLOB") == -1)) {
			str += "String ";
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
