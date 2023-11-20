package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.CalendarDao;
import com.ssafit.board.model.dao.UserDao;
import com.ssafit.board.model.dto.Calendar;
import com.ssafit.board.model.dto.Daily;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarDao calendarDao;
	
	@Autowired
	private UserDao userDao;
	
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
	public boolean modifyCal(Calendar cal) {
		return calendarDao.updateCal(cal) > 0;
	}

	@Transactional
	@Override
	public boolean removeCal(int id) {
		return calendarDao.deleteCal(id) == 1;
	}

	@Override
	public List<Daily> gettDaily(int id) {
		return calendarDao.selectDaily(id);
	}
	
	@Override
	public Daily getDailyOne(int id) {
		return calendarDao.selectDailyOne(id);
	}

	@Override
	public void writeDaily(Daily daily) {
		int userNum = daily.getUserNum();
		userDao.plusExp(userNum);
		calendarDao.insertDaily(daily);
		
	}

	@Override
	public boolean removeDaily(int id) {
		Daily daily = calendarDao.selectDailyOne(id);
		int userNum = daily.getUserNum();
		userDao.minusExp(userNum);;
		return calendarDao.deleteDaily(id) == 1;
	}

}
