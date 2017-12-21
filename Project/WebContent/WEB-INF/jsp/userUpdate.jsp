<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.UserBean" %>
     <% UserBean human = (UserBean)request.getAttribute("UserBean"); %>


    <!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <META http-equiv="Content-Style-Type" content="text/css">
    <link href="./style.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザ更新画面</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- オリジナルCSS読み込み -->
    <link href="css/original/common.css" rel="stylesheet">
    <!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->

  </head>
  <body>

    <!-- header -->
    <header>

      <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
        <div class="container">
          <div class="container mr-auto">
            <a class="navbar-brand" href="LoginServlet">ユーザ管理システム</a>
          </div>
          <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav">
              <li class="nav-item active">
                <span class="navbar-text">
                  ユーザ名さん
                </span>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">ログアウト</a>
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
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="panel-body">
            <form method="post" action="userUpdateServlet" class="form-horizontal">
              <div class="form-group">
                <label for="user-id" class="control-label col-sm-2 label-color">ログインID</label>
                <div class="col-sm-6">
                  <input type="text" name="user-id" id="user-id" class="form-control" value=<%= human.getLoginId() %> required/>
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="control-label col-sm-2 label-color">パスワード</label>
                <div class="col-sm-6">
                  <input type="password" name="password" id="password" class="form-control" required/>
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="password-confirm" class="control-label col-sm-2 label-color">パスワード(確認)</label>
                <div class="col-sm-6">
                  <input type="password" name="password-confirm" id="password-confirm" class="form-control" required/>
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="user-name" class="control-label col-sm-2 label-color">ユーザ名</label>
                <div class="col-sm-6">
                  <input type="text" name="user-name" id="user-name" class="form-control" value=<%= human.getName() %> required/>
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="continent" class="control-label col-sm-2 label-color">生年月日</label>
                <div class="row">
                  <div class="col-sm-5">
                    <input type="date" name="birthDate" id="date-start" class="form-control" size="30" value=<%= human.getFormatBirthDate() %> required/>
                  </div>
              </div>
              </div>
              <div>
                <button type="submit" value="検索" class="btn btn-primary center-block form-submit">登録</button>
              </div>
            </form>
          </div>
        </div>
      </div>

      <div class="col-xs-4">
        <a href="UserlistServlet">戻る</a>
      </div>
      <p style="color: red">
	          ${er}


    </div>
  </div>
  </body>
</html>