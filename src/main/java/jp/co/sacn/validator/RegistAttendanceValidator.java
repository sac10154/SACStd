package jp.co.sacn.validator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.sacn.common.Constants;

import org.slim3.controller.validator.Errors;
import org.slim3.controller.validator.Validators;


public class RegistAttendanceValidator extends AttendanceValidator{
    public void validate(Errors errors, HttpServletRequest request) throws Exception {
    	Validators v = new Validators(request);
    	v.add("calendarDate", v.required(), v.dateType(Constants.DATE_FORMATE_DATE),  v.regexp("^\\d{4}-\\d{2}-\\d{2}$"));
    	if (!v.validate()) {
    		errors = v.getErrors();
    		for(Map.Entry<String, String> e : errors.entrySet()) {
    		    System.out.println(e.getKey() + " : " + e.getValue());
    		}
    		return;
    	}

    	super.validate(errors, request);
    	if(!errors.isEmpty()){
    		return;
    	}

    }
}
