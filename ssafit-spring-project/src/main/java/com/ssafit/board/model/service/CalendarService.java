package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Calendar;

public interface CalendarService {
	// 일정 등록
	void writeCal(Calendar cal);
	
	// 일정 상세 조회
	Calendar getCal(int id);
	
	// 일정 한달 조회
	List<Calendar> getList(int userNum);
	
	// 일정 수정
	int modifyCal(Calendar cal);
	
	// 일정 삭제
	int removeCal(int id);
}
