package priv.TzGin.prototype.deep;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 深克隆
 * 1. 通过序列化实现深克隆
 *      缺点：占用IO，性能不好
 * 2. 转JSON
 */
@Data
public class ConcretePrototype implements Cloneable, Serializable{

    private int age;
    private String name;
    private List<String> hobbies;

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过硬编码创建新的引用对象后返回（如：ArrayList中的Clone方法）
     * 仍属于浅克隆
     * 但是克服了浅克隆的缺点
     * @return
     */
    public ConcretePrototype deepCloneHobbies(){
        try {
            ConcretePrototype result = (ConcretePrototype) super.clone();
            result.hobbies = (List<String>) ((ArrayList)result.hobbies).clone();
            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcretePrototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            ois.close();
            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
