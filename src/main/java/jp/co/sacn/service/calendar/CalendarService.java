package jp.co.sacn.service.calendar;

import java.util.Date;

import jp.co.sacn.dao.AttendanceDao;
import jp.co.sacn.model.Attendance;

public class CalendarService {

    private AttendanceDao attendanceDao = new AttendanceDao();

//    private HolidayDao holidayDao = new HolidayDao();

//    public Attendance create(Map<String, Object> input) {
//    	Attendance attendance = new Attendance();
//        BeanUtil.copy(input, attendance);
//        return  create(attendance);
//    }
//
//    /**
//     * 作成
//     *
//     * @param param パラメータ
//     * @throws Exception
//     */
//    public Attendance create(Calendar param) {
//        Attendance at = attendanceDao.select(attendance.getUserId(),attendance.getCalendarDate());
//    	if(at != null){
//    		attendance.setKey(at.getKey());
//    	}
//
//        Transaction tx = Datastore.beginTransaction();
//        attendanceDao.put(attendance);
//        tx.commit();
//        return attendance;
//    }

    public Attendance get(String userId, Date calendarDate) {
        return attendanceDao.select(userId, calendarDate);
    }

//    public List<Holiday> getHolidayList(Calendar cal, int type) {
//        return holidayDao.getList(cal, type);
//    }

}
