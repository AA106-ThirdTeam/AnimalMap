package jdbc.util.searchWithSortQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.hos.model.HosVO;

public class SearchWithSort_Hos {
//	public static void main(String[] args) throws Exception {
//		
//
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		String userid = "aa106g3";
//		String passwd = "aa106g3";
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, userid, passwd);
//		String searchInput = "java";
//		SearchWithSort_Hos swsHos = new SearchWithSort_Hos();
//		List<HosVO> list = swsHos.searchAll(con,searchInput);
//		
//		for (HosVO s : list) {
//			System.out.println(s.getHos_name());
//		}
//
//	}
	

	public List<HosVO> searchAll(Connection con,String searchInput) throws Exception{
		String regex = "\\s+";
		String[] afterSplit = searchInput.trim().toUpperCase().split(regex);
		
		// ���Ҧ������A�]���n�j�M�Ҧ������
		PreparedStatement pstmt = con.prepareStatement("select * from vet_hospital");
		ResultSetMetaData rsmd = pstmt.executeQuery().getMetaData();
		ResultSet rs = null;
		int columnCount = rsmd.getColumnCount();

		// �⮳�쪺���W�[�춰�X�̥H����QUERY
		List<String> column = new ArrayList<>();
		for (int i = 1; i <= columnCount; i++) {
			column.add(rsmd.getColumnLabel(i));
		}

		// ��Ҧ����j�M�����춰�X�z�H����QUERY
		Set<String> searchCond = new HashSet<>();
		for (int i = 0; i < afterSplit.length; i++) {
			searchCond.add(afterSplit[i]);
		}

		// ����QUERY
		List<String> allQuery = new LinkedList<>();
		for (String c : column) {
			for (String s : searchCond) {
				allQuery.add("select * from vet_hospital where upper(" + c + ") like '%" + s + "%'");
			}
		}

		// ���ͩҦ��j�M�쪺���X
		List<HosVO> hosVOList = new LinkedList<>();

		for (String a : allQuery) {

			// System.out.println(a);

			pstmt = con.prepareStatement(a);
			rs = pstmt.executeQuery();
			HosVO hosVO = null;

			while (rs.next()) {
				hosVO = new HosVO();
				
				hosVO.setHos_Id(rs.getString("Hos_Id"));
				hosVO.setHos_MemId(rs.getString("Hos_MemId"));
				hosVO.setHos_name(rs.getString("Hos_name"));
				hosVO.setHos_city(rs.getString("Hos_city"));
				hosVO.setHos_town(rs.getString("Hos_town"));
				hosVO.setHos_road(rs.getString("Hos_road"));
				hosVO.setHos_EndTime(rs.getString("Hos_EndTime"));
				hosVO.setHos_StartTime(rs.getString("Hos_StartTime"));
				hosVO.setHos_CreateTime(rs.getDate("Hos_CreateTime"));
				hosVO.setHos_Desc(rs.getString("Hos_Desc"));
				hosVO.setHos_Long(rs.getDouble("Hos_Long"));
				hosVO.setHos_Lat(rs.getDouble("Hos_Lat"));
				hosVO.setHos_visible(rs.getString("Hos_visible"));
				hosVO.setHos_Eval(rs.getInt("Hos_Eval"));
				hosVO.setHos_URL(rs.getString("Hos_URL"));
				hosVO.setHos_Tel(rs.getString("Hos_Tel"));

				hosVOList.add(hosVO);
			}

		}
		// ���F�n����C�Ӫ���X�{�����ơA�ҥH������gVO��EQUALS()�MHASHCODE()�A�~�ಣ�ͤ@�ӷs�������ƪ�LIST

		final Map<HosVO, Integer> map = new HashMap<HosVO, Integer>();

		// ���F����C�Ӫ���X�{�����ơA�ҥH�����N�X�{���ƩM����@�_��iMAP�̡A
		// �����gCOMPARATOR��COMPARE�ɤ~��̷���Ȯ��X�۹������X�{����

		for (HosVO es : hosVOList) {
			// System.out.println(es.getEname());
			int countOccurance = Collections.frequency(hosVOList, es);
			// System.out.println();
			map.put(es, countOccurance);

			// System.out.println(es.getEname() + " , " + map.get(es));
		}

		List<HosVO> list = new ArrayList<HosVO>(map.keySet());

		Collections.sort(list, new Comparator<HosVO>() {
			@Override
			public int compare(HosVO x, HosVO y) {
				return map.get(y) - map.get(x);
			}
		});
		
		return list;
		
	}
	
	
}
