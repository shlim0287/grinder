package com.grinder.web.admin.cart;

import com.grinder.domain.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CartAdminController {
    public final CartService CartService;
}
