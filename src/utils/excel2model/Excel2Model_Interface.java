package utils.excel2model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.read.biff.BiffException;
import utils.excel2sql.controller.Excel_put_in_hashMap;

/**
 * 
 @startuml
  start
  :先創一個root資料夾;
  :依照package生成對應資料夾;
  fork
  fork again
  #ff0000:____DAO_interface____;
  :創建 "大寫表格名稱"+DAO+"_interface.java" 的檔案在對應資料夾內;
  :"package" +"com"+小寫表格名稱+"model";
  :"import java.util*";
  :"public interface "+大寫表格名稱+"DAO_interface { ";
  	:public void insert(大寫表格名稱+VO "小寫表格名稱+VO);
   	:public void update(大寫表格名稱+VO "小寫表格名稱+VO);;
   	:public void delete(大寫表格名稱+VO "小寫表格名稱+VO);;
   	:public 大寫表格名稱+VO findByPrimaryKey(Integer PK欄位名稱);;
   	:public List<大寫表格名稱+VO> getAll();
   	:jfdigjfdjgpfdjpg;
  :};  
  end fork
  end
 @enduml
 * @author 暐翰
 *
 */
public class Excel2Model_Interface {
	private static String 桌面路徑  = Common.桌面路徑 ;

	
	/**
	 * 裡面裝有所有的DB資料
	 */
	@SuppressWarnings("rawtypes")
	private static LinkedHashMap<String, List> linkhashMap_excel_DB = new LinkedHashMap<String, List>();


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws BiffException, IOException {
		// 先獲取excel內所有table資料
		File file = new File("C:/Users/Administrator/git/AnimalMap/build/classes/utils/excel2sql/合併SQL_Excel.xls");
		linkhashMap_excel_DB = Excel_put_in_hashMap.init(file);		
		
		
		try {
			for (String 表格名稱 : linkhashMap_excel_DB.keySet()) {
				List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
//				.println(表格名稱);
				建立interface(表格名稱,list_列);
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void 建立interface(String 表格名稱, List<List> list_列) throws IOException{
		//===============
		String 主資料夾名稱 = "com";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
//		.println(大寫表格名稱);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();
		String PK欄位名稱 = "";
		String str = "";
		String 副檔名 = ".java";
		String 檔案路徑 = 桌面路徑+主資料夾名稱+"\\"
				+小寫表格名稱+"\\"+"model"+"\\"
				+大寫表格名稱
				+"DAO_interface"+副檔名;
		
		//====file處理====
		File file = new File(檔案路徑);
//		.println(檔案路徑);
		/**
		 * 此時如果直接createNewFile()
		 * 會因為parent的資料夾不存在而失敗，而這時直接使用mkdirs()
		 * 但這樣會把01.log也當成資料夾建立，就無法createNewFile，所以應該先切換到上層目錄再進行mkdirs()
		 * 
		 */
		if(!file.exists())
		{
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		str += "package " + 主資料夾名稱+"." + 小寫表格名稱+"." + "model;"+ "\n"+ "\n"
				+ "import java.util.*; \n"+ "\n"
				+ "public interface "+大寫表格名稱+"DAO_interface {"+ "\n" ;		


		

		FileWriter fw = new FileWriter(file);
		str	+= "	public void " + "insert("+大寫VO類別名稱 + " "+ 小寫表格名稱+"VO);" + "\n"
				+ "	public void " + "update("+大寫VO類別名稱 + " " + 小寫表格名稱+"VO);" + "\n";
		//===============================
		int 第幾個PK = 0;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 假資料類型 = (String) list_col.get(0);
			String 英文欄位名稱 = (String) list_col.get(1);
			String 限制條件 = (String) list_col.get(5);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			if (!(限制條件.indexOf("PK")==-1)){
				str += "	public void " + "delete" ;
				if((++第幾個PK)>1){
					str += 第幾個PK;
				}
				str +=  "(" ;
				if(!(資料型態.indexOf("VARCHAR2")==-1)){
					str += "String ";
				}
				if(!(資料型態.indexOf("NUMBER")==-1)){
					if(!(欄位長度.indexOf(",")==-1)){
						str += "Double ";
					}else{
						str += "Integer ";
					}
				}
				str += 英文欄位名稱+");" + "\n"
					+"	public "+大寫VO類別名稱 + " " + "findByPrimaryKey";
				if((第幾個PK)>1){
					str += 第幾個PK;
				} 
				str += "(" ;
				if(!(資料型態.indexOf("VARCHAR2")==-1)){
					str += "String ";
				}
				if(!(資料型態.indexOf("NUMBER")==-1)){
					if(!(欄位長度.indexOf(",")==-1)){
						str += "Double ";
					}else{
						str += "Integer ";
					}
				}
				str += 英文欄位名稱+");" + "\n";
			}
		}						
		str +=  ""
				+ "	public " + "List<" + 大寫VO類別名稱 + "> getAll();" + "\n"
				+ "}";
		
		
		//====file資料送出、生成====
		fw.write(str);
		fw.flush();
		fw.close();				
	}
	
	
}
