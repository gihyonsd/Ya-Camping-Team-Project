package com.spring.example.mapper;

import java.util.List;

import com.spring.example.domain.BoardVO;
import com.spring.example.domain.Criteria;



public interface BoardMapper {
	
	
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public BoardVO read(Criteria cri);
	
	public int gettotalCount(Criteria cri);
	
}
