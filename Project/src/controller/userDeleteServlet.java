package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBean;


@WebServlet("/userDeleteServlet")
public class userDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public userDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//クエリからid取得
				String id = request.getParameter("id");
				System.out.println(id);

		//フォーム情報→UserBeanインスタンスにコンストラクタで格納
		UserBean userbean = new UserBean(id);

		//リクエストスコープ保存
		request.setAttribute("UserBean",userbean);

		//削除画面フォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
		dispatcher.forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//クエリからid取得
		String id = request.getParameter("id");
		System.out.println(id);

		//UserBeanインスタンスにコンストラクタで格納
		UserBean userDelete = new UserBean(id);

		//削除用メソッド
		UserDao dao = new UserDao();
			try {
				dao.Delete(userDelete);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			response.sendRedirect("UserlistServlet");


	}

}
