$(function() {
	inputInitialize();
});

function inputInitialize() {
    $(".dateInput").datepicker({
    	format: 'yyyy-mm-dd',
        maxViewMode: 0,
        language: "ja",
        multidate: false,
        forceParse: false,
        autoclose: true,
        todayHighlight: true
    });

    $(".monthInput").datepicker({
    	format: 'yyyy-mm',
    	maxViewMode: 2,
        minViewMode: 1,
        startMode: 1,
        language: "ja",
        autoclose: true
    });

}
