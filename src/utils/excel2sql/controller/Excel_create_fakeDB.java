package utils.excel2sql.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import utils.excel2sql.model.Excel2SQL_VO;

/**
 * @startuml
 * 	start
 * 	:讀取上傳的Excel;
 * 	:先獲取excel內所有table資料;
 * 	:取得之前建立-假資料資料庫Excel的hashmap;
 * 	:送出資料到SQL文本保存起來;
 * 	end
 * @enduml
 * 
 * @author 暐翰
 */
public class Excel_create_fakeDB {
	// ====偷懶用====
	private static FileWriter SQL文字檔_假資料;
	private static Workbook workbook_fakeDB;

	// ====亂寫部分====
	static HashMap<String, Integer> hashMap_fakeDB_欄位名稱 = new HashMap<String, Integer>();// bad
	static HashMap<String, Integer> hashMap_fakeDB_欄位名稱_第二頁 = new HashMap<String, Integer>();// bad

	// ====變數宣告====
	static HashMap<String, String> hashMap_fakeDB_SEQ = new HashMap<String, String>();
	static String 檢查有沒有對應欄位名稱_返回字串 = "";
	static List list_倒著資料INSERT用 = new ArrayList();
	static int 決定要生成幾筆資料 = 10;

	static int ____以下為主要流程____;

