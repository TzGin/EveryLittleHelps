package priv.TzGin.prototype.deep;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAge(18);
        concretePrototype.setName("TzGin");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("code");
        hobbies.add("robot");
        concretePrototype.setHobbies(hobbies);

        ConcretePrototype clone = concretePrototype.deepCloneHobbies();
        clone.getHobbies().add("reading");

        System.out.println("原型对象：" + concretePrototype);
        System.out.println("克隆对象：" + clone);
        System.out.println(concretePrototype == clone);

        System.out.println("原型对象的爱好：" + concretePrototype.getHobbies());
        System.out.println("克隆对象的爱好：" + clone.getHobbies());
        System.out.println(concretePrototype.getHobbies() == clone.getHobbies());
    }
}
