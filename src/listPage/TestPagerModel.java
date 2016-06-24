package listPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳琦 on 2016/6/22.
 */
public class TestPagerModel {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("h");
        list.add("i");

        list.add("j");
        list.add("k");
        list.add("l");
        list.add("m");
        PageModel pm = new PageModel(list, 10);
        List sublist = pm.splitList(list, 2,3);

//        List sublist = pm.getObjects(3);
        for(int i = 0; i < sublist.size(); i++) {
            System.out.println(sublist.get(i));
        }
//        System.out.println(sublist.get(0));
    }
}
