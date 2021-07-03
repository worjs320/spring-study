package net.madvirus.spring4.chap07.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JgkimController {
    @RequestMapping("/test.jgkim")
    public String jgkim(Model model) {
        model.addAttribute("name", "jgkim");
        model.addAttribute("age", "22");
        return "test";
    }
}
