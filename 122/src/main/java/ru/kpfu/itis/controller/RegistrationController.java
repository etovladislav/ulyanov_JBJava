package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationUser(@ModelAttribute("userform") @Valid UserRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.saveUser(form);
        return "redirect:/";
    }

    @RequestMapping(value = "/valid/username", method = RequestMethod.POST)
    @ResponseBody
    public String validFormRegistration(@RequestParam("username") String username) {
        username = username.trim();
        if (userService.checkUser(username)) {
            return "This username is used";
        }
        return null;
    }
}
