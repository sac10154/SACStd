package jp.co.sacn.service;

import java.util.List;
import java.util.Map;

import jp.co.sacn.meta.EmployeeMeta;
import jp.co.sacn.model.Employee;
import jp.co.sacn.util.EncryptUtil;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

@Deprecated
public class EmployeeService {

    private EmployeeMeta em = new EmployeeMeta();

    public Employee create(Map<String, Object> input) {
        Employee employee = new Employee();
        BeanUtil.copy(input, employee);
        Transaction tx = Datastore.beginTransaction();
        employee.setPassword(EncryptUtil.encryptStr(employee.getPassword()));
        Datastore.put(employee);
        tx.commit();
        return employee;
    }

    public Employee login(Map<String, Object> input) {
        Employee employee = new Employee();
        BeanUtil.copy(input, employee);
        String encryptpw = EncryptUtil.encryptStr(employee.getPassword());
        EmployeeMeta e = EmployeeMeta.get();
        Employee emp = Datastore.query(e).filter(e.userId.equal(employee.getUserId()), e.password.equal(encryptpw)).asSingle();
        return emp;
    }

    public List<Employee> getEmployeeList() {
        return Datastore.query(em).sort(em.createdDate.desc).asList();
    }

}
