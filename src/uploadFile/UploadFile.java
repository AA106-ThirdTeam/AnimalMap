package uploadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.excel2sql.Excel_create_fakeDB;

public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		// process only if its multipart content
		if (isMultipart) {
//			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			String str = "";
			try {
				// Parse the request
				List<FileItem> multiparts = upload.parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						File file = new File(item.getName());
						String name = file.getName();						
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
						
						String path = getServletContext().getRealPath("/")+"/WEB-INF/classes/utils/excel2sql";
						System.out.println(path);
//						System.out.println(UPLOAD_DIRECTORY + File.separator + name);
						//====暐翰測試部分====
						file = new File(UPLOAD_DIRECTORY + File.separator + name);
						Excel_create_fakeDB.init(path,file);
						
						FileReader fr = new FileReader("C:/scott.sql");
						BufferedReader br = new BufferedReader(fr);
						while (br.ready()) {
							str += br.readLine() + "<br>";
//							strlist.add(br.readLine());
						}
						fr.close();							
						
						
						fr = new FileReader("C:/scott_假資料.sql");
						br = new BufferedReader(fr);
						while (br.ready()) {
							str += br.readLine() + "<br>";
//							strlist.add(br.readLine());
						}
						fr.close();			
					}
				}
				// File uploaded successfully
				request.setAttribute("message",str);
			} catch (Exception e) {
				request.setAttribute("message", "File Upload Failed due to " + e);
			}
		} else {
			request.setAttribute("message", "This Servlet only handles file upload request");
		}
		request.getRequestDispatcher("/excel2sql/result.jsp").forward(request, response);
	}
}
