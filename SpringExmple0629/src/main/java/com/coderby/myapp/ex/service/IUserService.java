package com.coderby.myapp.ex.service;

import java.util.List;

import com.coderby.myapp.ex.model.UserVO;

public interface IUserService {
	void insertUser(UserVO user);
	
	void updateUser(UserVO user);
	
	void deleteUser(String userId, String userPassword);
	UserVO selectUser(String userId);
	
	List<UserVO> selectAllUser();
	
	boolean checkPassword(String userId, String userPassword);
	
	
}
