package jp.co.sacn.service.calendar;

import java.text.ParseException;

import jp.co.sacn.dao.AttendanceDao;
import jp.co.sacn.model.Attendance;

import org.slim3.util.BeanUtil;

public class RegistAttendanceService {

    private AttendanceDao attendanceDao = new AttendanceDao();

    public Attendance create(RegistAttendanceParams param) throws ParseException{
        Attendance attendance = new Attendance();
        BeanUtil.copy(param, attendance);
        attendanceDao.create(attendance);
        return attendance;
    }

}
