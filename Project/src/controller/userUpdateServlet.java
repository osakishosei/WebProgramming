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


@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public userUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//クエリからid取得
		String id = null;
		if(request.getAttribute("id") == null) {
			id = request.getParameter("id");
		} else {
			id = (String)request.getAttribute("id");
		}

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
			request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request,response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//入力情報取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password-confirm");
		String userName = request.getParameter("user-name");
		String birth = request.getParameter("birthDate");

		if(password.equals(passwordConfirm)) {
			//フォーム情報→UserBeanインスタンスにコンストラクタで格納
			UserBean userUp = new UserBean(userId,password,userName,birth);

			//更新メソッド
			UserDao dao = new UserDao();
			try {
				dao.Update(userUp);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//ユーザ詳細画面フォワード
			response.sendRedirect("UserlistServlet");

		}else {
		request.setAttribute("er","入力された内容は正しくありません");
		request.setAttribute("id",userId);
		doGet(request, response);
		}

	}

}
