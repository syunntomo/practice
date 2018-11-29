package com.internousdev.webproj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class InquiryCompleteDAO {
	public int insert(String name, String qtype, String body){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="insert into inquiry values(?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);

			//executeUpdateの返し値は更新行数なので、int型になる
			int i = ps.executeUpdate();
			if(i > 0){
				//↓これはどこに出力される？
				System.out.println(i+"件登録されました");
				ret = i;
			}

		} catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
}
