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
//當數據量大於fileSizeThreshold值時，內容將被寫入磁碟
//上傳過程中無論是單個文件超過maxFileSize值，或者上傳的總量大於maxRequestSize 值都會拋出IllegalStateException 異常
public class Excel2SQL_Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String UPLOAD_DIRECTORY = "C:";
	String saveDirectory = "/excel_uploaded"; // 上傳檔案的目地目錄;

	private static void 上傳檔案處理(Excel2SQL_Servlet2 excel2sql_Servlet, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 處理中文檔名
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("ContentType=" + request.getContentType()); // 測試用

		String realPath = getServletContext().getRealPath(saveDirectory);
		System.out.println("realPath=" + realPath); // 測試用

		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists()) {
			fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄
		}

		Collection<Part> parts = request.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		System.out.println("<h2> Total parts : " + parts.size() + "</h2>");

		for (Part part : parts) {
//			if (getFileNameFromPart(part) != null && part.getContentType() != null) {
				String name = part.getName();
				String filename = getFileNameFromPart(part);
				String ContentType = part.getContentType();
				long size = part.getSize();
				File f = new File(fsaveDirectory, filename);

				System.out.println("name: " + name);
				System.out.println("filename: " + filename);
				System.out.println("ContentType: " + ContentType);
				System.out.println("size: " + size);
				System.out.println("File: " + f);

				// 利用File物件,寫入目地目錄,上傳成功
				part.write(f.toString());

				// 額外測試 InputStream 與 byte[] (幫將來model的VO預作準備)
				InputStream in = part.getInputStream();
				byte[] buf = new byte[in.available()];
				in.read(buf);
				in.close();
				System.out.println("buffer length: " + buf.length);

				// 額外測試秀圖
				System.out
						.println("<br><img src=\"" + request.getContextPath() + saveDirectory + "/" + filename + "\">");

				System.out.println();
				System.out.println("</PRE>");
//			}
		}

		String str = "";
		// ====VO初始化====
		Excel2SQL_VO.init();
		// 建立一個LinkedHashMap(表格Exce)，照著表格順序存放列、欄的資料。
		// Excel2SQL_VO.表格Excel = Excel_put_in_hashMap.init(file);
		//
		// // 第一步驟: 生成drop,create sql命令
		// Excel_create_fakeDB.init(path, file);

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
		request.setAttribute("message", str);

		// 重導頁面到前端頁面，並顯示資訊
		request.getRequestDispatcher("/excel2sql/result.jsp").forward(request, response);
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
