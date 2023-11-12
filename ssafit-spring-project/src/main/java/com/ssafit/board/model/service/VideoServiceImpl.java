package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.VideoDao;
import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.dto.SearchCondition;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao videoDao;

	@Transactional
	@Override
	public void writeVideo(Video video) {
		videoDao.insertVideo(video);
	}

	@Override
	public Video getVideo(int id) {
		videoDao.updateViewCnt(id);
		return videoDao.selectOne(id);
	}

	@Transactional
	@Override
	public boolean modifyVideo(Video video) {
		return videoDao.updateVideo(video) > 0;
	}

	@Transactional
	@Override
	public boolean removeVideo(int id) {
		return videoDao.deleteVideo(id) == 1;
	}

	@Override
	public List<Video> search(SearchCondition condition) {
		return videoDao.search(condition);
	}

}
