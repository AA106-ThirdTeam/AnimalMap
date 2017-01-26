package utils.excel2sql.model;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel2SQL_VO {
	//====
	public static LinkedHashMap<String, List> 假資料資料庫Excel = new LinkedHashMap<String, List>();
	public static LinkedHashMap<String, List> 表格Excel = new LinkedHashMap<String, List>();
	public static LinkedHashMap<String, List> 生成假資料Excel = new LinkedHashMap<String, List>();
	public static LinkedHashMap<String, String> linkhashMap_excel_DB_表格中文名字   = new LinkedHashMap<String,String>();
	//====
	public static String 假資料Excel的路徑 = "C:\\Users\\Administrator\\git\\AnimalMap\\SQL假資料.xls";
	public static File 假資料Excel的檔案 = new File(假資料Excel的路徑);
	public static Workbook workbook_fakeDB = null;
	
	//====
	public static File SQL_for_假資料 = new File("C:/scott_假資料.sql");
	
	public static void init(){
		//====
		try {
			workbook_fakeDB = Workbook.getWorkbook(假資料Excel的檔案);
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
