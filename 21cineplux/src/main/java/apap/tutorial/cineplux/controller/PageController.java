package apap.tutorial.cineplux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    private String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
