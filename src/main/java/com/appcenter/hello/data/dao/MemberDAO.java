package com.appcenter.hello.data.dao;

import com.appcenter.hello.data.entity.Member;

// 인터페이스 - 구현체 패턴
public interface MemberDAO {
    // CRUD (회원가입, 회원조회, 회원수정, 회원삭제)

    // 회원가입
    Member insertMember(Member member);

    // 회원조회
    Member selectMember(Long number);

    // 회원수정
    Member updateMember(Long number, String name) throws Exception;

    // 회원 삭제
    void deleteProduct(Long number) throws Exception;
}
