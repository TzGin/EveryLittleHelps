package priv.TzGin.prototype.shallowclone;

import lombok.Data;

import java.util.List;

/**
 * 浅克隆
 * 基本类型能复制
 * 引用类型只复制了引用对应的地址
 * 一旦引用发生改变，所有浅克隆后的引用都会发生改变
 */
@Data
public class ConcretePrototype implements Cloneable {

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
}
