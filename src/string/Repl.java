package string;

/**
 * Created by 佳琦 on 2016/3/30.
 */
public class Repl {
    public static void main(String[] args) {
        String str = "[{\"attach\":\"\",\"certificatelevel\":\"初级\",\"certificatetype\":\"06\",\"certificatetypeid\":\"移动认证资质\",\"eid\":4163,\"ertificatebegindate\":\"2013-12-31\",\"ertificatedep\":\"中国移动云南公司\",\"ertificateenddate\":\"2016-12-31\",\"ertificatenumber\":\"YN201300110990\",\"id\":11656,\"memo\":\"有效\"},{\"attach\":\"\",\"certificatelevel\":\"ceshi\",\"certificatetype\":\"01\",\"certificatetypeid\":\"电工证\",\"eid\":4163,\"ertificatebegindate\":\"2016-03-08\",\"ertificatedep\":\"12\",\"ertificateenddate\":\"2016-03-23\",\"ertificatenumber\":\"123\",\"id\":20186,\"memo\":\"123343434\\r\\n\"}]\n";
        str.contains("\n");
        String rep = str.replace("\\\\r","").replace("\\n","").replace("\\\\n","").replace("\\r","").replaceAll("[\\n]","");
        System.out.println(rep);
    }
}
