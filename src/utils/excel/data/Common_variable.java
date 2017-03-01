package utils.excel.data;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener()
public class Common_variable implements ServletContextListener{	
	public static LinkedHashMap<String, List> linkhashMap_excel_DB;
	public static String excel_path_fakeDB;
	public static String excel_fakeDB_output_path;
	public static String excel_fakeDB_input_path;
	public static boolean able_fakeDB_output ;
	public static boolean able_fakeDB_input ;
	public void contextInitialized(ServletContextEvent event) {
		// ==== 取得context物件 ====
		ServletContext context = event.getServletContext();
		// ==== 假資料Excel DB庫 ====
		excel_path_fakeDB = context.getRealPath("\\Input") + "\\SQL假資料.xls";
		// ==== 輸入輸出path ====
		excel_fakeDB_output_path =  context.getRealPath("\\Output") + "\\FakeDB_Excel\\";
		excel_fakeDB_input_path =  context.getRealPath("\\Input") + "\\FakeDB_Excel\\";
		////System.out.println("excel_fakeDB_input_path :" + excel_fakeDB_input_path);
		// ==== 控制布林值 ====
		able_fakeDB_output = true ;
		able_fakeDB_input = true ;
	}
	public void contextDestroyed(ServletContextEvent event) {
		////System.out.println("ServletContextListener通知: FakeDB_Common_contextDestroyed....");
	}		
	static{
		linkhashMap_excel_DB = new LinkedHashMap<String, List>();	

		//==== table名稱 : charge ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("charge", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("charge_no"); //====第2欄====  
				col_List.add("儲值編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("25000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("金錢"); //====第1欄====  
				col_List.add("charge_NUMBER"); //====第2欄====  
				col_List.add("儲值金額"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("pay"); //====第2欄====  
				col_List.add("付款方式"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.ATM 2.超商"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("applytime"); //====第2欄====  
				col_List.add("儲值時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : product_kind ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("product_kind", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("product_kind_no"); //====第2欄====  
				col_List.add("商品類別編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("5"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("11300000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("product_kind_name"); //====第2欄====  
				col_List.add("商品類別名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("NOT NULL"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : orders_item ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("orders_item", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("orders_item_no"); //====第2欄====  
				col_List.add("訂單明細編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("24000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("orders_no"); //====第2欄====  
				col_List.add("訂單編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK FK"); //====第6欄====  
				col_List.add("orders"); //====第7欄====  
				col_List.add("orders_no"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("product_no"); //====第2欄====  
				col_List.add("商品編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK FK"); //====第6欄====  
				col_List.add("product"); //====第7欄====  
				col_List.add("product_no"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("商品庫存量"); //====第1欄====  
				col_List.add("commodities_amout"); //====第2欄====  
				col_List.add("訂購數量"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("金錢"); //====第1欄====  
				col_List.add("selling_price"); //====第2欄====  
				col_List.add("商品售價"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : second_ProdPhotos ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("second_ProdPhotos", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("second_ProdPhotos_Id"); //====第2欄====  
				col_List.add("二手商品相簿編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("11200000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("second_Prod_Id"); //====第2欄====  
				col_List.add("二手商品編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL FK"); //====第6欄====  
				col_List.add("second_Prod"); //====第7欄====  
				col_List.add("second_Prod_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : second_ProdMsg ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("second_ProdMsg", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("second_ProdMsg_Id"); //====第2欄====  
				col_List.add("二手商品留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("11100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("second_Prod_Id"); //====第2欄====  
				col_List.add("二手商品編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL FK"); //====第6欄====  
				col_List.add("second_Prod"); //====第7欄====  
				col_List.add("second_Prod_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("留言會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("second_ProdMsg_Msg"); //====第2欄====  
				col_List.add("二手商品留言"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("second_ProdMsg_DATE"); //====第2欄====  
				col_List.add("留言發布日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("second_ProdMsg_adp_upDate"); //====第2欄====  
				col_List.add("留言更新日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("有更新才會有值"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : product ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("product", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("product_no"); //====第2欄====  
				col_List.add("商品編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("11000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("product_name"); //====第2欄====  
				col_List.add("商品名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("product_introduction"); //====第2欄====  
				col_List.add("商品簡介"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("金錢"); //====第1欄====  
				col_List.add("product_price"); //====第2欄====  
				col_List.add("商品價格"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("商品庫存量"); //====第1欄====  
				col_List.add("product_stock"); //====第2欄====  
				col_List.add("商品庫存量"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("product_picture_large"); //====第2欄====  
				col_List.add("商品圖片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("product_picture_small"); //====第2欄====  
				col_List.add("商品圖片（縮圖）"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("product_status"); //====第2欄====  
				col_List.add("商品上下架狀態"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.上架2.下架"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("product_create_date"); //====第2欄====  
				col_List.add("商品建立日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("product_info"); //====第2欄====  
				col_List.add("商品資訊"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("11"); //====第1欄====  
				col_List.add("product_kind_no"); //====第2欄====  
				col_List.add("商品類別編號"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : second_Prod ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("second_Prod", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("second_Prod_Id"); //====第2欄====  
				col_List.add("二手商品編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("10000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("second_Prod_Title"); //====第2欄====  
				col_List.add("二手商品標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("90"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("標題上限字數-30個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("second_Prod_Content"); //====第2欄====  
				col_List.add("二手商品內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("second_Prod_adp_start_date"); //====第2欄====  
				col_List.add("二手商品發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("結束時間"); //====第1欄====  
				col_List.add("second_Prod_adp_end_date"); //====第2欄====  
				col_List.add("二手商品截止時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("到期刪除二手商品地圖圖標、資訊"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("7"); //====第1欄====  
				col_List.add("second_Prod_adp_upDate"); //====第2欄====  
				col_List.add("二手商品更新時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("second_Prod_adp_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("second_Prod_Town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("second_Prod_Road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("second_Prod_Lon"); //====第2欄====  
				col_List.add("二手商品經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("second_Prod_Lat"); //====第2欄====  
				col_List.add("緯度座標緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : orders ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("orders", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("orders_no"); //====第2欄====  
				col_List.add("訂單編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("26000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add("NOT NULL FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("姓名"); //====第1欄====  
				col_List.add("orders_receiver"); //====第2欄====  
				col_List.add("收件人"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("post_no"); //====第2欄====  
				col_List.add("郵遞區號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("5"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("post_adp_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("post_town"); //====第2欄====  
				col_List.add("鄉鎮"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("post_road"); //====第2欄====  
				col_List.add("路"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("orders_phone"); //====第2欄====  
				col_List.add("收件人電話"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("9"); //====第1欄====  
				col_List.add("collect_mode_no"); //====第2欄====  
				col_List.add("付款方式"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("結束時間"); //====第1欄====  
				col_List.add("orders_date"); //====第2欄====  
				col_List.add("下單日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("orders_ship_date"); //====第2欄====  
				col_List.add("出貨日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("金錢"); //====第1欄====  
				col_List.add("orders_total"); //====第2欄====  
				col_List.add("總金額"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("13"); //====第1欄====  
				col_List.add("orders_status"); //====第2欄====  
				col_List.add("處理狀態"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1處理中2.已完成"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("14"); //====第1欄====  
				col_List.add("orders_credit"); //====第2欄====  
				col_List.add("信用卡卡號"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : emp_purview ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("emp_purview", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("emp_No"); //====第2欄====  
				col_List.add("員工編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PKFK"); //====第6欄====  
				col_List.add("emp"); //====第7欄====  
				col_List.add("emp_No"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("purview_No"); //====第2欄====  
				col_List.add("權限編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PKFK"); //====第6欄====  
				col_List.add("purview"); //====第7欄====  
				col_List.add("purview_No"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : purview ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("purview", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("purview_No"); //====第2欄====  
				col_List.add("權限編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("21000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("purview_name"); //====第2欄====  
				col_List.add("權限名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : animal_index ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("animal_index", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("animal_No"); //====第2欄====  
				col_List.add("圖鑑編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("20000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("animal_detail"); //====第2欄====  
				col_List.add("圖鑑敘述"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("animal_class"); //====第2欄====  
				col_List.add("圖鑑類別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("2"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("animal_class_No"); //====第2欄====  
				col_List.add("圖鑑類別照片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("2"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : emg_H_Msg ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("emg_H_Msg", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("emg_H_Msg_Id"); //====第2欄====  
				col_List.add("緊急求救留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("7100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("留言會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("emg_H_Id"); //====第2欄====  
				col_List.add("求救編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("emg_Help"); //====第7欄====  
				col_List.add("emg_H_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("emg_H_Msg_start"); //====第2欄====  
				col_List.add("發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("emg_H_Msg_content"); //====第2欄====  
				col_List.add("留言內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add("NOTNULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : emg_Help ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("emg_Help", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("emg_H_Id"); //====第2欄====  
				col_List.add("求救編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("7000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發起人編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("出生日期"); //====第1欄====  
				col_List.add("emg_H_start_date"); //====第2欄====  
				col_List.add("開始時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("結束時間"); //====第1欄====  
				col_List.add("emg_H_end_date"); //====第2欄====  
				col_List.add("結束日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("emg_H_title"); //====第2欄====  
				col_List.add("求救標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("90"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("標題上限字數-30個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("emg_H_content"); //====第2欄====  
				col_List.add("求救內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("emg_H_Pic"); //====第2欄====  
				col_List.add("照片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片副檔名"); //====第1欄====  
				col_List.add("emg_H_Pic_format"); //====第2欄====  
				col_List.add("照片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("emg_H_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("emg_H_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("emg_H_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("emg_H_Lon"); //====第2欄====  
				col_List.add("緊急求救經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("emg_H_Lat"); //====第2欄====  
				col_List.add("緊急求救緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("emg_H_status"); //====第2欄====  
				col_List.add("檢舉狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("ex欄位值:emp_H_status="); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : report ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("report", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("report_No"); //====第2欄====  
				col_List.add("檢舉編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("20000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_name"); //====第2欄====  
				col_List.add("檢舉名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_class"); //====第2欄====  
				col_List.add("檢舉類別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0.留言1.文章2.流浪狗3.自家寵物4.揪團活動5.領養活動Table名稱"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_class_No"); //====第2欄====  
				col_List.add("檢舉類別編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0.討論區留言1.討論區文章2.流浪狗圖鑑留言3.自家寵物圖鑑留言3.揪團活動留言4.領養活動留言5.緊急求救留言6.店家留言7.流浪狗編號8.自家寵物編號9.會員編號10.店家編號11.揪團活動編號12.領養活動編號13.緊急求救編號pk名稱"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_class_No_value"); //====第2欄====  
				col_List.add("檢舉類別編號值"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("//再加一欄位放PKvalue"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_content"); //====第2欄====  
				col_List.add("檢舉內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_status"); //====第2欄====  
				col_List.add("檢舉狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("2"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id_active"); //====第2欄====  
				col_List.add("檢舉人ID"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id_passive"); //====第2欄====  
				col_List.add("被檢舉人ID"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_time"); //====第2欄====  
				col_List.add("檢舉時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("//鄭群修改"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("未指定"); //====第1欄====  
				col_List.add("report_class_status"); //====第2欄====  
				col_List.add("檢舉類別的狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("//再加一欄位放檢舉狀態的名稱"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : rel_List ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("rel_List", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("rel_MemId"); //====第2欄====  
				col_List.add("會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("(PK,FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("added_MemId"); //====第2欄====  
				col_List.add("被加會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("(PK,FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("黑名單"); //====第1欄====  
				col_List.add("isBlackList"); //====第2欄====  
				col_List.add("是否為黑名單"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0為否，1為是"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("黑名單"); //====第1欄====  
				col_List.add("isInvited"); //====第2欄====  
				col_List.add("是否已被邀請至揪團"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0為否，1為是"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : priv_message ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("priv_message", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("privMsg_Id"); //====第2欄====  
				col_List.add("私人訊息編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("(PK)"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("privMsgSend_MemId"); //====第2欄====  
				col_List.add("發送會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL(FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("privMsgRec_MemId"); //====第2欄====  
				col_List.add("接收會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL(FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("privMsg_content"); //====第2欄====  
				col_List.add("訊息內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("privMsg_SendTime"); //====第2欄====  
				col_List.add("發送時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("privMsg_type"); //====第2欄====  
				col_List.add("訊息類別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : shop_comment ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("shop_comment", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("shopComment_Id"); //====第2欄====  
				col_List.add("診所留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("shopComment_MemId"); //====第2欄====  
				col_List.add("發送會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("shopComment_ShopId"); //====第2欄====  
				col_List.add("商店編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("petShop"); //====第7欄====  
				col_List.add("shop_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("shopComment_content"); //====第2欄====  
				col_List.add("發送內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("shopComment_SendTime"); //====第2欄====  
				col_List.add("發送時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : shop_photo ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("shop_photo", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("shopPhoto_Id"); //====第2欄====  
				col_List.add("相片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("shopPhoto_ShopId"); //====第2欄====  
				col_List.add("商家編號(相片擁有商家)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("petShop"); //====第7欄====  
				col_List.add("shop_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("shopPhoto_photo"); //====第2欄====  
				col_List.add("相片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("isDisp_shopPhoto"); //====第2欄====  
				col_List.add("是否為大頭貼相片"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0為否，1為是"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片檔名"); //====第1欄====  
				col_List.add("shopPhoto_name"); //====第2欄====  
				col_List.add("相片名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片副檔名"); //====第1欄====  
				col_List.add("SHOPPHOTO_EXTENTION"); //====第2欄====  
				col_List.add("相片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : petShop ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("petShop", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("shop_Id"); //====第2欄====  
				col_List.add("商家編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("shop_MemId"); //====第2欄====  
				col_List.add("會員編號(負責人)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("shop_name"); //====第2欄====  
				col_List.add("商家名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("shop_city"); //====第2欄====  
				col_List.add("縣/市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("shop_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("shop_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("shop_Eval"); //====第2欄====  
				col_List.add("評價"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("shop_URL"); //====第2欄====  
				col_List.add("URL"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("shop_StartTime"); //====第2欄====  
				col_List.add("開始營業時間"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("shop_EndTime"); //====第2欄====  
				col_List.add("結束營業時間"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("shop_CreateTime"); //====第2欄====  
				col_List.add("建立時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("手機"); //====第1欄====  
				col_List.add("shop_Tel"); //====第2欄====  
				col_List.add("電話"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("shop_Desc"); //====第2欄====  
				col_List.add("商家敘述"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("shop_Long"); //====第2欄====  
				col_List.add("商家經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 15 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("shop_Lat"); //====第2欄====  
				col_List.add("商家緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 16 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("shop_visible"); //====第2欄====  
				col_List.add("物件顯示狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.顯示0.不顯示"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : grp_comment ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("grp_comment", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("grpComment_Id"); //====第2欄====  
				col_List.add("揪團留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("grpComment_MemId"); //====第2欄====  
				col_List.add("發送會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("grpComment_GrpId"); //====第2欄====  
				col_List.add("揪團編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL(FK)"); //====第6欄====  
				col_List.add("petGroup"); //====第7欄====  
				col_List.add("grp_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("grpComment_content"); //====第2欄====  
				col_List.add("發送內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("grpComment_SendTime"); //====第2欄====  
				col_List.add("發送時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : JoinList ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("JoinList", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("joinList_GrpId"); //====第2欄====  
				col_List.add("活動編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("(PK)(FK)"); //====第6欄====  
				col_List.add("petGroup"); //====第7欄====  
				col_List.add("grp_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("joinList_MemId"); //====第2欄====  
				col_List.add("會員編號(參加者)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("(PK)(FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("JOINLIST_ISINVITED"); //====第2欄====  
				col_List.add("是否被邀請"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : petGroup ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("petGroup", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("grp_Id"); //====第2欄====  
				col_List.add("活動編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("grp_MemId"); //====第2欄====  
				col_List.add("會員編號(負責人)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("grp_name"); //====第2欄====  
				col_List.add("名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("grp_city"); //====第2欄====  
				col_List.add("縣/市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("GRP_TOWN"); //====第2欄====  
				col_List.add("鄉鎮市區道路"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("grp_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("grp_EndTime"); //====第2欄====  
				col_List.add("結束時間"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("grp_StartTime"); //====第2欄====  
				col_List.add("開始時間"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("grp_CreateTime"); //====第2欄====  
				col_List.add("建立時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("grp_Desc"); //====第2欄====  
				col_List.add("揪團敘述"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("grp_Long"); //====第2欄====  
				col_List.add("商家經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("grp_Lat"); //====第2欄====  
				col_List.add("商家緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("grp_visible"); //====第2欄====  
				col_List.add("物件顯示狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.顯示0.不顯示"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("GRP_PHOTO"); //====第2欄====  
				col_List.add("揪團照片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : hos_photo ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("hos_photo", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("hosPhoto_Id"); //====第2欄====  
				col_List.add("相片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("hosPhoto_HosId"); //====第2欄====  
				col_List.add("診所編號(相片擁有診所)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("vet_hospital"); //====第7欄====  
				col_List.add("hos_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("hosPhoto_photo"); //====第2欄====  
				col_List.add("相片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("isDisp_HosPhoto"); //====第2欄====  
				col_List.add("是否為大頭貼相片"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0為否，1為是"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片檔名"); //====第1欄====  
				col_List.add("hosPhoto_name"); //====第2欄====  
				col_List.add("相片名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片副檔名"); //====第1欄====  
				col_List.add("HOSPHOTO_EXTENTION"); //====第2欄====  
				col_List.add("相片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : hos_comment ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("hos_comment", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("hosComment_Id"); //====第2欄====  
				col_List.add("診所留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("hosComment_MemId"); //====第2欄====  
				col_List.add("發送會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("hosComment_HosId"); //====第2欄====  
				col_List.add("診所編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("vet_hospital"); //====第7欄====  
				col_List.add("hos_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("hosComment_content"); //====第2欄====  
				col_List.add("發送內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("hosComment_SendTime"); //====第2欄====  
				col_List.add("發送時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : vet_hospital ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("vet_hospital", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("hos_Id"); //====第2欄====  
				col_List.add("診所編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("1"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("hos_MemId"); //====第2欄====  
				col_List.add("會員編號(負責人)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("hos_name"); //====第2欄====  
				col_List.add("診所名稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("hos_city"); //====第2欄====  
				col_List.add("縣/市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("hos_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("hos_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("可以為空"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("hos_Eval"); //====第2欄====  
				col_List.add("評價"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("hos_URL"); //====第2欄====  
				col_List.add("URL"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("hos_StartTime"); //====第2欄====  
				col_List.add("開始營業時間"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("hos_EndTime"); //====第2欄====  
				col_List.add("結束營業時間"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("hos_CreateTime"); //====第2欄====  
				col_List.add("建立時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("手機"); //====第1欄====  
				col_List.add("hos_Tel"); //====第2欄====  
				col_List.add("電話"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("hos_Desc"); //====第2欄====  
				col_List.add("診所敘述"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("hos_Long"); //====第2欄====  
				col_List.add("診所經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 15 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("hos_Lat"); //====第2欄====  
				col_List.add("診所緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 16 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("hos_visible"); //====第2欄====  
				col_List.add("物件顯示狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.顯示0.不顯示"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : stray_Ani_photos ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("stray_Ani_photos", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("str_Ani_Pic_No"); //====第2欄====  
				col_List.add("相片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("2100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("stray_Ani_Id"); //====第2欄====  
				col_List.add("社區動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("stray_Ani"); //====第7欄====  
				col_List.add("stray_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("stray_Ani_Pic"); //====第2欄====  
				col_List.add("流浪動物相片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Pic_name"); //====第2欄====  
				col_List.add("相片檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("24"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片副檔名"); //====第1欄====  
				col_List.add("stray_Pic_nameEX"); //====第2欄====  
				col_List.add("相片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("5"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("stray_Pic_time"); //====第2欄====  
				col_List.add("相片發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Pic_type"); //====第2欄====  
				col_List.add("相片類型"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0:一般,1:大頭貼"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : stray_Ani_message ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("stray_Ani_message", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("str_Ani_Mes_No"); //====第2欄====  
				col_List.add("流浪動物留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("2200000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("stray_Ani_Id"); //====第2欄====  
				col_List.add("社區動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("stray_Ani"); //====第7欄====  
				col_List.add("stray_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("str_Ani_Mes_time"); //====第2欄====  
				col_List.add("發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("str_Ani_Mes"); //====第2欄====  
				col_List.add("流浪動物留言"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : stray_Ani_Loc ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("stray_Ani_Loc", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("str_Ani_Loc_No"); //====第2欄====  
				col_List.add("流浪動物出沒編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("2300000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("stray_Ani_Id"); //====第2欄====  
				col_List.add("社區動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("stray_Ani"); //====第7欄====  
				col_List.add("stray_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("str_Ani_LocLat"); //====第2欄====  
				col_List.add("送養地點經度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("str_Ani_LocLon"); //====第2欄====  
				col_List.add("送養地點緯度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : stray_Ani ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("stray_Ani", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("stray_Ani_Id"); //====第2欄====  
				col_List.add("社區動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("2000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("姓名"); //====第1欄====  
				col_List.add("stray_Ani_name"); //====第2欄====  
				col_List.add("流浪動物名字"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("動物種類"); //====第1欄====  
				col_List.add("stray_Ani_type"); //====第2欄====  
				col_List.add("流浪動物種類"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("性別"); //====第1欄====  
				col_List.add("stray_Ani_gender"); //====第2欄====  
				col_List.add("流浪性別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("M.公F.母"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_heal"); //====第2欄====  
				col_List.add("流浪動物健康狀況"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_Vac"); //====第2欄====  
				col_List.add("流浪動物疫苗接踵"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_color"); //====第2欄====  
				col_List.add("流浪動物毛色"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_body"); //====第2欄====  
				col_List.add("流浪動物體型"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_age"); //====第2欄====  
				col_List.add("流浪動物年齡"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_Neu"); //====第2欄====  
				col_List.add("流浪動物節育"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.已節育0.未節育"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_chip"); //====第2欄====  
				col_List.add("流浪動物晶片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("stray_Ani_date"); //====第2欄====  
				col_List.add("流浪動物發現時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("stray_Ani_status"); //====第2欄====  
				col_List.add("流浪動物物件狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.顯示0.不顯示"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 15 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("stray_Ani_CreDate"); //====第2欄====  
				col_List.add("流浪動物建立時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 16 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("stray_Ani_FinLat"); //====第2欄====  
				col_List.add("流浪出沒地點經度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 17 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("stray_Ani_FinLon"); //====第2欄====  
				col_List.add("流浪出沒地點緯度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 18 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("stray_Ani_city"); //====第2欄====  
				col_List.add("縣/市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 19 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("stray_Ani_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 20 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("stray_Ani_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : pet_Photos ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("pet_Photos", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("pet_Pic_No"); //====第2欄====  
				col_List.add("寵物相片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("3100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("pet_Id"); //====第2欄====  
				col_List.add("寵物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("pet"); //====第7欄====  
				col_List.add("pet_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("pet_Pic"); //====第2欄====  
				col_List.add("寵物相片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片檔名"); //====第1欄====  
				col_List.add("pet_Pic_name"); //====第2欄====  
				col_List.add("寵物相片檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("24"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片副檔名"); //====第1欄====  
				col_List.add("pet_Pic_nameEX"); //====第2欄====  
				col_List.add("寵物相片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("5"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("pet_Pic_time"); //====第2欄====  
				col_List.add("發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_Pic_type"); //====第2欄====  
				col_List.add("相片類型"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0:一般,1:大頭貼"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : pet_Message ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("pet_Message", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("pet_Mes_No"); //====第2欄====  
				col_List.add("寵物留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("3200000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("pet_Id"); //====第2欄====  
				col_List.add("寵物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("pet"); //====第7欄====  
				col_List.add("pet_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("pet_Mes"); //====第2欄====  
				col_List.add("寵物留言"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("pet_Mes_time"); //====第2欄====  
				col_List.add("發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : pet ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("pet", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("pet_Id"); //====第2欄====  
				col_List.add("寵物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("3000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("主人會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("姓名"); //====第1欄====  
				col_List.add("pet_name"); //====第2欄====  
				col_List.add("寵物名字"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("動物種類"); //====第1欄====  
				col_List.add("pet_type"); //====第2欄====  
				col_List.add("寵物種類"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("性別"); //====第1欄====  
				col_List.add("pet_gender"); //====第2欄====  
				col_List.add("寵物性別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("M.公F.母"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_heal"); //====第2欄====  
				col_List.add("寵物健康狀況"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_Vac"); //====第2欄====  
				col_List.add("寵物疫苗接踵"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_color"); //====第2欄====  
				col_List.add("寵物毛色"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_body"); //====第2欄====  
				col_List.add("寵物體型"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_age"); //====第2欄====  
				col_List.add("寵物年齡"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_Neu"); //====第2欄====  
				col_List.add("寵物節育"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.已節育0.未節育"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("pet_chip"); //====第2欄====  
				col_List.add("寵物晶片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("出生日期"); //====第1欄====  
				col_List.add("pet_birth"); //====第2欄====  
				col_List.add("寵物生日"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("pet_status"); //====第2欄====  
				col_List.add("寵物物件狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.顯示0.不顯示"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 15 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("pet_CreDATE"); //====第2欄====  
				col_List.add("寵物建立時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 16 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("pet_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 17 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("pet_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 18 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("pet_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 19 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("pet_FinLat"); //====第2欄====  
				col_List.add("送養地點經度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 20 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("pet_FinLon"); //====第2欄====  
				col_List.add("送養地點緯度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adopt_Ani_photos ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adopt_Ani_photos", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("ado_Ani_Pic_No"); //====第2欄====  
				col_List.add("送養動物相片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("4100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("adopt_Ani_Id"); //====第2欄====  
				col_List.add("送養動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("adopt_Ani"); //====第7欄====  
				col_List.add("adopt_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("BLOB"); //====第1欄====  
				col_List.add("ado_Ani_Pic"); //====第2欄====  
				col_List.add("送養動物相片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片檔名"); //====第1欄====  
				col_List.add("ado_Pic_name"); //====第2欄====  
				col_List.add("寵物相片檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("24"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("照片副檔名"); //====第1欄====  
				col_List.add("ado_Pic_nameEX"); //====第2欄====  
				col_List.add("寵物相片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("5"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("ado_Pic_time"); //====第2欄====  
				col_List.add("發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("ado_Pic_type"); //====第2欄====  
				col_List.add("相片類型"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0:一般,1:大頭貼"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adopt_Ani_message ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adopt_Ani_message", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("ado_Ani_Mes_No"); //====第2欄====  
				col_List.add("送養動物留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("4200000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("adopt_Ani_Id"); //====第2欄====  
				col_List.add("社區動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("adopt_Ani"); //====第7欄====  
				col_List.add("adopt_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("送養動物會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("ado_Ani_Mes"); //====第2欄====  
				col_List.add("送養動物留言"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("100"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("ado_Ani_Mes_time"); //====第2欄====  
				col_List.add("發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adopt_Ani_sponsor ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adopt_Ani_sponsor", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("ado_Ani_Spo_No"); //====第2欄====  
				col_List.add("送養動物贊助編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("4300000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("adopt_Ani_Id"); //====第2欄====  
				col_List.add("送養動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("adopt_Ani"); //====第7欄====  
				col_List.add("adopt_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("贊助者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("金錢"); //====第1欄====  
				col_List.add("ado_Ani_Spo_money"); //====第2欄====  
				col_List.add("贊助送養動物金額"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("贊助送養動物物資"); //====第1欄====  
				col_List.add("ado_Ani_Spo_thing"); //====第2欄====  
				col_List.add("贊助送養動物物資"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("ado_Ani_Spo_time"); //====第2欄====  
				col_List.add("贊助送養動物時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adoAniSpo ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adoAniSpo", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("adoAniSpoNo"); //====第2欄====  
				col_List.add("送養動物贊助編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("4400000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("adopt_Ani_Id"); //====第2欄====  
				col_List.add("送養動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("adopt_Ani"); //====第7欄====  
				col_List.add("adopt_Ani_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("贊助者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("金錢"); //====第1欄====  
				col_List.add("adoAniSpoMoney"); //====第2欄====  
				col_List.add("贊助送養動物金額"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("贊助送養動物物資"); //====第1欄====  
				col_List.add("adoAniSpoMat"); //====第2欄====  
				col_List.add("贊助送養動物物資"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adopt_Ani ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adopt_Ani", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("adopt_Ani_Id"); //====第2欄====  
				col_List.add("送養動物編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("4000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布者會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("姓名"); //====第1欄====  
				col_List.add("adopt_Ani_name"); //====第2欄====  
				col_List.add("送養動物名字"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("動物種類"); //====第1欄====  
				col_List.add("adopt_Ani_type"); //====第2欄====  
				col_List.add("送養動物動物種類"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("性別"); //====第1欄====  
				col_List.add("adopt_Ani_gender"); //====第2欄====  
				col_List.add("送養動物性別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("M.公F.母"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_heal"); //====第2欄====  
				col_List.add("送養動物健康狀況"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_Vac"); //====第2欄====  
				col_List.add("送養動物疫苗接踵"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_color"); //====第2欄====  
				col_List.add("送養動物毛色"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_body"); //====第2欄====  
				col_List.add("送養動物體型"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_age"); //====第2欄====  
				col_List.add("送養動物年齡"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_Neu"); //====第2欄====  
				col_List.add("送養動物節育"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.已節育0.未節育"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_chip"); //====第2欄====  
				col_List.add("送養動物晶片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_date"); //====第2欄====  
				col_List.add("送養時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("物件狀態"); //====第1欄====  
				col_List.add("adopt_Ani_status"); //====第2欄====  
				col_List.add("送養動物物件狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.顯示0.不顯示"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 15 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("adopt_Ani_CreDate"); //====第2欄====  
				col_List.add("送養動物建立時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 16 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣經度"); //====第1欄====  
				col_List.add("adopt_Ani_FinLat"); //====第2欄====  
				col_List.add("送養地點經度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 17 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("台灣緯度"); //====第1欄====  
				col_List.add("adopt_Ani_FinLon"); //====第2欄====  
				col_List.add("送養地點緯度"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("google map經緯度"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 18 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("縣市"); //====第1欄====  
				col_List.add("adopt_Ani_city"); //====第2欄====  
				col_List.add("縣/市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 19 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("鄉鎮市區"); //====第1欄====  
				col_List.add("adopt_Ani_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 20 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("道路街名村里"); //====第1欄====  
				col_List.add("adopt_Ani_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 21 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("adopt_Ani_like"); //====第2欄====  
				col_List.add("喜歡數"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("4"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : post_Response ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("post_Response", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("res_Id"); //====第2欄====  
				col_List.add("留言(回覆)編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("16100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號(發文者)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("post_Id"); //====第2欄====  
				col_List.add("文章編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("post"); //====第7欄====  
				col_List.add("post_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("post_Response_content"); //====第2欄====  
				col_List.add("文章留言內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("900"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("post_time"); //====第2欄====  
				col_List.add("發佈時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("修改時間"); //====第1欄====  
				col_List.add("post_Response_upDate"); //====第2欄====  
				col_List.add("修改時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : post ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("post", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("post_Id"); //====第2欄====  
				col_List.add("文章編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("16000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號(發文者)"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("post_class"); //====第2欄====  
				col_List.add("文章分類"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.自介 2.請問 3.資訊 4.推薦(反推) 5.認養 6.協尋 7.拾獲 8.心得"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("post_class_Id"); //====第2欄====  
				col_List.add("文章分類編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("對應其他Table的PK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("post_title"); //====第2欄====  
				col_List.add("文章標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("80"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("post_content"); //====第2欄====  
				col_List.add("文章內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("post_time"); //====第2欄====  
				col_List.add("發佈時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("修改時間"); //====第1欄====  
				col_List.add("post_upDate"); //====第2欄====  
				col_List.add("修改時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("不指定"); //====第1欄====  
				col_List.add("post_resNum"); //====第2欄====  
				col_List.add("回覆數量"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("4"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : offiMsg ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("offiMsg", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("PK"); //====第1欄====  
				col_List.add("offiMsg_Id"); //====第2欄====  
				col_List.add("訊息編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("22000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("FK"); //====第1欄====  
				col_List.add("emp_No"); //====第2欄====  
				col_List.add("發布員工編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("NOT NULL (FK)"); //====第6欄====  
				col_List.add("emp"); //====第7欄====  
				col_List.add("emp_No"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("標題"); //====第1欄====  
				col_List.add("offiMsg_Title"); //====第2欄====  
				col_List.add("訊息標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("90"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("標題上限字數-30個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("內容"); //====第1欄====  
				col_List.add("offiMsg_Content"); //====第2欄====  
				col_List.add("訊息內容"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("發布日期"); //====第1欄====  
				col_List.add("offiMsg_Date"); //====第2欄====  
				col_List.add("訊息發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : track ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("track", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("track_Id"); //====第2欄====  
				col_List.add("收藏編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("19000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("track_record_class"); //====第2欄====  
				col_List.add("收藏種類"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("track_record_class_Id"); //====第2欄====  
				col_List.add("種類編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adpPhotos ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adpPhotos", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("adpPhotos_Id"); //====第2欄====  
				col_List.add("領養活動相簿編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("14200000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("adp_Id"); //====第2欄====  
				col_List.add("領養活動編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("adp"); //====第7欄====  
				col_List.add("adp_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("adpPhotosPic"); //====第2欄====  
				col_List.add("領養活動照片"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adpMsg ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adpMsg", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("adpMsg_Id"); //====第2欄====  
				col_List.add("領養活動留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("14100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("adp_Id"); //====第2欄====  
				col_List.add("領養活動編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("adp"); //====第7欄====  
				col_List.add("adp_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("留言會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("msg"); //====第2欄====  
				col_List.add("領養活動留言"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("adpMsgDate"); //====第2欄====  
				col_List.add("留言發布日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("adpMsgadp_upDate"); //====第2欄====  
				col_List.add("留言更新日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("有更新才會有值"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : adp ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("adp", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("adp_Id"); //====第2欄====  
				col_List.add("領養活動編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("14000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("發布會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("adp_title"); //====第2欄====  
				col_List.add("領養活動標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("90"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("標題上限字數-30個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("adp_adp_content"); //====第2欄====  
				col_List.add("領養活動內容"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("adp_start_date"); //====第2欄====  
				col_List.add("領養活動發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("adp_end_date"); //====第2欄====  
				col_List.add("領養活動到期時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("7"); //====第1欄====  
				col_List.add("adp_upDate"); //====第2欄====  
				col_List.add("領養活動更新時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("adp_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("9"); //====第1欄====  
				col_List.add("adp_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("10"); //====第1欄====  
				col_List.add("adp_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("11"); //====第1欄====  
				col_List.add("adp_addr"); //====第2欄====  
				col_List.add("地址"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
				col_List.add("adp_lon"); //====第2欄====  
				col_List.add("領養活動經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("13"); //====第1欄====  
				col_List.add("adp_lat"); //====第2欄====  
				col_List.add("緯度座標緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("14"); //====第1欄====  
				col_List.add("adp_adp_pic"); //====第2欄====  
				col_List.add("領養活動照片"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : park ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("park", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("park_Id"); //====第2欄====  
				col_List.add("公園編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("180000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("emp_No"); //====第2欄====  
				col_List.add("員工編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("emp"); //====第7欄====  
				col_List.add("emp_No"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("park_title"); //====第2欄====  
				col_List.add("公園標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("90"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("標題上限字數-30個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("park_content"); //====第2欄====  
				col_List.add("公園內容"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("park_pic"); //====第2欄====  
				col_List.add("公園照片"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("park_start_date"); //====第2欄====  
				col_List.add("公園發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("7"); //====第1欄====  
				col_List.add("park_upDate"); //====第2欄====  
				col_List.add("公園更新時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("park_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("9"); //====第1欄====  
				col_List.add("park_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("10"); //====第1欄====  
				col_List.add("park_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("11"); //====第1欄====  
				col_List.add("park_lon"); //====第2欄====  
				col_List.add("公園經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
				col_List.add("park_lat"); //====第2欄====  
				col_List.add("緯度座標緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : aniHome_Photos ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("aniHome_Photos", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("aniHome_Photos_Id"); //====第2欄====  
				col_List.add("相片編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("5200000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("aniHome_Id"); //====第2欄====  
				col_List.add("動物之家編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("aniHome"); //====第7欄====  
				col_List.add("aniHome_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("aniHome_Photos_pic"); //====第2欄====  
				col_List.add("動物之家照片"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : aniHome_Msg ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("aniHome_Msg", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("aniHome_Msg_Id"); //====第2欄====  
				col_List.add("動物之家留言編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("5100000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("aniHome_Id"); //====第2欄====  
				col_List.add("動物之家編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("aniHome"); //====第7欄====  
				col_List.add("aniHome_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add("aniHome_title"); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("留言會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add("mem_name/mem_nick_name"); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("aniHome_Msg"); //====第2欄====  
				col_List.add("動物之家留言"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("adp_start_date"); //====第2欄====  
				col_List.add("留言發布日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : aniHome ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("aniHome", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("aniHome_Id"); //====第2欄====  
				col_List.add("動物之家編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("5000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("FK"); //====第6欄====  
				col_List.add("mem"); //====第7欄====  
				col_List.add("mem_Id"); //====第8欄====  
				col_List.add("FK"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add("mem_name/mem_nick_name"); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("aniHome_title"); //====第2欄====  
				col_List.add("動物之家標題"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("90"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("標題上限字數-30個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("aniHome_content"); //====第2欄====  
				col_List.add("動物之家內容"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("內容上限字數-1000個中文字"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("aniHome_start_date"); //====第2欄====  
				col_List.add("動物之家發布時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("aniHome_upDate"); //====第2欄====  
				col_List.add("動物之家更新時間"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("7"); //====第1欄====  
				col_List.add("aniHome_city"); //====第2欄====  
				col_List.add("縣市"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("aniHome_town"); //====第2欄====  
				col_List.add("鄉鎮市區"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("12"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("9"); //====第1欄====  
				col_List.add("aniHome_road"); //====第2欄====  
				col_List.add("道路街名村里"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("50"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("13"); //====第1欄====  
				col_List.add("aniHome_addr"); //====第2欄====  
				col_List.add("地址"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("300"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("10"); //====第1欄====  
				col_List.add("aniHome_lon"); //====第2欄====  
				col_List.add("動物之家經度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("11"); //====第1欄====  
				col_List.add("aniHome_lat"); //====第2欄====  
				col_List.add("緯度座標緯度座標"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("9,6"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("由住址分析出來，或手機抓GPS取得(有小數點)"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
				col_List.add("aniHome_pic"); //====第2欄====  
				col_List.add("預覽圖"); //====第3欄====  
				col_List.add("CLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : mem ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("mem", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("mem_Id"); //====第2欄====  
				col_List.add("會員編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("PK"); //====第9欄====  
				col_List.add("1000000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("mem_account"); //====第2欄====  
				col_List.add("帳號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("mem_email"); //====第2欄====  
				col_List.add("信箱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("mem_Psw"); //====第2欄====  
				col_List.add("密碼"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("mem_nick_name"); //====第2欄====  
				col_List.add("會員暱稱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("mem_name"); //====第2欄====  
				col_List.add("姓名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("40"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("7"); //====第1欄====  
				col_List.add("mem_gender"); //====第2欄====  
				col_List.add("性別"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("M.男F.女"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("mem_Tw_Id"); //====第2欄====  
				col_List.add("身份證字號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("9"); //====第1欄====  
				col_List.add("mem_birth_date"); //====第2欄====  
				col_List.add("出生年月日"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("10"); //====第1欄====  
				col_List.add("mem_phone"); //====第2欄====  
				col_List.add("手機"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("11"); //====第1欄====  
				col_List.add("mem_Intro"); //====第2欄====  
				col_List.add("個人簡介"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("150"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
				col_List.add("mem_profile"); //====第2欄====  
				col_List.add("大頭照"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("40"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("13"); //====第1欄====  
				col_List.add("mem_black_list"); //====第2欄====  
				col_List.add("黑名單"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0.非黑名單1.黑名單"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 14 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("14"); //====第1欄====  
				col_List.add("mem_permission"); //====第2欄====  
				col_List.add("權限"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1.一般 2.志工 3.店家"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 15 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("15"); //====第1欄====  
				col_List.add("mem_setting"); //====第2欄====  
				col_List.add("偏好設定"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 16 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("mem_balance"); //====第2欄====  
				col_List.add("餘額"); //====第3欄====  
				col_List.add("NUMBER"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	

		//==== table名稱 : emp ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("emp", row_List);
			//====第 1 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("1"); //====第1欄====  
				col_List.add("emp_No"); //====第2欄====  
				col_List.add("員工編號"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("8"); //====第5欄====  
				col_List.add("PK"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add("10000"); //====第10欄====  
				col_List.add("1"); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 2 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("2"); //====第1欄====  
				col_List.add("emp_name"); //====第2欄====  
				col_List.add("員工姓名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("30"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 3 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("3"); //====第1欄====  
				col_List.add("emp_Pw"); //====第2欄====  
				col_List.add("員工密碼"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 4 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("4"); //====第1欄====  
				col_List.add("emp_email"); //====第2欄====  
				col_List.add("員工信箱"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("60"); //====第5欄====  
				col_List.add("UNIQUE"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 5 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("5"); //====第1欄====  
				col_List.add("emp_Id"); //====第2欄====  
				col_List.add("員工身分證"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add("UNIQUE"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("修改欄位名稱成 emp_Id"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("emp_birthday"); //====第2欄====  
				col_List.add("員工出生年月日"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 7 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("7"); //====第1欄====  
				col_List.add("emp_phone"); //====第2欄====  
				col_List.add("員工電話"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("15"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 8 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("8"); //====第1欄====  
				col_List.add("emp_address"); //====第2欄====  
				col_List.add("員工地址"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("100"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 9 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("9"); //====第1欄====  
				col_List.add("emp_status"); //====第2欄====  
				col_List.add("員工狀態"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("1"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add("1:在職 0: 離職"); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 10 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("10"); //====第1欄====  
				col_List.add("emp_picture"); //====第2欄====  
				col_List.add("員工照片"); //====第3欄====  
				col_List.add("BLOB"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 11 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("11"); //====第1欄====  
				col_List.add("emp_Pic_format"); //====第2欄====  
				col_List.add("員工照片副檔名"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("10"); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
				col_List.add("emp_hiredate"); //====第2欄====  
				col_List.add("雇用日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add("NOT NULL"); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
			//====第 13 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("13"); //====第1欄====  
				col_List.add("emp_firedate"); //====第2欄====  
				col_List.add("離職日期"); //====第3欄====  
				col_List.add("DATE"); //====第4欄====  
				col_List.add(""); //====第5欄====  
				col_List.add(""); //====第6欄====  
				col_List.add(""); //====第7欄====  
				col_List.add(""); //====第8欄====  
				col_List.add(""); //====第9欄====  
				col_List.add(""); //====第10欄====  
				col_List.add(""); //====第11欄====  
				col_List.add(""); //====第12欄====  
			}	
		}
	
	}
}
