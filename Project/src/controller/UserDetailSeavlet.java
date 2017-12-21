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


@WebServlet("/UserDetailSeavlet")
public class UserDetailSeavlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//クエリからid取得
		String id = request.getParameter("id");
		System.out.println(id);

		//フォーム情報→UserBeanインスタンスにコンストラクタで格納
				UserBean userbean = new UserBean(id);

				//UserDaoメソッド呼び出して引数で格納済みインスタンス渡す
				UserDao dao = new UserDao();
				UserBean userInfo = null;

				try {
					//インスタンスかnullが返ってくる
					userInfo = dao.findBydetail(userbean);

				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}


				//リクエストスコープ保存
				request.setAttribute("UserBean",userInfo);



		//ユーザ詳細画面フォワード
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/userDetail.jsp");
				dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
