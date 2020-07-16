package com.simple.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.simple.command.BoardVO;

public interface BoardMapper {
	//추상메서드
	//1st
	//public void boardRegist(BoardVO vo); //board 등록 메서드
	//2nd
	//public void boardRegist(HashMap<String, String> map); 
	
	public void boardRegister(BoardVO vo); //board 등록 메서드
	public ArrayList<BoardVO> getList(); //모든 게시물 가져오기
	public void boardDelete(int num); //게시글 삭제 메서드
}
