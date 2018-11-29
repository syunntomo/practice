package Com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Com.internousdev.webproj4.dao.LoginDAO;
import Com.internousdev.webproj4.dto.LoginDTO;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();

	public String execute(){
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();

		//dao.select()メソッドの返し値はloginDTOList
		LoginDTOList = dao.select(username, password);

		//listオブジェクト名.get(インデックス)･･･オブジェクトの(インデックス)番目のデータを取得せよ、という意味
		//つまり、LoginDTOListの0番目のgetUsername()メソッドを実行して、現オブジェクトのusernameと取得したusernameを比較せよ、と言っている

		//ここで、get(0)で記述をやめると、配列[0]にはusernameとpasswordの両方の情報が格納されているため、PCはどちらの情報を参照すればいいかわからず、
		//結果、getterメソッドは不発に終わる

		//this.usernameはwelcome.jspで送られたデータ、LoginDTO.get.getUsername()は検索結果を取り出したデータ
		//LoginDTO型なので、LoginDTO.javaにあるgetUsername()メソッドを使ってusernameのデータを取り出している
		if(this.username.equals(LoginDTOList.get(0).getUsername()) && this.password.equals(LoginDTOList.get(0).getPassword())){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

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
		return LoginDTOList;
	}

	public void setLoginDTOList(List<LoginDTO> loginDTOList){
		LoginDTOList = loginDTOList;
	}
}
