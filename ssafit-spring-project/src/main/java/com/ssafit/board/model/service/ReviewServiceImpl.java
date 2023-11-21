package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.ReviewDao;
import com.ssafit.board.model.dao.UserDao;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public void writeReview(Review review) {
		int userNum = review.getWriter();
		userDao.plusExp(userNum);
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
		Review review = reviewDao.selectOne(id);
		int userNum = review.getWriter();
		userDao.minusExp(userNum);
		return reviewDao.deleteReview(id) == 1;
	}

	@Override
	public List<Review> search(SearchCondition condition) {
		return reviewDao.search(condition);
	}
	
	@Override
	public List<Review> getVideoReveiw(int id) {
		List<Review> list = reviewDao.selectVideoReview(id);
		for(int i = 0; i<list.size();i++) {
			int reviewNum = list.get(i).getNum();
			reviewDao.updateViewCnt(reviewNum);
		}
	    return list;
	}

}
