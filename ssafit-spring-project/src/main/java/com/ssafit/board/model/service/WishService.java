package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Wish;

public interface WishService {

	void wish(Wish wish);
	
	boolean unwish(int id);
}
