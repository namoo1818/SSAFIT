package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.UserDao;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public void regist(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User getUser(int id) {
		return userDao.selectOne(id);
	}

	@Override
	@Transactional
	public boolean modifyUser(User user) {
		return userDao.updateUser(user) > 0;
	}

	@Override
	@Transactional
	public boolean removeUser(int id) {
		return userDao.deleteUser(id) == 1;
	}

	@Override
	public List<User> search(SearchCondition condition) {
		return userDao.search(condition);
	}

}
