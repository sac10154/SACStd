package jp.co.sacn.controller.common;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class DownloadController extends Controller {

	private final static String ENCODING = "SJIS";
	private final static String CONTENTTYPE = "application/octet-stream";

    public Navigation download(String filename, String str) throws Exception {
    	response.setContentType(CONTENTTYPE);
    	response.setHeader("Content-Disposition", "filename=" + filename);
    	response.setCharacterEncoding(ENCODING); //getWriter()の前にエンコード指定
    	String res = new String( str.getBytes(ENCODING),ENCODING);
    	response.getWriter().println(res);
    	return null;
    }

}
