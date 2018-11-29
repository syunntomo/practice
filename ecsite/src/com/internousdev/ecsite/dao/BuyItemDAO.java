package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private BuyItemDTO dto = new BuyItemDTO();

	//操作①
	public BuyItemDTO getBuyItemInfo(){

		/*id,item_name,item_priceを取り出す理由
		 * id･･･後のitem_transaction_idに必要なため
		 * item_name･･･buyItem.jspなどでの表示で必要になる
		 * item_price･･･料金計算など様々なところで必要になる */
		String sql = "select id,item_name,item_price from item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	//操作②
	public BuyItemDTO getBuyItemDTO(){
		return dto;
	}
}
