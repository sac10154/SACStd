<%@page pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.slim3.util.ApplicationMessage"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="calendar" uri="http://www.sacn.co.jp/tags/calendar"%>
<%@taglib prefix="message" uri="http://www.sacn.co.jp/tags/message"%>

<html>
<head>
<%@ include file="/common/header.jsp"%>
<script src="/js/calendar.js?x1"></script>
</head>
<body>
<div class="container bg-info form-inline">
<h1 class="text-center text-primary">
	<span><%=ApplicationMessage.get("label.appname") %></span>
</h1>
<div class="btn-toolbar" role="toolbar">
	<div class="btn-group btn-group-lg" role="group">
		<button class="btn btn-default" aria-label="Left Align" type="button" id="config">
			<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
		</button>
		<button class="btn btn-default" aria-label="Center Align" type="button" id="logout">
			<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
		</button>
	</div>
	<div class="btn-group btn-group-lg pull-right" role="group">
		<button class="btn btn-default" aria-label="Right Align" type="button" onclick="javascript:location.href='./submit.htm'">
			<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
		</button>
		<button class="btn btn-default" aria-label="Center Align" type="button" id="inputAttendance">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		</button>
    </div>
</div>
<message:Message errorMessage="${errors.message}" infoMessage="${message}" errorLevel=""/>
</div>
<form class="form-horizontal">
<div class="container">
<calendar:Calendar calendarDate="${calendarDate}"/>
</div>
</form>

<br/>
<div class="container">
<div class="panel panel-default">
	<div class="panel-heading">
	<%=ApplicationMessage.get("label.attendance.input.form") %>
	</div>


<div class="panel-body">
<calendar:CalendarInputForm absenceReason="${absenceReason}"
                   arrivalTime="${arrivalTime}"
                   quittingTime="${quittingTime}"
                   workingLocation="${workingLocation}"
                   />

</div>
<div class="btn-group btn-group-justified" role="group">
<div class="btn-group" role="group">
<button type="button" class="btn btn-primary btn-lg btn-block" id="regist"><%=ApplicationMessage.get("label.btn.regist") %></button>
</div>
</div>
</div>
</div>
<form id="configForm" method="POST" action="/config/">
</form>
<form id="inputAttendanceForm" method="POST" action="/calendar/InputAttendance">
<input type="hidden" name="calendarDate" id="calendarDate" value="${calendarDate}" />
</form>
<form id="annualCalendarForm" method="POST" action="/calendar/AnnualCalendar">
<input type="hidden" name="calendarMonth" id="calendarMonth" value="${calendarMonth}" />
</form>
<form id="logoutForm" method="POST" action="/login/logout">
</form>
<form id="calendarForm" method="POST" action="/calendar/">
<input type="hidden" name="calendarMonth" id="calendarMonth" value="${calendarMonth}" />
<input type="hidden" name="calendarDate" id="calendarDate" value="${calendarDate}" />
</form>
<form id="registAttendanceForm" method="POST" action="/calendar/RegistAttendance">
<input type="hidden" name="userId" id="userId" value="${userId}" />
<input type="hidden" name="calendarDate" id="calendarDate" value="${calendarDate}" />
<input type="hidden" name="arrivalTime" id="arrivalTime" value="${arrivalTime}" />
<input type="hidden" name="quittingTime" id="quittingTime" value="${quittingTime}" />
<input type="hidden" name="absenceReason" id="absenceReason" value="${absenceReason}" />
<input type="hidden" name="workingLocation" id="workingLocation" value="${workingLocation}" />
</form>
</body>
</html>
