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


@WebServlet("/userCreateservlet")
public class userCreateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public userCreateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規登録画面フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力情報取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password-confirm");
		String userName = request.getParameter("user-name");
		String birth = request.getParameter("birth-day");
		UserBean userInfo = new UserBean(userId,password,userName,birth);

		if(password.equals(passwordConfirm)) {
			//フォーム情報→UserBeanインスタンスにコンストラクタで格納

			//ID確認メソッド
			UserDao dao = new UserDao();
			UserBean userbean = null;
			try {
				userbean = dao.findSerch(userInfo);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			if(userbean == null) {
				try {
					dao.Create(userInfo);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
					//一覧画面リダイレクト
					response.sendRedirect("UserlistServlet");

				}else {
					dispErrMsg(request, response,userInfo);
			}


		} else {
			dispErrMsg(request, response, userInfo);
		}

	}


	/**
	 * エラーメッセージを保存してもとのページを表示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void dispErrMsg(HttpServletRequest request, HttpServletResponse response, UserBean userErr)
			throws ServletException, IOException {
		request.setAttribute("userErr",userErr);
		request.setAttribute("er","入力された内容は正しくありません");
		doGet(request, response);
	}

}
