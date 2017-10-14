package jp.co.sacn.controller.login;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class LogoutController extends Controller {

    @Override
    public Navigation run() throws Exception {
    	HttpSession session = request.getSession(false);
    	if(session != null){
        	session.invalidate();
    	}

    	return forward("logout.jsp");
    }
}
