<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <META http-equiv="Content-Style-Type" content="text/css">
    <link href="./style.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザ削除画面</title>
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
                <a class="nav-link" href="LogoutServletl">ログアウト</a>
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
          <font size="4">

          <p class = "label-color">ログインID:${UserBean.loginId}</p>
          <p class = "label-color">を本当に削除してもよろしいでしょうか。</p>

        </font>
          <div class="text-center">
            <a class="btn btn-default form-submit" href="UserlistServlet">いいえ</a>
            <form method="post" action="userDeleteServlet">
            <INPUT TYPE="HIDDEN"  NAME="id" VALUE="${UserBean.loginId}" />
            <input class="btn btn-primary form-submit" type=submit value=はい>
            </form>
          </div>
        </div>
      </div>


      <div class="col-xs-4">
        <a href="UserlistServlet">戻る</a>
      </div>
    </div>
  </div>
  </body>
</html>