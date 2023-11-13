package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.FollowDao;
import com.ssafit.board.model.dto.Follow;
import com.ssafit.board.model.dto.SearchCondition;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowDao followDao;
	
	@Override
	public void follow(Follow follow) {
		followDao.insertFollow(follow);
	}

	@Override
	public boolean unfollow(int id) {
		return followDao.deleteFollow(id) ==1;
	}

	@Override
	public List<Follow> followerSearch(int id) {
		return followDao.followerSearch(id);
	}

	@Override
	public List<Follow> followingSearch(int id) {
		return followDao.followingSearch(id);
	}

}
