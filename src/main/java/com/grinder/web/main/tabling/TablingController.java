package com.grinder.web.main.tabling;

import com.grinder.domain.tabling.service.TablingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TablingController {
    private final TablingService tablingService;
}
