package com.appcenter.hello.data.dao.impl;

import com.appcenter.hello.data.dao.MemberDAO;
import com.appcenter.hello.data.entity.Member;
import com.appcenter.hello.data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        // select로 정보 가져오기
        // Optional NPE을 방지할 수 있는 클래스
        // NPE과 관련된 다양한 메소드를 제공해준다.
        Optional<Member> selectedMember = memberRepository.findById(number);

        Member updateMember;
        if (selectedMember.isPresent()) {
            Member member = selectedMember.get();

            member.setName(name);

            updateMember = memberRepository.save(member);
        } else {
            // 존재하지 않을 경우 Exception
            throw new Exception();
        }

        return updateMember;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Member> selectedMember = memberRepository.findById(number);

        if (selectedMember.isPresent()) {
            Member member = selectedMember.get();

            memberRepository.delete(member);
        } else {
            throw new Exception();
        }
    }
}
