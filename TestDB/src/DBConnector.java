//DBConnector...mySQLにつなぐためのプログラムを書いていく


//使用する外部ライブラリをimport

//connection...特定のデータベースとの接続を表現する、接続のコンテキスト内でSQL文が実行される
import java.sql.Connection;
//DriverManager...一連のJDBCドライバを管理するための基本的なサービス
import java.sql.DriverManager;
//SQLException...データベース・アクセス・エラーまたはその他のエラーに関する情報を提供する例外
//つまりコネクションが取れなかったときの例外を表示するために必要
import java.sql.SQLException;

//private static StringはDB接続に必要な情報を書いている
public class DBConnector {

	//DriverNameの指定  ""内はドライバーの本体がある
	//com.mysql.jdbc...パッケージ名 .Driver...クラス名
	private static String driverName = "com.mysql.jdbc.Driver";

	//DB接続先の指定

	//localhost...データベースサーバ名 testdb...実際に接続するDBの名前
	private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";

	//認証に必要なユーザー名(con代入用)
	private static String user ="root";

	//認証に必要なパスワード名(con代入用)
	private static String password="mysql";

	//getConnection()を自分で作成している、APIと関係はない
	public Connection getConnection(){
		//1.conにnullを代入しておく
		Connection con = null;

	//ここからtry-catch文
		try{
			//2-1.正常に作動したとき、conに代入　API DriverManager Connection

			//forName()...ドライバーを実際に使えるようにするために必要な文
			//DB接続の詳細なJAVAの動き、クラスCLASS等の知識を必要とするため難しい
			Class.forName(driverName);
			//DriverManagerクラス内に持っているgetConnection()メソッドを使用し、mysqlへのコネクションを実質稼動
			//また、接続に必要な情報をgetConnection()メソッドの引数として指定する
			con = DriverManager.getConnection(url,user,password);
		} //2-2.以上作動したときcatch文(エラー文)の発動 ここでは2通りを準備　API SQLException
		catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//3.conを戻す
		return con;
	}
}
