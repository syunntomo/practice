<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 例外が起きた時にどのページに飛ばすかを指定している -->
<!-- page errorPage="エラーページのパス" -->
<%@page errorPage="total-error.jsp" %>

<%
//request...JSPで使用できる、宣言する必要のない暗黙オブジェクトの1つ
//setCharacterEncoding(String)...パラメータ値をエンコードする際のエンコード方式を指定
//エンコード...符号化とも言う、アナログデータをデジタルデータに変換
request.setCharacterEncoding("utf-8");

//Integer.parseInt(String)...String型の変数をint型に変換する
//request.getParameter(String)...因数にパラメータ名を指定、値を取得する
//int型にしないと計算ができないので、request.getParameterでindex.jspから送られた
//String型の値を受け取り、即int型に変換している
int price=Integer.parseInt(request.getParameter("price"));
int count=Integer.parseInt(request.getParameter("count"));
int delivery=Integer.parseInt(request.getParameter("delivery"));
%>

<!-- price count deliveryはJAVAプログラム内で得た値なので、その変数も宣言を行う必要がある -->
<%=price %>x<%=count %>個+送料<%=delivery %>円＝<a></a>
<%=price*count+delivery %>円
</body>
</html>