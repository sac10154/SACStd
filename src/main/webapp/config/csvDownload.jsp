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
<script src="/js/csvDonwload.js?1a1"></script>
</head>
<body>
<div class="container-fluid bg-info form-inline">
<h1 class="text-center text-primary">
<div class="btn-toolbar" role="toolbar">
	<div class="btn-group btn-group-lg" role="group">
	</div>
	<span><%=ApplicationMessage.get("label.appname") %></span>
	<div class="btn-group btn-group-lg pull-right" role="group">
		<button class="btn btn-link" aria-label="Center Align" onclick="javascript:history.back();" type="button">
			<span aria-hidden="true"><%=ApplicationMessage.get("label.btn.back") %></span>
		</button>
    </div>
</div>
</h1>
<message:Message errorMessage="${errors.message}" infoMessage="${message}" errorLevel=""/>
</div>

<div class="panel-body">
<form class="form-horizontal">
<div class="form-group form-group-lg">
<label class="col-sm-2 control-label" for="InputText"><%=ApplicationMessage.get("label.targetMonth") %></label>
<div class="col-sm-2">
	<input type="text" name="inputMonth" class="form-control monthInput" value="" id="inputMonth" />
</div>
</div>
<div class="btn-group btn-group-justified" role="group">
<div class="btn-group" role="group">
<button type="button" class="btn btn-primary btn-lg btn-block" id="download"><%=ApplicationMessage.get("label.btn.download") %></button>
</div>
</div>
</form>
</div>
<form id="downloadAttendanceCsvFileForm" method="POST" action="/config/DownloadAttendanceCsvFile">
<input type="hidden" name="userId" id="userId" value="${userId}" />
<input type="hidden" name="calendarMonth" id="calendarMonth" value="${calendarMonth}" />
</form>
</body>
</html>
