package com.ssafit.board.model.dao;

import com.ssafit.board.model.dto.Playlist;
import com.ssafit.board.model.dto.Quote;
import com.ssafit.board.model.dto.Weather;

public interface WeatherDao {
	
	// 날씨 코드로 검색
	public Weather selectWeather(String id);
	
	// 음악 추천
	public Playlist selectPlayList(String id);
	
	// 응원멘트 추천
	public Quote selectQuote(String id);
}
