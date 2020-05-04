package priv.TzGin.singleton.serializable;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    /**
     * 序列化过程
     * 把内存中对象的状态转换为字节码的形式
     * 把字节码通过IO输出流，写到磁盘上
     * 永久保存下来，持久化
     *
     * 反序列化过程
     * 将持久化的字节码内容，通过IO输入流读到内存中来
     * 转化为一个Java对象
     */

    public final static SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton(){}

    public static SerializableSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
