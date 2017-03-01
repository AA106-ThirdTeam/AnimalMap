package com.strayani.model;

/*
 Hibernate is providing a factory.getCurrentSession() method for retrieving the current session. A
 new session is opened for the first time of calling this method, and closed when the transaction is
 finished, no matter commit or rollback. But what does it mean by the ��current session��? We need to
 tell Hibernate that it should be the session bound with the current thread.

 <hibernate-configuration>
 <session-factory>
 ...
 <property name="current_session_context_class">thread</property>
 ...
 </session-factory>
 </hibernate-configuration>

 */

import org.hibernate.*;
import hibernate.util.HibernateUtil;
import java.util.*;
import com.strayani.model.StrayaniVO


;

public class StrayaniHibernateDAO implements StrayaniDAO_interface {

	private static final String GET_ALL_STMT = "from StrayaniVO order by stray_Ani_Id";

	@Override
	public void insert(StrayaniVO strayaniVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();//(1)交易三部曲
			
			session.saveOrUpdate(strayaniVO);
			
			session.getTransaction().commit();//(2)
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();//(3)
			throw ex;
		}
	}

	@Override
	public void update(StrayaniVO strayaniVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
/****/			session.saveOrUpdate(strayaniVO);
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String stray_Ani_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
/****/  	StrayaniVO strayaniVO = (StrayaniVO) session.get(StrayaniVO.class, stray_Ani_Id);
			session.delete(strayaniVO);
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public StrayaniVO findByPrimaryKey(String stray_Ani_Id) {
		StrayaniVO strayaniVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
/****/  	strayaniVO = (StrayaniVO) session.get(StrayaniVO.class, stray_Ani_Id);
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return strayaniVO;
	}

	@Override
	public List<StrayaniVO> getAll() {
		List<StrayaniVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
/****/		Query query = session.createQuery(GET_ALL_STMT);	
			list = query.list();
		
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

//	@Override
//	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {		
//		Set<EmpVO>	set = findByPrimaryKey(deptno).getEmps();
//		return set;
//	}

	public static void main(String[] args) {

		StrayaniHibernateDAO dao = new StrayaniHibernateDAO();

		//● 新增-1(一方dept2.hbm.xml必須有cascade="save-update" 或cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可用在訂單主檔與明細檔一次新增成功)
//		DeptVO deptVO = new DeptVO(); // 部門POJO
//		Set<EmpVO> set = new HashSet<EmpVO>();// 準備置入員工數人,以便cascade="save-update"的測試
//
//		EmpVO empXX = new EmpVO();   // 員工POJO1
//		empXX.setEname("吳15");
//		empXX.setJob("MANAGER15");
//		empXX.setHiredate(java.sql.Date.valueOf("2001-01-15"));
//		empXX.setSal(new Double(15000));
//		empXX.setComm(new Double(150));
//		empXX.setDeptVO(deptVO);
//
//		EmpVO empYY = new EmpVO();   // 員工POJO2
//		empYY.setEname("吳16");
//		empYY.setJob("MANAGER16");
//		empYY.setHiredate(java.sql.Date.valueOf("2001-01-16"));
//		empYY.setSal(new Double(16000));
//		empYY.setComm(new Double(160));
//		empYY.setDeptVO(deptVO);
//
//		set.add(empXX);
//		set.add(empYY);
//
//		deptVO.setDname("製造部");
//		deptVO.setLoc("中國江西");
//		deptVO.setEmps(set);
//		dao.insert(deptVO);



		//● 修改-1(一方dept2.hbm.xml必須有cascade="save-update" 或 cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可視情況使用之)
//		DeptVO deptVO = new DeptVO(); // 部門POJO
//		Set<EmpVO> set = new HashSet<EmpVO>(); // 準備置入員工數人,以便cascade="save-update"的測試
//
//		EmpVO empXX = new EmpVO(); // 員工POJO1
//		empXX.setEmpno(7015); // 【如果增加 empXX.setEmpno(7015); 則變成update】
//		empXX.setEname("吳永15");
//		empXX.setJob("MANAGER15");
//		empXX.setHiredate(java.sql.Date.valueOf("2001-01-15"));
//		empXX.setSal(new Double(15555));
//		empXX.setComm(new Double(155));
//		empXX.setDeptVO(deptVO);
//
//		EmpVO empYY = new EmpVO(); // 員工POJO2
//		empYY.setEmpno(7016); // 【如果增加 empXX.setEmpno(7016); 則變成update】
//		empYY.setEname("吳永16");
//		empYY.setJob("MANAGER16");
//		empYY.setHiredate(java.sql.Date.valueOf("2001-01-16"));
//		empYY.setSal(new Double(16666));
//		empYY.setComm(new Double(166));
//		empYY.setDeptVO(deptVO);
//
//		set.add(empXX);
//		set.add(empYY);
//
//		deptVO.setDeptno(50); // 【如果增加deptVO.setDeptno(50); 則變成update】
//		deptVO.setDname("製造部1");
//		deptVO.setLoc("中國江西1");
//		deptVO.setEmps(set);
//		dao.update(deptVO);



		//● 修改-2(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		DeptVO deptVO2 = new DeptVO(); // 部門POJO
//		deptVO2.setDeptno(50); // 【如果增加deptVO.setDeptno(50); 則變成update】
//		deptVO2.setDname("製造部2");
//		deptVO2.setLoc("中國江西2");
//		dao.update(deptVO2);



		//●刪除 (超級強大!小心使用!)(一方dept2.hbm.xml必須有cascade="delete" 或 cascade="all"的設定, 再加上inverse="true"設定)
//		dao.delete(50);



		//● 新增-2(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		DeptVO deptVO = new DeptVO(); // 部門POJO
//		deptVO.setDname("製造部s");
//		deptVO.setLoc("中國江西s");
//		dao.insert(deptVO);



		//● 查詢-findByPrimaryKey (優秀!) (一方dept2.hbm.xml必須設為lazy="false")
//		DeptVO deptVO3 = dao.findByPrimaryKey(30);
//		System.out.print(deptVO3.getDeptno() + ",");
//		System.out.print(deptVO3.getDname() + ",");
//		System.out.print(deptVO3.getLoc());
//		System.out.println("\n-----------------");
//		Set<EmpVO> set3 = deptVO3.getEmps();
//		for (EmpVO aEmp : set3) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//			System.out.print(aEmp.getDeptVO().getDname() + ",");
//			System.out.print(aEmp.getDeptVO().getLoc());
//			System.out.println();
//		}



		//● 查詢-getAll-1 (一方dept2.hbm.xml不用設為lazy="false",因為沒用到多方的物件)
//		List<DeptVO> list1 = dao.getAll();
//		for (DeptVO aDept : list1) {
//			System.out.print(aDept.getDeptno() + ",");
//			System.out.print(aDept.getDname() + ",");
//			System.out.print(aDept.getLoc());
//			System.out.println();
//		}



		//● 查詢-getAll-2 (優秀!!!) (一方dept2.hbm.xml必須設為lazy="false")
		List<StrayaniVO> list2 = dao.getAll();
		for (StrayaniVO aStrayani : list2) {
			System.out.print(aStrayani.getStray_Ani_Id() + ",");
			System.out.print(aStrayani.getMem_Id() + ",");
			System.out.print(aStrayani.getStray_Ani_name() + ",");
			System.out.print(aStrayani.getStray_Ani_type() + ",");
			System.out.print(aStrayani.getStray_Ani_gender() + ",");
			System.out.print(aStrayani.getStray_Ani_heal() + ",");
			System.out.print(aStrayani.getStray_Ani_Vac() + ",");
			System.out.print(aStrayani.getStray_Ani_color() + ",");
			System.out.print(aStrayani.getStray_Ani_body() + ",");
			System.out.print(aStrayani.getStray_Ani_age() + ",");
			System.out.print(aStrayani.getStray_Ani_Neu() + ",");
			System.out.print(aStrayani.getStray_Ani_chip() + ",");
			System.out.print(aStrayani.getStray_Ani_date() + ",");
			System.out.print(aStrayani.getStray_Ani_status() + ",");
			System.out.print(aStrayani.getStray_Ani_CreDate() + ",");
			System.out.print(aStrayani.getStray_Ani_FinLat() + ",");
			System.out.print(aStrayani.getStray_Ani_FinLon() + ",");
			System.out.print(aStrayani.getStray_Ani_city() + ",");
			System.out.print(aStrayani.getStray_Ani_town() + ",");
			System.out.print(aStrayani.getStray_Ani_road() + ",");
			System.out.print(aStrayani.getStray_Ani_like() + ",");
			System.out.println("\n-----------------");
//			Set<EmpVO> set2 = aDept.getEmps();
//			for (EmpVO aEmp : set2) {
//				System.out.print(aEmp.getEmpno() + ",");
//				System.out.print(aEmp.getEname() + ",");
//				System.out.print(aEmp.getJob() + ",");
//				System.out.print(aEmp.getHiredate() + ",");
//				System.out.print(aEmp.getSal() + ",");
//				System.out.print(aEmp.getComm() + ",");
//				System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//				System.out.print(aEmp.getDeptVO().getDname() + ",");
//				System.out.print(aEmp.getDeptVO().getLoc());
//				System.out.println();
//			}
			System.out.println();
		}

	}
}
