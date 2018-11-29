package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public String deleteFlg;
	private String result;

	public String execute() throws SQLException{
		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();

		//下の操作はdeleteFlgによって分岐している
		//deleteFlg=nullなら購入情報をセッションに代入 / deleteFlg="1"ならAction内のdelete()メソッドの実行

		//分岐①
		if(deleteFlg == null){
			String item_transaction_id = session.get("id").toString(); //item_info_transaction の 固有id
			String user_master_id = session.get("login_user_id").toString(); //login_user_transaction のlogin_user_idのこと

			dto = dao.getMyPageUserInfo(item_transaction_id, user_master_id); //DAOの検索結果をセッションに代入
			session.put("buyItem_name", dto.getItemName()); //左の4つに入れられているデータは最新データのみ！(sql文のORDER BY insert_date DESCの効果)
			session.put("total_price", dto.getTotalPrice());
			session.put("total_count", dto.getTotalCount());
			session.put("total_payment",dto.getPayment());
			session.put("message", "");

		//分岐②
		} else if(deleteFlg.equals("1")){ //隠しデータ(input type="hidden")によって送られたデータで判断
			delete(); //現クラス内のdelete()メソッドの実行
		}
		result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{

		MyPageDAO dao = new MyPageDAO();

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString(); //削除に必要な情報はセッション内にあり

		int res = dao.buyItemHistoryDelete(item_transaction_id, user_master_id);

		if(res > 0){
			session.put("message", "商品を正しく削除しました。");
		} else if(res==0){
			session.put("message","商品情報の削除に失敗しました。");
		}
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setSession(Map<String,Object>loginSessionMap){
		this.session = loginSessionMap;
	}
}
