package jp.co.sacn.controller;

import jp.co.sacn.service.users.EmployeeService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

	/** 社員のService */
    private EmployeeService service = new EmployeeService();

    @Override
    public Navigation run() throws Exception {
    	int cnt = service.getCount();
    	if(cnt == 0){
        	return forward("/users/Start");
    	}
    	return forward("index.jsp");
    }
}
