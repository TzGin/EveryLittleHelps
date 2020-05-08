package priv.TzGin.flyweight.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {

    private final Vector<Connection> pool;
    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String username = "root";
    private final String password = "root";
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final int poolSize = 100;

    public ConnectionPool() {
        pool = new Vector<Connection>(poolSize);

        try {
            Class.forName(driverClassName);
            for (int i = 0; i < poolSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }
        return null;
    }

    public synchronized void release(Connection conn) {
        pool.add(conn);
    }
}
