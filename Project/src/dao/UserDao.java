package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SearchConditionBeans;
import model.UserBean;


public class UserDao extends DaoUtil{

	/**ログイン用メソッド**/
	public UserBean findBylogin(UserBean userbean) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();
		//sql送信
		PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE login_id = ? and password = ? order by id DESC");
		st.setString(1,userbean.getLoginId());
		st.setString(2,userbean.getPassword());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			UserBean user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setLoginId(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthDate(rs.getDate("birth_date"));
			user.setPassword(rs.getString("password"));
			user.setCreateDate(rs.getTimestamp("create_date"));
			user.setCreateDate(rs.getTimestamp("update_date"));
			return user;

		}

		return null;
	}

	/**詳細画面用メソッド**/
	public UserBean findBydetail(UserBean userbean) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();
		//sql送信
		PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE login_id = ? order by id DESC");
		st.setString(1,userbean.getLoginId());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			UserBean user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setLoginId(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthDate(rs.getDate("birth_date"));
			user.setPassword(rs.getString("password"));
			user.setCreateDate(rs.getTimestamp("create_date"));
			user.setUpdateDate(rs.getTimestamp("update_date"));
			return user;

		}

		return null;
	}


	/**Userテーブルに登録された全てのデータを取得する(登録順)**/
	public ArrayList<UserBean> findAll() throws SQLException {
		Connection con = DBManager.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM user where login_id NOT IN ('admin') order by id ASC");
		ResultSet rs = st.executeQuery();

		ArrayList<UserBean> userList = new ArrayList<UserBean>();

		while (rs.next()) {
			UserBean user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setLoginId(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthDate(rs.getDate("birth_date"));
			user.setPassword(rs.getString("password"));
			user.setCreateDate(rs.getTimestamp("create_date"));
			user.setCreateDate(rs.getTimestamp("update_date"));

			userList.add(user);
		}

		return userList;
	}


	public List<UserBean> searchUser(String loginId, String userName, String birthdayFrom, String birthdayTo) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();

		String sql = "SELECT * FROM user where login_id NOT IN ('admin')";

		// 各種検索要件を設定してSQLを生成
		// List型配列にSearchConditionBeans型インスタンスを格納(DB文,form情報,検索条件)
		List<SearchConditionBeans> conditions = new ArrayList<SearchConditionBeans>();
		conditions.add(new SearchConditionBeans("login_id", loginId, WHERE_TYPE_EQUAL));
		conditions.add(new SearchConditionBeans("name", userName, WHERE_TYPE_LIKE_PARTIAL_MATCH));
		conditions.add(new SearchConditionBeans("birth_date", birthdayFrom, WHERE_TYPE_GENDER_OR_EQUAL));
		conditions.add(new SearchConditionBeans("birth_date", birthdayTo, WHERE_TYPE_LESS_OR_EQUAL));
		//DaoUtillメソッド("SELECT * FROM user", 検索情報インスタンス)
		sql = addWhereCondition(sql, conditions);
		System.out.println(sql);

		// IDの降順に表示("SELECT * FROM user order by id desc")
		sql += " order by id desc";


		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();


		ArrayList<UserBean> userList = new ArrayList<UserBean>();

		while (rs.next()) {
			UserBean user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setLoginId(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthDate(rs.getDate("birth_date"));
			user.setPassword(rs.getString("password"));
			user.setCreateDate(rs.getTimestamp("create_date"));
			user.setCreateDate(rs.getTimestamp("update_date"));


			userList.add(user);
		}

		return userList;

	}


	/**アップデート用メソッド**/
	public void Update(UserBean userUp) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();
		//sql送信
		PreparedStatement st = con.prepareStatement("UPDATE user SET login_id=?, password=?, name=?, birth_date=? WHERE login_id= ? ");
		st.setString(1,userUp.getLoginId());
		st.setString(2,userUp.getPassword());
		st.setString(3,userUp.getName());
		st.setString(4,userUp.getFormatBirthDate());
		st.setString(5,userUp.getLoginId());
		System.out.println(userUp.getFormatBirthDate());

		st.executeUpdate();

	}


	/**削除用メソッド**/
	public void Delete(UserBean userDelete) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();
		//sql送信
		PreparedStatement st = con.prepareStatement("DELETE FROM user WHERE login_id= ?");
		st.setString(1,userDelete.getLoginId());

		st.executeUpdate();

	}


	/**確認用メソッド**/
	public UserBean findSerch(UserBean userbean) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();
		//sql送信
		PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE login_id = ?  order by id DESC");
		st.setString(1,userbean.getLoginId());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			UserBean user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setLoginId(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthDate(rs.getDate("birth_date"));
			user.setPassword(rs.getString("password"));
			user.setCreateDate(rs.getTimestamp("create_date"));
			user.setCreateDate(rs.getTimestamp("update_date"));
			return user;

		}

		return null;
	}


	/**新規登録メソッド**/
	public void Create(UserBean userCreate) throws SQLException {
		//DB接続
		Connection con = DBManager.getConnection();
		//sql送信
		PreparedStatement st =
			con.prepareStatement("INSERT INTO user (login_id, password, name, birth_date, create_date, update_date) VALUES (?, ?, ?, ?, now(), now())");
			st.setString(1,userCreate.getLoginId());
			st.setString(2,userCreate.getPassword());
			st.setString(3,userCreate.getName());
			st.setString(4,userCreate.getFormatBirthDate());

			st.executeUpdate();

		}










}
