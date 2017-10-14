package jp.co.sacn.controller.users;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class StartController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("start.jsp");
    }
}
