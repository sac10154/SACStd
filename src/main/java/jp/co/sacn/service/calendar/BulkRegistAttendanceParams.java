package jp.co.sacn.service.calendar;

import java.io.Serializable;

import org.slim3.datastore.Attribute;

import com.google.appengine.api.datastore.Key;


public class BulkRegistAttendanceParams implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    // ユーザーID
    private String userId;

    // 年月日(yyyy-mm-dd)
    private String calendarDate;

    // 年月(yyyy-mm)
    private String calendarMonth;

    // 出社時間(hhmi)
    private String arrivalTime;

    // 退社時間(hhmi)
    private String quittingTime;

    // 休暇理由
    private String absenceReason;

    // 行先常駐先
    private String workingLocation;

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
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
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

	/**
	 * @param arrivalTime セットする arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return quittingTime
	 */
	public String getQuittingTime() {
		return quittingTime;
	}

	/**
	 * @param quittingTime セットする quittingTime
	 */
	public void setQuittingTime(String quittingTime) {
		this.quittingTime = quittingTime;
	}

	/**
	 * @return absenceReason
	 */
	public String getAbsenceReason() {
		return absenceReason;
	}

	/**
	 * @param absenceReason セットする absenceReason
	 */
	public void setAbsenceReason(String absenceReason) {
		this.absenceReason = absenceReason;
	}

	/**
	 * @return workingLocation
	 */
	public String getWorkingLocation() {
		return workingLocation;
	}

	/**
	 * @param workingLocation セットする workingLocation
	 */
	public void setWorkingLocation(String workingLocation) {
		this.workingLocation = workingLocation;
	}


}
