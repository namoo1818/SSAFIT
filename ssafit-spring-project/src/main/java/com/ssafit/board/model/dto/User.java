package com.ssafit.board.model.dto;

public class User {
	
	private int userNum;
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userRegdate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String userPassword, String userName, String userNickname, String userEmail) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
	}

	public User(int userNum, String userId, String userPassword, String userName, String userNickname, 
			String userEmail, String userRegdate) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userRegdate = userRegdate;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	@Override
	public String toString() {
		return "User [userNum=" + userNum + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userNickname=" + userNickname + ", userEmail=" + userEmail + ", userRegdate="
				+ userRegdate + "]";
	}
	

}
