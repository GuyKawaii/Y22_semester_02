package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Basket;
import com.example.cookieshop.models.Cookie;
import com.example.cookieshop.repositories.CookieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CookieController {
    CookieRepository repo = new CookieRepository();
    ArrayList<Cookie> basket = new ArrayList<>();

    @GetMapping("/")
    public String index(HttpSession session) {


        
        session.setAttribute("basket", basket);
        return "index";
    }

    @GetMapping("/basket")
    public String basket(HttpSession session, Model model) {

        // create basket

        // add basket
        model.addAttribute("basket", session.getAttribute("basket"));

        return "basket";
    }

    @GetMapping("/shop")
    public String shop(HttpSession session, Model cookieModel) {
        cookieModel.addAttribute("cookies", repo.getAllCookies());
        return "shop";
    }

    @GetMapping("/addToBasket")
    public String add(@RequestParam String id, HttpServletRequest request) {

        int cookieId = Integer.parseInt(id);
        Cookie cookie = repo.getCookieById(cookieId);

        HttpSession session = request.getSession();
        ArrayList<Cookie> basket = (ArrayList<Cookie>) session.getAttribute("basket");

        basket.add(cookie);

        session.setAttribute("basket", basket);


        return "redirect:/basket";
    }






    // EXTRA STUFF
    @GetMapping("/session")
    public String sessionExample(HttpSession session) {
        return "index";
    }

    @GetMapping("/getDataFromSession")
    public String getDataFromSession(HttpSession session) {
        Cookie magicCookie = (Cookie) session.getAttribute("cookie");
        return "index";
    }

    @GetMapping("/invalidate-session")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "redirect:index";
    }

    @GetMapping("/get-session-rendered")
    public String getSessionRendered() {
        return "session.html";
    }

}
