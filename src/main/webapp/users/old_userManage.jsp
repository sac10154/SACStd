<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<%@ include file="/common/header.jsp"%>
<script src="/js/timesheet.js"></script>
</head>
<body>
<form class="form-horizontal" method="post" action="userCreate">
<div class="page-header">
<h3 class="text-center text-primary">ユーザー管理（仮）</h3>
</div>
<div class="container">
	<div class="input-group">
		<span class="input-group-addon">
		ユーザーID
		</span>
		<input type="text" class="form-control" id="inputuid3" name="userId" placeholder="ユーザーID">
	</div>
	<div class="input-group">
		<span class="input-group-addon">
		パスワード
		</span>
		<input type="password" class="form-control" id="inputPassword3" name="password" placeholder="パスワード">
	</div>

	<br/>
	<div class="btn-group btn-group-justified" role="group">
		<div class="btn-group" role="group">
		<button type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:this.form.submit();">登録</button>
		</div>
	</div>
</div>
</form>
</body>
</html>
