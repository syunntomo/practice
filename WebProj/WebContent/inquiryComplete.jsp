<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>お問い合わせ  受付完了</title>
</head>
<body>

<br>
<s:property value="name" />さん、お問い合わせありがとうございました。
<br>

<br>お問い合わせの種類:<br>

<!-- qtype･･･name属性　company･･･option中のvalue属性 -->
<!-- s:ifタグ test内に条件を書いていく -->

<!-- 例えば、下の場合はname属性qtype＝companyが成立したときは「会社について」をjspファイルに記述 -->
<s:if test='qtype=="company"'>
会社について
</s:if>

<!-- 同様に下の場合はname属性qtype==productが成立したときは「製品について」をjspファイル内に記述 -->
<s:if test='qtype=="product"'>
製品について
</s:if>

<s:if test='qtype=="support"'>
アフターサポートについて
</s:if>
<br>

<br>お問い合わせ内容<br>
<!-- 下はs:propertyなので、inpuiry.jsp内のname属性body中のデータがここに代入されるということ -->
<s:property value="body"/>

</body>
</html>