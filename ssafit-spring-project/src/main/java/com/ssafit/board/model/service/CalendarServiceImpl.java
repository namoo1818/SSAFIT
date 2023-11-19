package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.CalendarDao;
import com.ssafit.board.model.dto.Calendar;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarDao calendarDao;
	
	@Override
	public void writeCal(Calendar cal) {
		calendarDao.insertCal(cal);
	}

	@Override
	public Calendar getCal(int id) {
		return calendarDao.selectOne(id);
	}

	@Override
	public List<Calendar> getList(int userNum) {
		return calendarDao.selectList(userNum);
	}

	@Transactional
	@Override
	public int modifyCal(Calendar cal) {
		return calendarDao.updateCal(cal);
	}

	@Transactional
	@Override
	public int removeCal(int id) {
		return calendarDao.deleteCal(id);
	}

}
