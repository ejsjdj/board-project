package com.example.board.common.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtils {

    public static void setCookie(HttpServletResponse res, String name, String value, int expSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        if (expSeconds > 0) cookie.setMaxAge(expSeconds);

        res.addCookie(cookie);

    }
}
