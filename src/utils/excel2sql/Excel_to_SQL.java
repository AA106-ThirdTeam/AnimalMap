package utils.excel2sql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.map.HashedMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.Label;
import jxl.write.WritableSheet;

public class Excel_to_SQL {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "TEST_ER_MODEL";
	private static final String PASSWORD = "food1234";
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static List<Integer> startList;
	static List<Integer> endList;
	static List<String> 表格名稱List;
	static Sheet sheet;
	static Sheet sheet_fakeDB;
	static int 最大欄的數量 = 8;
	static int 工作頁數量 = 8;
	static int 起始頁 = 2;
	static int 結束頁 = 8;
	static FileWriter SQL文字檔 = null;
	static FileWriter SQL文字檔_假資料 = null;
	static HashMap<String, String> hashMap_fakeDB_SEQ = new HashMap<String, String>();;
	static HashMap<String, Integer> hashMap_fakeDB_欄位名稱 = new HashMap<String, Integer>();
	static int index_fakeDB_start;
	/**
	 * 假資料列的總數
	 */
	static int index_fakeDB_end;
	static int count_fakeDB_rows;

	public static void main(String[] args) {
		try {
			init();
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

	public static void init() throws IOException, BiffException, ClassNotFoundException, SQLException,
			InterruptedException, RowsExceededException, WriteException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL, USER, PASSWORD);

		// ====文字檔IO====
		SQL文字檔 = new FileWriter("C:\\Users\\Administrator\\sql\\scott3.sql");
		SQL文字檔_假資料 = new FileWriter("C:\\Users\\Administrator\\sql\\scott3_假資料.sql");

		// 讀取組員table資料
		File file = new File("C:/Users/Administrator/git/AnimalMap/src/oracle_sql命令/合併SQL_Excel.xls");
		Workbook workbook = Workbook.getWorkbook(file);

		// 假資料Excel
		File file_fakeDB = new File("C:\\Users\\Administrator\\Desktop\\SQL假資料.xls");
		Workbook workbook_fakeDB = Workbook.getWorkbook(file_fakeDB);
		sheet_fakeDB = workbook_fakeDB.getSheet(0);
		index_fakeDB_start = 0;
		index_fakeDB_end = sheet_fakeDB.getRows();

		// 後面取第幾欄使用
		for (int i = 0; i < sheet_fakeDB.getColumns(); i++) {
			System.err.println(i);
			System.err.println(sheet_fakeDB.getCell(i, 0).getContents());
			String 欄位名稱 = sheet_fakeDB.getCell(i, 0).getContents();
			hashMap_fakeDB_欄位名稱.put(欄位名稱.trim(), i);
		}

		// 假如g為8 可以call全部function，也可以call 指令數量的作業頁 //如何分開?
		// //中心思想:等所有作業業做完一系列動作後，在進行下一系列的工作
		repeat_call_sql_part_方法的遍歷(workbook);

		// 文字檔IO
		SQL文字檔.flush();
		SQL文字檔.close();
		SQL文字檔_假資料.flush();
		SQL文字檔_假資料.close();
	}

	public static void repeat_call_sql_part_方法的遍歷(Workbook workbook)
			throws IOException, RowsExceededException, WriteException {
		int 總共呼叫幾個方法 = 8;// 總共有:刪、增、註解、fk,unique,seq,insert
		// 作業
		for (int g = 0; g < 總共呼叫幾個方法; g++) {
			repeat_call_sql_part_工作頁的遍歷(workbook, g);
		}
	}

	public static void repeat_call_sql_part_工作頁的遍歷(Workbook workbook, int 第x個SQL方法)
			throws RowsExceededException, WriteException, IOException {

		for (int i = 起始頁; i < 結束頁; i++) {
			startList = new ArrayList<Integer>();
			endList = new ArrayList<Integer>();
			表格名稱List = new ArrayList<String>();

			// 獲取指定頁資料、列的數量
			sheet = workbook.getSheet(i);

			repeat_call_sql_part_獲取表格(workbook, 第x個SQL方法);
		}
	}

