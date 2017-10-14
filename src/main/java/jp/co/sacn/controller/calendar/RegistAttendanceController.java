/*
 * Copyright(C) 2017 xxxxxx Corporation, All Rights Reserved.
 * xxxxxxx Corporation CONFIDENTIAL.
 */
package jp.co.sacn.controller.calendar;

import java.text.SimpleDateFormat;
import java.util.Map;

import jp.co.sacn.common.Constants;
import jp.co.sacn.controller.common.AbstractController;
import jp.co.sacn.model.Attendance;
import jp.co.sacn.service.calendar.RegistAttendanceParams;
import jp.co.sacn.service.calendar.RegistAttendanceService;
import jp.co.sacn.validator.RegistAttendanceValidator;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

/**
 * 勤怠登録制御
 *
 * @author authorName
 *
 */
public class RegistAttendanceController extends AbstractController {

//	/** JSP */
//	private static final String JSP =  "index.jsp";

	/** 勤怠のService */
    private RegistAttendanceService service = new RegistAttendanceService();

    /** 勤怠のパラメータ */
    private RegistAttendanceParams param = new RegistAttendanceParams();

    /**
     * 制御
     *
     * @return 遷移先のパス
     * @throws Exception
     */
    @Override
    public Navigation run() throws Exception {
    	RegistAttendanceValidator v = new RegistAttendanceValidator();
    	v.validate(errors, request);
    	if(!this.errors.isEmpty()){
    		for(Map.Entry<String, String> e : errors.entrySet()) {
                errors.put("message", e.getValue());
    		}
            return forward(getReferer());
    	}

        BeanUtil.copy(request, param);
        Attendance at = service.create(param);

    	requestScope("userId",at.getUserId());
    	SimpleDateFormat fmtDate = new SimpleDateFormat(Constants.DATE_FORMATE_DATE);
    	SimpleDateFormat fmtMonth = new SimpleDateFormat(Constants.DATE_FORMATE_MONTH);
    	requestScope("calendarMonth",fmtMonth.format(at.getCalendarDate()));
    	requestScope("calendarDate",fmtDate.format(at.getCalendarDate()));

    	requestScope("arrivalTime",at.getArrivalTime());
    	requestScope("quittingTime",at.getQuittingTime());
    	requestScope("workingLocation",at.getWorkingLocation());
    	requestScope("absenceReason",at.getAbsenceReason());

        requestScope("message","登録しました");
        return forward(getReferer());
    }
}
