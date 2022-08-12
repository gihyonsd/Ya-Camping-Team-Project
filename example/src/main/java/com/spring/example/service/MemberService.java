package com.spring.example.service;

import com.spring.example.VO.MemberVO;

public interface MemberService {
	public int Login(MemberVO vo) throws Exception;

	public void register(MemberVO vo) throws Exception;

	//아이디 중복체크
	public int idChk(MemberVO vo) throws Exception;

	//회원 탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
	
	//회원 탈퇴 패스워드 체크
	public int passChk(MemberVO vo) throws Exception;
}