	public static void repeat_call_sql_part_獲取表格(Workbook workbook, int 第x個SQL方法)
			throws RowsExceededException, WriteException, IOException {
		int flag_int = 0;
		boolean flag_b = false;
		int 列的數量 = sheet.getRows();
		for (int j = 0; j < 列的數量; j++) {
			String val = sheet.getCell(0, j).getContents();
			if ("表格名稱".equals(val)) {
				flag_b = true;
				startList.add(j);// 紀錄開始點
				String 表格名稱 = sheet.getCell(1, j + 1).getContents();
				表格名稱List.add(表格名稱);
			}
			if (flag_b && "".equals(val) || !(val.indexOf(" ") == -1)) {
				++flag_int;
				if (flag_int == 2) {
					flag_b = false;
					flag_int = 0;
					endList.add(j);// 紀錄結束點
				}
			}
		}

		repeat_call_sql_part_列的遍歷(workbook, 第x個SQL方法);
	}

	public static void repeat_call_sql_part_列的遍歷(Workbook workbook, int 第x個SQL方法)
			throws IOException, RowsExceededException, WriteException {
		// 作業頁(有幾頁，就要循環幾次)-> 表格名稱 -> 每列遍歷

		// System.err.println(表格名稱List.size());
		for (int k = 0; k < 表格名稱List.size(); k++) {
			switch (第x個SQL方法) {
			case 0:
				// 刪除table
				sql_drop((String) 表格名稱List.get(k)); // 參數 代表表格名稱
				break;
			case 1:
				// 建立table
				sql_create((String) 表格名稱List.get(k), workbook, (int) startList.get(k) + 4, (int) endList.get(k));
				break;
			case 2:
				// // 建立備註
				// sql_note((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
				break;
			case 3:
				 // 建立FK
				 sql_fk((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
			case 4:
				// // 建立Unique
				// sql_unique((String)表格名稱List.get(k),workbook,(int)startList.get(k)+4,(int)endList.get(k));
			case 5:
				// 建立SEQ
				sql_seq((String) 表格名稱List.get(k), workbook, (int) startList.get(k) + 4, (int) endList.get(k));
			case 6:
				// 建立INSERT(假資料)
				// System.err.println((int) startList.get(k) + 4);
				sql_insert((String) 表格名稱List.get(k), workbook, (int) startList.get(k) + 4, (int) endList.get(k));
				// System.err.println((int) endList.get(k));
			}
		}
	}

	public static void sql_drop(String 表格名稱) throws IOException {
		try {
			String str = "";
			String str1 = "drop table ";
			str = str1 + 表格名稱 + " CASCADE CONSTRAINTS ";// 用java下sql指令 不用加;
			// 合併成一個字串
			// sql_str+= ";" + str;
			// ====打印====
			//// System.out.println(str+";");
			// ====SQL====
			// pstmt = con.prepareStatement(str);
			// pstmt.executeUpdate();
			// ====給文本使用，要加;====
			str += ";";// 用java下sql指令 不用加;
			Excel_to_SQL.write(str);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}
			}
		}

	}

