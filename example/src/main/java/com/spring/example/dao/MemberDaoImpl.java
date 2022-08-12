package com.spring.example.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.spring.example.VO.MemberVO;

public class MemberDaoImpl implements MemberDao {
	private static final String Namespace = "com.spring.example.dao.MemberDao";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int Login(MemberVO vo) throws Exception {
		return sql.selectOne(Namespace + ".Login", vo);
	}

	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert(Namespace + ".register", vo);
	}
	// 아이디 중복 체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(Namespace + ".idChk", vo);
		return result;
	}
	// 회원 탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		sql.delete(Namespace + ".memberDelete", vo);
		
	}
	// 회원 탈퇴 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(Namespace + ".passChk", vo);
		return result;
	}

}
