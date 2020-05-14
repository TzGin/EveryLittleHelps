package priv.TzGin.bridge.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DriverManager {

    public static void main(String[] args) {
        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接Connection
            Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            //3. 得到执行sql语句的对象Statement
            Statement stmt = conn.createStatement();
            //4. 执行sql语句并返回结果
            ResultSet rs = stmt.executeQuery("select * from table");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
