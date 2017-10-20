<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="message" uri="http://www.sacn.co.jp/tags/message"%>

<html>
<head>
<%@ include file="/common/header.jsp"%>
<script src="/js/userManage.js?"></script>
</head>
<body>
<div class="page-header">
<h3 class="text-center text-primary">xxxx</h3>
</div>
<div class="container">
<message:Message errorMessage="${errors.message}"
                   infoMessage=""
                   errorLevel=""
                   />

	<div class="row">
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					グループ階層
				</div>
				<div class="panel-body">
					<ul id="browser" class="filetree">
						<li class="closed"><span class="folder">Folder 1</span>
							<ul>
								<li><span class="file">Item 1.1</span></li>
							</ul>
						</li>
						<li class="closed"><span class="folder">Folder 2</span>
							<ul>
								<li><span class="folder">Subfolder 2.1</span>
									<ul id="folder21">
<c:forEach var="e" items="${result.groupInfoList}">
										<li><span class="file">${f:h(e.group.groupId)}</span></li>
</c:forEach>
									</ul>
								</li>
								<li><span class="file">File 2.2</span></li>
							</ul>
						</li>
						<li class="closed"><span class="folder">Folder 3 (closed at start)</span>
							<ul>
								<li><span class="file">File 3.1</span></li>
							</ul>
						</li>
						<li><span class="file">File 4</span></li>
					</ul>
				</div>
			</div>
		</div>		<div class="col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading"></div>
				<div class="panel-body">
				</div>
			</div>
		</div>
	</div>
<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th></th>
				<th>No.</th>
				<th>ユーザーID</th>
				<th>登録日</th>
			</tr>
		</thead>
		<tbody>
<c:forEach var="e" items="${userList}">
			<tr>
				<td><input type="checkbox"/></td>
				<th>1</th>
				<td>${f:h(e.userId)}</td>
				<td>${f:h(e.createdDate)}</td>
			</tr>
</c:forEach>
		</tbody>
	</table>
</div>
<hr />

	<form class="form-horizontal" method="post" action="/users/userCreate">
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
	</form>

	<br/>
	<form class="form-horizontal" method="post" action="/users/back">
	<div class="btn-group btn-group-justified" role="group">
		<div class="btn-group" role="group">
		<button type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:this.form.submit();">戻る</button>
		</div>
	</div>
	</form>
</div>
</body>
</html>
