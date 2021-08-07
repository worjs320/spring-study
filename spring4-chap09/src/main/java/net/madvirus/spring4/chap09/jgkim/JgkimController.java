package net.madvirus.spring4.chap09.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/simple")
public class JgkimController {
    @RequestMapping(method = RequestMethod.GET)
    public String simpleForm() {
        return "simple_test";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String simple(@RequestBody String body) {
        return body;
    }
}
