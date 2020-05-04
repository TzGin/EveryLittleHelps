package priv.TzGin.singleton.register;

/**
 * 缺点：可能会造成内存浪费，不适合大批量使用
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
