package com.grinder.web.main.menu;

import com.grinder.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
}
