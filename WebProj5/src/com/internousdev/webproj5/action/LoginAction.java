package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//セッションに必要なものをimport
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.LoginDAO;
import com.internousdev.webproj5.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//SessioAwareインターフェースを実装して、セッションできるようにする
//実際には実装されていないように見えるが、ActionSupportが必要な情報を持っている
public class LoginAction extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	//セッションを利用する際のデータ格納法を明示
	private Map<String,Object> session;

	public String execute(){
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao =new LoginDAO();

		//返し値はList
		loginDTOList = dao.select(username, password);
		if(this.username.equals(loginDTOList.get(0).getUsername()) && this.password.equals(loginDTOList.get(0).getPassword())){
			//セッションに必要な情報を以下に格納　putはpushの事
			session.put("loginDTOList", loginDTOList);
			ret = SUCCESS;
		} else {
			session.put("loginDTOList", loginDTOList);
			ret = ERROR;
		}

		return ret;
	}

	//下に書かれている操作は全てvalue stackとの操作である
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

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}

/* セッションについて
 * クライアントとサーバ間の一連のやり取りの事を言う
 * 何もしなければ、サーバー側はクライアント側を認識する機能は存在しないため、ショッピングサイト等の場合、情報保持をすることが困難になる
 * 上のSessionAwareは、そのようなクライアントサーバ間の情報保持をするための方法であると理解しておく
 *
 * また、cookieがクライアント側の情報保持に対し、セッションはサーバー側の情報保持であり、セキュリティ関連からも推奨されていることも覚えておく
 *
 * 必要な情報は以下に記述、わからなくてもこのように書けば問題はない
 *
 * SessionAwareインターフェースの実装
 * public class SampleSessionAction extends ActionSupport implements SessionAware {

	格納先をMapにするために、以下のように書く
    private Map<String, Object> session;

   （@Override
    public void setSession(Map<String, Object> session) {
        this.session = session;）
    }
}

	Mapへの格納方法は以下
	session.put("key", value);
 */

