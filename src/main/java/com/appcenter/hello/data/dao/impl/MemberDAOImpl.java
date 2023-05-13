package com.appcenter.hello.data.dao.impl;

import com.appcenter.hello.data.dao.MemberDAO;
import com.appcenter.hello.data.entity.Member;
import com.appcenter.hello.data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// MemberDAO의 구현체 클래스
@Component
public class MemberDAOImpl implements MemberDAO {

    // 레포지토리를 상수 선언
    private final MemberRepository memberRepository;

    // @Autowired로 의존 관계 자동 주입
    // 빌더 타입
    @Autowired
    public MemberDAOImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member insertMember(Member member) {
        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    @Override
    public Member selectMember(Long number) {
        Member selectedMember = memberRepository.getById(number);

        return selectedMember;
    }

    @Override
    public Member updateMember(Long number, String name) throws Exception {
        return null;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {

    }
}
