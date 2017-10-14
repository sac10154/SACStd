/**
 *
 */
package jp.co.sacn.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import jp.co.sacn.util.StringUtils;

/**
 * @author gotoumasahiko
 *
 */
@SuppressWarnings("serial")
public class MessageTag extends TagSupport{
    private String infoMessage = "";
    private String errorMessage = "";
    private String errorLevel = "";


	/**
	 * @return infoMessage
	 */
	public String getInfoMessage() {
		return infoMessage;
	}

	/**
	 * @param infoMessage セットする infoMessage
	 */
	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	/**
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage セットする errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return errorLevel
	 */
	public String getErrorLevel() {
		return errorLevel;
	}

	/**
	 * @param errorLevel セットする errorLevel
	 */
	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}

	public int doStartTag() throws JspException {

        try {

        	JspWriter writer = pageContext.getOut();
        	if(StringUtils.isNotNull(getErrorMessage())){
                writer.println("<div class='alert alert-danger' role='alert'><strong>error</strong>：　" + getErrorMessage() + "</div>");
        	}
        	if(StringUtils.isNull(getErrorMessage()) && StringUtils.isNotNull(getInfoMessage())){
                writer.println("<div class='alert alert-info' role='alert'><strong>info</strong>：　" + getInfoMessage() + "</div>");
        	}

        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
       return EVAL_PAGE;
    }

}
