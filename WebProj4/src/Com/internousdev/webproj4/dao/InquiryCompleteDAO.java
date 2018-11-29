package Com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.internousdev.webproj4.dto.InquiryDTO;
import Com.internousdev.webproj4.util.DBConnector;

public class InquiryCompleteDAO {
	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	//操作① List中にあるデータをActionクラスのListにデータを格納するために必要な操作
	public List<InquiryDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from inquiry";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//検索結果をDTOに格納し、さらにListに格納
			while(rs.next()){
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return inquiryDTOList;
	}

	//操作2 クライアントが入力したデータをDBに記入するための操作
	public int insert(String name, String qtype, String body){
		//返し値の初期値を0と設定する
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="insert into inquiry values(?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);
			//復習：executeupdate()メソッドは返し値が更新行数なので、int型変数になる
			int i = ps.executeUpdate();
			if(i > 0){
				System.out.println(i + "件登録されました");
				//初期値に更新件数(行数)を代入する
				ret = i;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		//返し値は更新件数(行数)
		return ret;
	}
}
