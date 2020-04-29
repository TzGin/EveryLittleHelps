package priv.TzGin.liskovsubstitution.methodreturn;

import java.util.HashMap;

public class Child extends Base{

    /**
     * 重写继承方法时返回值类型范围只能小于或等于父类返回值类型
     * 这里可以是Map，HashMap，不能是Object
     * @return
     */
    @Override
    public HashMap method() {
        HashMap hashMap = new HashMap();
        System.out.println("执行子类的method");
        hashMap.put("msg", "子类method");
        return hashMap;
    }
}
