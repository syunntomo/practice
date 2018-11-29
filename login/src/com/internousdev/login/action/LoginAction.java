package com.internousdev.login.action;

import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	//①login.jspからname,password(name=taro,passwore=123)が送られてくる
	private String name;
	private String password;
	//②struts.xmlよりexecute()の実行
	public String execute() throws SQLException{
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		//③dao.select()の実行 dao.select(taro,123) →LoginDAOへ
		//⑤DAOによる検索結果が、戻り値としてdtoに代入される
		dto = dao.select(name, password);
		//⑥dtoからgetterメソッドを使ってselect()に代入されている、name,passwordをequalsで比較する
		//今回はtaro,123で一致するので、SUCCESSが選ばれる
		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
				ret = SUCCESS;
			}
		}
		//⑦戻り値としてsuccessが戻る、戻る場所はstruts.xml
		return ret;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
}
