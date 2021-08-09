package net.madvirus.spring4.chap09.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class JgkimController {
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simpleForm() {
        return "simple_test";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    @ResponseBody
    public String simple(@RequestBody String body) {
        return body;
    }

    @RequestMapping(value = "/person_list.xml", method = RequestMethod.GET)
    @ResponseBody
    public XmlPersonTemplate listXml() {
        return getPersonList();
    }

    private XmlPersonTemplate getPersonList() {
        List<PersonTemplate> persons = Arrays.asList(
                new PersonTemplate("발악", "이름", 19, "남자"),
                new PersonTemplate("발악2", "이름2", 40, "여자")
        );
        return new XmlPersonTemplate(persons);
    }

    @RequestMapping(value = "/xml_test", method = RequestMethod.GET)
    public String requestPersonXmlView() {
        return "xml_test";
    }

    @RequestMapping(value = "/person_list.xml", method = RequestMethod.POST)
    @ResponseBody
    public XmlPersonTemplate requestListXml(@RequestBody XmlPersonTemplate xmlPersonTemplate) {
        return xmlPersonTemplate;
    }

}
