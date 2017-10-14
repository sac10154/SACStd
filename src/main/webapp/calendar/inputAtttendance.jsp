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
<script src="/js/inputAttendance.js?z"></script>
</head>
<body>
<div class="container-fluid bg-info form-inline">
<h1 class="text-center text-primary">
<div class="btn-toolbar" role="toolbar">
	<div class="btn-group btn-group-lg" role="group">
	</div>
	<span><%=ApplicationMessage.get("label.appname") %></span>
	<div class="btn-group btn-group-lg pull-right" role="group">
		<button class="btn btn-link" aria-label="Center Align" onclick="back();" type="button">
			<span aria-hidden="true"><%=ApplicationMessage.get("label.btn.back") %></span>
		</button>
    </div>
</div>
</h1>
<message:Message errorMessage="${errors.message}" infoMessage="${message}" errorLevel=""/>
</div>
<div class="container bg-default">
<form class="form-horizontal">
	<div class="form-group form-group-lg">
	<div class="container">
	  <table class="table">
	    <thead></thead>
	    <tbody>
	      <tr>
	        <td><div class="radio-inline">
			<c:if test="${empty calendarMonth && not empty calendarDate}" >
	        <input type="radio" name="bulkFlag" value="0" id="inputSelectDate" checked="checked">
			</c:if>
			<c:if test="${not empty calendarMonth ||empty calendarDate}" >
	        <input type="radio" name="bulkFlag" value="0" id="inputSelectDate">
			</c:if>
	        <label for="inputSelectDate"><%=ApplicationMessage.get("label.date") %></label></div></td>
	        <td><div class="radio-inline">
			<c:if test="${not empty calendarMonth && empty calendarDate}" >
	        <input type="radio" name="bulkFlag" value="1" id="inputSelectMonth" checked="checked">
			</c:if>
			<c:if test="${empty calendarMonth || not empty calendarDate}" >
	        <input type="radio" name="bulkFlag" value="1" id="inputSelectMonth">
			</c:if>
	        <label for="inputSelectMonth"><%=ApplicationMessage.get("label.bulk") %></label></div></td>
	      </tr>
	      <tr>
	        <td>
			<c:if test="${empty calendarMonth && not empty calendarDate}" >
	        <input type="text" name="inputDate" class="form-control dateInput" value="${calendarDate}" id="inputDate"/>
			</c:if>
			<c:if test="${not empty calendarMonth || empty calendarDate}" >
	        <input type="text" name="inputDate" class="form-control dateInput" value="${calendarDate}" id="inputDate" disabled="disabled"/>
			</c:if>
	        </td>
	        <td>
			<c:if test="${not empty calendarMonth && empty calendarDate}" >
	        <input type="text" name="inputMonth" class="form-control monthInput" value="${calendarMonth}" id="inputMonth"/>
			</c:if>
			<c:if test="${empty calendarMonth || not empty calendarDate}" >
	        <input type="text" name="inputMonth" class="form-control monthInput" value="${calendarMonth}" id="inputMonth" disabled="disabled"/>
			</c:if>
	        </td>
	      </tr>
	    </tbody>
	  </table>
	</div>
	</div>
<calendar:CalendarInputForm absenceReason="${absenceReason}"
                   arrivalTime="${arrivalTime}"
                   quittingTime="${quittingTime}"
                   workingLocation="${workingLocation}"
                   />

<div class="btn-group btn-group-justified" role="group">
<div class="btn-group" role="group">
<button type="button" class="btn btn-primary btn-lg btn-block" onclick="registAttendance();"><%=ApplicationMessage.get("label.btn.regist") %></button>
</div>
</div>
</form>
</div>
<form id="back" method="POST" action="/calendar/back">
</form>

<form id="registAttendanceForm" method="POST" action="/calendar/RegistAttendance">
<input type="hidden" name="userId" id="userId" value="${userId}" />
<input type="hidden" name="calendarMonth" id="calendarMonth" value="${calendarMonth}" />
<input type="hidden" name="calendarDate" id="calendarDate" value="${calendarDate}" />
<input type="hidden" name="arrivalTime" id="arrivalTime" value="${arrivalTime}" />
<input type="hidden" name="quittingTime" id="quittingTime" value="${quittingTime}" />
<input type="hidden" name="absenceReason" id="absenceReason" value="${absenceReason}" />
<input type="hidden" name="workingLocation" id="workingLocation" value="${workingLocation}" />
</form>
</body>
</html>
