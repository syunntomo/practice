package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
//キーに対してキーに紐づく値を保持することができるコレクション(配列サイズを変更できる動的配列の事)の１つ
//Listと異なる点はMapは連想配列である点　またMapは参照型(データを保持せず、格納場所を保持している)のみ可能
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.HelloStrutsDAO;
import com.internousdev.webproj5.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport implements SessionAware{

	private List<HelloStrutsDTO>helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	// 新公式 Map<データ型, データ型>Mapの名前   以下ではString型は連想配列のキー Object型はデータ sessionはMapの名前
	private Map<String, Object> session;

	public String execute(){
		String ret=ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO();

		//戻り値はDAO内で作ったList
		helloStrutsDTOList = dao.select();

		if(helloStrutsDTOList.size()>0){
			//putメソッド公式･･･Mapの名前.put(キー名,値)　第一引数にキーを指定、第二引数にキーに関連付けられる値を指定
			//putは配列内に要素を格納するためのメソッドである
			//下の場合は"helloSTrutsDTOList"のキー値とhelloStrutsDTOListというオブジェクト内のデータを関連付けて要素を格納する、ということ
			session.put("helloStrutsDTOList", helloStrutsDTOList);
			ret=SUCCESS;
		}else{
			ret=ERROR;
		}
		return ret;
	}

	//下の操作はvalue stackとのやり取りに必要なデータを書いていく
	//Actionクラスで扱うデータについて書いていく？のかをこれから注視してコードを書いていく
	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
