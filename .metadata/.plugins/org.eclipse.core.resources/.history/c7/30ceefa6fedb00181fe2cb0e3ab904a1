/* HomeActionが難しくしているのは、セッション情報の保持状態(通常の流れだと、アイテム購入後のホーム画面)に関しても対応しているため*/

package com.internousdev.ecsite.action;

import java.util.Map;//sessionに必要

import org.apache.struts2.interceptor.SessionAware;//sessionに必要

import com.internousdev.ecsite.dao.BuyItemDAO;//商品情報に必要
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;//Actionに必要

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public String execute(){

		String result = "login"; //初期値をlogin･･･loginされておらず、login.jspにいくぞという意味

		//containsKey("○○")メソッド･･･○(key)に値が入っていればtrue 入っていなければfalseを返す
		//ここでログインの有無に関する情報はidで行われていることになる
		//idはLogin.Action中でログイン成功後にセッションに格納されている変数であるため、
		//idでログイン認証されているかどうかを確認することは論理的に正しい

		//if文内の上5行に注目(商品情報取得)、これはログインが確認された後に行う操作なので、LoginActionを見るとログイン成功後に同じ操作を行っている
		//ただひとつ違う点は、すでにログインを行っているため、login_user_idのセッション格納は行っていない点
		if(session.containsKey("id")){
			BuyItemDAO dao = new BuyItemDAO();
			BuyItemDTO dto = dao.getBuyItemInfo();
			session.put("id", dto.getId()); //商品情報を得られたと同時にsession格納
			session.put("buyItemName", dto.getItemName());
			session.put("buyItem_price", dto.getItemPrice());

			result = SUCCESS;
		}
		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return session;
	}

}
