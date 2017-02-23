package hibernate.util.CompositeQuery;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import heibernate_com.mem.model.MemVO;
@WebServlet(urlPatterns = { "/A_Test.do" })
public class A_Test extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		Map<String, String[]> map = new TreeMap<String, String[]>();
		map.put("mem_Id", new String[] { "1000000" });	
		
		List<MemVO> list = HibernateUtil_CompositeQuery_Mem.getAllC(map);
		for (MemVO aEmp : list) {
			System.out.print(aEmp.getMem_Id() + ",");
			System.out.print(aEmp.getMem_account() + ",");
			System.out.print(aEmp.getMem_email() + ",");
			System.out.print(aEmp.getMem_Psw() + ",");
			System.out.print(aEmp.getMem_nick_name() + ",");
			System.out.print(aEmp.getMem_name() + ",");
			System.out.print(aEmp.getMem_gender() + ",");
			System.out.print(aEmp.getMem_Tw_Id() + ",");
			System.out.print(aEmp.getMem_birth_date() + ",");
			System.out.print(aEmp.getMem_phone() + ",");
			System.out.print(aEmp.getMem_Intro() + ",");
			System.out.print(aEmp.getMem_profile() + ",");
			System.out.print(aEmp.getMem_black_list() + ",");
			System.out.print(aEmp.getMem_permission() + ",");
			System.out.print(aEmp.getMem_setting() + ",");
			System.out.print(aEmp.getMem_balance() + ",");
			System.out.println();
		}
	}

}
