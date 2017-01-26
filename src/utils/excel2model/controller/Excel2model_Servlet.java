package utils.excel2model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.read.biff.BiffException;
import utils.excel2model.Excel2Model_DAO;
import utils.excel2model.Excel2Model_Interface;
import utils.excel2model.Excel2Model_JDBCDAO;
import utils.excel2model.Excel2Model_VO;


@WebServlet(urlPatterns = { "/excel2model_Servlet" })
public class Excel2model_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		try {
			
			//VO
			Excel2Model_VO.init();
		
			//Interface
			Excel2Model_Interface.init();
			
			//接下一個流程
			Excel2Model_DAO.init();
			
			//JDBC
			Excel2Model_JDBCDAO.init();
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
