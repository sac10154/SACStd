/**
 *
 */
package jp.co.sacn.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.co.sacn.model.Holiday;

/**
 * @author gotoumasahiko
 *
 */
public class CalendarUtils {

    private CalendarUtils() {};

    /**
     * 月末日取得
     *
     * @param calendarMonth 年月
     * @return int 月末日
     */
    public static int getActualMaximum(Date calendarMonth) {
    	Calendar cal = Calendar.getInstance();
        //年月をセットする
        cal.setTime(calendarMonth);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 休日判定
     *
     * @param cal カレンダー日付
     * @param holidayList 祝日リスト
     * @return boolean true/false
     */
    public static boolean isHoliday(Calendar cal, List<Holiday> holidayList) {
        // 定休日（※土日固定）
        int week = cal.get(Calendar.DAY_OF_WEEK);
        if ( week == Calendar.SUNDAY || week == Calendar.SATURDAY ) {
        	return true;
        }

        // 祝日
        Date calDate = cal.getTime();
        if(holidayList != null){
        	for(Holiday holiday : holidayList){
        		if(calDate.compareTo(holiday.getDate()) == 0){
        			return true;
        		}
        	}
        }

        return false;
    }
}
