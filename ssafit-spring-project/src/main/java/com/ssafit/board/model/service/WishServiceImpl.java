package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.WishDao;
import com.ssafit.board.model.dto.Wish;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private WishDao wishDao;
	
	@Override
	@Transactional
	public void wish(Wish wish) {
		wishDao.insertWish(wish);
	}

	@Override
	@Transactional
	public boolean unwish(int id) {
		return wishDao.deleteWish(id) == 1;
	}

}
