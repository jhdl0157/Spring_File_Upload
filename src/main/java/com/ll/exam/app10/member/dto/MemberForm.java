package com.ll.exam.app10.member.dto;


import com.ll.exam.app10.member.entity.Member;
import lombok.*;

@Data
@NoArgsConstructor
public class MemberForm {
    private String memberId;
    private String password;
    private String email;

    @Builder
    public MemberForm(String memberId, String password, String email) {
        this.memberId = memberId;
        this.password = password;
        this.email = email;
    }

}
