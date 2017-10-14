package jp.co.sacn.service.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jp.co.sacn.common.Constants;
import jp.co.sacn.dao.AttendanceDao;
import jp.co.sacn.model.Attendance;
import jp.co.sacn.util.CalendarUtils;
import jp.co.sacn.util.StringUtils;

import org.apache.commons.lang.StringEscapeUtils;
import org.slim3.util.BeanUtil;

public class DownloadAttendanceCsvFileService {

    /** 勤怠Dao */
    private AttendanceDao attendanceDao = new AttendanceDao();

    /**
     * CSVデータ
     *
     * @param param パラメータ
     * @throws Exception
     */
    public String getCsvData(DownloadAttendanceCsvFileParams param) throws Exception{
    	StringBuilder sb = new StringBuilder();

    	Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        SimpleDateFormat sdDateFormat = new SimpleDateFormat(Constants.DATE_FORMATE_DATE);
        //
        sb.append(getCsvHeader());

        if(StringUtils.isNotEmpty(param.getCalendarMonth())){
            SimpleDateFormat sdFormat = new SimpleDateFormat(Constants.DATE_FORMATE_MONTH);
            Date calendarMonth = sdFormat.parse(param.getCalendarMonth());
            cal.setTime(calendarMonth);
        	int intYear = cal.get(Calendar.YEAR);
        	int intMonth = cal.get(Calendar.MONTH);
        	int maxDate = CalendarUtils.getActualMaximum(calendarMonth);

        	for(int i=1 ; i <= maxDate; i++){

                cal2.set(intYear, intMonth, i, 0, 0, 0);
                param.setCalendarDate(sdDateFormat.format(cal2.getTime()));
                sb.append(param.getCalendarDate()).append(",");

                Attendance attendance = new Attendance();
                BeanUtil.copy(param, attendance);
                Attendance at = attendanceDao.select(attendance.getUserId(), attendance.getCalendarDate());
                if(at != null){
                	sb.append(at.getArrivalTime()).append(",");
                	sb.append(at.getQuittingTime()).append(",");
                	sb.append(at.getAbsenceReason()).append(",");
                	sb.append(StringEscapeUtils.escapeCsv(at.getWorkingLocation())).append("\r\n");
                } else {
                	sb.append(",");
                	sb.append(",");
                	sb.append(",");
                	sb.append("\r\n");
                }
        	}
        }
        return sb.toString();
    }

    /**
     * CSVヘッダー
     *
     * @param param パラメータ
     * @throws Exception
     */
    private String getCsvHeader() throws Exception{
    	StringBuilder sb = new StringBuilder();
    	sb.append("日付").append(",");
    	sb.append("出社時間").append(",");
    	sb.append("退社時間").append(",");
    	sb.append("休暇等").append(",");
    	sb.append("行き先（常駐先欄）").append("\r\n");

    	return sb.toString();

    }
}
