/*
 * Copyright(C) 2017 xxxxxx Corporation, All Rights Reserved.
 * xxxxxxx Corporation CONFIDENTIAL.
 */
package jp.co.sacn.controller.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sacn.common.Constants;
import jp.co.sacn.util.DateUtils;
import jp.co.sacn.util.StringUtils;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * 年間カレンダー制御
 *
 * @author authorName
 *
 */
public class AnnualCalendarController extends Controller {

	/** JSP **/
	private static final String JSP =  "annualCalendar.jsp";

	/**
     * 制御
     *
     * @return 遷移先のパス
     * @throws Exception
     */
    @Override
    public Navigation run() throws Exception {
    	String calendarMonth = param("calendarMonth");
    	if(StringUtils.isEmpty(calendarMonth)){
    		Date calendarDate = DateUtils.getSysdate();
        	SimpleDateFormat sdFormat = new SimpleDateFormat(Constants.DATE_FORMATE_MONTH);
        	calendarMonth = sdFormat.format(calendarDate);
    	}
    	requestScope("calendarMonth",calendarMonth);
    	return forward(JSP);
    }
}
