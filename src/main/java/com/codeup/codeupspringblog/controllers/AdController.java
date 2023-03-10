package com.codeup.codeupspringblog.controllers;

import org.springframework.ui.Model;
import com.codeup.codeupspringblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ad";
    }

    @GetMapping("/ads/{title}")
    public String adShowPage(@PathVariable String title, Model model) {
        model.addAttribute("title", adDao.findByTitle(title));
        return "ads/adsShow";
    }

}
