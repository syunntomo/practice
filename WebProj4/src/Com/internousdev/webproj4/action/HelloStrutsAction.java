package Com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Com.internousdev.webproj4.dao.HelloStrutsDAO;
import Com.internousdev.webproj4.dto.HelloStrutsDTO;

public class HelloStrutsAction extends ActionSupport{

	//List 基本形：List<データ型>オブジェクト名 = new ArrayList<データ型>();
		//配列と特徴は良く似ているが、配列の長さは不変に対し、Listの長さは可変
		//また、配列は追加・削除・検索ができないのに対して、Listはこれを行うことができる
		//参考URL:https://eng-entrance.com/java-array-list#List

	private List<HelloStrutsDTO> HelloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	public String execute(){
		String ret = ERROR; //初期値はエラー
		HelloStrutsDAO dao = new HelloStrutsDAO(); //データ検索のためにDAOインスタンス化

		//dao.select();の返し値はhelloStrutsDTOList(データの入ったListオブジェクト)
		//hとHでオブジェクト名が異なっていることに注意する
		HelloStrutsDTOList = dao.select();

		if(HelloStrutsDTOList.size() > 0){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	public List<HelloStrutsDTO> getHelloStrutsDTOList(){
		return HelloStrutsDTOList;
	}

	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList){
		HelloStrutsDTOList = helloStrutsDTOList;
	}
}
