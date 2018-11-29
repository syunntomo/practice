package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public String execute(){
		session.clear(); //今までsessionで保存された情報が「全て」削除＝ログイン情報/商品情報の全消去
		return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
