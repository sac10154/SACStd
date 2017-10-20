package jp.co.sacn.dao;

import java.util.List;

import jp.co.sacn.meta.EmployeeMeta;
import jp.co.sacn.model.Employee;
import jp.co.sacn.util.EncryptUtil;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class EmployeeDao extends DaoBase<Employee>{

	protected static EmployeeMeta meta = new EmployeeMeta();

    public Employee create(Employee employee) {
    	Employee emp = select(employee.getUserId());
    	if(emp != null){
    		employee.setKey(emp.getKey());
    	}

        Transaction tx = Datastore.beginTransaction();
        employee.setPassword(EncryptUtil.encryptStr(employee.getPassword()));
        put(employee);
        tx.commit();
        return employee;
    }

    public Employee select(String userId) {
        return Datastore.query(meta).filter(meta.userId.equal(userId)).asSingle();
    }

    public List<Employee> selects(String[] userIds) {
        return Datastore.query(meta).filter(meta.userId.in(userIds)).asList();
    }
}
