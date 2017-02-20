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
		System.out.println("excel_fakeDB_input_path :" + excel_fakeDB_input_path);
		// ==== 控制布林值 ====
		able_fakeDB_output = true ;
		able_fakeDB_input = true ;
	}
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener通知: FakeDB_Common_contextDestroyed....");
	}		
	static{
		linkhashMap_excel_DB = new LinkedHashMap<String, List>();	

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
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
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
				col_List.add("park_pic"); //====第2欄====  
				col_List.add("公園照片"); //====第3欄====  
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
			//====第 6 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("6"); //====第1欄====  
				col_List.add("adp_start_date"); //====第2欄====  
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
				col_List.add("adp_upDate"); //====第2欄====  
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
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("3000"); //====第5欄====  
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
			//====第 11 列====
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
				col_List.add("emp_identity_card"); //====第2欄====  
				col_List.add("員工身分證"); //====第3欄====  
				col_List.add("VARCHAR2"); //====第4欄====  
				col_List.add("20"); //====第5欄====  
				col_List.add("UNIQUE"); //====第6欄====  
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
