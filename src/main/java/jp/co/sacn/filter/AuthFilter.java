package jp.co.sacn.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter{

	private static final String EXCLUDE_PATH = "excludepath";

	private String[] excludeArray;


	/**
     * フィルタ
     *
     * @param request リクエスト
     * @param response レスポンス
     * @param chain チェイン
     */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
		try{
	    	String target = ((HttpServletRequest)request).getRequestURI();
			HttpSession session = ((HttpServletRequest)request).getSession();

			if (session == null){
				/* 未認証 */
		        session = ((HttpServletRequest)request).getSession(true);
	        	String session_id = session.getId();
		        session.setAttribute("target", target);
	        	session.setAttribute("sessionid", session_id);
		        ((HttpServletResponse)response).sendRedirect("/");
			}else{
				if(isExcludePath(target)){
					chain.doFilter(request, response);
					return;
				}

				Object loginCheck = session.getAttribute("login");
				if (loginCheck == null){
			        session.setAttribute("target", target);
			        ((HttpServletResponse)response).sendRedirect("/");
				}
			}
			chain.doFilter(request, response);
			return;
		}catch (ServletException se){
		}catch (IOException e){
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException{
		String excludePath = (String)filterConfig.getInitParameter(EXCLUDE_PATH);
		//パスを分割
		excludeArray = excludePath.split(",",0);
	}

	public void destroy(){
	}

	private boolean isExcludePath(String target) {

		//パターンとリクエストされているURLを比較して判定
		for(int i = 0; i < excludeArray.length; i++){
			Pattern pattern = Pattern.compile("^" + excludeArray[i]);
			Matcher matcher = pattern.matcher(target);
			if(matcher.matches()){
				return true;
			}
		}
		return false;
	}
}
