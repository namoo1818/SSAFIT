package com.ssafit.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

public interface VideoDao {
	// ID에 해당하는 영상 하나 가져오기
	public Video selectOne(int id);

	// 영상 등록
	public void insertVideo(Video video);

	// 영상 삭제
	public int deleteVideo(int id);

	// 영상 수정
	public int updateVideo(Video video);

	// 조회수 증가
	public void updateViewCnt(int id);
	
	// 시청기록 등록
	public void insertViewLog(Map<String, Integer> map);

	// 검색 기능
	public List<Video> search(SearchCondition condition);
	
	// 최근에 본 영상 목록
	public List<Video> RecentlyViewedVideo(int id);
	

}
