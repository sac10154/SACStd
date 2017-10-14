package jp.co.sacn.controller.common;

import java.net.URI;

import org.slim3.controller.Controller;

public abstract class AbstractController extends Controller {

    public String getReferer() throws Exception {
        String referer = new URI(request.getHeader("referer")).getPath();
    	return referer;
    }

}
