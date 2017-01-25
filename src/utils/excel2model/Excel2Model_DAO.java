package utils.excel2model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.read.biff.BiffException;
import utils.excel2sql.Excel_create_fakeDB;
import utils.excel2sql.Excel_put_in_hashMap;

/*
 * 問題:
 * 	PK不能給Update命令
 *
 */
public class Excel2Model_DAO {
	private static String 桌面路徑  = Common.桌面路徑 ;

	/**
	 * 裡面裝有所有的DB資料
	 */
	@SuppressWarnings("rawtypes")
	private static LinkedHashMap<String, List> linkhashMap_excel_DB;
	
	@SuppressWarnings("rawtypes")
	public static LinkedHashMap<String, List> linkhashMap_excel_DB_分組編隊 = new LinkedHashMap<String, List>();

	static String ________以下為主要流程_________  = "" ;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws BiffException, IOException {
		// 先獲取excel內所有table資料
		File file = new File(Common.測試Excel檔案路徑);
		linkhashMap_excel_DB = Excel_put_in_hashMap.init(file);
		
		Excel2Model_VO.main(args);
		
		//分組編隊
		表格欄位分組編隊();
		
		try {
			for (String 表格名稱 : linkhashMap_excel_DB.keySet()) {
				List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
				建立DAO(表格名稱,list_列);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void 建立DAO(String 表格名稱, List<List> list_列) throws IOException{
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
				+"DAO"+副檔名;
		
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
				+ "import java.util.*;\n"
				+ "import java.sql.*; \n"
				+ "import javax.naming.Context; \n"
				+ "import javax.naming.InitialContext; \n"
				+ "import javax.naming.NamingException; \n"
				+ "import javax.sql.DataSource; \n"
				+ "/** \n"
				+" *" + "表格名稱 : <br>\n"
				+" *	" + 中文表格名稱 + "<br>\n"
				+" *	英文:" + 表格名稱 + "<br>\n"
				+" */" + " \n"
				+ "public class " + 大寫表格名稱 + "DAO implements " + 大寫表格名稱 +"DAO_interface{"+ "\n" 
				+ "	private static DataSource ds = null; \n"
				+ "	static {\n"
				+ "		try {\n"
				+ "			Context ctx = new InitialContext();\n"
				+ "			ds = (DataSource) ctx.lookup("+Common.DB名稱+");\n"
				+ "		} catch (NamingException e) {\n"
				+ "			e.printStackTrace();\n"
				+ "		}\n"
				+ "	}\n"
				;
		//INSERT_STMT部分
		str += create_INSERT_STMT命令(表格名稱);
		
		//UPDATE部分
		str += create_UPDATE命令(表格名稱);
		
		//DELTE部分
		str += create_DELETE命令(表格名稱);
		
		//GET_ONE_STMT部分
		str += create_GET_ONE_STMT命令(表格名稱);		
	
		//GET_ALL_STMT部分
		str += create_GET_ALL_STMT命令(表格名稱);		
		
		//更新部分
		str += 個別UPDATE命令產生(表格名稱);
		
		//改寫insert部分
		str += 改寫insert方法(表格名稱);
		
		//改寫update方法
		str += 改寫update方法(表格名稱);
	
		//改寫delete方法
		str += 改寫delete方法(表格名稱);
		
		//改寫delete方法
		str += 改寫findByPrimaryKey方法(表格名稱);	
		
		//改寫delete方法
		str += 改寫getAll方法(表格名稱);			
		

//		str+= "	public void " + "update("+大寫VO類別名稱 + " " + 小寫表格名稱+"VO);" + "\n";
		//===============================
//		int 第幾個PK = 0;
//		for (int k = 0; k < list_列.size(); k++) {
//			List<String> list_col = list_列.get(k);
//			String 假資料類型 = (String) list_col.get(0);
//			String 英文欄位名稱 = (String) list_col.get(1);
//			String 限制條件 = (String) list_col.get(5);
//			if (!(限制條件.indexOf("PK")==-1)){
//				str += "	public void " + "delete" + (++第幾個PK) +  "("+"Integer " + 英文欄位名稱+");" + "\n"
//						+"	public "+大寫VO類別名稱 + " " + "findByPrimaryKey"+ (第幾個PK) +"("+"Integer "+ 英文欄位名稱+");" + "\n"
//						;
//			}
//		}						
//		str +=  ""
//				+ "	public " + "List<" + 大寫VO類別名稱 + "> getAll();" + "\n"
//				+ "}";		
	
		
		str += "}";
		//====file資料送出、生成====
		fw.write(str);
		fw.flush();
		fw.close();				
	}

	static String ________以下為工具方法_________  = "" ;	

	private static void 表格欄位分組編隊(){
		
		for (String 表格名稱 : linkhashMap_excel_DB.keySet()) {
			List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
			for (int k = 0; k < list_列.size(); k++) {
				List<String> list_col = list_列.get(k);
				String 小寫英文欄位名稱 = (String) list_col.get(1);
				String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
				String 中文欄位名稱 = (String) list_col.get(2);
				String 資料型態 = (String) list_col.get(3);
				String 欄位長度 = (String) list_col.get(4);
				String 限制條件 = (String) list_col.get(5);
				String 分組編隊 = (String) list_col.get(11);
//				System.err.println(分組編隊);
			}			
			//====分組編隊====
//			linkhashMap_excel_DB_分組編隊
		}			
	}
	
	private static String create_INSERT_STMT命令(String 表格名稱){
		String str = "	//====以下是一般指令====\n";;
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
		str += "	public static final String INSERT_STMT = \"INSERT INTO (";
		for (int k1 = 0; k1 < list_列.size(); k1++) {
			ArrayList<String> list_row = (ArrayList) list_列.get(k1);
			String 英文欄位名稱 = (String) list_row.get(1);
			if (k1 == 0) {
				str += 英文欄位名稱;
			} else {
				str += "," + 英文欄位名稱;
			}
		}
		str += " ) " + "VALUES " + " ( ";
	
		int 編號數_本身 = 1;
		int 編號數_對應 = 1;		
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			
			if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
				if (k==0) {
					str += "? ";
				}else{					
					str += ", ? ";
				}
			}else if (!(限制條件.indexOf("PK") == -1)) {
				str += 表格名稱 + "_seq" + 編號數_本身++ + ".nextval ";
			}else{
				if (k==0) {
					str += "? ";
				}else{					
					str += ", ? ";
				}
			}
		}	
		str += " ) ";
		str += " \" ; \n";
		
		return str ;
	}

	private static String create_UPDATE命令(String 表格名稱){
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();	
		String str = "	//====以下是更新指令====\n";;
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
		str += "	public static final String UPDATE = \"UPDATE "
				+ 表格名稱 + " SET "
				;
		//排除PK外的第一個值
		boolean flat_排除PK_FK外的第一個欄位 = false;
		for (int k1 = 0; k1 < list_列.size(); k1++) {
			List<String> list_col = list_列.get(k1);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
			}else if (!(限制條件.indexOf("PK") == -1)) {
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}				
			}else if (!(限制條件.indexOf("FK") == -1)) {
			}else{
				if (!flat_排除PK_FK外的第一個欄位) {
					str += 小寫英文欄位名稱+"=?";
					flat_排除PK_FK外的第一個欄位 = true;
				} else {
					str += "," + 小寫英文欄位名稱 +"=? ";
				}
			}			
		}
		str += " WHERE " + 第一個PK的欄位名稱 + "=?";
		str += " \" ; \n";
		
