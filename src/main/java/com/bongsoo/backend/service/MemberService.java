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
        try {
            memberRepository.save(member);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "fail";
        }
        return "success";
    }

    public Long sign_in(Member member){
        // 유저 검색
        Optional<Member> findMember = memberRepository.findByMemberId(member.getMemberId());
        // NULL
        if(findMember.isPresent()){ // 결과 확인
            if(findMember.get().getPw().equals(member.getPw())) // 비밀번호 대조
                return findMember.get().getId();
        }
        return 0L;
    }
}
