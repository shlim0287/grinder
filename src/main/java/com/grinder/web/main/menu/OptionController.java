package com.grinder.web.main.menu;

import com.grinder.domain.menu.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OptionController {
    public final OptionService optionService;
}
