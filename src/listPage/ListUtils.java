package listPage;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 佳琦 on 2016/6/25.
 */
public class ListUtils<T> {
    public void listDetail(List<T> list) throws Exception {
        for (int i=0;i<list.size();i++){
            Object obj = list.get(i);
            Map<String, Object> map = new HashMap<String, Object>();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property:propertyDescriptors){
                String key = property.getName();
                if (key.compareToIgnoreCase("class")==0){
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter!=null?getter.invoke(obj):null;
                map.put(key,value);
            }
            System.out.println(map);
        }

    }

    public static void main(String[] args) throws Exception{
        TestEnity enity = new TestEnity();
        enity.setName("mic");
        enity.setAge(23);
        enity.setMobile(1234l);
        enity.setPassword("123455");
        enity.setSex("man");
        enity.setAddress("china");
        List<TestEnity> list = new ArrayList<TestEnity>();
        list.add(enity);
        ListUtils listUtils = new ListUtils();
        listUtils.listDetail(list);
    }
}
class TestEnity implements Serializable{
    private String name;
    private String password;
    private String sex;
    private int age;
    private Long mobile;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
