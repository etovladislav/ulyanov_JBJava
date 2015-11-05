package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.MedClinic;
import ru.kpfu.itis.model.Office;
import ru.kpfu.itis.model.People;
import ru.kpfu.itis.model.Provider;
import ru.kpfu.itis.service.MedClinicService;
import ru.kpfu.itis.service.StuffService;

@Controller
public class MainController {
    @Autowired
    MedClinicService medClinicService;

    @Autowired
    StuffService stuffService;

    @RequestMapping(value = "/getbestoffice")
    public String getBestOffice(@ModelAttribute MedClinic medClinic, Model model) {
        model.addAttribute("bestoffice", medClinicService.getBestOffice(medClinic));
        return "bestoffice";
    }

    @RequestMapping(value = "/getbestclinic")
    public String getBestMedClinic(Model model) {
        model.addAttribute("bestclinic", medClinicService.getBestMedClinic());
        return "bestclinic";
    }

    @RequestMapping(value = "/getsalary")
    public String getSalary(@ModelAttribute MedClinic medClinic, Model model) {
        model.addAttribute("salary", medClinicService.getSalary(medClinic));
        return "salary";
    }

    @RequestMapping(value = "/getaveragecheck")
    public String getAverageCheck(@ModelAttribute MedClinic medClinic, @ModelAttribute Office office, Model model) {
        model.addAttribute("averagecheck", medClinicService.getAverageCheck(medClinic, office));
        return "averagecheck";
    }

    @RequestMapping(value = "/getsumofficecheck")
    public String getSumOfficeCheck(@ModelAttribute MedClinic medClinic, Model model) {
        model.addAttribute("salary", medClinicService.getSumOfficeCheck(medClinic));
        return "sumofficecheck";
    }

    @RequestMapping(value = "/getlastsending")
    public String getLastSending(@ModelAttribute MedClinic medClinic, @ModelAttribute Provider provider, Model model) {
        model.addAttribute("lastsending", medClinicService.getLastSending(medClinic, provider));
        return "lastsending";
    }

    @RequestMapping(value = "/getstuffsalary")
    public String getStuffSalary(@ModelAttribute People people, Model map) {
        map.addAttribute("stuffsalary", stuffService.getStuffSalary(people));
        return "stuffsalary";
    }

    @RequestMapping(value = "/getlastsending")
    public String getEmployedDate(@ModelAttribute People people, Model map) {
        map.addAttribute("lastsending", stuffService.getEmployedDate(people));
        return "employedate";
    }
}
