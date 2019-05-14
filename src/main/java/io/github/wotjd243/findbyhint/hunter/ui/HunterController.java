package io.github.wotjd243.findbyhint.hunter.ui;

import io.github.wotjd243.findbyhint.hunter.domain.Hunter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HunterController {

    @GetMapping("/login")
    public String naverLogin(Model model) {

        return "/login";
    }

    @PostMapping("/buyOneBullet")
    public String buyOneBullet(Hunter hunter) {
        hunter.buyOneBullet();

        // 추후 화면 개발 후 변경
        return "redirect:/login";
    }



}
