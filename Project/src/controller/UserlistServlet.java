package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBean;

@WebServlet("/UserlistServlet")
public class UserlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserlistServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// UserDao.findall()でUserBean型のインスタンスの配列取得
		UserDao dao = new UserDao();
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		try {
			userList = dao.findAll();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// リクエストスコープとフォワード

		request.setAttribute("UserList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userlist.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 検索条件form情報取得
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("login_id");
		String userName = request.getParameter("user_name");
		String birthdayFrom = request.getParameter("date-start");
		String birthdayTo = request.getParameter("date-end");

		// 検索情報をメソッド送信 (UserDao)
		List<UserBean> userList = new ArrayList<UserBean>();
		UserDao dao = new UserDao();
		try {
			userList = dao.searchUser(loginId, userName, birthdayFrom, birthdayTo);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("UserList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userlist.jsp");
		dispatcher.forward(request, response);

	}

}
