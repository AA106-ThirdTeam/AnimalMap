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

		//==== table名稱 : stray_Ani_photos_H ====
		{
			//====表格====
			ArrayList<List> row_List = new ArrayList<List>();
			linkhashMap_excel_DB.put("stray_Ani_photos_H", row_List);
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
				col_List.add("stray_Pic_extent"); //====第2欄====  
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
				col_List.add("2"); //====第5欄====  
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
				col_List.add("pet_Pic_extent"); //====第2欄====  
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
				col_List.add("2"); //====第5欄====  
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
				col_List.add("ado_Pic_extent"); //====第2欄====  
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
				col_List.add("2"); //====第5欄====  
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
			//====第 12 列====
			{
				ArrayList<String> col_List = new ArrayList<String>();
				row_List.add(col_List);
				//====欄====
				col_List.add("12"); //====第1欄====  
				col_List.add("aniHome_pic"); //====第2欄====  
				col_List.add("預覽圖"); //====第3欄====  
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
