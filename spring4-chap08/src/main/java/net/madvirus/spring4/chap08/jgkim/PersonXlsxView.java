package net.madvirus.spring4.chap08.jgkim;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

@Component("personXlsxView")
public class PersonXlsxView extends AbstractXlsxView {
    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"personExcel.xlsx\";");

        Sheet sheet = createFirstSheet(workbook);
        createColumnLabel(sheet);

        List<PersonTemplate> personList = (List<PersonTemplate>) model.get("personList");
        int rowNum = 1;
        for (PersonTemplate person : personList) {
            createPageRankRow(sheet, person, rowNum++);
        }
    }

    private Sheet createFirstSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "사용자 정보");
        sheet.setColumnWidth(0, 200 * 20);
        sheet.setColumnWidth(1, 100 * 20);
        sheet.setColumnWidth(2, 100 * 20);
        sheet.setColumnWidth(3, 400 * 20);
        return sheet;
    }

    private void createColumnLabel(Sheet sheet) {
        Row firstRow = sheet.createRow(0);
        Cell cell = firstRow.createCell(0);
        cell.setCellValue("이름");

        cell = firstRow.createCell(1);
        cell.setCellValue("나이");

        cell = firstRow.createCell(2);
        cell.setCellValue("성별");

        cell = firstRow.createCell(3);
        cell.setCellValue("핸드폰 번호");
    }

    private void createPageRankRow(Sheet sheet, PersonTemplate person, int rowNum) {
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(0);
        cell.setCellValue(person.getName());

        cell = row.createCell(1);
        cell.setCellValue(person.getAge());

        cell = row.createCell(2);
        cell.setCellValue(person.getGender());

        cell = row.createCell(3);
        cell.setCellValue(person.getPhoneNumber());
    }

}
