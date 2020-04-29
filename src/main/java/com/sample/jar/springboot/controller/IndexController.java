package com.sample.jar.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * https://spring.io/guides/gs/serving-web-content/
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) throws Exception {
        model.addAttribute("context", "SpringBoot JAR!");
        return "index";
    }

}
