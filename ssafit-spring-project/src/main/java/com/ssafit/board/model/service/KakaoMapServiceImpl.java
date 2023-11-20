package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.KakaoMapDao;
import com.ssafit.board.model.dto.kakaoMap;

@Service
public class KakaoMapServiceImpl implements KakaoMapService {
	
	@Autowired
	private KakaoMapDao kakaoMapDao;

	@Override
	public List<kakaoMap> getList(int id) {
		return kakaoMapDao.selectList(id);
	}

	@Override
	public kakaoMap getMap(int id) {
		return kakaoMapDao.selectOne(id);
	}

	@Override
	public void writeMap(kakaoMap kakaoMap) {
		kakaoMapDao.insertMap(kakaoMap);
	}

	@Transactional
	@Override
	public boolean removeMap(int id) {
		return kakaoMapDao.deleteMap(id) == 1;
	}

	@Transactional
	@Override
	public boolean modifyMap(kakaoMap kakaoMap) {
		return kakaoMapDao.updateMap(kakaoMap) > 0;
	}

}
