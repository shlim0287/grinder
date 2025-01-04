package com.grinder.web.admin.image;

import com.grinder.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ImageAdminController {
    private final ImageService imageService;
}
