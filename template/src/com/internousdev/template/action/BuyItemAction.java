package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private int stock;//購入個数
	private String pay; //支払い方法  左2つは前ページのbuyItem.jspで初めて選んだ変数
	public Map<String,Object> session; //他のオブジェクトでも使うからpublic･･･？
	private String result;

	public String execute(){

		result = SUCCESS;

		session.put("stock", stock); //購入個数をセッションへ

		/* 1.Sessionの値をsession.get()メソッドで取り出す
		 * 2.Object型変数をtoString()メソッドを使い文字型変数に変換
		 * 3.Integer.parseInt()メソッドを使い、int型に変換
		 * 4.ラッパークラスIntegerにより、int型のインスタンス化が可能になったので、intStock/intPriceに値を入れる
		 * 5.インスタンス化によりセッションのObject型に値を入れることが可能になる 結果をセッションに保存*/
		int intStock = Integer.parseInt(session.get("stock").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("buyItem_price", intStock * intPrice);

		String payment;

		if(pay.equals("1")){ //この1はvalue="1" ここでの分岐のためにvalueで値付けをした
			payment = "現金払い";
			session.put("pay", payment); //結果的にログイン情報/商品情報は全てセッションに保存したことになる
		} else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	//上2つはstock/payでやり取りをしている sessionはそのほかの変数buyItem_priceなどで取り込み次ページでも使う
	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
