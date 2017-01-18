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
	
	public static void sql_drop(Workbook workbook) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				String str = "";
				String str1 = "drop table ";
				String 表格名稱 = workbook.getSheet(i).getName();
				str = str1 + 表格名稱 + " ";//用java下sql指令 不用加;
				//====SQL====
				pstmt = con.prepareStatement(str);
				pstmt.executeUpdate();
				//====給文本使用，要加;====
				str +=  ";";//用java下sql指令 不用加;
				System.out.println(str);
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

	public static void sql_create(Workbook workbook) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
				
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				String str = "";
				String str1 = "CREATE TABLE ";
				String 表格名稱 = workbook.getSheet(i).getName();
				str = str1 + 表格名稱 + " (";
	
				// 由Workbook的getSheet方法選擇工作表（從0開始）
				Sheet sheet = workbook.getSheet(i);
				// 取得Sheet表中所包含的總row數
				int rows = sheet.getRows();
	
				// =====================
				for (int k = 1; k < rows; k++) {
					String tempStr = "";
					String 欄位名稱 = sheet.getCell(0, k).getContents();
					String 資料型態 = sheet.getCell(1, k).getContents();
					String 欄位長度 = sheet.getCell(2, k).getContents();
					String 限制條件 = sheet.getCell(3, k).getContents();
					
					// Cell的getContents方法把單元格中的信息以字符的形式讀取出來
					if (k == 1) {
						tempStr += "";
					}else{
						tempStr += ",";
					}
					tempStr += 欄位名稱 + " " 
							+ 資料型態 + ""
							;
					if ("DATE".equals(資料型態) || "BLOB".equals(資料型態)) {
						tempStr += 欄位長度;
					}else{
						tempStr += "(" + 欄位長度 + ")"; 
					}
					
					if (!(限制條件.equals("Not Null"))) {
						if (!(限制條件.indexOf("PK")==-1)) {
							tempStr += ", ConStraint "+表格名稱+"_PK PRIMARY KEY ( " 
									+ 欄位名稱 
									+ " ) ENABLE"
									;
//							System.err.println("PK");
						}else{
							tempStr += " NOT NULL ";
						}
					}
					str += tempStr;
				}
	
				// =====================
				str += " )";
				//System.out.println(str);
				//====SQL====
				pstmt = con.prepareStatement(str);
			    pstmt.executeUpdate();
				//====給文本使用，要加;====
				str += ";";
				System.out.println(str);				
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
	
	public static void sql_note(Workbook workbook) {	
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
					
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				// 由Workbook的getSheet方法選擇工作表（從0開始）
				Sheet sheet = workbook.getSheet(i);
				// 取得Sheet表中所包含的總row數
				int rows = sheet.getRows();			
				// =====================
				for (int k = 1; k < rows; k++) {
					String str = "";
					String str1 = "COMMENT ON COLUMN ";
					String 表格名稱 = workbook.getSheet(i).getName();
					str = str1 + 表格名稱 + ".";				
					String 欄位名稱 = sheet.getCell(0, k).getContents();
					String 註解;
					String tempStr = str + 欄位名稱 + " IS " ;
					
					if (sheet.getCell(4, k)==null){
						註解 = "";
					}
					else{
						
						註解 =  
								"'" + sheet.getCell(4, k).getContents() + " | PS: "
								+ sheet.getCell(7, k).getContents()
								+ "'";	
					}
					tempStr += 註解 + "";
					//====SQL====
					pstmt = con.prepareStatement(tempStr);
					pstmt.executeUpdate();
					//====給文本使用，要加;====
					tempStr += ";";
					System.out.println(tempStr);				
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
	 * <h1>FK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 */
	public static void sql_fk(Workbook workbook) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count_Fk = 1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
				
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	
				// 由Workbook的getSheet方法選擇工作表（從0開始）
				Sheet sheet = workbook.getSheet(i);
				// 取得Sheet表中所包含的總row數
				int rows = sheet.getRows();
	
				// =====================
				for (int k = 1; k < rows; k++) {
					String 欄位名稱 = sheet.getCell(0, k).getContents();
					String 限制條件 = sheet.getCell(3, k).getContents();
					String 對應表格 = sheet.getCell(5, k).getContents();
					String 對應欄位 = sheet.getCell(6, k).getContents();
					
					if (!(限制條件.indexOf("FK")==-1)) {
						String str = "";
						String 表格名稱 = workbook.getSheet(i).getName();
						str += 	
								"ALTER TABLE "
								+ 表格名稱 
								+ " ADD CONSTRAINT " + 表格名稱 +"_FK"+(count_Fk++) 
								+ " FOREIGN KEY ( " + 欄位名稱 + " )"
								+ " REFERENCES " + 對應表格 + " ( " + 對應欄位 +" ) "
								+ "ENABLE"
								;
						//====SQL====
						pstmt = con.prepareStatement(str);
					    pstmt.executeUpdate();
						//====給文本使用，要加;====
						str += ";";
						System.out.println(str);				
					}						
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
	public static void sql_unique(Workbook workbook) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count_UK = 1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
				
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	
				// 由Workbook的getSheet方法選擇工作表（從0開始）
				Sheet sheet = workbook.getSheet(i);
				// 取得Sheet表中所包含的總row數
				int rows = sheet.getRows();
	
				// =====================
				for (int k = 1; k < rows; k++) {
					String 欄位名稱 = sheet.getCell(0, k).getContents();
					String 限制條件 = sheet.getCell(3, k).getContents();
					
					if (!(限制條件.indexOf("UNIQUE")==-1)) {
						String str = "";
						String 表格名稱 = workbook.getSheet(i).getName();
						str += 	
								"ALTER TABLE "
								+ 表格名稱 
								+ " ADD CONSTRAINT " + 表格名稱 +"_UK"+(count_UK++) 
								+ " UNIQUE ( " + 欄位名稱 + " )"
								+ "ENABLE"
								;
						//====SQL====
						pstmt = con.prepareStatement(str);
					    pstmt.executeUpdate();
						//====給文本使用，要加;====
						str += ";";
						System.out.println(str);				
					}						
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
	
	public static void excel_main() throws IOException, BiffException {
		File 暐翰表格 = new File("C:\\Users\\Administrator\\git\\SQL_For_AnimalMapTable\\data\\暐翰的表格.xls");
		File 志鈞表格 = new File("C:\\Users\\Administrator\\git\\SQL_For_AnimalMapTable\\data\\志鈞的表格.xls");

		List<File> list = new ArrayList<File>();
		list.add(志鈞表格);
		list.add(暐翰表格);
		Workbook workbook = null;
		
		for (Object 表格 : list) {			
			// 從輸入流創建Workbook
			workbook = Workbook.getWorkbook((File)表格);
			
			{// 刪除table
				sql_drop(workbook);
			}
			
			{// 建立table
				sql_create(workbook);
			}
			
			{// 建立註解
				sql_note(workbook);
			}		

			{// 建立UNIQUE
				sql_unique(workbook);
			}				
			
			{// 建立FK
				sql_fk(workbook);
			}		
			
			
			workbook.close();
		}
	}

	public static void main(String[] args) {
		try {
			excel_main();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
