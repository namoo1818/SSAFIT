package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Calendar;
import com.ssafit.board.model.dto.Daily;

public interface CalendarService {
	// 일정 등록
	void writeCal(Calendar cal);
	
	// 일정 상세 조회
	Calendar getCal(int id);
	
	// 일정 한달 조회
	List<Calendar> getList(int userNum);
	
	// 일정 수정
	boolean modifyCal(Calendar cal);
	
	// 일정 삭제
	boolean removeCal(int id);
	
	// 출석 전체 조회
	List<Daily> gettDaily(int id);
	
	// 출석 하나 조회
	Daily getDailyOne(int id);
		
	// 출석 등록
	void writeDaily(Daily daily);
	
	// 출석 삭제
	boolean removeDaily(int id);
}
