package utils.excel2sql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 目的得到一個HashMap裝所有的table
 * 
 * @author 暐翰
 *
 */
public class Excel_put_in_hashMap {
	/**
	 * 裡面裝有所有的DB資料
	 */
	@SuppressWarnings("rawtypes")
	private static LinkedHashMap<String, List> linkhashMap_excel_DB = new LinkedHashMap<String, List>();
	/**
	 * 存Excel的資料
	 */
	private static Workbook workbook;
	/**
	 * 保存每個table的開始位置
	 */
	@SuppressWarnings("unused")
	private static List<Integer> startList;
	/**
	 * 保存每個table的結束位置
	 */
	@SuppressWarnings("unused")
	private static List<Integer> endList;
	/**
	 * 保存每個table的結束位置
	 */
	private static List<String> 表格名稱List;
	/**
	 * 傳遞工作頁數據使用
	 */
	private static Sheet sheet;
	/**
	 * 確保不會超出資料欄範圍，造成nullpint
	 */
	private static int 最大欄的數量 = 11; 
	
	@SuppressWarnings("rawtypes")
	public static LinkedHashMap<String, String> linkhashMap_excel_DB_表格中文名字 = new LinkedHashMap<String, String>();

	static int ____以下為主要流程____;

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Administrator\\Desktop\\合併SQL_Excel.xls");
			init(file);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @startuml
	 * 	start
	 * 		:;
	 * 	end
	 * @enduml
	 * 
	 * 
	 * 
	 * 
	 * @return hashMap_excel_DB (組員table資料)
	 * @throws IOException
	 * @throws BiffException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	@SuppressWarnings("rawtypes")
	public static LinkedHashMap<String, List> init(File file) throws IOException, BiffException {
		// 讀取組員table資料
		workbook = Workbook.getWorkbook(file);

		//接著下一個流程
		repeat_call_sql_part_工作頁的遍歷();

		return linkhashMap_excel_DB;
	}

	public static void repeat_call_sql_part_工作頁的遍歷() {
		int 起始頁 = 0;
		int 結束頁 = workbook.getNumberOfSheets();
		for (int i = 起始頁; i < 結束頁; i++) {
			startList = new ArrayList<Integer>();
			endList = new ArrayList<Integer>();
			表格名稱List = new ArrayList<String>();

			// 獲取指定頁資料、列的數量
			sheet = workbook.getSheet(i);

			repeat_call_sql_part_獲取表格();
		}
	}

	/**
	 * @startuml start repeat if("表格名稱".equals(val)) then (YES)
	 *           :新創的RowList塞進(新創的TableList); :再把新創的TableList塞進(LinkedHashMap);
	 *           endif if(flag_b==true)then(YES) :把列裡面的欄資料都保存進(一個新創的RowList);
	 *           endif repeat while (每列都遍歷過) end
	 * @enduml
	 * 
	 * @param workbook
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void repeat_call_sql_part_獲取表格() {
		// flag_int、flag_b作判定是否空白使用
		int flag_int = 0;
		boolean flag_b = false;
		// 前四行不要
		int 前四行不要 = 0;

		int 列的數量 = sheet.getRows();
		ArrayList<List> 列List = null;
		for (int j = 0; j < 列的數量; j++) {
			String val = sheet.getCell(0, j).getContents();
			if ("表格名稱".equals(val)) {
				flag_b = true;
				列List = new ArrayList<List>();

				String 表格名稱 = sheet.getCell(1, j + 1).getContents();
				String 中文表格名稱 = sheet.getCell(1, j).getContents();
				表格名稱List.add(表格名稱);

				// 由上而下，把小資料往集合塞，一層一層上去
				linkhashMap_excel_DB.put(表格名稱, 列List);
				linkhashMap_excel_DB_表格中文名字.put(表格名稱, 中文表格名稱);
			}
			if (flag_b) {
				// 目的判斷第二個空白，等於Table的最底範圍。
				if ("".equals(val) || !(val.indexOf(" ") == -1)) {
					++flag_int;
					if (flag_int == 2) {
						flag_b = false;
						flag_int = 0;
						前四行不要 = 0;
					}
				}
				// 排除最後一行
				if (flag_int == 1) {
					++前四行不要;
					if (前四行不要 >= 4) {
						ArrayList<String> 欄List = new ArrayList<String>();
						列List.add(欄List);
						for (int k = 0; k < 最大欄的數量; k++) {
							String 欄資料 = sheet.getCell(k, j).getContents();
							欄List.add(欄資料);
						}
					}
				}

			}
		}

//		File file = new File("C:/Test.txt");
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(file);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// 驗證
//		Collection<List> test = linkhashMap_excel_DB.values();
//			for (List<List> list_row : test) {
//				for (List<String> list_col : list_row) {
//					for (String col_val : list_col) {
//						try {
//							fw.write(col_val + " ");
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					try {
//						fw.write("\n");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		try {
//			fw.flush();
//			fw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	static int ____以下工具方法____;

}
