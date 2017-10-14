package jp.co.sacn.controller.login;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import jp.co.sacn.model.Employee;
import jp.co.sacn.service.login.LoginService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.RequestMap;

public class LoginController extends Controller {

	private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

	private LoginService service = new LoginService();

    @Override
    public Navigation run() throws Exception {
    	LOG.info("Start");
    	HttpSession session = request.getSession(false);
    	Employee employee = service.login(new RequestMap(request));
        if(employee != null){
            /* 認証済みにセット */
            session.setAttribute("login", "OK");
            session.setAttribute("userId", employee.getUserId());
            session.setAttribute("userName", employee.getFname() + " " + employee.getSname());
        	requestScope("userId",employee.getUserId());
            return redirect("/calendar");
        } else {
            session.setAttribute("status", "Not Auth");
            errors.put("message", ApplicationMessage.get("error.login.failure"));
            return forward(basePath);
        }
    }
}
