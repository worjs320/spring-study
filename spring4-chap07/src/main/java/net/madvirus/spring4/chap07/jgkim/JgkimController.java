package net.madvirus.spring4.chap07.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JgkimController {
    @RequestMapping("/test.jgkim")
    public String jgkim(Model model) {
        model.addAttribute("name", "jgkim");
        model.addAttribute("age", "22");
        return "test";
    }

    @RequestMapping(value = {"/multi1/{pathValue}", "/multi2/{pathValue}"}, method = RequestMethod.GET)
    public String multi(Model model, @PathVariable String pathValue, @RequestParam(value = "id", defaultValue = "default") String id) {
        model.addAttribute("name", "jgkim");
        model.addAttribute("age", "22");
        model.addAttribute("pathValue", pathValue);
        model.addAttribute("paramValue", id);
        return "test";
    }

    @RequestMapping(value = "/userForm.jgkim", method = RequestMethod.GET)
    public String userForm() {
        return "userForm";
    }

    @RequestMapping(value = "/register.jgkim", method = RequestMethod.POST)
    public String register(@ModelAttribute("test") UserTemplate userTemplate) {
        return "registered";
    }

    @ModelAttribute("listModel")
    public List<String> numberList() {
        List<String> testList = new ArrayList<>();
        testList.add("하나");
        testList.add("둘");
        testList.add("셋");
        return testList;
    }

    @RequestMapping(value = "/modelAttribute.jgkim", method = RequestMethod.GET)
    public String modelAttribute(Model model, @ModelAttribute("listModel") List<String> modelAttributeList) {
        model.addAttribute("modelAttributeList", modelAttributeList);
        return "modelAttribute";
    }
}
