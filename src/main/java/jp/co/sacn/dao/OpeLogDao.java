package jp.co.sacn.dao;

import jp.co.sacn.meta.OpeLogMeta;
import jp.co.sacn.model.OpeLog;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class OpeLogDao extends DaoBase<OpeLog>{

	protected static OpeLogMeta meta = new OpeLogMeta();

    public OpeLog create(OpeLog opeLog) {
        Transaction tx = Datastore.beginTransaction();
        put(opeLog);
        tx.commit();
        return opeLog;
    }


}
