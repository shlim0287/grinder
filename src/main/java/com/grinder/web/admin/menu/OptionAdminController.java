package com.grinder.web.admin.menu;

import com.grinder.domain.menu.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OptionAdminController {
    public final OptionService optionService;
}
