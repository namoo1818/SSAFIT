package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Wish;

public interface WishDao {

	//위시추가
	void insertWish(Wish wish);
	
	//위시삭제
	int deleteWish(int id);
	
	//회원별 위시 조회 
	List<Wish> wishSearch(int id);
	
}
