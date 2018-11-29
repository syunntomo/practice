

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * 参考url:https://www.javadrive.jp/servlet/response/index1.html
	 * webコンテナとは　https://eng-entrance.com/java-servlet-server#Web-3
	 * 下記にpost/getメソッドの違いを書いてある
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding() はサーバーから送られてきたコードを指定した値に書き換える */
		request.setCharacterEncoding("UTF-8");

		/* response.setContentType…HTTPサーバに送り返すときに()内で指定したもので返す */
		response.setContentType("text/html; charset=UTF-8");

		/* request.getParameter はhtmlフォームを用いて送信されたデータを抽出する。戻り値はString型 */
		String username = request.getParameter("username");

		System.out.println(username);

		/* PrintWriterクラス…テキストの出力に特化したクラス */
		PrintWriter out=response.getWriter();
		out.println("<html><head></head><body><br>"+username+"さん、ようこそ！</body></html>");
	}

}

/* postメソッドとgetメソッドの違いは「パラメータの受け渡し方法」
 * GETメソッド…サーブレットに受け渡すパラメータをurlに組み込んでいる
 * なので、urlを見るととても長ったらしい分になっていることが確認でき、ブラウザ履歴にも残る
 *
 * POSTメソッド…HTTPリクエストのメッセージボディ中に組み込んでいる
 * これより、GETメソッドのurlに比べるとスッキリしている
 *
 * なお、どちらのメソッドを使っても、機密性に関しては疑問符が残るので暗号化は必須*/
