/**
 *
 */
package jp.co.sacn.web.taglib;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import jp.co.sacn.common.Constants;

/**
 * @author gotoumasahiko
 *
 */
@SuppressWarnings("serial")
public class AnnualCalendarTag extends TagSupport{
	private String calendarMonth = "";

    /**
	 * @return calendarMonth
	 */
	public String getCalendarMonth() {
		return calendarMonth;
	}

	/**
	 * @param calendarMonth セットする calendarMonth
	 */
	public void setCalendarMonth(String calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	public int doStartTag() throws JspException {

        try {
            JspWriter writer = pageContext.getOut();

            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMATE_MONTH);
			Date date = new Date();
            try {
            	date = sdf.parse(getCalendarMonth());
			} catch (ParseException e) {
                writer.print("日付が不正です");
                return SKIP_BODY;
			}

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
        	int intYear = cal.get(Calendar.YEAR);
        	int intMonth = cal.get(Calendar.MONTH)+1;

            //月が1から12かどうかチェック
            if ((intMonth < 1) || (intMonth > 12)) {
                writer.print("月が1から12以外のため表示できません");
                return SKIP_BODY;
            }


            writer.println("<nav>");
            writer.println("<ul class='pager pagination-sm'>");
            writer.println("<li class='previous'><a href='#' onclick=\"changeYear('"+String.valueOf(intYear -1)+"','1')\">");
            writer.println("<span class='glyphicon glyphicon-chevron-left' aria-hidden='true'>");
            writer.println("</span>");
            writer.println(String.valueOf(intYear -1) + "年");
            writer.println("</a></li>");
            writer.println("<li><SPAN style='font-size:200%'><B>");
            writer.println(String.valueOf(intYear) + "年</B></SPAN>");
            writer.println("</li>");
            writer.println("<li class='next'><a href='#' onclick=\"changeYear('"+String.valueOf(intYear +1)+"','1')\">");
            writer.println(String.valueOf(intYear + 1) + "年");
            writer.println("<span class='glyphicon glyphicon-chevron-right' aria-hidden='true'>");
            writer.println("</span>");
            writer.println("</a></li>");
            writer.println("</ul>");
            writer.println("</nav>");

            writer.println("<div class='container'>");
            StringBuilder sb = new StringBuilder();
            for(int i=1 ; i<= 12; i++){
            	sb.setLength(0);
            	if(i==1 || (i % 3) == 1){
            		sb.append("<div class='btn-group btn-group-justified'  role='group'>");
            	}
            	if(i == intMonth){
            		sb.append("<a href='#' class='btn btn-default btn btn-primary' role='button' onclick=\"clickMonth('"+String.valueOf(intYear)+"','"+i+"')\">"+i+"月</a>");
            	} else {
            		sb.append("<a href='#' class='btn btn-default' role='button' onclick=\"clickMonth('"+String.valueOf(intYear)+"','"+i+"')\">"+i+"月</a>");
            	}
            	if((i % 3) == 0){
            		sb.append("</div>");
            	}
            	writer.println(sb.toString());
            }

        	writer.println("</div>");


        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

	public int doEndTag() throws JspException {
       return EVAL_PAGE;
    }

}
