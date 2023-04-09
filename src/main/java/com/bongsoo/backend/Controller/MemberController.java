package com.bongsoo.backend.Controller;

import com.bongsoo.backend.dto.MemberDTO;
import com.bongsoo.backend.dto.MemberSigninDTO;
import com.bongsoo.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor    // final 변수 초기화
@RestController
public class MemberController {
    private final MemberService memberService;
    private final HttpSession session;

    @RequestMapping(value = "/sign_up",method = {RequestMethod.POST})
    public String sign_up(@RequestBody MemberDTO memberDTO){
        return memberService.sign_up(memberDTO.toEntity());
    }

    @RequestMapping(value = "/sign_in",method = {RequestMethod.POST})
    public String sign_in(@RequestBody MemberSigninDTO memberSigninDTO){
        String result = memberService.sign_in(memberSigninDTO.toEntity());
        if(result.equals("success"))
            session.setAttribute("ID", memberSigninDTO.getId());
        return result;
    }

    @RequestMapping(value = "/sign_out", method = {RequestMethod.POST})
    public String sign_out(){
        session.invalidate();
        return "success";
    }

}
