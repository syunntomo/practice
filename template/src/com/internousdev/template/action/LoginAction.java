package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String,Object> session;

	public String execute(){
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		result = ERROR; //初期値はエラー
		loginDTO = loginDAO.gerLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		/*loginUserの中身はloginDTOだが、一度Object型にはまってしまったので、自身は忘れている
		 * よって、()で思い出させ、LoginDTOのgetLoginFlgメソッドを使えるようにする
		 * また、if文はtrue/falseで判断するため、getLoginFlgはこれを満たす*/

		//LoginDTOのgetLoginFlgメソッドを使って、DAOでログインが上手くいっているのか確認
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS; //SUCCESSを返す
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			//ユーザーIDと商品情報を各々セッションに格納
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId()); //item_info_transaction のidをセッションに格納
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

			return result; //上手くいったときのsuccess返し
		}
		return result; //だめだったときのerror返し
	}

	//この3つのメソッドは、外から情報を得ており、次のJSPのときに出力する
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

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
