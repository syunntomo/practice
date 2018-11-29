package Com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Com.internousdev.webproj4.dao.InquiryCompleteDAO;
import Com.internousdev.webproj4.dto.InquiryDTO;

public class InquiryCompleteAction extends ActionSupport{
	private String name;
	private String qtype;
	private String body;

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public String execute(){
		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();
		int count = dao.insert(name, qtype, body);

		//DBへの格納が成功した場合は、その内容を配列の中に格納する、という文が下にある
		//配列にデータを格納することができれば、struts.xmlに対してsuccessという返し値を送る
		if(count > 0){
			inquiryDTOList = dao.select();

			ret = SUCCESS;
		}
		return ret;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getQtype(){
		return qtype;
	}

	public void setQtype(String qtype){
		this.qtype = qtype;
	}

	public String getBody(){
		return body;
	}

	public void setBody(String body){
		this.body = body;
	}

	public List<InquiryDTO> getInquiryDTOList(){
		return inquiryDTOList;
	}

	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList){
		this.inquiryDTOList = inquiryDTOList;
	}
}
