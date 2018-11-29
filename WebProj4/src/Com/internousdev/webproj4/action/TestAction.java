package Com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Com.internousdev.webproj4.dao.TestDAO;
import Com.internousdev.webproj4.dto.LoginDTO;

public class TestAction extends ActionSupport{
	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public String execute(){
		String ret = ERROR;

		TestDAO dao = new TestDAO();
		//dao.insertの返し値はint型･･･更新件数
		int count =dao.insert(username, password);

		if(count > 0){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}

		loginDTOList = dao.select(username,password);

		return ret;
	}

	//username password はjspからの受信データやdaoに対してのデータ送信に使う
	//loginDTOList はActionクラスへデータ送信等に用いる ので、下に操作を書いてvalue stackへの道筋を書く必要がある

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

	public List<LoginDTO> getLoginDTOList(){
		return loginDTOList;
	}

	public void setLoginDTOList(List<LoginDTO> loginDTOList){
		this.loginDTOList = loginDTOList;
	}


}
