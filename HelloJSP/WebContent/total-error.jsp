<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--このページはエラーページですよ、と宣言している-->
<!-- page isErrorPage=true は上を宣言する定型文 -->
<%@page isErrorPage="true" %>

<p>数値を入力してください。</p>
<!-- history.back()メソッドは、履歴のひとつ前のページに戻るメソッド -->
<!--bottonタグはボタンを作成することができる-->
<!-- onclickはボタンを押したときにhistory.back()メソッドが発動する事を指示している -->
<button onclick="history.back()">戻る</button>
<br>

<!-- エラー内容の表示が行われている -->
<p><%=exception %></p>
<!-- table borderでエラーテーブルの作成 -->
<table border=1>
    <tr>
		<td><strong>エラーメッセージ</strong></td>
		<!-- exceptionのgetMessage()メソッドで原因の表示 -->
		<td><%= exception.getMessage() %></td>
	</tr>
	<tr>
		<td><strong>例外を文字列に変換</strong></td>
		<!-- javaの例外対象を文字列で表示-->
		<td><%= exception.toString() %></td>
	</tr>
	<tr>
	<!-- プログラムの実行された情報を時系列順にしたものをスタックトレースという -->
		<td><strong>スタックトレース</strong>
		<td>
		<!-- 下の一文はスタックトレースを文字列にしたいときに使う一文だと覚えておく-->
		<!-- 詳細を調べようとしたが、難しくてわからなかった -->
		<%
		exception.printStackTrace(new java.io.PrintWriter(out));
		%>
		</td></tr>
</table>
</body>
</html>