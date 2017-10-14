package jp.co.sacn.service.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.co.sacn.common.Constants;
import jp.co.sacn.dao.AttendanceDao;
import jp.co.sacn.dao.HolidayDao;
import jp.co.sacn.model.Attendance;
import jp.co.sacn.model.Holiday;
import jp.co.sacn.util.CalendarUtils;
import jp.co.sacn.util.StringUtils;

import org.slim3.util.BeanUtil;

public class BulkRegistAttendanceService {

    /** 勤怠Dao */
    private AttendanceDao attendanceDao = new AttendanceDao();

    /** 休日Dao */
    private HolidayDao holidayDao = new HolidayDao();

    /**
     * 作成
     *
     * @param param パラメータ
     * @throws Exception
     */
    public void create(BulkRegistAttendanceParams param) throws Exception{
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        SimpleDateFormat sdDateFormat = new SimpleDateFormat(Constants.DATE_FORMATE_DATE);

        if(StringUtils.isNotEmpty(param.getCalendarMonth())){
            SimpleDateFormat sdFormat = new SimpleDateFormat(Constants.DATE_FORMATE_MONTH);
            Date calendarMonth = sdFormat.parse(param.getCalendarMonth());
            cal.setTime(calendarMonth);
        	int intYear = cal.get(Calendar.YEAR);
        	int intMonth = cal.get(Calendar.MONTH);
        	int maxDate = CalendarUtils.getActualMaximum(calendarMonth);

        	// 祝日リスト取得
        	List<Holiday> holidayList = holidayDao.getList(cal, Calendar.MONTH);

        	for(int i=1 ; i <= maxDate; i++){

        		//休日は除く
                cal2.set(intYear, intMonth, i, 0, 0, 0);
                if ( CalendarUtils.isHoliday(cal2, holidayList) ) {
                	continue;
                }
                param.setCalendarDate(sdDateFormat.format(cal2.getTime()));

                //TODO:登録済みの場合、判定ロジックを入れる
                Attendance attendance = new Attendance();
                BeanUtil.copy(param, attendance);
                attendanceDao.create(attendance);
        	}
        } else if(StringUtils.isNotEmpty(param.getCalendarDate())){
        	Attendance attendance = new Attendance();
        	BeanUtil.copy(param, attendance);
        	attendanceDao.create(attendance);
        }

    }

}
