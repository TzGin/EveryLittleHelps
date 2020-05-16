package priv.TzGin.adapter.demo.passport;

public class PassportService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, username, password);
    }

    /**
     * 登陆方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password) {
        return null;
    }
}
