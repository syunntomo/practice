<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 下記はsタグを使うのに必要な分 -->
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<s:form action="LoginAction">
		<!-- input type=""という風にやる必要はない sタグの効果 -->
		<!-- name,passwordのname属性を持ったままLoginActionに送られる＝勝手に代入される -->
		<s:textfield name="name"/>
		<s:password name="password"/>
		<s:submit value="ログイン"/>
	</s:form>
</body>
</html>