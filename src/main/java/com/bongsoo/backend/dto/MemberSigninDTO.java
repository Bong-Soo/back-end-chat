package com.bongsoo.backend.dto;

import com.bongsoo.backend.model.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSigninDTO {

    private String id;
    private String pw;

    public Member toEntity(){
        return Member.builder()
                .userId(id)
                .pw(pw)
                .build();
    }

}
