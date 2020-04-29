package com.sample.docker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * https://spring.io/guides/gs/serving-web-content/
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("context", "SpringBoot Docker!");
        return "index";
    }

}
