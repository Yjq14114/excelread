package mysqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 佳琦 on 2016/2/26.
 */
public class Connect {
    public void connect(String account,String password) throws Exception{
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/yjq";
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url,account,password);
            if(!connection.isClosed()){
                System.out.println("Successed connecting to the database");
            }
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM userinfo";
            ResultSet ret = statement.executeQuery(sql);
            while(ret.next()){
                String name = ret.getString("USER_NAME");
                System.out.println(name);
            }
            ret.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Connect connect = new Connect();
        String user = "root";
        String password = "yjq14114";
        connect.connect(user,password);
    }
}
