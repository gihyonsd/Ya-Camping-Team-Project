package com.spring.yacamping.service;

import com.spring.yacamping.domain.MemberVO;

public interface MemberService {
    public int Login(MemberVO vo) throws Exception;
    
    public void register(MemberVO vo) throws Exception;
}