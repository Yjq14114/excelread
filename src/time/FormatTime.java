package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by 佳琦 on 2016/3/25.
 */
public class FormatTime {
    public String format(){
        SimpleDateFormat format = new SimpleDateFormat("");
        try {
            format.parse("YYY");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        Date rightNow = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat format3 = new SimpleDateFormat("h:mm a");
        DateFormat format4 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        DateFormat format5 = new SimpleDateFormat("EEE, MMM, dd, ''yyyy");
        DateFormat format6 = new SimpleDateFormat("yyyy.MM.dd kk:mm 'o''clock' a, zzzz");
        DateFormat format7 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        DateFormat format8 = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss z", Locale.US);
        format8.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));

        System.out.println("format1 = " + format1.format(rightNow));
        System.out.println("format2 = " + format2.format(rightNow));
        System.out.println("format3 = " + format3.format(rightNow));
        System.out.println("format4 = " + format4.format(rightNow));
        System.out.println("format5 = " + format5.format(rightNow));
        System.out.println("format6 = " + format6.format(rightNow));
        System.out.println("format7 = " + format7.format(rightNow));
        System.out.println("format8 = " + format8.format(rightNow));
    }
}
