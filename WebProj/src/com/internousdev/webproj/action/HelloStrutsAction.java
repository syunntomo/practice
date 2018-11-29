package com.internousdev.webproj.action;

//下はStruts2が問題なくデータのやり取りができるようにするもの
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport{
	public String execute(){
		return SUCCESS;
	}
}
