package com.ssafit.board.model.dao;

import com.ssafit.board.model.dto.Weather;

public interface WeatherDao {
	// 날씨 코드로 검색
	public Weather selectWeather(String id);
}
