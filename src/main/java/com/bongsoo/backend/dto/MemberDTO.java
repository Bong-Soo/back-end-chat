package com.bongsoo.backend.dto;

import com.bongsoo.backend.model.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {

    private String id;
    private String pw;
    private String name;

    public Member toEntity(){
        return Member.builder()
                .userId(id)
                .pw(pw)
                .name(name)
                .build();
    }

}
