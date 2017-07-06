package com.coderby.myapp.ex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coderby.myapp.ex.model.UserVO;

@Repository
public class userRepository implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate; //jdbcTemplate 의존성 주입을 해야됨
	
	@Override
	public void insertUser(UserVO user) {
		String sql = "insert into users(user_id, user_name, user_password, user_role)"
					+ "values(?,?,?,?)";
		jdbcTemplate.update(sql,
				user.getUserId(),
				user.getUserName(),
				user.getUserPassword(),
				user.getUserRole()
				);
	}

	@Override
	public void updateUser(UserVO user) {
		String sql = "update users set user_name=?, user_password=?,"
				+ "user_role=? where user_id=?";
		jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserRole(), user.getUserId());
	}

	@Override
	public void deleteUser(String userId, String userPassword) {
		String sql= "delete from users where user_id=? and user_password=?";
		jdbcTemplate.update(sql,userId, userPassword);
	}

	private class UserMapper implements RowMapper<UserVO> {
		@Override
		public UserVO mapRow(ResultSet rs, int count) throws SQLException {
			UserVO user = new UserVO();
			user.setUserId(rs.getString("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserPassword(rs.getString("user_password"));
			user.setUserRole(rs.getString("user_role"));
			return user;
		}
	}	
	
	@Override
	public UserVO selectUser(String userId) {
		String sql = "select user_id, user_name, user_password, user_role from users where user_id=?";
		return jdbcTemplate.queryForObject(sql,  new UserMapper(), userId);
	}

	@Override
	public List<UserVO> selectAllUser() {
		String sql = "select user_id, user_name, user_password, user_role from users";
		return jdbcTemplate.query(sql, new UserMapper());
	}
			
	@Override
	public String getPassword(String userId){
		String sql = "select user_password from users where user_id=?";
		return jdbcTemplate.queryForObject(sql, String.class, userId);
	}
	

}
