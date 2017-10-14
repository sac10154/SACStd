package jp.co.sacn.controller.login;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class UserManageController extends Controller {

	/** JSP **/
	private static final String JSP =  "/users/";

	@Override
    public Navigation run() throws Exception {
        return redirect(JSP);
    }
}
