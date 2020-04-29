package priv.TzGin.compositereuse;

public class OracleConnection extends DBConnection{
    @Override
    public String getConnection() {
        return "获取Oracle数据库连接";
    }
}
