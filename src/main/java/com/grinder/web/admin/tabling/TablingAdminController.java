package com.grinder.web.admin.tabling;

import com.grinder.domain.tabling.service.TablingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TablingAdminController {
    private final TablingService tablingService;
}
