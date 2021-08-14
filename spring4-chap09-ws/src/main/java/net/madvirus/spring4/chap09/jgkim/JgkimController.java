package net.madvirus.spring4.chap09.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JgkimController {
    @GetMapping(value = "/test")
    public String requestPersonXmlView() {
        return "test";
    }
}
