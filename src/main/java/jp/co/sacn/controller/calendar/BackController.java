package jp.co.sacn.controller.calendar;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class BackController extends Controller {

	/**
     * 制御
     *
     * @return 遷移先のパス
     * @throws Exception
     */
	@Override
    public Navigation run() throws Exception {
        return forward(basePath);
    }
}
