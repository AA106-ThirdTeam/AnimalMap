package utils.excel2sql;

import java.io.File;
import java.io.FileWriter;
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
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.Label;
import jxl.write.WritableSheet;


public class Excel_to_SQL {
	static String sql_str = "";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "TEST_ER_MODEL";
	private static final String PASSWORD = "food1234";
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	public static void sql_drop(String 表格名稱) throws IOException {
		try {
			String str = "";
			String str1 = "drop table ";
			str = str1 + 表格名稱 + " CASCADE CONSTRAINTS ";//用java下sql指令 不用加;
			//合併成一個字串
//			sql_str+= ";" + str;
			//====打印====
			////System.out.println(str+";");
			//====SQL====
			//pstmt = con.prepareStatement(str);
			//pstmt.executeUpdate();
			//====給文本使用，要加;====
			str +=  ";";//用java下sql指令 不用加;
			Excel_to_SQL.write(str);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
			}
		}	
		

	}
	
	static String 欄位名稱_PK2 = null ;
	public static void sql_create(String 表格名稱,Workbook workbook,int start,int end) throws IOException, RowsExceededException, WriteException {
		List<String> pkList = new ArrayList<String>();
		{//判斷PK數量
			for (int i = start; i < end; i++) {
				if (!(sheet.getCell(5, i).getContents().indexOf("PK")==-1)) {
					pkList.add(sheet.getCell(1, i).getContents());
				}
			}
		}
		try {
			
//            // 打開文件
            WritableWorkbook book = Workbook.createWorkbook(new File("c:/test/"+表格名稱+".xls"));
//            // 生成名為“第一頁”的工作表，參數0表示這是第一頁
            WritableSheet sheet2 = book.createSheet(" 第一頁 ", 0);
            for (int k = start; k < end; k++) {
            	String 欄位名稱 = sheet.getCell(1, k).getContents();
            	
                // 在Label對象的構造子中指名單元格位置，EX.第一列第一行(0,0)
                Label label = new Label((k-start), 0, 欄位名稱);
                // 將定義好的單元格添加到工作表中
                sheet2.addCell(label);            	
            }
//            // 寫入數據並關閉文件
            book.write();
            book.close();			
			// =====================
			String str = "CREATE TABLE ";
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
			//System.out.println(str+";");
			//====SQL====
			//pstmt = con.prepareStatement(str);
		    //pstmt.executeUpdate();
			//====給文本使用，要加;====
			str += ";";
			Excel_to_SQL.write(str);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
			}
		}		
	}
	
	public static void sql_note(String 表格名稱,Workbook workbook,int start,int end) throws IOException {	
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String str = "";
				String str1 = "COMMENT ON COLUMN ";
				str = str1 + 表格名稱 + ".";				
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 註解;
				str += 欄位名稱 + " IS " ;
				
				if (sheet.getCell(4, k)==null){
					註解 = "";
				}
				else{
					
					註解 =  
							"'" + sheet.getCell(2, k).getContents() + " | PS: "
							+ sheet.getCell(8, k).getContents()
							+ "'";	
				}
				str += 註解 + "";
				//====打印====
				////System.out.println(tempStr+";");
				//====SQL====
//				pstmt = con.prepareStatement(str);
				//pstmt.executeUpdate();
				//====給文本使用，要加;====
				str += ";";
				Excel_to_SQL.write(str);
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
				
			}
		}				
	}
	
	/**
	 * <h1>FK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 * @throws IOException 
	 */
	public static void sql_fk(String 表格名稱,Workbook workbook,int start,int end) throws IOException {
		int count_Fk = 1;
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();
				String 對應表格 = sheet.getCell(6, k).getContents();
				String 對應欄位 = sheet.getCell(7, k).getContents();
				
				if (!(限制條件.indexOf("FK")==-1)) {
					String str = "";
					str += 	
							"ALTER TABLE "
							+ 表格名稱 
							+ " ADD CONSTRAINT " + 表格名稱 +"_FK"+(count_Fk++) 
							+ " FOREIGN KEY ( " + 欄位名稱 + " )"
							+ " REFERENCES " + 對應表格 + " ( " + 對應欄位 +" ) "
							+ "ENABLE"
							;
					//====打印====
					////System.out.println(str+";");
					//====SQL====
					//pstmt = con.prepareStatement(str);
				    //pstmt.executeUpdate();
					//====給文本使用，要加;====
					str += ";";
					Excel_to_SQL.write(str);
				}						
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
			}
		}		
	}

	/**
	 * <h1>UK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 * @throws IOException 
	 */
	public static void sql_unique(String 表格名稱,Workbook workbook,int start,int end) throws IOException {
		int count_UK = 1;
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();
				
				if (!(限制條件.indexOf("UNIQUE")==-1)) {
					String str = "";
					str += 	
							"ALTER TABLE "
							+ 表格名稱 
							+ " ADD CONSTRAINT " + 表格名稱 +"_UK"+(count_UK++) 
							+ " UNIQUE ( " + 欄位名稱 + " )"
							+ "ENABLE"
							;
					//====打印====
					//System.err.println(str+";");
					//====SQL====
					//pstmt = con.prepareStatement(str);
				    //pstmt.executeUpdate();
					//====給文本使用，要加;====
					str += ";";
					Excel_to_SQL.write(str);
				}						
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
			}
			
		}		
	}	

	
	/**
	 * <h1>UK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 * @throws IOException 
	 */
	public static void sql_seq(String 表格名稱,Workbook workbook,int start,int end) throws IOException {
		int count_SEQ = 1;
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String 起始數 = sheet.getCell(9, k).getContents();
				String 增量 = sheet.getCell(10, k).getContents();
				
				//判斷文字內容不為空(空白鍵判斷為空)
				if (起始數.length()>0 && !(起始數.trim().isEmpty())) {
					String str = "";
					str += 	
							"drop sequence " + 表格名稱 + "_seq" + (count_SEQ) + " ; "
						    + "CREATE SEQUENCE "
							+ " " + 表格名稱 + "_seq" + (count_SEQ++) 
							+ " INCREMENT BY " + 增量
							+ " START WITH " + 起始數
							+ " NOMAXVALUE "
							+ " NOCYCLE "
							+ " NOCACHE "
							;
					//====TEST====
//					//System.err.println(起始數);	
//					//System.err.println(起始數.length());					
					//====打印====
					//System.err.println(str+";");
					//====SQL====
					//pstmt = con.prepareStatement(str);
				    //pstmt.executeUpdate();
					//====給文本使用，要加;====
					str += ";";
					Excel_to_SQL.write(str);
				}						
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
			}
			
		}		
	}		
	
	
	
	
	
	/**
	 * <h1>UK的操作</h1>
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	public static void sql_INSERT(String 表格名稱,Workbook workbook,int start,int end) throws IOException, RowsExceededException, WriteException {
		try {
			String str = "";
			str += "INSERT INTO " + 表格名稱 +" ( ";      	
			for (int k = start; k < end; k++) {
				String 欄位名稱 = sheet.getCell(1, k).getContents();
				if((k-start)==0){
					str += 欄位名稱;
				}else{
					str +=  ","  + 欄位名稱;
				}
			}
			str += " ) ";
			int 指定添加欄編號 = 0 ;
			str += "VALUES "+" ( ";  
			//範圍是欄位的數量
			System.err.println(end-start);
			for (int k = start-start; k < 2; k++) {
				String 輸入值 = sheet_fakeDB.getCell(指定添加欄編號,k+1).getContents();
				System.out.println(輸入值);
				if((k)==0){
					str += 輸入值;
				}else{
					str += "," + 輸入值;
				}
			}	
			str += " ) ";
			str += " ; ";
			System.err.println(str);
			
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close(); pstmt=null;
				} catch (SQLException se) {
					////System.out.println(se);
				}
			}
			
		}		
	}		
	
	
	static List<Integer> startList ;
	static List<Integer> endList ;
	static List<String> 表格名稱List ;	
	static Sheet sheet;
	static Sheet sheet_fakeDB;
	static int 最大欄的數量 = 8;
	static int 工作頁數量 = 8;
	static FileWriter fw = null;
	static int fakeDB_start_index ;
	static int fakeDB_end_index;
	static int fakeDB_rowsCount;
	
	//寫資料進few文件用
	public static void write(String astr) throws IOException{
		fw.write(astr+"\n");
	}
	
	public static void repeat_call_sql(Workbook workbook,int 作業頁數量) throws IOException, RowsExceededException, WriteException{
		int flag_int = 0;
		boolean flag_b = false;
		for (int g = 0; g < 作業頁數量 ; g++) {
//			Thread.sleep(1000); 
			for (int i = 2; i < 最大欄的數量; i++) {
				startList = new ArrayList<Integer>();
				endList = new ArrayList<Integer>();
				表格名稱List = new ArrayList<String>();
				sheet = workbook.getSheet(i);
				int 列的數量 = sheet.getRows();
				
				for (int j = 0; j < 列的數量; j++) {
					String val = sheet.getCell(0, j).getContents();
					if ("表格名稱".equals(val)) {
						flag_b = true;
						startList.add(j);//紀錄開始點
//						//System.err.println(j);
						String 表格名稱 = sheet.getCell(1, j+1).getContents();
						表格名稱List.add(表格名稱);
					}
					if (flag_b && "".equals(val)|| !(val.indexOf(" ")==-1)){
						++flag_int;
						if (flag_int==2){
							flag_b = false;
							flag_int = 0;
							endList.add(j);//紀錄結束點
//							//System.err.println(j);
						}
					}
				}
				//作業頁(有幾頁，就要循環幾次)-> 表格名稱 -> 每列遍歷
				for (int k = 0; k < 表格名稱List.size(); k++) {
					// 刪除table
					if (g==0){
						sql_drop((String)表格名稱List.get(k));
					}
					// 建立table	
					if (g==1)	{
//						//System.err.println((int)startList.get(k)+4);
						sql_create((String)表格名稱List.get(k)
								,workbook,(int)startList.get(k)+4
								,(int)endList.get(k));
//						//System.err.println((int)endList.get(k));
					}
					// 建立備註
					if (g==2)	{
						sql_note((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
					}
					// 建立FK
					if (g==4)	{
//						//System.err.println((int)startList.get(k)+4);
						sql_fk((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
//						//System.err.println((int)endList.get(k));
					}
					// 建立Unique
					if (g==5) {
//						//System.err.println((int)startList.get(k)+4);
						sql_unique((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
//						//System.err.println((int)endList.get(k));
					}
					// 建立SEQ
					if (g==6) {
						sql_seq((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));						
					}		
					// 建立INSERT(假資料)
					if (g==7) {
						sql_INSERT((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));						
					}						
				}
			}
		}			
	}
	
	
	public static void excel_main() throws IOException, BiffException, ClassNotFoundException, SQLException, InterruptedException, RowsExceededException, WriteException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL, USER, PASSWORD);

		//====文字檔IO====
       fw = new FileWriter("E:\\Google 雲端硬碟\\專題第三組\\SQL合併命令.sql");



		
		//讀取組員table資料
		File file = new File("C:/Users/Administrator/git/AnimalMap/src/oracle_sql命令/合併SQL_Excel.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		//假資料Excel
		File file_fakeDB = new File("C:\\Users\\Administrator\\Desktop\\SQL假資料.xls");
		Workbook workbook_fakeDB = Workbook.getWorkbook(file_fakeDB);	
		sheet_fakeDB = workbook_fakeDB.getSheet(0);
		fakeDB_start_index = 0;
		fakeDB_end_index = sheet_fakeDB.getRows();
		//TEst
//		for (int i = 0; i < sheet_fakeDB.getRows(); i++) {
//			System.out.println(sheet_fakeDB.getCell(0, i).getContents());
//		}
		
//		fakeDB_rowsCount = sheet_fakeDB.getRows();
		

		//假如g為8 可以call全部function，也可以call 指令數量的作業頁 //如何分開? //中心思想:等所有作業業做完一系列動作後，在進行下一系列的工作

		
		//文字檔IO
		fw.flush();
		fw.close();
	}
	
	public static void main(String[] args) {
		try {
			excel_main();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
