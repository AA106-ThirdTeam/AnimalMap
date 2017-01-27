package utils.excel2sql;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.excel2sql.model.Excel2sql_VO;

/**
 * @startuml
 * 	:contextInit初始化運行;
 * 	:建立一個Excel2sql_VO物件 把資料塞進去;
 * @enduml
 * @author 暐翰
 */
@WebListener()
public class Common implements ServletContextListener {
	public static Excel2sql_VO excel2sql_VO = new Excel2sql_VO();
	public static String excel_DB資料路徑;
	public static String sql_DB命令路徑;
	public static String excel_假資料路徑;
	public static String sql_假資料DB命令路徑;

	public void contextInitialized(ServletContextEvent event) {
		// 取得context物件
		ServletContext context = event.getServletContext();
		String project_path = context.getRealPath("");
		System.out.println("project_path = " + project_path);

		String Input_path = context.getRealPath("\\Input");
		System.out.println("Input_path = " + Input_path);
		String Output_path = context.getRealPath("\\Output");
		System.out.println("Output_path = " + Output_path);
		File fsaveDirectory = new File(Output_path);
		if (!fsaveDirectory.exists()) {
			fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄
		} 

		// 路徑紀錄
		excel_DB資料路徑 = Input_path + "";//測試使用而已
		sql_DB命令路徑 = Output_path + "\\scott.sql";
		excel_假資料路徑 = Input_path + "\\SQL假資料.xls";
		System.out.println(excel_假資料路徑);
		sql_假資料DB命令路徑 = Output_path + "\\scott_假資料.sql";

		// 建立一個Excel2sql_VO物件，把資料塞進去
		excel2sql_VO.set專案路徑(context.getContextPath());
		excel2sql_VO.setDB_Excel_path(excel_DB資料路徑);
		excel2sql_VO.setDB_SQL_path(sql_DB命令路徑);
		excel2sql_VO.set假資料_Excel_path(excel_假資料路徑);
		excel2sql_VO.set假資料_SQL_path(sql_假資料DB命令路徑);
	}

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener通知: contextDestroyed....");
	}

}
