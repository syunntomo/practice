<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>HelloServlet</title>
</head>
<body>
	<input type = "button" value="HelloServlet" onClick="location.href='HelloServlet'">
	<input type="button" value="WelcomeServlet" onClick="location.href='welcome.jsp'">
	<input type="button" value="問い合わせ" onClick="location.href='inquiry.jsp'">
	<input type="button" value="MySQLServlet" onClick="location.href='MySQLServlet'">
	GET通信
	<form method="get" action="TestServlet">
	<input type="text" name="username">
	<input type="password" name="password">
	<input type="submit" value="送信">
	</form>
	POST通信
	<form method="post" action="TestServlet">
	<input type="text" name="username">
	<input type="password" name="password">
	<input type="submit" value="送信">
	</form>
</body>
</html>


<!--ただのHTMLファイル　データを送信するためのページ  -->
<!-- データの流れ　参照url:https://codezine.jp/article/detail/1481 -->
<!-- JSP…Java Server Page サーブレットと同じくサーバ上で動作させるもの -->