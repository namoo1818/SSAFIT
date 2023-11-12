package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.User;

public interface UserDao {
	
	//회원 등록 
	void insertUser(User user);

	//회원 1명 조회 
	User selectOne(int id);

	//회원 수정 
	int updateUser(User user);

	//회원 삭제 
	int deleteUser(int id);

	//회원 전체/검색 조회 
	List<User> search(SearchCondition condition);
	
}
