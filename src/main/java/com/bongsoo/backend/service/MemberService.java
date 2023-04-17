package com.bongsoo.backend.service;

import com.bongsoo.backend.model.Member;
import com.bongsoo.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public String sign_up(Member member){
        try {memberRepository.save(member);}        // 회원가입(정보 저장)
        catch (Exception e){                        // 예외처리
            System.out.println(e.getMessage());
            return "fail";
        }
        return "success";
    }

    public Long sign_in(Member member){
        Optional<Member> findMember = memberRepository.findByUserId(member.getUserId());    // Member 검색
        if(findMember.isPresent() && findMember.get().getPw().equals(member.getPw()))       // 1. 예외처리 2. 비밀번호 대조
            return findMember.get().getId();
        return 0L;
    }
}
