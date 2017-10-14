<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="org.slim3.util.ApplicationMessage"%>
<html>
<head>
<%@ include file="/common/header.jsp"%>
<script src="/js/config.js"></script>
</head>
<body>
	<div class="container-fluid bg-info form-inline">
		<h1 class="text-center text-primary">
			<div class="btn-toolbar" role="toolbar">
				<div class="btn-group btn-group-lg" role="group">
				</div>
				<span>設定</span>
				<div class="btn-group btn-group-lg pull-right" role="group">
					<button class="btn btn-link" aria-label="Center Align" onclick="javascript:history.back();" type="button">
						<span aria-hidden="true"><%=ApplicationMessage.get("label.btn.back") %></span>
					</button>
				</div>
			</div>
		</h1>
	</div>

<form class="form-horizontal">
	<div class="container">

		<!-- 一般メンバー向けの設定 -->
		<h4>メンバー向けメニュー</h4>
		<p><button type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:$('#csvDownloadForm').submit();">CSVダウンロード</button></p>
		<p><button type="button" class="btn btn-primary btn-lg btn-block">初期値設定</button></p>
		<p><button type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:$('#changePasswordForm').submit();">パスワード変更</button></p>

			<br>

		<!-- 役職持ちのメニュー -->
		<h4>上長向けメニュー</h4>
		<p><button type="button" class="btn btn-primary btn-lg btn-block">メンバー提出状況確認</button></p>
		<p><button type="button" class="btn btn-primary btn-lg btn-block">一括CSVダウンロード</button></p>

			<br>

		<!-- 管理者のメニュー -->
		<h4>管理者メニュー</h4>
		<p><button type="button" class="btn btn-primary btn-lg btn-block">休日設定</button></p>
		<p><button type="button" class="btn btn-primary btn-lg btn-block">ユーザー・グループ設定</button></p>
			<br>

	</div>
</form>

<form id="logoutForm" method="POST" action="/login/logout">
</form>
<form id="csvDownloadForm" method="POST" action="/config/csvDownload">
</form>
<form id="changePasswordForm" method="POST" action="/users/changePassword">
</form>

</body>
</html>
