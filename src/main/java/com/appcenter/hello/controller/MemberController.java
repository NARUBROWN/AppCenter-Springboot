package com.appcenter.hello.controller;

import com.appcenter.hello.data.dto.MemberDTO;
import com.appcenter.hello.data.dto.MemberResponseDTO;
import com.appcenter.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    // MemberService를 상수로 선언
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<MemberResponseDTO> getMember(Long number) {
        MemberResponseDTO memberResponseDTO = memberService.getMember(number);

        return ResponseEntity.status(HttpStatus.OK).body(memberResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody MemberDTO memberDTO) {
        MemberResponseDTO memberResponseDTO = memberService.savedMember(memberDTO);

        return ResponseEntity.status(HttpStatus.OK).body(memberResponseDTO);
    }
}
