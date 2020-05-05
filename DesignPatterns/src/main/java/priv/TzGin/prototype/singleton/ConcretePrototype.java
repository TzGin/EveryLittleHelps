package priv.TzGin.prototype.singleton;

import lombok.Data;

import java.util.List;

/**
 * 单例模式与原型模式冲突
 * 实例了单例就不实现原型
 * 实现了原型就破坏了单例
 */
@Data
public class ConcretePrototype implements Cloneable{

    private int age;
    private String name;
    private List<String> hobbies;

    private static  ConcretePrototype instance = new ConcretePrototype();

    private ConcretePrototype(){}

    public static ConcretePrototype getInstance(){
        return instance;
    }

    @Override
    public ConcretePrototype clone() {
        return instance;
    }
}
