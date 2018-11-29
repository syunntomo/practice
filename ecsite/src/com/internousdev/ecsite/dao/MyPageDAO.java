/*初級と異なる点は、ページリストを複数件表示することにある
 *複数件表示するためには、新しい技術のArrayListを使うことになる*/

package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; //複数件のデータリスト作成に必要

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection(); //getMyPageUserInfo()とdelete()の共用メソッドのため外に書く

	//返し値のデータ型がArrayList<MyPageDTO>なので、下のようになる
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{

		/* リスト型配列･･･可変長の配列
		 * 基本： ArrayList<データ型> オブジェクト名 = new ArrayList<データ型> で作成
		 * 必要な理由･･･今回の購入履歴は複数件表示することを想定、そのためには情報を複数件持つための工夫が必要になる
		 * 				今回はリスト型配列を用いる事で、目的を達成している*/
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){ //今回はwhile文のため、購入履歴全てが対称になる(初級はif文であった)
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto); //最後に上6つの情報をmyPageDTO型の可変長List型配列に代入 2件目以降は上書きされながらリスト配列に代入されていく .add()メソッドでリスト型配列に代入
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException{ //Connectionまでは上のメソッドと共用

		String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";

		PreparedStatement ps;
		int result = 0;

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
