package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object>session;
	private int count; //左2つはbuyItem.jspで記述
	private String pay;

	public String execute(){

		String result = SUCCESS;
		session.put("count", count);//countはすぐにsession格納
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString()); //Object型にデータ型は付加なのでオブジェクト内に格納
		int intCount = Integer.parseInt(session.get("count").toString());
		session.put("total_price",intPrice * intCount); //合計をsession格納
		String payment;

		if(pay.equals("1")){ //ラジオボタンの種類によりsessionへの格納が変更されるので、ココは分岐を使う
			payment = "現金払い";
			session.put("pay", payment);
		} else {
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	//ValueStackへの格納のみを行う

	public void setCount(int count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
