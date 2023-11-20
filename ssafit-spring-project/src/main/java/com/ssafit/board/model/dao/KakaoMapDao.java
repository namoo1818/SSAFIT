package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.kakaoMap;

public interface KakaoMapDao {
	
		// 맵 목록
		public List<kakaoMap> selectList(int id);
		
		// 맵 목록
		public kakaoMap selectOne(int id);

		// 맵 등록
		public void insertMap(kakaoMap kakaoMap);

		// 맵 삭제
		public int deleteMap(int id);

		// 맵 수정
		public int updateMap(kakaoMap kakaoMap);

}
