package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {

	public MyPageDTO getMyPageUserInfo(String item_transaction_id, String user_master_id)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		MyPageDTO dto = new MyPageDTO();

		//2つの表を結合/外部結合を行っている 詳細は下に記述する
		String sql = "SELECT iit.item_name, ubit.total_price, ubit.total_count, ubit.pay FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY ubit.insert_date DESC";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){ //ORDER BY insert_date DESCで並び返された一番上(最新データ)をDTOに代入,Actionクラスに送る
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}

	//操作② myPage.jspで削除ボタンが押されたときに使われるメソッド
	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//このsql文で注意するべきなのは、表示されているデータのみでなく今までの購入履歴が全て消される点
		//DELETE FROMはWHEREで合致した条件の「全て」のデータを削除する
		String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id = ?";

		PreparedStatement ps;
		int result = 0;

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);//商品ID
			ps.setString(2, user_master_id);//ユーザーID

			result = ps.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}

/*SELECT iit.item_name, ubit.total_price, ubit.total_count, ubit.pay  SELECT･･･これから作成する表に表示したい要素を記述する
 *FROM user_buy_item_transaction ubit  FROM･･･元になる表を記述(左側)  ※表の名前(半角)○○で省略名を記述することができる
 *LEFT JOIN item_info_transaction iit  LEFT JOIN･･･結合したい表を記述(右側)  ※表の名前(半角)○○で省略名を記述することができる
 *ON ubit.item_transaction_id = iit.id  ON...結合の条件を記述 左では商品情報のidを＝で結んでいる
 *WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ?  WHERE...表の抽出条件の記述
 *ORDER BY ubit.insert_date DESC  ORDER BY...並び替え 左ではinsert_date の降順に並べよ、という条件になっている
 * */
