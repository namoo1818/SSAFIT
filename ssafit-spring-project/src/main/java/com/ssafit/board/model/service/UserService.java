package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.User;

//사용자 친화적으로 작성  
public interface UserService {

	//회원가입 (회원정보 등록) 
	void regist(User user);
	
	//회원정보 조회  
	User getUser(int id);
	
	//회원정보 수정 
	boolean modifyUser(User user);
	
	//회원탈퇴 (회원정보 삭제) 
	boolean removeUser(int id);
	
	//검색 
	List<User> search(SearchCondition condition);
	
	////게시글 등록
	//void writeBoard(Board board);
	//
	////게시글 상세 조회	
	//Board getBoard(int id);
	//
	////게시글 수정
	//boolean modifyBoard(Board board);
	//
	////게시글 삭제
	//boolean removeBoard(int id);
	
}


