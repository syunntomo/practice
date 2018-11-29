<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>TEST</title>
</head>
<body>
<br>

<!-- 下のs:property()メソッドを使うことによって、TestAction.getUsername()が実行される -->
<!-- value内にindex.jspで名付けたname属性を書くことにより、そのgetterメソッドが実行 -->
<!-- sタグで重要なのは、name属性は保持されるというところ -->

<!-- 公式　s:property value="要求データのあるname属性" -->

<s:property value="username"/>
<br>
<s:property value="password"/>
</body>
</html>