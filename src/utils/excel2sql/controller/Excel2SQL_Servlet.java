package utils.excel2sql.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jxl.read.biff.BiffException;
import utils.excel2sql.model.Excel2SQL_VO;

/**
 * @startuml
 * start
 * 	:上傳檔案;
 * 	:call 製造假資料的hashmap;
 *  :call 製造動物地圖專案所有表格資料的hashmap;
 *  :建立一個LinkedHashMap(表格Exce)，照著表格順序存放列、欄的資料。;
 *  :把所有SQL命令，存到一個String裡面，再setAttribute到request裡面;
 *  :重導頁面到前端頁面，並顯示資訊;
 * end
 * @enduml
 * @author 暐翰
 *
 */
@WebServlet(urlPatterns = { "/Excel2SQL_Servlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
// 當數據量大於fileSizeThreshold值時，內容將被寫入磁碟
// 上傳過程中無論是單個文件超過maxFileSize值，或者上傳的總量大於maxRequestSize 值都會拋出IllegalStateException
// 異常
public class Excel2SQL_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String UPLOAD_DIRECTORY = "C:";
	private static String saveDirectory = "/excel_uploaded"; // 上傳檔案的目地目錄;

	private static void 上傳檔案處理(Excel2SQL_Servlet excel2sql_Servlet, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8"); // 處理中文檔名
		res.setContentType("text/html; charset=UTF-8");
		System.out.println("ContentType=" + req.getContentType()); // 測試用

		String realPath = getServletContext().getRealPath(saveDirectory);
		System.out.println("realPath=" + realPath); // 測試用
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄

		Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		System.out.println("Total parts : " + parts.size());

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

				// ====VO初始化====
				Excel2SQL_VO.init();
				
				try {
					// 建立一個LinkedHashMap(表格Exce)，照著表格順序存放列、欄的資料。
					Excel2SQL_VO.表格Excel = Excel_put_in_hashMap.init(file);
					// 第一步驟: 生成假資料命令
					Excel_create_fakeDB.init( file);
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				

				// // 第二步驟: 生成drop,create sql命令
				// Excel_to_SQL.init(path, file);
				//
				// // 第三步驟: 讀取生成的SQL命令
				// FileReader fr = new FileReader("C:/scott.sql");
				// BufferedReader br = new BufferedReader(fr);
				// while (br.ready()) {
				// str += br.readLine() + "<br>";
				// // strlist.add(br.readLine());
				// }
				// fr.close();
				//
				// fr = new FileReader("C:/scott_假資料.sql");
				// br = new BufferedReader(fr);
				// while (br.ready()) {
				// str += br.readLine() + "<br>";
				// // strlist.add(br.readLine());
				// }
				// fr.close();
				// 把所有SQL命令，存到一個String裡面，再setAttribute到request裡面
			}
		}

		req.setAttribute("message", str);

		// 重導頁面到前端頁面，並顯示資訊
		req.getRequestDispatcher("/excel2sql/result.jsp").forward(req, res);
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
