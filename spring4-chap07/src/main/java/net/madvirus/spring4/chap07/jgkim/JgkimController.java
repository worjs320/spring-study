package net.madvirus.spring4.chap07.jgkim;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("userTemplate")
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
    public String userForm(Model model) {
        model.addAttribute("userTemplate", new UserTemplate());
        return "userForm";
    }

    @RequestMapping(value = "/deleteSession.jgkim", method = RequestMethod.GET)
    public String deleteSession(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "userForm";
    }

    private static final String USER_FORM = "userForm";
//    @RequestMapping(value = "/register.jgkim", method = RequestMethod.POST)
//    public String register(@ModelAttribute("userTemplate") @Valid UserTemplate userTemplate, BindingResult bindingResult, Errors errors) {
//        new UserValidator().validate(userTemplate, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return USER_FORM;
//        }
//        return "registered";
//    }

    @RequestMapping(value = "/register.jgkim", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("userTemplate") UserTemplate userTemplate, Errors errors) {
        if (errors.hasErrors()) {
            return USER_FORM;
        }
        return "registered";
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder webDataBinder) {
//        CustomDateEditor customDateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
//        webDataBinder.registerCustomEditor(Date.class, customDateEditor);
//    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder){
//        binder.addValidators(new UserValidator());
//    }

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

    @RequestMapping(value = "/header.jgkim", method = RequestMethod.GET)
    public String header(@RequestHeader Map<String, Object> requestHeader,
                         @CookieValue(value = "auth", defaultValue = "default cookie") String cookieAuth,
                         Model model) {
        model.addAttribute("header", requestHeader);
        model.addAttribute("cookieAuth", cookieAuth);
        return "header";
    }

    @RequestMapping(value = "/prev_redirect.jgkim", method = RequestMethod.GET)
    public String prevRedirect() {
        return "prev_redirect";
    }

    @RequestMapping(value = "/redirect.jgkim", method = RequestMethod.GET)
    public String redirect(@RequestParam(value = "cookieValue", defaultValue = "default cookie") String cookieValue,
                           HttpServletResponse response) {
        Cookie cookie = new Cookie("test", cookieValue);
        response.addCookie(cookie);
        return "redirect:/header.jgkim";
    }

    @RequestMapping(value = "/exception_view.jgkim", method = RequestMethod.GET)
    public String exceptionView() {
        return "exception_view";
    }

    @RequestMapping(value = "/exception.jgkim", method = RequestMethod.POST)
    public String exception(Model model, @RequestParam("num1") int num1, @RequestParam int num2) {
        model.addAttribute("result", num1/num2);
        return "exception_view";
    }

    @ExceptionHandler(Exception.class)
    public String ExceptionHandler() {
        return "error";
    }
}
