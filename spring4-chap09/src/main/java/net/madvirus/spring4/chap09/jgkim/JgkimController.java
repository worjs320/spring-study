package net.madvirus.spring4.chap09.jgkim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/person_list.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonPersonTemplate jsonPersonTemplate() {
         List<PersonTemplate> persons = Arrays.asList(
                new PersonTemplate("발악", "이름", 19, "남자"),
                new PersonTemplate("발악2", "이름2", 40, "여자")
        );
        return new JsonPersonTemplate(persons);
    }

    @RequestMapping(value = "/file/upload_form", method = RequestMethod.GET)
    public String fileUploadForm() {
        return "file/file_upload";
    }

    private final String uploadPath = System.getProperty("java.io.tmpdir");

    @RequestMapping(value = "/file/multipart", method = RequestMethod.POST)
    public String uploadByMultipartFile(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
         if(!multipartFile.isEmpty()) {
             byte[] bytes = multipartFile.getBytes();
             File file = new File(uploadPath, multipartFile.getOriginalFilename());
             multipartFile.transferTo(file);
             model.addAttribute("title", "MultipartFile");
             model.addAttribute("fileName", multipartFile.getOriginalFilename());
             model.addAttribute("uploadPath", uploadPath);
             return "file/file_upload_success";
         }

         return "file/file_upload_fail";
    }

    @PostMapping("/file/multipartHttpServletRequest")
    public String uploadByMultipartHttpServletRequest(MultipartHttpServletRequest request, Model model) throws IOException {
        MultipartFile multipartFile = request.getFile("file");
         if(!multipartFile.isEmpty()) {
             File file = new File(uploadPath, multipartFile.getOriginalFilename());
             multipartFile.transferTo(file);
             model.addAttribute("title", "MultipartHttpServletRequest");
             model.addAttribute("fileName", multipartFile.getOriginalFilename());
             model.addAttribute("uploadPath", uploadPath);
             return "file/file_upload_success";
         }

         return "file/file_upload_fail";
    }
}
