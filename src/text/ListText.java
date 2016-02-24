package text;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import objclass.EmployeeEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListText {
    public void jsonObject() throws Exception{
        String json = "{ \"people\": [ { \"firstName\": \"Brett\", \"lastName\":\"McLaughlin\", \"email\": \"aaaa\" }, { \"firstName\": \"Jason\", \"lastName\":\"Hunter\", \"email\": \"bbbb\"}, { \"firstName\": \"Elliotte\", \"lastName\":\"Harold\", \"email\": \"cccc\" } ]}";
        //        JSONObject jsonObject = JSONObject.fromObject(json);
        JSONArray jsonArray = JSONArray.fromObject(json);
    }
    public static void main(String[] args) throws Exception{
        ListText list = new ListText();
        list.jsonObject();
    }
}
