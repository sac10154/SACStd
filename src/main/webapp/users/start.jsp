<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="org.slim3.util.ApplicationMessage"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="message" uri="http://www.sacn.co.jp/tags/message"%>
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<body>
<div class="page-header">
<h3 class="text-center text-primary"><%=ApplicationMessage.get("label.login") %></h3>
</div>
<div class="container">
	<form class="form-horizontal" method="post" action="/users/CreateAdministrator">
	<message:Message errorMessage="${errors.message}"
                   infoMessage="${message}"
                   errorLevel=""
                   />

	<div class="btn-group btn-group-justified" role="group">
		<div class="btn-group" role="group">
		<button type="button" class="btn btn-primary btn-lg btn-block" onclick='javascript:this.form.submit();'><%=ApplicationMessage.get("label.user.regist") %></button>
		</div>
	</div>
	</form>
</div>
</body>
</html>
