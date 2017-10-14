/**
 *
 */
package jp.co.sacn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sacn.common.Constants;

/**
 * @author gotoumasahiko
 *
 */
public class DateUtils {

    private DateUtils() {};

    /**
     * 日付のnullチェック
     *
     * @param date 日付
     * @return true/false
     */
    public static boolean isNull(Date date) {
        if(date == null){
            return true;
        }
        if("".equals(date)){
            return true;
        }

        return false;
    }

    /**
     * 日付のnullチェック
     *
     * @param date 日付
     * @return true/false
     */
    public static boolean isNotNull(Date date) {
    	return !isNull(date);
    }


//    /**
//    * 日付のnullチェック
//    *
//    * @param date 日付
//    * @return true/false
//    */
//    public static Date parseDate(String str, String[] parsePatterns) {
//        if (str == null || parsePatterns == null) {
//            throw new IllegalArgumentException("Date and Patterns must not be null");
//        }
//
//    }

    /**
     * 時間を削除
     *
     * @param date 日付
     * @return 日付（時間を削除）
     * @throws ParseException
     */
    public static Date truncateTime(Date date) throws ParseException {
        if (date == null ) {
            throw new IllegalArgumentException("Date must not be null");
        }

        SimpleDateFormat fmt = new SimpleDateFormat(Constants.DATE_FORMATE_DATE + " 00:00:00");
        String str = fmt.format(date);
        return fmt.parse(str);
    }

    /**
     * システム日付を取得
     *
     * @return 日付（時間を削除）
     * @throws ParseException
     */
    public static Date getSysdate() throws ParseException {
    	Date date = new Date();
    	return truncateTime(date);
    }
}
