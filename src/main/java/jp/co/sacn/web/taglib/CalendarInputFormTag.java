/**
 *
 */
package jp.co.sacn.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import jp.co.sacn.common.impl.AbsenceReason;

/**
 * @author gotoumasahiko
 *
 */
@SuppressWarnings("serial")
public class CalendarInputFormTag extends TagSupport{
    private String absenceReason = "";
    private String arrivalTime = "";
    private String quittingTime = "";
    private String workingLocation = "";

    /**
	 * @return absenceReason
	 */
	public String getAbsenceReason() {
		return absenceReason;
	}

	/**
	 * @param absenceReason セットする absenceReason
	 */
	public void setAbsenceReason(String absenceReason) {
		this.absenceReason = absenceReason;
	}

	/**
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime セットする arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return quittingTime
	 */
	public String getQuittingTime() {
		return quittingTime;
	}

	/**
	 * @param quittingTime セットする quittingTime
	 */
	public void setQuittingTime(String quittingTime) {
		this.quittingTime = quittingTime;
	}

	/**
	 * @return workingLocation
	 */
	public String getWorkingLocation() {
		return workingLocation;
	}

	/**
	 * @param workingLocation セットする workingLocation
	 */
	public void setWorkingLocation(String workingLocation) {
		this.workingLocation = workingLocation;
	}

	public int doStartTag() throws JspException {

        try {

            JspWriter writer = pageContext.getOut();

//            writer.println("<div class=\"panel-body\">");
            writer.println("<form class=\"form-horizontal\">");

            writer.println("<div class=\"form-group\">");
            writer.println("<label class=\"col-sm-2 control-label\" for=\"InputSelect1\">休 暇 等 ：</label>");
            writer.println("<div class=\"col-sm-10\">");
            writer.println("<select class=\"form-control\" id=\"selAbsenceReason\" name=\"selAbsenceReason\">");
            writer.println("<option value=\"\">--</option>");
            for(int i=1 ; i< AbsenceReason.values().length; i++){
            	String absenceReasonStr = String.valueOf(i);
                writer.println("<option value='" + absenceReasonStr  + "' ");
                if(absenceReasonStr.equals(getAbsenceReason())){
                    writer.println("selected='selected'");
                }
                writer.println(">" + AbsenceReason.decode(i).getName() +"</option>");
            }
            writer.println("</select>");
            writer.println("</div>");
            writer.println("</div>");

            writer.println("<div class=\"form-group\">");
            writer.println("<label class=\"col-sm-2 control-label\" for=\"InputSelect2\">出社時間：</label>");
            writer.println("<div class=\"col-sm-10\">");
            writer.println("<select class=\"form-control\" id=\"selArrivalTime\" name=\"selArrivalTime\">");
            writer.println("<option value=\"\">--</option>");

            writeSelectTime(writer, getArrivalTime());
            writer.println("</select>");
            writer.println("</div>");
            writer.println("</div>");

            writer.println("<div class=\"form-group\">");
            writer.println("<label class=\"col-sm-2 control-label\" for=\"InputSelect3\">退社時間：</label>");
            writer.println("<div class=\"col-sm-10\">");
            writer.println("<select class=\"form-control\" id=\"selQuittingTime\" name=\"selQuittingTime\">");
            writer.println("<option value=\"\">--</option>");

            writeSelectTime(writer, getQuittingTime());

            writer.println("</select>");
            writer.println("</div>");
            writer.println("</div>");

            writer.println("<div class=\"form-group form-group-lg\">");
            writer.println("<label class=\"col-sm-2 control-label sr-only\" for=\"InputText\">行き先（常駐先）</label>");
            writer.println("<div class=\"col-sm-10\">");
            writer.println("<input type=\"text\" class=\"form-control\" id=\"InputWorkingLocation\" name=\"InputWorkingLocation\" placeholder=\"行き先（常駐先）欄\" value=\"" + getWorkingLocation() + "\"/>");
            writer.println("</div>");
            writer.println("</div>");

            writer.println("</form>");
//            writer.println("</div>");
//            writer.println("<div class=\"btn-group btn-group-justified\" role=\"group\">");
//            writer.println("<div class=\"btn-group\" role=\"group\">");
//            writer.println("<button type=\"button\" class=\"btn btn-primary btn-lg btn-block\" onclick=\"registAttendance();\">登録</button>");
//            writer.println("</div>");
//            writer.println("</div>");

        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
       return EVAL_PAGE;
    }


    //時間選択
    private void writeSelectTime(JspWriter writer, String selectedTime) throws JspException {

        try {
            int mi = 7;
            for(int i=0 ; i< 23; i++){

            	String miStr = String.format("%02d", mi + i);
            	String ssStr = String.format("%02d", 0);
            	String missStrm = miStr + ssStr;
            	writer.println("<option value=\"" + missStrm + "\" ");
            	if(missStrm.equals(selectedTime)){
                	writer.println("selected='selected'");
            	}
            	writer.println(">" + miStr + ":" + ssStr + "</option>");

            	miStr = String.format("%02d", mi + i);
            	ssStr = String.format("%02d", 30);
            	missStrm = miStr + ssStr;
            	writer.println("<option value=\"" + missStrm + "\" ");
            	if(selectedTime != null && missStrm.equals(selectedTime)){
                	writer.println("selected='selected'");
            	}
            	writer.println(">" + miStr + ":" + ssStr + "</option>");

            }
        } catch (IOException e) {
            throw new JspException(e);
        }

    }

}
