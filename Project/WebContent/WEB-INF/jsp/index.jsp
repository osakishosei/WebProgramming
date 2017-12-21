<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import = "model.UserBean" %>



	<!DOCTYPE html>
	<html lang="ja">
	  <head>
	    <meta charset="utf-8">
	    <META http-equiv="Content-Style-Type" content="text/css">
	    <link href="./style.css" rel="stylesheet" type="text/css">

	    <!-- BootstrapのCSS読み込み -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <!-- Jqeryの読み込み -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	    <!-- BootstrapのJS読み込み -->
	    <script src="js/bootstrap.min.js"></script>
	    <!-- レイアウトカスタマイズ用個別CSS -->

	    <title>ログイン画面</title>

	  </head>


	  <body>
	    <!-- header -->
	    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
	      <div class="container">
	        <div class="container mr-auto">
	          <a class="navbar-brand" href="LoginServlet">ユーザ管理システム</a>
	        </div>

	      </div>

	    </nav>
	    <!-- /header -->

	    <!-- body -->
	<div class="container margin">
		  <div class="row login_box">
		    <div class="col-md-12 col-xs-12" align="center">
	            <div class="outter"><img src="http://lorempixel.com/output/people-q-c-100-100-1.jpg" class="image-circle"/></div>
	            <h1 class="label-color">Hi Guest</h1>
		    </div>

			<p style="color: red">
	          ${er}
	          ${Logout}
	        </p>

	        <div class="col-md-12 col-xs-12 login_control">
	        <form action="LoginServlet" method = "post">

	                <div class="control">
	                    <div class="label">ログインID</div>
	                    <input type="text" name="id" class="form-control"/>
	                </div>

	                <div class="control">
	                     <div class="label">パスワード</div>
	                    <input type="password" name="pass" class="form-control"
	                    />
	                </div>
	                <div align="center">
	                		<input type="submit" value="送信する" class="btn btn-orange">
	                </div>
	      	</form>


	        </div>



	  </div>
	</div>

	  </body>
	</html>
