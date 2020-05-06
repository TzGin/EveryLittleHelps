package priv.TzGin.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class Test {

    public static void main(String[] args) {
//        System.setProperties(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\Developer\IdeaProjects\EveryLittleHelps\DesignPattern\");
        ZhangSan zhangSan = (ZhangSan) new CglibProxy().getInstance(ZhangSan.class);
        zhangSan.findLove();
    }
}
