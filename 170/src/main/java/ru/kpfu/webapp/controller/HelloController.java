package ru.kpfu.webapp.controller;


import kpfu.VladislavService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderHelloView() {
        VladislavService vladislavService = new VladislavService();
        System.out.println(vladislavService.getVladName());
        return "index";
    }
}
