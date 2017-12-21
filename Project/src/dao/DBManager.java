package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;

/**
 * DBの接続情報インスタンスを作成する
 */
public class DBManager {

	// DBへの接続ユーザ
	private final static String USER = "root";
	// DBへの接続パスワード
	private final static String PASSWORD = "password";
	// 接続先DB名称
	private final static String DB = "ユーザ情報";

	/**
	 * DBに接続してコネクションインスタンスを返す
	 * @return コネクションインスタンス
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			//ドライバー読み込み
			Class.forName("com.mysql.jdbc.Driver");
			//(url、ユーザ、パスワード)
			con = DriverManager.getConnection(
					MessageFormat.format("jdbc:mysql://localhost:3306/{0}?useUnicode=true&characterEncoding=utf8",DB)
					, USER
					, PASSWORD
					);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalMonitorStateException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalMonitorStateException();
		}
	}

	public static Connection getConnection1() {
		return null;
	}
}
