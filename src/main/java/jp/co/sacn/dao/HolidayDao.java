package jp.co.sacn.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.co.sacn.meta.HolidayMeta;
import jp.co.sacn.model.Holiday;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

public class HolidayDao extends DaoBase<Holiday>{

	protected static HolidayMeta meta = new HolidayMeta();

    public List<Holiday> getList(Calendar cal, int type) {
    	Date d1 = new Date();
    	Date d2 = new Date();
    	Calendar cal2 = Calendar.getInstance();

    	if(type == Calendar.YEAR){
    		int intYear = cal.get(Calendar.YEAR);
    		cal2.set(intYear, 0, 1, 0, 0, 0);
    		d1 = cal2.getTime();

    		cal2.set(intYear, 11, 31, 0, 0, 0);
    		d2 = cal2.getTime();
    	} else if (type == Calendar.MONTH){
    		int intYear = cal.get(Calendar.YEAR);
    		int intMonth = cal.get(Calendar.MONTH);
    		cal2.set(intYear, intMonth, 1, 0, 0, 0);
    		d1 = cal2.getTime();

    		cal2.set(intYear, intMonth, 31, 0, 0, 0);
    		d2 = cal2.getTime();
    	} else {
    		int intYear = cal.get(Calendar.YEAR);
    		int intMonth = cal.get(Calendar.MONTH);
    		int intDay = cal.get(Calendar.DATE);
    		cal2.set(intYear, intMonth, intDay, 0, 0, 0);
    		d1 = cal2.getTime();

    		cal2.set(intYear, intMonth, intDay, 0, 0, 0);
    		d2 = cal2.getTime();
    	}

    	return Datastore.query(meta).filter(meta.date.greaterThanOrEqual(d1), meta.date.lessThanOrEqual(d2)).asList();
    }
}
