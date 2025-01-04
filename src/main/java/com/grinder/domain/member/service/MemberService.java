package com.grinder.domain.member.service;

import com.grinder.common.utils.PasswordValidator;
import com.grinder.domain.member.implement.MemberManager;
import com.grinder.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberManager memberManager;


    public Member register(String email, String password, String confirmPassword) {
        memberManager.validateDuplicateEmail(email);

        PasswordValidator.validatePassword(password, confirmPassword);

        return memberManager.save(email, password);
    }
}
