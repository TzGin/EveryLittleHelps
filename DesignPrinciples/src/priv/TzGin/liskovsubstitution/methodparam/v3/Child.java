package priv.TzGin.liskovsubstitution.methodparam.v3;

import java.util.HashMap;

/**
 * 继承后
 * 重载方法参数范围比父类小
 * 实例化时，子类与父类替换后会影响结果
 * 实例化后，调用对应参数的方法
 */
public class Child extends Base {

    public void method(HashMap map){
        System.out.println("执行子类Map入参方法");
    }
}
