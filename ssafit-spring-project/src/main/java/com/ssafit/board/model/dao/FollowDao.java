package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Follow;
import com.ssafit.board.model.dto.SearchCondition;

public interface FollowDao {
	
	//팔로우 
	void insertFollow(Follow follow);
	
	//언팔로우
	int deleteFollow(int id);
	
	//나를 팔로우하는 사람 조회  
	List<Follow> followerSearch(int id);
	
	//내가 팔로우하는 사람 조회 
	List<Follow> followingSearch(int id);

}
