package com.coderby.myapp.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderby.myapp.ex.dao.IUserRepository;
import com.coderby.myapp.ex.model.UserVO;

@Service
@Transactional("transactionManager") // TransactionManager가 다른이름으로 써있으면 써주고 같으면 안써도 된다.
public class userService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	
	@Override
	public void insertUser(UserVO user) {
		userRepository.insertUser(user);
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String userId, String userPassword) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(userId, userPassword);
	}

	@Override
	public UserVO selectUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.selectUser(userId);
	}

	@Override
	public List<UserVO> selectAllUser() {
		// TODO Auto-generated method stub
		return userRepository.selectAllUser();
	}

	@Override
	public boolean checkPassword(String userId, String userPassword) {
		String password= userRepository.getPassword(userId);
		if(password.equals(userPassword)){
			System.out.println("true");
			return true;
		}else {
			System.out.println("F");
			return false;
		}
	}
}
