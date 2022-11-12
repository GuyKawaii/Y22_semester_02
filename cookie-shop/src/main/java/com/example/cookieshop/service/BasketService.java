package com.example.cookieshop.service;

import com.example.cookieshop.models.Cookie;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class BasketService {

    public HttpSession setupBasket(HttpSession session) {

        if (session.getAttribute("basket") == null) session.setAttribute("bakset", new ArrayList<Cookie>());

        return session;
    }

}
