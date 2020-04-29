package priv.TzGin.compositereuse;

public class MySQLConnection extends DBConnection{
    @Override
    public String getConnection() {
        return "获取MySQL数据库连接";
    }
}
