package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pmz on 2017/5/23 18:09.
 */
public class ExcelTest {

    @Test
    public void test1(){

        try (Workbook wb1 = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("d:/workbook1.xls")) {
            Sheet sheet1 = wb1.createSheet("饿哦没");
            wb1.createSheet("hello shhet");
            String safename = WorkbookUtil.createSafeSheetName("[O`Brain`s sales*?]s");
            wb1.createSheet(safename);

            CreationHelper ch = wb1.getCreationHelper();
            Row row = sheet1.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(1.2);
            row.createCell(1).setCellValue(1);
            row.createCell(2).setCellValue(ch.createRichTextString("this is string"));
            row.createCell(3).setCellValue(true);

            CellStyle cellStyle = wb1.createCellStyle();
            cellStyle.setDataFormat(ch.createDataFormat().getFormat("m/d/yy h:mm"));
            row.createCell(4).setCellValue(new Date());
            Cell cell1 = row.createCell(5);
            cell1.setCellValue(new Date());
            cell1.setCellStyle(cellStyle);

            CellStyle cellStyle1 = wb1.createCellStyle();
            cellStyle1.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle1.setBorderLeft(CellStyle.BORDER_DASH_DOT);
            cellStyle1.setLeftBorderColor(IndexedColors.BLUE.index);
            Cell cell2 = row.createCell(6);
            cell2.setCellStyle(cellStyle1);
            cell2.setCellValue(false);

            Row row1 = sheet1.createRow(1);
            row1.createCell(1).setCellValue(Calendar.getInstance());
            sheet1.addMergedRegion(new CellRangeAddress(1,1,1,2));
            wb1.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Workbook wk2 = new XSSFWorkbook();
            FileOutputStream fileOut2 = new FileOutputStream("d:/work2.xlsx")){
            Sheet sheet = wk2.createSheet();
            Row row = sheet.createRow(2);
            Cell cell = row.createCell(2);
            Cell cell1 = row.createCell(5);
            cell1.setCellValue(new Date());
            CellStyle cs2 = wk2.createCellStyle();
            cs2.setDataFormat(wk2.getCreationHelper().createDataFormat().getFormat("yyyy/m/d hh:mm:ss"));
            cell1.setCellStyle(cs2);
            cell.setCellValue("use \n with word wrap on to create a new line");
            CellStyle cs = wk2.createCellStyle();
            cs.setWrapText(true);
            cell.setCellStyle(cs);
            row.setHeightInPoints((2*sheet.getDefaultRowHeightInPoints()));
            sheet.autoSizeColumn(2);
            wk2.write(fileOut2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(System.getProperty("user.home"));
        System.out.println(path.getFileName());
        System.out.println(path.toAbsolutePath().getFileName());
    }
}
