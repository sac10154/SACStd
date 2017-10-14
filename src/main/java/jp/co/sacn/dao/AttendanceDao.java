package jp.co.sacn.dao;

import java.util.Date;
import java.util.List;

import jp.co.sacn.meta.AttendanceMeta;
import jp.co.sacn.model.Attendance;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class AttendanceDao extends DaoBase<Attendance>{

	protected static AttendanceMeta meta = new AttendanceMeta();

    public Attendance create(Attendance attendance) {
        Attendance at = select(attendance.getUserId(),attendance.getCalendarDate());
    	if(at != null){
    		attendance.setKey(at.getKey());
    	}

        Transaction tx = Datastore.beginTransaction();
        put(attendance);
        tx.commit();
        return attendance;
    }

    public Attendance select(String userId, Date calendarDate) {
        return Datastore.query(meta).filter(meta.userId.equal(userId), meta.calendarDate.equal(calendarDate)).asSingle();
    }

    public List<Attendance> selectList(String userId, Date calendarDateFrom, Date calendarDateTo) {
        return Datastore.query(meta).filter(meta.userId.equal(userId), meta.calendarDate.greaterThanOrEqual(calendarDateFrom), meta.calendarDate.lessThanOrEqual(calendarDateTo)).asList();
    }
}
