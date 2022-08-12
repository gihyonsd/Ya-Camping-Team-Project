package com.spring.example.dao;

import com.spring.example.VO.BoardVO;

public interface BoardDAO {

	// 게시글 작성
	public void write(BoardVO boardVO) throws Exception;
}