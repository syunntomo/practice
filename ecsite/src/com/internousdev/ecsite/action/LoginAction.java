package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO(); //なぜ今回はprivateにしたのか？
	private LoginDTO loginDTO = new LoginDTO(); //ログイン情報/商品情報は変えられたくない重要項目だから？
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR; //初期値ログイン失敗
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);//ログイン情報（全）を格納,3行下で使用

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){ //1度Object型に入れられているので、LoginDTO型のメソッドを使いたいときは無理やり型変換
			result = SUCCESS; //ログイン成功(Struts.xml向け)
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo(); //商品情報の取得

			session.put("login_user_id",loginDTO.getLoginId()); //ここがHomeActionのログイン済の操作と唯一違う点
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}

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

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
