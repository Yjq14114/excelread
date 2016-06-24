package time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 佳琦 on 2016/6/23.
 */
public class WeekUtils {
    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, 2010); // 2010年
//        c.set(Calendar.MONTH, 5); // 6 月
//        System.out.println("------------" + c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月的天数和周数-------------");
//        System.out.println("天数：" + c.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println("周数：" + c.getActualMaximum(Calendar.WEEK_OF_MONTH));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse("2015-6-01");
            Date end = sdf.parse("2015-6-23");
            int day = dayForWeek(end);
            System.out.println(day);
            System.out.println(sdf.format(sdf.parse("2016-6-23").getTime()-(24 * 60 * 60 * 1000*day)));
            System.out.println(sdf.parse("2016-6-23").getTime());
//            Date start = sdf.parse("2015-4");
//            Date end = sdf.parse("2015-12");
            List<Date> lists = weekSplit(start, end);
            if (!lists.isEmpty()) {
                for (Date date : lists) {
                    System.out.println(sdf.format(date));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Date> weekSplit(Date startDate,Date endDate) throws Exception{
        if (!startDate.before(endDate))
            throw new Exception("开始时间应该在结束时间之后");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        int day = dayForWeek(endDate);
        long time = endDate.getTime()-(24 * 60 * 60 * 1000*(day-1));
        endDate = sdf.parse(sdf.format(time));
        List<Date> dateList = new ArrayList<Date>();
        Long spi = endDate.getTime() - startDate.getTime();
        Long step = spi / (24 * 60 * 60 * 1000*7);
        Calendar calendar = Calendar.getInstance();
        dateList.add(endDate);
        for(int i=1;i<=step;i++){
            calendar.setTime(new Date(dateList.get(i-1).getTime()));
            calendar.add(Calendar.WEEK_OF_MONTH,-1);
            dateList.add(calendar.getTime());
        }
        return dateList;
    }
    public static int dayForWeek(Date pTime) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) +1;
        }
        return dayForWeek;
    }
}
