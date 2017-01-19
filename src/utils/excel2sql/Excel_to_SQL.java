package utils.excel2sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel_to_SQL {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "TEST_ER_MODEL";
	private static final String PASSWORD = "food1234";
	
	public static void sql_drop(String tableName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String str = "";
			String str1 = "drop table ";
			str = str1 + tableName + " CASCADE CONSTRAINTS ";//用java下sql指令 不用加;
			//====打印====
			System.out.println(str+";");
			//====SQL====
			pstmt = con.prepareStatement(str);
			pstmt.executeUpdate();
			//====給文本使用，要加;====
			str +=  ";";//用java下sql指令 不用加;
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}		

	}
	
	static String 欄位名稱_PK2 = null ;
	public static void sql_create(String tableName,Workbook workbook,int start,int end) {
		List<String> pkList = new ArrayList<String>();
		{//判斷PK數量
			for (int i = start; i < end; i++) {
				if (!(sheet.getCell(5, i).getContents().indexOf("PK")==-1)) {
					pkList.add(sheet.getCell(1, i).getContents());
				}
			}
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String str = "CREATE TABLE ";
			String 表格名稱 = tableName;
			str += 表格名稱 + " (";
			// =====================
			for (int k = start; k < end; k++) {
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 資料型態 = sheet.getCell(3, k).getContents();
				String 欄位長度 = sheet.getCell(4, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();
				
				// Cell的getContents方法把單元格中的信息以字符的形式讀取出來
				if (k == start) {
					str += "";
				}else{
					str += ",";
				}
				str += 欄位名稱 + " " 
						+ 資料型態 + ""
						;
				if ("DATE".equals(資料型態) || "BLOB".equals(資料型態)) {
					str += 欄位長度;
				}else{
					str += "(" + 欄位長度 + ")"; 
				}
				
				if (!(限制條件.indexOf("NOT NULL")==-1)) {
					str += " NOT NULL ";
				}
			}
			if (pkList.size()>1){
				str += ", ConStraint "+表格名稱+"_PK PRIMARY KEY ( ";
				//第一行不用","
				for (int i = 0; i < pkList.size(); i++) {
					if(i==0){
						str += pkList.get(i);
					}else{
						str += " , "+pkList.get(i);
					}
				}
				str += " ) ENABLE";
			}
			if (pkList.size()==1) {
				str += ", ConStraint "+表格名稱+"_PK PRIMARY KEY ( "
					+ pkList.get(0)
					+ " ) ENABLE"
					;
			}			
			
			
			// =====================
			str += " )";
			//====打印====
			System.out.println(str+";");
			//====SQL====
			pstmt = con.prepareStatement(str);
		    pstmt.executeUpdate();
			//====給文本使用，要加;====
			str += ";";
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}		
	}
	
	public static void sql_note(String tableName,Workbook workbook,int start,int end) {	
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
					
			// =====================
			for (int k = start; k < end; k++) {
				String str = "";
				String str1 = "COMMENT ON COLUMN ";
				String 表格名稱 = tableName;
				str = str1 + 表格名稱 + ".";				
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 註解;
				String tempStr = str + 欄位名稱 + " IS " ;
				
				if (sheet.getCell(4, k)==null){
					註解 = "";
				}
				else{
					
					註解 =  
							"'" + sheet.getCell(2, k).getContents() + " | PS: "
							+ sheet.getCell(8, k).getContents()
							+ "'";	
				}
				tempStr += 註解 + "";
				//====打印====
				System.out.println(tempStr+";");
				//====SQL====
				pstmt = con.prepareStatement(tempStr);
				pstmt.executeUpdate();
				//====給文本使用，要加;====
				tempStr += ";";
			}
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
				
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}				
	}
	
	/**
	 * <h1>FK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 */
	public static void sql_fk(String tableName,Workbook workbook,int start,int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count_Fk = 1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			// =====================
			for (int k = start; k < end; k++) {
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();
				String 對應表格 = sheet.getCell(6, k).getContents();
				String 對應欄位 = sheet.getCell(7, k).getContents();
				
				if (!(限制條件.indexOf("FK")==-1)) {
					String str = "";
					String 表格名稱 = tableName;
					str += 	
							"ALTER TABLE "
							+ 表格名稱 
							+ " ADD CONSTRAINT " + 表格名稱 +"_FK"+(count_Fk++) 
							+ " FOREIGN KEY ( " + 欄位名稱 + " )"
							+ " REFERENCES " + 對應表格 + " ( " + 對應欄位 +" ) "
							+ "ENABLE"
							;
					//====打印====
					System.out.println(str+";");
					//====SQL====
					pstmt = con.prepareStatement(str);
				    pstmt.executeUpdate();
					//====給文本使用，要加;====
					str += ";";
				}						
			}
	
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}		
	}

	/**
	 * <h1>UK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 */
	public static void sql_unique(String tableName,Workbook workbook,int start,int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count_UK = 1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
	
			// =====================
			for (int k = start; k < end; k++) {
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();
				
				if (!(限制條件.indexOf("UNIQUE")==-1)) {
					String str = "";
					String 表格名稱 = tableName;
					str += 	
							"ALTER TABLE "
							+ 表格名稱 
							+ " ADD CONSTRAINT " + 表格名稱 +"_UK"+(count_UK++) 
							+ " UNIQUE ( " + 欄位名稱 + " )"
							+ "ENABLE"
							;
					//====打印====
					System.out.println(str+";");
					//====SQL====
					pstmt = con.prepareStatement(str);
				    pstmt.executeUpdate();
					//====給文本使用，要加;====
					str += ";";
				}						
			}
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}		
	}	
	
	static List<Integer> startList ;
	static List<Integer> endList ;
	static List<String> tableNameList ;	
	static Sheet sheet;
	static int 最大欄的數量 = 8;
	
	public static void excel_main() throws IOException, BiffException {
		File file = new File("C:/Users/Administrator/git/AnimalMap/src/oracle_sql命令/合併SQL_Excel.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		
		int flag_int = 0;
		boolean flag_b = false;
		int 命令總類數量 = 5;
		for (int g = 0; g < 命令總類數量; g++) {
			for (int i = 2; i < 6; i++) {
				startList = new ArrayList<Integer>();
				endList = new ArrayList<Integer>();
				tableNameList = new ArrayList<String>();
				sheet = workbook.getSheet(i);
				int 列的數量 = sheet.getRows();
				
				for (int j = 0; j < 列的數量; j++) {
					String val = sheet.getCell(0, j).getContents();
					if ("表格名稱".equals(val)) {
						flag_b = true;
						startList.add(j);//紀錄開始點
						String tableName = sheet.getCell(1, j+1).getContents();
						tableNameList.add(tableName);
					}
					if (flag_b && "".equals(val)||" ".equals(val)){
						flag_int++;
						if (flag_int==2){
							flag_b = false;
							flag_int = 0;
							endList.add(j);//紀錄結束點
						}
					}
				}
				//==============
				for (int k = 0; k < tableNameList.size(); k++) {
					// 刪除table
					if (g==0){
						sql_drop((String)tableNameList.get(k));
					// 建立table	
					}else if (g==1)	{
						sql_create((String)tableNameList.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
					// 建立備註
					}else if (g==2)	{
						sql_note((String)tableNameList.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
					// 建立FK
					}else if (g==4)	{
						sql_fk((String)tableNameList.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
					// 建立Unique
					}
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		try {
			excel_main();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}

}
