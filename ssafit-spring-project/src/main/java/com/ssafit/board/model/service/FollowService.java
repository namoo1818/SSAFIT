package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Follow;
import com.ssafit.board.model.dto.SearchCondition;

public interface FollowService {
	
	void follow(Follow follow);
	
	boolean unfollow(int id);
	
	//나를 팔로우하는 사람 조회  
	List<Follow> followerSearch(int id);
	
	//내가 팔로우하는 사람 조회 
	List<Follow> followingSearch(int id);
	
}
