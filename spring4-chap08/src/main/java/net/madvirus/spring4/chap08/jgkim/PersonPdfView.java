package net.madvirus.spring4.chap08.jgkim;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component("personPdfView")
public class PersonPdfView extends AbstractPdfView {
    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<PersonTemplate> personList = (List<PersonTemplate>) map.get("personList");

        Table table = new Table(4, personList.size() + 1);
        table.setPadding(5);

        String fontPath = "c:\\windows\\Fonts\\Gaesung.ttf";
        BaseFont bfKorean = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Font font = new Font(bfKorean);
        Cell cell = new Cell(new Paragraph("이름", font));
        cell.setHeader(true);
        table.addCell(cell);

        cell = new Cell(new Paragraph("나이", font));
        table.addCell(cell);
        table.endHeaders();

        cell = new Cell(new Paragraph("성별", font));
        table.addCell(cell);
        table.endHeaders();

        cell = new Cell(new Paragraph("핸드폰 번호", font));
        table.addCell(cell);
        table.endHeaders();

        for (PersonTemplate person : personList) {
            table.addCell(new Paragraph(person.getName(), font));
            table.addCell(Integer.toString(person.getAge()));
            table.addCell(new Paragraph(person.getGender(), font));
            table.addCell(new Paragraph(person.getPhoneNumber(), font));
        }

        document.add(table);
    }

}
