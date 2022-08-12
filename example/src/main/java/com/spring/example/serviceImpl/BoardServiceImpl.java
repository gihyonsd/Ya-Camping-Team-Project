package com.spring.example.serviceImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.example.dao.BoardDAO;
import com.spring.example.service.BoardService;
import com.spring.example.VO.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}

}
