$(function() {
	  $('#regist').click(function() {
		  registAttendance();
	  });
	  $('#config').click(function() {
		  clickConfigButton();
	  });
	  $('#inputAttendance').click(function() {
		  clickInputAttendanceButton();
	  });
	  $('#logout').click(function() {
		  var form = $('#logoutForm');
		  form.submit();
	  });

});
function clickInputAttendanceButton(){
	if(checkConfirm()){
		var form = $('#inputAttendanceForm');
		form.submit();
	}
}
function clickConfigButton(){
	if(checkConfirm()){
		var form = $('#configForm');
		form.submit();
	}
}

function changeMonth(y,m){
	var yy = ("000"+y).slice(-4);
	var mm = ("0"+m).slice(-2);
	if(checkConfirm()){
		$('#annualCalendarForm [name=calendarMonth]').val(yy + "-" + mm);
		var form = $('#annualCalendarForm');
		form.submit();
	}
}

function changeYear(y,m){
	var yy = ("000"+y).slice(-4);
	var mm = ("0"+m).slice(-2);
	$('#annualCalendarForm [name=calendarMonth]').val(yy + "-" + mm);
	var form = $('#annualCalendarForm');
	form.submit();
}
function clickMonth(y,m){
	var yy = ("000"+y).slice(-4);
	var mm = ("0"+m).slice(-2);
	var dd = "01";

	$('#calendarForm [name=calendarMonth]').val(yy + "-" + mm);
	$('#calendarForm [name=calendarDate]').val(yy + "-" + mm + "-" + dd);
	var form = $('#calendarForm');
	form.attr('method', 'post');
	form.attr('action', '/calendar/');
	form.submit();
}
function selectCalendar(el){
	var calendarMonthVal = $('#calendarMonth').val();
	var clickVal = ("0"+el.text).slice(-2);
	$('#calendarForm [name=calendarDate]').val(calendarMonthVal + "-" + clickVal);

	var form = $('#calendarForm');
	form.attr('method', 'post');
	form.attr('action', '/calendar/');
	form.submit();
}

function registAttendance(){
	var arrivalTimeVal = $('#selArrivalTime').val();
	var quittingTimeVal = $('#selQuittingTime').val();
	var absenceReasonVal = $('#selAbsenceReason').val();
	var workingLocationVal = $('#InputWorkingLocation').val();
	$('#registAttendanceForm [name=arrivalTime]').val(arrivalTimeVal);
	$('#registAttendanceForm [name=quittingTime]').val(quittingTimeVal);
	$('#registAttendanceForm [name=absenceReason]').val(absenceReasonVal);
	$('#registAttendanceForm [name=workingLocation]').val(workingLocationVal);
	var form = $('#registAttendanceForm');
	form.attr('method', 'post');
	form.attr('action', '/calendar/RegistAttendance');
	form.submit();
}

function isEditing(){
	var orgArrivalTimeVal = $('#registAttendanceForm [name=arrivalTime]').val();
	var orgQuittingTimeVal = $('#registAttendanceForm [name=quittingTime]').val();
	var orgAbsenceReasonVal = $('#registAttendanceForm [name=absenceReason]').val();
	var orgWorkingLocationVal = $('#registAttendanceForm [name=workingLocation]').val();

	var arrivalTimeVal = $('#selArrivalTime').val();
	var quittingTimeVal = $('#selQuittingTime').val();
	var absenceReasonVal = $('#selAbsenceReason').val();
	var workingLocationVal = $('#InputWorkingLocation').val();
	if(arrivalTimeVal != orgArrivalTimeVal
		|| quittingTimeVal != orgQuittingTimeVal
		|| absenceReasonVal != orgAbsenceReasonVal
		|| workingLocationVal != orgWorkingLocationVal
		){
		return true;
	}

	return false;
}

function checkConfirm(){
	if(!isEditing() || window.confirm('編集中の内容が破棄されますが宜しいですか？')){
		return true;
	}

	return false;
}
