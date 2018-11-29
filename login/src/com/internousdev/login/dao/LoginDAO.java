package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
	//③dao.select()の実行 select(taro,123)
	public LoginDTO select(String name,String password) throws SQLException{
		//dtoにデータを送るためにインスタンス化が必要
		LoginDTO dto = new LoginDTO();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from user where user_name=? and password=?";

		try{
			//送信用インスタンスを形成
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name); //taroが入る
			ps.setString(2, password);  //123が入る
			ResultSet rs =ps.executeQuery();

			if(rs.next()){
				dto.setName(rs.getString("user_name")); //user表と一致したtaroが入る
				dto.setPassword(rs.getString("password")); //user表と一致した123が入る
			}
		} catch(SQLException e){
		e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}
	}