	public static void sql_create(String 表格名稱, Workbook workbook, int start, int end)
			throws IOException, RowsExceededException, WriteException {
		List<String> pkList = new ArrayList<String>();
		{// 判斷PK數量
			for (int i = start; i < end; i++) {
				if (!(sheet.getCell(5, i).getContents().indexOf("PK") == -1)) {
					pkList.add(sheet.getCell(1, i).getContents());
				}
			}
		}
		try {

			// // 打開文件
			WritableWorkbook book = Workbook.createWorkbook(new File("c:/test/" + 表格名稱 + ".xls"));
			// // 生成名為“第一頁”的工作表，參數0表示這是第一頁
			WritableSheet sheet2 = book.createSheet(" 第一頁 ", 0);
			for (int k = start; k < end; k++) {
				String 英文欄位名稱 = sheet.getCell(1, k).getContents();

				// 在Label對象的構造子中指名單元格位置，EX.第一列第一行(0,0)
				Label label = new Label((k - start), 0, 英文欄位名稱);
				// 將定義好的單元格添加到工作表中
				sheet2.addCell(label);
			}
			// // 寫入數據並關閉文件
			book.write();
			book.close();
			// =====================
			String str = "CREATE TABLE ";
			str += 表格名稱 + " (";
			// =====================
			for (int k = start; k < end; k++) {
				String 英文欄位名稱 = sheet.getCell(1, k).getContents();
				String 資料型態 = sheet.getCell(3, k).getContents();
				String 欄位長度 = sheet.getCell(4, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();

				// Cell的getContents方法把單元格中的信息以字符的形式讀取出來
				if (k == start) {
					str += "";
				} else {
					str += ",";
				}
				str += 英文欄位名稱 + " " + 資料型態 + "";
				if ("DATE".equals(資料型態) || "BLOB".equals(資料型態)) {
					str += 欄位長度;
				} else {
					str += "(" + 欄位長度 + ")";
				}

				if (!(限制條件.indexOf("NOT NULL") == -1)) {
					// str += " NOT NULL ";
				}
			}
			if (pkList.size() > 1) {
				str += ", ConStraint " + 表格名稱 + "_PK PRIMARY KEY ( ";
				// 第一行不用","
				for (int i = 0; i < pkList.size(); i++) {
					if (i == 0) {
						str += pkList.get(i);
					} else {
						str += " , " + pkList.get(i);
					}
				}
				str += " ) ENABLE";
			}
			if (pkList.size() == 1) {
				str += ", ConStraint " + 表格名稱 + "_PK PRIMARY KEY ( " + pkList.get(0) + " ) ENABLE";
			}

			// =====================
			str += " )";
			// ====打印====
			// System.out.println(str+";");
			// ====SQL====
			// pstmt = con.prepareStatement(str);
			// pstmt.executeUpdate();
			// ====給文本使用，要加;====
			str += ";";
			Excel_to_SQL.write(str);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}
			}
		}
	}

	public static void sql_note(String 表格名稱, Workbook workbook, int start, int end) throws IOException {
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String str = "";
				String str1 = "COMMENT ON COLUMN ";
				str = str1 + 表格名稱 + ".";
				String 英文欄位名稱 = sheet.getCell(1, k).getContents();
				String 註解;
				str += 英文欄位名稱 + " IS ";

				if (sheet.getCell(4, k) == null) {
					註解 = "";
				} else {

					註解 = "'" + sheet.getCell(2, k).getContents() + " | PS: " + sheet.getCell(8, k).getContents() + "'";
				}
				str += 註解 + "";
				// ====打印====
				//// System.out.println(tempStr+";");
				// ====SQL====
				// pstmt = con.prepareStatement(str);
				// pstmt.executeUpdate();
				// ====給文本使用，要加;====
				str += ";";
				Excel_to_SQL.write(str);
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}

			}
		}
	}

	/**
	 * <h1>FK的操作</h1>
	 * 
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 * @throws IOException
	 */
	public static void sql_fk(String 表格名稱, Workbook workbook, int start, int end) throws IOException {
		int count_Fk = 1;
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String 英文欄位名稱 = sheet.getCell(1, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();
				String 對應表格 = sheet.getCell(6, k).getContents();
				String 對應欄位 = sheet.getCell(7, k).getContents();

				if (!(限制條件.indexOf("FK") == -1)) {
					// !!!! 特別給INSERT使用
					hashMap_fakeDB_SEQ.put(表格名稱 + "_seq" + String.valueOf(count_Fk), 對應表格 + "_seq" + String.valueOf(count_Fk));					
					
					String str = "";
					str += "ALTER TABLE " + 表格名稱 + " ADD CONSTRAINT " + 表格名稱 + "_FK" + (count_Fk++) + " FOREIGN KEY ( "
							+ 英文欄位名稱 + " )" + " REFERENCES " + 對應表格 + " ( " + 對應欄位 + " ) " + "ENABLE";
					// ====打印====
					//// System.out.println(str+";");
					// ====SQL====
					// pstmt = con.prepareStatement(str);
					// pstmt.executeUpdate();
					// ====給文本使用，要加;====
					str += ";";
//					Excel_to_SQL.write(str);
				}
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}
			}
		}
	}

	/**
	 * <h1>UK的操作</h1>
	 * 
	 * @param workbook
	 * @version 1.0
	 * @author 暐翰
	 * @throws IOException
	 */
	public static void sql_unique(String 表格名稱, Workbook workbook, int start, int end) throws IOException {
		int count_UK = 1;
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String 英文欄位名稱 = sheet.getCell(1, k).getContents();
				String 限制條件 = sheet.getCell(5, k).getContents();

				if (!(限制條件.indexOf("UNIQUE") == -1)) {
					String str = "";
					str +=

							// "ALTER TABLE "+表格名稱
							// + " DROP CONSTRAINT " + 表格名稱 +"_UK"+(count_UK) +
							// " ; "
							// +
							"ALTER TABLE " + 表格名稱 + " ADD CONSTRAINT " + 表格名稱 + "_UK" + (count_UK++) + " UNIQUE ( "
									+ 英文欄位名稱 + " )" + "ENABLE";
					// ====打印====
					// System.err.println(str+";");
					// ====SQL====
					// pstmt = con.prepareStatement(str);
					// pstmt.executeUpdate();
					// ====給文本使用，要加;====
					str += ";";
					Excel_to_SQL.write(str);
				}
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}
			}

		}
	}

	/**
	 * @param 表格名稱
	 * @param workbook
	 * @param start
	 * @param end
	 * @throws IOException
	 */
	public static void sql_seq(String 表格名稱, Workbook workbook, int start, int end) throws IOException {
		int count_SEQ = 1;
		try {
			// =====================
			for (int k = start; k < end; k++) {
				String 起始數 = sheet.getCell(9, k).getContents();
				String 增量 = sheet.getCell(10, k).getContents();

				// Bad

				// 判斷文字內容不為空(空白鍵判斷為空)
				if (起始數.length() > 0 && !(起始數.trim().isEmpty())) {


					String str = "";
					str += "drop sequence " + 表格名稱 + "_seq" + (count_SEQ) + " ; " + "CREATE SEQUENCE " + " " + 表格名稱
							+ "_seq" + (count_SEQ++) + " INCREMENT BY " + 增量 + " START WITH " + 起始數 + " NOMAXVALUE "
							+ " NOCYCLE " + " NOCACHE ";

					// ====TEST====
					// //System.err.println(起始數);
					// //System.err.println(起始數.length());
					// ====打印====
					// System.err.println(str+";");
					// ====SQL====
					// pstmt = con.prepareStatement(str);
					// pstmt.executeUpdate();
					// ====給文本使用，要加;====
					str += ";";
					Excel_to_SQL.write(str);
				}
			}
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}
			}

		}
	}

	/**
	 * @param 表格名稱
	 * @param workbook
	 * @param start
	 * @param end
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void sql_insert(String 表格名稱, Workbook workbook, int start, int end)
			throws IOException, RowsExceededException, WriteException {
		try {
			// System.err.println(fakeDB_end_index);
			// for (int i = 1; i < fakeDB_end_index ; i++) {
			for (int i = 1; i < 2; i++) {
				String str = "";
				str += "INSERT INTO " + 表格名稱 + " ( ";
				for (int k = start; k < end; k++) {
					String 英文欄位名稱 = sheet.getCell(1, k).getContents();
					String 資料型態 = sheet.getCell(3, k).getContents();
					String 欄位長度 = sheet.getCell(4, k).getContents();
					String 限制條件 = sheet.getCell(5, k).getContents();
					if ((k - start) == 0) {
						str += 英文欄位名稱;
					} else {
						str += "," + 英文欄位名稱;
					}
				}
				str += " ) ";
				int 指定添加欄編號 = 0;
				str += "VALUES " + " ( ";
				// 範圍是欄位的數量
				// System.err.println(end-start);
				int 編號數_本身 = 1;
				int 編號數_對應 = 1;
				for (int k = start; k < end; k++) {
					String 假資料類型 = sheet.getCell(0, k).getContents();
					String 英文欄位名稱 = sheet.getCell(1, k).getContents();
					String 中文欄位名稱 = sheet.getCell(2, k).getContents();
					String 資料型態 = sheet.getCell(3, k).getContents();
					String 欄位長度 = sheet.getCell(4, k).getContents();
					String 限制條件 = sheet.getCell(5, k).getContents();
					String 對應表格 = sheet.getCell(6, k).getContents();
					String 對應欄位 = sheet.getCell(7, k).getContents();
					// System.err.println(k - start + 1);
					String 輸入值 = sheet_fakeDB.getCell(指定添加欄編號, k - start + 1).getContents();
					String 註解 = "'" + 中文欄位名稱 + " | PS: " + sheet.getCell(8, k).getContents() + "'";

					// ==============================================
					// PK FK
					if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
						System.err.println("FK :" + 表格名稱 + "  " + 英文欄位名稱 + "  " + 中文欄位名稱);
						System.err.println("FK-對應表格: " + 對應表格 + "  " + 對應欄位);
						// 對應seq
						String 對應PK的SEQ名稱 = (String) hashMap_fakeDB_SEQ.get((表格名稱 + "_seq" + String.valueOf(編號數_本身++)));
						System.err.println("FK-對應表格: " + 表格名稱 + "_seq" + (編號數_對應++) + " - " + 對應PK的SEQ名稱);
					} else if (!(限制條件.indexOf("PK") == -1)) {
						輸入值 = 表格名稱 + "_seq" + 編號數_對應++ + ".nextval ";
					} else if (!(限制條件.indexOf("FK") == -1)) {
						String 對應PK的SEQ名稱 = (String) hashMap_fakeDB_SEQ.get((表格名稱 + "_seq" + String.valueOf(編號數_本身++)));
//						輸入值 = 對應PK的SEQ名稱 + " - " + (k-start);//bad
						輸入值 = 對應PK的SEQ名稱;
						System.err.println(輸入值);
						
						//====代替方案
					} else if (!(資料型態.indexOf("DATE") == -1)) {  //多一道檢查DATE型態
						String fake_Date = "";
						if (!(假資料類型.indexOf("結束") == -1)) {
							fake_Date = write_假資料_類型_資料("結束時間", i);
						} else if (!(假資料類型.indexOf("修改") == -1)) {
							fake_Date = fake_Date = write_假資料_類型_資料("修改時間", i);
						} else {
							fake_Date = fake_Date = write_假資料_類型_資料("發布日期", i);
						}
						輸入值 = " TO_DATE(" + fake_Date + ", 'YYYY-MM-DD HH24:MI:SS') ";
					} else if (!(假資料類型.indexOf("姓名") == -1)) {
						輸入值 = " '" + write_假資料_類型_資料("姓名", i) + "' ";
					} else { //都沒有就判定為null
						輸入值 = "''";
					}

					if ((k - start) == 0) {
						str += 輸入值;
					} else {
						str += "," + 輸入值;
					}
				}
				str += " ) ";
				str += " ; ";
				// ====給文本使用，要加;====
				// System.out.println(str);
				Excel_to_SQL.write_假資料(str);
			}

		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException se) {
					//// System.out.println(se);
				}
			}

		}
	}

	/**
	 * @param astr
	 * @throws IOException
	 */
	public static void write(String astr) throws IOException {
		SQL文字檔.write(astr + "\n");
	}

	/**
	 * @param astr
	 * @throws IOException
	 */
	public static void write_假資料(String astr) throws IOException {
		SQL文字檔_假資料.write(astr + "\n");
	}

	/**
	 * @param 類型
	 * @param index
	 * @return
	 * @throws IOException
	 */
	public static String write_假資料_類型_資料(String 類型, int index) throws IOException {
		int 第幾欄 = hashMap_fakeDB_欄位名稱.get(類型);
		return sheet_fakeDB.getCell(第幾欄, index).getContents();
	}

}
