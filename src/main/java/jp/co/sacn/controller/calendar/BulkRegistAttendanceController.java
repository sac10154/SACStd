/*
 * Copyright(C) 2017 xxxxxx Corporation, All Rights Reserved.
 * xxxxxxx Corporation CONFIDENTIAL.
 */
package jp.co.sacn.controller.calendar;

import java.util.Map;

import jp.co.sacn.controller.common.AbstractController;
import jp.co.sacn.service.calendar.BulkRegistAttendanceParams;
import jp.co.sacn.service.calendar.BulkRegistAttendanceService;
import jp.co.sacn.validator.BulkRegistAttendanceValidator;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

/**
 * 勤怠入力制御
 *
 * @author authorName
 *
 */
public class BulkRegistAttendanceController extends AbstractController {

	/** JSP */
	private static final String JSP =  "inputAtttendance.jsp";

	/** 勤怠のService */
    private BulkRegistAttendanceService service = new BulkRegistAttendanceService();

    /** 勤怠のパラメータ */
    private BulkRegistAttendanceParams params = new BulkRegistAttendanceParams();

    /**
     * 制御
     *
     * @return 遷移先のパス
     * @throws Exception
     */
    @Override
    public Navigation run() throws Exception {
    	BulkRegistAttendanceValidator v = new BulkRegistAttendanceValidator();
    	v.validate(errors, request);
    	if(!this.errors.isEmpty()){
    		for(Map.Entry<String, String> e : errors.entrySet()) {
                errors.put("message", e.getValue());
    		}
            return forward(JSP);
    	}

        BeanUtil.copy(request, params);
        service.create(params);

        requestScope("message","登録しました");
        return forward(JSP);
    }

}
