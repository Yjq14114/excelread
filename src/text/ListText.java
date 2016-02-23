package text;

import net.sf.json.JSONObject;
import objclass.EmployeeEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListText {
    public void jsonObject() throws Exception{
        String json = "[{CITY_NAME=版纳}, {CITY_NAME=文山}, {CITY_NAME=迪庆}, {CITY_NAME=玉溪}, {CITY_NAME=德宏}, {CITY_NAME=临沧}, {CITY_NAME=普洱}, {CITY_NAME=楚雄}, {CITY_NAME=昭通}, {CITY_NAME=保山}, {CITY_NAME=昆明}, {CITY_NAME=曲靖}, {CITY_NAME=红河}, {CITY_NAME=怒江}, {CITY_NAME=大理}, {CITY_NAME=丽江}]";
        JSONObject jsonObject = JSONObject.fromObject(json);
        

    }
    public static void main(String[] args) throws Exception{
        ListText list = new ListText();
        list.jsonObject();
    }
}
