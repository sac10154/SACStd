$(function() {
	  $('#download').click(function() {
		  downloadAttendanceCsvFile();
	  });

});
function downloadAttendanceCsvFile(){
	var monthVal = $('#inputMonth').val();
	$('#downloadAttendanceCsvFileForm [name=calendarMonth]').val(monthVal);
	var form = $('#downloadAttendanceCsvFileForm');
	form.attr('method', 'post');
	form.attr('action', '/config/DownloadAttendanceCsvFile');
	form.submit();
}
