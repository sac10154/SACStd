/*
 * Copyright(C) 2017 xxxxxx Corporation, All Rights Reserved.
 * xxxxxxx Corporation CONFIDENTIAL.
 */
package jp.co.sacn.controller.calendar;

import jp.co.sacn.controller.common.AbstractController;

import org.slim3.controller.Navigation;

/**
 * 勤怠入力制御
 *
 * @author authorName
 *
 */
public class InputAttendanceController extends AbstractController {

	/** JSP */
	private static final String JSP =  "inputAtttendance.jsp";

    /**
     * 制御
     *
     * @return 遷移先のパス
     * @throws Exception
     */
    @Override
    public Navigation run() throws Exception {
    	return forward(JSP);

    }
}
