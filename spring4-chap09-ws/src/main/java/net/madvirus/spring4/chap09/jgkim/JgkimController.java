package net.madvirus.spring4.chap09.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JgkimController {
    @GetMapping(value = "/test")
    public String requestPersonXmlView() {
        return "test";
    }

    @GetMapping("/echoHandler")
    public String echoHandler() {
        return "echo_handler";
    }

    @GetMapping("/chat_view")
    public String chat_view() {
        return "chat_view";
    }
}
