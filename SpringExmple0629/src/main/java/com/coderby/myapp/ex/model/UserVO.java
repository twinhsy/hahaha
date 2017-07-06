package com.coderby.myapp.ex.model;

public class UserVO {
	private String userId;
	private String userName;
	private String userPassword;
	private String userPasswordConfirm;
	private String userRole;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userRole="
				+ userRole + "]";
	}
	public String getUserPasswordConfirm() {
		return userPasswordConfirm;
	}
	public void setUserPasswordConfirm(String userPasswordConfirm) {
		this.userPasswordConfirm = userPasswordConfirm;
	}
}
