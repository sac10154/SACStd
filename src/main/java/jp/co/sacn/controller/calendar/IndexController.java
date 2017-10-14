/*
 * Copyright(C) 2017 xxxxxx Corporation, All Rights Reserved.
 * xxxxxxx Corporation CONFIDENTIAL.
 */
package jp.co.sacn.controller.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import jp.co.sacn.common.Constants;
import jp.co.sacn.model.Attendance;
import jp.co.sacn.service.calendar.CalendarService;
import jp.co.sacn.util.DateUtils;
import jp.co.sacn.util.StringUtils;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * index制御
 *
 * @author authorName
 *
 */
public class IndexController extends Controller {

	private static final Logger LOG = Logger.getLogger(IndexController.class.getName());

	/** JSP */
	private static final String JSP =  "index.jsp";

	/** 勤怠のService */
    private CalendarService service = new CalendarService();

    /**
     * 制御
     *
     * @return 遷移先のパス
     * @throws Exception
     */
    @Override
    public Navigation run() throws Exception {
    	LOG.fine("Start");
    	Date calendarDate = DateUtils.getSysdate();
    	String calendarDateStr = param("calendarDate");
    	if(StringUtils.isNotEmpty(calendarDateStr)){
            SimpleDateFormat sdFormat = new SimpleDateFormat(Constants.DATE_FORMATE_DATE);
            calendarDate = sdFormat.parse(calendarDateStr);
    	}
    	HttpSession session = request.getSession(false);
    	String userId = (String) session.getAttribute("userId");

        SimpleDateFormat fmtDate = new SimpleDateFormat(Constants.DATE_FORMATE_DATE);
    	requestScope("calendarDate",fmtDate.format(calendarDate));

    	SimpleDateFormat fmtMonth = new SimpleDateFormat(Constants.DATE_FORMATE_MONTH);
    	requestScope("calendarMonth",fmtMonth.format(calendarDate));

    	Attendance at = service.get(userId,calendarDate);
    	if(at != null){
        	requestScope("userId",at.getUserId());
        	requestScope("calendarMonth",fmtMonth.format(at.getCalendarDate()));
        	requestScope("calendarDate",fmtDate.format(at.getCalendarDate()));
        	requestScope("arrivalTime",at.getArrivalTime());
        	requestScope("quittingTime",at.getQuittingTime());
        	requestScope("workingLocation",at.getWorkingLocation());
        	requestScope("absenceReason",at.getAbsenceReason());
    	}
    	LOG.fine("End");
    	return forward(JSP);
    }
}
