<!-- 気になったポイントを書いていく -->


<!--ディレクティブ JSP/サーブレットコンテナに対する指示を行う  -->
<!-- 属性名＝属性値　注意:属性値は数値であろうと必ず""で囲むことに注意する -->
<!-- page:現在のページの処理内容を指定している -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset = "utf-8">
	<title>TEST</title>
	</head>
	<body>
	<p>こんにちは！</p>
	<!-- 「<%! %>」は宣言部と言われる。変数・定数、ユーザー定義メソッドなどの宣言を行う -->
	<!-- 「<% %>」で囲まれた部分をスクリプトレットという。JAVA言語を書く時は宣言を行ってから -->
	<!-- スクリプトレット内はJSPページの実行時に行われ、処理内容のみが表示される -->

	<!-- JAVAとは少し異なり、Systemが取れたout.println宣言でコードを書いていく -->
	<!-- out.printlnを省略する書き方もある voidメソッド、変数宣言のみで使用は不可-->
	<% out.println(new java.util.Date()); %>


<!-- 宣言とスクリプトレットによる変数の動き -->

	<!-- 宣言部は初めてJSPページが呼び出されたときに初期化され、Tomcatが動いているうちは有効化される -->
	<%! static int countA=0; %>

	<!-- スクリプトレットのときはJSPページが呼び出される度に初期化される -->
	<%
	int countB=0;
	countA++;
	countB++;
	%>
<!-- この違いにより、更新ボタンを押したときに挙動が変化するようになる -->
<!-- 宣言文…更新ボタンを押すたびに1増加　スクリプト…ずっと1のまま -->
	<p>宣言による変数countA=<%=countA %></p>
	<p>スクリプトレットによる変数 countB=<%=countB %></p>




	</body>
</html>

<!-- Math.random()メソッド…乱数 -->