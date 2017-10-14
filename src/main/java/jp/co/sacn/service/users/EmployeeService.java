package jp.co.sacn.service.users;

import java.util.List;

import jp.co.sacn.meta.EmployeeMeta;
import jp.co.sacn.model.Employee;

import org.slim3.datastore.Datastore;

public class EmployeeService {

    private EmployeeMeta em = new EmployeeMeta();

    public List<Employee> getEmployeeList() {
        return Datastore.query(em).sort(em.createdDate.desc).asList();
    }

    public int getCount() {
        return Datastore.query(em).sort(em.createdDate.desc).asList().size();
    }
}
