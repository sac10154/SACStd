package jp.co.sacn.controller.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class CsvDownloadController extends Controller {

    @Override
    public Navigation run() throws Exception {
    	return forward("csvDownload.jsp");
    }
}
