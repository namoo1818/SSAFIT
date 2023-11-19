package com.ssafit.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafit.board.model.dto.Calendar;

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
	
	// 출석 조회
	
	// 출석 등록
	
	// 출석 삭제
}
