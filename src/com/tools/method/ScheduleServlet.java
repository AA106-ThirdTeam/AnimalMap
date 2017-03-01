package com.tools.method;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
import com.emg_H.model.*;
import java.util.*;

public class ScheduleServlet extends HttpServlet {

	Timer timer;
	long Time;

	public void init() throws ServletException {

		TimerTask task = new TimerTask() {

			public void run() {

				java.sql.Timestamp rightNow = new Timestamp(System.currentTimeMillis());

				Emg_HService emg_HSvc = new Emg_HService();
				List<Emg_HVO> list = emg_HSvc.getAll();

				for (Emg_HVO aEmg_H : list) {
					//如果結束時間小於現在的時間，排程刪除
					if (aEmg_H.getEmg_H_end_date().before(rightNow)) {

						emg_HSvc.delete(aEmg_H.getEmg_H_Id());
					}
//					//如果結束時間大於現在時間,做相減  ,升級WebSocket? 
//					if (aEmg_H.getEmg_H_end_date().after(rightNow)) {
//
//						Time =(aEmg_H.getEmg_H_end_date().getTime())-rightNow.getTime();
//					}
//
//				}
//					System.out.println(Time);
//					SimpleDateFormat dateFormat = new SimpleDateFormat("還剩下 , kk 時 mm分");
//					String lastTime= dateFormat.format(Time);
//					System.out.println(lastTime);
				}
			}
		};

//		timer = new Timer();
//		Calendar cal = new GregorianCalendar(2017, Calendar.MARCH, 9, 0, 0, 0);
//		timer.scheduleAtFixedRate(task, cal.getTime(),  1*24*60*60*1000);
//		System.out.println("已建立排程!");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

//	public void destroy() {
//		timer.cancel();
//		System.out.println("已移除排程!");
//	}

}