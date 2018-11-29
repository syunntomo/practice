package Com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//下二つは、おそらく配列を使うときに使う必要のあるもの
import java.util.ArrayList;
import java.util.List;

import Com.internousdev.webproj4.dto.HelloStrutsDTO;
import Com.internousdev.webproj4.util.DBConnector;

public class HelloStrutsDAO {

	//こちらでも配列を作るが、ActionクラスはHello こっちはhello 大文字小文字でオブジェクト名が異なっている
	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	public List<HelloStrutsDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select * from users";

		//try~catch直前までの流れ
		//sql文を実行し検索、その検索結果をDAOにセッティングを行い、検索結果に該当したデータ全てをListにその情報を加えている
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();

			//while文なので、該当したデータ全てが対象になっている
			while(rs.next()){
				HelloStrutsDTO dto = new HelloStrutsDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				dto.setResult("MySQLと接続できます。");
				//公式: オブジェクト名.add()でリストに追加することができる
				//「helloStrutsDTOListにdtoを加える」とは、dtoは user_id, user_name, password, result の結果が格納
				//されているので、それらの要素を全てリストに加え入れるという意味である
				helloStrutsDTOList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//返し値として、Listオブジェクトを返している
		return helloStrutsDTOList;
	}

}
