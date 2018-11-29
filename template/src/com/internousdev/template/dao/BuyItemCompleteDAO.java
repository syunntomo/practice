package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class BuyItemCompleteDAO {

	private DateUtil du = new DateUtil();

	//user_buy_item_transactionのidはauto_incrementのため変数代入の必要はない
	//ただし、そのままだと左側から順に入れられてしまうため、sql文で変数の指定が必要となる

	private String sql ="INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)VALUES(?,?,?,?,?,?)";

	//item_transaction_id は商品の固有IDのこと

	public void buyItemInfo(String item_transaction_id, String user_master_id, String total_price, String total_count,String pay) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id); //session.get("id").toString();
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, du.getDate());

			ps.execute();

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
