package com.grinder.web.main.cafe;

import com.grinder.domain.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;
}
