<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<meta http-equiv="Content-Script-Type" content="text/javascript" />
		<meta http-equiv="imagetoolbar" content="no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />

		<title>BuyItemComplete画面</title>

		<style type="text/css">
		body {
			margin: 0;
			padding: 0;
			line-height: 1.6;
			letter-spacing: 1px;
			font-family: Verdana, Helvetica, sans-serif;
			font-size: 12px;
			color: #333;
			background: #fff;
		}

		table {
			text-align: center;
			margin: 0 auto;
		}

		#top {
			width: 780px;
			margin: 30px auto;
			border: 1px solid #333;
		}

		#header {
			width: 100%;
			height: 80px;
			background-color: black;
		}

		#main {
			width: 100%;
			height: 500px;
			text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear: both;
		}

		#test-right{
			display: inline-block;
			text-align: right;
			}

		</style>
	</head>
	<body>

		<div id="header">
			<div id="pr">
			</div>
		</div>

		<div id="main">
			<div id="top">
				<p>MyPage</p>
			</div>

			<div>
				<s:if test="myPageList==null">
					<h3>ご購入情報はありません。</h3>
				</s:if>
				<s:elseif test="message==null">
					<h3>ご購入情報は以下になります。</h3>
					<table border="1">

						<tr>
							<th>商品名</th>
							<th>値段</th>
							<th>購入個数</th>
							<th>支払い方法</th>
							<th>購入日</th>
						</tr>

						<!-- s:iterator List型配列など複数情報ある場合（ループ）に便利なタグ
							 例えば、リスト型配列に2件あった場合、以下の書き方ではどちらの配列の中身をさしているのかわからない
							 その場合に、s:iteratorを使えは、リスト型配列の最初から順々に参照した上で、データを取り出すことが可能になる -->

						<!-- 下のmyPageListは ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>(); で定義されたもの-->

						<s:iterator value="myPageList">

							<tr>
								<td><s:property value="itemName"/></td>
								<td><s:property value="totalPrice"/><span>円</span></td>
								<td><s:property value="totalCount"/><span>個</span></td>
								<td><s:property value="payment"/></td>
								<td><s:property value="insert_date"/></td>
							</tr>
						</s:iterator>
					</table>

					<s:form action="MyPageAction">
						<input type="hidden" name="deleteFlg" value="1"> <!-- 削除ボタンを押すと、deleteFlg=1の情報も一緒に送られる -->
						<s:submit value="削除"/> <!-- method...execute()以外を指定するときに必要？他にも設定がいるみたい -->
					</s:form>
				</s:elseif>

				<s:if test="message != null"> <!-- ここはmyPageActionのmessageを参照している -->
					<h3><s:property value="message"/></h3>
				</s:if>

				<div id="text-right">
					<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
					<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>

		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
</html>