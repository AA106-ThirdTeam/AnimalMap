package utils.excel2model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.read.biff.BiffException;
import utils.excel2sql.controller.Excel_create_fakeDB;
import utils.excel2sql.controller.Excel_put_in_hashMap;

/**
 * 
 @startuml
  start
  :先創一個root資料夾;
  :依照package生成對應資料夾;
  fork
  #FF0000:如何分隊編組;
  :每個table在多一個分隊ArrayList;
  :多一個欄位 叫分隊欄;
  
  
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
public class Excel2Model_VO {
	private static String 桌面路徑  = Common.桌面路徑 ;

	
	/**
	 * 裡面裝有所有的DB資料
	 */
	@SuppressWarnings("rawtypes")
	private static LinkedHashMap<String, List> linkhashMap_excel_DB = new LinkedHashMap<String, List>();


	static String ________以下為主要流程_________  = "" ;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws BiffException, IOException {
		// 先獲取excel內所有table資料
		File file = new File(Common.測試Excel檔案路徑);
		linkhashMap_excel_DB = Excel_put_in_hashMap.init(file);		
		
		Excel2Model_Interface.main(args);
		
		try {
			for (String 表格名稱 : linkhashMap_excel_DB.keySet()) {
				List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
				建立VO(表格名稱,list_列);
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void 建立VO(String 表格名稱, List<List> list_列) throws IOException{
		//===============
		String 中文表格名稱 = Excel_put_in_hashMap.linkhashMap_excel_DB_表格中文名字.get(表格名稱);
		String 主資料夾名稱 = "com";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();
		String PK欄位名稱 = "";
		String str = "";
		String 副檔名 = ".java";
		String 檔案路徑 = 桌面路徑+主資料夾名稱+"\\"
				+小寫表格名稱+"\\"+"model"+"\\"
				+大寫表格名稱
				+"VO"+副檔名;
		
		//====file處理====
		File file = new File(檔案路徑);
		
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
		
		FileWriter fw = new FileWriter(file);
		
		str += "package " + 主資料夾名稱+"." + 小寫表格名稱+"." + "model;"+ "\n"+ "\n"
				+ "import java.sql.*; \n"
				+ "import java.util.Set; \n"
				+ "import java.util.LinkedHashSet;; \n"+ "\n"
				+ "/** \n"
				+" *" + "表格名稱 : <br>\n"
				+" *	" + 中文表格名稱 + "<br>\n"
				+" *	英文:" + 表格名稱 + "<br>\n"
				+" */" + " \n"
				+ "public class "+大寫表格名稱+"VO implements java.io.Serializable{"+ "\n" 
				+ "	private static final long serialVersionUID = 1L; \n"
				;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			String 註解 = "'" + 中文欄位名稱 + " | PS: " + (String) list_col.get(8) + "'";
			//====Document====
			str += "	/** \n"
			+" 	*	" + "欄位名稱:" + 註解  + "<br>\n"
			+"	*	" + "資料型態:" + 資料型態 	+ "<br>\n"
			+"	*	" + "欄位長度:" + 欄位長度 	+ "<br>\n"
			+"	*	" + "限制條件:" + 限制條件 	+ "<br>\n"
			+" 	*/" + " \n";			
			
			str += 欄位類型返回對應Java屬性(資料型態 , 小寫英文欄位名稱, 欄位長度)+"; \n \n";
		}		
		
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			String 註解 = "'" + 中文欄位名稱 + " | PS: " + (String) list_col.get(8) + "'";
			//====Document====
			str += "	/** \n"
			+" 	*	" + "欄位名稱:" + 註解  + "<br>\n"
			+"	*	" + "資料型態:" + 資料型態 	+ "<br>\n"
			+"	*	" + "欄位長度:" + 欄位長度 	+ "<br>\n"
			+"	*	" + "限制條件:" + 限制條件 	+ "<br>\n"
			+" 	*/" + " \n";			
			str += 欄位類型返回對應Get方法(資料型態, 字首大寫欄位名稱, 小寫英文欄位名稱, 欄位長度)+" \n";
		}
		
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			String 註解 = "'" + 中文欄位名稱 + " | PS: " + (String) list_col.get(8) + "'";		
			//====Document====
			str += "	/** \n"
			+" 	*	" + "欄位名稱:" + 註解  + "<br>\n"
			+"	*	" + "資料型態:" + 資料型態 	+ "<br>\n"
			+"	*	" + "欄位長度:" + 欄位長度 	+ "<br>\n"
			+"	*	" + "限制條件:" + 限制條件 	+ "<br>\n"
			+" 	*/" + " \n";			
			str += 欄位類型返回對應Set方法(資料型態, 字首大寫欄位名稱, 小寫英文欄位名稱, 欄位長度)+" \n";
		}
		
		str +=  ""
				+ "}";
		
		
		//====file資料送出、生成====
		fw.write(str);
		fw.flush();
		fw.close();				
	}

	static String ________以下為工具方法_________  = "" ;
	
	private static String 欄位類型返回對應Java屬性(String 資料型態,String 小寫英文欄位名稱,String 欄位長度){
		String str = "	private	";
		if(!(資料型態.indexOf("VARCHAR2")==-1)){
			str += "String ";
		}
		if(!(資料型態.indexOf("DATE")==-1)){
			str += "Date ";
		}
		if(!(資料型態.indexOf("NUMBER")==-1)){
			if(!(欄位長度.indexOf(",")==-1)){
				str += "Double ";
			}else{
				str += "Integer ";
			}
		}
		if(!(資料型態.indexOf("BLOB")==-1)){
			str += "byte[] ";
		}		
		str += 小寫英文欄位名稱;
		
		return str;
	}

	private static String 欄位類型返回對應Get方法(String 資料型態, String 字首大寫欄位名稱,String 小寫英文欄位名稱,String 欄位長度){
		String str = "	public	";
		if(!(資料型態.indexOf("VARCHAR2")==-1)){
			str += "String ";
		}
		if(!(資料型態.indexOf("DATE")==-1)){
			str += "Date ";
		}
		if(!(資料型態.indexOf("NUMBER")==-1)){
			if(!(欄位長度.indexOf(",")==-1)){
				str += "Double ";
			}else{
				str += "Integer ";
			}
		}
		if(!(資料型態.indexOf("BLOB")==-1)){
			str += "byte[] ";
		}		
		str += "get"+字首大寫欄位名稱+"() { \n"
				+"		return this."+小寫英文欄位名稱+";\n"
				+"	}"
				;
		
		return str;
	}

//	public void setMemIntro(String aMemIntro) {
//		this.memIntro = aMemIntro;
//	}
	private static String 欄位類型返回對應Set方法(String 資料型態, String 字首大寫欄位名稱,String 小寫英文欄位名稱,String 欄位長度){
		String str = "	public	void set" + 字首大寫欄位名稱 + "(";
		if(!(資料型態.indexOf("VARCHAR2")==-1)){
			str += "String ";
		}
		if(!(資料型態.indexOf("DATE")==-1)){
			str += "Date ";
		}
		if(!(資料型態.indexOf("NUMBER")==-1)){
			if(!(欄位長度.indexOf(",")==-1)){
				str += "Double ";
			}else{
				str += "Integer ";
			}
		}
		if(!(資料型態.indexOf("BLOB")==-1)){
			str += "byte[] ";
		}		
		str += "a" + 字首大寫欄位名稱 +") { \n"
				+"		this."+小寫英文欄位名稱+" = a" + 字首大寫欄位名稱 + "; \n"
				+"	} \n"
				;
		
		return str;
	}	
}
