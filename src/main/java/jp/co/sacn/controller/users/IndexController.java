package jp.co.sacn.controller.users;

import java.util.List;

import jp.co.sacn.model.Employee;
import jp.co.sacn.service.users.EmployeeService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private EmployeeService service = new EmployeeService();

    @Override
    public Navigation run() throws Exception {
        List<Employee> userList = service.getEmployeeList();
        requestScope("userList",userList);
        return forward("index.jsp");
    }
}