		return str ;
	}

	private static String create_DELETE命令(String 表格名稱){
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();	
		String str = "	//====以下是刪除指令====\n";;
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
		str += "	public static final String DELETE = \"DELETE FROM "
				+ 表格名稱
				;
		//排除PK外的第一個值
		boolean flat_排除PK_FK外的第一個欄位 = false;
		for (int k1 = 0; k1 < list_列.size(); k1++) {
			List<String> list_col = list_列.get(k1);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
			}else if (!(限制條件.indexOf("PK") == -1)) {
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}				
			}else if (!(限制條件.indexOf("FK") == -1)) {
			}else{
			}			
		}
		str += " WHERE " + 第一個PK的欄位名稱 + "=?";
		str += " \" ; \n";
		return str ;
	}

	private static String create_GET_ONE_STMT命令(String 表格名稱){
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();	
		String str = "	//====以下是單筆資料查詢指令====\n";;
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
		str += "	public static final String GET_ONE_STMT = \"SELECT ";

		//遍歷全部欄位
		boolean flat_排除PK_FK外的第一個欄位 = false;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			
			if (!flat_排除PK_FK外的第一個欄位) {
				flat_排除PK_FK外的第一個欄位 = true;
			} else {
				str += ",";
			}
			if(!(資料型態.indexOf("DATE")==-1)){
				str += "to_char("+小寫英文欄位名稱+",'yyyy-mm-dd') "+ 小寫英文欄位名稱;
			}else{
				str += 小寫英文欄位名稱;
			}
		}				
		
		//排除PK外的第一個值
		for (int k1 = 0; k1 < list_列.size(); k1++) {
			List<String> list_col = list_列.get(k1);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
			}else if (!(限制條件.indexOf("PK") == -1)) {
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}				
			}else if (!(限制條件.indexOf("FK") == -1)) {
			}else{
			}			
		}
		str += " WHERE " + 第一個PK的欄位名稱 + "=?";
		str += " \" ; \n";
		return str ;
	}

	private static String create_GET_ALL_STMT命令(String 表格名稱){
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();	
		String str = "	//====以下是單筆資料查詢指令====\n";;
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
		str += "	public static final String GET_ALL_STMT = \"SELECT ";
	
		//遍歷全部欄位
		boolean flat_排除PK_FK外的第一個欄位 = false;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			
			if (!flat_排除PK_FK外的第一個欄位) {
				flat_排除PK_FK外的第一個欄位 = true;
			} else {
				str += ",";
			}
			if(!(資料型態.indexOf("DATE")==-1)){
				str += "to_char("+小寫英文欄位名稱+",'yyyy-mm-dd') "+ 小寫英文欄位名稱;
			}else{
				str += 小寫英文欄位名稱;
			}
		}				
		
		//排除PK外的第一個值
		for (int k1 = 0; k1 < list_列.size(); k1++) {
			List<String> list_col = list_列.get(k1);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
			}else if (!(限制條件.indexOf("PK") == -1)) {
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}				
			}else if (!(限制條件.indexOf("FK") == -1)) {
			}else{
			}			
		}
		str += " WHERE " + 第一個PK的欄位名稱 + "=?";
		str += " \" ; \n";
		return str ;
	}

	private static String 個別UPDATE命令產生(String 表格名稱){
		String str = "	//====以下是新增指令====\n";
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}else if(!(限制條件.indexOf("FK")==-1) ){
				
			}else{
				str += "	private static final String " + "UPDATE_"+全部大寫欄位名稱 
						+ " =\" UPDATE " + 表格名稱 + " set " + 全部大寫欄位名稱 + "=? "
						+ " WHERE " + 第一個PK的欄位名稱 + "=? " +"\" ; \n"
						;
			}
		}	
		
		return str ;
	}
	
	private static String 改寫insert方法(String 表格名稱){
		String str = "	//====以下是改寫insert方法====\n";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();
		
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		str	+=  "	@Override\n"
				+ "	public void " + "insert("+大寫VO類別名稱 + " a"+ 大寫表格名稱+"VO){" + "\n"
				+ "		Connection con = null;\n"
				+ "		PreparedStatement pstmt = null;\n"
				+ "		try {\n"
				+ "			con = ds.getConnection();\n"
				+ "			pstmt = con.prepareStatement("+大寫表格名稱+"DAO.INSERT_STMT);\n";
		String 第一個PK的欄位名稱 = "" ;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}else{
				str += "			pstmt.set";
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
						str += "Int ";
					}
				}
				if(!(資料型態.indexOf("BLOB")==-1)){
					str += "Bytes ";
				}	
				str +="("+k+", a"+大寫表格名稱+"VO"+".get"+字首大寫欄位名稱+"());\n";
			}
		}			
		str += "			pstmt.executeUpdate();\n"
				+ "		} catch (SQLException se) {\n"
				+ "			throw new RuntimeException(\"A database error occured. \" + se.getMessage());\n"
				+ "		} finally {\n"
				+ "			if (pstmt != null) {\n"
				+ "				try {\n"
				+ "					pstmt.close();\n"
				+ "				} catch (SQLException se) {\n"
				+ "					se.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "			if (con != null) {\n"
				+ "				try {\n"
				+ "					con.close();\n"
				+ "				} catch (Exception e) {\n"
				+ "					e.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "		}\n"
				+ "	} \n"
				;
		return str ;
	}

	private static String 改寫update方法(String 表格名稱){
		String str = "	//====以下是改寫update方法====\n";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 大寫VO類別名稱 = 大寫表格名稱+"VO"; 
		String 小寫表格名稱 = 表格名稱.toLowerCase();
		
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		str	+=  "	@Override\n"
				+ "	public void " + "update("+大寫VO類別名稱 + " a"+ 大寫表格名稱+"VO){" + "\n"
				+ "		Connection con = null;\n"
				+ "		PreparedStatement pstmt = null;\n"
				+ "		try {\n"
				+ "			con = ds.getConnection();\n"
				+ "			pstmt = con.prepareStatement("+大寫表格名稱+"DAO.UPDATE);\n";
		String 第一個PK的欄位名稱 = "" ;
		int 編號索引 = 1;
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 中文欄位名稱 = (String) list_col.get(2);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}else if(!(限制條件.indexOf("FK")==-1) ){	
			}else{
				str += "			pstmt.set";
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
						str += "Int ";
					}
				}
				if(!(資料型態.indexOf("BLOB")==-1)){
					str += "Bytes ";
				}	
				str +="("+(編號索引++)+", a"+大寫表格名稱+"VO"+".get"+字首大寫欄位名稱+"());\n";
			}
		}			
		str += "			pstmt.executeUpdate();\n"
				+ "		} catch (SQLException se) {\n"
				+ "			throw new RuntimeException(\"A database error occured. \" + se.getMessage());\n"
				+ "		} finally {\n"
				+ "			if (pstmt != null) {\n"
				+ "				try {\n"
				+ "					pstmt.close();\n"
				+ "				} catch (SQLException se) {\n"
				+ "					se.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "			if (con != null) {\n"
				+ "				try {\n"
				+ "					con.close();\n"
				+ "				} catch (Exception e) {\n"
				+ "					e.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "		}\n"
				+ "	} \n"
				;
		return str ;
	}

	private static String 改寫delete方法(String 表格名稱){
		String str = "	//====以下是改寫delete方法====\n";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
				
		str	+=  "	@Override\n"
				+ "	public void " + "delete("
				;
		//====判斷類型====
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
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
						str += "Bytes ";
					}	
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}
		}					
		str	+= " a"+ 大寫表格名稱+"){" + "\n";
		str += 	""
				+ "		Connection con = null;\n"
				+ "		PreparedStatement pstmt = null;\n"
				+ "		try {\n"
				+ "			con = ds.getConnection();\n"
				+ "			pstmt = con.prepareStatement("+大寫表格名稱+"DAO.DELETE);\n";
		int 編號索引 = 1;
		第一個PK的欄位名稱 = "";
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
					str += "			pstmt.set";
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
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}
		}		
		str += "("+編號索引+",a"+大寫表格名稱+");\n";
		
		str += "			pstmt.executeUpdate();\n"
				+ "		} catch (SQLException se) {\n"
				+ "			throw new RuntimeException(\"A database error occured. \" + se.getMessage());\n"
				+ "		} finally {\n"
				+ "			if (pstmt != null) {\n"
				+ "				try {\n"
				+ "					pstmt.close();\n"
				+ "				} catch (SQLException se) {\n"
				+ "					se.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "			if (con != null) {\n"
				+ "				try {\n"
				+ "					con.close();\n"
				+ "				} catch (Exception e) {\n"
				+ "					e.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "		}\n"
				+ "	} \n"
				;
		return str ;
	}

	private static String 改寫findByPrimaryKey方法(String 表格名稱){
		String str = "	//====以下是改寫findByPrimaryKey方法====\n";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 小寫表格名稱 = 表格名稱.toLowerCase();
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
				
		str	+=  "	@Override\n"
				+ "	public "+大寫表格名稱+"VO " + "findByPrimaryKey("
				;
		//====判斷類型====
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
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
						str += "Bytes ";
					}	
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}
		}					
		str	+= " a"+ 大寫表格名稱+"){" + "\n";
		str += 	"		"+大寫表格名稱+"VO " + 小寫表格名稱+"VO = null; \n"  
				+ "		Connection con = null;\n"
				+ "		PreparedStatement pstmt = null;\n"
				+ "		ResultSet rs = null;\n"
				+ "		try {\n"
				+ "			con = ds.getConnection();\n"
				+ "			pstmt = con.prepareStatement("+大寫表格名稱+"DAO.GET_ONE_STMT);\n";
		int 編號索引 = 1;
		第一個PK的欄位名稱 = "";
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			String 限制條件 = (String) list_col.get(5);
			if (!(限制條件.indexOf("PK")==-1) ) {
				//Logic:如果是PK,FK就不給他 Update命令字串
				//		紀錄第一筆PK的值，給後面WHere使用
				if("".equals(第一個PK的欄位名稱)){
					str += "			pstmt.set";
					if(!(資料型態.indexOf("VARCHAR2")==-1)){
						str += "String ";
					}
					if(!(資料型態.indexOf("NUMBER")==-1)){
						if(!(欄位長度.indexOf(",")==-1)){
							str += "Double ";
						}else{
							str += "Int ";
						}
					}
					第一個PK的欄位名稱 = 小寫英文欄位名稱;
				}
			}
		}		
		str += "("+編號索引+",a"+大寫表格名稱+");\n";
		
		str += "			pstmt.executeUpdate();\n"
				+ "			while (rs.next()) {\n"
				+ "				" + 小寫表格名稱 +"VO = new " + 大寫表格名稱 +"VO();\n"
				;
				
		for (int k = 0; k < list_列.size(); k++) {
			List<String> list_col = list_列.get(k);
			String 假資料類型 = (String) list_col.get(0);
			String 小寫英文欄位名稱 = (String) list_col.get(1);
			String 全部大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase();
			String 字首大寫欄位名稱 = 小寫英文欄位名稱.toUpperCase().charAt(0) + 小寫英文欄位名稱.substring(1);
			String 限制條件 = (String) list_col.get(5);
			String 資料型態 = (String) list_col.get(3);
			String 欄位長度 = (String) list_col.get(4);
			str += "				" + 小寫表格名稱 +"VO.set"+字首大寫欄位名稱+"(rs.get";
			if(!(資料型態.indexOf("VARCHAR2")==-1)){
				str += "String";
			}
			if(!(資料型態.indexOf("DATE")==-1)){
				str += "Date";
			}
			if(!(資料型態.indexOf("NUMBER")==-1)){
				if(!(欄位長度.indexOf(",")==-1)){
					str += "Double";
				}else{
					str += "Int";
				}
			}
			if(!(資料型態.indexOf("BLOB")==-1)){
				str += "Bytes";
			}		
			str += "(\"" +小寫英文欄位名稱+ "\"" + "));\n";
			
		}		
		str += "			}\n";	
		
				
				
		str += "		} catch (SQLException se) {\n"
				+ "			throw new RuntimeException(\"A database error occured. \" + se.getMessage());\n"
				+ "		} finally {\n"
				+ "		if (rs != null) {\n"
				+"			try {\n"
				+"					rs.close();\n"
				+"				} catch (SQLException se) {\n"
				+"					se.printStackTrace(System.err);\n"
				+"				}\n"
				+"			}\n"
				+ "			if (pstmt != null) {\n"
				+ "				try {\n"
				+ "					pstmt.close();\n"
				+ "				} catch (SQLException se) {\n"
				+ "					se.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "			if (con != null) {\n"
				+ "				try {\n"
				+ "					con.close();\n"
				+ "				} catch (Exception e) {\n"
				+ "					e.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "		}\n"
				+ "		return "+小寫表格名稱+"VO; \n"
				+ "	} \n"
				;
		return str ;
	}

	private static String 改寫getAll方法(String 表格名稱){
		String str = "	//====以下是改寫getAll方法====\n";
		String 大寫表格名稱 =表格名稱.toUpperCase().charAt(0)+ 表格名稱.substring(1);
		String 小寫表格名稱 = 表格名稱.toLowerCase();
		List<List> list_列 = linkhashMap_excel_DB.get(表格名稱);
		String 第一個PK的欄位名稱 = "" ;
				
		str	+=  "	@Override\n"
				+ "	public List<"+大寫表格名稱+"VO> " + "getAll(){ \n"
				;
		str += 	"		List<"+大寫表格名稱+"VO> list = new ArrayList<"+大寫表格名稱+"VO>();\n"
				+ "		"+大寫表格名稱+"VO "+小寫表格名稱+"VO = null;\n"
				+ "		Connection con = null;\n"
				+ "		PreparedStatement pstmt = null;\n"
				+ "		ResultSet rs = null;\n"
				+ "		try {\n"
				+ "			con = ds.getConnection();\n"
				+ "			pstmt = con.prepareStatement(GET_ALL_STMT);";
		
		str += "			pstmt.executeUpdate();\n"
				+ "		} catch (SQLException se) {\n"
				+ "			throw new RuntimeException(\"A database error occured. \" + se.getMessage());\n"
				+ "		} finally {\n"
				+ "			if (pstmt != null) {\n"
				+ "				try {\n"
				+ "					pstmt.close();\n"
				+ "				} catch (SQLException se) {\n"
				+ "					se.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "			if (con != null) {\n"
				+ "				try {\n"
				+ "					con.close();\n"
				+ "				} catch (Exception e) {\n"
				+ "					e.printStackTrace(System.err);\n"
				+ "				}\n"
				+ "			}\n"
				+ "		}\n"
				+ "		return list;\n"
				+ "	} \n"
				;
		return str ;
	}	
}
