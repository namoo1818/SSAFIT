package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;

//사용자 친화적으로 작성
public interface ReviewService {
	// 게시글 등록
	void writeReview(Review review);

	// 게시글 상세 조회
	Review getReview(int id);

	// 게시글 수정
	boolean modifyReview(Review review);

	// 게시글 삭제
	boolean removeReview(int id);

	// 검색 버튼을 눌렀을 때 처리할 메서드
	List<Review> search(SearchCondition condition);
	
	// 영상에 달린 리뷰 조회
	public List<Review> getVideoReveiw(int id);
}
