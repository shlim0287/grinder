package com.grinder.web.main.member;

import com.grinder.common.exception.MemberException;
import com.grinder.common.exception.PasswordValidationException;
import com.grinder.domain.member.model.MemberRegister;
import com.grinder.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid MemberRegister request,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "main/register";
        }

        try {
            memberService.register(request.getEmail(), request.getPassword(), request.getConfirmPassword());

            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");
            return "redirect:/login";
        } catch (MemberException | PasswordValidationException e) {
            if (e instanceof PasswordValidationException) {
                bindingResult.rejectValue("confirmPassword", "error", e.getMessage());
            } else bindingResult.rejectValue("email", "error", e.getMessage());
        }

        model.addAttribute("bindingResult", bindingResult);
        return "main/register";
    }
}