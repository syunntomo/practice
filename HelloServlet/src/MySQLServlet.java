
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
/*anotation...これまでweb.wmlに記述していた設定値を直接プログラムに記述することが可能
 * @WebServlet...ServletクラスとそれにアクセスするURLパターンを定義する*/
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySQLServlet
 */
@WebServlet("/MySQLServlet")
public class MySQLServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySQLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>データベーステスト</title>");
		out.println("</head>");
		out.println("<body>");

		Connection conn = null;
		String url = "jdbc:mysql://localhost/testdb";
		String user = "root";
		String password = "mysql";

		try{
			//この部分はDBConnection.javaで書いていた部分
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,password);

			/*ここから下はTestUserDAO.javaで書いていた部分
			 * createStatement()はSQL文をデータベースに送るためのStatementオブジェクトを生成する
			 *
			 * 下はStatementメソッドを使った方法、DAOのようにパラメータが存在しないので使っている
			 * SQL送信用のインスタンスを作っている点は共通*/
			Statement stmt = conn.createStatement();

			String sql ="SELECT * FROM test_table";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userPassword = rs.getString("password");

				//下は実際にクライアントに対して出力する部分、HTML言語で書かれている
				out.println("<p>");
				out.println("ユーザーID:"+ userId +",ユーザー名:"+userName+",パスワード:"+userPassword);
				out.println("</p>");
			}


			//rsもstmtもDriverManagerの要素を引き継いでいるため、DB切断のためには2つとも閉じる必要がある
			rs.close();
			stmt.close();

		}catch(ClassNotFoundException e){
			out.println("ClassNotFoundException:"+e.getMessage());
		}catch(SQLException e){
			out.println("SQLException:"+e.getMessage());
		}catch(Exception e){
			out.println("Exception:"+e.getMessage());
		}
		//finally文･･･例外の発生の有無にかかわらず、実行するメソッド
		finally{
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(SQLException e){
				out.println("SQLException:"+e.getMessage());
			}
		}

		out.println("</body>");
		out.println("</html>");
	}
}
