package utils.excel2model;

public class Common {
	public static String 桌面路徑  = "C:/Users/Administrator/git/AnimalMap/src/" ;
	public static String DB名稱  = "\"java:comp/env/jdbc/TestDB\"" ;
	public static String 測試Excel檔案路徑  = "E:/AnimalMap合併SQL.XLS" ;
	
	//====預設JDBC需要用到的資料====
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static String userid = "scott";
	public static String passwd = "tiger";	
	
	//====假資料====
	static String [] VARCHAR2 = {"a","b","c"};
	public static String 製造假資料(String 資料類型, String 欄位長度 ){
		String str = "";
		System.out.println(資料類型);
		if (資料類型.indexOf("VARCHAR2")!=-1) {
			str = "\"";
			for (int i = 0; i < Integer.parseInt(欄位長度); i++) {
				str += VARCHAR2[(int)(Math.random()*VARCHAR2.length)];
			}
			str += "\"";
		} 
		if (資料類型.indexOf("NUMBER")!=-1) {
//			for (int i = 0; i < Integer.parseInt(欄位長度); i++) {
				str += (int)(Math.random()*10);
//			}	
		}
		if (資料類型.indexOf("BLOB")!=-1) {
//			for (int i = 0; i < Integer.parseInt(欄位長度); i++) {
				str += null;
//			}			
		}
		if (資料類型.indexOf("DATE")!=-1) {
//			for (int i = 0; i < Integer.parseInt(欄位長度); i++) {
				str += null;
//			}			
		}		
		
		return str;
	}
	
}
