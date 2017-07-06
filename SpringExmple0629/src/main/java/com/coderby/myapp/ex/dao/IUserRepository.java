package com.coderby.myapp.ex.dao;

import java.util.List;

import com.coderby.myapp.ex.model.UserVO;

public interface IUserRepository {
	void insertUser(UserVO user);
	
	void updateUser(UserVO user);
	
	void deleteUser(String userId, String userPassword);
	
	UserVO selectUser(String userId);
	
	List<UserVO> selectAllUser();
	
	String getPassword(String userId);
	
	
}