<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<META http-equiv="Content-Style-Type" content="text/css">
<link href="./style.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ユーザ一覧画面</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- オリジナルCSS読み込み -->
<link href="css/original/common.css" rel="stylesheet">
<!-- Jqeryの読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<!-- BootstrapのJS読み込み -->
	<script src="js/bootstrap.min.js">
</script>
<!-- レイアウトカスタマイズ用個別CSS -->

</head>
<body>

	<!-- header -->
	<header>

		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
			<div class="container">
				<div class="container mr-auto">
					<a class="navbar-brand" href="LoginServlet">ユーザ管理システム</a>
				</div>
				<div class="collapse navbar-collapse" id="navbarText">
					<ul class="navbar-nav">
						<li class="nav-item active"><span class="navbar-text">
								ユーザ名さん </span></li>
						<li class="nav-item active"><a class="nav-link"
							href="userCreateservlet">新規登録</a></li>
						<li class="nav-item"><a class="nav-link" href="LogoutServlet">ログアウト</a>
						</li>
					</ul>
				</div>
			</div>

		</nav>
	</header>
	<!-- /header -->

	<!-- body -->
	<div class="container margin">
		<div class="container">
			<div class="panel-body">
				<div class="panel panel-default">
					<div class="panel-heading">
						<font size="5">
							<div class="panel-title label-color">検索条件</div>
						</font>
					</div>
					<div class="panel-body">
						<form method="post" action="UserlistServlet"
							class="form-horizontal">
							<div class="form-group">
								<font size="5"> <label for="code"
									class="control-label col-sm-2 label-color">ログインID</label>
								</font>
								<div class="col-sm-6">
									<input type="text" name="login_id" id="login-id"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<font size="5"> <label for="name"
									class="control-label col-sm-2 label-color">ユーザ名</label>
								</font>
								<div class="col-sm-6">
									<input type="text" name="user_name" id="user-name"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<font size="5"> <label for="continent"
									class="control-label col-sm-2 label-color">生年月日</label>
								</font>
								<div class="row">
									<div class="col-sm-2">
										<input type="date" name="date-start" id="date-start" class="form-control" size="30" />
									</div>
									<div class="col-xs-1 text-center">~</div>
									<div class="col-sm-2">
										<input type="date" name="date-end" id="date-end" class="form-control" />
									</div>
								</div>
							</div>
							<div class="text-right">
								<button type="submit" value="検索"
									class="btn btn-primary form-submit">検索</button>
							</div>
						</form>
					</div>
				</div>

				<table class="table" background="PAK85_kiirioicup20140329_TP_V.jpg">
					<thead>
						<tr>
							<th>#</th>
							<th>ログインID</th>
							<th>ユーザ名</th>
							<th>生年月日</th>
						</tr>
					</thead>
					<tbody>






						<c:forEach var="human" items="${UserList}">


							<tr class="active">
								<th scope="row">${human.id}</th>
								<td>${human.loginId}</td>
								<td>${human.name}</td>
								<td>${human.getFormatBirthDate()}</td>
								<td>
									<c:choose>
										<c:when test="${UserBean.loginId == 'admin'}">
											<a class="btn btn-primary" href="UserDetailSeavlet?id=${human.loginId}">詳細</a>
											<a class="btn btn-success" href="userUpdateServlet?id=${human.loginId}">更新</a>
											<a class="btn btn-danger" href="userDeleteServlet?id=${human.loginId}">削除</a>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${human.loginId == UserBean.loginId}">
													<a class="btn btn-primary" href="UserDetailSeavlet?id=${human.loginId}">詳細</a>
													<a class="btn btn-success" href="userUpdateServlet?id=${human.loginId}">更新</a>
												</c:when>
												<c:otherwise>
													<a class="btn btn-primary" href="UserDetailSeavlet?id=${human.loginId}">詳細</a>
												</c:otherwise>
											</c:choose>
									 	</c:otherwise>
									 </c:choose>
								 </td>
							</tr>


						</c:forEach>


						<!--  <tr>
	              <th scope="row">2</th>
	              <td>Jacob</td>
	              <td>Thornton</td>
	              <td>@fat</td>
	              <td>
	                <a class="btn btn-primary" href="userDetail.html">詳細</a>
	                <a class="btn btn-success" href="userUpdate.html">更新</a>
	                <a class="btn btn-danger" href ="userDelete.html">削除</a>
	              </td>
	            </tr>
	            <tr>
	              <th scope="row">3</th>
	              <td>Larry</td>
	              <td>the Bird</td>
	              <td>@twitter</td>
	              <td>
	                <a class="btn btn-primary" href="userDetail.html">詳細</a>
	                <a class="btn btn-success" href="userUpdate.html">更新</a>
	                <a class="btn btn-danger" href ="userDelete.html">削除</a>
	              </td>
	            </tr> -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	<p style="color: green">${delete}</p>

</body>
</html>
