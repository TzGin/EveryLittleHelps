package priv.TzGin.proxy.dynamicproxy.jdkproxy;

import priv.TzGin.proxy.IPerson;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Test {

    public static void main(String[] args) {
        JdkProxy meipo = new JdkProxy();
        IPerson zhangsan = meipo.getInstance(new ZhangSan());
        zhangsan.findLove();

        IPerson lisi = meipo.getInstance(new LiSi());
        lisi.findLove();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        try {
            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
