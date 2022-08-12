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

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		memberDao.memberDelete(vo);
	}
	
	//Controller에서 보내는 파라미터들을 memberUpdate(MemberVO vo)로 받고
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		
		//받은 vo를 DAO로 보내줍니다.
		memberDao.memberUpdate(vo);
		
	}

}