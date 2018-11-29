//DBの処理を行うクラス  DAO...Data Access Objectの略

import java.sql.Connection;
//PreparedStatement...Statementの代わりに使われる
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestUserDAO {
	String name = "";
	String password = "";

//操作①
	public void select(String name,String password){

		//DBConnector.javaのインスタンス化とDBConnectorのgetConnctionメソッド（操作）の実行
		//これにより、mySQLへのコネクションがこの瞬間に行われる
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		// =?の意味...今のところは不明である、と捉えておく。SQL文としては成立していない
		String sql = "select * from test_table where user_name=? and password=?";

		try{
			//ここまではDAOとmysqlのコネクションを作っただけであり、実際のsql文を送信することを想定していない
			//よって、ここでsqlを送信できるようにprepareStatementを使いインスタンス化、送信できるようにしている

			//SQL送信用のインスタンスを作成する（窓口作成）Statement...SQL文の事
			//※※PreparedStatementは型名 prepareStatementはメソッドであることに注意　dがないのにも注意
			//prepareStatementメソッド...API PreparedStatementのメソッドの1つであり、?を持つSQL分の実行に必要
			PreparedStatement ps = con.prepareStatement(sql);

			//以下は、1個目の?にnameを代入してください、という意味
			//ここの変数に入るのはselect()に入っている変数
			ps.setString(1,name);
			ps.setString(2,password);

			//executeQuery(SQL文)　SELECT文を実行するのに使用する 下にexecuteUpdate文があるが用途が違うので注意
			//ResultSet...SQL文を送信/ステートメントを取得し、結果をテーブルの形で取得する
			//ResultSetはAPI PreparedStatementの１つ
			ResultSet rs = ps.executeQuery();

			//next()...ResultSetが持つメソッドの1つ、参照する表を1行分下にずらす
			//その行にデータが存在するならばTrue 存在しないならfalse を戻す
			if(rs.next()){
				//getString()を使って、表の列を参照しデータを取り出す
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			//DBの利用終了を伝える（DB接続の終了）、必ず書く
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	//操作②　
	public void selectAll(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//if文だと最初の1行のみ対応になるためselectAllにはならない。
			//while文より、rs.next()=Trueの限り、処理が繰り返される。基本はwhile文
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	//操作③
	public void selectByName(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	//操作④
	public void selectByPassword(String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select * from test_table where password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	//操作⑤
	public void updateUserNameByUserName(String oldName,String newName){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="update test_table set user_name=? where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);
			//executeUpdate(SQL文)
			//SELECT文以外に使用する、戻り値として何件処理されたの情報が得られる
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println(i+"件更新されました");
			}else{
				System.out.println("該当するデータはありませんでした");
			}
		}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}
				catch(SQLException e){
				e.printStackTrace();
			}
	    }


	//操作⑥
		public void insert(int user_id,String name,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="insert into test_table values(?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,user_id);
			ps.setString(2, name);
			ps.setString(3, password);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println(i+"件更新されました");
			}
		}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
	    }


		//操作⑦
				public void delete(String name){
				DBConnector db = new DBConnector();
				Connection con = db.getConnection();

				String sql ="delete from test_table where user_name=?";
				try{
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,name);
					int i=ps.executeUpdate();
					if(i>0){
						System.out.println(i+"件削除されました");
					}
				}catch(SQLException e){
						e.printStackTrace();
					}
					try{
						con.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
		}

