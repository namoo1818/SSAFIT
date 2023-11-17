package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.dto.SearchCondition;

//사용자 친화적으로 작성
public interface VideoService {
	// 영상 등록
	void writeVideo(Video video);

	// 영상 상세 조회
	Video getVideo(int id);

	// 영상 수정
	boolean modifyVideo(Video video);

	// 영상 삭제
	boolean removeVideo(int id);

	// 검색 버튼을 눌렀을 때 처리할 메서드
	List<Video> search(SearchCondition condition);
	
	// 최근에 본 영상 목록
	List<Video> RecentlyViewedVideo(int id);
}
