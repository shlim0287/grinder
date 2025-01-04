package com.grinder.web.admin.menu;

import com.grinder.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MenuAdminController {
    private final MenuService menuService;
}
