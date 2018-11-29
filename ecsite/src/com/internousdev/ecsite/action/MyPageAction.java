package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList; //新
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private MyPageDAO dao = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>(); //新
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("id")){ //ログインがなされていない セッションの設定時間経過後に発生するイベント？
			return ERROR; //error.jspへ
		}

		//MyPageActionはマイページの参照と削除の2つの機能をもつため、その判断基準が必要になる(deleteFlg)
		if(deleteFlg==null){ //ワンクッション入れなくても大丈夫だった、ということはわかり易くする為に文章分けを行ったと考えてよい
			myPageList = dao.getMyPageUserInfo(session.get("id").toString(),session.get("login_user_id").toString());//返し値はリスト型配列
		} else if(deleteFlg.equals("1")){
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();//この2つも実は不要 下に直接session.getで入れればよい

		int res = dao.buyItemHistoryDelete(item_transaction_id, user_master_id);//返し値は更新件数

		if(res > 0){
			setMessage("商品情報を正しく削除しました。");
		} else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList(){ //myPage.jspで使うのでgetter必要
		return this.myPageList;
	}

	public String getMessage(){ //ここでsetMessageした情報をjspに送る必要がある
		return this.message;
	}

	public void setMessage(String message){
		this.message = message;
	}
}
