<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloStruts</title>
</head>
<body>
	<h1>HelloStruts2!</h1>
	<br>

	<table>
		<!-- tbodyとはテーブルボディのこと、bodyの主内容が表であることをあらわす -->
		<!-- この下は該当データを表に表せるように下地を作っている -->
		<tbody>
			<tr>
				<th>USERID</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>RESULT</th>
			</tr>

			<!-- s:iterator(イテレーター)  Listのデータの中身を取り出すのに必要なタグ 簡単に言うと配列の最初から順番に参照しろー的なやつ-->
			<!-- s:interatorで配列を順番に参照した上で、s;propertyタグを使って該当する検索データを全て表記するという流れ -->
			<s:iterator value="helloStrutsDTOList">
				<tr>
					<td><s:property value = "userId"/></td>
					<td><s:property value = "userName"/></td>
					<td><s:property value = "password"/></td>
					<td><s:property value = "result"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>