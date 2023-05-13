package com.appcenter.hello.service;

import com.appcenter.hello.data.dto.MemberDTO;
import com.appcenter.hello.data.dto.MemberResponseDTO;

public interface MemberService {

    MemberResponseDTO getMember(Long number);

    MemberResponseDTO savedMember(MemberDTO memberDTO);

    MemberResponseDTO changeMember(Long number, String name) throws Exception;

    void deleteMember(Long number) throws Exception;
}
