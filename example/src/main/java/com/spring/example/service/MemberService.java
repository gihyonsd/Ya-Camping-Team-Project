package com.spring.example.service;

import com.spring.example.VO.MemberVO;

public interface MemberService {
	//로그인
    public int Login(MemberVO vo) throws Exception;
    //회원가입
    public void memberJoin(MemberVO vo) throws Exception;
    

}