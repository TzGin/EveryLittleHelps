package priv.TzGin.liskovsubstitution.methodparam.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * 继承后
 * 重写方法参数范围一致
 * 重载方法参数范围比父类大
 * 实例化时，子类与父类替换不改变结果
 * 实例化后，调用对应参数的方法
 */
public class Child extends Base{
    @Override
    public void method(HashMap map) {
        System.out.println("执行子类HashMap入参方法");
    }

    public void method(Map map){
        System.out.println("执行子类Map入参方法");
    }
}
