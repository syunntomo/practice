package com.internousdev.login.dto;

public class LoginDTO {
	private int id;
	//④DAOから送られたname=taro,password=123がsetterメソッドを使って定義される
	private String name;
	private String password;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
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
