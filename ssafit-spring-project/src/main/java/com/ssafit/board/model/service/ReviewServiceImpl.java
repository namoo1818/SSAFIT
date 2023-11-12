package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.ReviewDao;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Transactional
	@Override
	public void writeReview(Review review) {
		reviewDao.insertReview(review);
	}

	@Override
	public Review getReview(int id) {
		reviewDao.updateViewCnt(id);
		return reviewDao.selectOne(id);
	}

	@Transactional
	@Override
	public boolean modifyReview(Review review) {
		return reviewDao.updateReview(review) > 0;
	}

	@Transactional
	@Override
	public boolean removeReview(int id) {
		return reviewDao.deleteReview(id) == 1;
	}

	@Override
	public List<Review> search(SearchCondition condition) {
		return reviewDao.search(condition);
	}

}
