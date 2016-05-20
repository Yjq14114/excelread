package excel;


import jxl.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳琦 on 2016/4/1.
 */
public class ImportJxlExcel {
    public void importExcel() throws Exception{
        jxl.Workbook rwb = null;
        InputStream stream = new FileInputStream("D:\\project\\砚山县_4529#砚山县布标_2016-03-20.xls");
        try{
            rwb = jxl.Workbook.getWorkbook(stream);
            jxl.Sheet sheet = rwb.getSheet(2);
            int len = sheet.getRows();
            for(int i=3;i<len;i++){
                List<String> cellList = new ArrayList();
                for(int j=0;j<sheet.getColumns();j++){
                    String str = null;
                    str = sheet.getCell(j,i).getContents();
                    Range[] ranges = sheet.getMergedCells();
                    for (Range r : ranges) {
                        if (i > r.getTopLeft().getRow()
                                && i <= r.getBottomRight().getRow()
                                && j == r.getTopLeft().getColumn()) {
                            str = sheet.getCell(r.getTopLeft().getColumn(),
                                    r.getTopLeft().getRow()).getContents();
                        }
                    }
                    System.out.println("第"+i+"行:"+"第"+j+"列:"+"值"+str);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stream.close();
        }
    }

    public static void main(String[] args) throws Exception {
        ImportJxlExcel importExcel = new ImportJxlExcel();
        importExcel.importExcel();
    }
}
