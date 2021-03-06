package ru.kpfu.itis.jetbrains.hw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.jetbrains.hw2.model.User;
import ru.kpfu.itis.jetbrains.hw2.service.UserService;

/**
 * Created by Vladislav on 11.10.2015.
 */
@Controller
public class UsersController {

    @Autowired
    UserService service;

    @RequestMapping(value = {"/", "index"})
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/table")
    public String showTable(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "table";
    }

    @RequestMapping(value = "/table", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("users") User user) {
        service.addUser(user);
        return "redirect:/table";
    }
}
