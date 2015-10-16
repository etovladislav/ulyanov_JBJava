package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.service.ScoreService;

@Controller
public class MainController {

    @Autowired
    ScoreService userService;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/average", method = RequestMethod.POST)
    public String getAverage(@ModelAttribute Student student, Model map) {
        map.addAttribute("average", userService.getAverage(student));
        return "average";
    }

    @RequestMapping(value = "/tp", method = RequestMethod.POST)
    public String getTotalPoint(@ModelAttribute Student student, Model map) {
        map.addAttribute("tp", userService.getScore(student));
        return "tp";
    }

    @RequestMapping(value = "/pointsubj", method = RequestMethod.POST)
    public String getScoreSubject(@ModelAttribute Student student,
                                  @RequestParam(value = "subject") Integer val,
                                  Model map) {
        map.addAttribute("pointsubj", userService.getScoreSubject(student, val));
        return "pointsubj";
    }
}
