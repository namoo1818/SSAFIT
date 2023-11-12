package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;

public interface ReviewDao {
	// ID에 해당하는 게시글 하나 가져오기
	public Review selectOne(int id);

	// 게시글 등록
	public void insertReview(Review review);

	// 게시글 삭제
	public int deleteReview(int id);

	// 게시글 수정
	public int updateReview(Review review);

	// 조회수 증가
	public void updateViewCnt(int id);

	// 검색 기능
	public List<Review> search(SearchCondition condition);

}
