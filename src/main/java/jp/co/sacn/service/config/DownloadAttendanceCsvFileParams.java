package jp.co.sacn.service.config;

import java.io.Serializable;

import org.slim3.datastore.Attribute;

import com.google.appengine.api.datastore.Key;


public class DownloadAttendanceCsvFileParams implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    // ユーザーID
    private String userId;

    // 年月日(yyyy-mm-dd)
    private String calendarDate;

    // 年月(yyyy-mm)
    private String calendarMonth;

    /**
	 * @return key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key セットする key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return calendarDate
	 */
	public String getCalendarDate() {
		return calendarDate;
	}

	/**
	 * @param calendarDate セットする calendarDate
	 */
	public void setCalendarDate(String calendarDate) {
		this.calendarDate = calendarDate;
	}

	/**
	 * @return calendarMonth
	 */
	public String getCalendarMonth() {
		return calendarMonth;
	}

	/**
	 * @param calendarMonth セットする calendarMonth
	 */
	public void setCalendarMonth(String calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

}
