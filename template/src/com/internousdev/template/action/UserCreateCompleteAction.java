package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object> session;


	public String execute() throws SQLException{
		UserCreateCompleteDAO dao = new UserCreateCompleteDAO();

		//session内の値はObjectのため、toString()メソッドで文字化する必要がある
		dao.createUser(session.get("loginUserId").toString(),session.get("loginPassword").toString(),session.get("userName").toString());

		String result = SUCCESS;

		return result;
	}

	//全ての情報を受け取っている、またログイン情報のためここの値は別ページでも使われる
	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
