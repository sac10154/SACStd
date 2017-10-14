package jp.co.sacn.common;

import java.util.ArrayList;
import java.util.List;

import jp.co.sacn.model.Holiday;


/**
 * 休日情報
 *
 */
public class HolidayInfo {

    /** 休日リスト */
    public List<Holiday> holidayList = new ArrayList<Holiday>();

	/**
	 * @return holidayList
	 */
	public List<Holiday> getHolidayList() {
		return holidayList;
	}

	/**
	 * @param holidayList セットする holidayList
	 */
	public void setHolidayList(List<Holiday> holidayList) {
		this.holidayList = holidayList;
	}
}
