package excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportExcel {
    public void text(){
        ExcelIO excelIO = new ExcelIO();
        try {
            InputStream is = new FileInputStream("D:\\年度考核需求相关文件\\年度考核模板\\年度考核基站及配套模板.xls");
            POIFSFileSystem poifs = new POIFSFileSystem(is);
            HSSFWorkbook workbook = new HSSFWorkbook(poifs);
            int numofsheet = workbook.getNumberOfSheets();
            HSSFSheet sheet = null;
            Long start = System.currentTimeMillis();
            StringBuffer sb1 = null;
            StringBuffer sb2 = null;
            StringBuffer sb3 = null;
            StringBuffer sb4 = null;

            for(int i=0;i<numofsheet;i++){
                sheet = workbook.getSheetAt(i);
                if(sheet==null){
                    continue;
                }
            int maxrow = sheet.getLastRowNum();
            int begin = 2;
            int end = maxrow-10;
            List<Map<String,Object>> list = excelIO.read(sheet,begin,end);
            Map<String,Object> map = new HashMap<String, Object>();
            for(Map<String,Object> tmp:list){
                //插入主项目，基分
                sb1 = new StringBuffer( "INSERT INTO KH_YEAR_ITEM("
                        +"	ITEMID,"
                        +"	ITEMNAME,"
                        +"	LEVELID,"
                        +"	SPECIALID,"
                        +"	CONTENTID,"
                        +"	RATIO,"
                        +"	ORDERS,"
                        +"	PERIODISM,"
                        +"	USE,"
                        +"	REMARK,"
                        +"	ROWID"
                        +")"
                        +"VALUES(");
                //插入次项目
                sb2 = new StringBuffer("INSERT INTO KH_YEAR_LITTLEITEM ("
                        +"	LITTLEITEMID,"
                        +"	ITEMID,"
                        +"	LITTLEITEMNAME,"
                        +"	ORDERS,"
                        +"	ROWID"
                        +")"
                        +"VALUES"
                        +"	(");
                //插入要求，评分标准
                sb3 = new StringBuffer( "INSERT INTO KH_YEAR_GUIDELINE ("
                        +"	LITTLEITEMID,"
                        +"	REQUIRED,"
                        +"	STANDARD,"
                        +"	ADDORREDUCE,"
                        +"	RATIO,"
                        +"	BASEVALUE,"
                        +"	MAXVALUE,"
                        +"	COMPUTE_PATTERN,"
                        +"	FORMULA,"
                        +"	BASE_SCORE_VALUE,"
                        +"	MAX_SCORE_VALUE,"
                        +"	ORDERS,"
                        +"	GUIDELINEID,"
                        + "	PERIODISM,"
                        + "	GROUPS,"
                        + "	GROUPSPONT,"
                        + "	RULESS,"
                        + "	REMARK,"
                        +"	ROWID"
                        +")"
                        +"VALUES"
                        +"	(");
                //插入得分，评分说明
                sb4 = new StringBuffer("INSERT INTO KH_YEAR_SCOR ("
                        +"	ID,"
                        +"	TASK_ID,"
                        +"	LITTLEITEMID,"
                        +"	GUIDELINEID,"
                        +"	PERIODISM,"
                        +"	USER_ID,"
                        +"	USER_NAME,"
                        +"	SPECIALID,"
                        +"	BASE_SCORE,"
                        +"	STATES,"
                        +"	SCORDETAIL,"
                        +"	SCORE,"
                        +"	COUNTY_USER_ID,"
                        +"	COUNTY_USER_NAME,"
                        +"	COUNTY_SCORE,"
                        +"	COUNTY_SCORDETAIL,"
                        +"	SCORE_AFFIX,"
                        +"	COUNTY_SCORE_AFFIX,"
                        +"	ROWID"
                        +")"
                        +"VALUES"
                        +"	(");
                    String header = tmp.get("分类").toString();
                    if(!header.equals("")){
                        map.put("key",header);
                    }else{
                        String value = map.get("key").toString();
                        tmp.put("分类",value);
                    }
                String based = tmp.get("分值").toString();

                if(!based.equals("")){
                    map.put("score",based);
                }else{
                    String value = map.get("score").toString();
                    tmp.put("分值",value);
                }
                sb1.append("KH_YEAR_ITEM_seq.nextval,'"+tmp.get("分类").toString()+"',null,'001','001','"+tmp.get("分值").toString()+"',null,00"+(i+1)+",'0',null,null)");
                sb2.append("");
                System.out.println(tmp);

            }
            }
            Long endtime = System.currentTimeMillis();
            System.out.println("全部耗时：" + (endtime - start) / 1000f + "秒！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ImportExcel im = new ImportExcel();
        im.text();
    }
}
