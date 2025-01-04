package com.grinder.web.admin.cafe;

import com.grinder.domain.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CafeAdminController {
    private final CafeService cafeService;
}
