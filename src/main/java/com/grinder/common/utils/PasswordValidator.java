package com.grinder.common.utils;

import com.grinder.common.exception.PasswordValidationException;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$";
    private static final Pattern PATTERN = Pattern.compile(PASSWORD_PATTERN);

    public static void validatePassword(String password, String confirmPassword) {
        if (!PATTERN.matcher(password).matches()) {
            throw new PasswordValidationException("비밀번호는 8~20자리이며 영문, 숫자, 특수문자를 포함해야 합니다");
        }
        if (!password.equals(confirmPassword)) {
            throw new PasswordValidationException("비밀번호가 일치하지 않습니다");
        }
    }
}