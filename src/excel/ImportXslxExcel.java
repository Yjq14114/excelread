package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by 佳琦 on 2016/3/31.
 */
public class ImportXslxExcel {
    public void improtexcel() throws Exception {
        Workbook workbook = null;
        Sheet sheet = null;
        String value = "";
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.CHINA);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
//        FileInputStream fs = new FileInputStream(new File("D:\\年度考核需求相关文件\\年度考核模板备份\\年度考核基站及配套模板.xls"));
        FileInputStream fs = new FileInputStream(new File("D:\\project\\砚山县_4529#砚山县布标_2016-03-20.xlsx"));
        try {
            workbook = WorkbookFactory.create(fs);
            sheet = workbook.getSheetAt(2);
            List<String> cellList = new ArrayList();
            int maxrow = sheet.getLastRowNum();
            for(int i=3;i<maxrow;i++){
                Row row = sheet.getRow(i);
                int start = row.getFirstCellNum();
                int end  = row.getLastCellNum();
                for(int j=start;j<end;j++){
                    int sheetMergeCount = sheet.getNumMergedRegions();
                    for(int k = 0;k<sheetMergeCount;k++){
                        CellRangeAddress ca = sheet.getMergedRegion(k);
                        int firstColumn = ca.getFirstColumn();
                        int lastColumn = ca.getLastColumn();
                        int firstRow = ca.getFirstRow();
                        int lastRow = ca.getLastRow();
                        if(i >= firstRow && i <= lastRow){
                            if(j >= firstColumn && j <= lastColumn){
                                Row fRow = sheet.getRow(firstRow);
                                Cell fCell = fRow.getCell(firstColumn);
                                int type = fCell.getCellType();
                                switch (type){
                                    case Cell.CELL_TYPE_NUMERIC:
                                        value = nf.format(fCell.getNumericCellValue());
                                        break;
                                    case Cell.CELL_TYPE_FORMULA:
                                        value = nf.format(fCell.getNumericCellValue());
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        value = fCell.getStringCellValue();
                                        break;
                                    case Cell.CELL_TYPE_BLANK:
                                        value = "";
                                        break;
                                }
                                break;
                            }else{
                                Cell cell = row.getCell(j);
                                int type = cell.getCellType();
                                switch (type){
                                    case Cell.CELL_TYPE_NUMERIC:
                                        value = nf.format(cell.getNumericCellValue());
                                        break;
                                    case Cell.CELL_TYPE_FORMULA:
                                        value = nf.format(cell.getNumericCellValue());
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        value = cell.getStringCellValue();
                                        break;
                                    case Cell.CELL_TYPE_BLANK:
                                        value = "";
                                        break;
                                }
                            }
                        }
                    }
                    System.out.println("第"+i+"行:"+"第"+j+"列:"+"值"+value);
                    cellList.add(value);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
          e.printStackTrace();
        } finally {
            fs.close();
        }
    }
    public void excelIO(Workbook workbook,Sheet sheet) throws Exception{
        String value = "";
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.CHINA);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        try {
            int sheetNum = workbook.getNumberOfSheets();
            for(int l=0;l<sheetNum;l++){
                sheet = workbook.getSheetAt(l);
                int maxrow = sheet.getLastRowNum();
                for(int i=3;i<maxrow;i++){
                    Row row = sheet.getRow(i);
                    int start = row.getFirstCellNum();
                    int end  = row.getLastCellNum();
                    for(int j=start;j<end;j++){
                        int sheetMergeCount = sheet.getNumMergedRegions();
                        for(int k = 0;k<sheetMergeCount;k++){
                            CellRangeAddress ca = sheet.getMergedRegion(k);
                            int firstColumn = ca.getFirstColumn();
                            int lastColumn = ca.getLastColumn();
                            int firstRow = ca.getFirstRow();
                            int lastRow = ca.getLastRow();
                            if(i >= firstRow && i <= lastRow){
                                if(j >= firstColumn && j <= lastColumn){
                                    Row fRow = sheet.getRow(firstRow);
                                    Cell fCell = fRow.getCell(firstColumn);
                                    int type = fCell.getCellType();
                                    switch (type){
                                        case Cell.CELL_TYPE_NUMERIC:
                                            value = nf.format(fCell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_FORMULA:
                                            value = nf.format(fCell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_STRING:
                                            value = fCell.getStringCellValue();
                                            break;
                                        case Cell.CELL_TYPE_BLANK:
                                            value = "";
                                            break;
                                    }
                                    break;
                                }else{
                                    Cell cell = row.getCell(j);
                                    int type = cell.getCellType();
                                    switch (type){
                                        case Cell.CELL_TYPE_NUMERIC:
                                            value = nf.format(cell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_FORMULA:
                                            value = nf.format(cell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_STRING:
                                            value = cell.getStringCellValue();
                                            break;
                                        case Cell.CELL_TYPE_BLANK:
                                            value = "";
                                            break;
                                    }
                                }
                            }
                        }
                        System.out.println("第"+i+"行:"+"第"+j+"列:"+"值"+value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
    public static void main(String[] args) throws Exception {
        ImportXslxExcel is = new ImportXslxExcel();
        is.improtexcel();
    }
}
