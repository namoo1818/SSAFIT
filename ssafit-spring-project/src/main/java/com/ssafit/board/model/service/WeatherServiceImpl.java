package com.ssafit.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.WeatherDao;
import com.ssafit.board.model.dto.Weather;
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDao weatherDao;
	
	@Override
	public Weather getWeather(String id) {
		return weatherDao.selectWeather(id);
	}

}
