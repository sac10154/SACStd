package jp.co.sacn.service.login;

import java.util.Map;

import jp.co.sacn.meta.EmployeeMeta;
import jp.co.sacn.model.Employee;
import jp.co.sacn.util.EncryptUtil;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;


public class LoginService {

    public Employee login(Map<String, Object> input) {
        Employee employee = new Employee();
        BeanUtil.copy(input, employee);
        String encryptpw = EncryptUtil.encryptStr(employee.getPassword());
        EmployeeMeta e = EmployeeMeta.get();
        Employee emp = Datastore.query(e).filter(e.userId.equal(employee.getUserId()), e.password.equal(encryptpw)).asSingle();
        return emp;
    }

}
