package excel;

import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by 佳琦 on 2016/4/7.
 */
public class WriteExcel {
    public  void write() throws Exception{
        Workbook workbook = null;
        String value = "";
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.CHINA);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        //        FileInputStream fs = new FileInputStream(new File("D:\\年度考核需求相关文件\\年度考核模板备份\\年度考核基站及配套模板.xls"));
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\佳琦\\Desktop\\新建 Microsoft Excel 工作表.xlsx"));
//        POIFSFileSystem ps=new POIFSFileSystem(fis);
        try {
            workbook = WorkbookFactory.create(fis);
            fis.close();
            Sheet sheet = workbook.getSheetAt(1);
            FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\佳琦\\Desktop\\新建 Microsoft Excel 工作表.xlsx"));
            for(int i=0;i<13;i++){
                Row  row = sheet.createRow(i);
                row.createCell((short) 0).setCellValue("我是单元格");
            }
            fos.flush();
            workbook.write(fos);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
        }
    }
    public static void main(String[] args) throws Exception {
        WriteExcel excel = new WriteExcel();
        excel.write();
    }
}
