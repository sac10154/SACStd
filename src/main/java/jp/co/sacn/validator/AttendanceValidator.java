package jp.co.sacn.validator;

import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.validator.Errors;
import org.slim3.controller.validator.Validators;


public class AttendanceValidator {

	protected static final Logger LOG =Logger.getLogger(AttendanceValidator.class.getName());

	public void validate(Errors errors, HttpServletRequest request) throws Exception {
    	Validators v = new Validators(request);
//    	v.add("userId", v.required(), v.minlength(5), v.maxlength(5), v.regexp("^[0-9]*"));
//    	v.add("calendarDate", v.required(), v.dateType(Constants.DATE_FORMATE_DATE),  v.regexp("^\\d{4}-\\d{2}-\\d{2}$"));
    	v.add("arrivalTime", v.minlength(4), v.maxlength(4), v.regexp("^[0-9]*"));
    	v.add("quittingTime", v.minlength(4), v.maxlength(4), v.regexp("^[0-9]*"));
    	v.add("workingLocation", v.minlength(1), v.maxlength(100));
    	v.add("absenceReason", v.regexp("^[0-9]*"));

    	if (!v.validate()) {
    		errors = v.getErrors();
    		for(Map.Entry<String, String> e : errors.entrySet()) {
    			LOG.severe(e.getKey() + " : " + e.getValue());
//    			System.out.println(e.getKey() + " : " + e.getValue());
    		}
    	}
    }

    protected String param(CharSequence name, HttpServletRequest request) throws NullPointerException {
    	if (name == null) {
    		throw new NullPointerException(
    				"The name parameter must not be null.");
    	}
    	return request.getParameter(name.toString());
    }

}

