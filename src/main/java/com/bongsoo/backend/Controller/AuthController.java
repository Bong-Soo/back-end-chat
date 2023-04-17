package com.bongsoo.backend.Controller;

import com.bongsoo.backend.dto.MemberDTO;
import com.bongsoo.backend.dto.MemberSigninDTO;
import com.bongsoo.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor    // final 변수 초기화
@RestController
public class AuthController {
    private final MemberService memberService;
    private final HttpSession session;

    @PostMapping("/sign_up")
    public String sign_up(@RequestBody MemberDTO memberDTO){
        return memberService.sign_up(memberDTO.toEntity());
    }

    @PostMapping("/sign_in")
    public String sign_in(@RequestBody MemberSigninDTO memberSigninDTO){
        Long result = memberService.sign_in(memberSigninDTO.toEntity());
        if(!result.equals(0L)) {
            session.setAttribute("Id", result);
            return "success";
        }
        return "fail";
    }

    @PostMapping("/sign_out")
    public String sign_out(){
        session.invalidate();
        return "success";
    }

}
