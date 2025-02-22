package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Calendar;
import com.ssafit.board.model.dto.Daily;

public interface CalendarDao {
	// 일정 등록
	void insertCal(Calendar cal);
	
	// 일정 상세 조회
	Calendar selectOne(int id);
	
	// 일정 목록 조회
	List<Calendar> selectList(int id);
	
	// 일정 수정
	int updateCal(Calendar cal);
	
	// 일정 삭제
	int deleteCal(int id);
	
	// 출석 전체 조회
	List<Daily> selectDaily(int id);
	
	// 출석 하나 조회
	Daily selectDailyOne(int id);
	
	// 출석 등록
	void insertDaily(Daily daily);
	
	// 출석 삭제
	int deleteDaily(int id);
	
}
