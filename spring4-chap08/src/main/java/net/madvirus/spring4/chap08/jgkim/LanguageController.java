package net.madvirus.spring4.chap08.jgkim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LanguageController {
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    public LanguageController(MessageSource messageSource, LocaleResolver localeResolver) {
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @RequestMapping(value = "/message_view")
    public String messageView(Locale locale, HttpServletRequest request, Model model) {
        model.addAttribute("clientLocale", locale);
        model.addAttribute("sessionLocale", localeResolver.resolveLocale(request));
        model.addAttribute("siteCount", messageSource.getMessage("test", null, localeResolver.resolveLocale(request)));
        return "message_view";
    }

//    @RequestMapping(value = "/changeLocale/{lang}")
//    public String changeLocale(@PathVariable("lang") String lang, HttpServletRequest request, HttpServletResponse response) {
//        Locale locale = new Locale(lang);
//        localeResolver.setLocale(request, response, locale);
//        return "message_view";
//    }
}
