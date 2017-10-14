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
	<div class="container-fluid bg-info form-inline">
		<h1 class="text-center text-primary">
			<div class="btn-toolbar" role="toolbar">
				<div class="btn-group btn-group-lg" role="group">
				</div>
				<span>パスワード変更</span>
				<div class="btn-group btn-group-lg pull-right" role="group">
					<button class="btn btn-link" aria-label="Center Align" onclick="javascript:history.back();" type="button">
						<span aria-hidden="true">戻る</span>
					</button>
				</div>
			</div>
		</h1>
	</div>

<form class="form-horizontal">
	<div class="container">

			<br>

		<h4>この画面ではパスワードの変更ができます。</h4>

		<!-- パスワードの変更 -->
			<input type="text" class="form-control" id="inputuid3" placeholder="変更前のパスワード">

			<br>

			<input type="text" class="form-control" id="inputuid3" placeholder="変更後のパスワード">

			<input type="text" class="form-control" id="inputuid3" placeholder="確認用に変更後のパスワードをもう一度">

			<br>

			<button type="button" class="btn btn-primary btn-lg btn-block">登録</button>

	</div>
</form>
	</body>
</html>
