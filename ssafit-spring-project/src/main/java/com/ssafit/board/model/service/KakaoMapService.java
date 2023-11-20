package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.kakaoMap;

public interface KakaoMapService {

	// 맵 목록
	public List<kakaoMap> getList(int id);

	// 맵 목록
	public kakaoMap getMap(int id);

	// 맵 등록
	public void writeMap(kakaoMap kakaoMap);

	// 맵 삭제
	public boolean removeMap(int id);

	// 맵 수정
	public boolean modifyMap(kakaoMap kakaoMap);

}
