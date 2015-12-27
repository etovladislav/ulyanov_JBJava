package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.UserSettingsForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.UserUtil;

import javax.validation.Valid;

@Controller
public class SettingsController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        User user = UserUtil.getPrincipal();
        model.addAttribute("userform", new UserSettingsForm());
        model.addAttribute("user", user);
        return "settings";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String registrationUser(@ModelAttribute("userform") @Valid UserSettingsForm form,
                                   BindingResult result, Model model) {
        User user = UserUtil.getPrincipal();
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "settings";
        }
        userService.updateUserInfo(form, user);
        return "redirect:/" + user.getUsername();
    }
}
