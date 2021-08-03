package net.madvirus.spring4.chap08.jgkim;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.madvirus.spring4.chap08.stat.PageRank;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {

    private WebApplicationContext context = null;

    @RequestMapping(value = "/file/{fileId}")
    public ModelAndView download(@PathVariable String fileId, HttpServletResponse response) throws IOException {
        File downloadFile = getFile(fileId);
        if (downloadFile == null) {
            response.sendError(HttpServletResponse.SC_ACCEPTED);
            return null;
        }
        return new ModelAndView("jgkimDownload", "downloadFile", downloadFile);
    }

    private File getFile(String fileId) {
        String baseDir = context.getServletContext().getRealPath(
                "/WEB-INF/files");
        if (fileId.equals("1"))
            return new File(baseDir, "test.zip");
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = (WebApplicationContext) applicationContext;
    }

    @RequestMapping(value = "/file/personExcel")
    public String personExcel(Model model) {
        List<PersonTemplate> personList = Arrays.asList(
                new PersonTemplate("발악", "남자", 19, "010-1234-1234"),
                new PersonTemplate("발악2", "여자", 20, "010-1234-5678"),
                new PersonTemplate("발악3", "중성", 100, "010-0000-0000")
        );
        model.addAttribute("personList", personList);
        return "personXlsxView";
    }

    @RequestMapping(value = "/file/personPdf")
    public String personPdf(Model model) {
        List<PersonTemplate> personList = Arrays.asList(
                new PersonTemplate("발악", "남자", 19, "010-1234-1234"),
                new PersonTemplate("발악2", "여자", 20, "010-1234-5678"),
                new PersonTemplate("발악3", "중성", 100, "010-0000-0000")
        );
        model.addAttribute("personList", personList);
        return "personPdfView";
    }

}
