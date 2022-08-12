package com.spring.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.VO.MemberVO;
import com.spring.example.dao.MemberDao;
import com.spring.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public int Login(MemberVO vo) throws Exception {

		return memberDao.Login(vo);

	}

	@Override
	public void register(MemberVO vo) throws Exception {
		memberDao.register(vo);
	}

	// 아이디 중복 체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = memberDao.idChk(vo);
		return result;
	}

	//회원탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		memberDao.memberDelete(vo);
	}
	
	//회원 탈퇴 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = memberDao.passChk(vo);
		return result;
	}

}