	public static void init(File file) throws IOException, BiffException {
		// ====變數的宣告====
		// 假資料Excel
		SQL文字檔_假資料 = new FileWriter(Excel2SQL_VO.SQL_for_假資料);
		String 假資料Excel的路徑 = "C:\\Users\\Administrator\\git\\AnimalMap\\SQL假資料.xls";
		File 假資料Excel的檔案 = new File(假資料Excel的路徑);
		workbook_fakeDB = Workbook.getWorkbook(假資料Excel的檔案);

		保存假資料欄位名稱_後面拿資料使用();

		// 進入轉成insert sql命令步驟
		sql_insert();

		// 送出資料到SQL文本保存起來
		SQL文字檔_假資料.flush();
		SQL文字檔_假資料.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sql_insert() throws IOException {
		for (int i = 0; i < 決定要生成幾筆資料; i++) {
			for (String 表格名稱 : Excel2SQL_VO.表格Excel.keySet()) {
				String str = "";
				str += "INSERT INTO " + 表格名稱 + " ( ";
				List<List> list_列 = Excel2SQL_VO.表格Excel.get(表格名稱);

				for (int k = 0; k < list_列.size(); k++) {
					ArrayList<String> list_row = (ArrayList) list_列.get(k);
					String 英文欄位名稱 = (String) list_row.get(1);
					if (k == 0) {
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
					String 假資料類型 = (String) list_col.get(0);
					String 英文欄位名稱 = (String) list_col.get(1);
					String 中文欄位名稱 = (String) list_col.get(2);
					String 資料型態 = (String) list_col.get(3);
					String 欄位長度 = (String) list_col.get(4);
					String 限制條件 = (String) list_col.get(5);
					String 對應表格 = (String) list_col.get(6);
					String 對應欄位 = (String) list_col.get(7);
					String 註解 = "'" + 中文欄位名稱 + " | PS: " + (String) list_col.get(8) + "'";

					String 輸入值 = "";

					// ==============================================
					// PK FK
					if (!(限制條件.indexOf("FK") == -1) && !(限制條件.indexOf("PK") == -1)) {
						// .println("FK :" + 表格名稱 + " " + 英文欄位名稱 +
						// " " +
						// 中文欄位名稱);
						// .println("FK-對應表格: " + 對應表格 + " " +
						// 對應欄位);
						// 對應seq
						// String 對應PK的SEQ名稱 = (String)
						// hashMap_fakeDB_SEQ.get((表格名稱
						// + "_seq" + String.valueOf(編號數_本身++)));
						// .println("FK-對應表格: " + 表格名稱 + "_seq" +
						// (編號數_對應++) + " - " + 對應PK的SEQ名稱);

						// ====代替方案
						輸入值 = 對應表格 + "_seq" + 編號數_對應 + ".CURRVAL ";
					} else if (!(限制條件.indexOf("PK") == -1)) {
						輸入值 = 表格名稱 + "_seq" + 編號數_本身++ + ".nextval ";
					} else if (!(限制條件.indexOf("FK") == -1)) {
						// .println();
						// String 對應PK的SEQ名稱 = (String)
						// hashMap_fakeDB_SEQ.get((表格名稱
						// + "_seq" + String.valueOf(編號數_本身++)));
						// 輸入值 = 對應PK的SEQ名稱 + " - " + (k-start);//bad
						// 輸入值 = 對應PK的SEQ名稱;
						// .println(輸入值);

						// ====代替方案
						輸入值 = 對應表格 + "_seq" + 編號數_對應 + ".CURRVAL ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "結束時間", i + 1)) {
						String fake_Date = "";
						fake_Date = write_假資料_類型_資料("結束時間", i + 1);
						輸入值 = " TO_DATE(" + fake_Date + ", 'YYYY-MM-DD HH24:MI:SS') ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "修改時間", i + 1)) {
						String fake_Date = "";
						fake_Date = write_假資料_類型_資料("修改時間", i + 1);
						輸入值 = " TO_DATE(" + fake_Date + ", 'YYYY-MM-DD HH24:MI:SS') ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "出生日期", i + 1)) {
						String fake_Date = "";
						fake_Date = write_假資料_類型_資料("出生日期", i + 1);
						輸入值 = " TO_DATE(" + fake_Date + ", 'YYYY-MM-DD HH24:MI:SS') ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "發布日期", i + 1)) {
						String fake_Date = "";
						fake_Date = write_假資料_類型_資料("發布日期", i + 1);
						輸入值 = " TO_DATE(" + fake_Date + ", 'YYYY-MM-DD HH24:MI:SS') ";
					} else if (!(假資料類型.indexOf("姓名") == -1)) {
						輸入值 = " '" + write_假資料_類型_資料("姓名", i + 1) + "' ";
					} else if (!(假資料類型.indexOf("信箱") == -1)) {
						輸入值 = " '" + write_假資料_類型_資料("信箱", i + 1) + "' ";
					} else if (!(假資料類型.indexOf("密碼") == -1)) {
						輸入值 = " '" + write_假資料_類型_資料("密碼", i + 1) + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "暱稱", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "性別", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "身分證", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "手機", i + 1)) {
						輸入值 = 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "簡介", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "黑名單", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "會員權限", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "金錢", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "標題", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "內容", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "贊助送養動物物資", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "動物種類", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "照片檔名", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "商品庫存量", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else if (boolean_檢查有沒有對應欄位名稱(假資料類型, "員工權限", i + 1)) {
						輸入值 = " '" + 檢查有沒有對應欄位名稱_返回字串 + "' ";
					} else { // 都沒有就判定為null
						輸入值 = "''";
					}

					if ((k) == 0) {
						str += 輸入值;
					} else {
						str += "," + 輸入值;
					}
				}
				str += " ) ";
				str += " ; ";
				// .println(str);
				list_倒著資料INSERT用.add(str);
			}
		}

		for (int j = list_倒著資料INSERT用.size() - 1; j >= 0; j--) {
			String str = (String) list_倒著資料INSERT用.get(j);
			SQL文字檔_假資料.write(str + "\n");
		}
		SQL文字檔_假資料.write("commit;" + "\n");
	}

	static int ____以下工具方法____;

	public static void write_假資料(String astr) throws IOException {
		SQL文字檔_假資料.write(astr + "\n");
	}

	public static String write_假資料_類型_資料(String 類型, int index) throws IOException {
		try {
			int 第幾欄 = hashMap_fakeDB_欄位名稱.get(類型);
			return workbook_fakeDB.getSheet(0).getCell(第幾欄, index).getContents();
		} catch (java.lang.NullPointerException e) {
			int 第幾欄 = hashMap_fakeDB_欄位名稱_第二頁.get(類型);
			return workbook_fakeDB.getSheet(1).getCell(第幾欄, index).getContents();
		}
	}

	public static boolean boolean_檢查有沒有對應欄位名稱(String 假資料類型, String 類型, int index) throws IOException {
		檢查有沒有對應欄位名稱_返回字串 = write_假資料_類型_資料(類型, index);
		return (!(假資料類型.indexOf(類型) == -1));
	}

	public static void 保存假資料欄位名稱_後面拿資料使用() {
		// 後面取第幾欄使用
		for (int i = 0; i < workbook_fakeDB.getSheet(0).getColumns(); i++) {
			String 欄位名稱 = workbook_fakeDB.getSheet(0).getCell(i, 0).getContents();
			hashMap_fakeDB_欄位名稱.put(欄位名稱.trim(), i);
		}
		for (int i = 0; i < workbook_fakeDB.getSheet(1).getColumns(); i++) {
			String 欄位名稱 = workbook_fakeDB.getSheet(1).getCell(i, 0).getContents();
			hashMap_fakeDB_欄位名稱_第二頁.put(欄位名稱.trim(), i);
		}
	}
}