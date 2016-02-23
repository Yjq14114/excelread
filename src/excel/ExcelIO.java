package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;

public class ExcelIO {
    public List<Map<String, Object>> read(HSSFSheet sheet, int begin, int end) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String value = "";
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.CHINA);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        for (int i = begin; i < end; i++) {
            HSSFRow row = sheet.getRow(i);
            int maxcell = row.getLastCellNum();
            Map<String, Object> map = new HashMap<String, Object>();
            for (int j = 0; j < maxcell; j++) {
                HSSFCell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case HSSFCell.CELL_TYPE_STRING:
                        value = cell.getStringCellValue();
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        value = nf.format(cell.getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        value = nf.format(cell.getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_BLANK:
                        value = "";
                        break;
                }
                switch (maxcell){
                    case 5:
                        switch (j){
                            case 0:map.put("分类",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 1:map.put("要求",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 2:map.put("分值",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 3:map.put("评分标准",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 4:map.put("扣分",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                        };
                        break;
                    case 7:
                        switch (j){
                            case 0:map.put("分类",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 1:map.put("项目",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 2:map.put("要求",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 3:map.put("分值",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 4:map.put("评分标准",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 5:map.put("扣分说明",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 6:map.put("扣分",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                        };
                        break;
                    case 10:
                        switch (j){
                            case 0:map.put("分类",value.toString().trim().replaceAll ( "\r", "" ).replace("\n",""));break;
                            case 1:map.put("项目",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 2:map.put("要求",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 3:map.put("分值",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 4:map.put("折算得分",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 5:map.put("评分标准",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 6:map.put("扣分说明",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 7:map.put("扣分",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 8:map.put("折算后的得分",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                            case 9:map.put("备注",value.toString().trim().replaceAll("\r", "").replace("\n", ""));break;
                        }
                }
            }
            list.add(map);
        }
            return list;
        }
}
