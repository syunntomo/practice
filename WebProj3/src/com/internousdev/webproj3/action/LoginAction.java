package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.LoginDAO;
import com.internousdev.webproj3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	//sタグ効果でwelcome.jspで送られた情報はname属性で紐付いた下のフィールドに代入される
	private String username;
	private String password;

	public String execute(){
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		//sタグの効果よりusername passwordにはwelcome.jspで書かれたデータは勝手に代入される
		//daoのselect()メソッドにデータを送る　返し値はSUCCESS or ERROR
		dto = dao.select(username, password);

		if(this.username.equals(dto.getUsername()) && this.password.equals(dto.getPassword())){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
}
