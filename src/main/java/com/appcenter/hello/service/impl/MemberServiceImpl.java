package com.appcenter.hello.service.impl;

import com.appcenter.hello.data.dao.MemberDAO;
import com.appcenter.hello.data.dto.MemberDTO;
import com.appcenter.hello.data.dto.MemberResponseDTO;
import com.appcenter.hello.data.entity.Member;
import com.appcenter.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    // 상수로 DAO 선언
    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }


    @Override
    public MemberResponseDTO getMember(Long number) {
        Member member = memberDAO.selectMember(number);

        // 리턴할 새로운 DTO 객체 생성
        // Entity 객체에서 get해서 DTO 객체에 set
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setNumber(member.getNumber());
        memberResponseDTO.setName(member.getName());
        memberResponseDTO.setPassword(member.getPassword());
        memberResponseDTO.setEmail(member.getEmail());

        return memberResponseDTO;
    }

    @Override
    public MemberResponseDTO savedMember(MemberDTO memberDTO) {

        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setPassword(memberDTO.getPassword());
        member.setEmail(memberDTO.getEmail());

        Member savedMember = memberDAO.insertMember(member);

        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setNumber(savedMember.getNumber());
        memberResponseDTO.setName(savedMember.getName());
        memberResponseDTO.setPassword(savedMember.getPassword());
        memberResponseDTO.setEmail(savedMember.getEmail());

        return memberResponseDTO;
    }

    @Override
    public MemberResponseDTO changeMemberinfo(Long number, String name) throws Exception {
        Member changedMember = memberDAO.updateMember(number, name);

        // DTO 객체에 담아 리턴
        // DTO 객체 선언
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setNumber(changedMember.getNumber());
        memberResponseDTO.setName(changedMember.getName());
        memberResponseDTO.setPassword(changedMember.getPassword());
        memberResponseDTO.setEmail(changedMember.getEmail());

        return memberResponseDTO;
    }

    @Override
    public void deleteMember(Long number) throws Exception {
        // DAO에서 delete 메소드 호출
        memberDAO.deleteProduct(number);
    }
}
