package utils.excel2sql.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import utils.excel2sql.Common;
import utils.excel2sql.Excel_create_fakeDB;
import utils.excel2sql.Excel_put_in_hashMap;
import utils.excel2sql.Excel_to_SQL;

/**
 * @startuml
 * 	start
 * 		:檔案處理;
 * 		:重導到前端;
 * 		:call Excel_create_fakeDB.init() 取得假資料;
 * 		:Excel_to_SQL.init;
 * 	end
 * @enduml
 */
@WebServlet(urlPatterns = { "/Excel2SQL_Servlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class Excel2SQL_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String saveDirectory = "/excel_uploaded"; // 上傳檔案的目地目錄;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 處理中文檔名
		res.setContentType("text/html; charset=UTF-8");
		System.out.println("ContentType=" + req.getContentType()); // 測試用

		// 第一步驟
		this.檔案處理(req, res);

		// 重導到前端
		req.getRequestDispatcher("/excel2sql/result.jsp").forward(req, res);

	}

	private void 檔案處理(HttpServletRequest req, HttpServletResponse res)
			throws IllegalStateException, IOException, ServletException {
		String realPath = getServletContext().getRealPath(saveDirectory);
		System.out.println("realPath=" + realPath); // 測試用
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists()) {
			fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄
		}

		Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		System.out.println("Total parts : " + parts.size());

		// 字串拼接
		String str = "";
		for (Part part : parts) {
			if (getFileNameFromPart(part) != null && part.getContentType() != null) {
				String name = part.getName();
				String filename = getFileNameFromPart(part);
				String ContentType = part.getContentType();
				long size = part.getSize();
				File file = new File(fsaveDirectory, filename);

				System.out.println("name: " + name);
				System.out.println("filename: " + filename);
				System.out.println("ContentType: " + ContentType);
				System.out.println("size: " + size);
				System.out.println("File: " + file);

				// 利用File物件,寫入目地目錄,上傳成功
				part.write(file.toString());

				/**主要流程**/
				try {

					// 把Excel資料塞進去
					Common.excel2sql_VO.setDB_Excel_LinkedHashMap(Excel_put_in_hashMap.init(file));
					// 生成假資料SQL
					Excel_create_fakeDB.init(file);
					// 生成drop,create sql命令
					Excel_to_SQL.init(file);
				} catch (BiffException | ClassNotFoundException | WriteException | SQLException
						| InterruptedException e) {
					e.printStackTrace();
				}

				// ========
				str += 回傳SQL命令(Common.sql_DB命令路徑);
				str += 回傳SQL命令(Common.sql_假資料DB命令路徑);
			}
		}
		try {
			// 把所有SQL命令 存到一個字串裡面 再存到request
			req.setAttribute("message", str);
		} catch (Exception e) {
			req.setAttribute("message", "檔案上傳失敗 因為: " + e);
		}
	}

	private String 回傳SQL命令(String 路徑) {
		String str = "";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(路徑);
			br = new BufferedReader(fr);
			while (br.ready()) {
				str += br.readLine() + "<br>";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str;
	}

	// 取出上傳的檔案名稱 (因為API未提供method,所以必須自行撰寫)
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		System.out.println("header=" + header); // 測試用
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		System.out.println("filename=" + filename); // 測試用
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}

}
