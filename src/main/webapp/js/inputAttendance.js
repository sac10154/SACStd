$(function() {
	$('#inputSelectDate').on('click', function(event) {
		$('input[name="inputDate"]').prop('disabled', false);
		$('input[name="inputMonth"]').val("");
		$('input[name="inputMonth"]').prop('disabled', true);
	});
	$('#inputSelectMonth').on('click', function(event) {
		$('input[name="inputDate"]').val("");
		$('input[name="inputDate"]').prop('disabled', true);
		$('input[name="inputMonth"]').prop('disabled', false);
	});
});

function registAttendance(){
	var bulkFlag = $('input[name="bulkFlag"]:checked');
	if (bulkFlag.length == 0) {
		alert('日付または一括をチェックしてください');
		return;
	}

	var inputDateVal = $('#inputDate').val();
	var inputMonthVal = $('#inputMonth').val();
	var arrivalTimeVal = $('#selArrivalTime').val();
	var quittingTimeVal = $('#selQuittingTime').val();
	var absenceReasonVal = $('#selAbsenceReason').val();
	var workingLocationVal = $('#InputWorkingLocation').val();

	$('#registAttendanceForm [name=calendarMonth]').val(inputMonthVal);
	$('#registAttendanceForm [name=calendarDate]').val(inputDateVal);
	$('#registAttendanceForm [name=arrivalTime]').val(arrivalTimeVal);
	$('#registAttendanceForm [name=quittingTime]').val(quittingTimeVal);
	$('#registAttendanceForm [name=absenceReason]').val(absenceReasonVal);
	$('#registAttendanceForm [name=workingLocation]').val(workingLocationVal);

	var form = $('#registAttendanceForm');
	form.attr('method', 'post');
	var action = '/calendar/RegistAttendance';
	if ('1' == bulkFlag.val()){
		action = '/calendar/BulkRegistAttendance';
	}
	form.attr('action', action);
	form.submit();
}

function back(){
	var form = $('#back');
	form.submit();
}