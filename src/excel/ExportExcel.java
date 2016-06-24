package excel;


import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by yjq on 2016/6/12.
 */
public class ExportExcel {


    public void exportExcel() throws Exception{

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet xssfSheet = workbook.createSheet("sheet1");

        // 设置excel每列宽度
        xssfSheet.setColumnWidth(0,4000);
        xssfSheet.setColumnWidth(1,3500);
        //创建字体样式
        XSSFCellStyle style = getXssfCellStyle(workbook);

        // 创建Excel的sheet的一行------------------------
        XSSFRow row = xssfSheet.createRow(0);
        //row.setHeight((short) 100);// 设定行的高度
        // 创建一个Excel的单元格
        XSSFCell cell = row.createCell(0);
        // 合并单元格(startRow，endRow，startColumn，endColumn)
        xssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,0));
        cell.setCellStyle(style);
        cell.setCellValue("hello world");
        XSSFCell cell1 = row.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("nihao");


        //设置单元格内容格式
        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));
        style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style1.setWrapText(true);//自动换行
        row = xssfSheet.createRow(1);

        // 设置单元格的样式格式
        for(int i=0;i<5;i++){
            cell = row.createCell(i);
            cell.setCellStyle(style1);
            cell.setCellValue("nihao");
        }

        FileOutputStream os = new FileOutputStream("D:\\tmp\\workbook.xlsx");
        workbook.write(os);
        os.close();
    }

    private XSSFCellStyle getXssfCellStyle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setFontName("Verdana");
        font.setBoldweight((short) 100);
        font.setFontHeight((short) 300);
        font.setColor(HSSFColor.BLUE.index);
        //创建单元格样式
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER); //设置居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);//设置单元格背景色
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        //设置边框
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setFont(font);
        return style;
    }

    public static void main(String[] args) throws Exception {
        ExportExcel excel = new ExportExcel();
        excel.exportExcel();
    }
}
