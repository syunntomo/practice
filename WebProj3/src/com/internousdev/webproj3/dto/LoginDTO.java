package com.internousdev.webproj3.dto;

public class LoginDTO {
	//DAOがsetterメソッドを使って、検索結果をDTOフィールドにセットする
	private String username;
	private String password;

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
