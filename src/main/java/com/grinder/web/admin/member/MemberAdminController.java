package com.grinder.web.admin.member;

import com.grinder.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberAdminController {
    private final MemberService memberService;


}
