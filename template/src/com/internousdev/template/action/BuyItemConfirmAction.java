package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	public String execute() throws SQLException{
		BuyItemCompleteDAO dao = new BuyItemCompleteDAO();

		//全てのログイン情報と商品情報はセッション中に与えられている
		//つまり、最低でもbuyItemInfoに必要な情報をセッション中に入れられればよい。てか、ValueStackでいちいち引き継ぐより楽

		dao.buyItemInfo(session.get("id").toString(),session.get("login_user_id").toString(), session.get("buyItem_price").toString(),session.get("stock").toString(),session.get("pay").toString());

		String result = SUCCESS;

		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
