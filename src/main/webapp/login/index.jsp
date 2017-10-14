<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="org.slim3.util.ApplicationMessage"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="message" uri="http://www.sacn.co.jp/tags/message"%>

<html>
<head>
<%@ include file="/common/header.jsp"%>
<script src="/js/login.js"></script>
</head>
<body>
<form class="form-horizontal" id="loginForm" method="POST" action="/login/login">
<div class="page-header">
<h3 class="text-center text-primary"><%=ApplicationMessage.get("label.login") %></h3>
</div>
<div class="container">
	<message:Message errorMessage="${errors.message}"
                   infoMessage="${message}"
                   errorLevel=""
                   />
	<div class="input-group input-group-lg">
		<span class="input-group-addon">
		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		</span>
		<input type="text" class="form-control" id="inputuid3" name="userId" placeholder="<%=ApplicationMessage.get("label.userId") %>" />
	</div>
	<div class="input-group input-group-lg">
		<span class="input-group-addon">
		<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
		</span>
		<input type="password" class="form-control" id="inputPassword3" name="password" placeholder="<%=ApplicationMessage.get("label.password") %>" />
	</div>

	<br/>
	<div class="btn-group btn-group-justified" role="group">
		<div class="btn-group" role="group">
		<button type="button" class="btn btn-primary btn-lg btn-block" id="login"><%=ApplicationMessage.get("label.login") %></button>
		</div>
	</div>
</div>
</form>
</body>
</html>
