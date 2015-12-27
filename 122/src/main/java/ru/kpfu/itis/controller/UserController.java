package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.util.UserUtil;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{username}")
    public String getUserPage(Model model, @PathVariable("username") String username) {
        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            return "404";
        }
        model.addAttribute("user", user);
        return "/page";
    }

    @RequestMapping(value = "/all-users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/followers";
    }

    @RequestMapping(value = "/im")
    public String getUserPage() {
        User user = UserUtil.getPrincipal();
        return "redirect:/" + user.getUsername();
    }

}
