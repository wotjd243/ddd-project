package io.github.wotjd243.findbyhint.hunter.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HunterController {

    @GetMapping("/login")
    public String naverLogin(Model model) {

        return "/login";
    }



}
