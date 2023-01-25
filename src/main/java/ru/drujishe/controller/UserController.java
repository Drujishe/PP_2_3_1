package ru.drujishe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping(value = "/")
    public String goIndex(Model model){
        System.out.println("вернул индекс");
        return "index";
    }
}
