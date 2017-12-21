package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.UserBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//ログイン画面フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form情報取得
        request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		//フォーム情報→UserBeanインスタンスにコンストラクタで格納
		UserBean userbean = new UserBean(id,pass);

		//UserDaoメソッド呼び出して引数で格納済みインスタンス渡す
		UserDao dao = new UserDao();
		UserBean userInfo = null;

		try {
			//インスタンスかnullが返ってくる
			userInfo = dao.findBylogin(userbean);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//条件分岐
		if(userInfo == null) {
			request.setAttribute("er","ログインIDまたはパスワードが異なります");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request,response);
			return;
		}

		//セッションスコープ保存
		HttpSession session = request.getSession();
		session.setAttribute("UserBean",userInfo);


		//UserlistServletにリダイレクト
		response.sendRedirect("UserlistServlet");

	}

}
