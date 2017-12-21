package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBean implements Serializable {
	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private Timestamp createDate;
	private Timestamp updateDate;

	public UserBean() {
	}

	public UserBean(String id, String pass) {
		this.loginId = id;
		this.password = pass;
	}

	public UserBean(String id) {
		this.loginId = id;
	}

	public UserBean(String userId, String password, String userName) {
		this.loginId = userId;
		this.password = password;
		this.name = userName;
	}

	public UserBean(String userId, String password, String userName, String birth) {
		try {
			this.loginId = userId;
			this.password = password;
			this.name = userName;

			SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日");
			Date formatDate;
			formatDate = sdf.parse(birth);
			this.birthDate = formatDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	//String変換
	public String getFormatBirthDate() {
		String str = new SimpleDateFormat("yyyy年MM月dd日").format(birthDate);
        System.out.println("String型 = " + str);
		return str;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	//String変換
	public String getFormatCreateDate() {
		String str = new SimpleDateFormat("yyyy年MM月dd日HH:mm").format(createDate);
	    System.out.println("String型 = " + str);
		return str;
		}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	//String変換
	public String getFormatUpdateDate() {
		String str = new SimpleDateFormat("yyyy年MM月dd日HH:mm").format(updateDate);
	    System.out.println("String型 = " + str);
		return str;
		}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}





}
