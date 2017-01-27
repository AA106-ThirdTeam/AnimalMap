package utils.excel2sql.model;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 主要概念:
 * 	一個物件，裡面有所有需要資料。
 * 需要有:
 * 	假資料Excel路徑、LinkedHashMap
 * 	DB Excel路徑、LinkedHashMap
 * 	專案本機端路徑
 *  
 * @author 暐翰
 *
 */
public class Excel2sql_VO {
	private String DB_Excel_path;
	private String DB_SQL_path;
	private String 假資料_Excel_path;
	private String 假資料_SQL_path;
	private String 專案路徑;
	private LinkedHashMap<String, List> DB_Excel_LinkedHashMap;

	public String getDB_SQL_path() {
		return DB_SQL_path;
	}
	public void setDB_SQL_path(String dB_SQL_path) {
		DB_SQL_path = dB_SQL_path;
	}
	public String get假資料_SQL_path() {
		return 假資料_SQL_path;
	}
	public void set假資料_SQL_path(String 假資料_SQL_path) {
		this.假資料_SQL_path = 假資料_SQL_path;
	}
	public LinkedHashMap<String, List> getDB_Excel_LinkedHashMap() {
		return DB_Excel_LinkedHashMap;
	}
	public void setDB_Excel_LinkedHashMap(LinkedHashMap<String, List> dB_Excel_LinkedHashMap) {
		DB_Excel_LinkedHashMap = dB_Excel_LinkedHashMap;
	}
	public String get專案路徑() {
		return 專案路徑;
	}
	public void set專案路徑(String 專案路徑) {
		this.專案路徑 = 專案路徑;
	}
	public String getDB_Excel_path() {
		return DB_Excel_path;
	}
	public void setDB_Excel_path(String dB_Excel_path) {
		DB_Excel_path = dB_Excel_path;
	}
	public String get假資料_Excel_path() {
		return 假資料_Excel_path;
	}
	public void set假資料_Excel_path(String 假資料_Excel_path) {
		this.假資料_Excel_path = 假資料_Excel_path;
	}	
}
